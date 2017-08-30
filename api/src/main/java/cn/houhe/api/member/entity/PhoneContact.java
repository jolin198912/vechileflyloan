package cn.houhe.api.member.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：phone_contact
 * @since 2017-05-03 15:07:07
 */
@Alias("PhoneContact")
public class PhoneContact implements Serializable {
	/** pc_id --  */
	private Integer pcId;

	/** member_id -- 会员id */
	@NotNull(message="member.PhoneContact.memberId.NotNull")
	private Integer memberId;

	/** name -- 联系人名字 */
	@Length(max=10,message="member.PhoneContact.name.Length")
	private String name;

	/** mobile -- 手机号码 */
	@Length(max=20,message="member.PhoneContact.mobile.Length")
	private String mobile;

	/** relation -- 关系（父母，兄弟，同事，其他等等） */
	@Length(max=20,message="member.PhoneContact.relation.Length")
	private String relation;

	/** relation_type -- 0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	private Byte relationType;

	/** createdon --  */
	@NotNull(message="member.PhoneContact.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getPcId() {
		return pcId;
	}

	/** 设置 */
	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	/** 获取会员id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置会员id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取联系人名字 */
	public String getName() {
		return name;
	}

	/** 设置联系人名字 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/** 获取手机号码 */
	public String getMobile() {
		return mobile;
	}

	/** 设置手机号码 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/** 获取关系（父母，兄弟，同事，其他等等） */
	public String getRelation() {
		return relation;
	}

	/** 设置关系（父母，兄弟，同事，其他等等） */
	public void setRelation(String relation) {
		this.relation = relation == null ? null : relation.trim();
	}

	/** 获取0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	public Byte getRelationType() {
		return relationType;
	}

	/** 设置0父母1配偶2兄弟姐妹3朋友4同事5其他 */
	public void setRelationType(Byte relationType) {
		this.relationType = relationType;
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-05-03 15:07:07
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
		PhoneContact other = (PhoneContact) that;
		return (this.getPcId() == null ? other.getPcId() == null : this.getPcId().equals(other.getPcId()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
			&& (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
			&& (this.getRelation() == null ? other.getRelation() == null : this.getRelation().equals(other.getRelation()))
			&& (this.getRelationType() == null ? other.getRelationType() == null : this.getRelationType().equals(other.getRelationType()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-05-03 15:07:07
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPcId() == null) ? 0 : getPcId().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
		result = prime * result + ((getRelation() == null) ? 0 : getRelation().hashCode());
		result = prime * result + ((getRelationType() == null) ? 0 : getRelationType().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}