package cn.interheart;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.service.IssueTypeService;
import cn.houhe.api.loan.entity.DebitRcd;
import cn.houhe.api.loan.entity.RepaymentsPlan;
import cn.houhe.api.loan.service.RepaymentsPlanExtService;
import cn.houhe.api.loan.service.RepaymentsPlanService;
import cn.houhe.api.user.entity.VerifyThirdQuery;
import cn.houhe.api.user.mapper.VerifyThirdQueryExtMapper;
import cn.houhe.api.user.web.bo.VerifyThirdQueryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by think on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml","classpath*:applicationContext.xml","classpath*:spring-servlet.xml"})
@ImportResource(locations = "classpath*:config.properties")
@WebAppConfiguration
public class RepaymentPlanTest extends AbstractJUnit4SpringContextTests{
    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private RepaymentsPlanService repaymentsPlanService;

    @Autowired
    private VerifyThirdQueryExtMapper verifyThirdQueryExtMapper;
    @Autowired
    private RepaymentsPlanExtService repaymentsPlanExtService;
    @Autowired
    private IssueTypeService issueTypeService;

    private   MockMvc mockMvc;


    @Test
    public void testS() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/repayplan/repaymentsplanlist").param("page","1").param("rows","10"))
                .andExpect(MockMvcResultMatchers.status().is(200)).andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void testPlan()
    {
        ResultDto<List<RepaymentsPlan>> resultDto = new ResultDto<>("0", "获取成功");
        try {
            Criteria<RepaymentsPlan> criteria=Criteria.create(RepaymentsPlan.class);
            criteria.add(ExpressionFactory.eq("loanRecordId",125));
            criteria.sortIfEmpty(Sort.asc("payDate"));
            List<RepaymentsPlan> lst= repaymentsPlanService.findAll(criteria);
            RepaymentsPlan res= Collections.max(lst,new Comparator<RepaymentsPlan>(){
                @Override
                public int compare(RepaymentsPlan s1, RepaymentsPlan s2) {
                    return s1.getCurrentTerm()-s2.getCurrentTerm();
                }
            });
            //最后一期不收利息
            BigDecimal totalpay=res.getTotalPay().subtract(res.getInterest());
            res.setTotalPay(totalpay);
            res.setRealPay(totalpay);
            res.setRealTotalPay(totalpay);
            resultDto.setData(lst);
        } catch (Exception e) {
            resultDto.setCode("1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void  testQuery()
    {
        VerifyThirdQueryDto dto=new VerifyThirdQueryDto();
        dto.setUserId(360);
        Integer cnt= verifyThirdQueryExtMapper.getCount(dto);
    }
    @Test
    public void  testQueryList()
    {
        VerifyThirdQueryDto dto=new VerifyThirdQueryDto();
        dto.setPage(1);
        dto.setRows(10);
        dto.setPage((dto.getPage()-1)*dto.getRows());
        List<VerifyThirdQuery> lst= verifyThirdQueryExtMapper.getList(dto);
    }
    @Test
    public void  testStatics()
    {
        VerifyThirdQueryDto dto=new VerifyThirdQueryDto();
        dto.setPage(1);
        dto.setRows(10);
        dto.setPage((dto.getPage()-1)*dto.getRows());
        List<Map<String,String>> map=verifyThirdQueryExtMapper.statics(dto);
    }
    @Test
    public void  testgetlast()
    {
        Object res= verifyThirdQueryExtMapper.getlast();
    }
    @Test
    public void testOverPay() throws  Exception
    {
        DebitRcd db=new DebitRcd();
        db.setRepaymentsPlanId(20);
        repaymentsPlanExtService.overduePay(db);
    }
    @Test
    public void  testIssues()
    {
       ResultDto dto=  issueTypeService.getCatIsuessLimit2();
    }
}
