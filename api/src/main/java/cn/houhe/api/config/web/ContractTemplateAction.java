package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.config.entity.ContractTemplate;
import cn.houhe.api.config.service.ContractTemplateService;
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
 * Spring MVC Controler - 表：contract_template
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class ContractTemplateAction {
	private static final Logger logger = LoggerFactory.getLogger(ContractTemplateAction.class);

	@Autowired
	private ContractTemplateService contractTemplateService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/contracttemplate", method=RequestMethod.GET)
	public Object listPage() {
		return "contracttemplate";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/contracttemplate", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<ContractTemplate> criteria = Criteria.create(ContractTemplate.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("ctId"));
			Pager<ContractTemplate> pager = contractTemplateService.findPage(criteria);
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
	@RequestMapping(value = "/contracttemplateadd", method=RequestMethod.GET)
	public Object addPage() {
		return "contracttemplate_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/contracttemplateadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(ContractTemplate contractTemplate) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			contractTemplateService.insert(contractTemplate);
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
	@RequestMapping(value = "/contracttemplateedit", method=RequestMethod.GET)
	public Object editPage(Short ctId) {
		ModelAndView model = new ModelAndView();
		try {
			ContractTemplate contractTemplate = contractTemplateService.findByPrimaryKey(ctId);
			model.addObject("contractTemplate", contractTemplate);
			model.setViewName("contracttemplate_edit");
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
	@RequestMapping(value = "/contracttemplateedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(ContractTemplate contractTemplate) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			contractTemplateService.update(contractTemplate);
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
	@RequestMapping(value = "/contracttemplatedelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Short> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			contractTemplateService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}