package cn.houhe.api.loan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：credit_children
 * @since 2017-05-12 11:34:16
 */
@Alias("CreditChildren")
public class CreditChildren implements Serializable {
	/** ccd_id --  */
	private Integer ccdId;

	/** birth -- 出生年月 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	/** credit_apply_id -- 授信id */
	@NotNull(message="loan.CreditChildren.creditApplyId.NotNull")
	private Integer creditApplyId;

	/** sex -- 性别0男1女 */
	@NotNull(message="loan.CreditChildren.sex.NotNull")
	private Byte sex;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getCcdId() {
		return ccdId;
	}

	/** 设置 */
	public void setCcdId(Integer ccdId) {
		this.ccdId = ccdId;
	}

	/** 获取出生年月 */
	public Date getBirth() {
		return birth;
	}

	/** 设置出生年月 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/** 获取授信id */
	public Integer getCreditApplyId() {
		return creditApplyId;
	}

	/** 设置授信id */
	public void setCreditApplyId(Integer creditApplyId) {
		this.creditApplyId = creditApplyId;
	}

	/** 获取性别0男1女 */
	public Byte getSex() {
		return sex;
	}

	/** 设置性别0男1女 */
	public void setSex(Byte sex) {
		this.sex = sex;
	}

	/**
	
	 * @since 2017-05-12 11:34:16
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
		CreditChildren other = (CreditChildren) that;
		return (this.getCcdId() == null ? other.getCcdId() == null : this.getCcdId().equals(other.getCcdId()))
			&& (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
			&& (this.getCreditApplyId() == null ? other.getCreditApplyId() == null : this.getCreditApplyId().equals(other.getCreditApplyId()))
			&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()));
	}

	/**
	
	 * @since 2017-05-12 11:34:16
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCcdId() == null) ? 0 : getCcdId().hashCode());
		result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
		result = prime * result + ((getCreditApplyId() == null) ? 0 : getCreditApplyId().hashCode());
		result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
		return result;
	}
}