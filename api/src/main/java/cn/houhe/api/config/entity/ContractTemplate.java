package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：contract_template
 * @since 2017-03-30 10:04:06
 */
@Alias("ContractTemplate")
public class ContractTemplate implements Serializable {
	/** ct_id --  */
	private Short ctId;

	/** name -- 文件名称 */
	@NotEmpty(message="config.ContractTemplate.name.NotEmpty")
	@Length(max=100,message="config.ContractTemplate.name.Length")
	private String name;

	/** path -- 文件路径 */
	@NotEmpty(message="config.ContractTemplate.path.NotEmpty")
	@Length(max=200,message="config.ContractTemplate.path.Length")
	private String path;

	/** type -- 合同类型 */
	@NotNull(message="config.ContractTemplate.type.NotNull")
	private Byte type;

	/** createdby --  */
	@Length(max=20,message="config.ContractTemplate.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.ContractTemplate.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.ContractTemplate.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getCtId() {
		return ctId;
	}

	/** 设置 */
	public void setCtId(Short ctId) {
		this.ctId = ctId;
	}

	/** 获取文件名称 */
	public String getName() {
		return name;
	}

	/** 设置文件名称 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取文件路径 */
	public String getPath() {
		return path;
	}

	/** 设置文件路径 */
	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	/** 获取合同类型 */
	public Byte getType() {
		return type;
	}

	/** 设置合同类型 */
	public void setType(Byte type) {
		this.type = type;
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
		ContractTemplate other = (ContractTemplate) that;
		return (this.getCtId() == null ? other.getCtId() == null : this.getCtId().equals(other.getCtId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
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
		result = prime * result + ((getCtId() == null) ? 0 : getCtId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}