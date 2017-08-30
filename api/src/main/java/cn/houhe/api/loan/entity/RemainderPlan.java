package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
@Alias("RemainderPlan")
public class RemainderPlan implements Serializable {
	/** rp_id --  */
	private Integer rpId;

	/** loan_record_id -- 贷款id */
	@NotNull(message="loan.RemainderPlan.loanRecordId.NotNull")
	private Integer loanRecordId;

	/** repayments_plan_id -- 还款计划id */
	@NotNull(message="loan.RemainderPlan.repaymentsPlanId.NotNull")
	private Integer repaymentsPlanId;

	/** remainder_id -- 催款人id */
	@NotNull(message="loan.RemainderPlan.remainderId.NotNull")
	private Integer remainderId;

	/** remainder -- 催款人 */
	@Length(max=30,message="loan.RemainderPlan.remainder.Length")
	private String remainder;

	/** remark -- 备注 */
	@Length(max=100,message="loan.RemainderPlan.remark.Length")
	private String remark;

	/** createdon --  */
	@NotNull(message="loan.RemainderPlan.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getRpId() {
		return rpId;
	}

	/** 设置 */
	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取还款计划id */
	public Integer getRepaymentsPlanId() {
		return repaymentsPlanId;
	}

	/** 设置还款计划id */
	public void setRepaymentsPlanId(Integer repaymentsPlanId) {
		this.repaymentsPlanId = repaymentsPlanId;
	}

	/** 获取催款人id */
	public Integer getRemainderId() {
		return remainderId;
	}

	/** 设置催款人id */
	public void setRemainderId(Integer remainderId) {
		this.remainderId = remainderId;
	}

	/** 获取催款人 */
	public String getRemainder() {
		return remainder;
	}

	/** 设置催款人 */
	public void setRemainder(String remainder) {
		this.remainder = remainder == null ? null : remainder.trim();
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-05-24 18:33:37
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
		RemainderPlan other = (RemainderPlan) that;
		return (this.getRpId() == null ? other.getRpId() == null : this.getRpId().equals(other.getRpId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getRepaymentsPlanId() == null ? other.getRepaymentsPlanId() == null : this.getRepaymentsPlanId().equals(other.getRepaymentsPlanId()))
			&& (this.getRemainderId() == null ? other.getRemainderId() == null : this.getRemainderId().equals(other.getRemainderId()))
			&& (this.getRemainder() == null ? other.getRemainder() == null : this.getRemainder().equals(other.getRemainder()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-05-24 18:33:37
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRpId() == null) ? 0 : getRpId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getRepaymentsPlanId() == null) ? 0 : getRepaymentsPlanId().hashCode());
		result = prime * result + ((getRemainderId() == null) ? 0 : getRemainderId().hashCode());
		result = prime * result + ((getRemainder() == null) ? 0 : getRemainder().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}