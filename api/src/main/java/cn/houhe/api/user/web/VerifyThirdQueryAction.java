package cn.houhe.api.user.web;

import cn.com.iotrust.common.ValidatorException;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.user.entity.VerifyThirdQuery;
import cn.houhe.api.user.service.VerifyThirdQueryService;
import cn.houhe.api.user.web.bo.VerifyThirdQueryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC Controler - 表：verify_third_query
 * @since 2017-06-06 14:31:52
 */
@Controller
@RequestMapping(value = "/user/verifythirdquery")
public class VerifyThirdQueryAction {
	private static final Logger logger = LoggerFactory.getLogger(VerifyThirdQueryAction.class);

	@Autowired
	private VerifyThirdQueryService verifyThirdQueryService;

	/**
	 * 调用三方接口保存结果
	 */
	@RequestMapping(value = "/query", method=RequestMethod.POST)
	@ResponseBody
	public Object query(@RequestBody RequestDto<VerifyThirdQueryDto> verifyThirdQuery) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Object res= verifyThirdQueryService.query(verifyThirdQuery.getData());
			resultMap.put("result", res);
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
	 * 查询历史
	 */
	@RequestMapping(value = "/list", method=RequestMethod.POST)
	@ResponseBody
	public Object list(VerifyThirdQueryDto verifyThirdQuery) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Map<String,Object> res= verifyThirdQueryService.queryList(verifyThirdQuery);
			res.put("code", 1);
			return res;
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
	 * 查询统计
	 */
	@RequestMapping(value = "/statics", method=RequestMethod.POST)
	@ResponseBody
	public Object statics(VerifyThirdQueryDto verifyThirdQuery) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			Map<String,Object> res= verifyThirdQueryService.statics(verifyThirdQuery);
			return res;
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
	 * 查询最后一次查询结果
	 */
	@RequestMapping(value = "/lastquery", method=RequestMethod.POST)
	@ResponseBody
	public Object lastquery() {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			VerifyThirdQuery last= verifyThirdQueryService.querylast();
			resultMap.put("code","1");
			resultMap.put("data",last);
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

}