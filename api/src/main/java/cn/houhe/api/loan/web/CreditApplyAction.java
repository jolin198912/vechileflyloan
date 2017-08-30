package cn.houhe.api.loan.web;

import cn.com.iotrust.common.mvc.ApiException;
import cn.com.iotrust.common.mvc.BaseAction;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.loan.entity.CreditChildren;
import cn.houhe.api.loan.entity.bo.CreditApplyList;
import cn.houhe.api.loan.service.CreditApplyExtService;
import cn.houhe.api.loan.service.CreditChildrenService;
import cn.houhe.api.loan.service.LoanRecordExtService;
import cn.houhe.api.loan.web.bo.CreditApplyListDto;
import cn.houhe.api.loan.web.bo.MemberExtDto;
import org.apache.ibatis.mapping.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC Controler - 表：credit_apply
 * @since 2017-03-29 18:30:03
 *
 * 后台接口
 */
@RestController
@RequestMapping(value = "/loan/web")
public class CreditApplyAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(CreditApplyAction.class);

	@Autowired
	private CreditApplyExtService creditApplyExtService;

	@Autowired
	private LoanRecordExtService loanRecordExtService;

	@Autowired
	private CreditChildrenService creditChildrenService;

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/creditapply/list", method=RequestMethod.POST)
	@ResponseBody
	public Object listData( CreditApplyListDto listDto) {
		Map<String,Object> resultMap = new HashMap<>();
		Pager<CreditApplyList> pager = creditApplyExtService.findPage(listDto);
		resultMap.put("code", 0);
		resultMap.put("total", pager.getTotalRecords());
		resultMap.put("rows", pager.getList());
		return resultMap;
	}


	/**
	 * 申请详情
	 */
	@RequestMapping(value = "/creditapply/info", method=RequestMethod.POST)
	@ResponseBody
	public Object info(@RequestBody RequestDto<CreditApplyList> requestDto) {

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("data", creditApplyExtService.getCreditApplyInfo(requestDto.getData().getCaid()));
		resultMap.put("code", 0);
		return resultMap;
	}

	/**
	 * 授信申请风控评分的详情
	 */
	@RequestMapping(value = "/creditapply/scoreinfo", method=RequestMethod.POST)
	@ResponseBody
	public Object scoreInfo(@RequestBody RequestDto<CreditApplyList> requestDto) {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("data", creditApplyExtService.getCreditScoreInfo(requestDto.getData().getCdid()));
		resultMap.put("code", 0);
		return resultMap;
	}

	/**
	 * 授信第三方接口信息的详情
	 */
	@RequestMapping(value = "/creditapply/thirdpartyinfo", method=RequestMethod.POST)
	@ResponseBody
	public Object thirdpartyInfo(@RequestBody RequestDto<CreditApplyList> requestDto) {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("data", creditApplyExtService.getThirdPartyInfo(requestDto.getData().getCaid()));
		resultMap.put("code", 0);
		return resultMap;
	}

	/**
	 * 申请详情
	 * @param state 0 通过，1 不通过
	 */
	@RequestMapping(value = "/creditapply/approve", method=RequestMethod.POST)
	@ResponseBody
	public Object apply(@RequestParam Integer caid, Integer pid,@RequestParam String pname, @RequestParam(defaultValue = "0") int state
			,@RequestParam(defaultValue = "0",required = false) Integer limit, String remark) throws ApiException{

		Map<String,Object> resultMap = new HashMap<>();
		creditApplyExtService.approve(caid,pid,pname,state,limit,remark);
		resultMap.put("code", 0);
		resultMap.put("msg", "成功");
		return resultMap;
	}

	/**
	 * 获取子女列表
	 * @param
	 */
	@RequestMapping(value = "/creditapply/childrenlist", method=RequestMethod.POST)
	@ResponseBody
	public Object childrenlist(@RequestBody RequestDto<CreditChildren> requestDto) throws ApiException{
		Map<String,Object> resultMap = new HashMap<>();
		try {
			Criteria<CreditChildren> criteria = Criteria.create(CreditChildren.class);
			criteria.add(ExpressionFactory.eq("creditApplyId",requestDto.getData().getCreditApplyId()));
			criteria.setCurrentPage(1);
			criteria.setPageSize(999);
			Pager<CreditChildren> pager = creditChildrenService.findPage(criteria);
			resultMap.put("result", 1);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("total", -1);
			resultMap.put("rows", null);
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 获得百融特殊名单项
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/getSpecialList", method=RequestMethod.POST)
	@ResponseBody
	public Object getSpecialList() throws ApiException{
		return creditApplyExtService.findSpecialList();
	}

}