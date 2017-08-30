package cn.houhe.api.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：remainder
 * @since 2017-04-25 16:44:11
 */
@Alias("Remainder")
public class Remainder implements Serializable {
	/** rmd_id -- 主键 */
	private Integer rmdId;

	/** user_mobile -- 贷款人手机 */
	@Length(max=50,message="loan.Remainder.userMobile.Length")
	private String userMobile;

	/** username -- 贷款人姓名 */
	@Length(max=50,message="loan.Remainder.username.Length")
	private String username;

	/** member_id -- 用户id */
	@NotNull(message="loan.Remainder.memberId.NotNull")
	private Integer memberId;

	/** repayments_plan_id -- 还款计划主键 */
	@NotNull(message="loan.Remainder.repaymentsPlanId.NotNull")
	private Integer repaymentsPlanId;

	/** loan_record_id -- 贷款id */
	@NotNull(message="loan.Remainder.loanRecordId.NotNull")
	private Integer loanRecordId;

	/** type -- (0,系统催款，1后台催款) */
	@NotNull(message="loan.Remainder.type.NotNull")
	private Byte type;

	/** contact_truth -- 联系人真实性（0真实1虚假） */
	@NotNull(message="loan.Remainder.contactTruth.NotNull")
	private Byte contactTruth;

	/** contact_has_negative -- 是否有第三方负面信息0没有1有 */
	@NotNull(message="loan.Remainder.contactHasNegative.NotNull")
	private Byte contactHasNegative;

	/** remainder_id -- 催款人id */
	@NotNull(message="loan.Remainder.remainderId.NotNull")
	private Integer remainderId;

	/** remainder -- 催款人 */
	@Length(max=30,message="loan.Remainder.remainder.Length")
	private String remainder;

	/** remaind_object -- 催收对象（0本人1联系人） */
	private Byte remaindObject;

	/** remaind_name -- 催收对象名字 */
	@Length(max=20,message="loan.Remainder.remaindName.Length")
	private String remaindName;

	/** call_state -- 接通情况（接通,关机，停机等） */
	@Length(max=10,message="loan.Remainder.callState.Length")
	private String callState;

	/** attitude -- 用户态度（积极配合,良好,一般等） */
	@Length(max=10,message="loan.Remainder.attitude.Length")
	private String attitude;

	/** link_attitude -- 联系人态度 */
	@Length(max=10,message="loan.Remainder.linkAttitude.Length")
	private String linkAttitude;

	/** debit_desire -- 还款意愿（承诺还款等） */
	@Length(max=10,message="loan.Remainder.debitDesire.Length")
	private String debitDesire;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	/** promise_debit_date -- 承诺还款日期 */
	private Date promiseDebitDate;

	/** reason -- 拖欠原因 */
	@Length(max=50,message="loan.Remainder.reason.Length")
	private String reason;

	/** remark -- 备注 */
	@Length(max=100,message="loan.Remainder.remark.Length")
	private String remark;

	/** createdon -- 催款时间 */
	@NotNull(message="loan.Remainder.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取主键 */
	public Integer getRmdId() {
		return rmdId;
	}

	/** 设置主键 */
	public void setRmdId(Integer rmdId) {
		this.rmdId = rmdId;
	}

	/** 获取贷款人手机 */
	public String getUserMobile() {
		return userMobile;
	}

	/** 设置贷款人手机 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/** 获取贷款人姓名 */
	public String getUsername() {
		return username;
	}

	/** 设置贷款人姓名 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取还款计划主键 */
	public Integer getRepaymentsPlanId() {
		return repaymentsPlanId;
	}

	/** 设置还款计划主键 */
	public void setRepaymentsPlanId(Integer repaymentsPlanId) {
		this.repaymentsPlanId = repaymentsPlanId;
	}

	/** 获取贷款id */
	public Integer getLoanRecordId() {
		return loanRecordId;
	}

	/** 设置贷款id */
	public void setLoanRecordId(Integer loanRecordId) {
		this.loanRecordId = loanRecordId;
	}

	/** 获取(0,系统催款，1后台催款) */
	public Byte getType() {
		return type;
	}

	/** 设置(0,系统催款，1后台催款) */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取联系人真实性（0真实1虚假） */
	public Byte getContactTruth() {
		return contactTruth;
	}

	/** 设置联系人真实性（0真实1虚假） */
	public void setContactTruth(Byte contactTruth) {
		this.contactTruth = contactTruth;
	}

	/** 获取是否有第三方负面信息0没有1有 */
	public Byte getContactHasNegative() {
		return contactHasNegative;
	}

	/** 设置是否有第三方负面信息0没有1有 */
	public void setContactHasNegative(Byte contactHasNegative) {
		this.contactHasNegative = contactHasNegative;
	}

	/** 获取催款人id */
	public Integer getRemainderId() {
		return remainderId;
	}

	/** 设置催款人id */
	public void setRemainderId(Integer remainderId) {
		this.remainderId = remainderId;
	}

	/** 获取催款人 */
	public String getRemainder() {
		return remainder;
	}

	/** 设置催款人 */
	public void setRemainder(String remainder) {
		this.remainder = remainder == null ? null : remainder.trim();
	}

	/** 获取催收对象（0本人1联系人） */
	public Byte getRemaindObject() {
		return remaindObject;
	}

	/** 设置催收对象（0本人1联系人） */
	public void setRemaindObject(Byte remaindObject) {
		this.remaindObject = remaindObject;
	}

	/** 获取催收对象名字 */
	public String getRemaindName() {
		return remaindName;
	}

	/** 设置催收对象名字 */
	public void setRemaindName(String remaindName) {
		this.remaindName = remaindName == null ? null : remaindName.trim();
	}

	/** 获取接通情况（接通,关机，停机等） */
	public String getCallState() {
		return callState;
	}

	/** 设置接通情况（接通,关机，停机等） */
	public void setCallState(String callState) {
		this.callState = callState == null ? null : callState.trim();
	}

	/** 获取用户态度（积极配合,良好,一般等） */
	public String getAttitude() {
		return attitude;
	}

	/** 设置用户态度（积极配合,良好,一般等） */
	public void setAttitude(String attitude) {
		this.attitude = attitude == null ? null : attitude.trim();
	}

	/** 获取联系人态度 */
	public String getLinkAttitude() {
		return linkAttitude;
	}

	/** 设置联系人态度 */
	public void setLinkAttitude(String linkAttitude) {
		this.linkAttitude = linkAttitude == null ? null : linkAttitude.trim();
	}

	/** 获取还款意愿（承诺还款等） */
	public String getDebitDesire() {
		return debitDesire;
	}

	/** 设置还款意愿（承诺还款等） */
	public void setDebitDesire(String debitDesire) {
		this.debitDesire = debitDesire == null ? null : debitDesire.trim();
	}

	/** 获取承诺还款日期 */
	public Date getPromiseDebitDate() {
		return promiseDebitDate;
	}

	/** 设置承诺还款日期 */
	public void setPromiseDebitDate(Date promiseDebitDate) {
		this.promiseDebitDate = promiseDebitDate;
	}

	/** 获取拖欠原因 */
	public String getReason() {
		return reason;
	}

	/** 设置拖欠原因 */
	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取催款时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置催款时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-04-25 16:44:11
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
		Remainder other = (Remainder) that;
		return (this.getRmdId() == null ? other.getRmdId() == null : this.getRmdId().equals(other.getRmdId()))
			&& (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
			&& (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getRepaymentsPlanId() == null ? other.getRepaymentsPlanId() == null : this.getRepaymentsPlanId().equals(other.getRepaymentsPlanId()))
			&& (this.getLoanRecordId() == null ? other.getLoanRecordId() == null : this.getLoanRecordId().equals(other.getLoanRecordId()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getContactTruth() == null ? other.getContactTruth() == null : this.getContactTruth().equals(other.getContactTruth()))
			&& (this.getContactHasNegative() == null ? other.getContactHasNegative() == null : this.getContactHasNegative().equals(other.getContactHasNegative()))
			&& (this.getRemainderId() == null ? other.getRemainderId() == null : this.getRemainderId().equals(other.getRemainderId()))
			&& (this.getRemainder() == null ? other.getRemainder() == null : this.getRemainder().equals(other.getRemainder()))
			&& (this.getRemaindObject() == null ? other.getRemaindObject() == null : this.getRemaindObject().equals(other.getRemaindObject()))
			&& (this.getRemaindName() == null ? other.getRemaindName() == null : this.getRemaindName().equals(other.getRemaindName()))
			&& (this.getCallState() == null ? other.getCallState() == null : this.getCallState().equals(other.getCallState()))
			&& (this.getAttitude() == null ? other.getAttitude() == null : this.getAttitude().equals(other.getAttitude()))
			&& (this.getLinkAttitude() == null ? other.getLinkAttitude() == null : this.getLinkAttitude().equals(other.getLinkAttitude()))
			&& (this.getDebitDesire() == null ? other.getDebitDesire() == null : this.getDebitDesire().equals(other.getDebitDesire()))
			&& (this.getPromiseDebitDate() == null ? other.getPromiseDebitDate() == null : this.getPromiseDebitDate().equals(other.getPromiseDebitDate()))
			&& (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-04-25 16:44:11
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRmdId() == null) ? 0 : getRmdId().hashCode());
		result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getRepaymentsPlanId() == null) ? 0 : getRepaymentsPlanId().hashCode());
		result = prime * result + ((getLoanRecordId() == null) ? 0 : getLoanRecordId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getContactTruth() == null) ? 0 : getContactTruth().hashCode());
		result = prime * result + ((getContactHasNegative() == null) ? 0 : getContactHasNegative().hashCode());
		result = prime * result + ((getRemainderId() == null) ? 0 : getRemainderId().hashCode());
		result = prime * result + ((getRemainder() == null) ? 0 : getRemainder().hashCode());
		result = prime * result + ((getRemaindObject() == null) ? 0 : getRemaindObject().hashCode());
		result = prime * result + ((getRemaindName() == null) ? 0 : getRemaindName().hashCode());
		result = prime * result + ((getCallState() == null) ? 0 : getCallState().hashCode());
		result = prime * result + ((getAttitude() == null) ? 0 : getAttitude().hashCode());
		result = prime * result + ((getLinkAttitude() == null) ? 0 : getLinkAttitude().hashCode());
		result = prime * result + ((getDebitDesire() == null) ? 0 : getDebitDesire().hashCode());
		result = prime * result + ((getPromiseDebitDate() == null) ? 0 : getPromiseDebitDate().hashCode());
		result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}