package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.ExcelUtil;
import cn.houhe.api.common.FlowNoUtil;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.loan.entity.*;
import cn.houhe.api.loan.entity.bo.RepaymentDto;
import cn.houhe.api.loan.entity.bo.RepaymentDtoApp;
import cn.houhe.api.loan.mapper.RepaymentsPlanExtMapper;
import cn.houhe.api.loan.mapper.RepaymentsPlanMapper;
import cn.houhe.api.loan.web.bo.*;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.mapper.MessageMapper;
import cn.houhe.api.log.service.MessageSmsService;
import jdk.net.SocketFlow;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.plaf.metal.MetalBorders;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 业务实现层 - 表：repayments_plan
 * @since 2017-03-29 18:30:03
 */
@Service("repaymentsPlanExtService")
public class RepaymentsPlanExtService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(RepaymentsPlanExtService.class);
	@Resource
	private RepaymentsPlanMapper repaymentsPlanMapper;

	@Resource
	private RepaymentsPlanExtMapper repaymentsPlanExtMapper;

	@Autowired
	private LoanRecordService loanRecordService;

	@Autowired
	private CreditinfoService creditinfoService;
	@Autowired
	private DebitRcdService debitRcdService;

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private RepaymentsPlanService repaymentsPlanService;

	@Autowired
	private MessageSmsService messageSmsService;
	@Autowired
	private LoanBankCardService loanBankCardService;


	/**
	 * 生成还款计划
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void generateRepaymentPlan() throws Exception{
		List<LoanRecord> loanRecords = loanRecordService.findAll(Criteria.create(LoanRecord.class)
		.add(ExpressionFactory.eq("payStatus",1)));
		if (CollectionUtils.isNotEmpty(loanRecords)){
			for (LoanRecord loanRecord : loanRecords) {
			    int term = 1;
				int loanId = loanRecord.getLoanId();
				List<RepaymentsPlan> plans = repaymentsPlanMapper.selectByCriteria(Criteria.create(RepaymentsPlan.class)
				.add(ExpressionFactory.eq("loanRecordId",loanId)));
				if (CollectionUtils.isNotEmpty(plans)){
					logger.warn("贷款["+ loanId +"]计划已生成，跳过");
					continue;
				}
				int loanType = loanRecord.getLoanType().intValue();
				logger.debug("开始为贷款id为 "+ loanId + " 的记录生成还款计划");
				if (loanType == 0){//按日
                    RepaymentsPlan plan = new RepaymentsPlan();
                    plan.setLoanRecordId(loanId);
                    plan.setUserMobile(loanRecord.getUserMobile());
                    plan.setUsername(loanRecord.getUsername());
					plan.setMemberId(loanRecord.getMemberId());
                    plan.setRepayNumber("DB" + FlowNoUtil.next());
					int time = loanRecord.getTime();
                    plan.setPrincipal(loanRecord.getLoanLimit());
                    //BigDecimal interest = loanRecord.getRate().multiply(loanRecord.getLoanLimit());
                    plan.setInterest(new BigDecimal(0));
                    plan.setCurrentTerm((short) term);
                    plan.setTotalPay(plan.getPrincipal());
					plan.setRealTotalPay(plan.getTotalPay());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(loanRecord.getLendingTime());
                    calendar.add(Calendar.DAY_OF_MONTH,time);
                    plan.setPayDate(calendar.getTime());
                    plan.setStatus((byte) 0);
                    repaymentsPlanMapper.insertSelective(plan);
				}else if (loanType == 1){
                    int time = loanRecord.getTime();
				    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(loanRecord.getLendingTime());
                    //算每期的金额，先除于time, 向下取整，然后最后一期加上剩下的
                    BigDecimal termLoanLimit = loanRecord.getLoanLimit().divide(new BigDecimal(time), BigDecimal.ROUND_FLOOR);
                    BigDecimal lastTermLoanLimit = loanRecord.getLoanLimit().subtract(termLoanLimit.multiply(new BigDecimal(time))).add( termLoanLimit);
                    int lastTerm = time - 1;
				    for (int i = 0; i< time ; i ++) {
                        RepaymentsPlan plan = new RepaymentsPlan();
                        plan.setLoanRecordId(loanId);
                        plan.setMemberId(loanRecord.getMemberId());
						plan.setRepayNumber("DB" + FlowNoUtil.next());
                        plan.setUserMobile(loanRecord.getUserMobile());
                        plan.setUsername(loanRecord.getUsername());
						BigDecimal interest = loanRecord.getRate().multiply(loanRecord.getLoanLimit());
						plan.setInterest(interest);
                        if ( i == lastTerm){//最后一期
                        	plan.setPrincipal(lastTermLoanLimit);
							interest=new BigDecimal(0);
                        	plan.setInterest(interest);//最有一期利息为0
						}else {
							plan.setPrincipal(termLoanLimit);
						}
                        plan.setCurrentTerm((short) term);
                        plan.setTotalPay(interest.add(plan.getPrincipal()));
                        plan.setRealTotalPay(plan.getTotalPay());
                        calendar.add(Calendar.MONTH, 1);
                        plan.setPayDate(calendar.getTime());
                        plan.setStatus((byte) 0);
                        repaymentsPlanMapper.insertSelective(plan);
                        term++;
                    }
                }
				logger.debug("生成还款计划完成");
			}
		}
	}


	/**
	 * 计算渝期的还款
	 */
	public void computeLateDebit() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dtnow=sdf.format(new Date());
		Date date=new   Date();//取时间
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date);
		calendar1.add(calendar1.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar1.getTime();   //这个时间就是日期往后推一天的结果
		String dttomorrow=sdf.format(date);
		List<RepaymentsPlan> plans = repaymentsPlanMapper.selectByCriteria(Criteria.create(RepaymentsPlan.class)
		.add(ExpressionFactory.eq("status",0))
		.add(ExpressionFactory.sql(" (delay_date<'"+dtnow+"' or delay_date is null) "))
		.add(ExpressionFactory.lessEqual("payDate",dttomorrow)));
		Calendar calendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		for (RepaymentsPlan plan : plans) {
			try {
				updateLatePlan(calendar, endCalendar, plan);
			}catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}

		//将需要收款的，收款计划，插入到收款表中
		debitRcdService.insertDebitRcdDataSer();
	}

	@Transactional(rollbackFor = Exception.class)
	private void updateLatePlan(Calendar calendar, Calendar endCalendar, RepaymentsPlan plan) {
		endCalendar.setTime(plan.getPayDate());
		long time = calendar.getTimeInMillis() - endCalendar.getTimeInMillis();
		long date = (long) Math.ceil(time/(24 * 3600 * 1000d))-1;
		LoanRecord loanRecord = loanRecordService.findByPrimaryKey(plan.getLoanRecordId());

		/*罚息=(贷款金额+本期利息)*罚息/30*逾期天数
		* 修改日期：2017年5月8日16:13:06*/
//		BigDecimal lateFee = loanRecord.getLoanLimit().add(plan.getInterest()).multiply(loanRecord.getLateFeeRate())
//                .multiply(new BigDecimal(date))
//                .divide(new BigDecimal(30), RoundingMode.CEILING);//罚息

        /*逾期罚金*/
		BigDecimal nPow=new BigDecimal(1).add(loanRecord.getLateFeeRate()).pow((int)date);
		BigDecimal lateFee=nPow.multiply(loanRecord.getLoanLimit()).add(loanRecord.getRemindFee().multiply(nPow.subtract(new BigDecimal(1)).divide(loanRecord.getLateFeeRate()))
		).subtract(loanRecord.getLoanLimit());

		plan = repaymentsPlanExtMapper.getPlanLock(plan.getRptId());

		/*2017年5月26日17:22:15 罚金不能超过当期本金 */
		if (lateFee.compareTo(plan.getPrincipal())>0){
			lateFee=plan.getPrincipal();
		}

		plan.setDelayDays((short) date);
		plan.setDelayDate(new Date());
		plan.setLateFee(lateFee);
		plan.setRemindFee(loanRecord.getRemindFee().multiply(new BigDecimal(date)));//催收费=每天催收费*逾期天数
		if ((short) date>60){
			plan.setIsBad((byte)1);
			plan.setBadDay(calendar.getTime());
		}
		plan.setRealTotalPay(plan.getPrincipal().add(plan.getInterest()).add(plan.getLateFee()));
		repaymentsPlanMapper.updateByPrimaryKeySelective(plan);
		Creditinfo creditinfo = creditinfoService.findAll(Criteria.create(Creditinfo.class).add(ExpressionFactory.eq("memberId",loanRecord.getMemberId()))).get(0);
		if(plan.getDelayDays()==1) {
			creditinfo.setDelayDebitTimes((short) (creditinfo.getDelayDebitTimes() + 1));
		}
		creditinfoService.updateSelective(creditinfo);

		 if(plan.getDelayDays()>=1) {
			 ///逾期提醒
			 try {
				 String title = "逾期提醒";
				 String summary = "逾期提醒";
				 String body = "您有借款已经逾期，请及时归还。";
				 byte msgtype = (byte) PushMsgEnum.RePayRemaind.getIndex();
				 Map<String, String> sendres = AliTools.pushMsg(creditinfo.getMemberId() + "_" + Configs.pushEv, msgtype, title, summary, body);
				 Message m = new Message();
				 m.setMemberId(creditinfo.getMemberId());
				 m.setMsgType((byte) 1);
				 m.setMsgContentType(msgtype);
				 m.setIsSend((byte) 1);
				 m.setTitle(title);
				 m.setIsSend((byte) 1);
				 m.setContent(body);
				 m.setCreatedon(new Date());
				 m.setRemark(sendres.get("responseId"));
				 messageMapper.insert(m);

				 //逾期短信提醒
				 //您已成功还款${amount}元
				 messageSmsService.SendSms("您有一笔应还款已逾期" + plan.getDelayDays() + "天，应还金额为${" + plan.getRealTotalPay() + "}元（含逾期金额${" + plan.getPrincipal() + "}元，逾期罚金${" + plan.getLateFee() + "}元），为保持您的良好信用，请快去还款！", plan.getUserMobile(), plan.getMemberId(), 0, PushMsgEnum.RePayNo.getIndex());

			 } catch (Exception ex) {
			 }
		 }
	}

	public List<RepaymentDtoApp> getNotPayList(MemberDto dto) throws Exception {
		try {
			return repaymentsPlanExtMapper.getNotPayList(dto);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 获取还款记录列表（用于还款服务）
	 */
	public List<RepaymentsPlanListDto> findRepaymentsPlanList() throws Exception {
		try {
			return repaymentsPlanExtMapper.getRepaymentsPlanList();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 获取逾期的总和
	 * @param loanId
	 * @return
	 * @throws Exception
	 */
	public RepaymentDtoApp getOverdueTotal(Integer loanId) throws Exception {
		try {
			return repaymentsPlanExtMapper.getOverdueTotal(loanId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 获取未还本金总和(不包含逾期本金)
	 * @param loanId
	 * @return
	 * @throws Exception
	 */
	public BigDecimal getLastPrincipalTotal(Integer loanId) throws Exception {
		try {
			return repaymentsPlanExtMapper.getLastPrincipalTotal(loanId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * <!--将贷款所有未还款的还款计划收款状态更新成还款中-->
	 * @param loanId
	 * @throws Exception
	 */
	public  void  updateStatus(Integer loanId)throws Exception {
		try {
			repaymentsPlanExtMapper.updateStatus(loanId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 获取所有处于结款中的还款计划
	 * @param loanid
	 * @return
	 * @throws Exception
	 */
	public Integer getPayingCount(Integer loanid) throws  Exception{
		try {
			return repaymentsPlanExtMapper.getPayingCount(loanid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 更新某个还款计划状态
	 * @param repayments_plan_id 还款计划id
	 * @return
	 * @throws Exception
	 */
	public int updateRepayStatus(Integer repayments_plan_id,int status) throws  Exception{
		try {
			return repaymentsPlanExtMapper.updateRepayStatus(repayments_plan_id,status);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 逾期还款
	 * @param debitRcd
	 * @throws Exception
	 */
	@Transactional
	public int overduePay(DebitRcd debitRcd) throws  Exception{
		try {
			RepaymentsPlan plan= repaymentsPlanService.findByPrimaryKey(debitRcd.getRepaymentsPlanId());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String nowday=sdf.format(new Date());
			//收款状态必须是0待收款&&逾期利息维护必须到今天
			if(plan.getGatherStatus()==0&&plan.getDelayDate().getTime()==(sdf.parse(nowday)).getTime()) {
				LoanBankCard bk= loanBankCardService.findAll(Criteria.create(LoanBankCard.class).add(ExpressionFactory.eq("loanRecordId",plan.getLoanRecordId()))).get(0);
				debitRcd.setLoanRecordId(plan.getLoanRecordId());
				debitRcd.setMemberId(plan.getMemberId());
				debitRcd.setNumber("DB"+FlowNoUtil.next());
				debitRcd.setRepayType((byte)2);
				debitRcd.setBankNo(bk.getRepayBankCardno());
				debitRcd.setBankName(bk.getRepayBank());
				debitRcd.setBankUserName(bk.getRepayName());
				debitRcd.setUserMobile(plan.getUserMobile());
				debitRcd.setLateFee(plan.getLateFee());
				debitRcd.setAdvanceRepayFee(new BigDecimal(0));
				debitRcd.setPayPlatform("易联收付");
				debitRcd.setInterest(plan.getInterest());
				debitRcd.setAmount(plan.getRealTotalPay());
				debitRcd.setDebiton(new Date());
				debitRcd.setPlanPayTime(plan.getPayDate());
				debitRcd.setCreatedon(new Date());
				debitRcdService.insertSelective(debitRcd);
				repaymentsPlanExtMapper.updateRepayStatus(debitRcd.getRepaymentsPlanId(), 2);
				return 1;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * 获取还款计划中未还款最小还款日
	 *
	 * @param loanid
	 * @return
	 * @throws Exception
	 */
	public RepaymentDtoApp getLeastPayTime(Integer loanid) throws Exception {
		try {
			return repaymentsPlanExtMapper.getLeastPayTime(loanid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 导出excel
	 */
	public void importExcelFile(RepaymentsDto dto, OutputStream io){
		try {
			if(dto.status==0) {//催收中
				ExcelUtil<RepaymentExcelDto> ex = new ExcelUtil<RepaymentExcelDto>();
				String[] headers =
						{"姓名", "手机号码", "逾期金额（¥）", "应还日期", "逾期天数", "逾期罚金（¥）", "催收费（¥）", "应还合计（¥）", "催收人", "催记时间"};
				List<RepaymentExcelDto> dataset = new ArrayList<RepaymentExcelDto>();
				dto.setPage(0);
				dto.setRows(100000);
				Pager<RepaymentDto> list = repaymentsPlanService.findPaymentPage(dto);
				for (RepaymentDto item : list.getList()) {
					dataset.add(new RepaymentExcelDto(item.username, item.user_mobile, item.total_pay, item.pay_date, item.delay_days, item.late_fee, item.remind_fee, item.real_total_pay, item.remainder, item.createdon));
				}
				ex.exportExcel(headers, dataset, io);
			}else if(dto.status==1)//已完成
			{
				ExcelUtil<RepaymentExcelDto> ex = new ExcelUtil<RepaymentExcelDto>();
				String[] headers =
						{"姓名", "手机号码", "逾期金额（¥）", "应还日期", "逾期天数", "逾期罚金（¥）", "催收费（¥）", "应还合计（¥）", "催收人", "实还日期"};
				List<RepaymentExcelDto> dataset = new ArrayList<RepaymentExcelDto>();
				dto.setPage(0);
				dto.setRows(100000);
				Pager<RepaymentDto> list = repaymentsPlanService.findPaymentPage(dto);
				for (RepaymentDto item : list.getList()) {
					dataset.add(new RepaymentExcelDto(item.username, item.user_mobile, item.total_pay, item.pay_date, item.delay_days, item.late_fee, item.remind_fee, item.real_total_pay, item.remainder, item.real_pay_date));
				}
				ex.exportExcel(headers, dataset, io);
			}else if(dto.status==2)
			{
				ExcelUtil<RepaymentBadExceDto> ex = new ExcelUtil<RepaymentBadExceDto>();
				String[] headers =
						{"姓名", "手机号码", "逾期金额（¥）", "应还日期", "逾期天数", "逾期罚金（¥）", "催收费（¥）", "应还合计（¥）",  "坏账登记时间"};
				List<RepaymentBadExceDto> dataset = new ArrayList<RepaymentBadExceDto>();
				dto.setPage(0);
				dto.setRows(100000);
				Pager<RepaymentDto> list = repaymentsPlanService.findPaymentPage(dto);
				for (RepaymentDto item : list.getList()) {
					dataset.add(new RepaymentBadExceDto(item.username, item.user_mobile, item.total_pay, item.pay_date, item.delay_days, item.late_fee, item.remind_fee, item.real_total_pay,item.createdon));
				}
				ex.exportExcel(headers, dataset, io);
			}else
			{
				ExcelUtil<RemainderNoDivDto> ex = new ExcelUtil<RemainderNoDivDto>();
				String[] headers =
						{"姓名", "手机号码", "逾期金额（¥）", "应还日期", "逾期天数", "逾期罚金（¥）" , "应还合计（¥）"};
				List<RemainderNoDivDto> dataset = new ArrayList<RemainderNoDivDto>();
				dto.setPage(0);
				dto.setRows(100000);
				Pager<RepaymentDto> list = repaymentsPlanService.findPaymentPage(dto);
				for (RepaymentDto item : list.getList()) {
					dataset.add(new RemainderNoDivDto(item.username, item.user_mobile, item.total_pay, item.pay_date, item.delay_days, item.late_fee, item.real_total_pay));
				}
				ex.exportExcel(headers, dataset, io);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出excel
	 */
	public void importExcelFileOverdue(RepaymentsDto dto, OutputStream io){
		try {
			ExcelUtil<OverdueListExcelDto> ex = new ExcelUtil<OverdueListExcelDto>();
			String[] headers =
					{ "合同编号", "借款客户", "应收日期", "实收日期", "逾期期数", "逾期金额（¥）", "逾期天数", "逾期罚金（¥）", "催收费（¥）", "还款金额（¥）" };
			List<OverdueListExcelDto> dataset = new ArrayList<OverdueListExcelDto>();
			dto.setPage(0);
			dto.setRows(100000);
			Pager<RepaymentDto> list = repaymentsPlanService.getOverdueList(dto);
			for (RepaymentDto item: list.getList()){
				dataset.add(new OverdueListExcelDto(item.getLoan_number(), item.getUsername(), item.getPay_date(), item.getReal_pay_date(), item.getCurrent_term(), item.total_pay, item.getDelay_days(), item.getLate_fee(), item.getRemind_fee(), item.getReal_total_pay()));
			}
			ex.exportExcel(headers, dataset, io);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取催收人员列表
	 */
	public List<SelectDto> findPersonnelList() throws Exception {
		try {
			return repaymentsPlanExtMapper.selectPersonnelList();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 还款发送提醒短信
	 */
	public void  sendRemainderMsg()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dtnow=sdf.format(new Date());
		List<RepaymentsPlan> plans = repaymentsPlanMapper.selectByCriteria(Criteria.create(RepaymentsPlan.class)
				.add(ExpressionFactory.eq("status",0))
				.add(ExpressionFactory.sql(" datediff(pay_date,'"+dtnow+"') >0 and datediff(pay_date,'"+dtnow+"')<4")));
		for (RepaymentsPlan p: plans)
		{
			messageSmsService.SendSms("您有一笔"+p.getRealTotalPay()+"元的待还资金将于"+sdf.format(p.getPayDate())+"日扣款，请保证还款银行卡余额充足。",p.getUserMobile(),p.getMemberId(),1,PushMsgEnum.RePayRemaind.getIndex());
		}
	}


}