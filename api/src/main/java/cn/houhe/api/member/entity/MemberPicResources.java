package cn.houhe.api.member.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
@Alias("MemberPicResources")
public class MemberPicResources implements Serializable {
	/** memresid -- 主键id */
	private Integer memresid;

	/** member_id -- 会员id */
	@NotNull(message="member.MemberPicResources.memberId.NotNull")
	private Integer memberId;

	/** pictype -- 图片类型（0：头像；1：身份证正面；2身份证反面；3：人脸识别；4：身份证头像） */
	@NotNull(message="member.MemberPicResources.pictype.NotNull")
	private Short pictype;

	/** url -- 图片路径 */
	@Length(max=200,message="member.MemberPicResources.url.Length")
	private String url;

	/** object_type -- 图片来源类型0默认会员1贷款的图片2信用申请的图片 */
	@NotNull(message="member.MemberPicResources.objectType.NotNull")
	private Byte objectType;

	/** object_id -- 贷款id,信用申请id */
	@NotNull(message="member.MemberPicResources.objectId.NotNull")
	private Integer objectId;

	/** remark -- 备注 */
	@Length(max=30,message="member.MemberPicResources.remark.Length")
	private String remark;

	/** createdon -- 创建时间 */
	@NotNull(message="member.MemberPicResources.createdon.NotNull")
	private Date createdon;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getMemresid() {
		return memresid;
	}

	/** 设置主键id */
	public void setMemresid(Integer memresid) {
		this.memresid = memresid;
	}

	/** 获取会员id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置会员id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取图片类型（0：头像；1：身份证正面；2身份证反面；3：人脸识别；4：身份证头像） */
	public Short getPictype() {
		return pictype;
	}

	/** 设置图片类型（0：头像；1：身份证正面；2身份证反面；3：人脸识别；4：身份证头像） */
	public void setPictype(Short pictype) {
		this.pictype = pictype;
	}

	/** 获取图片路径 */
	public String getUrl() {
		return url;
	}

	/** 设置图片路径 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/** 获取图片来源类型0默认会员1贷款的图片2信用申请的图片 */
	public Byte getObjectType() {
		return objectType;
	}

	/** 设置图片来源类型0默认会员1贷款的图片2信用申请的图片 */
	public void setObjectType(Byte objectType) {
		this.objectType = objectType;
	}

	/** 获取贷款id,信用申请id */
	public Integer getObjectId() {
		return objectId;
	}

	/** 设置贷款id,信用申请id */
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
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

	/** 获取修改时间 */
	public Date getModifiedon() {
		return modifiedon;
	}

	/** 设置修改时间 */
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	/**
	
	 * @since 2017-03-30 10:12:39
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
		MemberPicResources other = (MemberPicResources) that;
		return (this.getMemresid() == null ? other.getMemresid() == null : this.getMemresid().equals(other.getMemresid()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getPictype() == null ? other.getPictype() == null : this.getPictype().equals(other.getPictype()))
			&& (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
			&& (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
			&& (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-03-30 10:12:39
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMemresid() == null) ? 0 : getMemresid().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getPictype() == null) ? 0 : getPictype().hashCode());
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
		result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}