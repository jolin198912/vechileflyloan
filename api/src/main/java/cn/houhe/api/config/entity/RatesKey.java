package cn.houhe.api.config.entity;

import java.io.Serializable;

public class RatesKey implements Serializable {
	/** level_id -- 信用等级id */
	private Short levelId;

	/** lp_id -- 贷款期限id */
	private Short lpId;

	private static final long serialVersionUID = 1L;

	/** 获取信用等级id */
	public Short getLevelId() {
		return levelId;
	}

	/** 设置信用等级id */
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	/** 获取贷款期限id */
	public Short getLpId() {
		return lpId;
	}

	/** 设置贷款期限id */
	public void setLpId(Short lpId) {
		this.lpId = lpId;
	}

	/**
	
	 * @since 2017-04-27 14:34:32
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
		RatesKey other = (RatesKey) that;
		return (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
			&& (this.getLpId() == null ? other.getLpId() == null : this.getLpId().equals(other.getLpId()));
	}

	/**
	
	 * @since 2017-04-27 14:34:32
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
		result = prime * result + ((getLpId() == null) ? 0 : getLpId().hashCode());
		return result;
	}
}