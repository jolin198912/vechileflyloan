package cn.houhe.api.member.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.member.entity.PhoneContact;
import cn.houhe.api.member.service.PhoneContactService;
import cn.houhe.api.member.web.bo.PhoneContractDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：phone_contact
 * @since 2017-04-21 17:41:59
 */
@Controller
@RequestMapping(value = "/member")
public class PhoneContactAction {
	private static final Logger logger = LoggerFactory.getLogger(PhoneContactAction.class);

	@Autowired
	private PhoneContactService phoneContactService;

	/**
	 * 根据memid获取紧急联系人
	 */
	@RequestMapping(value = "/phonecontact/getbymemid", method=RequestMethod.POST)
	@ResponseBody
	public Object getbymemid(@RequestBody RequestDto<PhoneContractDto> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<PhoneContact> criteria = Criteria.create(PhoneContact.class);
			criteria.add(ExpressionFactory.eq("memberId",requestDto.getData().getMemid()));
			criteria.setCurrentPage(1);
			criteria.setPageSize(999);
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<PhoneContact> pager = phoneContactService.findPage(criteria);
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
	 * 列表页面
	 */
	@RequestMapping(value = "/phonecontact", method=RequestMethod.GET)
	public Object listPage() {
		return "phonecontact";
	}

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/phonecontact", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(PhoneContractDto phoneContractDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Criteria<PhoneContact> criteria = Criteria.create(PhoneContact.class);
			//criteria.buildFromRequest(request);
			criteria.add(ExpressionFactory.eq("memberId",phoneContractDto.getMemid()));
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<PhoneContact> pager = phoneContactService.findPage(criteria);
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
	@RequestMapping(value = "/phonecontactadd", method=RequestMethod.GET)
	public Object addPage() {
		return "phonecontact_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/phonecontactadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd( PhoneContact phoneContact) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			phoneContactService.insert(phoneContact);
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
	@RequestMapping(value = "/phonecontactedit", method=RequestMethod.GET)
	public Object editPage(Integer pcId) {
		ModelAndView model = new ModelAndView();
		try {
			PhoneContact phoneContact = phoneContactService.findByPrimaryKey(pcId);
			model.addObject("phoneContact", phoneContact);
			model.setViewName("phonecontact_edit");
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
	@RequestMapping(value = "/phonecontactedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(PhoneContact phoneContact) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			phoneContactService.update(phoneContact);
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
	@RequestMapping(value = "/phonecontactdelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete(List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			phoneContactService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}