package cn.houhe.api.member.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：member
 * @since 2017-03-30 10:12:39
 */
@Alias("MemberExt")
public class MemLoanInfoExt implements Serializable {
	/** memid -- 主键id */
	private Integer memid;

	/** apply_state -- 授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	private Byte applyState;

	/** apply_state -- 贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	private Byte loanState;

	/** status -- 还款状态(0,一分未还，1部分还款，2已还清) */
	private Byte overdueStatus;

	/** loan_type -- 贷款期限类型（0日，1月） */
	private Byte loanType;

	/** loan_limit_used、pdl_loan_limit_used -- 已用额度、pdl已用额度 */
	private Integer loanLimitUsed;

	/** loan_limit_total、pdl_loan_limit_total -- 授信额度、pdl授信额度 */
	private Integer loanLimitTotal;

	/** loan_limit_applying、pdl_loan_limit_applying -- 申请中的额度、pdl申请中的额度 */
	private Integer loanLimitApplying;

	/** loan_limit_left、pdl_loan_limit_left -- 可用额度、pdl可用额度 */
	private Integer loanLimitLeft;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getMemid() {
		return memid;
	}

	/** 设置主键id */
	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	/** 获取授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public Byte getApplyState() {
		return applyState;
	}

	/** 设置授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public void setApplyState(Byte applyState) {
		this.applyState = applyState;
	}

	/** 获取贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public Byte getLoanState() {
		return loanState;
	}

	/** 设置贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public void setLoanState(Byte loanState) {
		this.loanState = loanState;
	}

	/** 获取还款状态(0,一分未还，1部分还款，2已还清) */
	public Byte getOverdueStatus() {
		return overdueStatus;
	}

	/** 设置还款状态(0,一分未还，1部分还款，2已还清) */
	public void setOverdueStatus(Byte overdueStatus) {
		this.overdueStatus = overdueStatus;
	}

	public Byte getLoanType() {
		return loanType;
	}

	public void setLoanType(Byte loanType) {
		this.loanType = loanType;
	}

	/** 获取已用额度 */
	public Integer getLoanLimitUsed() {
		return loanLimitUsed;
	}

	/** 设置已用额度 */
	public void setLoanLimitUsed(Integer loanLimitUsed) {
		this.loanLimitUsed = loanLimitUsed;
	}

	/** 获取授信额度 */
	public Integer getLoanLimitTotal() {
		return loanLimitTotal;
	}

	/** 设置授信额度 */
	public void setLoanLimitTotal(Integer loanLimitTotal) {
		this.loanLimitTotal = loanLimitTotal;
	}

	/** 获取申请中的额度 */
	public Integer getLoanLimitApplying() {
		return loanLimitApplying;
	}

	/** 设置申请中的额度 */
	public void setLoanLimitApplying(Integer loanLimitApplying) {
		this.loanLimitApplying = loanLimitApplying;
	}

	/** 获取可用额度 */
	public Integer getLoanLimitLeft() {
		return loanLimitLeft;
	}

	/** 设置可用额度 */
	public void setLoanLimitLeft(Integer loanLimitLeft) {
		this.loanLimitLeft = loanLimitLeft;
	}

	/**
	
	 * @since 2017-03-30 10:12:39
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
		MemLoanInfoExt other = (MemLoanInfoExt) that;
		return (this.getMemid() == null ? other.getMemid() == null : this.getMemid().equals(other.getMemid()));
	}

	/**
	
	 * @since 2017-03-30 10:12:39
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMemid() == null) ? 0 : getMemid().hashCode());
		return result;
	}
}