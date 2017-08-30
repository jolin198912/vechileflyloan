package cn.houhe.api.loan.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.loan.entity.Remainder;
import cn.houhe.api.loan.service.RemainderService;
import cn.houhe.api.loan.web.bo.RemindDto;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：remainder
 * @since 2017-03-29 18:30:03
 */
@Controller
@RequestMapping(value = "/repay")
public class RemainderAction {
	private static final Logger logger = LoggerFactory.getLogger(RemainderAction.class);

	@Autowired
	private RemainderService remainderService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/remainder", method=RequestMethod.GET)
	public Object listPage() {
		return "remainder";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/remainder", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(RemindDto remindDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<Remainder> criteria = Criteria.create(Remainder.class);
			//criteria.buildFromRequest(request);
			criteria.add(ExpressionFactory.eq("memberId",remindDto.getMemberId()));
			criteria.add(ExpressionFactory.eq("repaymentsPlanId",remindDto.getRepaymentsPlanId()));
			criteria.setCurrentPage(remindDto.getPage());
			criteria.setPageSize(remindDto.getRows());
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<Remainder> pager = remainderService.findPage(criteria);
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
	@RequestMapping(value = "/remainderadd", method=RequestMethod.GET)
	public Object addPage() {
		return "remainder_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/remainderadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(Remainder remainder) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			remainderService.insert(remainder);
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
	 * 新增保存
	 */
	@RequestMapping(value = "/remainderaddSelective", method=RequestMethod.POST)
	@ResponseBody
	public Object insertSelective(Remainder remainder) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			//ValidatorUtil.validate(remainder);
			remainderService.insertSelective(remainder);
			resultMap.put("code", 0);
		} catch (ValidatorException ve) {
			resultMap.put("code", 1);
			resultMap.put("message", ve.getMessage());
		} catch (Exception e) {
			resultMap.put("code", 1);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(value = "/remainderedit", method=RequestMethod.GET)
	public Object editPage(Integer rmdId) {
		ModelAndView model = new ModelAndView();
		try {
			Remainder remainder = remainderService.findByPrimaryKey(rmdId);
			model.addObject("remainder", remainder);
			model.setViewName("remainder_edit");
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
	@RequestMapping(value = "/remainderedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(Remainder remainder) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			remainderService.update(remainder);
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
	@RequestMapping(value = "/remainderdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			remainderService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}