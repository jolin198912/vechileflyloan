package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.Advertisement;
import cn.houhe.api.config.entity.AdvertisementExt;
import cn.houhe.api.config.service.AdvertisementService;
import cn.houhe.api.config.web.bo.AdvertisementDto;
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
 * Spring MVC Controler - 表：advertisement
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class AdvertisementAction {
	private static final Logger logger = LoggerFactory.getLogger(AdvertisementAction.class);

	@Autowired
	private AdvertisementService advertisementService;

	/**
	 * 列表数据
	 */
	@RequestMapping(value = "/advertisement", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Object listData(AdvertisementDto advertisementDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Criteria<Advertisement> criteria = Criteria.create(Advertisement.class);
			//criteria.buildFromRequest(request);
			criteria.setCurrentPage(advertisementDto.getPage());
			criteria.setPageSize(advertisementDto.getRows());
			criteria.sortIfEmpty(Sort.desc("createdon"));
			Pager<Advertisement> pager = advertisementService.findPage(criteria);
			resultMap.put("total", pager.getTotalRecords());
			resultMap.put("rows", pager.getList());
		} catch (Exception e) {
			resultMap.put("total", -1);
			resultMap.put("rows", null);
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/**
	 * 新增保存
	 */
	@RequestMapping(value = "/advertisementadd", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Object doAdd(@RequestBody RequestDto<Advertisement> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			//ValidatorUtil.validate(advertisement);
			advertisementService.insertSelective(requestDto.getData());
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
	 * 根据id获取数据
	 */
	@RequestMapping(value = "/advertisementget", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public ResultDto GetById(@RequestBody RequestDto<Advertisement> requestDto) {
		ResultDto result=new ResultDto("0","获取消息成功");
		try {
			Advertisement advertisement = advertisementService.findByPrimaryKey(requestDto.getData().getAdId());
			result.setData(advertisement);
		} catch (Exception e) {
			result.setCode("-1");
			result.setMsg("系统异常");
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/advertisementedit", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Object doEdit(@RequestBody RequestDto<Advertisement> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			//ValidatorUtil.validate(advertisement);
			advertisementService.updateSelective(requestDto.getData());
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
	 * 上线下线广告
	 */
	@RequestMapping(value = "/advertisementupdatestatus", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public Object doDelete(@RequestBody RequestDto<Advertisement> requestDto) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			advertisementService.updateSelective(requestDto.getData());
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			resultMap.put("message", e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return resultMap;
	}

	/*
    使用场景说明：获取广告列表接口，APP端根据此接口返回值展示首页广告页
    参数定义：
    code值定义：0 获取成功
                -1 接口异常，获取失败
    */
	@RequestMapping(value = "/getadvertisementlist", method=RequestMethod.POST,produces = "application/json")
	@ResponseBody()
	public Object getAdvertisementList(){
		ResultDto result = new ResultDto();
		result.setMsg("获取广告列表");
		try {
			List<AdvertisementExt> advlist = advertisementService.selAdvList();
			result.setData(advlist);
			result.setCode("0");
		}catch (Exception e){
			result.setCode("-1");
			result.setMsg(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}