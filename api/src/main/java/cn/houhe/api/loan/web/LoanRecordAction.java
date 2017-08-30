package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mvc.ApiException;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.loan.entity.bo.LoanList;
import cn.houhe.api.loan.entity.bo.LoanRecordInfoObject;
import cn.houhe.api.loan.service.LoanRecordExtService;
import cn.houhe.api.loan.service.LoanRecordService;
import cn.houhe.api.loan.web.bo.LoanListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC Controler - 表：loan_record
 * @since 2017-04-12 15:46:36
 */
@Controller
@RequestMapping(value = "/loan/web")
public class LoanRecordAction {
	private static final Logger logger = LoggerFactory.getLogger(LoanRecordAction.class);


	@Autowired
	private LoanRecordExtService loanRecordExtService;

	/**
	 * 贷款申请列表数据
	 */
	@RequestMapping(value = "/loan/approve/list", method=RequestMethod.POST)
	@ResponseBody
	public Object loanApproveListData( LoanListDto listDto) {
		Map<String,Object> resultMap = new HashMap<>();
		Pager<LoanList> pager = loanRecordExtService.findPage(listDto);
		resultMap.put("code", 0);
		resultMap.put("total", pager.getTotalRecords());
		//resultMap.put("sum",loanRecordExtService.getLoanTotalMoney(listDto));
		resultMap.put("rows", pager.getList());
		return resultMap;
	}


	/**
	 * 贷款申请详情
	 * @param requestDto
	 */
	@RequestMapping(value = "/loan/info", method=RequestMethod.POST)
	@ResponseBody
	public Object loanInfo(@RequestBody RequestDto<LoanRecordInfoObject> requestDto) {

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("data", loanRecordExtService.getLoanApplyInfo(requestDto.getData().getLoanId()));
		resultMap.put("code", 0);
		return resultMap;
	}

	/**
	 * 贷款审核
	 * @param state 0 通过，1 不通过
	 */
	@RequestMapping(value = "/loan/approve", method=RequestMethod.POST)
	@ResponseBody
	public Object loanapply(@RequestParam Integer loanId, @RequestParam Integer pid, @RequestParam String pname, @RequestParam(defaultValue = "0") int state
			, String remark) throws Exception {

		Map<String,Object> resultMap = new HashMap<>();
		loanRecordExtService.approve(loanId,pid,pname,state,remark);
		resultMap.put("code", 0);
		resultMap.put("msg", "成功");
		return resultMap;
	}
}