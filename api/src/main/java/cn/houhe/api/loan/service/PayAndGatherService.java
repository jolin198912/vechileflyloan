package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.common.job.CronUtil;
import cn.houhe.api.common.job.QuartzManager;
import cn.houhe.api.common.job.ScheduleJob;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.mapper.*;
import cn.houhe.api.loan.service.pay.PayService;
import cn.houhe.api.loan.service.pay.bean.PayBean;
import cn.houhe.api.loan.web.bo.MsgBodyDto;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import cn.houhe.api.log.service.MessageSmsService;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.service.MemberService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by victorrrr on 2017/5/6.
 */
@Service("payAndGatherService")
public class PayAndGatherService {

    private static Logger logger = Logger.getLogger(PayService.class.getName());

    @Resource
    private LoanPayMapper loanPayMapper;
    @Resource
    private DebitRcdMapper debitRcdMapper;
    @Resource
    private RepaymentsPlanMapper repaymentsPlanMapper;
    @Resource
    private ScheduleJobService scheduleJobService;
    @Resource
    private PayService payService;
    @Resource
    private LoanRecordMapper loanRecordMapper;
    @Resource
    private CreditinfoMapper creditinfoMapper;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private MessageSmsService messageSmsService;
    @Resource
    private RepaymentsPlanExtMapper repaymentsPlanExtMapper;
    @Autowired
    private MemberService memberService;

    /*
    * 自动打款，服务入口方法
    * */
    public void autoPay()
    {
        Criteria<LoanPay> criteria = Criteria.create(LoanPay.class)
                .add(ExpressionFactory.in("status",0,2));
        List<LoanPay> list = loanPayMapper.selectByCriteria(criteria);
        for (int i = 0; i <= list.size() - 1; i++) {
            LoanPay loanPay = list.get(i);
            try {
                payALoan(loanPay);
            }catch (Exception ex)
            {
                logger.error("autoPay:id"+loanPay.getLpId(),ex);
            }
        }
    }
    /*
    * 自动收款服务入口方法
    * */
    public  void autoGather()
    {
        Criteria<DebitRcd> criteria = Criteria.create(DebitRcd.class)
                .add(ExpressionFactory.in("status",0,2));
        List<DebitRcd> list = debitRcdMapper.selectByCriteria(criteria);
        for (int i = 0; i <= list.size() - 1; i++) {
            DebitRcd debitRcd = list.get(i);
            try {
                gatherADebit(debitRcd);
            }catch (Exception ex)
            {
                logger.error("autoGather:id"+debitRcd.getDrId(),ex);
            }

        }
    }

    /**
     * 打款一条贷款记录
     * @param loanPay
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void payALoan(LoanPay loanPay) throws Exception {
        Integer memberId = loanPay.getMemberId();
        List<Creditinfo> creditinfos = creditinfoMapper.selectByCriteria(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", memberId)));
        Creditinfo creditinfo = creditinfos.get(0);

        LoanRecord record = new LoanRecord();
        record.setLoanId(loanPay.getLoanRecordId());
        if (loanPay != null) {
            if (loanPay.getStatus() == 0){ // 待打款
                MsgBodyDto msg = new MsgBodyDto();
                msg.setUserId(loanPay.getMemberId());
                msg.setAccNo(loanPay.getReceiveBankCardno());
                msg.setAccName(loanPay.getUsername());
                msg.setMobileNo(loanPay.getUserMobile());
                msg.setAmount(loanPay.getAmount().doubleValue());
                msg.setBankName(loanPay.getReceiveBank());
                msg.setObjectId(loanPay.getNumber());
                PayBean bean = payService.pay(msg);
                loanPay.setFlownumber(bean.getBatchNo());
            }
            PayBean result = payService.payQuery(loanPay.getFlownumber(), loanPay.getNumber());
            if ("2".equals(result.getCode())) {//2打款中·
                loanPay.setStatus((byte)2);
                record.setPayStatus((byte)2);
                record.setPayResult(result.getMsg());
            } else if ("1".equals(result.getCode())) {//1打款成功
                loanPay.setStatus((byte)1);
                record.setPayStatus((byte)1);
                loanPay.setPaytime(new Date());
                loanPay.setPayPlatform("易联收付");
                record.setLendingTime(new Date());
                record.setPayResult(result.getMsg());
                //贷款成功后，更新贷款次数
                Byte loanApplyTimes = creditinfo.getLoanApplyTimes();
                loanApplyTimes++;
                creditinfo.setLoanApplyTimes(loanApplyTimes);
                ///打款成功推送、短信
                try {
                    String title="打款";
                    String summary="打款成功";
                    String body="恭喜您，您的贷款已经打到你申请的银行卡中，请注意查收！";
                    byte msgtype= (byte) PushMsgEnum.LoanPayOk.getIndex();
                    Map<String,String> sendres= AliTools.pushMsg(memberId + "_" + Configs.pushEv, msgtype, title, summary , body);
                    Message m = new Message();
                    m.setMemberId(memberId);
                    m.setMsgType((byte)1);
                    m.setMsgContentType(msgtype);
                    m.setTitle(title);
                    m.setIsSend((byte)1);
                    m.setContent(body);
                    m.setCreatedon(new Date());
                    m.setRemark(sendres.get("responseId"));
                    messageMapper.insert(m);

                    //发送短信
                    SimpleDateFormat sfd=new SimpleDateFormat("yyyy-MM-dd");
                    messageSmsService.SendSms("您于"+sfd.format( loanPay.getCreatedon())+"日申请的"+loanPay.getAmount()+"元信用借款已成功打款到建设银行("+loanPay.getReceiveBank()+")，请查收。",loanPay.getUserMobile(),memberId,0,msgtype);

                }catch (Exception ex)
                {
                }
            } else if ("3".equals(result.getCode())) { // 3打款失败
                loanPay.setStatus((byte)3);
                record.setPayStatus((byte)3);
                record.setPayResult(result.getMsg());

                ///打款失败推送
                try {
                    String title="打款";
                    String summary="打款失败";
                    String body="对不起，您申请的贷款打款失败，请检查银行卡等账户信息，联系客服进行处理！";
                    byte msgtype= (byte) PushMsgEnum.LoanPayNo.getIndex();
                    Map<String,String> sendres= AliTools.pushMsg(memberId + "_" + Configs.pushEv, msgtype, title, summary , body);
                    Message m = new Message();
                    m.setMemberId(memberId);
                    m.setMsgType((byte)1);
                    m.setMsgContentType(msgtype);
                    m.setTitle(title);
                    m.setIsSend((byte)1);
                    m.setContent(body);
                    m.setCreatedon(new Date());
                    m.setRemark(sendres.get("responseId"));
                    messageMapper.insert(m);
                }catch (Exception ex)
                {
                }
            }
        }
        loanPayMapper.updateByPrimaryKeySelective(loanPay);
        loanRecordMapper.updateByPrimaryKeySelective(record);
        creditinfoMapper.updateByPrimaryKeySelective(creditinfo);
    }

    /**
     * 收款一条收款记录
     * @param debitRcd
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void gatherADebit(DebitRcd debitRcd) throws Exception {


        Integer loanRecordId = debitRcd.getLoanRecordId();
        List<LoanRecord> loanRecords = loanRecordMapper.selectByCriteria(Criteria.create(LoanRecord.class)
                .add(ExpressionFactory.eq("loanId", loanRecordId)));
        LoanRecord loanRecord = loanRecords.get(0);

        List<Creditinfo> creditinfos = creditinfoMapper.selectByCriteria(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", debitRcd.getMemberId())));
        Creditinfo creditinfo = creditinfos.get(0);

        List<RepaymentsPlan> repaymentsPlans = repaymentsPlanMapper.selectByCriteria(Criteria.create(RepaymentsPlan.class)
                .add(ExpressionFactory.eq("loanRecordId", loanRecordId)));
        RepaymentsPlan repaymentsPlan = repaymentsPlans.get(0);

        Member m= memberService.findByPrimaryKey(debitRcd.getMemberId());
        if(m==null) return;
        if (debitRcd.getStatus() == 0) {
            MsgBodyDto msg = new MsgBodyDto();
            msg.setUserId(debitRcd.getMemberId());
            msg.setAccNo(debitRcd.getBankNo());
            msg.setAccName(debitRcd.getBankUserName());
            msg.setAmount(debitRcd.getRepayAmount().doubleValue());
            msg.setBankName(debitRcd.getBankName());
            msg.setObjectId(debitRcd.getNumber());
            msg.setMobileNo(debitRcd.getUserMobile());
            msg.setCardNo(m.getIdcardno());


            PayBean bean = payService.gather(msg);
            debitRcd.setFlownumber(bean.getBatchNo());
        }
        PayBean result = payService.gatherQuery(debitRcd.getFlownumber(), debitRcd.getNumber());
        RepaymentsPlan plan = new RepaymentsPlan();
        if (debitRcd.getRepayType() == 1) {//提前还款
            String[] ids = debitRcd.getRepaymentsPlanIds().split(",");
            for (String id:ids) {
                int idnum=0;
                try {
                    if(id!=null) {
                        idnum = Integer.parseInt(id);
                    }
                }catch (Exception ex) {
                    throw new ServiceOperationException("提前还款期数参数错误");
                }
                if(idnum==0) continue;
                plan.setRptId(idnum);
                if ("2".equals(result.getCode())) { //收款中
                    debitRcd.setStatus((byte)2);
                    plan.setGatherStatus((byte)2);
                    plan.setGatherResult(result.getMsg());
                } else if ("1".equals(result.getCode())) { //收款成功
                    debitRcd.setStatus((byte)1);
                    debitRcd.setPayTime(new Date());
                    debitRcd.setAmount(debitRcd.getRepayAmount());
                    debitRcd.setPayPlatform("易联收付");
                    loanRecord.setRepayState((byte)2);
                    plan.setStatus((byte)4);
                    plan.setGatherStatus((byte)1);
                    plan.setGatherResult(result.getMsg());
                    plan.setRealPayDate(new Date());
                    if (loanRecord.getLoanType() == 0) {
                        creditinfo.setPdlLoanLimitUsed(creditinfo.getPdlLoanLimitUsed() - repaymentsPlan.getPrincipal().intValue());
                        creditinfo.setPdlLoanLimitLeft(creditinfo.getPdlLoanLimitLeft() + repaymentsPlan.getPrincipal().intValue());
                    } else {
                        creditinfo.setLoanLimitUsed(creditinfo.getLoanLimitUsed() - repaymentsPlan.getPrincipal().intValue());
                        creditinfo.setLoanLimitLeft(creditinfo.getLoanLimitLeft() + repaymentsPlan.getPrincipal().intValue());
                    }
                    creditinfoMapper.updateByPrimaryKeySelective(creditinfo);
                } else if ("3".equals(result.getCode())) { //收款失败
                    debitRcd.setStatus((byte)3);
                    plan.setGatherStatus((byte)3);
                    plan.setGatherResult(result.getMsg());
                }
                repaymentsPlanMapper.updateByPrimaryKeySelective(plan);
            }
            //短信发送
            if ("1".equals(result.getCode())) {
                //成功
                try {
                    //您已成功还款${amount}元
                    messageSmsService.SendSms("您申请的提前还款已经成功扣款，还款金额为" + debitRcd.getRepayAmount() + "元.", debitRcd.getUserMobile(), debitRcd.getMemberId(), 0, PushMsgEnum.RePayOk.getIndex());
                } catch (Exception ex) {
                }
            }else  if("3".equals(result.getCode()))
            {
                try {
                    //您已成功还款${amount}元
                    messageSmsService.SendSms("您的还款银行账户余额不足，"+debitRcd.getRepayAmount() +"元的应还款扣款失败。", debitRcd.getUserMobile(), debitRcd.getMemberId(), 0, PushMsgEnum.RePayNo.getIndex());
                } catch (Exception ex) {
                }
            }
            debitRcdMapper.updateByPrimaryKeySelective(debitRcd);
        } else if (debitRcd.getRepayType() == 0 ||debitRcd.getRepayType() == 2) { //正常还款或逾期还款
            plan.setRptId(debitRcd.getRepaymentsPlanId());
            if ("2".equals(result.getCode())) { //收款中
                debitRcd.setStatus((byte)2);
                plan.setGatherStatus((byte)2);
                plan.setGatherResult(result.getMsg());
            } else if ("1".equals(result.getCode())) { //收款成功
                if (debitRcd.getRepayType() == 0) { //正常还款
                    plan.setStatus((byte)2);
                    try{
                        //您已成功还款${amount}元
                        messageSmsService.SendSms("您已成功还款"+debitRcd.getRepayAmount().doubleValue()+"元",debitRcd.getUserMobile(),debitRcd.getMemberId(),0,PushMsgEnum.RePayOk.getIndex());
                    }catch (Exception ex)
                    {}
                } else { //逾期还款
                    plan.setStatus((byte)3);
                    try{
                        //您已成功还款${amount}元
                        messageSmsService.SendSms("您的还款银行账户余额不足，"+debitRcd.getRepayAmount()+"元的应还款扣款失败。为保持您的良好信用，请给还款账号充钱，并发起还款。",debitRcd.getUserMobile(),debitRcd.getMemberId(),0,PushMsgEnum.RePayNo.getIndex());
                    }catch (Exception ex)
                    {}
                }
                debitRcd.setPayPlatform("易联收付");
                debitRcd.setStatus((byte)1);
                debitRcd.setPayTime(new Date());
                debitRcd.setAmount(debitRcd.getRepayAmount());
                plan.setGatherStatus((byte)1);
                plan.setGatherResult(result.getMsg());
                plan.setRealPayDate(new Date());
                if (loanRecord.getLoanType() == 0) {
                    creditinfo.setPdlLoanLimitUsed(creditinfo.getPdlLoanLimitUsed() - repaymentsPlan.getPrincipal().intValue());
                    creditinfo.setPdlLoanLimitLeft(creditinfo.getPdlLoanLimitLeft() + repaymentsPlan.getPrincipal().intValue());
                } else {
                    creditinfo.setLoanLimitUsed(creditinfo.getLoanLimitUsed() - repaymentsPlan.getPrincipal().intValue());
                    creditinfo.setLoanLimitLeft(creditinfo.getLoanLimitLeft() + repaymentsPlan.getPrincipal().intValue());
                }
                creditinfoMapper.updateByPrimaryKeySelective(creditinfo);
            } else if ("3".equals(result.getCode())) { //收款失败
                debitRcd.setStatus((byte)3);
                plan.setGatherStatus((byte)3);
                plan.setGatherResult(result.getMsg());
                try{
                    //您已成功还款${amount}元
                    messageSmsService.SendSms("您的还款银行账户余额不足，"+debitRcd.getRepayAmount()+"元的应还款扣款失败。为保持您的良好信用，请给还款账号充钱，并发起还款。",debitRcd.getUserMobile(),debitRcd.getMemberId(),0,PushMsgEnum.RePayNo.getIndex());
                }catch (Exception ex)
                {}
            }
            debitRcdMapper.updateByPrimaryKeySelective(debitRcd);
            repaymentsPlanMapper.updateByPrimaryKeySelective(plan);
            if(repaymentsPlanExtMapper.isAllPlanPay(loanRecord.getLoanId()))
            {
                loanRecord.setRepayState((byte)1);
            }
        }
        //货款结清
        if(loanRecord.getRepayState()==1)
        {
            try{
                SimpleDateFormat sfp=new SimpleDateFormat("yyyy-MM-dd");
                //您已成功还款${amount}元
                messageSmsService.SendSms("恭喜，您于"+sfp.format(loanRecord.getStartTime())+"号借款"+loanRecord.getLoanLimit()+"元的款项已全部结清。",debitRcd.getUserMobile(),debitRcd.getMemberId(),0,PushMsgEnum.RePayAll.getIndex());
            }catch (Exception ex)
            {}
        }
        loanRecordMapper.updateByPrimaryKeySelective(loanRecord);
    }

    /**
     * 提交自动打款任务
     * @throws Exception
     */
    public void autoPayJob() throws Exception {
        ScheduleJob job = new ScheduleJob();
        job.setJobName("自动打款");
        job.setJobGroup("自动打款收款");
        job.setClassPath("cn.houhe.api.common.job.DefaultJob.doJob()");
        job.setJobStatus("1");
        job.setCronExpression(CronUtil.laterOneTime(TimeUnit.MINUTES, 2));//4分钟后执行
        job.setDescription("给用户打款");
        JSONObject param = new JSONObject();
        param.put("beanName","PayAndGatherService");
        param.put("methodName","autoPay");
        job.setExecuteParam(param.toJSONString());
        QuartzManager.addJob(job, scheduleJobService);
        cn.houhe.api.loan.entity.ScheduleJob scheduleJob = new cn.houhe.api.loan.entity.ScheduleJob();
        try {
            BeanUtils.copyProperties(scheduleJob,job);
            scheduleJobService.insert(scheduleJob);
        } catch (Exception e) {
            logger.error("提交任务失败",e);
        }
    }

    /**
     * 提交自动收款任务
     * @throws Exception
     */
    public void autoGatherJob() throws Exception {
        ScheduleJob job = new ScheduleJob();
        job.setJobName("自动收款");
        job.setJobGroup("自动打款收款");
        job.setClassPath("cn.houhe.api.common.job.DefaultJob.doJob()");
        job.setJobStatus("1");
        job.setCronExpression(CronUtil.laterOneTime(TimeUnit.MINUTES, 2));//4分钟后执行
        job.setDescription("向用户收款");
        JSONObject param = new JSONObject();
        param.put("beanName","PayAndGatherService");
        param.put("methodName","autoGather");
        job.setExecuteParam(param.toJSONString());
        QuartzManager.addJob(job, scheduleJobService);
        cn.houhe.api.loan.entity.ScheduleJob scheduleJob = new cn.houhe.api.loan.entity.ScheduleJob();
        try {
            BeanUtils.copyProperties(scheduleJob,job);
            scheduleJobService.insert(scheduleJob);
        } catch (Exception e) {
            logger.error("提交任务失败",e);
        }
    }

}
