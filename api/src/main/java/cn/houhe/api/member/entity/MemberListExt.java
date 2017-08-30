package cn.houhe.api.member.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类 - 表：member
 * @since 2017-03-30 10:12:39
 */
@Alias("MemberListExt")
public class MemberListExt implements Serializable {
	/** memid -- 主键id */
	private Integer memid;

	/** level_id -- 信用等级id */
	private Short levelId;

	/** realname -- 真实姓名 */
	private String realname;

	/** mobileno -- 手机号 */
	private String mobileno;

	/** createdon -- 创建时间 */
	private Date createdon;

	/** invitecode -- 邀请码 */
	private String invitecode;

	/** apply_state -- 授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	private Byte applyState;

	/** apply_state -- 贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	private Byte loanState;

	private int page;
	private int rows;

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

	/** 获取创建时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getInvitecode() {
		return invitecode;
	}

	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}

	/** 获取授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public Byte getApplyState() {
		return applyState;
	}

	/** 设置授信申请审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public void setApplyState(Byte applyState) {
		this.applyState = applyState;
	}

	/** 获取贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public Byte getLoanState() {
		return loanState;
	}

	/** 设置贷款审核状态（0填写资料申请中1填写完资料初审中2初审通过3初审不通过4终审通过5终审不通过） */
	public void setLoanState(Byte loanState) {
		this.loanState = loanState;
	}

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
}