package cn.houhe.api.user.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：resource
 * @since 2017-04-10 16:50:49
 */
@Alias("Resource")
public class Resource implements Serializable {
	/** res_id -- 主键id */
	private Integer resId;

	/** is_single -- 是否单选(0否，1是) */
	@NotNull(message="user.Resource.isSingle.NotNull")
	private Integer isSingle;

	/** parent_id -- 父节点id */
	@NotNull(message="user.Resource.parentId.NotNull")
	private Integer parentId;

	/** res_code -- 资源编码 */
	@NotEmpty(message="user.Resource.resCode.NotEmpty")
	@Length(max=50,message="user.Resource.resCode.Length")
	private String resCode;

	/** res_name -- 资源名称 */
	@NotEmpty(message="user.Resource.resName.NotEmpty")
	@Length(max=50,message="user.Resource.resName.Length")
	private String resName;

	/** remark -- 备注 */
	@Length(max=200,message="user.Resource.remark.Length")
	private String remark;

	/** createdon -- 创建时间 */
	@NotNull(message="user.Resource.createdon.NotNull")
	private Date createdon;

	/** createdby -- 创建人 */
	@NotEmpty(message="user.Resource.createdby.NotEmpty")
	@Length(max=50,message="user.Resource.createdby.Length")
	private String createdby;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	/** modifiedby -- 修改人 */
	@Length(max=50,message="user.Resource.modifiedby.Length")
	private String modifiedby;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getResId() {
		return resId;
	}

	/** 设置主键id */
	public void setResId(Integer resId) {
		this.resId = resId;
	}

	/** 获取是否单选(0否，1是) */
	public Integer getIsSingle() {
		return isSingle;
	}

	/** 设置是否单选(0否，1是) */
	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}

	/** 获取父节点id */
	public Integer getParentId() {
		return parentId;
	}

	/** 设置父节点id */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/** 获取资源编码 */
	public String getResCode() {
		return resCode;
	}

	/** 设置资源编码 */
	public void setResCode(String resCode) {
		this.resCode = resCode == null ? null : resCode.trim();
	}

	/** 获取资源名称 */
	public String getResName() {
		return resName;
	}

	/** 设置资源名称 */
	public void setResName(String resName) {
		this.resName = resName == null ? null : resName.trim();
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取创建人 */
	public String getCreatedby() {
		return createdby;
	}

	/** 设置创建人 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby == null ? null : createdby.trim();
	}

	/** 获取修改时间 */
	public Date getModifiedon() {
		return modifiedon;
	}

	/** 设置修改时间 */
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	/** 获取修改人 */
	public String getModifiedby() {
		return modifiedby;
	}

	/** 设置修改人 */
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby == null ? null : modifiedby.trim();
	}

	/**
	
	 * @since 2017-04-10 16:50:49
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
		Resource other = (Resource) that;
		return (this.getResId() == null ? other.getResId() == null : this.getResId().equals(other.getResId()))
			&& (this.getIsSingle() == null ? other.getIsSingle() == null : this.getIsSingle().equals(other.getIsSingle()))
			&& (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
			&& (this.getResCode() == null ? other.getResCode() == null : this.getResCode().equals(other.getResCode()))
			&& (this.getResName() == null ? other.getResName() == null : this.getResName().equals(other.getResName()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()));
	}

	/**
	
	 * @since 2017-04-10 16:50:49
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getResId() == null) ? 0 : getResId().hashCode());
		result = prime * result + ((getIsSingle() == null) ? 0 : getIsSingle().hashCode());
		result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
		result = prime * result + ((getResCode() == null) ? 0 : getResCode().hashCode());
		result = prime * result + ((getResName() == null) ? 0 : getResName().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		return result;
	}
}