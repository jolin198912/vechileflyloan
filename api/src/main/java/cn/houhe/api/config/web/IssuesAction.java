package cn.houhe.api.config.web;

import cn.com.iotrust.common.ValidatorException;
import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.config.entity.IssueTypeExt;
import cn.houhe.api.config.entity.Issues;
import cn.houhe.api.config.entity.IssuesExt;
import cn.houhe.api.config.service.IssueTypeService;
import cn.houhe.api.config.service.IssuesService;
import cn.houhe.api.config.web.bo.IssueDto;
import cn.houhe.api.config.web.bo.IssueTypeDto;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC Controler - 表：issues
 *
 * @since 2017-03-30 10:04:06
 */
@Controller
@RequestMapping(value = "/config")
public class IssuesAction {
    private static final Logger logger = LoggerFactory.getLogger(IssuesAction.class);

    @Autowired
    private IssuesService issuesService;

    /**
     * 列表数据
     */
    @RequestMapping(value = "/issues", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(IssueDto requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            IssuesExt issuesExt=new IssuesExt();
            BeanUtils.copyProperties(issuesExt,requestDto);

            issuesExt.setPage((issuesExt.getPage()-1)*issuesExt.getRows());
            resultMap.put("total", issuesService.getCount(issuesExt));
            resultMap.put("rows", issuesService.findPageExt(issuesExt));
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
    @RequestMapping(value = "/issuesadd", method = RequestMethod.POST)
    @ResponseBody
    public Object doAdd(@RequestBody RequestDto<Issues> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //ValidatorUtil.validate(requestDto.getData());
            issuesService.insertSelective(requestDto.getData());
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
    @RequestMapping(value = "/getIsuueById", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto getById(@RequestBody RequestDto<Issues> requestDto) {
        ResultDto resultDto=new ResultDto("0","获取问题");
        try {
            resultDto.setData(issuesService.findByPrimaryKey(requestDto.getData().getIuId()));
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
    @RequestMapping(value = "/issuesedit", method = RequestMethod.POST)
    @ResponseBody
    public Object doEdit(@RequestBody RequestDto<Issues> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //ValidatorUtil.validate(issues);
            issuesService.updateSelective(requestDto.getData());
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
     * 上架下架
     */
    @RequestMapping(value = "/issueseenable", method = RequestMethod.POST)
    @ResponseBody
    public Object doEnable(@RequestBody RequestDto<IssuesExt> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            issuesService.updateEnable(requestDto.getData());
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    /**
     * 获取所有上架问题
     */
    @RequestMapping(value = "/issuesall", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object getAllIssues() {
        return issuesService.getAllIssuesSer();
    }

    /**
     * 问题反馈
     */
    @RequestMapping(value = "/issuesfeedback", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object issuesFeedback(@RequestBody RequestDto<IssueDto> param) {
        return issuesService.issuesFeedbackSer(param);
    }
    /**
     * 查询分类问题列表
     */
    @RequestMapping(value = "/issuesdetail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object issuesDetail(int id) {
        return issuesService.getDetials(id);
    }

}