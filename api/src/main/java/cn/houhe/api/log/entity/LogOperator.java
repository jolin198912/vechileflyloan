package cn.houhe.api.log.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：log_operator
 * @since 2017-04-10 11:10:03
 */
@Alias("LogOperator")
public class LogOperator implements Serializable {
	/** loid --  */
	private Integer loid;

	/** operator -- 操作人 */
	@Length(max=20,message="log.LogOperator.operator.Length")
	private String operator;

	/** type -- 日志类型(0新增1删除2修改) */
	@NotNull(message="log.LogOperator.type.NotNull")
	private Byte type;

	/** table_name -- 操作表名 */
	@Length(max=20,message="log.LogOperator.tableName.Length")
	private String tableName;

	/** context -- 日志内容 */
	@Length(max=10,message="log.LogOperator.context.Length")
	private String context;

	/** createdon -- 操作时间 */
	@NotNull(message="log.LogOperator.createdon.NotNull")
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getLoid() {
		return loid;
	}

	/** 设置 */
	public void setLoid(Integer loid) {
		this.loid = loid;
	}

	/** 获取操作人 */
	public String getOperator() {
		return operator;
	}

	/** 设置操作人 */
	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	/** 获取日志类型(0新增1删除2修改) */
	public Byte getType() {
		return type;
	}

	/** 设置日志类型(0新增1删除2修改) */
	public void setType(Byte type) {
		this.type = type;
	}

	/** 获取操作表名 */
	public String getTableName() {
		return tableName;
	}

	/** 设置操作表名 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}

	/** 获取日志内容 */
	public String getContext() {
		return context;
	}

	/** 设置日志内容 */
	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}

	/** 获取操作时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置操作时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-04-10 11:10:03
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
		LogOperator other = (LogOperator) that;
		return (this.getLoid() == null ? other.getLoid() == null : this.getLoid().equals(other.getLoid()))
			&& (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
			&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
			&& (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
			&& (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-04-10 11:10:03
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getLoid() == null) ? 0 : getLoid().hashCode());
		result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
		result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}