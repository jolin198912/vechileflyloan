package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：verify_third_result
 * @since 2017-05-23 19:42:13
 */
@Alias("VerifyThirdResult")
public class VerifyThirdResult implements Serializable {
	/** vtr_id --  */
	private Integer vtrId;

	/** credit_apply_id -- 征信申请id */
	private Integer creditApplyId;

	/** baiqishi_result -- 白骑士返回结果 */
	@Length(max=50,message="loan.VerifyThirdResult.baiqishiResult.Length")
	private String baiqishiResult;

	/** tongdun_result -- 同盾返回结果 */
	@Length(max=50,message="loan.VerifyThirdResult.tongdunResult.Length")
	private String tongdunResult;

	/** bairong_result -- 百荣返回结果 */
	@Length(max=50,message="loan.VerifyThirdResult.bairongResult.Length")
	private String bairongResult;

	/** createdon --  */
	@NotNull(message="loan.VerifyThirdResult.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getVtrId() {
		return vtrId;
	}

	/** 设置 */
	public void setVtrId(Integer vtrId) {
		this.vtrId = vtrId;
	}

	/** 获取征信申请id */
	public Integer getCreditApplyId() {
		return creditApplyId;
	}

	/** 设置征信申请id */
	public void setCreditApplyId(Integer creditApplyId) {
		this.creditApplyId = creditApplyId;
	}

	/** 获取白骑士返回结果 */
	public String getBaiqishiResult() {
		return baiqishiResult;
	}

	/** 设置白骑士返回结果 */
	public void setBaiqishiResult(String baiqishiResult) {
		this.baiqishiResult = baiqishiResult == null ? null : baiqishiResult.trim();
	}

	/** 获取同盾返回结果 */
	public String getTongdunResult() {
		return tongdunResult;
	}

	/** 设置同盾返回结果 */
	public void setTongdunResult(String tongdunResult) {
		this.tongdunResult = tongdunResult == null ? null : tongdunResult.trim();
	}

	/** 获取百荣返回结果 */
	public String getBairongResult() {
		return bairongResult;
	}

	/** 设置百荣返回结果 */
	public void setBairongResult(String bairongResult) {
		this.bairongResult = bairongResult == null ? null : bairongResult.trim();
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
	
	 * @since 2017-05-23 19:42:13
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
		VerifyThirdResult other = (VerifyThirdResult) that;
		return (this.getVtrId() == null ? other.getVtrId() == null : this.getVtrId().equals(other.getVtrId()))
			&& (this.getCreditApplyId() == null ? other.getCreditApplyId() == null : this.getCreditApplyId().equals(other.getCreditApplyId()))
			&& (this.getBaiqishiResult() == null ? other.getBaiqishiResult() == null : this.getBaiqishiResult().equals(other.getBaiqishiResult()))
			&& (this.getTongdunResult() == null ? other.getTongdunResult() == null : this.getTongdunResult().equals(other.getTongdunResult()))
			&& (this.getBairongResult() == null ? other.getBairongResult() == null : this.getBairongResult().equals(other.getBairongResult()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-05-23 19:42:13
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getVtrId() == null) ? 0 : getVtrId().hashCode());
		result = prime * result + ((getCreditApplyId() == null) ? 0 : getCreditApplyId().hashCode());
		result = prime * result + ((getBaiqishiResult() == null) ? 0 : getBaiqishiResult().hashCode());
		result = prime * result + ((getTongdunResult() == null) ? 0 : getTongdunResult().hashCode());
		result = prime * result + ((getBairongResult() == null) ? 0 : getBairongResult().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}