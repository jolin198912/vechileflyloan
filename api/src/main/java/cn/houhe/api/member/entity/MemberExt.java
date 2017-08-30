package cn.houhe.api.member.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 实体类 - 表：member
 * @since 2017-03-30 10:12:39
 */
@Alias("MemberExt")
public class MemberExt implements Serializable {
	/** memid -- 主键id */
	private Integer memid;

	/** level_id -- 信用等级id */
	private Short levelId;

	/** apply_state -- 授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	private Byte applyState;

	/** realname -- 真实姓名 */
	private String realname;

	/** mobileno -- 手机号 */
	private String mobileno;

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

	/** loginpsw -- 登录密码 */
	private String loginpsw;

	/** tradingpsw -- 交易密码 */
	private String tradingpsw;

	/** invitecode -- 邀请码 */
	private String invitecode;

	/** idcardno -- 身份证号 */
	private String idcardno;

	/** longtimecity -- 长居城市 */
	private String longtimecity;

	/** detailaddr -- 详细地址 */
	private String detailaddr;

	/** leveleducation -- 文化程度 */
	private String leveleducation;

	/** familyincome -- 家庭月收入 */
	private BigDecimal familyincome;

	/** unitnature -- 单位性质 */
	private String unitnature;

	/** unitname -- 单位名称 */
	private String unitname;

	/** position -- 职务 */
	private String position;

	/** havejobtime -- 参加工作时间 */
	private Date havejobtime;

	/** nowunitinductiontime -- 现单位入职时间 */
	private Date nowunitinductiontime;

	/** maritalstatus -- 婚姻状况（0：未婚；1：已婚） */
	private Byte maritalstatus;

	/** childrennumber -- 子女个数 */
	private Short childrennumber;

	/** createdon -- 创建时间 */
	private Date createdon;

	/** url -- 头像 */
	private String url;

	/** tradingpswstatus -- 交易密码状态（0：未设置；1：已设置） */
	private Byte tradingpswstatus;

	/** alias -- 推送设备别名 */
	private String alias;

	/**
	 * 群发标记
	 */
	private  String pushTag;

	/** phoneContacts -- 联系人 */
	private List<PhoneContact> phoneContacts;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getMemid() {
		return memid;
	}

	/** 设置主键id */
	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	/** 获取信用等级id */
	public Short getLevelId() {
		return levelId;
	}

	/** 设置信用等级id */
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	/** 获取授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public Byte getApplyState() {
		return applyState;
	}

	/** 设置授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public void setApplyState(Byte applyState) {
		this.applyState = applyState;
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

	/** 获取交易密码 */
	public String getTradingpsw() {
		return tradingpsw;
	}

	/** 设置交易密码 */
	public void setTradingpsw(String tradingpsw) {
		this.tradingpsw = tradingpsw == null ? null : tradingpsw.trim();
	}

	/** 获取邀请码 */
	public String getInvitecode() {
		return invitecode;
	}

	/** 设置邀请码 */
	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode == null ? null : invitecode.trim();
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

	/** 获取婚姻状况（0：未婚；1：已婚） */
	public Byte getMaritalstatus() {
		return maritalstatus;
	}

	/** 设置婚姻状况（0：未婚；1：已婚） */
	public void setMaritalstatus(Byte maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	/** 获取子女个数 */
	public Short getChildrennumber() {
		return childrennumber;
	}

	/** 设置子女个数 */
	public void setChildrennumber(Short childrennumber) {
		this.childrennumber = childrennumber;
	}

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取头像 */
	public String getUrl() {
		return url;
	}

	/** 设置头像 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/** tradingpswstatus -- 获取交易密码状态（0：未设置；1：已设置） */
	public Byte getTradingpswstatus() {
		return tradingpswstatus;
	}

	/** tradingpswstatus -- 设置交易密码状态（0：未设置；1：已设置） */
	public void setTradingpswstatus(Byte tradingpswstatus) {
		this.tradingpswstatus = tradingpswstatus;
	}

	/** alias -- 获取推送设备别名 */
	public String getAlias() {
		return alias;
	}

	/** alias -- 设置推送设备别名 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPushTag() {
		return pushTag;
	}

	public void setPushTag(String pushTag) {
		this.pushTag = pushTag;
	}

	public List<PhoneContact> getPhoneContacts() {
		return phoneContacts;
	}

	public void setPhoneContacts(List<PhoneContact> phoneContacts) {
		this.phoneContacts = phoneContacts;
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
		MemberExt other = (MemberExt) that;
		return (this.getMemid() == null ? other.getMemid() == null : this.getMemid().equals(other.getMemid()))
			&& (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
			&& (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
			&& (this.getMobileno() == null ? other.getMobileno() == null : this.getMobileno().equals(other.getMobileno()))
			&& (this.getLoginpsw() == null ? other.getLoginpsw() == null : this.getLoginpsw().equals(other.getLoginpsw()))
			&& (this.getTradingpsw() == null ? other.getTradingpsw() == null : this.getTradingpsw().equals(other.getTradingpsw()))
			&& (this.getInvitecode() == null ? other.getInvitecode() == null : this.getInvitecode().equals(other.getInvitecode()))
			&& (this.getIdcardno() == null ? other.getIdcardno() == null : this.getIdcardno().equals(other.getIdcardno()))
			&& (this.getLongtimecity() == null ? other.getLongtimecity() == null : this.getLongtimecity().equals(other.getLongtimecity()))
			&& (this.getDetailaddr() == null ? other.getDetailaddr() == null : this.getDetailaddr().equals(other.getDetailaddr()))
			&& (this.getLeveleducation() == null ? other.getLeveleducation() == null : this.getLeveleducation().equals(other.getLeveleducation()))
			&& (this.getFamilyincome() == null ? other.getFamilyincome() == null : this.getFamilyincome().equals(other.getFamilyincome()))
			&& (this.getUnitnature() == null ? other.getUnitnature() == null : this.getUnitnature().equals(other.getUnitnature()))
			&& (this.getUnitname() == null ? other.getUnitname() == null : this.getUnitname().equals(other.getUnitname()))
			&& (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
			&& (this.getHavejobtime() == null ? other.getHavejobtime() == null : this.getHavejobtime().equals(other.getHavejobtime()))
			&& (this.getNowunitinductiontime() == null ? other.getNowunitinductiontime() == null : this.getNowunitinductiontime().equals(other.getNowunitinductiontime()))
			&& (this.getMaritalstatus() == null ? other.getMaritalstatus() == null : this.getMaritalstatus().equals(other.getMaritalstatus()))
			&& (this.getChildrennumber() == null ? other.getChildrennumber() == null : this.getChildrennumber().equals(other.getChildrennumber()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-03-30 10:12:39
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMemid() == null) ? 0 : getMemid().hashCode());
		result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
		result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
		result = prime * result + ((getMobileno() == null) ? 0 : getMobileno().hashCode());
		result = prime * result + ((getLoginpsw() == null) ? 0 : getLoginpsw().hashCode());
		result = prime * result + ((getTradingpsw() == null) ? 0 : getTradingpsw().hashCode());
		result = prime * result + ((getInvitecode() == null) ? 0 : getInvitecode().hashCode());
		result = prime * result + ((getIdcardno() == null) ? 0 : getIdcardno().hashCode());
		result = prime * result + ((getLongtimecity() == null) ? 0 : getLongtimecity().hashCode());
		result = prime * result + ((getDetailaddr() == null) ? 0 : getDetailaddr().hashCode());
		result = prime * result + ((getLeveleducation() == null) ? 0 : getLeveleducation().hashCode());
		result = prime * result + ((getFamilyincome() == null) ? 0 : getFamilyincome().hashCode());
		result = prime * result + ((getUnitnature() == null) ? 0 : getUnitnature().hashCode());
		result = prime * result + ((getUnitname() == null) ? 0 : getUnitname().hashCode());
		result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
		result = prime * result + ((getHavejobtime() == null) ? 0 : getHavejobtime().hashCode());
		result = prime * result + ((getNowunitinductiontime() == null) ? 0 : getNowunitinductiontime().hashCode());
		result = prime * result + ((getMaritalstatus() == null) ? 0 : getMaritalstatus().hashCode());
		result = prime * result + ((getChildrennumber() == null) ? 0 : getChildrennumber().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}