package cn.houhe.api.loan.entity;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 表：schedule_job
 * @since 2017-04-27 16:27:05
 */
@Alias("ScheduleJob")
public class ScheduleJob implements Serializable {
	/** job_id --  */
	private Integer jobId;

	/** class_path -- 类的路径 */
	@NotEmpty(message="loan.ScheduleJob.classPath.NotEmpty")
	@Length(max=100,message="loan.ScheduleJob.classPath.Length")
	private String classPath;

	/** job_name -- 任务名称 */
	@Length(max=50,message="loan.ScheduleJob.jobName.Length")
	private String jobName;

	/** job_group -- 任务分组 */
	@NotEmpty(message="loan.ScheduleJob.jobGroup.NotEmpty")
	@Length(max=50,message="loan.ScheduleJob.jobGroup.Length")
	private String jobGroup;

	/** job_status -- 任务状态 0禁用 1启用 2删除 */
	@NotNull(message="loan.ScheduleJob.jobStatus.NotNull")
	private Byte jobStatus;

	/** run_status -- 执行状态0未执行，1已执行成功，2执行失败 */
	@NotNull(message="loan.ScheduleJob.runStatus.NotNull")
	private Byte runStatus;

	/** cron_expression -- 任务运行时间表达式 */
	@NotEmpty(message="loan.ScheduleJob.cronExpression.NotEmpty")
	@Length(max=100,message="loan.ScheduleJob.cronExpression.Length")
	private String cronExpression;

	/** description -- 任务描述 */
	@NotEmpty(message="loan.ScheduleJob.description.NotEmpty")
	@Length(max=200,message="loan.ScheduleJob.description.Length")
	private String description;

	/** createdon --  */
	@NotNull(message="loan.ScheduleJob.createdon.NotNull")
	private Date createdon;

	/** execute_param -- 任务所需参数 */
	@Length(max=200,message="loan.ScheduleJob.executeParam.Length")
	private String executeParam;

	/** is_repeat -- 是否需要重复执行 */
	@NotNull(message="loan.ScheduleJob.isRepeat.NotNull")
	private Byte isRepeat;

	private static final long serialVersionUID = 1L;

	/** 获取 */
	public Integer getJobId() {
		return jobId;
	}

	/** 设置 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	/** 获取类的路径 */
	public String getClassPath() {
		return classPath;
	}

	/** 设置类的路径 */
	public void setClassPath(String classPath) {
		this.classPath = classPath == null ? null : classPath.trim();
	}

	/** 获取任务名称 */
	public String getJobName() {
		return jobName;
	}

	/** 设置任务名称 */
	public void setJobName(String jobName) {
		this.jobName = jobName == null ? null : jobName.trim();
	}

	/** 获取任务分组 */
	public String getJobGroup() {
		return jobGroup;
	}

	/** 设置任务分组 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup == null ? null : jobGroup.trim();
	}

	/** 获取任务状态 0禁用 1启用 2删除 */
	public Byte getJobStatus() {
		return jobStatus;
	}

	/** 设置任务状态 0禁用 1启用 2删除 */
	public void setJobStatus(Byte jobStatus) {
		this.jobStatus = jobStatus;
	}

	/** 获取执行状态0未执行，1已执行成功，2执行失败 */
	public Byte getRunStatus() {
		return runStatus;
	}

	/** 设置执行状态0未执行，1已执行成功，2执行失败 */
	public void setRunStatus(Byte runStatus) {
		this.runStatus = runStatus;
	}

	/** 获取任务运行时间表达式 */
	public String getCronExpression() {
		return cronExpression;
	}

	/** 设置任务运行时间表达式 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression == null ? null : cronExpression.trim();
	}

	/** 获取任务描述 */
	public String getDescription() {
		return description;
	}

	/** 设置任务描述 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/** 获取 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/** 获取任务所需参数 */
	public String getExecuteParam() {
		return executeParam;
	}

	/** 设置任务所需参数 */
	public void setExecuteParam(String executeParam) {
		this.executeParam = executeParam == null ? null : executeParam.trim();
	}

	/** 获取是否需要重复执行 */
	public Byte getIsRepeat() {
		return isRepeat;
	}

	/** 设置是否需要重复执行 */
	public void setIsRepeat(Byte isRepeat) {
		this.isRepeat = isRepeat;
	}

	/**
	
	 * @since 2017-04-27 16:27:05
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
		ScheduleJob other = (ScheduleJob) that;
		return (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
			&& (this.getClassPath() == null ? other.getClassPath() == null : this.getClassPath().equals(other.getClassPath()))
			&& (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
			&& (this.getJobGroup() == null ? other.getJobGroup() == null : this.getJobGroup().equals(other.getJobGroup()))
			&& (this.getJobStatus() == null ? other.getJobStatus() == null : this.getJobStatus().equals(other.getJobStatus()))
			&& (this.getRunStatus() == null ? other.getRunStatus() == null : this.getRunStatus().equals(other.getRunStatus()))
			&& (this.getCronExpression() == null ? other.getCronExpression() == null : this.getCronExpression().equals(other.getCronExpression()))
			&& (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()))
			&& (this.getExecuteParam() == null ? other.getExecuteParam() == null : this.getExecuteParam().equals(other.getExecuteParam()))
			&& (this.getIsRepeat() == null ? other.getIsRepeat() == null : this.getIsRepeat().equals(other.getIsRepeat()));
	}

	/**
	
	 * @since 2017-04-27 16:27:05
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
		result = prime * result + ((getClassPath() == null) ? 0 : getClassPath().hashCode());
		result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
		result = prime * result + ((getJobGroup() == null) ? 0 : getJobGroup().hashCode());
		result = prime * result + ((getJobStatus() == null) ? 0 : getJobStatus().hashCode());
		result = prime * result + ((getRunStatus() == null) ? 0 : getRunStatus().hashCode());
		result = prime * result + ((getCronExpression() == null) ? 0 : getCronExpression().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		result = prime * result + ((getExecuteParam() == null) ? 0 : getExecuteParam().hashCode());
		result = prime * result + ((getIsRepeat() == null) ? 0 : getIsRepeat().hashCode());
		return result;
	}
}