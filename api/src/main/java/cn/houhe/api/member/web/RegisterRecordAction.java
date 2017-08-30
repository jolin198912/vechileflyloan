package cn.houhe.api.member.web;

import cn.com.iotrust.common.ValidatorException;
import cn.houhe.api.member.entity.RegisterRecord;
import cn.houhe.api.member.entity.RegisterRecordExt;
import cn.houhe.api.member.service.RegisterRecordExtService;
import cn.houhe.api.member.service.RegisterRecordService;
import cn.houhe.api.member.web.bo.RegisterRecordDto;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：register_record
 * @since 2017-04-14 11:59:03
 */
@Controller
@RequestMapping(value = "/registerrecord")
public class RegisterRecordAction {
	private static final Logger logger = LoggerFactory.getLogger(RegisterRecordAction.class);

	@Autowired
	private RegisterRecordService registerRecordService;

	@Autowired
	private RegisterRecordExtService registerRecordExtService;

	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/registerrecord", method=RequestMethod.GET)
	public Object listPage() {
		return "registerrecord";
	}

	/**
	 * 列表数据(后台使用)
	 */
	@RequestMapping(value = "/unregisterrecordlist", method=RequestMethod.POST)
	@ResponseBody
	public Object listData(RegisterRecordDto requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			RegisterRecordExt registerRecordExt = new RegisterRecordExt();
			BeanUtils.copyProperties(registerRecordExt, requestDto);
			registerRecordExt.setPage((registerRecordExt.getPage()-1)*registerRecordExt.getRows());
			resultMap.put("result", 1);
			resultMap.put("total", registerRecordExtService.getCount(registerRecordExt));
			resultMap.put("rows", registerRecordExtService.findPageExt(registerRecordExt));
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
	@RequestMapping(value = "/registerrecordadd", method=RequestMethod.GET)
	public Object addPage() {
		return "registerrecord_add";
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/registerrecordadd", method=RequestMethod.POST)
	@ResponseBody
	public Object doAdd(RegisterRecord registerRecord) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			registerRecordService.insert(registerRecord);
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
	@RequestMapping(value = "/registerrecordedit", method=RequestMethod.GET)
	public Object editPage(Integer rrId) {
		ModelAndView model = new ModelAndView();
		try {
			RegisterRecord registerRecord = registerRecordService.findByPrimaryKey(rrId);
			model.addObject("registerRecord", registerRecord);
			model.setViewName("registerrecord_edit");
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
	@RequestMapping(value = "/registerrecordedit", method=RequestMethod.POST)
	@ResponseBody
	public Object doEdit(RegisterRecord registerRecord) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			registerRecordService.update(registerRecord);
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
	@RequestMapping(value = "/registerrecorddelete", method=RequestMethod.POST)
	@ResponseBody
	public Object doDelete( List<Integer> ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			registerRecordService.batchDelete(ids);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}