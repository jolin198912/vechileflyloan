package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.AuthorizeInfo;
import cn.houhe.api.loan.service.AuthorizeInfoService;
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
 * Spring MVC Controler - 表：authorize_info
 * @since 2017-04-20 16:50:02
 */
@Controller
@RequestMapping(value = "/loan")
public class AuthorizeInfoAction {
	private static final Logger logger = LoggerFactory.getLogger(AuthorizeInfoAction.class);

	@Autowired
	private AuthorizeInfoService authorizeInfoService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/authorizeinfo", method=RequestMethod.GET)
	public Object listPage() {
		return "authorizeinfo";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/authorizeinfo", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<AuthorizeInfo> criteria = Criteria.create(AuthorizeInfo.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("aiId"));
			Pager<AuthorizeInfo> pager = authorizeInfoService.findPage(criteria);
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
	@RequestMapping(value = "/authorizeinfoadd", method=RequestMethod.GET)
	public Object addPage() {
		return "authorizeinfo_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/authorizeinfoadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd( AuthorizeInfo authorizeInfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			authorizeInfoService.insert(authorizeInfo);
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
	@RequestMapping(value = "/authorizeinfoedit", method=RequestMethod.GET)
	public Object editPage(Integer aiId) {
		ModelAndView model = new ModelAndView();
		try {
			AuthorizeInfo authorizeInfo = authorizeInfoService.findByPrimaryKey(aiId);
			model.addObject("authorizeInfo", authorizeInfo);
			model.setViewName("authorizeinfo_edit");
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
	@RequestMapping(value = "/authorizeinfoedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(AuthorizeInfo authorizeInfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			authorizeInfoService.update(authorizeInfo);
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
	@RequestMapping(value = "/authorizeinfodelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			authorizeInfoService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}