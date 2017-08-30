package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.ServiceOperationException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.*;
import cn.houhe.api.common.enums.ApplyStateEnum;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.config.entity.LoanPeriod;
import cn.houhe.api.config.entity.Rates;
import cn.houhe.api.config.service.LoanPeriodService;
import cn.houhe.api.config.service.RatesExtService;
import cn.houhe.api.facade.MemberFacade;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.entity.bo.*;
import cn.houhe.api.loan.mapper.LoanRecordExtMapper;
import cn.houhe.api.loan.mapper.LoanRecordMapper;
import cn.houhe.api.loan.web.bo.*;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import cn.houhe.api.member.entity.Member;
import cn.houhe.api.member.service.MemberService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sun.tools.corba.se.idl.PragmaEntry;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.script.ScriptException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * 业务实现层 - 表：loan_record
 *
 * @since 2017-04-12 15:46:36
 */
@Service
public class LoanRecordExtService implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(LoanRecordExtService.class);

    private NumberFormat monthFormat = new DecimalFormat("00");
    @Resource
    private LoanRecordExtMapper loanRecordExtMapper;

    @Resource
    private LoanRecordMapper loanRecordMapper;

    @Resource
    private LoanAuditService loanAuditService;

    @Resource
    private CreditApplyService creditApplyService;

    @Resource
    private CreditinfoService creditinfoService;

    @Autowired
    private MemberFacade memberFacade;
    @Autowired
    private LoanPeriodService loanPeriodService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private RatesExtService ratesExtService;

    @Autowired
    private LoanContractService loanContractService;

    @Autowired
    private LoanBankCardService loanBankCardService;

    @Autowired
    private RepaymentsPlanService repaymentsPlanService;

    @Autowired
    private RepaymentsPlanExtService repaymentsPlanExtService;

    @Autowired
    private DebitRcdService debitRcdService;

    @Autowired
    private LoanBasicFeeService loanBasicFeeService;

    @Autowired
    private LoanPayService loanPayService;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    @Qualifier("formulaYaml")
    private Properties formulaYaml;

    public Pager<LoanList> findPage(LoanListDto loanListDto) {
        int total = loanRecordExtMapper.selectLoanApplyListCount(loanListDto);

        Pager<LoanList> pager = new Pager<>(loanListDto.getPage(), loanListDto.getRows(), total, new ArrayList<LoanList>());
        if (total == 0) {
            return pager;
        }
        List<LoanList> list = loanRecordExtMapper.selectLoanApplyList(loanListDto, pager.getStartRow(), pager.getPageSize());
        pager.setList(list);
        return pager;
    }


    public LoanRecordInfoObject getLoanApplyInfo(Integer lrid) {
        LoanRecordInfoObject infoObject = loanRecordExtMapper.getLoanApplyInfo(lrid);
        if (infoObject == null) {
            throw new ServiceOperationException("未找到申请信息");
        }
        return infoObject;
    }


    /**
     * 贷款审核
     *
     * @param state  审核状态
     * @param lrid   申请id
     * @param pid    审核人id
     * @param remark 备注
     */
    @Transactional(rollbackFor = Exception.class)
    public void approve(Integer lrid, Integer pid, String pname, Integer state, String remark) throws Exception{
        LoanRecord apply = loanRecordMapper.selectByPrimaryKey(lrid);

        if (apply == null) {
            throw new ServiceOperationException("未找到该申请信息");
        }

        if (!Arrays.asList(1, 2).contains(apply.getApplyState().intValue())) {
            throw new ServiceOperationException("不要重复审核");
        }

        List<LoanAudit> audits = loanAuditService.findAll(Criteria.create(LoanAudit.class)
                .add(ExpressionFactory.eq("loanRecordId", apply.getLoanId())));

        LoanAudit audit = new LoanAudit();
        if (CollectionUtils.isEmpty(audits)) {
            audit.setLoanRecordId(apply.getLoanId());
            loanAuditService.insert(audit);
        } else {
            audit = audits.get(0);
        }

        List<Creditinfo> creditinfos = creditinfoService.findAll(Criteria.create(Creditinfo.class)
                .add(ExpressionFactory.eq("memberId", apply.getMemberId())));

        if (CollectionUtils.isEmpty(creditinfos)) {
            logger.error("未找到信用记录");
            throw new ServiceOperationException("操作失败");
        }
        Creditinfo creditinfo = creditinfos.get(0);
        if (state == 0) {//通过
            //creditinfo.setLoanLimitTotal(limit);
            if (apply.getApplyState() == ApplyStateEnum.APPROVING.getIndex()) {//初审
                audit.setFirstAuditPerson(pname);
                audit.setFirstAuditTime(new Date());
                Map user = loanAuditService.getLoanLastPlanAuditPerson();
                audit.setPlanSapId((Integer) user.get("usid"));//分配终审人员
                audit.setPlanSecondAuditPerson((String) user.get("name"));//分配终审人员
                apply.setApplyState((byte) ApplyStateEnum.TRIAL_OK.getIndex());//初审通过

            } else if (apply.getApplyState() == ApplyStateEnum.TRIAL_OK.getIndex()) {//终审
                audit.setSecondAuditPerson(pname);
                audit.setSecondAuditTime(new Date());
                apply.setApplyState((byte) ApplyStateEnum.FINAL_OK.getIndex());//终审通过
                if (apply.getLoanType() == 1) {//现金分期
                    creditinfo.setLoanLimitUsed(creditinfo.getLoanLimitUsed() + creditinfo.getLoanLimitApplying());
                    creditinfo.setLoanLimitApplying(0);//申请中的额度为0
                    apply.setBillDay((short) Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                } else {
                    creditinfo.setPdlLoanLimitUsed(creditinfo.getPdlLoanLimitUsed() + creditinfo.getPdlLoanLimitApplying());
                    creditinfo.setPdlLoanLimitApplying(0);//申请中的额度为0
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_MONTH, apply.getTime());
                    apply.setBillDay((short) Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                }


                List<LoanBankCard> bankCards = loanBankCardService.findAll(Criteria.create(LoanBankCard.class).add(ExpressionFactory.eq("loanRecordId", apply.getLoanId())));
                Assert.notEmpty(bankCards, "银行卡不能为空");
                LoanBankCard card = bankCards.get(0);
                LoanPay pay = new LoanPay();
                pay.setMemberId(apply.getMemberId());
                pay.setLoanRecordId(lrid);
                pay.setAmount(getLoanAmount(apply,apply.getMemberId()));
                pay.setLoanLimit(apply.getLoanLimit());
                pay.setUserMobile(apply.getUserMobile());
                pay.setUsername(apply.getUsername());
                pay.setLoanRecordId(apply.getLoanId());
                pay.setReceiveBankCardno(card.getReceiveBankCardno());
                pay.setReceiveBank(card.getReceiveBank());
                pay.setNumber(apply.getLoanNumber());
                loanPayService.insert(pay);
                try {
                    Member muser= memberService.findByPrimaryKey(apply.getMemberId());
                    Map<String, String> param = new HashMap<>();
                    param.put("realname", apply.getUsername());
                    param.put("idcard", apply.getIdcardno());
                    param.put("mobile", apply.getUserMobile());
                    param.put("address",muser.getDetailaddr());
                    param.put("loan_cycle",apply.getTime()+"");
                    param.put("repay_day",apply.getBillDay() +"");
                    param.put("loan_no", DateFormatUtils.format(new Date(), "yyyy-MM-dd")+" "+apply.getLoanNumber());

                    BigDecimal intrest=apply.getLoanLimit().multiply(apply.getRate());
                    param.put("repay_amount",String.valueOf(apply.getLoanLimit().add(intrest)));
                    param.put("principal",String.valueOf(apply.getLoanLimit().intValue()));
                    param.put("interest",String.valueOf(intrest.intValue()));
                    param.put("fee",String.valueOf(apply.getRate()));
                    param.put("realname_line",apply.getUsername());
                    Calendar calendar = Calendar.getInstance();
                    param.put("year", String.valueOf(calendar.get(Calendar.YEAR)));
                    param.put("day", monthFormat.format(calendar.get(Calendar.DAY_OF_MONTH)));
                    param.put("month", monthFormat.format(calendar.get(Calendar.MONTH) + 1));
                    param.put("realname_end",apply.getUsername());
                    param.put("year_end", String.valueOf(calendar.get(Calendar.YEAR)));
                    param.put("day_end", monthFormat.format(calendar.get(Calendar.DAY_OF_MONTH)));
                    param.put("month_end", monthFormat.format(calendar.get(Calendar.MONTH) + 1));

                    param.put("card_username",apply.getUsername());
                    param.put("card_bk_name",card.getReceiveBank());
                    param.put("card_no",card.getReceiveBankCardno());

                    param.put("amount",String.valueOf(apply.getLoanLimit()));
                    param.put("big_amount",MoneyUtil.digitUppercase(String.valueOf(apply.getLoanLimit().intValue())));
                    param.put("foruse","个人借贷");
                    param.put("year_rate",String.valueOf(apply.getRate()));
                    param.put("loan_day",DateFormatUtils.format(new Date(), "yyyy年MM月dd日"));
                    param.put("loan_end_day",DateFormatUtils.format(apply.getEndTime(), "yyyy年MM月dd日"));
                    param.put("username",muser.getMobileno());
                    loanContractService.generateAndSignLoanApplyContract(apply.getLoanId(), param);
                } catch (Exception e) {
                    logger.error("审核失败", e);
                    throw new ServiceOperationException("审核失败", e);
                }
                 //保存费用
                saveLoanBasicFee(apply);
                ///贷款终审通过，发送推送消息
                try {
                    String title="贷款";
                    String summary="贷款申请";
                    String body="您的借款申请已经审核通过，您的预留账户收到来自车飞贷出借人 潘坚铭 银行打款"+pay.getAmount().intValue()+"元，请注意查收";
                    byte msgtype= (byte) PushMsgEnum.LoanOk.getIndex();
                    Map<String,String> sendres= AliTools.pushMsg(apply.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary , body);
                    Message m = new Message();
                    m.setMemberId(apply.getMemberId());
                    m.setMsgType((byte)1);
                    m.setMsgContentType(msgtype);
                    m.setTitle(title);
                    m.setIsSend((byte)1);
                    m.setContent(body);
                    m.setCreatedon(new Date());
                    m.setRemark(sendres.get("responseId"));
                    messageMapper.insert(m);
                } catch (Exception ex) {
                }
            }
        } else {
            if (apply.getApplyState() == 1) {//初审
                audit.setFirstAuditPerson(pname);
                audit.setFirstAuditTime(new Date());
                apply.setApplyState((byte) 3);//初审不通过

            } else if (apply.getApplyState() == 2) {//终审
                audit.setSecondAuditPerson(pname);
                audit.setSecondAuditTime(new Date());
                apply.setApplyState((byte) 5);//终审不通过
            }
            if (apply.getLoanType() == 1) {//现金分期
                creditinfo.setLoanLimitApplying(0);
                creditinfo.setLoanLimitLeft(creditinfo.getLoanLimitApplying() + creditinfo.getLoanLimitLeft());//恢复额度
            } else {
                creditinfo.setPdlLoanLimitLeft(creditinfo.getLoanLimitApplying() + creditinfo.getLoanLimitLeft());//恢复额度
                creditinfo.setPdlLoanLimitApplying(0);
            }
            audit.setRemark(remark);

            ///贷款审核不通过
            try {
                String title="贷款";
                String summary="贷款申请";
                String body="对不起，您的借款申请未通过审核";
                byte msgtype= (byte) PushMsgEnum.LoanNo.getIndex();
                Map<String,String> sendres= AliTools.pushMsg(apply.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary , body);
                Message m = new Message();
                m.setMemberId(apply.getMemberId());
                m.setMsgType((byte)1);
                m.setMsgContentType(msgtype);
                m.setTitle(title);
                m.setIsSend((byte)1);
                m.setContent(body);
                m.setCreatedon(new Date());
                m.setRemark(sendres.get("responseId"));
                messageMapper.insert(m);

            } catch (Exception ex) {

            }
        }
        creditinfoService.updateSelective(creditinfo);
        loanAuditService.updateSelective(audit);
        loanRecordMapper.updateByPrimaryKeySelective(apply);
    }

    private void saveLoanBasicFee(LoanRecord apply) throws Exception{
        Rates rates = ratesExtService.getRate(apply.getMemberId(), apply.getLoanType());
        LoanBasicFee basicFee = new LoanBasicFee();
        String interestFormula =apply.getLoanType() == 0 ? formulaYaml.getProperty("pdlInterest") : formulaYaml.getProperty("interest");
        Map<String, Number> interestParam = new HashMap<>();
        interestParam.put("time",apply.getTime());
        interestParam.put("limit",apply.getLoanLimit());
        interestParam.put("loanRate",apply.getRate());
        //利息
        basicFee.setInterest(new BigDecimal(FormulaUtil.eval(interestFormula, interestParam ).floatValue()));
        interestParam.remove("loanRate");
        interestParam.put("loanRate",rates.getLoanPayRate());
        //放款手续费
        basicFee.setLoanPayFee(new BigDecimal(FormulaUtil.eval(interestFormula, interestParam ).floatValue()));
        //账户管理费
        interestParam.remove("loanRate");
        interestParam.put("loanRate",rates.getAccountManageRate());
        basicFee.setAccountManageFee(new BigDecimal(FormulaUtil.eval(interestFormula, interestParam ).floatValue()));
        //咨询费
        interestParam.remove("loanRate");
        interestParam.put("loanRate",rates.getConsultationRate());
        basicFee.setConsultationFee(new BigDecimal(FormulaUtil.eval(interestFormula, interestParam ).floatValue()));
        basicFee.setLoanRecordId(apply.getLoanId());
        basicFee.setQuotaManageFee(rates.getQuotaManageRate().multiply(apply.getLoanLimit()));
        basicFee.setWithdrawalsFee(rates.getWithdrawalsRate().multiply(apply.getLoanLimit()));
        loanBasicFeeService.insert(basicFee);
    }

    /**
     * 获取第一期的放款金额
     *
     * @param apply
     * @param memberId
     * @return
     */
    private BigDecimal getLoanAmount(LoanRecord apply, Integer memberId) {
        if (apply.getLoanType() == 0 || apply.getLoanType() == 1) {
            Rates rates = ratesExtService.getRate(memberId, apply.getLoanType());
            Map<String,Number> param = new HashMap<>();
            param.put("limit",apply.getLoanLimit());
            param.put("loanRate",apply.getRate());
            param.put("withdrawRate",rates.getWithdrawalsRate());
            param.put("quotaManageRate",rates.getQuotaManageRate());
            param.put("time",apply.getTime());
            try {
                String formula = apply.getLoanType() == 0 ? formulaYaml.getProperty("pdlLoanPay") : formulaYaml.getProperty("loanPay");
                return new BigDecimal(FormulaUtil.eval(formula,param).doubleValue());
            } catch (ScriptException e) {
               logger.error("放款金额计算错误",e);
            }
            //综合利率，提现费，额度管理费
           // return apply.getLoanLimit().multiply(new BigDecimal(1 - apply.getRate().floatValue() - rates.getWithdrawalsRate().floatValue() - rates.getQuotaManageRate().floatValue()));
        }
        return new BigDecimal(0);
    }


    public Integer getLoanTotalMoney(LoanListDto loanListDto) {

        return loanRecordExtMapper.getLoanTotalMoney(loanListDto);
    }

    /**
     * 贷款申请
     *
     * @param applyDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void loanApply(LoanApplyDto applyDto) throws Exception {
        //applyDto.setFace(AliTools.ossPrefix + applyDto.getFace());

        if(applyDto.getLoanType()==0)
        {
            throw new ServiceOperationException("抱歉，该产品升级中，请选择其他产品");
        }

        CreditInfo creditInfo = creditApplyService.isCredited(applyDto.getMemId());

        if (creditInfo == null) {
            throw new ServiceOperationException("暂无借款额度");
        }

        if ((applyDto.getLoanType() == 1 && creditInfo.getLoanLimitLeft() < applyDto.getAmount()) ||
                applyDto.getLoanType() == 0 && creditInfo.getPdlLoanLimitLeft() < applyDto.getAmount()) {
            throw new ServiceOperationException("可用额度不够");
        }

        Map bank = memberFacade.getBankCard(applyDto.getMemId());
        if (bank == null) {
            throw new ServiceOperationException("卡号不存在");
        }

        int memSituationType = 0;
        List<LoanRecord> applyingLoanRecords = loanRecordMapper.selectByCriteria(Criteria.create(LoanRecord.class)
                .add(ExpressionFactory.eq("memberId", applyDto.getMemId())));
        if (CollectionUtils.isNotEmpty(applyingLoanRecords)) {
            memSituationType = 1;
            for (LoanRecord applyingLoanRecord : applyingLoanRecords) {
                if (applyingLoanRecord.getApplyState() == 1 || applyingLoanRecord.getApplyState() == 2) {
                    throw new ServiceOperationException("你有申请正在审批中");
                }
                if (applyingLoanRecord.getRepayState() == 0 && !Arrays.asList(3, 5, 7).contains(applyingLoanRecord.getApplyState().intValue())) {//未被拒绝，有未还完的就是增贷
                    memSituationType = 2;
                }
            }
        }
        //检查日期
        LoanPeriod loanPeriod = checkLoanDate(applyDto.getLoanType(), applyDto.getTime());
        LoanRecord loanRecord = new LoanRecord();
        loanRecord.setLpId(loanPeriod.getLpId());
        loanRecord.setMemberId(applyDto.getMemId());
        loanRecord.setLoanLimit(new BigDecimal(applyDto.getAmount()));
        loanRecord.setLoanType(applyDto.getLoanType().byteValue());
        loanRecord.setTime(applyDto.getTime().shortValue());
//		loanRecord.setFaceSimilarity(new BigDecimal(applyDto.getConfidence()));
        loanRecord.setMemSituationType((byte) memSituationType);
        CreditApplyFaceDto faceDto = new CreditApplyFaceDto();
        faceDto.setMemId(applyDto.getMemId());
        faceDto.setFace(applyDto.getFace());
        face(faceDto);
        loanRecord.setFaceSimilarity(new BigDecimal(faceDto.getConfidence()));

        Map memInfo = memberFacade.getMemberInfo(applyDto.getMemId());
        loanRecord.setIdcardno((String) memInfo.get("idcardno"));
        loanRecord.setLoanNumber("LR" + FlowNoUtil.next());
        loanRecord.setUsername((String) memInfo.get("realname"));
        loanRecord.setUserMobile((String) memInfo.get("mobileno"));
        loanRecord.setApplyTime(new Date());
        loanRecord.setStartTime(new Date());
        loanRecord.setEndTime(getEndDate(new Date(), loanRecord.getLoanType(), loanRecord.getTime()));
        loanRecord.setRate(ratesExtService.getLoanRate(loanRecord.getMemberId(), loanRecord.getLpId(), loanRecord.getLoanType(), loanRecord.getTime()));
        loanRecord.setLateFeeRate(ratesExtService.getLoanLateRate(loanRecord.getMemberId(), loanRecord.getLpId(), loanRecord.getLoanType(), loanRecord.getTime()));
        loanRecord.setRemindFee(ratesExtService.getLoanRemindFee(loanRecord.getMemberId(), loanRecord.getLpId(), loanRecord.getLoanType(), loanRecord.getTime()));
        loanRecord.setApplyState((byte) ApplyStateEnum.APPROVING.getIndex());
        loanRecord.setPayAmount(loanRecord.getLoanLimit());
        loanRecord.setCurrentPayAmount(loanRecord.getLoanLimit());


        Creditinfo creditinfo = creditinfoService.findByPrimaryKey(creditInfo.getCdId());
        if (loanRecord.getLoanType() == 0) {//pdl
            creditinfo.setPdlLoanLimitApplying(loanRecord.getLoanLimit().intValue());
            creditinfo.setPdlLoanLimitLeft(new BigDecimal(creditinfo.getPdlLoanLimitLeft()).subtract(loanRecord.getLoanLimit()).intValue());
        } else {//现金分期
            creditinfo.setLoanLimitLeft(new BigDecimal(creditInfo.getLoanLimitLeft()).subtract(loanRecord.getLoanLimit()).intValue());
            creditinfo.setLoanLimitApplying(loanRecord.getLoanLimit().intValue());
        }
        loanRecordMapper.insertSelective(loanRecord);
        //generateContract(loanRecord.getLoanId(),applyDto.getMemId());

        LoanBankCard loanBankCard = new LoanBankCard();
        loanBankCard.setLoanRecordId(loanRecord.getLoanId());
        loanBankCard.setReceiveBank((String) bank.get("collectingbank"));
        loanBankCard.setReceiveBankCardno((String) bank.get("bankcardno"));
        loanBankCard.setReceiveName((String) bank.get("cardholder"));
        loanBankCard.setRepayBank(loanBankCard.getReceiveBank());
        loanBankCard.setRepayBankCardno(loanBankCard.getReceiveBankCardno());
        loanBankCard.setRepayName(loanBankCard.getReceiveName());

        List<LoanAudit> audits = loanAuditService.findAll(Criteria.create(LoanAudit.class)
                .add(ExpressionFactory.eq("loanRecordId", loanRecord.getLoanId())));

        LoanAudit audit = new LoanAudit();
        if (CollectionUtils.isEmpty(audits)) {
            audit.setLoanRecordId(loanRecord.getLoanId());
            loanAuditService.insert(audit);
        } else {
            audit = audits.get(0);
        }
        Map user = loanAuditService.getLoanFirstPlanAuditPerson();
        audit.setPlanFapId((Integer) user.get("usid"));//分配初审人员
        audit.setPlanFirstAuditPerson((String) user.get("name"));//分配初审人员
        loanAuditService.updateSelective(audit);
        loanBankCardService.insert(loanBankCard);
        memberFacade.insertLoanApplyFace(faceDto, loanRecord.getLoanId());
        creditinfoService.updateSelective(creditinfo);
    }

    /**
     * 生成借款合同
     *
     * @param loanId
     * @param memId
     */
    private void generateContract(Integer loanId, Integer memId) {
        /*LoanContract regContract = new LoanContract();
        regContract.setContractName("借款借据");
		regContract.setLoanRecordId(loanId);
		regContract.setContractFileUrl("");
		regContract.setContractNumber("LR" + FlowNoUtil.next());
		loanContractService.insertSelective(regContract);

		LoanContract loanContract = new LoanContract();
		loanContract.setContractName("服务合同");
		loanContract.setLoanRecordId(loanId);
		loanContract.setContractFileUrl("");
		loanContract.setContractNumber("LR" + FlowNoUtil.next());
		loanContractService.insertSelective(loanContract);

		LoanContract creditQueryContract = new LoanContract();
		creditQueryContract.setContractName("额度借款合同");
		creditQueryContract.setLoanRecordId(loanId);
		creditQueryContract.setContractFileUrl("");
		creditQueryContract.setContractNumber("LR" + FlowNoUtil.next());
		loanContractService.insertSelective(creditQueryContract);

		LoanContract collectionContract = new LoanContract();
		collectionContract.setContractName("借款合同");
		collectionContract.setLoanRecordId(loanId);
		collectionContract.setContractFileUrl("");
		collectionContract.setContractNumber("LR" + FlowNoUtil.next());
		loanContractService.insertSelective(collectionContract);*/
    }

    /**
     * 获取结束时间
     *
     * @param baseDate 基准时间
     * @param loanType 贷款类型
     * @param time     时长
     * @return
     */
    private Date getEndDate(Date baseDate, Byte loanType, Short time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        if (loanType == 0) {
            calendar.add(Calendar.DATE, time);
        } else {
            calendar.add(Calendar.MONTH, time);
        }
        return calendar.getTime();
    }


    /**
     * 检查贷款日期
     *
     * @param loanType
     * @param time
     * @return
     */
    private LoanPeriod checkLoanDate(Integer loanType, Integer time) {
        List<LoanPeriod> loanPeriods = loanPeriodService.findAll(Criteria.create(LoanPeriod.class)
                .add(ExpressionFactory.eq("type", loanType))
                .add(ExpressionFactory.eq("time", time)));
        if (CollectionUtils.isEmpty(loanPeriods)) {
            logger.error("贷款期限不合法，loan type: " + loanType + " , time : " + time);
            throw new ServiceOperationException("贷款期限不合法");
        }
        return loanPeriods.get(0);
    }

    /**
     * 贷款人脸识别
     *
     * @param data
     */
    public void face(final CreditApplyFaceDto data) throws Exception {
    	logger.info("人脸识别开始，识别id："+data.getFaceId()+";member id"+data.getMemId());
        data.setFace(AliTools.ossPrefix + data.getFace());
        List<CreditApply> creditApplies = creditApplyService.findAll(Criteria.create(CreditApply.class)
                .add(ExpressionFactory.eq("memberId", data.getMemId())));
        if (CollectionUtils.isEmpty(creditApplies)) {
            throw new ServiceOperationException("请先进行信用申请");
        }

        CreditApply apply = creditApplies.get(0);
        if (!MegviiUtil.compareFaceWithOrigin(data.getFace(), apply.getName(), apply.getIdCard(), new MegviiUtil.FaceComparator() {
            @Override
            public void compare(JSONObject result) {
                JSONObject faceId = result.getJSONObject("result_faceid");
                data.setConfidence(faceId.getFloat("confidence") / 100);
                //memberFacade.insertLoanApplyFace(data,null);
                //data.setFaceId();
            }
        })) {
            throw new ServiceOperationException("头像不匹配");
        }
    	logger.info("人脸识别结束,识别id"+data.getFaceId());

    }

    /**
     * 获取借款详情
     *
     * @param loanid
     * @return
     * @throws ServiceException
     */
    public LoanRecordInfoAPP getInfoByid(Integer loanid) throws ServiceException {
        try {
            LoanRecordInfoAPP la = loanRecordExtMapper.getInfoByid(loanid);
            la.setIsAdvancePay(0);
            if ((la.getApplyState() == 4 || la.getApplyState() == 6)
                    && la.getPayStatus() == 1
                    && la.getRepayState() == 0
                    && la.getBill_day() != Calendar.getInstance().get(Calendar.DATE)
                    //&& la.getEndtime().getTime() > new Date().getTime()
                    ) {
                Integer count = repaymentsPlanExtService.getPayingCount(loanid);
                if (count == 0)
                    la.setIsAdvancePay(1);
            }
            return la;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 获取详情
     *
     * @param loanid
     * @return
     * @throws ServiceException
     */
    public LoanRecordInfoAPP getDetailById(Integer loanid) throws ServiceException {
        try {
            return loanRecordExtMapper.getDetailById(loanid);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public HashMap calculateAdvance(int loanId) throws ServiceException {
        try {
            HashMap map = new HashMap();

            LoanRecordInfoAPP loanRecord = loanRecordExtMapper.getDetailById(loanId);

            map.put("bankcardno", loanRecord.getBankcardno());
            map.put("bank", loanRecord.getBank());
            map.put("bankusername", loanRecord.getBankUserName());

            if (loanRecord.getLoanType() == 0)//PDL产品
            {
                BigDecimal fine=loanRecordExtMapper.getFine(loanId);
                BigDecimal total=fine.add(loanRecord.getLoanLimit());
                map.put("total", total);
                map.put("type", loanRecord.getLoanType());
                map.put("lastPrincipal", loanRecord.getLoanLimit());
                map.put("incerst", 0);
                map.put("advancerepayfee", 0);
                map.put("fine", fine);

                return map;
            }
            //现金分期产品
            else {
                map.put("type", loanRecord.getLoanType());
                Criteria<RepaymentsPlan> criteria = Criteria.create(RepaymentsPlan.class);
                criteria.add(ExpressionFactory.eq("loanRecordId", loanId));
                criteria.add(ExpressionFactory.eq("status", 0));
                List<RepaymentsPlan> list = repaymentsPlanService.findAll(criteria);
                //特别说明：
                //当用户给（现金分期的）最后一期提前还款时，不再收取提前还款违约金 和 利息。（因为在放款时，就收取了最后一期的利息）
                if (list.size() == 1 && list.get(0).getPayDate().getTime() == loanRecord.getEndtime().getTime()) {
                    map.put("total", list.get(0).getPrincipal());
                    map.put("lastPrincipal", list.get(0).getPrincipal());
                    map.put("incerst", 0);
                    map.put("advancerepayfee", 0);
                    map.put("fine", 0);

                    return map;
                }

                //如果不是最后一期
                //逾期的费用计算
                RepaymentDtoApp repaymentDtoApp = repaymentsPlanExtService.getOverdueTotal(loanId);
                //逾期罚金
                BigDecimal latefine = new BigDecimal(0);
                if (repaymentDtoApp != null)
                    latefine = repaymentDtoApp.getRealTotalPay().subtract(repaymentDtoApp.getInterest()).subtract(repaymentDtoApp.getPrincipal());

                // 剩余的本金计算(提前还款所以lastPrincipalTotal不可能为空)
                BigDecimal lastPrincipalTotal = repaymentsPlanExtService.getLastPrincipalTotal(loanId);

                //计算使用天数（用当前时间减去（最小还款日减去一个月）的天数再减去1）
                RepaymentDtoApp repaymentDtoApp1 = repaymentsPlanExtService.getLeastPayTime(loanId);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(repaymentDtoApp1.getPayDate());
                calendar.add(Calendar.MONTH, -1);
                Integer totaldays = 0;
                Calendar time = Calendar.getInstance();
                long endtim = time.getTimeInMillis();
                long stime = calendar.getTimeInMillis();
                totaldays = (int) ((endtim - stime) / (1000 * 3600 * 24)) - 1;

                //利息
                BigDecimal incerst = loanRecord.getLoanLimit().multiply(loanRecord.getRate()).multiply(new BigDecimal(totaldays)).divide(new BigDecimal(30), 2, BigDecimal.ROUND_CEILING);

                //提前还款违约金
                BigDecimal advance_repay_fee = loanRecord.getLoanLimit().multiply(loanRecord.getRate()).multiply(new BigDecimal(totaldays)).multiply(new BigDecimal(3)).divide(new BigDecimal(30), 2, BigDecimal.ROUND_CEILING);

                map.put("total", latefine.add(lastPrincipalTotal).add(incerst).add(advance_repay_fee));
                map.put("lastPrincipal", lastPrincipalTotal);
                map.put("incerst", incerst);
                map.put("advancerepayfee", advance_repay_fee);
                map.put("fine", latefine);

                return map;
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * 提前还款操作
     *
     * @param advancePayDto
     * @throws ServiceException
     */
    @Transactional
    public void doAdvance(AdvancePayDto advancePayDto) throws ServiceException {
        try {
            Criteria<RepaymentsPlan> criteria = Criteria.create(RepaymentsPlan.class);
            criteria.add(ExpressionFactory.eq("loanRecordId", advancePayDto.getLoanId()));
            criteria.add(ExpressionFactory.eq("status", 0));
            List<RepaymentsPlan> list = repaymentsPlanService.findAll(criteria);
            String ids = "";
            for (RepaymentsPlan r : list) {
                if (ids.equals(""))
                    ids += r.getRptId();
                else
                    ids += "," + r.getRptId();
            }
            DebitRcd d = new DebitRcd();
            d.setNumber("DB" + FlowNoUtil.next());
            d.setMemberId(advancePayDto.getMemid());
            d.setRepayType((byte) 1);
            d.setLoanRecordId(advancePayDto.getLoanId());
            d.setRepaymentsPlanIds(ids);
            d.setBankNo(advancePayDto.getBankcardno());
            d.setBankName(advancePayDto.getBank());
            d.setBankUserName(advancePayDto.getBankusername());
            d.setUserMobile(advancePayDto.getMobile());
            d.setLateFee(advancePayDto.getFine());
            d.setAdvanceRepayFee(advancePayDto.getAdvancefee());
            d.setStatus((byte) 0);
            d.setRepayAmount(advancePayDto.getTotal());
            d.setInterest(advancePayDto.getInverst());

            debitRcdService.insertSelective(d);
            //更新还款计划状态到还款中
            repaymentsPlanExtService.updateStatus(advancePayDto.getLoanId());
            LoanBasicFee loanBasicFee = new LoanBasicFee();
            //更新贷款的提前还款费用
            loanRecordExtMapper.updateAdvancefee(advancePayDto.getLoanId(), advancePayDto.getAdvancefee());

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    public Map loanSum(StatisticsDto data) {
        return loanRecordExtMapper.loanSum(data.getStart(),data.getEnd());
    }

    public Map compLoanBadSum(StatisticsDto data) {
        return loanRecordExtMapper.compLoanBadSum(data.getStart(),data.getEnd());
    }

    public Map loanBalance(StatisticsDto data) {
        return loanRecordExtMapper.loanBalance(data.getStart(),data.getEnd());
    }

    public Map loanBad(StatisticsDto data) {
        return loanRecordExtMapper.loanBadSum(data.getStart(),data.getEnd());
    }
}