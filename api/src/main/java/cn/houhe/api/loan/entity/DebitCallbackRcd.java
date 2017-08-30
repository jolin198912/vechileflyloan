package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：debit_callback_rcd
 * @since 2017-04-27 10:38:09
 */
@Alias("DebitCallbackRcd")
public class DebitCallbackRcd implements Serializable {
	/** dcr_id -- 回调记录id */
	private Integer dcrId;

	/** type -- 类型0放款1还款 */
	@NotNull(message="loan.DebitCallbackRcd.type.NotNull")
	private Byte type;

	/** number -- 还款或放款流水号 */
	@Length(max=50,message="loan.DebitCallbackRcd.number.Length")
	private String number;

	/** object_id -- 贷款id或还款记录id */
	@NotNull(message="loan.DebitCallbackRcd.objectId.NotNull")
	private Integer objectId;

	/** pay_number -- 转账流水号 */
	@Length(max=100,message="loan.DebitCallbackRcd.payNumber.Length")
	private String payNumber;

	/** paytime -- 到账时间 */
	private Date paytime;

	/** status -- 状态0失败1成功2已生成还款计划 */
	@NotNull(message="loan.DebitCallbackRcd.status.NotNull")
	private Byte status;

	/** call_date -- 回调时间 */
	@NotNull(message="loan.DebitCallbackRcd.callDate.NotNull")
	private Date callDate;

	/** paramdata -- 回调参数 */
	@Length(max=1000,message="loan.DebitCallbackRcd.paramdata.Length")
	private String paramdata;

	private static final long serialVersionUID = 1L;

	/** 获取回调记录id */
	public Integer getDcrId() {
		return dcrId;
	}

	/** 设置回调记录id */
	public void setDcrId(Integer dcrId) {
		this.dcrId = dcrId;
	}

	/** 获取类型0放款1还款 */
	public Byte getType() {
		return type;
	}

	/** 设置类型0放款1还款 */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取还款或放款流水号 */
	public String getNumber() {
		return number;
	}

	/** 设置还款或放款流水号 */
	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	/** 获取贷款id或还款记录id */
	public Integer getObjectId() {
		return objectId;
	}

	/** 设置贷款id或还款记录id */
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	/** 获取转账流水号 */
	public String getPayNumber() {
		return payNumber;
	}

	/** 设置转账流水号 */
	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber == null ? null : payNumber.trim();
	}

	/** 获取到账时间 */
	public Date getPaytime() {
		return paytime;
	}

	/** 设置到账时间 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	/** 获取状态0失败1成功2已生成还款计划 */
	public Byte getStatus() {
		return status;
	}

	/** 设置状态0失败1成功2已生成还款计划 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/** 获取回调时间 */
	public Date getCallDate() {
		return callDate;
	}

	/** 设置回调时间 */
	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	/** 获取回调参数 */
	public String getParamdata() {
		return paramdata;
	}

	/** 设置回调参数 */
	public void setParamdata(String paramdata) {
		this.paramdata = paramdata == null ? null : paramdata.trim();
	}

	/**
	
	 * @since 2017-04-27 10:38:09
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
		DebitCallbackRcd other = (DebitCallbackRcd) that;
		return (this.getDcrId() == null ? other.getDcrId() == null : this.getDcrId().equals(other.getDcrId()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
			&& (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
			&& (this.getPayNumber() == null ? other.getPayNumber() == null : this.getPayNumber().equals(other.getPayNumber()))
			&& (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getCallDate() == null ? other.getCallDate() == null : this.getCallDate().equals(other.getCallDate()))
			&& (this.getParamdata() == null ? other.getParamdata() == null : this.getParamdata().equals(other.getParamdata()));
	}

	/**
	
	 * @since 2017-04-27 10:38:09
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDcrId() == null) ? 0 : getDcrId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
		result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
		result = prime * result + ((getPayNumber() == null) ? 0 : getPayNumber().hashCode());
		result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCallDate() == null) ? 0 : getCallDate().hashCode());
		result = prime * result + ((getParamdata() == null) ? 0 : getParamdata().hashCode());
		return result;
	}
}