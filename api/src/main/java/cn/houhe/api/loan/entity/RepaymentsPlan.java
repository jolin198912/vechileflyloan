package cn.houhe.api.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：repayments_plan
 * @since 2017-05-15 14:49:54
 */
@Alias("RepaymentsPlan")
public class RepaymentsPlan implements Serializable {
	/** rpt_id -- 主键 */
	private Integer rptId;

	/** loan_record_id -- 贷款id */
	@NotNull(message="loan.RepaymentsPlan.loanRecordId.NotNull")
	private Integer loanRecordId;

	/** user_mobile -- 贷款人手机 */
	@Length(max=50,message="loan.RepaymentsPlan.userMobile.Length")
	private String userMobile;

	/** username -- 贷款人姓名 */
	@Length(max=50,message="loan.RepaymentsPlan.username.Length")
	private String username;

	/** member_id -- 用户id */
	private Integer memberId;

	/** repay_number -- 还款编号 */
	@Length(max=50,message="loan.RepaymentsPlan.repayNumber.Length")
	private String repayNumber;

	/** principal -- 本期应还本金 */
	@NotNull(message="loan.RepaymentsPlan.principal.NotNull")
	private BigDecimal principal;

	/** total_pay -- 本期应还总额（最初生成的还款计划的应还总额） */
	@NotNull(message="loan.RepaymentsPlan.totalPay.NotNull")
	private BigDecimal totalPay;

	/** real_total_pay -- 本期实际应还总额 */
	@NotNull(message="loan.RepaymentsPlan.realTotalPay.NotNull")
	private BigDecimal realTotalPay;

	/** arrears -- 往期欠款 */
	@NotNull(message="loan.RepaymentsPlan.arrears.NotNull")
	private BigDecimal arrears;

	/** current_term -- 当前期数（1代表第一期） */
	@NotNull(message="loan.RepaymentsPlan.currentTerm.NotNull")
	private Short currentTerm;

	/** interest -- 本期利息 */
	@NotNull(message="loan.RepaymentsPlan.interest.NotNull")
	private BigDecimal interest;

	/** real_pay -- 实际偿还金额 */
	@NotNull(message="loan.RepaymentsPlan.realPay.NotNull")
	private BigDecimal realPay;

	/** liquidated_damages -- 提前还款的违约金（手续费） */
	@NotNull(message="loan.RepaymentsPlan.liquidatedDamages.NotNull")
	private BigDecimal liquidatedDamages;

	/** late_fee -- 罚息 */
	@NotNull(message="loan.RepaymentsPlan.lateFee.NotNull")
	private BigDecimal lateFee;

	/** late_interest -- 逾期利息（暂不维护） */
	@NotNull(message="loan.RepaymentsPlan.lateInterest.NotNull")
	private BigDecimal lateInterest;

	/** remind_fee -- 催收费 */
	@NotNull(message="loan.RepaymentsPlan.remindFee.NotNull")
	private BigDecimal remindFee;

	/** status -- 还款状态(0一分未还1部分还款2正常还清3逾期还清4提前还款) */
	private Byte status;

	/** delay_days -- 逾期天数 */
	@NotNull(message="loan.RepaymentsPlan.delayDays.NotNull")
	private Short delayDays;

	/** pay_date -- 应还款日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date payDate;

	/** delay_date -- 还款信息维护日期 */
	private Date delayDate;

	/** bad_day -- 登记坏账时间 */
	private Date badDay;

	/** is_bad -- 是否坏账0否1是 */
	@NotNull(message="loan.RepaymentsPlan.isBad.NotNull")
	private Byte isBad;

	/** real_pay_date -- 实际还款日期 */
	private Date realPayDate;

	/** createdon -- 创建时间 */
	@NotNull(message="loan.RepaymentsPlan.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.RepaymentsPlan.remark.Length")
	private String remark;

	/** gather_status -- 收款状态（0待收款，1已收款，2收款中，3收款失败） */
	@NotNull(message="loan.RepaymentsPlan.gatherStatus.NotNull")
	private Byte gatherStatus;

	/** gather_result -- 收款提示信息 */
	@Length(max=50,message="loan.RepaymentsPlan.gatherResult.Length")
	private String gatherResult;

	private static final long serialVersionUID = 1L;

	/** 获取主键 */
	public Integer getRptId() {
		return rptId;
	}

	/** 设置主键 */
	public void setRptId(Integer rptId) {
		this.rptId = rptId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取贷款人手机 */
	public String getUserMobile() {
		return userMobile;
	}

	/** 设置贷款人手机 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/** 获取贷款人姓名 */
	public String getUsername() {
		return username;
	}

	/** 设置贷款人姓名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取还款编号 */
	public String getRepayNumber() {
		return repayNumber;
	}

	/** 设置还款编号 */
	public void setRepayNumber(String repayNumber) {
		this.repayNumber = repayNumber == null ? null : repayNumber.trim();
	}

	/** 获取本期应还本金 */
	public BigDecimal getPrincipal() {
		return principal;
	}

	/** 设置本期应还本金 */
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	/** 获取本期应还总额（最初生成的还款计划的应还总额） */
	public BigDecimal getTotalPay() {
		return totalPay;
	}

	/** 设置本期应还总额（最初生成的还款计划的应还总额） */
	public void setTotalPay(BigDecimal totalPay) {
		this.totalPay = totalPay;
	}

	/** 获取本期实际应还总额 */
	public BigDecimal getRealTotalPay() {
		return realTotalPay;
	}

	/** 设置本期实际应还总额 */
	public void setRealTotalPay(BigDecimal realTotalPay) {
		this.realTotalPay = realTotalPay;
	}

	/** 获取往期欠款 */
	public BigDecimal getArrears() {
		return arrears;
	}

	/** 设置往期欠款 */
	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	/** 获取当前期数（1代表第一期） */
	public Short getCurrentTerm() {
		return currentTerm;
	}

	/** 设置当前期数（1代表第一期） */
	public void setCurrentTerm(Short currentTerm) {
		this.currentTerm = currentTerm;
	}

	/** 获取本期利息 */
	public BigDecimal getInterest() {
		return interest;
	}

	/** 设置本期利息 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	/** 获取实际偿还金额 */
	public BigDecimal getRealPay() {
		return realPay;
	}

	/** 设置实际偿还金额 */
	public void setRealPay(BigDecimal realPay) {
		this.realPay = realPay;
	}

	/** 获取提前还款的违约金（手续费） */
	public BigDecimal getLiquidatedDamages() {
		return liquidatedDamages;
	}

	/** 设置提前还款的违约金（手续费） */
	public void setLiquidatedDamages(BigDecimal liquidatedDamages) {
		this.liquidatedDamages = liquidatedDamages;
	}

	/** 获取罚息 */
	public BigDecimal getLateFee() {
		return lateFee;
	}

	/** 设置罚息 */
	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	/** 获取逾期利息（暂不维护） */
	public BigDecimal getLateInterest() {
		return lateInterest;
	}

	/** 设置逾期利息（暂不维护） */
	public void setLateInterest(BigDecimal lateInterest) {
		this.lateInterest = lateInterest;
	}

	/** 获取催收费 */
	public BigDecimal getRemindFee() {
		return remindFee;
	}

	/** 设置催收费 */
	public void setRemindFee(BigDecimal remindFee) {
		this.remindFee = remindFee;
	}

	/** 获取还款状态(0一分未还1部分还款2正常还清3逾期还清4提前还款) */
	public Byte getStatus() {
		return status;
	}

	/** 设置还款状态(0一分未还1部分还款2正常还清3逾期还清4提前还款) */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/** 获取逾期天数 */
	public Short getDelayDays() {
		return delayDays;
	}

	/** 设置逾期天数 */
	public void setDelayDays(Short delayDays) {
		this.delayDays = delayDays;
	}

	/** 获取应还款日期 */
	public Date getPayDate() {
		return payDate;
	}

	/** 设置应还款日期 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/** 获取还款信息维护日期 */
	public Date getDelayDate() {
		return delayDate;
	}

	/** 设置还款信息维护日期 */
	public void setDelayDate(Date delayDate) {
		this.delayDate = delayDate;
	}

	/** 获取登记坏账时间 */
	public Date getBadDay() {
		return badDay;
	}

	/** 设置登记坏账时间 */
	public void setBadDay(Date badDay) {
		this.badDay = badDay;
	}

	/** 获取是否坏账0否1是 */
	public Byte getIsBad() {
		return isBad;
	}

	/** 设置是否坏账0否1是 */
	public void setIsBad(Byte isBad) {
		this.isBad = isBad;
	}

	/** 获取实际还款日期 */
	public Date getRealPayDate() {
		return realPayDate;
	}

	/** 设置实际还款日期 */
	public void setRealPayDate(Date realPayDate) {
		this.realPayDate = realPayDate;
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
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

	/** 获取收款状态（0待收款，1已收款，2收款中，3收款失败） */
	public Byte getGatherStatus() {
		return gatherStatus;
	}

	/** 设置收款状态（0待收款，1已收款，2收款中，3收款失败） */
	public void setGatherStatus(Byte gatherStatus) {
		this.gatherStatus = gatherStatus;
	}

	/** 获取收款提示信息 */
	public String getGatherResult() {
		return gatherResult;
	}

	/** 设置收款提示信息 */
	public void setGatherResult(String gatherResult) {
		this.gatherResult = gatherResult == null ? null : gatherResult.trim();
	}

	/**
	
	 * @since 2017-05-15 14:49:54
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
		RepaymentsPlan other = (RepaymentsPlan) that;
		return (this.getRptId() == null ? other.getRptId() == null : this.getRptId().equals(other.getRptId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getRepayNumber() == null ? other.getRepayNumber() == null : this.getRepayNumber().equals(other.getRepayNumber()))
			&& (this.getPrincipal() == null ? other.getPrincipal() == null : this.getPrincipal().equals(other.getPrincipal()))
			&& (this.getTotalPay() == null ? other.getTotalPay() == null : this.getTotalPay().equals(other.getTotalPay()))
			&& (this.getRealTotalPay() == null ? other.getRealTotalPay() == null : this.getRealTotalPay().equals(other.getRealTotalPay()))
			&& (this.getArrears() == null ? other.getArrears() == null : this.getArrears().equals(other.getArrears()))
			&& (this.getCurrentTerm() == null ? other.getCurrentTerm() == null : this.getCurrentTerm().equals(other.getCurrentTerm()))
			&& (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
			&& (this.getRealPay() == null ? other.getRealPay() == null : this.getRealPay().equals(other.getRealPay()))
			&& (this.getLiquidatedDamages() == null ? other.getLiquidatedDamages() == null : this.getLiquidatedDamages().equals(other.getLiquidatedDamages()))
			&& (this.getLateFee() == null ? other.getLateFee() == null : this.getLateFee().equals(other.getLateFee()))
			&& (this.getLateInterest() == null ? other.getLateInterest() == null : this.getLateInterest().equals(other.getLateInterest()))
			&& (this.getRemindFee() == null ? other.getRemindFee() == null : this.getRemindFee().equals(other.getRemindFee()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getDelayDays() == null ? other.getDelayDays() == null : this.getDelayDays().equals(other.getDelayDays()))
			&& (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
			&& (this.getDelayDate() == null ? other.getDelayDate() == null : this.getDelayDate().equals(other.getDelayDate()))
			&& (this.getBadDay() == null ? other.getBadDay() == null : this.getBadDay().equals(other.getBadDay()))
			&& (this.getIsBad() == null ? other.getIsBad() == null : this.getIsBad().equals(other.getIsBad()))
			&& (this.getRealPayDate() == null ? other.getRealPayDate() == null : this.getRealPayDate().equals(other.getRealPayDate()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getGatherStatus() == null ? other.getGatherStatus() == null : this.getGatherStatus().equals(other.getGatherStatus()))
			&& (this.getGatherResult() == null ? other.getGatherResult() == null : this.getGatherResult().equals(other.getGatherResult()));
	}

	/**
	
	 * @since 2017-05-15 14:49:54
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRptId() == null) ? 0 : getRptId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getRepayNumber() == null) ? 0 : getRepayNumber().hashCode());
		result = prime * result + ((getPrincipal() == null) ? 0 : getPrincipal().hashCode());
		result = prime * result + ((getTotalPay() == null) ? 0 : getTotalPay().hashCode());
		result = prime * result + ((getRealTotalPay() == null) ? 0 : getRealTotalPay().hashCode());
		result = prime * result + ((getArrears() == null) ? 0 : getArrears().hashCode());
		result = prime * result + ((getCurrentTerm() == null) ? 0 : getCurrentTerm().hashCode());
		result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
		result = prime * result + ((getRealPay() == null) ? 0 : getRealPay().hashCode());
		result = prime * result + ((getLiquidatedDamages() == null) ? 0 : getLiquidatedDamages().hashCode());
		result = prime * result + ((getLateFee() == null) ? 0 : getLateFee().hashCode());
		result = prime * result + ((getLateInterest() == null) ? 0 : getLateInterest().hashCode());
		result = prime * result + ((getRemindFee() == null) ? 0 : getRemindFee().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getDelayDays() == null) ? 0 : getDelayDays().hashCode());
		result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
		result = prime * result + ((getDelayDate() == null) ? 0 : getDelayDate().hashCode());
		result = prime * result + ((getBadDay() == null) ? 0 : getBadDay().hashCode());
		result = prime * result + ((getIsBad() == null) ? 0 : getIsBad().hashCode());
		result = prime * result + ((getRealPayDate() == null) ? 0 : getRealPayDate().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getGatherStatus() == null) ? 0 : getGatherStatus().hashCode());
		result = prime * result + ((getGatherResult() == null) ? 0 : getGatherResult().hashCode());
		return result;
	}
}