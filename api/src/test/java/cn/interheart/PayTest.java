package cn.interheart;

import cn.houhe.api.loan.mapper.RepaymentsPlanExtMapper;
import cn.houhe.api.loan.service.PayAndGatherService;
import cn.houhe.api.loan.service.RepaymentsPlanExtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by victorrrr on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
public class PayTest {

    @Resource
    private PayAndGatherService payAndGatherService;
    @Autowired
    private RepaymentsPlanExtService repaymentsPlanExtService;

    @Autowired
    private RepaymentsPlanExtMapper repaymentsPlanExtMapper;

    @Test
    public void testPay() throws Exception {
        payAndGatherService.autoPay();
    }

    @Test
    public void testGather() throws Exception {
        payAndGatherService.autoGather();
    }

    @Test
    public void test1() throws Exception {
        payAndGatherService.autoPayJob();
    }

    @Test
    public void test2() throws Exception {
        payAndGatherService.autoGatherJob();
    }

    @Test
    public void testGenerateRepaymentPlan() throws Exception{
        repaymentsPlanExtService.generateRepaymentPlan();
    }

    @Test
    public void queryPay() throws Exception{
        repaymentsPlanExtService.generateRepaymentPlan();
    }


    @Test
    public void computeLateDebit() throws Exception{
        repaymentsPlanExtService.computeLateDebit();
    }
    @Test
    public void  testrepaymentsPlanExtMapper()
    {
       boolean b=  repaymentsPlanExtMapper.isAllPlanPay(1061);
    }

}
