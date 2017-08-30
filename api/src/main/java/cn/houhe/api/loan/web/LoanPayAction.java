package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.LoanPay;
import cn.houhe.api.loan.service.LoanPayService;
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
 * Spring MVC Controler - 表：loan_pay
 * @since 2017-04-13 15:27:06
 */
@Controller
@RequestMapping(value = "/loan")
public class LoanPayAction {
	private static final Logger logger = LoggerFactory.getLogger(LoanPayAction.class);

	@Autowired
	private LoanPayService loanPayService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/loanpay", method=RequestMethod.GET)
	public Object listPage() {
		return "loanpay";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/loanpay", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<LoanPay> criteria = Criteria.create(LoanPay.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("lpId"));
			Pager<LoanPay> pager = loanPayService.findPage(criteria);
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
	@RequestMapping(value = "/loanpayadd", method=RequestMethod.GET)
	public Object addPage() {
		return "loanpay_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/loanpayadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(LoanPay loanPay) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPayService.insert(loanPay);
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
	@RequestMapping(value = "/loanpayedit", method=RequestMethod.GET)
	public Object editPage(Integer lpId) {
		ModelAndView model = new ModelAndView();
		try {
			LoanPay loanPay = loanPayService.findByPrimaryKey(lpId);
			model.addObject("loanPay", loanPay);
			model.setViewName("loanpay_edit");
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
	@RequestMapping(value = "/loanpayedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(LoanPay loanPay) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPayService.update(loanPay);
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
	@RequestMapping(value = "/loanpaydelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			loanPayService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}