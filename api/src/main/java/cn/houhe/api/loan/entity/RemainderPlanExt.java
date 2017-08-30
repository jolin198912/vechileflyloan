package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：remainder_plan
 * @since 2017-05-24 18:33:37
 */
@Alias("RemainderPlanExt")
public class RemainderPlanExt implements Serializable {
	/** loan_record_id -- 贷款id */
	public String loanRecordIds;
	public String getLoanRecordIds() {
		return loanRecordIds;
	}
	public void setLoanRecordIds(String loanRecordIds) {
		this.loanRecordIds = loanRecordIds;
	}

	/** repayments_plan_id -- 还款计划id */
	public String repaymentsPlanIds;
	public String getRepaymentsPlanIds() {
		return repaymentsPlanIds;
	}
	public void setRepaymentsPlanIds(String repaymentsPlanIds) {
		this.repaymentsPlanIds = repaymentsPlanIds;
	}

	/** remainder_id -- 催款人id */
	public Integer remainderId;
	public Integer getRemainderId() {
		return remainderId;
	}
	public void setRemainderId(Integer remainderId) {
		this.remainderId = remainderId;
	}

	/** remainder -- 催款人 */
	public String remainder;
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}

	/** remark -- 备注 */
	public String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** createdon --  */
	public Date createdon;
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	private static final long serialVersionUID = 1L;
}