package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.CommDataConfig;
import cn.houhe.api.config.service.CommDataConfigService;
import cn.houhe.api.config.web.bo.menuTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * Spring MVC Controler - 表：comm_data_config
 * @since 2017-04-13 11:30:10
 */
@Controller
@RequestMapping(value = "/config")
public class CommDataConfigAction {
	private static final Logger logger = LoggerFactory.getLogger(CommDataConfigAction.class);

	@Autowired
	private CommDataConfigService commDataConfigService;

	/*
	使用场景说明：获取文化程度或单位性质相关信息接口
	参数定义：menuType 菜单类型
	code值定义：0 查询成功
                1 未查询到菜单项相关信息
                -1 接口异常
	 */
	@RequestMapping(value = "/getmenuitems", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody()
	public Object getMenuItems(@RequestBody RequestDto<menuTypeDto> param) {
//		return commDataConfigService.findMenuItems(param.getData().getMenuType());
		return commDataConfigService.findMenuItems(param.getData().getMenuType());
	}

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/commdataconfig", method=RequestMethod.GET)
	public Object listPage() {
		return "commdataconfig";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/commdataconfig", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<CommDataConfig> criteria = Criteria.create(CommDataConfig.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("menuId"));
			Pager<CommDataConfig> pager = commDataConfigService.findPage(criteria);
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
	@RequestMapping(value = "/commdataconfigadd", method=RequestMethod.GET)
	public Object addPage() {
		return "commdataconfig_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/commdataconfigadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(CommDataConfig commDataConfig) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			commDataConfigService.insert(commDataConfig);
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
	@RequestMapping(value = "/commdataconfigedit", method=RequestMethod.GET)
	public Object editPage(Short menuId) {
		ModelAndView model = new ModelAndView();
		try {
			CommDataConfig commDataConfig = commDataConfigService.findByPrimaryKey(menuId);
			model.addObject("commDataConfig", commDataConfig);
			model.setViewName("commdataconfig_edit");
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
	@RequestMapping(value = "/commdataconfigedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit( CommDataConfig commDataConfig) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			commDataConfigService.update(commDataConfig);
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
	@RequestMapping(value = "/commdataconfigdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Short> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			commDataConfigService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}