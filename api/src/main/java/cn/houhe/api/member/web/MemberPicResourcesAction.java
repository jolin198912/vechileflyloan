package cn.houhe.api.member.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.member.entity.MemberPicResources;
import cn.houhe.api.member.service.MemberPicResourcesExtService;
import cn.houhe.api.member.service.MemberPicResourcesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：member_pic_resources
 * @since 2017-03-30 10:12:39
 */
@Controller
@RequestMapping(value = "/memberpic")
public class MemberPicResourcesAction {
	private static final Logger logger = LoggerFactory.getLogger(MemberPicResourcesAction.class);

	@Autowired
	private MemberPicResourcesService memberPicResourcesService;
	@Autowired
	private MemberPicResourcesExtService memberPicResourcesExtService;

	/*
    使用场景说明：修改用户头像接口
    参数定义：memberId 会员id
    		  url 头像url
    code值定义：0 修改成功
                -1 头像修改失败，请重试
    */
	@RequestMapping(value = "/updateheadpic", method= RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object updateHeadPic(@RequestBody RequestDto<MemberPicResources> param){
		return memberPicResourcesExtService.updateHeadPicSer(param);
	}

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/memberpicresources", method=RequestMethod.GET)
	public Object listPage() {
		return "memberpicresources";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/memberpicresources", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<MemberPicResources> criteria = Criteria.create(MemberPicResources.class);
			criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.asc("memresid"));
			Pager<MemberPicResources> pager = memberPicResourcesService.findPage(criteria);
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
	@RequestMapping(value = "/memberpicresourcesadd", method=RequestMethod.GET)
	public Object addPage() {
		return "memberpicresources_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/memberpicresourcesadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(MemberPicResources memberPicResources) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			memberPicResourcesService.insert(memberPicResources);
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
	@RequestMapping(value = "/memberpicresourcesedit", method=RequestMethod.GET)
	public Object editPage(Integer memresid) {
		ModelAndView model = new ModelAndView();
		try {
			MemberPicResources memberPicResources = memberPicResourcesService.findByPrimaryKey(memresid);
			model.addObject("memberPicResources", memberPicResources);
			model.setViewName("memberpicresources_edit");
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
	@RequestMapping(value = "/memberpicresourcesedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(MemberPicResources memberPicResources) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			memberPicResourcesService.update(memberPicResources);
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
	@RequestMapping(value = "/memberpicresourcesdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			memberPicResourcesService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}