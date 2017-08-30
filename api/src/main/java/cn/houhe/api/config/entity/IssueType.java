package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：issue_type
 * @since 2017-03-30 10:04:06
 */
@Alias("IssueType")
public class IssueType implements Serializable {
	/** it_id --  */
	private Short itId;

	/** name -- 类别名称 */
	@NotEmpty(message="config.IssueType.name.NotEmpty")
	@Length(max=50,message="config.IssueType.name.Length")
	private String name;

	/** is_del -- 0未删除，1已删除 */
	@NotNull(message="config.IssueType.isDel.NotNull")
	private Byte isDel;

	/** createdby --  */
	@Length(max=20,message="config.IssueType.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.IssueType.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.IssueType.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getItId() {
		return itId;
	}

	/** 设置 */
	public void setItId(Short itId) {
		this.itId = itId;
	}

	/** 获取类别名称 */
	public String getName() {
		return name;
	}

	/** 设置类别名称 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取0未删除，1已删除 */
	public Byte getIsDel() {
		return isDel;
	}

	/** 设置0未删除，1已删除 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
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
		IssueType other = (IssueType) that;
		return (this.getItId() == null ? other.getItId() == null : this.getItId().equals(other.getItId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
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
		result = prime * result + ((getItId() == null) ? 0 : getItId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}