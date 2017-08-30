package cn.houhe.api.config.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：advertisement
 * @since 2017-03-30 10:04:06
 */
@Alias("Advertisement")
public class Advertisement implements Serializable {
	/** ad_id --  */
	private Integer adId;

	/** title -- 广告标题 */
	@NotEmpty(message="config.Advertisement.title.NotEmpty")
	@Length(max=50,message="config.Advertisement.title.Length")
	private String title;

	/** logo -- 广告图片 */
	@NotEmpty(message="config.Advertisement.logo.NotEmpty")
	@Length(max=200,message="config.Advertisement.logo.Length")
	private String logo;

	/** url -- 广告链接 */
	@Length(max=200,message="config.Advertisement.url.Length")
	private String url;

	/** content -- 广告内容 */
	@Length(max=2000,message="config.Advertisement.content.Length")
	private String content;

	/** status -- 广告状态0下架1上架 */
	@NotNull(message="config.Advertisement.status.NotNull")
	private Byte status;

	/** sort -- 排序 */
	@NotNull(message="config.Advertisement.sort.NotNull")
	private Byte sort;

	/** type -- 广告类型（0富文本，1H5链接） */
	@NotNull(message="config.Advertisement.type.NotNull")
	private Byte type;

	/** createdby --  */
	@Length(max=20,message="config.Advertisement.createdby.Length")
	private String createdby;

	/** createdon --  */
	@NotNull(message="config.Advertisement.createdon.NotNull")
	private Date createdon;

	/** modifiedby --  */
	@Length(max=20,message="config.Advertisement.modifiedby.Length")
	private String modifiedby;

	/** modifiedon --  */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getAdId() {
		return adId;
	}

	/** 设置 */
	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	/** 获取广告标题 */
	public String getTitle() {
		return title;
	}

	/** 设置广告标题 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/** 获取广告图片 */
	public String getLogo() {
		return logo;
	}

	/** 设置广告图片 */
	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}

	/** 获取广告链接 */
	public String getUrl() {
		return url;
	}

	/** 设置广告链接 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/** 获取广告内容 */
	public String getContent() {
		return content;
	}

	/** 设置广告内容 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/** 获取广告状态0下架1上架 */
	public Byte getStatus() {
		return status;
	}

	/** 设置广告状态0下架1上架 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/** 获取排序 */
	public Byte getSort() {
		return sort;
	}

	/** 设置排序 */
	public void setSort(Byte sort) {
		this.sort = sort;
	}

	/** 获取广告类型（0富文本，1H5链接） */
	public Byte getType() {
		return type;
	}

	/** 设置广告类型（0富文本，1H5链接） */
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
		Advertisement other = (Advertisement) that;
		return (this.getAdId() == null ? other.getAdId() == null : this.getAdId().equals(other.getAdId()))
			&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
			&& (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
			&& (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
			&& (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
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
		result = prime * result + ((getAdId() == null) ? 0 : getAdId().hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getCreatedby() == null) ? 0 : getCreatedby().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedby() == null) ? 0 : getModifiedby().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}