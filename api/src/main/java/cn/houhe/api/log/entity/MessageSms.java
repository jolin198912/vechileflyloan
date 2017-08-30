package cn.houhe.api.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 实体类 - 表：message_sms
 * @since 2017-05-25 14:44:55
 */
@Alias("MessageSms")
public class MessageSms implements Serializable {
	/** mid --  */
	private Integer mid;

	/** member_id -- 用户id */
	private Integer memberId;

	/** msg_type -- 行为类型（0.系统短信，1用户短信） */
	@NotNull(message="log.MessageSms.msgType.NotNull")
	private Byte msgType;

	/** msg_content_type -- 内容类型（0注册成功，1授信申请通过，2授信申请未通过，3贷款申请通过，4贷款申请未通过，5还款提前通知，6还款成功，7逾期未还，8逾期已还，9结清贷款，10系统通知） */
	@NotNull(message="log.MessageSms.msgContentType.NotNull")
	private Byte msgContentType;

	/** title -- 标题 */
	@NotEmpty(message="log.MessageSms.title.NotEmpty")
	@Length(max=50,message="log.MessageSms.title.Length")
	private String title;

	/** is_send -- 是否发送 */
	@NotNull(message="log.MessageSms.isSend.NotNull")
	private Byte isSend;

	/** content -- 消息内容 */
	@NotEmpty(message="log.MessageSms.content.NotEmpty")
	@Length(max=200,message="log.MessageSms.content.Length")
	private String content;

	/** createdon --  */
	@NotNull(message="log.MessageSms.createdon.NotNull")
	private Date createdon;

	/** remark -- 备注 */
	@Length(max=50,message="log.MessageSms.remark.Length")
	private String remark;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getMid() {
		return mid;
	}

	/** 设置 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}

	/** 获取用户id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置用户id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取行为类型（0.系统短信，1用户短信） */
	public Byte getMsgType() {
		return msgType;
	}

	/** 设置行为类型（0.系统短信，1用户短信） */
	public void setMsgType(Byte msgType) {
		this.msgType = msgType;
	}

	/** 获取内容类型（0注册成功，1授信申请通过，2授信申请未通过，3贷款申请通过，4贷款申请未通过，5还款提前通知，6还款成功，7逾期未还，8逾期已还，9结清贷款，10系统通知） */
	public Byte getMsgContentType() {
		return msgContentType;
	}

	/** 设置内容类型（0注册成功，1授信申请通过，2授信申请未通过，3贷款申请通过，4贷款申请未通过，5还款提前通知，6还款成功，7逾期未还，8逾期已还，9结清贷款，10系统通知） */
	public void setMsgContentType(Byte msgContentType) {
		this.msgContentType = msgContentType;
	}

	/** 获取标题 */
	public String getTitle() {
		return title;
	}

	/** 设置标题 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/** 获取是否发送 */
	public Byte getIsSend() {
		return isSend;
	}

	/** 设置是否发送 */
	public void setIsSend(Byte isSend) {
		this.isSend = isSend;
	}

	/** 获取消息内容 */
	public String getContent() {
		return content;
	}

	/** 设置消息内容 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
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
	
	 * @since 2017-05-25 14:44:55
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
		MessageSms other = (MessageSms) that;
		return (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
			&& (this.getMsgContentType() == null ? other.getMsgContentType() == null : this.getMsgContentType().equals(other.getMsgContentType()))
			&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
			&& (this.getIsSend() == null ? other.getIsSend() == null : this.getIsSend().equals(other.getIsSend()))
			&& (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	
	 * @since 2017-05-25 14:44:55
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());
		result = prime * result + ((getMsgContentType() == null) ? 0 : getMsgContentType().hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((getIsSend() == null) ? 0 : getIsSend().hashCode());
		result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}
}