package cn.houhe.api.config.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.config.entity.DistributionConfig;
import cn.houhe.api.config.service.DistributionConfigExtService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Spring MVC Controler - 表：distribution__config
 * @since 2017-05-24 11:08:35
 */
@Controller
@RequestMapping(value = "/config")
public class DistributionConfigAction {
	private static final Logger logger = LoggerFactory.getLogger(DistributionConfigAction.class);

	@Autowired
	private DistributionConfigExtService distributionConfigExtService;

	/**
	 * 新增或修改保存
	 */
	@RequestMapping(value = "/saveconfig", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody RequestDto<DistributionConfig> requestDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			distributionConfigExtService.addOrUpdate(requestDto.getData());
			resultMap.put("result", 0);
		} catch (Exception e) {
			resultMap.put("result", -1);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 根据id获取相关信息
	 */
	@RequestMapping(value = "/getconfigbyid", method = RequestMethod.POST)
	@ResponseBody
	public Object getlevelbyid(@RequestBody RequestDto<DistributionConfig> requestDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			DistributionConfig distconfiginfo = distributionConfigExtService.getById();
			resultMap.put("result", 0);
			resultMap.put("data", distconfiginfo);
		} catch (Exception e) {
			resultMap.put("result", -1);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}
}