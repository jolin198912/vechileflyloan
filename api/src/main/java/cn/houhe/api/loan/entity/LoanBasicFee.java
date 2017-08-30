package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：loan_basic_fee
 * @since 2017-05-06 17:45:27
 */
@Alias("LoanBasicFee")
public class LoanBasicFee implements Serializable {
	/** lba_id --  */
	private Integer lbaId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** interest -- 利息 */
	@NotNull(message="loan.LoanBasicFee.interest.NotNull")
	private BigDecimal interest;

	/** loan_pay_fee -- 放款手续费 */
	@NotNull(message="loan.LoanBasicFee.loanPayFee.NotNull")
	private BigDecimal loanPayFee;

	/** financing_fee -- 融资服务费 */
	@NotNull(message="loan.LoanBasicFee.financingFee.NotNull")
	private BigDecimal financingFee;

	/** account_manage_fee -- 账号管理费 */
	@NotNull(message="loan.LoanBasicFee.accountManageFee.NotNull")
	private BigDecimal accountManageFee;

	/** consultation_fee -- 咨询费 */
	@NotNull(message="loan.LoanBasicFee.consultationFee.NotNull")
	private BigDecimal consultationFee;

	/** quota_manage_fee -- 额度管理费 */
	@NotNull(message="loan.LoanBasicFee.quotaManageFee.NotNull")
	private BigDecimal quotaManageFee;

	/** withdrawals_fee -- 提现费用 */
	@NotNull(message="loan.LoanBasicFee.withdrawalsFee.NotNull")
	private BigDecimal withdrawalsFee;

	/** advance_repay_fee -- 提前还款费用 */
	@NotNull(message="loan.LoanBasicFee.advanceRepayFee.NotNull")
	private BigDecimal advanceRepayFee;

	/** createdon --  */
	@NotNull(message="loan.LoanBasicFee.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanBasicFee.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLbaId() {
		return lbaId;
	}

	/** 设置 */
	public void setLbaId(Integer lbaId) {
		this.lbaId = lbaId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取利息 */
	public BigDecimal getInterest() {
		return interest;
	}

	/** 设置利息 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	/** 获取放款手续费 */
	public BigDecimal getLoanPayFee() {
		return loanPayFee;
	}

	/** 设置放款手续费 */
	public void setLoanPayFee(BigDecimal loanPayFee) {
		this.loanPayFee = loanPayFee;
	}

	/** 获取融资服务费 */
	public BigDecimal getFinancingFee() {
		return financingFee;
	}

	/** 设置融资服务费 */
	public void setFinancingFee(BigDecimal financingFee) {
		this.financingFee = financingFee;
	}

	/** 获取账号管理费 */
	public BigDecimal getAccountManageFee() {
		return accountManageFee;
	}

	/** 设置账号管理费 */
	public void setAccountManageFee(BigDecimal accountManageFee) {
		this.accountManageFee = accountManageFee;
	}

	/** 获取咨询费 */
	public BigDecimal getConsultationFee() {
		return consultationFee;
	}

	/** 设置咨询费 */
	public void setConsultationFee(BigDecimal consultationFee) {
		this.consultationFee = consultationFee;
	}

	/** 获取额度管理费 */
	public BigDecimal getQuotaManageFee() {
		return quotaManageFee;
	}

	/** 设置额度管理费 */
	public void setQuotaManageFee(BigDecimal quotaManageFee) {
		this.quotaManageFee = quotaManageFee;
	}

	/** 获取提现费用 */
	public BigDecimal getWithdrawalsFee() {
		return withdrawalsFee;
	}

	/** 设置提现费用 */
	public void setWithdrawalsFee(BigDecimal withdrawalsFee) {
		this.withdrawalsFee = withdrawalsFee;
	}

	/** 获取提前还款费用 */
	public BigDecimal getAdvanceRepayFee() {
		return advanceRepayFee;
	}

	/** 设置提前还款费用 */
	public void setAdvanceRepayFee(BigDecimal advanceRepayFee) {
		this.advanceRepayFee = advanceRepayFee;
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

	/**
	
	 * @since 2017-05-06 17:45:27
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
		LoanBasicFee other = (LoanBasicFee) that;
		return (this.getLbaId() == null ? other.getLbaId() == null : this.getLbaId().equals(other.getLbaId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
			&& (this.getLoanPayFee() == null ? other.getLoanPayFee() == null : this.getLoanPayFee().equals(other.getLoanPayFee()))
			&& (this.getFinancingFee() == null ? other.getFinancingFee() == null : this.getFinancingFee().equals(other.getFinancingFee()))
			&& (this.getAccountManageFee() == null ? other.getAccountManageFee() == null : this.getAccountManageFee().equals(other.getAccountManageFee()))
			&& (this.getConsultationFee() == null ? other.getConsultationFee() == null : this.getConsultationFee().equals(other.getConsultationFee()))
			&& (this.getQuotaManageFee() == null ? other.getQuotaManageFee() == null : this.getQuotaManageFee().equals(other.getQuotaManageFee()))
			&& (this.getWithdrawalsFee() == null ? other.getWithdrawalsFee() == null : this.getWithdrawalsFee().equals(other.getWithdrawalsFee()))
			&& (this.getAdvanceRepayFee() == null ? other.getAdvanceRepayFee() == null : this.getAdvanceRepayFee().equals(other.getAdvanceRepayFee()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-06 17:45:27
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLbaId() == null) ? 0 : getLbaId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
		result = prime * result + ((getLoanPayFee() == null) ? 0 : getLoanPayFee().hashCode());
		result = prime * result + ((getFinancingFee() == null) ? 0 : getFinancingFee().hashCode());
		result = prime * result + ((getAccountManageFee() == null) ? 0 : getAccountManageFee().hashCode());
		result = prime * result + ((getConsultationFee() == null) ? 0 : getConsultationFee().hashCode());
		result = prime * result + ((getQuotaManageFee() == null) ? 0 : getQuotaManageFee().hashCode());
		result = prime * result + ((getWithdrawalsFee() == null) ? 0 : getWithdrawalsFee().hashCode());
		result = prime * result + ((getAdvanceRepayFee() == null) ? 0 : getAdvanceRepayFee().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}