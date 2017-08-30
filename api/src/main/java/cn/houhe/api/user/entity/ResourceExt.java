package cn.houhe.api.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 实体类 - 表：resource
 * @since 2017-04-10 16:50:49
 */
@Alias("Resource")
public class ResourceExt implements Serializable {
	/** res_id -- 主键id */
	private Integer res_id;

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

	private List<ResourceExt> childList=new ArrayList<ResourceExt>();


	public List<ResourceExt> getChildList() {
		return childList;
	}

	public void setChildList(List<ResourceExt> childList) {
		this.childList = childList;
	}

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getResId() {
		return res_id;
	}

	/** 设置主键id */
	public void setResId(Integer resId) {
		this.res_id = resId;
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
		ResourceExt other = (ResourceExt) that;
		return (this.getResId() == null ? other.getResId() == null : this.getResId().equals(other.getResId()))
			&& (this.getIsSingle() == null ? other.getIsSingle() == null : this.getIsSingle().equals(other.getIsSingle()))
			&& (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
			&& (this.getResCode() == null ? other.getResCode() == null : this.getResCode().equals(other.getResCode()))
			&& (this.getResName() == null ? other.getResName() == null : this.getResName().equals(other.getResName()));
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
		return result;
	}
}