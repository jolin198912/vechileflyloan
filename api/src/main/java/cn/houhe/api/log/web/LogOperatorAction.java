package cn.houhe.api.log.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.log.entity.LogOperator;
import cn.houhe.api.log.service.LogOperatorService;
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
 * Spring MVC Controler - 表：log_operator
 * @since 2017-04-07 14:30:23
 */
@Controller
@RequestMapping(value = "/log")
public class LogOperatorAction {
	private static final Logger logger = LoggerFactory.getLogger(LogOperatorAction.class);

	@Autowired
	private LogOperatorService logOperatorService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/logoperator", method=RequestMethod.GET)
	public Object listPage() {
		return "logoperator";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/logoperator", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<LogOperator> criteria = Criteria.create(LogOperator.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("loid"));
			Pager<LogOperator> pager = logOperatorService.findPage(criteria);
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
	@RequestMapping(value = "/logoperatoradd", method=RequestMethod.GET)
	public Object addPage() {
		return "logoperator_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/logoperatoradd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(LogOperator logOperator) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			logOperatorService.insert(logOperator);
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
	@RequestMapping(value = "/logoperatoredit", method=RequestMethod.GET)
	public Object editPage(Integer loid) {
		ModelAndView model = new ModelAndView();
		try {
			LogOperator logOperator = logOperatorService.findByPrimaryKey(loid);
			model.addObject("logOperator", logOperator);
			model.setViewName("logoperator_edit");
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
	@RequestMapping(value = "/logoperatoredit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(LogOperator logOperator) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			logOperatorService.update(logOperator);
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
	@RequestMapping(value = "/logoperatordelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			logOperatorService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}