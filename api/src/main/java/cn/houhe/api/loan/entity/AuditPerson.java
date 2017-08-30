package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：audit_person
 * @since 2017-04-07 18:44:32
 */
@Alias("AuditPerson")
public class AuditPerson implements Serializable {
	/** ap_id --  */
	private Integer apId;

	/** loan_record_id -- 贷款id */
	private Integer loanRecordId;

	/** credit_apply_id -- 授信申请id */
	private Integer creditApplyId;

	/** audit_person_id -- 审批人的id */
	@NotNull(message="loan.AuditPerson.auditPersonId.NotNull")
	private Integer auditPersonId;

	/** audit_person_name -- 审批人姓名 */
	@NotEmpty(message="loan.AuditPerson.auditPersonName.NotEmpty")
	@Length(max=10,message="loan.AuditPerson.auditPersonName.Length")
	private String auditPersonName;

	/** createdon --  */
	@NotNull(message="loan.AuditPerson.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.AuditPerson.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getApId() {
		return apId;
	}

	/** 设置 */
	public void setApId(Integer apId) {
		this.apId = apId;
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

	/** 获取审批人的id */
	public Integer getAuditPersonId() {
		return auditPersonId;
	}

	/** 设置审批人的id */
	public void setAuditPersonId(Integer auditPersonId) {
		this.auditPersonId = auditPersonId;
	}

	/** 获取审批人姓名 */
	public String getAuditPersonName() {
		return auditPersonName;
	}

	/** 设置审批人姓名 */
	public void setAuditPersonName(String auditPersonName) {
		this.auditPersonName = auditPersonName == null ? null : auditPersonName.trim();
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
	
	 * @since 2017-04-07 18:44:32
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
		AuditPerson other = (AuditPerson) that;
		return (this.getApId() == null ? other.getApId() == null : this.getApId().equals(other.getApId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getCreditApplyId() == null ? other.getCreditApplyId() == null : this.getCreditApplyId().equals(other.getCreditApplyId()))
			&& (this.getAuditPersonId() == null ? other.getAuditPersonId() == null : this.getAuditPersonId().equals(other.getAuditPersonId()))
			&& (this.getAuditPersonName() == null ? other.getAuditPersonName() == null : this.getAuditPersonName().equals(other.getAuditPersonName()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-04-07 18:44:32
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getApId() == null) ? 0 : getApId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getCreditApplyId() == null) ? 0 : getCreditApplyId().hashCode());
		result = prime * result + ((getAuditPersonId() == null) ? 0 : getAuditPersonId().hashCode());
		result = prime * result + ((getAuditPersonName() == null) ? 0 : getAuditPersonName().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}