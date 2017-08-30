package cn.interheart;

import cn.houhe.api.common.liandong.SendSmsService;
import cn.houhe.api.loan.service.RepaymentsPlanExtService;
import cn.houhe.api.log.service.MessageSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
@ImportResource(locations = "classpath*:config.properties")
public class LiandongSendSmsTest {
    @Autowired
    MessageSmsService messageSmsService;
    @Autowired
    RepaymentsPlanExtService repaymentsPlanExtService;
    @Test
    public  void  SendTest()
    {
       Map<String,String> map= SendSmsService.SendMsg("尊敬的用户你好，此信息为通道测试短信，如有打扰，请谅解。","13827422321","23561566");
    }
    @Test
    public  void  SendDbTest()
    {
        messageSmsService.SendSms("尊敬的用户你好，此信息为通道测试短信，如有打扰，请谅解。","13827422321",88,0,10);
    }
    @Test
    public  void  SendRemainderSms()
    {
        repaymentsPlanExtService.sendRemainderMsg();
    }

}
