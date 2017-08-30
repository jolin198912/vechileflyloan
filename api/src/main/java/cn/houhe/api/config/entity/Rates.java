package cn.houhe.api.config.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：rates
 * @since 2017-05-05 12:22:12
 */
@Alias("Rates")
public class Rates implements Serializable {
	/** rr_id --  */
	private Short rrId;

	/** level_id -- 信用等级id */
	@NotNull(message="config.Rates.levelId.NotNull")
	private Short levelId;

	/** rate -- 月利率(存最终值，如0.05%，存0.0005) */
	@NotNull(message="config.Rates.rate.NotNull")
	private BigDecimal rate;

	/** type -- 类型0PDL1现金分期 */
	@NotNull(message="config.Rates.type.NotNull")
	private Short type;

	/** loan_pay_rate -- 放款手续费率 */
	@NotNull(message="config.Rates.loanPayRate.NotNull")
	private BigDecimal loanPayRate;

	/** account_manage_rate -- 账号管理费率 */
	@NotNull(message="config.Rates.accountManageRate.NotNull")
	private BigDecimal accountManageRate;

	/** consultation_rate -- 咨询费率 */
	@NotNull(message="config.Rates.consultationRate.NotNull")
	private BigDecimal consultationRate;

	/** first_loan_rate -- 首次贷款综合费率 */
	@NotNull(message="config.Rates.firstLoanRate.NotNull")
	private BigDecimal firstLoanRate;

	/** least_loan_rate -- 最低综合费率 */
	@NotNull(message="config.Rates.leastLoanRate.NotNull")
	private BigDecimal leastLoanRate;

	/** delay_rate -- 逾期罚息费率 */
	@NotNull(message="config.Rates.delayRate.NotNull")
	private BigDecimal delayRate;

	/** discount -- 费率折扣 */
	@NotNull(message="config.Rates.discount.NotNull")
	private BigDecimal discount;

	/** withdrawals_rate -- 提现费率 */
	@NotNull(message="config.Rates.withdrawalsRate.NotNull")
	private BigDecimal withdrawalsRate;

	/** quota_manage_rate -- 额度管理费率 */
	@NotNull(message="config.Rates.quotaManageRate.NotNull")
	private BigDecimal quotaManageRate;

	/** remind_fee -- 催收费（逾期一天的崔收费） */
	@NotNull(message="config.Rates.remindFee.NotNull")
	private BigDecimal remindFee;

	/** quota_manage_fee -- 额度管理费 */
	@NotNull(message="config.Rates.quotaManageFee.NotNull")
	private BigDecimal quotaManageFee;

	/** createdby --  */
	@Length(max=20,message="config.Rates.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.Rates.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.Rates.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getRrId() {
		return rrId;
	}

	/** 设置 */
	public void setRrId(Short rrId) {
		this.rrId = rrId;
	}

	/** 获取信用等级id */
	public Short getLevelId() {
		return levelId;
	}

	/** 设置信用等级id */
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	/** 获取月利率(存最终值，如0.05%，存0.0005) */
	public BigDecimal getRate() {
		return rate;
	}

	/** 设置月利率(存最终值，如0.05%，存0.0005) */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/** 获取类型0PDL1现金分期 */
	public Short getType() {
		return type;
	}

	/** 设置类型0PDL1现金分期 */
	public void setType(Short type) {
		this.type = type;
	}

	/** 获取放款手续费率 */
	public BigDecimal getLoanPayRate() {
		return loanPayRate;
	}

	/** 设置放款手续费率 */
	public void setLoanPayRate(BigDecimal loanPayRate) {
		this.loanPayRate = loanPayRate;
	}

	/** 获取账号管理费率 */
	public BigDecimal getAccountManageRate() {
		return accountManageRate;
	}

	/** 设置账号管理费率 */
	public void setAccountManageRate(BigDecimal accountManageRate) {
		this.accountManageRate = accountManageRate;
	}

	/** 获取咨询费率 */
	public BigDecimal getConsultationRate() {
		return consultationRate;
	}

	/** 设置咨询费率 */
	public void setConsultationRate(BigDecimal consultationRate) {
		this.consultationRate = consultationRate;
	}

	/** 获取首次贷款综合费率 */
	public BigDecimal getFirstLoanRate() {
		return firstLoanRate;
	}

	/** 设置首次贷款综合费率 */
	public void setFirstLoanRate(BigDecimal firstLoanRate) {
		this.firstLoanRate = firstLoanRate;
	}

	/** 获取最低综合费率 */
	public BigDecimal getLeastLoanRate() {
		return leastLoanRate;
	}

	/** 设置最低综合费率 */
	public void setLeastLoanRate(BigDecimal leastLoanRate) {
		this.leastLoanRate = leastLoanRate;
	}

	/** 获取逾期罚息费率 */
	public BigDecimal getDelayRate() {
		return delayRate;
	}

	/** 设置逾期罚息费率 */
	public void setDelayRate(BigDecimal delayRate) {
		this.delayRate = delayRate;
	}

	/** 获取费率折扣 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/** 设置费率折扣 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/** 获取提现费率 */
	public BigDecimal getWithdrawalsRate() {
		return withdrawalsRate;
	}

	/** 设置提现费率 */
	public void setWithdrawalsRate(BigDecimal withdrawalsRate) {
		this.withdrawalsRate = withdrawalsRate;
	}

	/** 获取额度管理费率 */
	public BigDecimal getQuotaManageRate() {
		return quotaManageRate;
	}

	/** 设置额度管理费率 */
	public void setQuotaManageRate(BigDecimal quotaManageRate) {
		this.quotaManageRate = quotaManageRate;
	}

	/** 获取催收费（逾期一天的崔收费） */
	public BigDecimal getRemindFee() {
		return remindFee;
	}

	/** 设置催收费（逾期一天的崔收费） */
	public void setRemindFee(BigDecimal remindFee) {
		this.remindFee = remindFee;
	}

	/** 获取额度管理费 */
	public BigDecimal getQuotaManageFee() {
		return quotaManageFee;
	}

	/** 设置额度管理费 */
	public void setQuotaManageFee(BigDecimal quotaManageFee) {
		this.quotaManageFee = quotaManageFee;
	}

	/** 获取 */
	public String getCreatedby() {
		return createdby;
	}

	/** 设置 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby == null ? null : createdby.trim();
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取 */
	public String getModifiedby() {
		return modifiedby;
	}

	/** 设置 */
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby == null ? null : modifiedby.trim();
	}

	/** 获取 */
	public Date getModifiedon() {
		return modifiedon;
	}

	/** 设置 */
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	/**
	
	 * @since 2017-05-05 12:22:12
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
		Rates other = (Rates) that;
		return (this.getRrId() == null ? other.getRrId() == null : this.getRrId().equals(other.getRrId()))
			&& (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
			&& (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getLoanPayRate() == null ? other.getLoanPayRate() == null : this.getLoanPayRate().equals(other.getLoanPayRate()))
			&& (this.getAccountManageRate() == null ? other.getAccountManageRate() == null : this.getAccountManageRate().equals(other.getAccountManageRate()))
			&& (this.getConsultationRate() == null ? other.getConsultationRate() == null : this.getConsultationRate().equals(other.getConsultationRate()))
			&& (this.getFirstLoanRate() == null ? other.getFirstLoanRate() == null : this.getFirstLoanRate().equals(other.getFirstLoanRate()))
			&& (this.getLeastLoanRate() == null ? other.getLeastLoanRate() == null : this.getLeastLoanRate().equals(other.getLeastLoanRate()))
			&& (this.getDelayRate() == null ? other.getDelayRate() == null : this.getDelayRate().equals(other.getDelayRate()))
			&& (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
			&& (this.getWithdrawalsRate() == null ? other.getWithdrawalsRate() == null : this.getWithdrawalsRate().equals(other.getWithdrawalsRate()))
			&& (this.getQuotaManageRate() == null ? other.getQuotaManageRate() == null : this.getQuotaManageRate().equals(other.getQuotaManageRate()))
			&& (this.getRemindFee() == null ? other.getRemindFee() == null : this.getRemindFee().equals(other.getRemindFee()))
			&& (this.getQuotaManageFee() == null ? other.getQuotaManageFee() == null : this.getQuotaManageFee().equals(other.getQuotaManageFee()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-05-05 12:22:12
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRrId() == null) ? 0 : getRrId().hashCode());
		result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
		result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getLoanPayRate() == null) ? 0 : getLoanPayRate().hashCode());
		result = prime * result + ((getAccountManageRate() == null) ? 0 : getAccountManageRate().hashCode());
		result = prime * result + ((getConsultationRate() == null) ? 0 : getConsultationRate().hashCode());
		result = prime * result + ((getFirstLoanRate() == null) ? 0 : getFirstLoanRate().hashCode());
		result = prime * result + ((getLeastLoanRate() == null) ? 0 : getLeastLoanRate().hashCode());
		result = prime * result + ((getDelayRate() == null) ? 0 : getDelayRate().hashCode());
		result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
		result = prime * result + ((getWithdrawalsRate() == null) ? 0 : getWithdrawalsRate().hashCode());
		result = prime * result + ((getQuotaManageRate() == null) ? 0 : getQuotaManageRate().hashCode());
		result = prime * result + ((getRemindFee() == null) ? 0 : getRemindFee().hashCode());
		result = prime * result + ((getQuotaManageFee() == null) ? 0 : getQuotaManageFee().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}