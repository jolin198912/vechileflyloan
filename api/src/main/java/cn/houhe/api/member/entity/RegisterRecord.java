package cn.houhe.api.member.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Alias("RegisterRecord")
public class RegisterRecord implements Serializable {
	/** rr_id --  */
	private Integer rrId;

	/** mobile -- 手机号 */
	@NotEmpty(message="member.RegisterRecord.mobile.NotEmpty")
	@Length(max=15,message="member.RegisterRecord.mobile.Length")
	private String mobile;

	/** id_code -- 发送的验证码 */
	@NotEmpty(message="member.RegisterRecord.idCode.NotEmpty")
	@Length(max=15,message="member.RegisterRecord.idCode.Length")
	private String idCode;

	/** id_code_count -- 发送验证次数 */
	@NotNull(message="member.RegisterRecord.idCodeCount.NotNull")
	private Short idCodeCount;

	/** is_success -- 是否注册成功0否1是 */
	@NotNull(message="member.RegisterRecord.isSuccess.NotNull")
	private Byte isSuccess;

	/** createdon --  */
	@NotNull(message="member.RegisterRecord.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getRrId() {
		return rrId;
	}

	/** 设置 */
	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	/** 获取手机号 */
	public String getMobile() {
		return mobile;
	}

	/** 设置手机号 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/** 获取发送的验证码 */
	public String getIdCode() {
		return idCode;
	}

	/** 设置发送的验证码 */
	public void setIdCode(String idCode) {
		this.idCode = idCode == null ? null : idCode.trim();
	}

	/** 获取发送验证次数 */
	public Short getIdCodeCount() {
		return idCodeCount;
	}

	/** 设置发送验证次数 */
	public void setIdCodeCount(Short idCodeCount) {
		this.idCodeCount = idCodeCount;
	}

	/** 获取是否注册成功0否1是 */
	public Byte getIsSuccess() {
		return isSuccess;
	}

	/** 设置是否注册成功0否1是 */
	public void setIsSuccess(Byte isSuccess) {
		this.isSuccess = isSuccess;
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
	
	 * @since 2017-04-14 11:59:03
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
		RegisterRecord other = (RegisterRecord) that;
		return (this.getRrId() == null ? other.getRrId() == null : this.getRrId().equals(other.getRrId()))
			&& (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
			&& (this.getIdCode() == null ? other.getIdCode() == null : this.getIdCode().equals(other.getIdCode()))
			&& (this.getIdCodeCount() == null ? other.getIdCodeCount() == null : this.getIdCodeCount().equals(other.getIdCodeCount()))
			&& (this.getIsSuccess() == null ? other.getIsSuccess() == null : this.getIsSuccess().equals(other.getIsSuccess()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-04-14 11:59:03
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRrId() == null) ? 0 : getRrId().hashCode());
		result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
		result = prime * result + ((getIdCode() == null) ? 0 : getIdCode().hashCode());
		result = prime * result + ((getIdCodeCount() == null) ? 0 : getIdCodeCount().hashCode());
		result = prime * result + ((getIsSuccess() == null) ? 0 : getIsSuccess().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}