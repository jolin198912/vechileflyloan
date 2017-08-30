package cn.houhe.api.log.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.log.entity.MemberPositioning;
import cn.houhe.api.log.service.MemberPositioningService;
import cn.houhe.api.log.web.bo.MemberPositionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：member_positioning
 * @since 2017-04-07 14:30:23
 */
@Controller
@RequestMapping(value = "/log")
public class MemberPositioningAction {
	private static final Logger logger = LoggerFactory.getLogger(MemberPositioningAction.class);

	@Autowired
	private MemberPositioningService memberPositioningService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/memberpositioning", method=RequestMethod.GET)
	public Object listPage() {
		return "memberpositioning";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/memberpositioning", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(MemberPositionDto memberPositionDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<MemberPositioning> criteria = Criteria.create(MemberPositioning.class);
			criteria.add(ExpressionFactory.eq("memberId",memberPositionDto.getMemid()));
			//criteria.buildFromRequest(request);
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<MemberPositioning> pager = memberPositioningService.findPage(criteria);
			resultMap.put("result", 1);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("total", -1);
			resultMap.put("rows", null);
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(value = "/memberpositioningadd", method=RequestMethod.GET)
	public Object addPage() {
		return "memberpositioning_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/memberpositioningadd", method=RequestMethod.POST)
	@ResponseBody
	public ResultDto doAdd(@RequestBody RequestDto<MemberPositioning> requestDto) {
		ResultDto resultDto=new ResultDto("0","新增成功");
		try {
			MemberPositioning m=requestDto.getData();
			m.setCreatedon(new Date());
			memberPositioningService.insert(m);
			return  resultDto;
		} catch (ValidatorException ve) {
			resultDto.setCode("-1");
			resultDto.setMsg(ve.getMessage());
		} catch (Exception e) {
			resultDto.setCode("-1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/memberpositioningedit", method=RequestMethod.GET)
	public Object editPage(Integer memposid) {
		ModelAndView model = new ModelAndView();
		try {
			MemberPositioning memberPositioning = memberPositioningService.findByPrimaryKey(memposid);
			model.addObject("memberPositioning", memberPositioning);
			model.setViewName("memberpositioning_edit");
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
	@RequestMapping(value = "/memberpositioningedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(MemberPositioning memberPositioning) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			memberPositioningService.update(memberPositioning);
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
	@RequestMapping(value = "/memberpositioningdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			memberPositioningService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}