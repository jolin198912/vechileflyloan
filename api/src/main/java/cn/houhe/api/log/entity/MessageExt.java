package cn.houhe.api.log.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：message
 * @since 2017-05-06 15:11:19
 */
@Alias("MessageExt")
public class MessageExt implements Serializable {
	/** mid --  */
	private Integer mid;

	/** member_id -- 用户id */
	private Integer memberId;

	/** msg_type -- 行为类型（0系统推送，1用户推送） */
	@NotNull(message="config.Message.msgType.NotNull")
	private Byte msgType;

	/** msg_content_type -- 内容类型（0注册成功，1授信申请通过，2授信申请未通过，3贷款申请通过，4贷款申请未通过，5还款提前通知，6还款成功，7逾期未还，8逾期已还，9结清贷款，10系统通知） */
	@NotNull(message="config.Message.msgContentType.NotNull")
	private Byte msgContentType;

	/** title -- 标题 */
	@NotEmpty(message="config.Message.title.NotEmpty")
	@Length(max=50,message="config.Message.title.Length")
	private String title;

	/** is_send -- 是否发送 */
	@NotNull(message="config.Message.isSend.NotNull")
	private Byte isSend;

	/** content -- 消息内容 */
	@NotEmpty(message="config.Message.content.NotEmpty")
	@Length(max=100,message="config.Message.content.Length")
	private String content;

	/** createdon --  */
	@NotNull(message="config.Message.createdon.NotNull")
	private Date createdon;

	private int page=1;
	private int rows=20;

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

	/** 获取行为类型（0系统推送，1用户推送） */
	public Byte getMsgType() {
		return msgType;
	}

	/** 设置行为类型（0系统推送，1用户推送） */
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

	/**
	
	 * @since 2017-05-06 15:11:19
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
		MessageExt other = (MessageExt) that;
		return (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
			&& (this.getMsgContentType() == null ? other.getMsgContentType() == null : this.getMsgContentType().equals(other.getMsgContentType()))
			&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
			&& (this.getIsSend() == null ? other.getIsSend() == null : this.getIsSend().equals(other.getIsSend()))
			&& (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-05-06 15:11:19
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
		return result;
	}
}