package cn.houhe.api.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：member
 * @since 2017-05-11 19:05:33
 */
@Alias("Member")
public class Member implements Serializable {
	/** memid -- 主键id */
	private Integer memid;

	/** level_id -- 现金分期信用等级id */
	@NotNull(message="member.Member.levelId.NotNull")
	private Short levelId;

	/** pdl_level_id -- PDL信用等级id */
	@NotNull(message="member.Member.pdlLevelId.NotNull")
	private Short pdlLevelId;

	/** realname -- 真实姓名 */
	@Length(max=50,message="member.Member.realname.Length")
	private String realname;

	/** mobileno -- 手机号 */
	@Length(max=50,message="member.Member.mobileno.Length")
	private String mobileno;

	/** loginpsw -- 登录密码 */
	@Length(max=100,message="member.Member.loginpsw.Length")
	private String loginpsw;

	/** bqs_open_id -- 会员的白骑士openid */
	@Length(max=100,message="member.Member.bqsOpenId.Length")
	private String bqsOpenId;

	/** tradingpsw -- 交易密码 */
	@Length(max=100,message="member.Member.tradingpsw.Length")
	private String tradingpsw;

	/** invitecode -- 邀请注册的邀请码 */
	@Length(max=10,message="member.Member.invitecode.Length")
	private String invitecode;

	/** my_invitecode -- 我的邀请码 */
	@Length(max=10,message="member.Member.myInvitecode.Length")
	private String myInvitecode;

	/** idcardno -- 身份证号 */
	@Length(max=50,message="member.Member.idcardno.Length")
	private String idcardno;

	/** longtimecity -- 长居城市 */
	@Length(max=50,message="member.Member.longtimecity.Length")
	private String longtimecity;

	/** detailaddr -- 详细地址 */
	@Length(max=200,message="member.Member.detailaddr.Length")
	private String detailaddr;

	/** leveleducation -- 文化程度 */
	@Length(max=20,message="member.Member.leveleducation.Length")
	private String leveleducation;

	/** familyincome -- 家庭月收入 */
	@NotNull(message="member.Member.familyincome.NotNull")
	private BigDecimal familyincome;

	/** unitnature -- 单位性质 */
	@Length(max=20,message="member.Member.unitnature.Length")
	private String unitnature;

	/** unitname -- 单位名称 */
	@Length(max=100,message="member.Member.unitname.Length")
	private String unitname;

	/** position -- 职务 */
	@Length(max=50,message="member.Member.position.Length")
	private String position;

	/** nation -- 民族 */
	@Length(max=10,message="member.Member.nation.Length")
	private String nation;

	/** havejobtime -- 参加工作时间 */
	private Date havejobtime;

	/** nowunitinductiontime -- 现单位入职时间 */
	private Date nowunitinductiontime;

	/** maritalstatus -- 婚姻状况(0未婚，1已婚未育，2已婚已育3离异) */
	@NotNull(message="member.Member.maritalstatus.NotNull")
	private Byte maritalstatus;

	/** sex -- 性别0男1女 */
	@NotNull(message="member.Member.sex.NotNull")
	private Byte sex;

	/** birthday -- 生日 */
	private Date birthday;

	/** origin_palce -- 籍贯 */
	@Length(max=20,message="member.Member.originPalce.Length")
	private String originPalce;

	/** is_enable -- 是否禁用0否1是（黑名单） */
	@NotNull(message="member.Member.isEnable.NotNull")
	private Byte isEnable;

	/** childrennumber -- 子女个数 */
	@NotNull(message="member.Member.childrennumber.NotNull")
	private Short childrennumber;

	/** mobilephonebrand -- 手机品牌 */
	@Length(max=20,message="member.Member.mobilephonebrand.Length")
	private String mobilephonebrand;

	/** linkman -- 联系人 */
	@Length(max=50,message="member.Member.linkman.Length")
	private String linkman;

	/** remark -- 备注 */
	@Length(max=30,message="member.Member.remark.Length")
	private String remark;

	/** linkphone -- 联系电话 */
	@Length(max=50,message="member.Member.linkphone.Length")
	private String linkphone;

	/** createdon -- 创建时间 */
	@NotNull(message="member.Member.createdon.NotNull")
	private Date createdon;

	/** modifiedon -- 修改时间 */
	private Date modifiedon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getMemid() {
		return memid;
	}

	/** 设置主键id */
	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	/** 获取现金分期信用等级id */
	public Short getLevelId() {
		return levelId;
	}

	/** 设置现金分期信用等级id */
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	/** 获取PDL信用等级id */
	public Short getPdlLevelId() {
		return pdlLevelId;
	}

	/** 设置PDL信用等级id */
	public void setPdlLevelId(Short pdlLevelId) {
		this.pdlLevelId = pdlLevelId;
	}

	/** 获取真实姓名 */
	public String getRealname() {
		return realname;
	}

	/** 设置真实姓名 */
	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	/** 获取手机号 */
	public String getMobileno() {
		return mobileno;
	}

	/** 设置手机号 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno == null ? null : mobileno.trim();
	}

	/** 获取登录密码 */
	public String getLoginpsw() {
		return loginpsw;
	}

	/** 设置登录密码 */
	public void setLoginpsw(String loginpsw) {
		this.loginpsw = loginpsw == null ? null : loginpsw.trim();
	}

	/** 获取会员的白骑士openid */
	public String getBqsOpenId() {
		return bqsOpenId;
	}

	/** 设置会员的白骑士openid */
	public void setBqsOpenId(String bqsOpenId) {
		this.bqsOpenId = bqsOpenId == null ? null : bqsOpenId.trim();
	}

	/** 获取交易密码 */
	public String getTradingpsw() {
		return tradingpsw;
	}

	/** 设置交易密码 */
	public void setTradingpsw(String tradingpsw) {
		this.tradingpsw = tradingpsw == null ? null : tradingpsw.trim();
	}

	/** 获取邀请注册的邀请码 */
	public String getInvitecode() {
		return invitecode;
	}

	/** 设置邀请注册的邀请码 */
	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode == null ? null : invitecode.trim();
	}

	/** 获取我的邀请码 */
	public String getMyInvitecode() {
		return myInvitecode;
	}

	/** 设置我的邀请码 */
	public void setMyInvitecode(String myInvitecode) {
		this.myInvitecode = myInvitecode == null ? null : myInvitecode.trim();
	}

	/** 获取身份证号 */
	public String getIdcardno() {
		return idcardno;
	}

	/** 设置身份证号 */
	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno == null ? null : idcardno.trim();
	}

	/** 获取长居城市 */
	public String getLongtimecity() {
		return longtimecity;
	}

	/** 设置长居城市 */
	public void setLongtimecity(String longtimecity) {
		this.longtimecity = longtimecity == null ? null : longtimecity.trim();
	}

	/** 获取详细地址 */
	public String getDetailaddr() {
		return detailaddr;
	}

	/** 设置详细地址 */
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr == null ? null : detailaddr.trim();
	}

	/** 获取文化程度 */
	public String getLeveleducation() {
		return leveleducation;
	}

	/** 设置文化程度 */
	public void setLeveleducation(String leveleducation) {
		this.leveleducation = leveleducation == null ? null : leveleducation.trim();
	}

	/** 获取家庭月收入 */
	public BigDecimal getFamilyincome() {
		return familyincome;
	}

	/** 设置家庭月收入 */
	public void setFamilyincome(BigDecimal familyincome) {
		this.familyincome = familyincome;
	}

	/** 获取单位性质 */
	public String getUnitnature() {
		return unitnature;
	}

	/** 设置单位性质 */
	public void setUnitnature(String unitnature) {
		this.unitnature = unitnature == null ? null : unitnature.trim();
	}

	/** 获取单位名称 */
	public String getUnitname() {
		return unitname;
	}

	/** 设置单位名称 */
	public void setUnitname(String unitname) {
		this.unitname = unitname == null ? null : unitname.trim();
	}

	/** 获取职务 */
	public String getPosition() {
		return position;
	}

	/** 设置职务 */
	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	/** 获取民族 */
	public String getNation() {
		return nation;
	}

	/** 设置民族 */
	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	/** 获取参加工作时间 */
	public Date getHavejobtime() {
		return havejobtime;
	}

	/** 设置参加工作时间 */
	public void setHavejobtime(Date havejobtime) {
		this.havejobtime = havejobtime;
	}

	/** 获取现单位入职时间 */
	public Date getNowunitinductiontime() {
		return nowunitinductiontime;
	}

	/** 设置现单位入职时间 */
	public void setNowunitinductiontime(Date nowunitinductiontime) {
		this.nowunitinductiontime = nowunitinductiontime;
	}

	/** 获取婚姻状况(0未婚，1已婚未育，2已婚已育3离异) */
	public Byte getMaritalstatus() {
		return maritalstatus;
	}

	/** 设置婚姻状况(0未婚，1已婚未育，2已婚已育3离异) */
	public void setMaritalstatus(Byte maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	/** 获取性别0男1女 */
	public Byte getSex() {
		return sex;
	}

	/** 设置性别0男1女 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/** 获取生日 */
	public Date getBirthday() {
		return birthday;
	}

	/** 设置生日 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/** 获取籍贯 */
	public String getOriginPalce() {
		return originPalce;
	}

	/** 设置籍贯 */
	public void setOriginPalce(String originPalce) {
		this.originPalce = originPalce == null ? null : originPalce.trim();
	}

	/** 获取是否禁用0否1是（黑名单） */
	public Byte getIsEnable() {
		return isEnable;
	}

	/** 设置是否禁用0否1是（黑名单） */
	public void setIsEnable(Byte isEnable) {
		this.isEnable = isEnable;
	}

	/** 获取子女个数 */
	public Short getChildrennumber() {
		return childrennumber;
	}

	/** 设置子女个数 */
	public void setChildrennumber(Short childrennumber) {
		this.childrennumber = childrennumber;
	}

	/** 获取手机品牌 */
	public String getMobilephonebrand() {
		return mobilephonebrand;
	}

	/** 设置手机品牌 */
	public void setMobilephonebrand(String mobilephonebrand) {
		this.mobilephonebrand = mobilephonebrand == null ? null : mobilephonebrand.trim();
	}

	/** 获取联系人 */
	public String getLinkman() {
		return linkman;
	}

	/** 设置联系人 */
	public void setLinkman(String linkman) {
		this.linkman = linkman == null ? null : linkman.trim();
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取联系电话 */
	public String getLinkphone() {
		return linkphone;
	}

	/** 设置联系电话 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone == null ? null : linkphone.trim();
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
	
	 * @since 2017-05-11 19:05:33
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
		Member other = (Member) that;
		return (this.getMemid() == null ? other.getMemid() == null : this.getMemid().equals(other.getMemid()))
			&& (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
			&& (this.getPdlLevelId() == null ? other.getPdlLevelId() == null : this.getPdlLevelId().equals(other.getPdlLevelId()))
			&& (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
			&& (this.getMobileno() == null ? other.getMobileno() == null : this.getMobileno().equals(other.getMobileno()))
			&& (this.getLoginpsw() == null ? other.getLoginpsw() == null : this.getLoginpsw().equals(other.getLoginpsw()))
			&& (this.getBqsOpenId() == null ? other.getBqsOpenId() == null : this.getBqsOpenId().equals(other.getBqsOpenId()))
			&& (this.getTradingpsw() == null ? other.getTradingpsw() == null : this.getTradingpsw().equals(other.getTradingpsw()))
			&& (this.getInvitecode() == null ? other.getInvitecode() == null : this.getInvitecode().equals(other.getInvitecode()))
			&& (this.getMyInvitecode() == null ? other.getMyInvitecode() == null : this.getMyInvitecode().equals(other.getMyInvitecode()))
			&& (this.getIdcardno() == null ? other.getIdcardno() == null : this.getIdcardno().equals(other.getIdcardno()))
			&& (this.getLongtimecity() == null ? other.getLongtimecity() == null : this.getLongtimecity().equals(other.getLongtimecity()))
			&& (this.getDetailaddr() == null ? other.getDetailaddr() == null : this.getDetailaddr().equals(other.getDetailaddr()))
			&& (this.getLeveleducation() == null ? other.getLeveleducation() == null : this.getLeveleducation().equals(other.getLeveleducation()))
			&& (this.getFamilyincome() == null ? other.getFamilyincome() == null : this.getFamilyincome().equals(other.getFamilyincome()))
			&& (this.getUnitnature() == null ? other.getUnitnature() == null : this.getUnitnature().equals(other.getUnitnature()))
			&& (this.getUnitname() == null ? other.getUnitname() == null : this.getUnitname().equals(other.getUnitname()))
			&& (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
			&& (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
			&& (this.getHavejobtime() == null ? other.getHavejobtime() == null : this.getHavejobtime().equals(other.getHavejobtime()))
			&& (this.getNowunitinductiontime() == null ? other.getNowunitinductiontime() == null : this.getNowunitinductiontime().equals(other.getNowunitinductiontime()))
			&& (this.getMaritalstatus() == null ? other.getMaritalstatus() == null : this.getMaritalstatus().equals(other.getMaritalstatus()))
			&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
			&& (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
			&& (this.getOriginPalce() == null ? other.getOriginPalce() == null : this.getOriginPalce().equals(other.getOriginPalce()))
			&& (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
			&& (this.getChildrennumber() == null ? other.getChildrennumber() == null : this.getChildrennumber().equals(other.getChildrennumber()))
			&& (this.getMobilephonebrand() == null ? other.getMobilephonebrand() == null : this.getMobilephonebrand().equals(other.getMobilephonebrand()))
			&& (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getLinkphone() == null ? other.getLinkphone() == null : this.getLinkphone().equals(other.getLinkphone()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getModifiedon() == null ? other.getModifiedon() == null : this.getModifiedon().equals(other.getModifiedon()));
	}

	/**
	
	 * @since 2017-05-11 19:05:33
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMemid() == null) ? 0 : getMemid().hashCode());
		result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
		result = prime * result + ((getPdlLevelId() == null) ? 0 : getPdlLevelId().hashCode());
		result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
		result = prime * result + ((getMobileno() == null) ? 0 : getMobileno().hashCode());
		result = prime * result + ((getLoginpsw() == null) ? 0 : getLoginpsw().hashCode());
		result = prime * result + ((getBqsOpenId() == null) ? 0 : getBqsOpenId().hashCode());
		result = prime * result + ((getTradingpsw() == null) ? 0 : getTradingpsw().hashCode());
		result = prime * result + ((getInvitecode() == null) ? 0 : getInvitecode().hashCode());
		result = prime * result + ((getMyInvitecode() == null) ? 0 : getMyInvitecode().hashCode());
		result = prime * result + ((getIdcardno() == null) ? 0 : getIdcardno().hashCode());
		result = prime * result + ((getLongtimecity() == null) ? 0 : getLongtimecity().hashCode());
		result = prime * result + ((getDetailaddr() == null) ? 0 : getDetailaddr().hashCode());
		result = prime * result + ((getLeveleducation() == null) ? 0 : getLeveleducation().hashCode());
		result = prime * result + ((getFamilyincome() == null) ? 0 : getFamilyincome().hashCode());
		result = prime * result + ((getUnitnature() == null) ? 0 : getUnitnature().hashCode());
		result = prime * result + ((getUnitname() == null) ? 0 : getUnitname().hashCode());
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
		result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
		result = prime * result + ((getHavejobtime() == null) ? 0 : getHavejobtime().hashCode());
		result = prime * result + ((getNowunitinductiontime() == null) ? 0 : getNowunitinductiontime().hashCode());
		result = prime * result + ((getMaritalstatus() == null) ? 0 : getMaritalstatus().hashCode());
		result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
		result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		result = prime * result + ((getOriginPalce() == null) ? 0 : getOriginPalce().hashCode());
		result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
		result = prime * result + ((getChildrennumber() == null) ? 0 : getChildrennumber().hashCode());
		result = prime * result + ((getMobilephonebrand() == null) ? 0 : getMobilephonebrand().hashCode());
		result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getLinkphone() == null) ? 0 : getLinkphone().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getModifiedon() == null) ? 0 : getModifiedon().hashCode());
		return result;
	}
}