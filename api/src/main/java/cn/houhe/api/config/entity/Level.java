package cn.houhe.api.config.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：level
 * @since 2017-04-28 16:36:11
 */
@Alias("Level")
public class Level implements Serializable {
	/** level_id --  */
	private Short levelId;

	/** name -- 等级名称 */
	@NotEmpty(message="config.Level.name.NotEmpty")
	@Length(max=30,message="config.Level.name.Length")
	private String name;

	/** min_score -- 最小分值(针对不分期的) */
	@NotNull(message="config.Level.minScore.NotNull")
	private Short minScore;

	/** max_score -- 最大分值(针对不分期的) */
	@NotNull(message="config.Level.maxScore.NotNull")
	private Short maxScore;

	/** max_limit -- 最大信用额度(针对不分期的) */
	@NotNull(message="config.Level.maxLimit.NotNull")
	private BigDecimal maxLimit;

	/** min_limit -- 最小信用额度(针对不分期的) */
	@NotNull(message="config.Level.minLimit.NotNull")
	private BigDecimal minLimit;

	/** installment_min_score -- 分期贷款的最小分值 */
	@NotNull(message="config.Level.installmentMinScore.NotNull")
	private BigDecimal installmentMinScore;

	/** installment_max_score -- 分期贷款的最大分值 */
	@NotNull(message="config.Level.installmentMaxScore.NotNull")
	private BigDecimal installmentMaxScore;

	/** installment_max_limit -- 分期贷款的最大信用额度 */
	@NotNull(message="config.Level.installmentMaxLimit.NotNull")
	private BigDecimal installmentMaxLimit;

	/** installment_min_limit -- 分期贷款的最小信用额度 */
	@NotNull(message="config.Level.installmentMinLimit.NotNull")
	private BigDecimal installmentMinLimit;

	/** createdby --  */
	@Length(max=20,message="config.Level.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.Level.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.Level.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getLevelId() {
		return levelId;
	}

	/** 设置 */
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	/** 获取等级名称 */
	public String getName() {
		return name;
	}

	/** 设置等级名称 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取最小分值(针对不分期的) */
	public Short getMinScore() {
		return minScore;
	}

	/** 设置最小分值(针对不分期的) */
	public void setMinScore(Short minScore) {
		this.minScore = minScore;
	}

	/** 获取最大分值(针对不分期的) */
	public Short getMaxScore() {
		return maxScore;
	}

	/** 设置最大分值(针对不分期的) */
	public void setMaxScore(Short maxScore) {
		this.maxScore = maxScore;
	}

	/** 获取最大信用额度(针对不分期的) */
	public BigDecimal getMaxLimit() {
		return maxLimit;
	}

	/** 设置最大信用额度(针对不分期的) */
	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	/** 获取最小信用额度(针对不分期的) */
	public BigDecimal getMinLimit() {
		return minLimit;
	}

	/** 设置最小信用额度(针对不分期的) */
	public void setMinLimit(BigDecimal minLimit) {
		this.minLimit = minLimit;
	}

	/** 获取分期贷款的最小分值 */
	public BigDecimal getInstallmentMinScore() {
		return installmentMinScore;
	}

	/** 设置分期贷款的最小分值 */
	public void setInstallmentMinScore(BigDecimal installmentMinScore) {
		this.installmentMinScore = installmentMinScore;
	}

	/** 获取分期贷款的最大分值 */
	public BigDecimal getInstallmentMaxScore() {
		return installmentMaxScore;
	}

	/** 设置分期贷款的最大分值 */
	public void setInstallmentMaxScore(BigDecimal installmentMaxScore) {
		this.installmentMaxScore = installmentMaxScore;
	}

	/** 获取分期贷款的最大信用额度 */
	public BigDecimal getInstallmentMaxLimit() {
		return installmentMaxLimit;
	}

	/** 设置分期贷款的最大信用额度 */
	public void setInstallmentMaxLimit(BigDecimal installmentMaxLimit) {
		this.installmentMaxLimit = installmentMaxLimit;
	}

	/** 获取分期贷款的最小信用额度 */
	public BigDecimal getInstallmentMinLimit() {
		return installmentMinLimit;
	}

	/** 设置分期贷款的最小信用额度 */
	public void setInstallmentMinLimit(BigDecimal installmentMinLimit) {
		this.installmentMinLimit = installmentMinLimit;
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
	
	 * @since 2017-04-28 16:36:11
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
		Level other = (Level) that;
		return (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getMinScore() == null ? other.getMinScore() == null : this.getMinScore().equals(other.getMinScore()))
			&& (this.getMaxScore() == null ? other.getMaxScore() == null : this.getMaxScore().equals(other.getMaxScore()))
			&& (this.getMaxLimit() == null ? other.getMaxLimit() == null : this.getMaxLimit().equals(other.getMaxLimit()))
			&& (this.getMinLimit() == null ? other.getMinLimit() == null : this.getMinLimit().equals(other.getMinLimit()))
			&& (this.getInstallmentMinScore() == null ? other.getInstallmentMinScore() == null : this.getInstallmentMinScore().equals(other.getInstallmentMinScore()))
			&& (this.getInstallmentMaxScore() == null ? other.getInstallmentMaxScore() == null : this.getInstallmentMaxScore().equals(other.getInstallmentMaxScore()))
			&& (this.getInstallmentMaxLimit() == null ? other.getInstallmentMaxLimit() == null : this.getInstallmentMaxLimit().equals(other.getInstallmentMaxLimit()))
			&& (this.getInstallmentMinLimit() == null ? other.getInstallmentMinLimit() == null : this.getInstallmentMinLimit().equals(other.getInstallmentMinLimit()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-04-28 16:36:11
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getMinScore() == null) ? 0 : getMinScore().hashCode());
		result = prime * result + ((getMaxScore() == null) ? 0 : getMaxScore().hashCode());
		result = prime * result + ((getMaxLimit() == null) ? 0 : getMaxLimit().hashCode());
		result = prime * result + ((getMinLimit() == null) ? 0 : getMinLimit().hashCode());
		result = prime * result + ((getInstallmentMinScore() == null) ? 0 : getInstallmentMinScore().hashCode());
		result = prime * result + ((getInstallmentMaxScore() == null) ? 0 : getInstallmentMaxScore().hashCode());
		result = prime * result + ((getInstallmentMaxLimit() == null) ? 0 : getInstallmentMaxLimit().hashCode());
		result = prime * result + ((getInstallmentMinLimit() == null) ? 0 : getInstallmentMinLimit().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}