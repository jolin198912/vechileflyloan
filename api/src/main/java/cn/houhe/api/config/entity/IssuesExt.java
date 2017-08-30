package cn.houhe.api.config.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：issues
 * @since 2017-03-30 10:04:06
 */
@Alias("Issues")
public class IssuesExt implements Serializable {
	/** iu_id --  */
	private Short iuId;

	/** issue_type_id --  */
	private Short issueTypeId;

	/** title -- 问题 */
	@NotEmpty(message="config.Issues.title.NotEmpty")
	@Length(max=100,message="config.Issues.title.Length")
	private String title;

	/** isSolve -- 是否已解决（0：是 1：否） */
	private Byte isSolve;

    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    //问题类别
	private String typename;
	/** content -- 问题答案 */
	@NotEmpty(message="config.Issues.content.NotEmpty")
	@Length(max=1000,message="config.Issues.content.Length")
	private String content;

	/** solve_count -- 解决次数 */
	@NotNull(message="config.Issues.solveCount.NotNull")
	private Integer solveCount;

	/** unsolve_count -- 未解决次数 */
	@NotNull(message="config.Issues.unsolveCount.NotNull")
	private Integer unsolveCount;

	/** is_enable -- 0下架，1上架 */
	@NotNull(message="config.Issues.isEnable.NotNull")
	private Byte isEnable;

    /** createdby --  */
	@Length(max=20,message="config.Issues.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.Issues.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.Issues.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Short getIuId() {
		return iuId;
	}

	/** 设置 */
	public void setIuId(Short iuId) {
		this.iuId = iuId;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	/** 获取 */
	public Short getIssueTypeId() {
		return issueTypeId;
	}

	/** 设置 */
	public void setIssueTypeId(Short issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	/** 获取问题 */
	public String getTitle() {
		return title;
	}

	/** 设置问题 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Byte getIsSolve() {
		return isSolve;
	}

	public void setIsSolve(Byte isSolve) {
		this.isSolve = isSolve;
	}

	/** 获取问题答案 */
	public String getContent() {
		return content;
	}

	/** 设置问题答案 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/** 获取解决次数 */
	public Integer getSolveCount() {
		return solveCount;
	}

	/** 设置解决次数 */
	public void setSolveCount(Integer solveCount) {
		this.solveCount = solveCount;
	}

	/** 获取未解决次数 */
	public Integer getUnsolveCount() {
		return unsolveCount;
	}

	/** 设置未解决次数 */
	public void setUnsolveCount(Integer unsolveCount) {
		this.unsolveCount = unsolveCount;
	}

	/** 获取0下架，1上架 */
	public Byte getIsEnable() {
		return isEnable;
	}

	/** 设置0下架，1上架 */
	public void setIsEnable(Byte isEnable) {
		this.isEnable = isEnable;
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
		IssuesExt other = (IssuesExt) that;
		return (this.getIuId() == null ? other.getIuId() == null : this.getIuId().equals(other.getIuId()))
			&& (this.getIssueTypeId() == null ? other.getIssueTypeId() == null : this.getIssueTypeId().equals(other.getIssueTypeId()))
			&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
			&& (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
			&& (this.getSolveCount() == null ? other.getSolveCount() == null : this.getSolveCount().equals(other.getSolveCount()))
			&& (this.getUnsolveCount() == null ? other.getUnsolveCount() == null : this.getUnsolveCount().equals(other.getUnsolveCount()))
			&& (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
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
		result = prime * result + ((getIuId() == null) ? 0 : getIuId().hashCode());
		result = prime * result + ((getIssueTypeId() == null) ? 0 : getIssueTypeId().hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
		result = prime * result + ((getSolveCount() == null) ? 0 : getSolveCount().hashCode());
		result = prime * result + ((getUnsolveCount() == null) ? 0 : getUnsolveCount().hashCode());
		result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}