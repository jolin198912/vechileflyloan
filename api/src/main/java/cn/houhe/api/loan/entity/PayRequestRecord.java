package cn.houhe.api.loan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：pay_request_record
 * @since 2017-05-03 15:31:46
 */
@Alias("PayRequestRecord")
public class PayRequestRecord implements Serializable {
	/** pr_id --  */
	private Integer prId;

	/** busines_code -- 请求业务代码 */
	@Length(max=20,message="loan.PayRequestRecord.businesCode.Length")
	private String businesCode;

	/** object_id -- 用户表用户id、贷款表id、还款计划表id */
	@NotEmpty(message="loan.PayRequestRecord.objectId.NotEmpty")
	@Length(max=50,message="loan.PayRequestRecord.objectId.Length")
	private String objectId;

	/** object_type -- 0认证，1放款，2收款 */
	@NotNull(message="loan.PayRequestRecord.objectType.NotNull")
	private Byte objectType;

	/** amount -- 金额 */
	@NotNull(message="loan.PayRequestRecord.amount.NotNull")
	private Integer amount;

	/** status -- 0提交请求，1请求处理成功，2请求处理结果需要查询确认，3、请求不能处理 */
	@NotNull(message="loan.PayRequestRecord.status.NotNull")
	private Byte status;

	/** request_param -- 打款请求参数 */
	@NotEmpty(message="loan.PayRequestRecord.requestParam.NotEmpty")
	@Length(max=5000,message="loan.PayRequestRecord.requestParam.Length")
	private String requestParam;

	/** request_date -- 请求发起时间 */
	@NotNull(message="loan.PayRequestRecord.requestDate.NotNull")
	private Date requestDate;

	/** flownumber -- 请求流水表 */
	@Length(max=36,message="loan.PayRequestRecord.flownumber.Length")
	private String flownumber;

	/** response_param -- 打款请求返回参数 */
	@Length(max=5000,message="loan.PayRequestRecord.responseParam.Length")
	private String responseParam;

	/** response_date -- 请求返回时间 */
	@NotNull(message="loan.PayRequestRecord.responseDate.NotNull")
	private Date responseDate;

	/** result_msg -- 打款结果信息 */
	@Length(max=100,message="loan.PayRequestRecord.resultMsg.Length")
	private String resultMsg;

	/** result_code -- 打款结果码 */
	@Length(max=20,message="loan.PayRequestRecord.resultCode.Length")
	private String resultCode;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getPrId() {
		return prId;
	}

	/** 设置 */
	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	/** 获取请求业务代码 */
	public String getBusinesCode() {
		return businesCode;
	}

	/** 设置请求业务代码 */
	public void setBusinesCode(String businesCode) {
		this.businesCode = businesCode == null ? null : businesCode.trim();
	}

	/** 获取用户表用户id、贷款表id、还款计划表id */
	public String getObjectId() {
		return objectId;
	}

	/** 设置用户表用户id、贷款表id、还款计划表id */
	public void setObjectId(String objectId) {
		this.objectId = objectId == null ? null : objectId.trim();
	}

	/** 获取0认证，1放款，2收款 */
	public Byte getObjectType() {
		return objectType;
	}

	/** 设置0认证，1放款，2收款 */
	public void setObjectType(Byte objectType) {
		this.objectType = objectType;
	}

	/** 获取金额 */
	public Integer getAmount() {
		return amount;
	}

	/** 设置金额 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/** 获取0提交请求，1请求处理成功，2请求处理结果需要查询确认，3、请求不能处理 */
	public Byte getStatus() {
		return status;
	}

	/** 设置0提交请求，1请求处理成功，2请求处理结果需要查询确认，3、请求不能处理 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/** 获取打款请求参数 */
	public String getRequestParam() {
		return requestParam;
	}

	/** 设置打款请求参数 */
	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam == null ? null : requestParam.trim();
	}

	/** 获取请求发起时间 */
	public Date getRequestDate() {
		return requestDate;
	}

	/** 设置请求发起时间 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/** 获取请求流水表 */
	public String getFlownumber() {
		return flownumber;
	}

	/** 设置请求流水表 */
	public void setFlownumber(String flownumber) {
		this.flownumber = flownumber == null ? null : flownumber.trim();
	}

	/** 获取打款请求返回参数 */
	public String getResponseParam() {
		return responseParam;
	}

	/** 设置打款请求返回参数 */
	public void setResponseParam(String responseParam) {
		this.responseParam = responseParam == null ? null : responseParam.trim();
	}

	/** 获取请求返回时间 */
	public Date getResponseDate() {
		return responseDate;
	}

	/** 设置请求返回时间 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	/** 获取打款结果信息 */
	public String getResultMsg() {
		return resultMsg;
	}

	/** 设置打款结果信息 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg == null ? null : resultMsg.trim();
	}

	/** 获取打款结果码 */
	public String getResultCode() {
		return resultCode;
	}

	/** 设置打款结果码 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode == null ? null : resultCode.trim();
	}

	/**
	
	 * @since 2017-05-03 15:31:46
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
		PayRequestRecord other = (PayRequestRecord) that;
		return (this.getPrId() == null ? other.getPrId() == null : this.getPrId().equals(other.getPrId()))
			&& (this.getBusinesCode() == null ? other.getBusinesCode() == null : this.getBusinesCode().equals(other.getBusinesCode()))
			&& (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
			&& (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
			&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
			&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
			&& (this.getRequestParam() == null ? other.getRequestParam() == null : this.getRequestParam().equals(other.getRequestParam()))
			&& (this.getRequestDate() == null ? other.getRequestDate() == null : this.getRequestDate().equals(other.getRequestDate()))
			&& (this.getFlownumber() == null ? other.getFlownumber() == null : this.getFlownumber().equals(other.getFlownumber()))
			&& (this.getResponseParam() == null ? other.getResponseParam() == null : this.getResponseParam().equals(other.getResponseParam()))
			&& (this.getResponseDate() == null ? other.getResponseDate() == null : this.getResponseDate().equals(other.getResponseDate()))
			&& (this.getResultMsg() == null ? other.getResultMsg() == null : this.getResultMsg().equals(other.getResultMsg()))
			&& (this.getResultCode() == null ? other.getResultCode() == null : this.getResultCode().equals(other.getResultCode()));
	}

	/**
	
	 * @since 2017-05-03 15:31:46
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPrId() == null) ? 0 : getPrId().hashCode());
		result = prime * result + ((getBusinesCode() == null) ? 0 : getBusinesCode().hashCode());
		result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
		result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getRequestParam() == null) ? 0 : getRequestParam().hashCode());
		result = prime * result + ((getRequestDate() == null) ? 0 : getRequestDate().hashCode());
		result = prime * result + ((getFlownumber() == null) ? 0 : getFlownumber().hashCode());
		result = prime * result + ((getResponseParam() == null) ? 0 : getResponseParam().hashCode());
		result = prime * result + ((getResponseDate() == null) ? 0 : getResponseDate().hashCode());
		result = prime * result + ((getResultMsg() == null) ? 0 : getResultMsg().hashCode());
		result = prime * result + ((getResultCode() == null) ? 0 : getResultCode().hashCode());
		return result;
	}
}