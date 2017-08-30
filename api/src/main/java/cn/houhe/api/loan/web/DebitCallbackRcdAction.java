package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.DebitCallbackRcd;
import cn.houhe.api.loan.service.DebitCallbackRcdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：debit_callback_rcd
 * @since 2017-03-29 18:30:03
 */
@Controller
@RequestMapping(value = "/repay")
public class DebitCallbackRcdAction {
	private static final Logger logger = LoggerFactory.getLogger(DebitCallbackRcdAction.class);

	@Autowired
	private DebitCallbackRcdService debitCallbackRcdService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/debitcallbackrcd", method=RequestMethod.GET)
	public Object listPage() {
		return "debitcallbackrcd";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/debitcallbackrcd", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<DebitCallbackRcd> criteria = Criteria.create(DebitCallbackRcd.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("dcrId"));
			Pager<DebitCallbackRcd> pager = debitCallbackRcdService.findPage(criteria);
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
	@RequestMapping(value = "/debitcallbackrcdadd", method=RequestMethod.GET)
	public Object addPage() {
		return "debitcallbackrcd_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/debitcallbackrcdadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(DebitCallbackRcd debitCallbackRcd) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitCallbackRcdService.insert(debitCallbackRcd);
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
	@RequestMapping(value = "/debitcallbackrcdedit", method=RequestMethod.GET)
	public Object editPage(Integer dcrId) {
		ModelAndView model = new ModelAndView();
		try {
			DebitCallbackRcd debitCallbackRcd = debitCallbackRcdService.findByPrimaryKey(dcrId);
			model.addObject("debitCallbackRcd", debitCallbackRcd);
			model.setViewName("debitcallbackrcd_edit");
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
	@RequestMapping(value = "/debitcallbackrcdedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(DebitCallbackRcd debitCallbackRcd) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitCallbackRcdService.update(debitCallbackRcd);
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
	@RequestMapping(value = "/debitcallbackrcddelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			debitCallbackRcdService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}