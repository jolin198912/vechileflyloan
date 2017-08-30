package cn.houhe.api.loan.service;

import cn.com.iotrust.common.ServiceException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.job.QuartzManager;
import cn.houhe.api.loan.entity.ScheduleJob;
import cn.houhe.api.loan.mapper.ScheduleJobMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 业务实现层 - 表：schedule_job
 * @since 2017-04-21 16:35:07
 */
@Service("scheduleJobService")
public class ScheduleJobService implements ApplicationListener<ContextRefreshedEvent>, JobListener, Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private ScheduleJobMapper scheduleJobMapper;

	private static Logger logger = LoggerFactory.getLogger(ScheduleJobService.class);

//	@Value("${job.flag}")
//	private boolean jobFlag = false;

	public Executor executor = Executors.newScheduledThreadPool(10);

	public void insert(ScheduleJob entity) throws ServiceException {
		try {
			scheduleJobMapper.insertSelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void delete(ScheduleJob entity) throws ServiceException {
		try {
			scheduleJobMapper.deleteByPrimaryKey(entity.getJobId());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Transactional
	public void batchDelete(List<Integer> ids) throws ServiceException {
		try {
			for (Integer id : ids) {
				scheduleJobMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void update(ScheduleJob entity) throws ServiceException {
		try {
			scheduleJobMapper.updateByPrimaryKey(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void updateSelective(ScheduleJob entity) throws ServiceException {
		try {
			scheduleJobMapper.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public ScheduleJob findByPrimaryKey(Integer jobId) throws ServiceException {
		try {
			return scheduleJobMapper.selectByPrimaryKey(jobId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public Pager<ScheduleJob> findPage(Criteria<ScheduleJob> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(ScheduleJob.class);
			}
			criteria.pagination(true);
			List<ScheduleJob> list = scheduleJobMapper.selectByCriteria(criteria);
			return new Pager<ScheduleJob>(criteria, list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<ScheduleJob> findAll(Criteria<ScheduleJob> criteria) throws ServiceException {
		try {
			if (criteria == null) {
				 criteria = Criteria.create(ScheduleJob.class);
			}
			criteria.pagination(false);
			return scheduleJobMapper.selectByCriteria(criteria);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}



	public void execute(Runnable job){
		executor.execute(job);
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (Configs.jobFlag) {//开关
			List<ScheduleJob> jobs = scheduleJobMapper.selectByCriteria(Criteria.create(ScheduleJob.class)
					.add(ExpressionFactory.eq("runStatus", 0))
					.add(ExpressionFactory.eq("jobStatus", 1)));
			if (CollectionUtils.isNotEmpty(jobs)) {
				for (ScheduleJob scheduleJob : jobs) {
					final cn.houhe.api.common.job.ScheduleJob job = new cn.houhe.api.common.job.ScheduleJob();
					try {
						BeanUtils.copyProperties(job, scheduleJob);
						QuartzManager.addJob(job, this);
					} catch (Exception e) {
						logger.error("读取任务信息失败", e);
					}
				}
			}
		}
	}

	@Override
	public String getName() {
			return "job listener";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		logger.debug("即将运行job: " + context.getJobDetail().getDescription());
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {

	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		if (jobException != null){
			logger.debug("任务[" + context.getJobDetail().getKey().getName() + "]执行出错.",jobException);
		}else {
			logger.debug("任务[" + context.getJobDetail().getKey().getName() + "]执行完成.");
		}
		JobKey key = context.getJobDetail().getKey();
		List<ScheduleJob> jobList = scheduleJobMapper.selectByCriteria(Criteria.create(ScheduleJob.class)
				.add(ExpressionFactory.eq("jobName",key.getName()))
				.add(ExpressionFactory.eq("jobGroup",key.getGroup())));
		if (CollectionUtils.isNotEmpty(jobList)){
			ScheduleJob j =	jobList.get(0);
			if (j.getIsRepeat().intValue() == 0) {
				if (jobException == null) {
					j.setRunStatus(new Byte("1"));
				} else {
					j.setRunStatus(new Byte("2"));
					logger.error("任务执行失败",jobException);
				}
			}else {
				j.setRunStatus((byte) 0);
			}
			scheduleJobMapper.updateByPrimaryKeySelective(j);
		}
	}
}