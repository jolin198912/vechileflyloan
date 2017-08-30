package cn.houhe.api.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 瑙掕壊琛�：role
 * @since 2017-03-30 13:50:02
 */
@Alias("Role")
public class Role implements Serializable {
	/** roleid -- 主键id */
	private Integer roleid;

	/** name -- 角色名称 */
	@NotEmpty(message="user.Role.name.NotEmpty")
	@Length(max=50,message="user.Role.name.Length")
	private String name;

	/** remark -- 备注 */
	@Length(max=200,message="user.Role.remark.Length")
	private String remark;

	/** createdon -- 创建时间 */
	@NotNull(message="user.Role.createdon.NotNull")
	private Date createdon;

	/** createdby -- 创建人 */
	@NotEmpty(message="user.Role.createdby.NotEmpty")
	@Length(max=50,message="user.Role.createdby.Length")
	private String createdby;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	/** modifiedby -- 修改人 */
	@Length(max=50,message="user.Role.modifiedby.Length")
	private String modifiedby;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getRoleid() {
		return roleid;
	}

	/** 设置主键id */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** 获取角色名称 */
	public String getName() {
		return name;
	}

	/** 设置角色名称 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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
	
	 * @since 2017-03-30 13:50:02
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
		Role other = (Role) that;
		return (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getCreatedby() == null ? other.getCreatedby() == null : this.getCreatedby().equals(other.getCreatedby()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()))
			&& (this.getModifiedby() == null ? other.getModifiedby() == null : this.getModifiedby().equals(other.getModifiedby()));
	}

	/**
	
	 * @since 2017-03-30 13:50:02
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		return result;
	}
}