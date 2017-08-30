package cn.houhe.api.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：member_positioning
 * @since 2017-04-10 11:10:03
 */
@Alias("MemberPositioning")
public class MemberPositioning implements Serializable {
	/** memposid -- 主键id */
	private Integer memposid;

	/** member_id -- 会员id */
	@NotNull(message="log.MemberPositioning.memberId.NotNull")
	private Integer memberId;

	/** latitude --  */
	@NotNull(message="log.MemberPositioning.latitude.NotNull")
	private Double latitude;

	/** longitude --  */
	@NotNull(message="log.MemberPositioning.longitude.NotNull")
	private Double longitude;

	/** detailaddr -- 详细地址 */
	@Length(max=200,message="log.MemberPositioning.detailaddr.Length")
	private String detailaddr;

	/** createdon -- 创建（获取）时间 */
	@NotNull(message="log.MemberPositioning.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getMemposid() {
		return memposid;
	}

	/** 设置主键id */
	public void setMemposid(Integer memposid) {
		this.memposid = memposid;
	}

	/** 获取会员id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置会员id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取 */
	public Double getLatitude() {
		return latitude;
	}

	/** 设置 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/** 获取 */
	public Double getLongitude() {
		return longitude;
	}

	/** 设置 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/** 获取详细地址 */
	public String getDetailaddr() {
		return detailaddr;
	}

	/** 设置详细地址 */
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr == null ? null : detailaddr.trim();
	}

	/** 获取创建（获取）时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建（获取）时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-04-10 11:10:03
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
		MemberPositioning other = (MemberPositioning) that;
		return (this.getMemposid() == null ? other.getMemposid() == null : this.getMemposid().equals(other.getMemposid()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
			&& (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
			&& (this.getDetailaddr() == null ? other.getDetailaddr() == null : this.getDetailaddr().equals(other.getDetailaddr()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-04-10 11:10:03
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMemposid() == null) ? 0 : getMemposid().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
		result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
		result = prime * result + ((getDetailaddr() == null) ? 0 : getDetailaddr().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}