package cn.houhe.api.user.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：verify_third_query
 * @since 2017-06-07 10:58:25
 */
@Alias("VerifyThirdQuery")
public class VerifyThirdQuery implements Serializable {
	/** qid --  */
	private Integer qid;

	/** real_name -- 真实姓名 */
	@NotEmpty(message="user.VerifyThirdQuery.realName.NotEmpty")
	@Length(max=30,message="user.VerifyThirdQuery.realName.Length")
	private String realName;

	/** idcard_no -- 身份证号 */
	@NotEmpty(message="user.VerifyThirdQuery.idcardNo.NotEmpty")
	@Length(max=20,message="user.VerifyThirdQuery.idcardNo.Length")
	private String idcardNo;

	/** mobile -- 手机号 */
	@NotEmpty(message="user.VerifyThirdQuery.mobile.NotEmpty")
	@Length(max=15,message="user.VerifyThirdQuery.mobile.Length")
	private String mobile;

	/** userinfo_id -- 系统用户id */
	@NotNull(message="user.VerifyThirdQuery.userinfoId.NotNull")
	private Integer userinfoId;

	/** tongdun -- 同盾查询结果 */
	@NotEmpty(message="user.VerifyThirdQuery.tongdun.NotEmpty")
	@Length(max=50000,message="user.VerifyThirdQuery.tongdun.Length")
	private String tongdun;

	/** baiqishi -- 白骑士查询结果 */
	@NotEmpty(message="user.VerifyThirdQuery.baiqishi.NotEmpty")
	@Length(max=50000,message="user.VerifyThirdQuery.baiqishi.Length")
	private String baiqishi;

	/** bairong -- 百荣查询结果 */
	@NotEmpty(message="user.VerifyThirdQuery.bairong.NotEmpty")
	@Length(max=50000,message="user.VerifyThirdQuery.bairong.Length")
	private String bairong;

	/** createdon --  */
	@NotNull(message="user.VerifyThirdQuery.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getQid() {
		return qid;
	}

	/** 设置 */
	public void setQid(Integer qid) {
		this.qid = qid;
	}

	/** 获取真实姓名 */
	public String getRealName() {
		return realName;
	}

	/** 设置真实姓名 */
	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	/** 获取身份证号 */
	public String getIdcardNo() {
		return idcardNo;
	}

	/** 设置身份证号 */
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo == null ? null : idcardNo.trim();
	}

	/** 获取手机号 */
	public String getMobile() {
		return mobile;
	}

	/** 设置手机号 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/** 获取系统用户id */
	public Integer getUserinfoId() {
		return userinfoId;
	}

	/** 设置系统用户id */
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	/** 获取同盾查询结果 */
	public String getTongdun() {
		return tongdun;
	}

	/** 设置同盾查询结果 */
	public void setTongdun(String tongdun) {
		this.tongdun = tongdun == null ? null : tongdun.trim();
	}

	/** 获取白骑士查询结果 */
	public String getBaiqishi() {
		return baiqishi;
	}

	/** 设置白骑士查询结果 */
	public void setBaiqishi(String baiqishi) {
		this.baiqishi = baiqishi == null ? null : baiqishi.trim();
	}

	/** 获取百荣查询结果 */
	public String getBairong() {
		return bairong;
	}

	/** 设置百荣查询结果 */
	public void setBairong(String bairong) {
		this.bairong = bairong == null ? null : bairong.trim();
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
	
	 * @since 2017-06-07 10:58:25
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
		VerifyThirdQuery other = (VerifyThirdQuery) that;
		return (this.getQid() == null ? other.getQid() == null : this.getQid().equals(other.getQid()))
			&& (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
			&& (this.getIdcardNo() == null ? other.getIdcardNo() == null : this.getIdcardNo().equals(other.getIdcardNo()))
			&& (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
			&& (this.getUserinfoId() == null ? other.getUserinfoId() == null : this.getUserinfoId().equals(other.getUserinfoId()))
			&& (this.getTongdun() == null ? other.getTongdun() == null : this.getTongdun().equals(other.getTongdun()))
			&& (this.getBaiqishi() == null ? other.getBaiqishi() == null : this.getBaiqishi().equals(other.getBaiqishi()))
			&& (this.getBairong() == null ? other.getBairong() == null : this.getBairong().equals(other.getBairong()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-06-07 10:58:25
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getQid() == null) ? 0 : getQid().hashCode());
		result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
		result = prime * result + ((getIdcardNo() == null) ? 0 : getIdcardNo().hashCode());
		result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
		result = prime * result + ((getUserinfoId() == null) ? 0 : getUserinfoId().hashCode());
		result = prime * result + ((getTongdun() == null) ? 0 : getTongdun().hashCode());
		result = prime * result + ((getBaiqishi() == null) ? 0 : getBaiqishi().hashCode());
		result = prime * result + ((getBairong() == null) ? 0 : getBairong().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}