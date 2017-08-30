package cn.houhe.api.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：debit_rcd
 * @since 2017-05-06 17:24:46
 */
@Alias("DebitRcd")
public class DebitRcd implements Serializable {
	/** dr_id -- 还款记录id */
	private Integer drId;

	/** repayments_plan_id -- 还款计划id */
	private Integer repaymentsPlanId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** member_id -- 用户id */
	@NotNull(message="loan.DebitRcd.memberId.NotNull")
	private Integer memberId;

	/** number -- 还款号 */
	@Length(max=50,message="loan.DebitRcd.number.Length")
	private String number;

	/** flownumber -- 请求流水表 */
	@Length(max=36,message="loan.DebitRcd.flownumber.Length")
	private String flownumber;

	/** repay_type -- 还款类型0自动还款1提前还款2逾期还款 */
	@NotNull(message="loan.DebitRcd.repayType.NotNull")
	private Byte repayType;

	/** repayments_plan_ids -- 提前还款期数（多个用逗号隔开） */
	@Length(max=200,message="loan.DebitRcd.repaymentsPlanIds.Length")
	private String repaymentsPlanIds;

	/** bank_no -- 还款银行卡 */
	@Length(max=30,message="loan.DebitRcd.bankNo.Length")
	private String bankNo;

	/** bank_name -- 还款银行卡名称 */
	@Length(max=50,message="loan.DebitRcd.bankName.Length")
	private String bankName;

	/** bank_user_name -- 持卡人姓名 */
	@Length(max=20,message="loan.DebitRcd.bankUserName.Length")
	private String bankUserName;

	/** user_mobile -- 贷款人手机 */
	@Length(max=20,message="loan.DebitRcd.userMobile.Length")
	private String userMobile;

	/** late_fee -- 滞纳金 */
	@NotNull(message="loan.DebitRcd.lateFee.NotNull")
	private BigDecimal lateFee;

	/** advance_repay_fee -- 提前还款违约金 */
	@NotNull(message="loan.DebitRcd.advanceRepayFee.NotNull")
	private BigDecimal advanceRepayFee;

	/** pay_platform -- 还款平台（微众银行等） */
	@Length(max=20,message="loan.DebitRcd.payPlatform.Length")
	private String payPlatform;

	/** interest -- 本期利息 */
	@NotNull(message="loan.DebitRcd.interest.NotNull")
	private BigDecimal interest;

	/** amount -- 实际扣款金额 */
	@NotNull(message="loan.DebitRcd.amount.NotNull")
	private BigDecimal amount;

	/** debiton -- 申请扣款时间 */
	private Date debiton;

	/** repay_amount -- 申请扣款金额 */
	private BigDecimal repayAmount;

	/** pay_time -- 到账时间 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date payTime;

	/** plan_pay_time -- 计划还款日期 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date planPayTime;

	/** status -- 收款状态（0待收款，1已收款，2收款中，3收款失败） */
	@NotNull(message="loan.DebitRcd.status.NotNull")
	private Byte status;

	/** createdon --  */
	@NotNull(message="loan.DebitRcd.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.DebitRcd.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取还款记录id */
	public Integer getDrId() {
		return drId;
	}

	/** 设置还款记录id */
	public void setDrId(Integer drId) {
		this.drId = drId;
	}

	/** 获取还款计划id */
	public Integer getRepaymentsPlanId() {
		return repaymentsPlanId;
	}

	/** 设置还款计划id */
	public void setRepaymentsPlanId(Integer repaymentsPlanId) {
		this.repaymentsPlanId = repaymentsPlanId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取还款号 */
	public String getNumber() {
		return number;
	}

	/** 设置还款号 */
	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	/** 获取请求流水表 */
	public String getFlownumber() {
		return flownumber;
	}

	/** 设置请求流水表 */
	public void setFlownumber(String flownumber) {
		this.flownumber = flownumber == null ? null : flownumber.trim();
	}

	/** 获取还款类型0自动还款1提前还款2逾期还款 */
	public Byte getRepayType() {
		return repayType;
	}

	/** 设置还款类型0自动还款1提前还款2逾期还款 */
	public void setRepayType(Byte repayType) {
		this.repayType = repayType;
	}

	/** 获取还款银行卡 */
	public String getBankNo() {
		return bankNo;
	}

	/** 设置还款银行卡 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo == null ? null : bankNo.trim();
	}

	/** 获取持卡人姓名 */
	public String getBankUserName() {
		return bankUserName;
	}

	/** 设置持卡人姓名 */
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName == null ? null : bankUserName.trim();
	}

	/** 获取贷款人手机 */
	public String getUserMobile() {
		return userMobile;
	}

	/** 设置贷款人手机 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/** 获取滞纳金 */
	public BigDecimal getLateFee() {
		return lateFee;
	}

	/** 设置滞纳金 */
	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	/** 获取提前还款违约金 */
	public BigDecimal getAdvanceRepayFee() {
		return advanceRepayFee;
	}

	/** 设置提前还款违约金 */
	public void setAdvanceRepayFee(BigDecimal advanceRepayFee) {
		this.advanceRepayFee = advanceRepayFee;
	}

	/** 获取还款平台（微众银行等） */
	public String getPayPlatform() {
		return payPlatform;
	}

	/** 设置还款平台（微众银行等） */
	public void setPayPlatform(String payPlatform) {
		this.payPlatform = payPlatform == null ? null : payPlatform.trim();
	}

	/** 获取本期利息 */
	public BigDecimal getInterest() {
		return interest;
	}

	/** 设置本期利息 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	/** 获取实际扣款金额 */
	public BigDecimal getAmount() {
		return amount;
	}

	/** 设置实际扣款金额 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/** 获取申请扣款时间 */
	public Date getDebiton() {
		return debiton;
	}

	/** 设置申请扣款时间 */
	public void setDebiton(Date debiton) {
		this.debiton = debiton;
	}

	/** 获取申请扣款金额 */
	public BigDecimal getRepayAmount() {
		return repayAmount;
	}

	/** 设置申请扣款金额 */
	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}

	/** 获取到账时间 */
	public Date getPayTime() {
		return payTime;
	}

	/** 设置到账时间 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/** 获取计划还款日期 */
	public Date getPlanPayTime() {
		return planPayTime;
	}

	/** 设置计划还款日期 */
	public void setPlanPayTime(Date planPayTime) {
		this.planPayTime = planPayTime;
	}

	/** 获取收款状态（0待收款，1已收款，2收款中，3收款失败） */
	public Byte getStatus() {
		return status;
	}

	/** 设置收款状态（0待收款，1已收款，2收款中，3收款失败） */
	public void setStatus(Byte status) {
		this.status = status;
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

	public String getRepaymentsPlanIds() {
		return repaymentsPlanIds;
	}

	public void setRepaymentsPlanIds(String repaymentsPlanIds) {
		this.repaymentsPlanIds = repaymentsPlanIds;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	
	 * @since 2017-05-05 09:44:17
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
		DebitRcd other = (DebitRcd) that;
		return (this.getDrId() == null ? other.getDrId() == null : this.getDrId().equals(other.getDrId()))
			&& (this.getRepaymentsPlanId() == null ? other.getRepaymentsPlanId() == null : this.getRepaymentsPlanId().equals(other.getRepaymentsPlanId()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
			&& (this.getFlownumber() == null ? other.getFlownumber() == null : this.getFlownumber().equals(other.getFlownumber()))
			&& (this.getRepayType() == null ? other.getRepayType() == null : this.getRepayType().equals(other.getRepayType()))
			&& (this.getBankNo() == null ? other.getBankNo() == null : this.getBankNo().equals(other.getBankNo()))
			&& (this.getBankUserName() == null ? other.getBankUserName() == null : this.getBankUserName().equals(other.getBankUserName()))
			&& (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
			&& (this.getLateFee() == null ? other.getLateFee() == null : this.getLateFee().equals(other.getLateFee()))
			&& (this.getAdvanceRepayFee() == null ? other.getAdvanceRepayFee() == null : this.getAdvanceRepayFee().equals(other.getAdvanceRepayFee()))
			&& (this.getPayPlatform() == null ? other.getPayPlatform() == null : this.getPayPlatform().equals(other.getPayPlatform()))
			&& (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
			&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
			&& (this.getDebiton() == null ? other.getDebiton() == null : this.getDebiton().equals(other.getDebiton()))
			&& (this.getRepayAmount() == null ? other.getRepayAmount() == null : this.getRepayAmount().equals(other.getRepayAmount()))
			&& (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
			&& (this.getPlanPayTime() == null ? other.getPlanPayTime() == null : this.getPlanPayTime().equals(other.getPlanPayTime()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-05 09:44:17
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDrId() == null) ? 0 : getDrId().hashCode());
		result = prime * result + ((getRepaymentsPlanId() == null) ? 0 : getRepaymentsPlanId().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
		result = prime * result + ((getFlownumber() == null) ? 0 : getFlownumber().hashCode());
		result = prime * result + ((getRepayType() == null) ? 0 : getRepayType().hashCode());
		result = prime * result + ((getBankNo() == null) ? 0 : getBankNo().hashCode());
		result = prime * result + ((getBankUserName() == null) ? 0 : getBankUserName().hashCode());
		result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
		result = prime * result + ((getLateFee() == null) ? 0 : getLateFee().hashCode());
		result = prime * result + ((getAdvanceRepayFee() == null) ? 0 : getAdvanceRepayFee().hashCode());
		result = prime * result + ((getPayPlatform() == null) ? 0 : getPayPlatform().hashCode());
		result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getDebiton() == null) ? 0 : getDebiton().hashCode());
		result = prime * result + ((getRepayAmount() == null) ? 0 : getRepayAmount().hashCode());
		result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
		result = prime * result + ((getPlanPayTime() == null) ? 0 : getPlanPayTime().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}