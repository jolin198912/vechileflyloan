package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.Rates;
import cn.houhe.api.config.service.RatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC Controler - 表：rates
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class RatesAction {
	private static final Logger logger = LoggerFactory.getLogger(RatesAction.class);

	@Autowired
	private RatesService ratesService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/rates", method=RequestMethod.GET)
	public Object listPage() {
		return "rates";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/rates", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<Rates> criteria = Criteria.create(Rates.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("levelId"));
			criteria.sortIfEmpty(Sort.asc("lpId"));
			Pager<Rates> pager = ratesService.findPage(criteria);
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
	@RequestMapping(value = "/ratesadd", method=RequestMethod.GET)
	public Object addPage() {
		return "rates_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/ratesadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(Rates rates) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			ratesService.insert(rates);
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

//	/**
//	 * 修改页面
//	 */
//	@RequestMapping(value = "/ratesedit", method=RequestMethod.GET)
//	public Object editPage(Short levelId, Short lpId) {
//		ModelAndView model = new ModelAndView();
//		try {
//			Rates rates = ratesService.findByPrimaryKey(levelId ,lpId);
//			model.addObject("rates", rates);
//			model.setViewName("rates_edit");
//		} catch (Exception e) {
//			model.addObject("exception", e.getMessage());
//			model.setViewName("/error");
//			logger.error(e.getMessage(), e);
//		}
//		return model;
//	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/ratesedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit( Rates rates) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			ratesService.update(rates);
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

//	/**
//	 * 删除
//	 */
//	@RequestMapping(value = "/ratesdelete", method=RequestMethod.POST)
//	@ResponseBody
//	public Object doDelete(@FormModel("ids") List<Short> ids) {
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		try {
//			ratesService.batchDelete(ids);
//			resultMap.put("result", 1);
//		} catch (Exception e) {
//			resultMap.put("result", 0);
//			resultMap.put("message", e.getMessage());
//			logger.error(e.getMessage(), e);
//		}
//		return resultMap;
//	}
}