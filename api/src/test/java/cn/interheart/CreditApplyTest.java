package cn.interheart;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.facade.ConfigFacade;
import cn.houhe.api.loan.entity.RepaymentsPlan;
import cn.houhe.api.loan.mapper.LoanRecordExtMapper;
import cn.houhe.api.loan.service.CreditApplyExtService;
import cn.houhe.api.loan.service.LoanAuditService;
import cn.houhe.api.loan.service.LoanContractService;
import cn.houhe.api.loan.service.RepaymentsPlanService;
import cn.houhe.api.loan.service.score.BaiRongApi;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.common.utils.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import javax.annotation.Resource;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by think on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
@ImportResource(locations = "classpath*:config.properties")
public class CreditApplyTest extends AbstractJUnit4SpringContextTests{
    @Autowired
    CreditApplyExtService creditApplyExtService;

    LoanContractService loanContractService;
    @Autowired
    private LoanRecordExtMapper loanRecordExtMapper;
    @Autowired
    private RepaymentsPlanService repaymentsPlanService;

    @Autowired
    private ConfigFacade configFacade;
    @Test
    public void testS() throws Exception {
        creditApplyExtService.autoApprove("aaaa",108,60);
    }

    @Test
    public void testCreditApplyApprove() throws Exception{
        creditApplyExtService.autoApprove("aaaaaaaa",108,60);
        Thread.sleep(1000000);
    }

    @Test
    public void testUpload() throws Exception{
        System.out.println("upload:    "+AliTools.uploadFileToAli("qzz/20170504","测试合同", IOUtils.readStreamAsByteArray(new URL("https://testapi.fadada.com:8443/api//getdocs.action?app_id=400355&send_app_id=null&v=2.0&timestamp=20170504154115&transaction_id=t21&msg_digest=MTcwRTBEQjVFMUI2MDI1QzY5QzExRUNDNjU3N0RDMUMxOTMxMkRDNg==").openStream())));
    }


    @Test
    public void testSignContract() throws Exception{
        NumberFormat monthFormat = new DecimalFormat("00");
        Map<String,String> param = new HashMap<>();
        param.put("realname", "柯贤明");
        param.put("realname_line", "柯贤明");
        param.put("realname_end", "柯贤明");
        param.put("idcard", "420322199011063319");
        param.put("mobile","");
        param.put("cano","13480751075");
        Calendar calendar = Calendar.getInstance();
        param.put("date", DateFormatUtils.format(new Date(),"yyyy年MM月dd日"));
        param.put("year", String.valueOf(calendar.get(Calendar.YEAR)));
        param.put("day", monthFormat.format(calendar.get(Calendar.DAY_OF_MONTH)));
        param.put("month", monthFormat.format(calendar.get(Calendar.MONTH )+1));
        loanContractService.generateAndSignCreditApplyContract(108,param);
    }

    @Test
    public void testCreditLevel() throws Exception{
        System.out.println(configFacade.judgeLoanLimit(0,406));
    }

    @Test
    public void testCanAutoCredit() throws Exception{
        System.out.println("canAutoCredit: "+configFacade.canAutoCredit(680));
    }


    @Test
    public void testBRSpercial() throws Exception {
        //蔡丽萍	370727197902025527	  15806490811
        //刘嘉	120103199204087324	 13502173737
        JSONObject reqData = new JSONObject();
        reqData.put("name", "蔡丽萍");
        reqData.put("id", "370727197902025527");
        JSONArray cells = new JSONArray();
        cells.add("15806490811");
        reqData.put("cell", cells);
        reqData.put("meal", "SpecialList_c");
        JSONObject specialResult=JSONObject.parseObject(new BaiRongApi().getData("BankServer3Api",reqData));
        logger.debug("specialResult:"+specialResult);
    }
    @Test
    public  void  testgetFine()
    {
       BigDecimal b= loanRecordExtMapper.getFine(114);
    }

    @Test
    public  void  testGetPayPlanInfo()
    {
        Criteria<RepaymentsPlan> criteria=Criteria.create(RepaymentsPlan.class);
        criteria.add(ExpressionFactory.eq("loanRecordId",114));
        criteria.sortIfEmpty(Sort.asc("payDate"));
        List<RepaymentsPlan> lst= repaymentsPlanService.findAll(criteria);
        RepaymentsPlan res= Collections.max(lst,new Comparator<RepaymentsPlan>(){
            @Override
            public int compare(RepaymentsPlan s1, RepaymentsPlan s2) {
                return s1.getCurrentTerm()-s2.getCurrentTerm();
            }
        });
    }

    @Resource
    private LoanAuditService loanAuditService;
    @Test
    public void testPlanAuditPerson() throws Exception{
        System.out.println("person: " + loanAuditService.getCreditFirstPlanAuditPerson());
    }
}
