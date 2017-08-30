package cn.houhe.api.common.job;

import cn.com.iotrust.common.util.SpringContextHolder;
import org.quartz.*;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * Created by think on 2017/4/21.
 */
public class QuartzManager {

    /**
     * 添加一个定时任务
     *
     * @param sched  调度器
     *
     * @param job 任务
     */
    public static void addJob(Scheduler sched, ScheduleJob job, JobListener listener) {
        try {
            JobDetail jobDetail = JobBuilder.newJob( QuartzStatefulJobFactory.class)
                    .withIdentity(job.getJobName(),job.getJobGroup()).withDescription(job.getDescription()).build();// 任务名，任务组，任务执行类
            jobDetail.getJobDataMap().put("scheduleJob", job);
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

            sched.getListenerManager().addJobListener(listener, KeyMatcher.keyEquals(jobDetail.getKey()));
            sched.scheduleJob(jobDetail,trigger);
        } catch (Exception e) {
            throw new JobScheduleException(e);
        }
    }

    /**
     * @Description: 添加一个定时任务
     *
     * @param job 任务
     *
     * @Title: QuartzManager.java
     */
    public static void addJob(ScheduleJob job, JobListener listener) {
        addJob((Scheduler) SpringContextHolder.getBean("schedulerFactoryBean"),job,listener);
    }






    /**
     * @Description: 移除一个任务
     *
     * @param sched
     *            调度器
     * @param job job
     */
    public static void removeJob(Scheduler sched, ScheduleJob job) {
        try {
            TriggerKey key = TriggerKey.triggerKey(job.getJobName(),job.getJobGroup());
            sched.pauseTrigger(key);// 停止触发器
            sched.unscheduleJob(key);// 移除触发器
            sched.deleteJob(JobKey.jobKey(job.getJobName(),job.getJobGroup()));// 删除任务
        } catch (Exception e) {
            throw new JobScheduleException(e);
        }
    }


}
