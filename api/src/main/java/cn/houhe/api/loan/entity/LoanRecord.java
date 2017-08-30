package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 璐锋璁板綍：loan_record
 * @since 2017-05-05 16:27:57
 */
@Alias("LoanRecord")
public class LoanRecord implements Serializable {
	/** loan_id -- id 主键 */
	private Integer loanId;

	/** loan_limit -- 贷款额度 */
	@NotNull(message="loan.LoanRecord.loanLimit.NotNull")
	private BigDecimal loanLimit;

	/** bill_day -- 还款日（1代表每个月的1号） */
	@NotNull(message="loan.LoanRecord.billDay.NotNull")
	private Short billDay;

	/** start_time -- 开始时间 */
	private Date startTime;

	/** end_time -- 结束时间 */
	private Date endTime;

	/** user_mobile -- 贷款人手机 */
	@Length(max=50,message="loan.LoanRecord.userMobile.Length")
	private String userMobile;

	/** loan_number -- 贷款编号 */
	@Length(max=50,message="loan.LoanRecord.loanNumber.Length")
	private String loanNumber;

	/** username -- 贷款人姓名 */
	@Length(max=50,message="loan.LoanRecord.username.Length")
	private String username;

	/** idcardno -- 身份证号 */
	@Length(max=50,message="loan.LoanRecord.idcardno.Length")
	private String idcardno;

	/** member_id -- 用户id */
	@NotNull(message="loan.LoanRecord.memberId.NotNull")
	private Integer memberId;

	/** apply_time -- 申请时间 */
	private Date applyTime;

	/** mem_situation_type -- 客户贷款情况0新增客户1结清再贷2增贷 */
	@NotNull(message="loan.LoanRecord.memSituationType.NotNull")
	private Byte memSituationType;

	/** lending_time -- 放贷时间 */
	private Date lendingTime;

	/** time -- 贷款天数或者月数（如：贷款3个月） */
	@NotNull(message="loan.LoanRecord.time.NotNull")
	private Short time;

	/** loan_type -- 贷款期限类型（0日，1月） */
	@NotNull(message="loan.LoanRecord.loanType.NotNull")
	private Byte loanType;

	/** repay_state -- 还款状态：0，未还完，1按计划还清，2提前还清 */
	@NotNull(message="loan.LoanRecord.repayState.NotNull")
	private Byte repayState;

	/** lp_id -- 贷款期限id */
	@NotNull(message="loan.LoanRecord.lpId.NotNull")
	private Short lpId;

	/** late_fee_rate -- 罚息率 */
	@NotNull(message="loan.LoanRecord.lateFeeRate.NotNull")
	private BigDecimal lateFeeRate;

	/** remind_fee -- 催收费（一天的催收费） */
	@NotNull(message="loan.LoanRecord.remindFee.NotNull")
	private BigDecimal remindFee;

	/** face_similarity -- 人脸相似度(存最终值，如0.05%，存0.0005) */
	@NotNull(message="loan.LoanRecord.faceSimilarity.NotNull")
	private BigDecimal faceSimilarity;

	/** rate -- 综合贷款利率(存最终值，如0.05%，存0.0005) */
	@NotNull(message="loan.LoanRecord.rate.NotNull")
	private BigDecimal rate;

	/** current_pay_amount -- 当前应还总金额（当还了部分金额，应还金额会变化） */
	@NotNull(message="loan.LoanRecord.currentPayAmount.NotNull")
	private BigDecimal currentPayAmount;

	/** pay_amount -- 本次贷款应还总金额（最初应还总额） */
	@NotNull(message="loan.LoanRecord.payAmount.NotNull")
	private BigDecimal payAmount;

	/** apply_state -- 审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	@NotNull(message="loan.LoanRecord.applyState.NotNull")
	private Byte applyState;

	/** createdon --  */
	@NotNull(message="loan.LoanRecord.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanRecord.remark.Length")
	private String remark;

	/** pay_status -- 打款状态（0待打款，1已打款，2打款中，3打款失败） */
	@NotNull(message="loan.LoanRecord.payStatus.NotNull")
	private Byte payStatus;

	/** pay_result -- 打款提示信息 */
	@Length(max=50,message="loan.LoanRecord.payResult.Length")
	private String payResult;

	private static final long serialVersionUID = 1L;

	/** 获取id 主键 */
	public Integer getLoanId() {
		return loanId;
	}

	/** 设置id 主键 */
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	/** 获取贷款额度 */
	public BigDecimal getLoanLimit() {
		return loanLimit;
	}

	/** 设置贷款额度 */
	public void setLoanLimit(BigDecimal loanLimit) {
		this.loanLimit = loanLimit;
	}

	/** 获取还款日（1代表每个月的1号） */
	public Short getBillDay() {
		return billDay;
	}

	/** 设置还款日（1代表每个月的1号） */
	public void setBillDay(Short billDay) {
		this.billDay = billDay;
	}

	/** 获取开始时间 */
	public Date getStartTime() {
		return startTime;
	}

	/** 设置开始时间 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/** 获取结束时间 */
	public Date getEndTime() {
		return endTime;
	}

	/** 设置结束时间 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/** 获取贷款人手机 */
	public String getUserMobile() {
		return userMobile;
	}

	/** 设置贷款人手机 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/** 获取贷款编号 */
	public String getLoanNumber() {
		return loanNumber;
	}

	/** 设置贷款编号 */
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber == null ? null : loanNumber.trim();
	}

	/** 获取贷款人姓名 */
	public String getUsername() {
		return username;
	}

	/** 设置贷款人姓名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取身份证号 */
	public String getIdcardno() {
		return idcardno;
	}

	/** 设置身份证号 */
	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno == null ? null : idcardno.trim();
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取申请时间 */
	public Date getApplyTime() {
		return applyTime;
	}

	/** 设置申请时间 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/** 获取客户贷款情况0新增客户1结清再贷2增贷 */
	public Byte getMemSituationType() {
		return memSituationType;
	}

	/** 设置客户贷款情况0新增客户1结清再贷2增贷 */
	public void setMemSituationType(Byte memSituationType) {
		this.memSituationType = memSituationType;
	}

	/** 获取放贷时间 */
	public Date getLendingTime() {
		return lendingTime;
	}

	/** 设置放贷时间 */
	public void setLendingTime(Date lendingTime) {
		this.lendingTime = lendingTime;
	}

	/** 获取贷款天数或者月数（如：贷款3个月） */
	public Short getTime() {
		return time;
	}

	/** 设置贷款天数或者月数（如：贷款3个月） */
	public void setTime(Short time) {
		this.time = time;
	}

	/** 获取贷款期限类型（0日，1月） */
	public Byte getLoanType() {
		return loanType;
	}

	/** 设置贷款期限类型（0日，1月） */
	public void setLoanType(Byte loanType) {
		this.loanType = loanType;
	}

	/** 获取还款状态：0，未还完，1按计划还清，2提前还清 */
	public Byte getRepayState() {
		return repayState;
	}

	/** 设置还款状态：0，未还完，1按计划还清，2提前还清 */
	public void setRepayState(Byte repayState) {
		this.repayState = repayState;
	}

	/** 获取贷款期限id */
	public Short getLpId() {
		return lpId;
	}

	/** 设置贷款期限id */
	public void setLpId(Short lpId) {
		this.lpId = lpId;
	}

	/** 获取罚息率 */
	public BigDecimal getLateFeeRate() {
		return lateFeeRate;
	}

	/** 设置罚息率 */
	public void setLateFeeRate(BigDecimal lateFeeRate) {
		this.lateFeeRate = lateFeeRate;
	}

	/** 获取催收费（一天的催收费） */
	public BigDecimal getRemindFee() {
		return remindFee;
	}

	/** 设置催收费（一天的催收费） */
	public void setRemindFee(BigDecimal remindFee) {
		this.remindFee = remindFee;
	}

	/** 获取人脸相似度(存最终值，如0.05%，存0.0005) */
	public BigDecimal getFaceSimilarity() {
		return faceSimilarity;
	}

	/** 设置人脸相似度(存最终值，如0.05%，存0.0005) */
	public void setFaceSimilarity(BigDecimal faceSimilarity) {
		this.faceSimilarity = faceSimilarity;
	}

	/** 获取综合贷款利率(存最终值，如0.05%，存0.0005) */
	public BigDecimal getRate() {
		return rate;
	}

	/** 设置综合贷款利率(存最终值，如0.05%，存0.0005) */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/** 获取当前应还总金额（当还了部分金额，应还金额会变化） */
	public BigDecimal getCurrentPayAmount() {
		return currentPayAmount;
	}

	/** 设置当前应还总金额（当还了部分金额，应还金额会变化） */
	public void setCurrentPayAmount(BigDecimal currentPayAmount) {
		this.currentPayAmount = currentPayAmount;
	}

	/** 获取本次贷款应还总金额（最初应还总额） */
	public BigDecimal getPayAmount() {
		return payAmount;
	}

	/** 设置本次贷款应还总金额（最初应还总额） */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/** 获取审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	public Byte getApplyState() {
		return applyState;
	}

	/** 设置审核状态（1填写完资料审批中2初审通过3初审不通过4终审通过5终审不通过6自动审批通过7自动审批不通过） */
	public void setApplyState(Byte applyState) {
		this.applyState = applyState;
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取打款状态（0待打款，1已打款，2打款中，3打款失败） */
	public Byte getPayStatus() {
		return payStatus;
	}

	/** 设置打款状态（0待打款，1已打款，2打款中，3打款失败） */
	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	/** 获取打款提示信息 */
	public String getPayResult() {
		return payResult;
	}

	/** 设置打款提示信息 */
	public void setPayResult(String payResult) {
		this.payResult = payResult == null ? null : payResult.trim();
	}

	/**
	
	 * @since 2017-05-05 16:27:57
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		LoanRecord other = (LoanRecord) that;
		return (this.getLoanId() == null ? other.getLoanId() == null : this.getLoanId().equals(other.getLoanId()))
			&& (this.getLoanLimit() == null ? other.getLoanLimit() == null : this.getLoanLimit().equals(other.getLoanLimit()))
			&& (this.getBillDay() == null ? other.getBillDay() == null : this.getBillDay().equals(other.getBillDay()))
			&& (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
			&& (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
			&& (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
			&& (this.getLoanNumber() == null ? other.getLoanNumber() == null : this.getLoanNumber().equals(other.getLoanNumber()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getIdcardno() == null ? other.getIdcardno() == null : this.getIdcardno().equals(other.getIdcardno()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
			&& (this.getMemSituationType() == null ? other.getMemSituationType() == null : this.getMemSituationType().equals(other.getMemSituationType()))
			&& (this.getLendingTime() == null ? other.getLendingTime() == null : this.getLendingTime().equals(other.getLendingTime()))
			&& (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
			&& (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
			&& (this.getRepayState() == null ? other.getRepayState() == null : this.getRepayState().equals(other.getRepayState()))
			&& (this.getLpId() == null ? other.getLpId() == null : this.getLpId().equals(other.getLpId()))
			&& (this.getLateFeeRate() == null ? other.getLateFeeRate() == null : this.getLateFeeRate().equals(other.getLateFeeRate()))
			&& (this.getRemindFee() == null ? other.getRemindFee() == null : this.getRemindFee().equals(other.getRemindFee()))
			&& (this.getFaceSimilarity() == null ? other.getFaceSimilarity() == null : this.getFaceSimilarity().equals(other.getFaceSimilarity()))
			&& (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
			&& (this.getCurrentPayAmount() == null ? other.getCurrentPayAmount() == null : this.getCurrentPayAmount().equals(other.getCurrentPayAmount()))
			&& (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
			&& (this.getApplyState() == null ? other.getApplyState() == null : this.getApplyState().equals(other.getApplyState()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
			&& (this.getPayResult() == null ? other.getPayResult() == null : this.getPayResult().equals(other.getPayResult()));
	}

	/**
	
	 * @since 2017-05-05 16:27:57
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLoanId() == null) ? 0 : getLoanId().hashCode());
		result = prime * result + ((getLoanLimit() == null) ? 0 : getLoanLimit().hashCode());
		result = prime * result + ((getBillDay() == null) ? 0 : getBillDay().hashCode());
		result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
		result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
		result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
		result = prime * result + ((getLoanNumber() == null) ? 0 : getLoanNumber().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getIdcardno() == null) ? 0 : getIdcardno().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
		result = prime * result + ((getMemSituationType() == null) ? 0 : getMemSituationType().hashCode());
		result = prime * result + ((getLendingTime() == null) ? 0 : getLendingTime().hashCode());
		result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
		result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
		result = prime * result + ((getRepayState() == null) ? 0 : getRepayState().hashCode());
		result = prime * result + ((getLpId() == null) ? 0 : getLpId().hashCode());
		result = prime * result + ((getLateFeeRate() == null) ? 0 : getLateFeeRate().hashCode());
		result = prime * result + ((getRemindFee() == null) ? 0 : getRemindFee().hashCode());
		result = prime * result + ((getFaceSimilarity() == null) ? 0 : getFaceSimilarity().hashCode());
		result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
		result = prime * result + ((getCurrentPayAmount() == null) ? 0 : getCurrentPayAmount().hashCode());
		result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
		result = prime * result + ((getApplyState() == null) ? 0 : getApplyState().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
		result = prime * result + ((getPayResult() == null) ? 0 : getPayResult().hashCode());
		return result;
	}
}