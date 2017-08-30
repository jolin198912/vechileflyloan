package cn.houhe.api.common.job;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Created by think on 2017/4/21.
 * job 执行类
 */
@DisallowConcurrentExecution
public class QuartzStatefulJobFactory implements Job{
    public static final String JOB_NAME_SEPARATOR = ".";
    private static Logger logger = LoggerFactory.getLogger(QuartzStatefulJobFactory.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("任务开始运行");
        ScheduleJob scheduleJob = (ScheduleJob)context.getMergedJobDataMap().get("scheduleJob");
        logger.debug("任务名称 = [" + scheduleJob.getJobName() + "]");
        String classPath = scheduleJob.getClassPath();
        if (StringUtils.isBlank(classPath)){
            logger.warn("任务类为空，忽略");
            return;
        }
        String className = classPath;
        String methodName = "execute";
        if (StringUtils.endsWith(classPath,"()")){
            int lastNameIndex = StringUtils.lastIndexOf(classPath,JOB_NAME_SEPARATOR);
            className = StringUtils.substring(classPath,0,lastNameIndex);
            methodName = StringUtils.substring(classPath,lastNameIndex + 1, StringUtils.indexOf(classPath, "()"));
        }
        try {
            Class jobClass =  ClassUtils.forName(className,ClassUtils.getDefaultClassLoader());
           /* ProxyFactoryBean proxy = new ProxyFactoryBean();
            proxy.setTargetClass(jobClass);
            Object target = proxy.getObject();*/
            Object target = jobClass.newInstance();
            Method method = null;
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(jobClass);
            for (Method method1 : methods) {//按名称找，不支持方法重载
                if (method1.getName().equals(methodName)){
                    method = method1;
                    break;
                }
            }
            Assert.notNull(method,"未找到所指定的方法");
            if (StringUtils.isNoneBlank(scheduleJob.getExecuteParam())) {
                    JSONObject param = JSONObject.parseObject(scheduleJob.getExecuteParam());
                if (jobClass.equals(DefaultJob.class)) {
                    String beanName = param.getString("beanName");
                    Assert.notNull(beanName,"bean name 不能为空");
                    String jobMethodName = param.getString("methodName");
                    Assert.notNull(jobMethodName,"方法名称不能为空");
                    param.remove("beanName");
                    param.remove("methodName");
                    ReflectionUtils.invokeMethod(method, target, beanName, jobMethodName, param.toJSONString());
                } else {
                    ReflectionUtils.invokeMethod(method, target, param.values());
                }
            }else {
                ReflectionUtils.invokeMethod(method, target);
            }
        } catch (Exception e) {
            logger.error("未找到所描述的类",e);
            throw new JobExecutionException(e);
        }
    }
}
