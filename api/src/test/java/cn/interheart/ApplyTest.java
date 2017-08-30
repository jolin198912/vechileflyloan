package cn.interheart;

import cn.houhe.api.loan.service.CreditApplyExtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
@ImportResource(locations = "classpath*:config.properties")
public class ApplyTest {

    @Autowired
    CreditApplyExtService creditApplyExtService;
    @Test
    public void  TestApprov()
    {
        //Integer caid, Integer pid, String pname, Integer state, Integer limit, String remark
        creditApplyExtService.approve(148,88,"徐鹏",0,0,"ok");
    }
}
