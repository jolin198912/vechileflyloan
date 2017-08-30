package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.entity.LoanContract;
import cn.houhe.api.loan.entity.LoanRecord;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoAPP;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoObject;
import cn.houhe.api.loan.service.*;
import cn.houhe.api.loan.web.bo.AdvancePayDto;
import cn.houhe.api.loan.web.bo.LoanRecordListDto;
import cn.houhe.api.loan.web.bo.MemberDto;
import cn.houhe.api.loan.web.bo.StatisticsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：loan_record
 *
 * @since 2017-04-12 15:46:36
 */
@Controller
@RequestMapping(value = "/loan/app")
public class LoanRecordAppAction {
    private static final Logger logger = LoggerFactory.getLogger(LoanRecordAppAction.class);

    @Autowired
    private LoanRecordService loanRecordService;

    @Autowired
    private LoanRecordExtService loanRecordExtService;

    @Autowired
    private RepaymentsPlanService repaymentsPlanService;

    @Autowired
    private RepaymentsPlanExtService repaymentsPlanExtService;

    @Autowired
    private LoanContractService loanContractService;

    /**
     * 获取借款记录
     */
    @RequestMapping(value = "/loanrecord/list", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<LoanRecordListDto> loanApproveListData(@RequestBody RequestDto<MemberDto> requestDto) {
        ResultDto<LoanRecordListDto> resultDto = new ResultDto<>("0", "获取成功");
        if (requestDto.getData().getMemid() == null || requestDto.getData().getMemid() <= 0) {
            resultDto.setCode("1");
            resultDto.setMsg("会员id不合法");
            return resultDto;
        }
        try {
            Criteria<LoanRecord> criteria = Criteria.create(LoanRecord.class);
            criteria.setCurrentPage(requestDto.getData().getPage());
            criteria.setPageSize(requestDto.getData().getRows());
            criteria.add(ExpressionFactory.eq("memberId", requestDto.getData().getMemid()));
            criteria.sort(Sort.desc("createdon"));
            Pager<LoanRecord> pager = loanRecordService.findPage(criteria);
            LoanRecordListDto loanRecordListDto =new LoanRecordListDto();
            loanRecordListDto.setRecordList(pager.getList());
            loanRecordListDto.setTotalPages(pager.getTotalPages());
            resultDto.setData(loanRecordListDto);
        } catch (Exception e) {
            resultDto.setCode("-1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultDto;
    }

    /**
     * 借款详情
     *
     * @paam requestDto
     */
    @RequestMapping(value = "/loaninfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<LoanRecordInfoAPP> loanInfo(@RequestBody RequestDto<LoanRecordInfoObject> requestDto) {
        ResultDto<LoanRecordInfoAPP> resultDto = new ResultDto<>("0", "获取成功");
        try {
            LoanRecordInfoAPP data=loanRecordExtService.getInfoByid(requestDto.getData().getLoanId());
            Criteria<LoanContract> criteria=Criteria.create(LoanContract.class);
            criteria.add(ExpressionFactory.eq("loanRecordId",requestDto.getData().getLoanId()));
            data.setContracts(loanContractService.findAll(criteria));
            resultDto.setData(data);
        } catch (Exception e) {
            resultDto.setCode("-1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultDto;
    }


    /**
     * 计算提前还款金额
     *
     * @param
     */
    @RequestMapping(value = "/advancePay", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto abvancePay(@RequestBody RequestDto<LoanRecord> recordRequestDto) {
        ResultDto resultDto = new ResultDto("0", "获取成功");
        HashMap<Object, Object> map = new HashMap<>();
        try {
            int loanId = recordRequestDto.getData().getLoanId();
            map = loanRecordExtService.calculateAdvance(loanId);
            resultDto.setData(map);
        } catch (Exception e) {
            resultDto.setCode("-1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultDto;
    }

    /**
     * 提交提前还款
     *
     * @param
     */
    @RequestMapping(value = "/doadvance", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto doadvance(@RequestBody RequestDto<AdvancePayDto> recordRequestDto) {
        ResultDto resultDto = new ResultDto("0", "获取成功");
        AdvancePayDto advancePayDto = recordRequestDto.getData();
        try {
            loanRecordExtService.doAdvance(advancePayDto);
        } catch (Exception e) {
            resultDto.setCode("-1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultDto;
    }


    /**
     * 贷款分析-贷款总量
     *
     * @param
     */
    @RequestMapping(value = "/statistics/loansum", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loanSum(@RequestBody RequestDto<StatisticsDto> statisticsDto) {
        return new ResultDto<>().data(loanRecordExtService.loanSum(statisticsDto.getData()));
    }

    /**
     * 贷款分析-已完成坏账比例
     *
     * @param
     */
    @RequestMapping(value = "/statistics/compLoanBadSum", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto compLoanBadSum(@RequestBody RequestDto<StatisticsDto> statisticsDto) {
        return new ResultDto<>().data(loanRecordExtService.compLoanBadSum(statisticsDto.getData()));
    }

    /**
     * 贷款分析-余额
     *
     * @param
     */
    @RequestMapping(value = "/statistics/balance", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loanBalance(@RequestBody RequestDto<StatisticsDto> statisticsDto) {
        return new ResultDto<>().data(loanRecordExtService.loanBalance(statisticsDto.getData()));
    }


    /**
     * 贷款分析-坏账比例
     *
     * @param
     */
    @RequestMapping(value = "/statistics/loanBad", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loanBadSum(@RequestBody RequestDto<StatisticsDto> statisticsDto) {
        return new ResultDto<>().data(loanRecordExtService.loanBad(statisticsDto.getData()));
    }
    /**
     * 贷款合同模板
     *
     * @param
     */
    @RequestMapping(value = "/loan/contract", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loanContract() {
        ResultDto res=new ResultDto();
        List<LoanContract> contracts=new ArrayList<>();
        LoanContract loanreapay=new LoanContract();
        loanreapay.setContractName("借款协议");
        loanreapay.setContractFileUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/jiekuanxieyi20170802.pdf");
        loanreapay.setContractPreviewUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/jiekuanxieyi20170802.pdf");
        contracts.add(loanreapay);
        loanreapay=new LoanContract();
        loanreapay.setContractName("平台居间服务协议");
        loanreapay.setContractFileUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/platformxieyi20170802.pdf");
        loanreapay.setContractPreviewUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/platformxieyi20170802.pdf");
        contracts.add(loanreapay);
        loanreapay=new LoanContract();
        loanreapay.setContractName("授权扣款委托书");
        loanreapay.setContractFileUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/shouquan_koukuanxieyi20170802.pdf");
        loanreapay.setContractPreviewUrl("http://chefeidai.oss-cn-shenzhen.aliyuncs.com/%E5%90%88%E5%90%8C%E6%A8%A1%E6%9D%BF/shouquan_koukuanxieyi20170802.pdf");
        contracts.add(loanreapay);
        Map<String,Object> map=new HashMap<>();
        map.put("contracts",contracts);
        res.setData(map);
        return res;
    }

}