package cn.interheart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by think on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
public class QuartzTest extends AbstractJUnit4SpringContextTests{
    @Test
    public void testS() throws InterruptedException {
        /*Scheduler schedule = (Scheduler) applicationContext.getBean("schedulerFactoryBean");
        ScheduleJob job = new ScheduleJob();
        job.setClassPath("cn.interheart.TestJob.test()");
        job.setJobName("test");
        job.setJobGroup("test");
        job.setCronExpression("* *//*4 * * * ?");
        QuartzManager.addJob(schedule, job, new JobListenerSupport() {
            @Override
            public String getName() {
                return "test listener";
            }
        });
        Thread.sleep(100000);*/
    }
}
