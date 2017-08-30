package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：distribution__config
 * @since 2017-05-24 11:08:35
 */
@Alias("DistributionConfig")
public class DistributionConfig implements Serializable {
	/** pc_id --  */
	private Integer pcId;

	/** distribution_type -- 分配方式0系统自动1人工分配 */
	@NotNull(message="config.DistributionConfig.distributionType.NotNull")
	private Byte distributionType;

	/** type -- 参数类型0授信1放贷2催收 */
	@NotNull(message="config.DistributionConfig.type.NotNull")
	private Byte type;

	/** min_score -- 自动授信的最低分数 */
	@NotNull(message="config.DistributionConfig.minScore.NotNull")
	private Integer minScore;

	/** max_score -- 自动授信的最高分数 */
	@NotNull(message="config.DistributionConfig.maxScore.NotNull")
	private Integer maxScore;

	/** createdon --  */
	@NotNull(message="config.DistributionConfig.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="config.DistributionConfig.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getPcId() {
		return pcId;
	}

	/** 设置 */
	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	/** 获取分配方式0系统自动1人工分配 */
	public Byte getDistributionType() {
		return distributionType;
	}

	/** 设置分配方式0系统自动1人工分配 */
	public void setDistributionType(Byte distributionType) {
		this.distributionType = distributionType;
	}

	/** 获取参数类型0授信1放贷2催收 */
	public Byte getType() {
		return type;
	}

	/** 设置参数类型0授信1放贷2催收 */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取自动授信的最低分数 */
	public Integer getMinScore() {
		return minScore;
	}

	/** 设置自动授信的最低分数 */
	public void setMinScore(Integer minScore) {
		this.minScore = minScore;
	}

	/** 获取自动授信的最高分数 */
	public Integer getMaxScore() {
		return maxScore;
	}

	/** 设置自动授信的最高分数 */
	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
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
	
	 * @since 2017-05-24 11:08:35
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
		DistributionConfig other = (DistributionConfig) that;
		return (this.getPcId() == null ? other.getPcId() == null : this.getPcId().equals(other.getPcId()))
			&& (this.getDistributionType() == null ? other.getDistributionType() == null : this.getDistributionType().equals(other.getDistributionType()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getMinScore() == null ? other.getMinScore() == null : this.getMinScore().equals(other.getMinScore()))
			&& (this.getMaxScore() == null ? other.getMaxScore() == null : this.getMaxScore().equals(other.getMaxScore()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-24 11:08:35
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPcId() == null) ? 0 : getPcId().hashCode());
		result = prime * result + ((getDistributionType() == null) ? 0 : getDistributionType().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getMinScore() == null) ? 0 : getMinScore().hashCode());
		result = prime * result + ((getMaxScore() == null) ? 0 : getMaxScore().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}