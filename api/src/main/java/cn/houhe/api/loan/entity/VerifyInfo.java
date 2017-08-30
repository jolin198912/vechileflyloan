package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;

/**
 * 实体类 - 表：verify_info
 * @since 2017-05-23 11:06:38
 */
@Alias("VerifyInfo")
public class VerifyInfo implements Serializable {
	/** vfi_id -- 主键id */
	private Integer vfiId;

	/** member_id -- 用户id */
	@NotNull(message="loan.VerifyInfo.memberId.NotNull")
	private Integer memberId;

	/** credit_apply_id -- 授信id */
	@NotNull(message="loan.VerifyInfo.creditApplyId.NotNull")
	private Integer creditApplyId;

	/** education_state -- 文化程度 */
	@NotNull(message="loan.VerifyInfo.educationState.NotNull")
	private Byte educationState;

	/** education_time_state -- 教育开始结束时间 */
	@NotNull(message="loan.VerifyInfo.educationTimeState.NotNull")
	private Byte educationTimeState;

	/** couple_name_state -- 配偶姓名 */
	@NotNull(message="loan.VerifyInfo.coupleNameState.NotNull")
	private Byte coupleNameState;

	/** couple_mobile_state -- 配偶手机号 */
	@NotNull(message="loan.VerifyInfo.coupleMobileState.NotNull")
	private Byte coupleMobileState;

	/** couple_idcard_state -- 配偶身份证 */
	@NotNull(message="loan.VerifyInfo.coupleIdcardState.NotNull")
	private Byte coupleIdcardState;

	/** couple_edu_state -- 配偶文化程度 */
	@NotNull(message="loan.VerifyInfo.coupleEduState.NotNull")
	private Byte coupleEduState;

	/** address_state -- 居住地址 */
	@NotNull(message="loan.VerifyInfo.addressState.NotNull")
	private Byte addressState;

	/** createdon --  */
	@NotNull(message="loan.VerifyInfo.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getVfiId() {
		return vfiId;
	}

	/** 设置主键id */
	public void setVfiId(Integer vfiId) {
		this.vfiId = vfiId;
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取授信id */
	public Integer getCreditApplyId() {
		return creditApplyId;
	}

	/** 设置授信id */
	public void setCreditApplyId(Integer creditApplyId) {
		this.creditApplyId = creditApplyId;
	}

	/** 获取文化程度 */
	public Byte getEducationState() {
		return educationState;
	}

	/** 设置文化程度 */
	public void setEducationState(Byte educationState) {
		this.educationState = educationState;
	}

	/** 获取教育开始结束时间 */
	public Byte getEducationTimeState() {
		return educationTimeState;
	}

	/** 设置教育开始结束时间 */
	public void setEducationTimeState(Byte educationTimeState) {
		this.educationTimeState = educationTimeState;
	}

	/** 获取配偶姓名 */
	public Byte getCoupleNameState() {
		return coupleNameState;
	}

	/** 设置配偶姓名 */
	public void setCoupleNameState(Byte coupleNameState) {
		this.coupleNameState = coupleNameState;
	}

	/** 获取配偶手机号 */
	public Byte getCoupleMobileState() {
		return coupleMobileState;
	}

	/** 设置配偶手机号 */
	public void setCoupleMobileState(Byte coupleMobileState) {
		this.coupleMobileState = coupleMobileState;
	}

	/** 获取配偶身份证 */
	public Byte getCoupleIdcardState() {
		return coupleIdcardState;
	}

	/** 设置配偶身份证 */
	public void setCoupleIdcardState(Byte coupleIdcardState) {
		this.coupleIdcardState = coupleIdcardState;
	}

	/** 获取配偶文化程度 */
	public Byte getCoupleEduState() {
		return coupleEduState;
	}

	/** 设置配偶文化程度 */
	public void setCoupleEduState(Byte coupleEduState) {
		this.coupleEduState = coupleEduState;
	}

	/** 获取居住地址 */
	public Byte getAddressState() {
		return addressState;
	}

	/** 设置居住地址 */
	public void setAddressState(Byte addressState) {
		this.addressState = addressState;
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
	
	 * @since 2017-05-23 11:06:38
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
		VerifyInfo other = (VerifyInfo) that;
		return (this.getVfiId() == null ? other.getVfiId() == null : this.getVfiId().equals(other.getVfiId()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getCreditApplyId() == null ? other.getCreditApplyId() == null : this.getCreditApplyId().equals(other.getCreditApplyId()))
			&& (this.getEducationState() == null ? other.getEducationState() == null : this.getEducationState().equals(other.getEducationState()))
			&& (this.getEducationTimeState() == null ? other.getEducationTimeState() == null : this.getEducationTimeState().equals(other.getEducationTimeState()))
			&& (this.getCoupleNameState() == null ? other.getCoupleNameState() == null : this.getCoupleNameState().equals(other.getCoupleNameState()))
			&& (this.getCoupleMobileState() == null ? other.getCoupleMobileState() == null : this.getCoupleMobileState().equals(other.getCoupleMobileState()))
			&& (this.getCoupleIdcardState() == null ? other.getCoupleIdcardState() == null : this.getCoupleIdcardState().equals(other.getCoupleIdcardState()))
			&& (this.getCoupleEduState() == null ? other.getCoupleEduState() == null : this.getCoupleEduState().equals(other.getCoupleEduState()))
			&& (this.getAddressState() == null ? other.getAddressState() == null : this.getAddressState().equals(other.getAddressState()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-05-23 11:06:38
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getVfiId() == null) ? 0 : getVfiId().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getCreditApplyId() == null) ? 0 : getCreditApplyId().hashCode());
		result = prime * result + ((getEducationState() == null) ? 0 : getEducationState().hashCode());
		result = prime * result + ((getEducationTimeState() == null) ? 0 : getEducationTimeState().hashCode());
		result = prime * result + ((getCoupleNameState() == null) ? 0 : getCoupleNameState().hashCode());
		result = prime * result + ((getCoupleMobileState() == null) ? 0 : getCoupleMobileState().hashCode());
		result = prime * result + ((getCoupleIdcardState() == null) ? 0 : getCoupleIdcardState().hashCode());
		result = prime * result + ((getCoupleEduState() == null) ? 0 : getCoupleEduState().hashCode());
		result = prime * result + ((getAddressState() == null) ? 0 : getAddressState().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}