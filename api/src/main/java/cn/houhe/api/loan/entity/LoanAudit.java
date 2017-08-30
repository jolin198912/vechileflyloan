package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：loan_audit
 * @since 2017-04-20 16:33:40
 */
@Alias("LoanAudit")
public class LoanAudit implements Serializable {
	/** la_id --  */
	private Integer laId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** credit_apply_id -- 授信申请id */
	private Integer creditApplyId;

	/** audit_time -- 自动审批时间 */
	private Date auditTime;

	/** first_audit_time -- 初审时间 */
	private Date firstAuditTime;

	/** first_audit_person -- 初审人 */
	@Length(max=20,message="loan.LoanAudit.firstAuditPerson.Length")
	private String firstAuditPerson;

	/** plan_first_audit_person -- 分配初审人 */
	@Length(max=20,message="loan.LoanAudit.planFirstAuditPerson.Length")
	private String planFirstAuditPerson;

	/** second_audit_person -- 终审人 */
	@Length(max=20,message="loan.LoanAudit.secondAuditPerson.Length")
	private String secondAuditPerson;

	/** plan_second_audit_person -- 分配终审人 */
	@Length(max=20,message="loan.LoanAudit.planSecondAuditPerson.Length")
	private String planSecondAuditPerson;

	/** plan_sap_id -- 分配终审人id */
	@NotNull(message="loan.LoanAudit.planSapId.NotNull")
	private Integer planSapId;

	/** plan_fap_id -- 分配初审人id */
	@NotNull(message="loan.LoanAudit.planFapId.NotNull")
	private Integer planFapId;

	/** second_audit_time -- 终审时间 */
	private Date secondAuditTime;

	/** createdon --  */
	@NotNull(message="loan.LoanAudit.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.LoanAudit.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLaId() {
		return laId;
	}

	/** 设置 */
	public void setLaId(Integer laId) {
		this.laId = laId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取授信申请id */
	public Integer getCreditApplyId() {
		return creditApplyId;
	}

	/** 设置授信申请id */
	public void setCreditApplyId(Integer creditApplyId) {
		this.creditApplyId = creditApplyId;
	}

	/** 获取自动审批时间 */
	public Date getAuditTime() {
		return auditTime;
	}

	/** 设置自动审批时间 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/** 获取初审时间 */
	public Date getFirstAuditTime() {
		return firstAuditTime;
	}

	/** 设置初审时间 */
	public void setFirstAuditTime(Date firstAuditTime) {
		this.firstAuditTime = firstAuditTime;
	}

	/** 获取初审人 */
	public String getFirstAuditPerson() {
		return firstAuditPerson;
	}

	/** 设置初审人 */
	public void setFirstAuditPerson(String firstAuditPerson) {
		this.firstAuditPerson = firstAuditPerson == null ? null : firstAuditPerson.trim();
	}

	/** 获取分配初审人 */
	public String getPlanFirstAuditPerson() {
		return planFirstAuditPerson;
	}

	/** 设置分配初审人 */
	public void setPlanFirstAuditPerson(String planFirstAuditPerson) {
		this.planFirstAuditPerson = planFirstAuditPerson == null ? null : planFirstAuditPerson.trim();
	}

	/** 获取终审人 */
	public String getSecondAuditPerson() {
		return secondAuditPerson;
	}

	/** 设置终审人 */
	public void setSecondAuditPerson(String secondAuditPerson) {
		this.secondAuditPerson = secondAuditPerson == null ? null : secondAuditPerson.trim();
	}

	/** 获取分配终审人 */
	public String getPlanSecondAuditPerson() {
		return planSecondAuditPerson;
	}

	/** 设置分配终审人 */
	public void setPlanSecondAuditPerson(String planSecondAuditPerson) {
		this.planSecondAuditPerson = planSecondAuditPerson == null ? null : planSecondAuditPerson.trim();
	}

	/** 获取分配终审人id */
	public Integer getPlanSapId() {
		return planSapId;
	}

	/** 设置分配终审人id */
	public void setPlanSapId(Integer planSapId) {
		this.planSapId = planSapId;
	}

	/** 获取分配初审人id */
	public Integer getPlanFapId() {
		return planFapId;
	}

	/** 设置分配初审人id */
	public void setPlanFapId(Integer planFapId) {
		this.planFapId = planFapId;
	}

	/** 获取终审时间 */
	public Date getSecondAuditTime() {
		return secondAuditTime;
	}

	/** 设置终审时间 */
	public void setSecondAuditTime(Date secondAuditTime) {
		this.secondAuditTime = secondAuditTime;
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
	
	 * @since 2017-04-20 16:33:40
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
		LoanAudit other = (LoanAudit) that;
		return (this.getLaId() == null ? other.getLaId() == null : this.getLaId().equals(other.getLaId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getCreditApplyId() == null ? other.getCreditApplyId() == null : this.getCreditApplyId().equals(other.getCreditApplyId()))
			&& (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
			&& (this.getFirstAuditTime() == null ? other.getFirstAuditTime() == null : this.getFirstAuditTime().equals(other.getFirstAuditTime()))
			&& (this.getFirstAuditPerson() == null ? other.getFirstAuditPerson() == null : this.getFirstAuditPerson().equals(other.getFirstAuditPerson()))
			&& (this.getPlanFirstAuditPerson() == null ? other.getPlanFirstAuditPerson() == null : this.getPlanFirstAuditPerson().equals(other.getPlanFirstAuditPerson()))
			&& (this.getSecondAuditPerson() == null ? other.getSecondAuditPerson() == null : this.getSecondAuditPerson().equals(other.getSecondAuditPerson()))
			&& (this.getPlanSecondAuditPerson() == null ? other.getPlanSecondAuditPerson() == null : this.getPlanSecondAuditPerson().equals(other.getPlanSecondAuditPerson()))
			&& (this.getPlanSapId() == null ? other.getPlanSapId() == null : this.getPlanSapId().equals(other.getPlanSapId()))
			&& (this.getPlanFapId() == null ? other.getPlanFapId() == null : this.getPlanFapId().equals(other.getPlanFapId()))
			&& (this.getSecondAuditTime() == null ? other.getSecondAuditTime() == null : this.getSecondAuditTime().equals(other.getSecondAuditTime()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-04-20 16:33:40
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLaId() == null) ? 0 : getLaId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getCreditApplyId() == null) ? 0 : getCreditApplyId().hashCode());
		result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
		result = prime * result + ((getFirstAuditTime() == null) ? 0 : getFirstAuditTime().hashCode());
		result = prime * result + ((getFirstAuditPerson() == null) ? 0 : getFirstAuditPerson().hashCode());
		result = prime * result + ((getPlanFirstAuditPerson() == null) ? 0 : getPlanFirstAuditPerson().hashCode());
		result = prime * result + ((getSecondAuditPerson() == null) ? 0 : getSecondAuditPerson().hashCode());
		result = prime * result + ((getPlanSecondAuditPerson() == null) ? 0 : getPlanSecondAuditPerson().hashCode());
		result = prime * result + ((getPlanSapId() == null) ? 0 : getPlanSapId().hashCode());
		result = prime * result + ((getPlanFapId() == null) ? 0 : getPlanFapId().hashCode());
		result = prime * result + ((getSecondAuditTime() == null) ? 0 : getSecondAuditTime().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}