package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.IssueType;
import cn.houhe.api.config.entity.IssueTypeExt;
import cn.houhe.api.config.service.IssueTypeService;
import cn.houhe.api.config.web.bo.IssueTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：issue_type
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class IssueTypeAction {
	private static final Logger logger = LoggerFactory.getLogger(IssueTypeAction.class);

	@Autowired
	private IssueTypeService issueTypeService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/issuetype", method=RequestMethod.GET)
	public Object listPage() {
		return "issuetype";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/issuetype", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(IssueTypeDto issueTypeDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<IssueType> criteria = Criteria.create(IssueType.class);
			criteria.add(ExpressionFactory.eq("isDel",0));
			criteria.setPageSize(issueTypeDto.getRows());
			criteria.setCurrentPage(issueTypeDto.getPage());
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<IssueType> pager = issueTypeService.findPage(criteria);
			if(issueTypeDto.getRows()>100)
				return pager.getList();
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if(issueTypeDto.getRows()>100)
				return null;
			resultMap.put("total", -1);
			resultMap.put("rows", null);
		}
		return resultMap;
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/issuetypeadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(@RequestBody RequestDto<IssueType> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			//ValidatorUtil.validate(requestDto.getData());
			issueTypeService.insertSelective(requestDto.getData());
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
	 * 根据id获取记录
	 */
	@RequestMapping(value = "/issuetypeget", method=RequestMethod.POST)
	@ResponseBody
	public ResultDto getbyid(@RequestBody RequestDto<IssueType> requestDto) {
		ResultDto resultDto=new ResultDto("0","获取问题类别");
		try {
			resultDto.setData(issueTypeService.findByPrimaryKey(requestDto.getData().getItId()));
			return  resultDto;
		} catch (Exception e) {
			resultDto.setCode("-1");
			resultDto.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultDto;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/issuetypeedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(@RequestBody RequestDto<IssueType> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			//ValidatorUtil.validate(issueType);
			issueTypeService.updateSelective(requestDto.getData());
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
	@RequestMapping(value = "/issuetypedelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(@RequestBody RequestDto<IssueType> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			IssueType issueType=requestDto.getData();
			List<IssueTypeExt> issuetypelst = issueTypeService.GetIssuesTypeUsing(issueType.getItId());
			if(issuetypelst.size() > 1){
				resultMap.put("result", 2);
			}else{
				issueType.setIsDel((byte)1);
				issueTypeService.updateSelective(issueType);
				resultMap.put("result", 1);
			}
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
	/**
	 * 查询问题分类（app，每个分类下面显示两个问题）
	 */
	@RequestMapping(value = "/catissues", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object catIssues() {
		return issueTypeService.getCatIsuessLimit2();
	}
	/**
	 * 查询分类问题列表
	 */
	@RequestMapping(value = "/issueslist", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object issuesList(int id) {
		return issueTypeService.getAllIsuessByCatId(id);
	}
}