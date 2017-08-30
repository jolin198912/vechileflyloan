package cn.houhe.api.log.web;

import cn.com.iotrust.common.ValidatorException;
import cn.com.iotrust.common.mybatis.criteria.Criteria;
import cn.com.iotrust.common.mybatis.criteria.ExpressionFactory;
import cn.com.iotrust.common.mybatis.criteria.Sort;
import cn.com.iotrust.common.mybatis.result.Pager;
import cn.houhe.api.common.*;
import cn.houhe.api.common.enums.PushMsgEnum;
import cn.houhe.api.common.liandong.SendSmsService;
import cn.houhe.api.common.liandong.util.RequestTool;
import cn.houhe.api.log.entity.Message;
import cn.houhe.api.log.entity.MessageExt;
import cn.houhe.api.log.service.MessageExtService;
import cn.houhe.api.log.service.MessageService;
import cn.houhe.api.log.web.bo.MessageDto;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
 * Spring MVC Controler - 表：message
 *
 * @since 2017-04-07 14:30:23
 */
@Controller
@RequestMapping(value = "/log")
public class MessageAction {
    private static final Logger logger = LoggerFactory.getLogger(MessageAction.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageExtService messageExtService;

    /**
     * 获取通知消息列表
     */
    @RequestMapping(value = "/getmessagelist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object getMessageList(@RequestBody RequestDto<MessageExt> param) {
        return messageExtService.getMessageListSer(param);
    }

    /**
     * 列表数据(后台使用)
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public Object listData(MessageDto messageDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            Criteria<Message> criteria = Criteria.create(Message.class);
            criteria.add(ExpressionFactory.eq("msgType", "0"));
            criteria.setPageSize(messageDto.getRows());
            criteria.setCurrentPage(messageDto.getPage());
            criteria.sortIfEmpty(Sort.desc("createdon"));
            Pager<Message> pager = messageService.findPage(criteria);
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
     * 列表数据(app使用)
     */
    @RequestMapping(value = "/messagelist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object getList(@RequestBody RequestDto<MessageDto> param) {
        ResultDto result = new ResultDto("0", "获取成功");
        try {
            if (param.getData().getMemberId() <= 0) {
                result.setCode("-1");
                result.setMsg("会员id不合法");
                return result;
            }
            Criteria<Message> criteria = Criteria.create(Message.class);
            criteria.add(ExpressionFactory.or(ExpressionFactory.and(ExpressionFactory.eq("memberId", param.getData().getMemberId()), ExpressionFactory.eq("msgType", "1")), ExpressionFactory.eq("msgType", "0")));
            criteria.setPageSize(param.getData().getRows());
            criteria.setCurrentPage(param.getData().getPage());
            criteria.sortIfEmpty(Sort.desc("createdon"));
            Pager<Message> pager = messageService.findPage(criteria);
            result.setData(pager.getList());
        } catch (Exception e) {
            result.setCode("-1");
            result.setMsg("系统异常");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 新增保存
     */
    @RequestMapping(value = "/messageadd", method = RequestMethod.POST)
    @ResponseBody
    public Object doAdd(@RequestBody RequestDto<Message> requestDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //ValidatorUtil.validate(requestDto.getData());
            Message msg=requestDto.getData();
            msg.setMsgContentType((byte)PushMsgEnum.SystemMsg.getIndex());
            messageService.insertSelective(msg);
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
     * 修改保存
     */
    @RequestMapping(value = "/messageedit", method = RequestMethod.POST)
    @ResponseBody
    public Object doEdit(Message message) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            messageService.update(message);
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
    @RequestMapping(value = "/messagedelete", method = RequestMethod.POST)
    @ResponseBody
    public Object doDelete(List<Integer> ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            messageService.batchDelete(ids);
            resultMap.put("result", 1);
        } catch (Exception e) {
            resultMap.put("result", 0);
            resultMap.put("message", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return resultMap;
    }

    @RequestMapping(value = "/pushmessage", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto pushMsg(@RequestBody RequestDto<Message> requestDto) {
        ResultDto resultDto = new ResultDto("0", "推送成功");
        try {
            Message msg = requestDto.getData();
            AliTools.pushGlobaMsg(Configs.pushEv, PushMsgEnum.SystemMsg.getIndex(), msg.getTitle(), msg.getTitle(), msg.getContent());
            Message m = new Message();
            m.setMid(msg.getMid());
            m.setIsSend((byte) 1);
            messageService.updateSelective(m);
            resultDto.setCode("0");
            return resultDto;
        } catch (Exception e) {
            resultDto.setCode("-1");
            resultDto.setMsg(e.getMessage());
            logger.error(e.getMessage(), e);
        }

        return resultDto;
    }
    @RequestMapping(value = "/sendsmstest", method = RequestMethod.GET)
    @ResponseBody
    public Object sendSmsTest()
    {
        Map<String,String> map=new HashMap<>();
        JSONObject jb=new JSONObject();
        jb.put("authCode",Configs.ld_authCode);
        jb.put("content","【车飞贷】test");
        JSONArray ja=new JSONArray();
        ja.add("13827422321");
        jb.put("mobiles",ja);
        jb.put("reqId","10111");
        jb.put("serviceId","");
        jb.put("spId",Configs.ld_spId);
        jb.put("srcId","");
        String res= RequestTool.request(jb.toJSONString(), Configs.ld_url);
        return "发送短信调用结果"+res;
    }
}