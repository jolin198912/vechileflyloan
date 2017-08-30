package cn.houhe.api.common.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by think on 2017/4/25.
 */
public class DefaultJobListener extends JobListenerSupport {
    private static Logger logger = LoggerFactory.getLogger(DefaultJobListener.class);
    @Override
    public String getName() {
        return "job listener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        super.jobToBeExecuted(context);
        logger.debug("任务[" + context.getJobDetail().getKey().getName() + "]即将执行.");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        super.jobWasExecuted(context, jobException);
        if (jobException != null){
            logger.debug("任务[" + context.getJobDetail().getKey().getName() + "]执行出错.",jobException);
        }else {
            logger.debug("任务[" + context.getJobDetail().getKey().getName() + "]执行完成.");
        }
    }
}
