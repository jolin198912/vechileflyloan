package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.entity.DebitRcd;
import cn.houhe.api.loan.service.DebitRcdService;
import cn.houhe.api.loan.web.bo.DebitRcdListDto;
import cn.houhe.api.loan.web.bo.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：debit_rcd
 * @since 2017-03-29 18:30:03
 */
@Controller
@RequestMapping(value = "/repay")
public class DebitRcdAction {
	private static final Logger logger = LoggerFactory.getLogger(DebitRcdAction.class);

	@Autowired
	private DebitRcdService debitRcdService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/debitrcd", method=RequestMethod.GET)
	public Object listPage() {
		return "debitrcd";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/debitrcd", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<DebitRcd> criteria = Criteria.create(DebitRcd.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("drId"));
			Pager<DebitRcd> pager = debitRcdService.findPage(criteria);
			resultMap.put("result", 1);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(value = "/debitrcdadd", method=RequestMethod.GET)
	public Object addPage() {



		return "debitrcd_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/debitrcdadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(DebitRcd debitRcd) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitRcdService.insert(debitRcd);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/debitrcdedit", method=RequestMethod.GET)
	public Object editPage(Integer drId) {
		ModelAndView model = new ModelAndView();
		try {
			DebitRcd debitRcd = debitRcdService.findByPrimaryKey(drId);
			model.addObject("debitRcd", debitRcd);
			model.setViewName("debitrcd_edit");
		} catch (Exception e) {
			model.addObject("exception", e.getMessage());
			model.setViewName("/error");
			logger.error(e.getMessage(), e);
		}
		return model;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/debitrcdedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(DebitRcd debitRcd) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitRcdService.update(debitRcd);
			resultMap.put("result", 1);
		} catch (ValidatorException ve) {
			resultMap.put("result", 0);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/debitrcddelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitRcdService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 获取还款记录
	 */
	@RequestMapping(value = "/repaylist", method=RequestMethod.POST)
	@ResponseBody
	public Object debitrcdListData(@RequestBody RequestDto<MemberDto> requestDto) {
		ResultDto<DebitRcdListDto> resultDto=new ResultDto<>("0","获取成功");
		if(requestDto.getData().getMemid()==null||requestDto.getData().getMemid()<=0) {
			resultDto.setCode("1");
			resultDto.setMsg("会员id不合法");
			return resultDto;
		}
		Criteria<DebitRcd> criteria=Criteria.create(DebitRcd.class);
		criteria.setCurrentPage(requestDto.getData().getPage());
		criteria.setPageSize(requestDto.getData().getRows());
		criteria.add(ExpressionFactory.eq("memberId",requestDto.getData().getMemid()));
		criteria.sort(Sort.desc("createdon"));
		Pager<DebitRcd> pager = debitRcdService.findPage(criteria);
		DebitRcdListDto debitRcdListDto=new DebitRcdListDto();
		debitRcdListDto.setList(pager.getList());
		debitRcdListDto.setTotalPages(pager.getTotalPages());
		resultDto.setData(debitRcdListDto);
		return resultDto;
	}

	/**
	 * 插入还款记录
	 */
	@RequestMapping(value = "/insertdebitrcddata", method=RequestMethod.POST)
	@ResponseBody
	public Object insertDebitRcdData() {
		return debitRcdService.insertDebitRcdDataSer();
	}
}