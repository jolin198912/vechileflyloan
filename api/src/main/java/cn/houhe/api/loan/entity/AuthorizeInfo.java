package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：authorize_info
 * @since 2017-04-20 16:50:02
 */
@Alias("AuthorizeInfo")
public class AuthorizeInfo implements Serializable {
	/** ai_id --  */
	private Integer aiId;

	/** member_id -- 用户id */
	@NotNull(message="loan.AuthorizeInfo.memberId.NotNull")
	private Integer memberId;

	/** aliy_authorize_time -- 支付宝授权时间 */
	private Date aliyAuthorizeTime;

	/** credit_authorize_time -- 个人征信授权时间 */
	private Date creditAuthorizeTime;

	/** opertate_authorize_time -- 运营商收取时间 */
	private Date opertateAuthorizeTime;

	/** is_aliy_authorize -- 支付宝是否授权0否1是 */
	@NotNull(message="loan.AuthorizeInfo.isAliyAuthorize.NotNull")
	private Byte isAliyAuthorize;

	/** is_operate_authorize -- 运营商是否授权0否1是 */
	@NotNull(message="loan.AuthorizeInfo.isOperateAuthorize.NotNull")
	private Byte isOperateAuthorize;

	/** is_credit_authorize -- 个人征信是否授权0否1是 */
	@NotNull(message="loan.AuthorizeInfo.isCreditAuthorize.NotNull")
	private Byte isCreditAuthorize;

	/** createdon --  */
	@NotNull(message="loan.AuthorizeInfo.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=30,message="loan.AuthorizeInfo.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getAiId() {
		return aiId;
	}

	/** 设置 */
	public void setAiId(Integer aiId) {
		this.aiId = aiId;
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取支付宝授权时间 */
	public Date getAliyAuthorizeTime() {
		return aliyAuthorizeTime;
	}

	/** 设置支付宝授权时间 */
	public void setAliyAuthorizeTime(Date aliyAuthorizeTime) {
		this.aliyAuthorizeTime = aliyAuthorizeTime;
	}

	/** 获取个人征信授权时间 */
	public Date getCreditAuthorizeTime() {
		return creditAuthorizeTime;
	}

	/** 设置个人征信授权时间 */
	public void setCreditAuthorizeTime(Date creditAuthorizeTime) {
		this.creditAuthorizeTime = creditAuthorizeTime;
	}

	/** 获取运营商收取时间 */
	public Date getOpertateAuthorizeTime() {
		return opertateAuthorizeTime;
	}

	/** 设置运营商收取时间 */
	public void setOpertateAuthorizeTime(Date opertateAuthorizeTime) {
		this.opertateAuthorizeTime = opertateAuthorizeTime;
	}

	/** 获取支付宝是否授权0否1是 */
	public Byte getIsAliyAuthorize() {
		return isAliyAuthorize;
	}

	/** 设置支付宝是否授权0否1是
     * @param isAliyAuthorize*/
	public void setIsAliyAuthorize(Byte isAliyAuthorize) {
		this.isAliyAuthorize = isAliyAuthorize;
	}

	/** 获取运营商是否授权0否1是 */
	public Byte getIsOperateAuthorize() {
		return isOperateAuthorize;
	}

	/** 设置运营商是否授权0否1是 */
	public void setIsOperateAuthorize(Byte isOperateAuthorize) {
		this.isOperateAuthorize = isOperateAuthorize;
	}

	/** 获取个人征信是否授权0否1是 */
	public Byte getIsCreditAuthorize() {
		return isCreditAuthorize;
	}

	/** 设置个人征信是否授权0否1是 */
	public void setIsCreditAuthorize(Byte isCreditAuthorize) {
		this.isCreditAuthorize = isCreditAuthorize;
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	
	 * @since 2017-04-20 16:50:02
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
		AuthorizeInfo other = (AuthorizeInfo) that;
		return (this.getAiId() == null ? other.getAiId() == null : this.getAiId().equals(other.getAiId()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getAliyAuthorizeTime() == null ? other.getAliyAuthorizeTime() == null : this.getAliyAuthorizeTime().equals(other.getAliyAuthorizeTime()))
			&& (this.getCreditAuthorizeTime() == null ? other.getCreditAuthorizeTime() == null : this.getCreditAuthorizeTime().equals(other.getCreditAuthorizeTime()))
			&& (this.getOpertateAuthorizeTime() == null ? other.getOpertateAuthorizeTime() == null : this.getOpertateAuthorizeTime().equals(other.getOpertateAuthorizeTime()))
			&& (this.getIsAliyAuthorize() == null ? other.getIsAliyAuthorize() == null : this.getIsAliyAuthorize().equals(other.getIsAliyAuthorize()))
			&& (this.getIsOperateAuthorize() == null ? other.getIsOperateAuthorize() == null : this.getIsOperateAuthorize().equals(other.getIsOperateAuthorize()))
			&& (this.getIsCreditAuthorize() == null ? other.getIsCreditAuthorize() == null : this.getIsCreditAuthorize().equals(other.getIsCreditAuthorize()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-04-20 16:50:02
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAiId() == null) ? 0 : getAiId().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getAliyAuthorizeTime() == null) ? 0 : getAliyAuthorizeTime().hashCode());
		result = prime * result + ((getCreditAuthorizeTime() == null) ? 0 : getCreditAuthorizeTime().hashCode());
		result = prime * result + ((getOpertateAuthorizeTime() == null) ? 0 : getOpertateAuthorizeTime().hashCode());
		result = prime * result + ((getIsAliyAuthorize() == null) ? 0 : getIsAliyAuthorize().hashCode());
		result = prime * result + ((getIsOperateAuthorize() == null) ? 0 : getIsOperateAuthorize().hashCode());
		result = prime * result + ((getIsCreditAuthorize() == null) ? 0 : getIsCreditAuthorize().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}