package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：loan_period
 * @since 2017-03-30 10:04:06
 */
@Alias("LoanPeriod")
public class LoanPeriod implements Serializable {
	/** lp_id --  */
	private Short lpId;

	/** type -- 类型0日，1月 */
	@NotNull(message="config.LoanPeriod.type.NotNull")
	private Byte type;

	/** time -- 天数或者月数 */
	@NotNull(message="config.LoanPeriod.time.NotNull")
	private Short time;

	/** createdby --  */
	@Length(max=20,message="config.LoanPeriod.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.LoanPeriod.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.LoanPeriod.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getLpId() {
		return lpId;
	}

	/** 设置 */
	public void setLpId(Short lpId) {
		this.lpId = lpId;
	}

	/** 获取类型0日，1月 */
	public Byte getType() {
		return type;
	}

	/** 设置类型0日，1月 */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取天数或者月数 */
	public Short getTime() {
		return time;
	}

	/** 设置天数或者月数 */
	public void setTime(Short time) {
		this.time = time;
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
	
	 * @since 2017-03-30 10:04:06
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
		LoanPeriod other = (LoanPeriod) that;
		return (this.getLpId() == null ? other.getLpId() == null : this.getLpId().equals(other.getLpId()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-03-30 10:04:06
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLpId() == null) ? 0 : getLpId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}