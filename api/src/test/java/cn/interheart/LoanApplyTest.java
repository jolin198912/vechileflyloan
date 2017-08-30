package cn.interheart;

import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.MoneyUtil;
import cn.houhe.api.loan.service.CreditApplyExtService;
import cn.houhe.api.loan.service.LoanContractService;
import com.aliyun.oss.common.utils.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml"})
@ImportResource(locations = "classpath*:config.properties")
public class LoanApplyTest extends AbstractJUnit4SpringContextTests{
    @Autowired
    CreditApplyExtService creditApplyExtService;
    @Autowired
    LoanContractService loanContractService;
    @Test
    public void testS() throws Exception {
        creditApplyExtService.autoApprove("aaaa",44,1);
    }

    @Test
    public void testCreditApplyApprove() throws Exception{
        creditApplyExtService.autoApproveJob("aaaaaaaa",44,1);
        Thread.sleep(1000000);
    }

    @Test
    public void testUpload() throws Exception{
        System.out.println("upload:    "+AliTools.uploadFileToAli("qzz/20170504","测试合同", IOUtils.readStreamAsByteArray(new URL("https://testapi.fadada.com:8443/api//getdocs.action?app_id=400355&send_app_id=null&v=2.0&timestamp=20170504154115&transaction_id=t21&msg_digest=MTcwRTBEQjVFMUI2MDI1QzY5QzExRUNDNjU3N0RDMUMxOTMxMkRDNg==").openStream())));
    }
    private NumberFormat monthFormat = new DecimalFormat("00");

    @Test
    public void testSignContract() throws Exception{
        Map param = new HashMap();
        param.put("cname", "彭孟京");
        param.put("idcardno", "362427199008023335");
        param.put("mobile",  "13828778122");
        param.put("start", DateFormatUtils.format(new Date(),"yyyy年MM月dd日"));
        param.put("amount", String.valueOf(1000));
        param.put("bigAmount", MoneyUtil.digitUppercase(String.valueOf(1000)));
        param.put("rate", String.valueOf(0.0045));
        param.put("end",DateFormatUtils.format(new Date(),"yyyy年MM月dd日"));
        param.put("repayType","一次性还清");
        Calendar calendar = Calendar.getInstance();
        param.put("date", DateFormatUtils.format(new Date(),"yyyy年MM月dd日"));
        param.put("year", String.valueOf(calendar.get(Calendar.YEAR)));
        param.put("day", monthFormat.format(calendar.get(Calendar.DAY_OF_MONTH)));
        param.put("month", monthFormat.format(calendar.get(Calendar.MONTH )+1));
        param.put("bankcardno","6225887844552315");
        param.put("bankcard","中国招商银行");
        loanContractService.generateAndSignLoanApplyContract(16,param);
    }
}
