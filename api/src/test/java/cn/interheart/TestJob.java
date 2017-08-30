package cn.interheart;

import cn.houhe.api.loan.service.CreditApplyExtService;
import cn.houhe.api.loan.service.score.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml", "classpath*:applicationContext.xml"})
public class TestJob {
    public void test(){
        System.out.println("test job. do sth.");
    }

    @Autowired
    private CreditApplyExtService creditApplyExtService;
    @Autowired
    private PhoneScoreDecisioner phoneScoreDecisioner;

    @Test
    public void test1() throws Exception {
        creditApplyExtService.autoApprove("3a64ecf1-366e-4347-ba61-4df986f77e4f",157,106);
    }

    @Test
    public void test2() throws Exception {
        Map<String,Object> scoreParam = new HashMap<>();
        scoreParam.put("name","杨荣");
        scoreParam.put("idcard","320222197511265218");
        scoreParam.put("mobileno","13921193938");
        phoneScoreDecisioner.decisionScore(scoreParam);
    }

    @Test
    public void test3() throws Exception {
        JSONObject reqData = new JSONObject();
        reqData.put("meal", "SpecialList_c");
        reqData.put("id", "370727197902025527");
        reqData.put("name", "蔡丽萍");
        JSONArray cells = new JSONArray();
        cells.add("15806490811");
        reqData.put("cell", cells);
        String portrait_result = new BaiRongApi().getData("BankServer3Api", reqData);
        JSONObject result = JSONObject.parseObject(portrait_result);
        System.out.println(result);
    }

}
