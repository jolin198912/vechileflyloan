package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：creditinfo
 * @since 2017-04-20 16:30:33
 */
@Alias("Creditinfo")
public class Creditinfo implements Serializable {
	/** cd_id -- id 主键 */
	private Integer cdId;

	/** member_id -- 用户id */
	@NotNull(message="loan.Creditinfo.memberId.NotNull")
	private Integer memberId;

	/** loan_limit_used -- 已用额度 */
	@NotNull(message="loan.Creditinfo.loanLimitUsed.NotNull")
	private Integer loanLimitUsed;

	/** loan_limit_total -- 授信额度 */
	@NotNull(message="loan.Creditinfo.loanLimitTotal.NotNull")
	private Integer loanLimitTotal;

	/** pdl_loan_limit_used -- pdl已用额度 */
	@NotNull(message="loan.Creditinfo.pdlLoanLimitUsed.NotNull")
	private Integer pdlLoanLimitUsed;

	/** pdl_loan_limit_total -- PDL授信额度 */
	@NotNull(message="loan.Creditinfo.pdlLoanLimitTotal.NotNull")
	private Integer pdlLoanLimitTotal;

	/** system_limit_total -- 系统授信额度 */
	@NotNull(message="loan.Creditinfo.systemLimitTotal.NotNull")
	private Integer systemLimitTotal;

	/** credit_rating -- 信用评级 */
	@Length(max=5,message="loan.Creditinfo.creditRating.Length")
	private String creditRating;

	/** loan_apply_times -- 贷款次数 */
	@NotNull(message="loan.Creditinfo.loanApplyTimes.NotNull")
	private Byte loanApplyTimes;

	/** delay_debit_times -- 逾期贷款次数 */
	@NotNull(message="loan.Creditinfo.delayDebitTimes.NotNull")
	private Short delayDebitTimes;

	/** loan_limit_applying -- 申请中的额度 */
	@NotNull(message="loan.Creditinfo.loanLimitApplying.NotNull")
	private Integer loanLimitApplying;

	/** pdl_loan_limit_applying -- pdl申请中的额度 */
	@NotNull(message="loan.Creditinfo.pdlLoanLimitApplying.NotNull")
	private Integer pdlLoanLimitApplying;

	/** loan_limit_left -- 可用额度 */
	@NotNull(message="loan.Creditinfo.loanLimitLeft.NotNull")
	private Integer loanLimitLeft;

	/** pdl_loan_limit_left -- pdl可用额度 */
	@NotNull(message="loan.Creditinfo.pdlLoanLimitLeft.NotNull")
	private Integer pdlLoanLimitLeft;

	/** total_scores -- 总分值 */
	@NotNull(message="loan.Creditinfo.totalScores.NotNull")
	private Integer totalScores;

	/** assessment_day -- 信用评估时间 */
	@NotNull(message="loan.Creditinfo.assessmentDay.NotNull")
	private Date assessmentDay;

	/** createdon --  */
	@NotNull(message="loan.Creditinfo.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.Creditinfo.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取id 主键 */
	public Integer getCdId() {
		return cdId;
	}

	/** 设置id 主键 */
	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	/** 获取pdl已用额度 */
	public Integer getPdlLoanLimitUsed() {
		return pdlLoanLimitUsed;
	}

	/** 设置pdl已用额度 */
	public void setPdlLoanLimitUsed(Integer pdlLoanLimitUsed) {
		this.pdlLoanLimitUsed = pdlLoanLimitUsed;
	}

	/** 获取PDL授信额度 */
	public Integer getPdlLoanLimitTotal() {
		return pdlLoanLimitTotal;
	}

	/** 设置PDL授信额度 */
	public void setPdlLoanLimitTotal(Integer pdlLoanLimitTotal) {
		this.pdlLoanLimitTotal = pdlLoanLimitTotal;
	}

	/** 获取系统授信额度 */
	public Integer getSystemLimitTotal() {
		return systemLimitTotal;
	}

	/** 设置系统授信额度 */
	public void setSystemLimitTotal(Integer systemLimitTotal) {
		this.systemLimitTotal = systemLimitTotal;
	}

	/** 获取信用评级 */
	public String getCreditRating() {
		return creditRating;
	}

	/** 设置信用评级 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating == null ? null : creditRating.trim();
	}

	/** 获取贷款次数 */
	public Byte getLoanApplyTimes() {
		return loanApplyTimes;
	}

	/** 设置贷款次数 */
	public void setLoanApplyTimes(Byte loanApplyTimes) {
		this.loanApplyTimes = loanApplyTimes;
	}

	/** 获取逾期贷款次数 */
	public Short getDelayDebitTimes() {
		return delayDebitTimes;
	}

	/** 设置逾期贷款次数 */
	public void setDelayDebitTimes(Short delayDebitTimes) {
		this.delayDebitTimes = delayDebitTimes;
	}

	/** 获取申请中的额度 */
	public Integer getLoanLimitApplying() {
		return loanLimitApplying;
	}

	/** 设置申请中的额度 */
	public void setLoanLimitApplying(Integer loanLimitApplying) {
		this.loanLimitApplying = loanLimitApplying;
	}

	/** 获取pdl申请中的额度 */
	public Integer getPdlLoanLimitApplying() {
		return pdlLoanLimitApplying;
	}

	/** 设置pdl申请中的额度 */
	public void setPdlLoanLimitApplying(Integer pdlLoanLimitApplying) {
		this.pdlLoanLimitApplying = pdlLoanLimitApplying;
	}

	/** 获取可用额度 */
	public Integer getLoanLimitLeft() {
		return loanLimitLeft;
	}

	/** 设置可用额度 */
	public void setLoanLimitLeft(Integer loanLimitLeft) {
		this.loanLimitLeft = loanLimitLeft;
	}

	/** 获取pdl可用额度 */
	public Integer getPdlLoanLimitLeft() {
		return pdlLoanLimitLeft;
	}

	/** 设置pdl可用额度 */
	public void setPdlLoanLimitLeft(Integer pdlLoanLimitLeft) {
		this.pdlLoanLimitLeft = pdlLoanLimitLeft;
	}

	/** 获取总分值 */
	public Integer getTotalScores() {
		return totalScores;
	}

	/** 设置总分值 */
	public void setTotalScores(Integer totalScores) {
		this.totalScores = totalScores;
	}

	/** 获取信用评估时间 */
	public Date getAssessmentDay() {
		return assessmentDay;
	}

	/** 设置信用评估时间 */
	public void setAssessmentDay(Date assessmentDay) {
		this.assessmentDay = assessmentDay;
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
	
	 * @since 2017-04-20 16:30:33
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
		Creditinfo other = (Creditinfo) that;
		return (this.getCdId() == null ? other.getCdId() == null : this.getCdId().equals(other.getCdId()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getLoanLimitUsed() == null ? other.getLoanLimitUsed() == null : this.getLoanLimitUsed().equals(other.getLoanLimitUsed()))
			&& (this.getLoanLimitTotal() == null ? other.getLoanLimitTotal() == null : this.getLoanLimitTotal().equals(other.getLoanLimitTotal()))
			&& (this.getPdlLoanLimitUsed() == null ? other.getPdlLoanLimitUsed() == null : this.getPdlLoanLimitUsed().equals(other.getPdlLoanLimitUsed()))
			&& (this.getPdlLoanLimitTotal() == null ? other.getPdlLoanLimitTotal() == null : this.getPdlLoanLimitTotal().equals(other.getPdlLoanLimitTotal()))
			&& (this.getSystemLimitTotal() == null ? other.getSystemLimitTotal() == null : this.getSystemLimitTotal().equals(other.getSystemLimitTotal()))
			&& (this.getCreditRating() == null ? other.getCreditRating() == null : this.getCreditRating().equals(other.getCreditRating()))
			&& (this.getLoanApplyTimes() == null ? other.getLoanApplyTimes() == null : this.getLoanApplyTimes().equals(other.getLoanApplyTimes()))
			&& (this.getDelayDebitTimes() == null ? other.getDelayDebitTimes() == null : this.getDelayDebitTimes().equals(other.getDelayDebitTimes()))
			&& (this.getLoanLimitApplying() == null ? other.getLoanLimitApplying() == null : this.getLoanLimitApplying().equals(other.getLoanLimitApplying()))
			&& (this.getPdlLoanLimitApplying() == null ? other.getPdlLoanLimitApplying() == null : this.getPdlLoanLimitApplying().equals(other.getPdlLoanLimitApplying()))
			&& (this.getLoanLimitLeft() == null ? other.getLoanLimitLeft() == null : this.getLoanLimitLeft().equals(other.getLoanLimitLeft()))
			&& (this.getPdlLoanLimitLeft() == null ? other.getPdlLoanLimitLeft() == null : this.getPdlLoanLimitLeft().equals(other.getPdlLoanLimitLeft()))
			&& (this.getTotalScores() == null ? other.getTotalScores() == null : this.getTotalScores().equals(other.getTotalScores()))
			&& (this.getAssessmentDay() == null ? other.getAssessmentDay() == null : this.getAssessmentDay().equals(other.getAssessmentDay()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-04-20 16:30:33
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCdId() == null) ? 0 : getCdId().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getLoanLimitUsed() == null) ? 0 : getLoanLimitUsed().hashCode());
		result = prime * result + ((getLoanLimitTotal() == null) ? 0 : getLoanLimitTotal().hashCode());
		result = prime * result + ((getPdlLoanLimitUsed() == null) ? 0 : getPdlLoanLimitUsed().hashCode());
		result = prime * result + ((getPdlLoanLimitTotal() == null) ? 0 : getPdlLoanLimitTotal().hashCode());
		result = prime * result + ((getSystemLimitTotal() == null) ? 0 : getSystemLimitTotal().hashCode());
		result = prime * result + ((getCreditRating() == null) ? 0 : getCreditRating().hashCode());
		result = prime * result + ((getLoanApplyTimes() == null) ? 0 : getLoanApplyTimes().hashCode());
		result = prime * result + ((getDelayDebitTimes() == null) ? 0 : getDelayDebitTimes().hashCode());
		result = prime * result + ((getLoanLimitApplying() == null) ? 0 : getLoanLimitApplying().hashCode());
		result = prime * result + ((getPdlLoanLimitApplying() == null) ? 0 : getPdlLoanLimitApplying().hashCode());
		result = prime * result + ((getLoanLimitLeft() == null) ? 0 : getLoanLimitLeft().hashCode());
		result = prime * result + ((getPdlLoanLimitLeft() == null) ? 0 : getPdlLoanLimitLeft().hashCode());
		result = prime * result + ((getTotalScores() == null) ? 0 : getTotalScores().hashCode());
		result = prime * result + ((getAssessmentDay() == null) ? 0 : getAssessmentDay().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}