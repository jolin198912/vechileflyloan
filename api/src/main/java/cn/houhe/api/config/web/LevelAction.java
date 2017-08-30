package cn.houhe.api.config.web;

import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.config.entity.Level;
import cn.houhe.api.config.entity.LevelRateExt;
import cn.houhe.api.config.service.LevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC Controler - 表：level
 *
 * @since 2017-04-10 10:40:01
 */
@Controller
@RequestMapping(value = "/config")
public class LevelAction {
    private static final Logger logger = LoggerFactory.getLogger(LevelAction.class);

    @Autowired
    private LevelService levelService;

    /**
     * 列表数据
     */
    @RequestMapping(value = "/level", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Criteria<Level> criteria = Criteria.create(Level.class);
            criteria.setCurrentPage(new Integer(request.getParameter("page")));
            criteria.setPageSize(new Integer(request.getParameter("rows")));
            criteria.sortIfEmpty(Sort.desc("levelId"));
            Pager<Level> pager = levelService.findPage(criteria);
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
     * 新增或修改保存
     */
    @RequestMapping(value = "/savelevel", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody RequestDto<LevelRateExt> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            levelService.addOrUpdate(requestDto.getData());
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 根据id获取级别相关信息
     */
    @RequestMapping(value = "/getlevelbyid", method = RequestMethod.POST)
    @ResponseBody
    public Object getlevelbyid(@RequestBody RequestDto<Level> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            LevelRateExt lr = levelService.getById(requestDto.getData().getLevelId());
            resultMap.put("result", 1);
            resultMap.put("data", lr);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }
}