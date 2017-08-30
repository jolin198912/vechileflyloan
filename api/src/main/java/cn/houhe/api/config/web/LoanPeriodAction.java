package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.LoanPeriod;
import cn.houhe.api.config.service.LoanPeriodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：loan_period
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class LoanPeriodAction {
	private static final Logger logger = LoggerFactory.getLogger(LoanPeriodAction.class);

	@Autowired
	private LoanPeriodService loanPeriodService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/loanperiod", method=RequestMethod.GET)
	public Object listPage() {
		return "loanperiod";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/loanperiod", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<LoanPeriod> criteria = Criteria.create(LoanPeriod.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("lpId"));
			Pager<LoanPeriod> pager = loanPeriodService.findPage(criteria);
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
	@RequestMapping(value = "/loanperiodadd", method=RequestMethod.GET)
	public Object addPage() {
		return "loanperiod_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/loanperiodadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(LoanPeriod loanPeriod) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPeriodService.insert(loanPeriod);
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
	@RequestMapping(value = "/loanperiodedit", method=RequestMethod.GET)
	public Object editPage(Short lpId) {
		ModelAndView model = new ModelAndView();
		try {
			LoanPeriod loanPeriod = loanPeriodService.findByPrimaryKey(lpId);
			model.addObject("loanPeriod", loanPeriod);
			model.setViewName("loanperiod_edit");
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
	@RequestMapping(value = "/loanperiodedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(LoanPeriod loanPeriod) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPeriodService.update(loanPeriod);
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
	@RequestMapping(value = "/loanperioddelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Short> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPeriodService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}