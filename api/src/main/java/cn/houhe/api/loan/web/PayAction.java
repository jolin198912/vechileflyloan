package cn.houhe.api.loan.web;

import cn.houhe.api.common.RequestDto;
import cn.houhe.api.common.ResultDto;
import cn.houhe.api.loan.service.CreditApplyService;
import cn.houhe.api.loan.service.pay.PayService;
import cn.houhe.api.loan.service.pay.bean.PayBean;
import cn.houhe.api.loan.service.pay.util.Base64;
import cn.houhe.api.loan.service.pay.util.Util;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBean;
import cn.houhe.api.loan.service.pay.versionSMS.MsgBody;
import cn.houhe.api.loan.web.bo.MsgBodyDto;
import cn.houhe.api.member.web.bo.BankCardDto;
import cn.houhe.api.user.web.UserAction;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by victorrrr on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/loan")
public class PayAction {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Resource
    private PayService payService;
    @Resource
    private CreditApplyService creditApplyService;


    /*
    应用场景：查询银行卡所属银行
    参数定义：ACC_NO
     */
//    @RequestMapping(value = "/queryaccountinfo",method = RequestMethod.POST,produces = "application/json")
//    @ResponseBody
//    public Object queryAccountInfo(@RequestBody RequestDto<MsgBodyDto> param) {
//        ResultDto result = new ResultDto();
//        result.setMsg("查询银行卡所属银行");
//        try {
//            MsgBodyDto data = param.getData();
//            String accNo = data.getAccNo();
//
//            MsgBody msgBody = new MsgBody();
//            msgBody.setACC_NO(accNo);
//            MsgBean msgBean = new MsgBean();
//            msgBean.getBODYS().add(msgBody);
//
//            PayBean reqBean = payService.queryAccountInfo(msgBean);
//            result.setData(reqBean);
//            result.setCode("0");
//            result.setMsg("查询成功");
//        }catch (Exception e) {
//            result.setCode("-1");
//            result.setMsg("查询失败");
//            logger.error(e.getMessage(),e);
//        }
//        return result;
//    }

      /*
    应用场景：发送短信验证码
     参数定义：mobileNo
              accNo
     */
//    @RequestMapping(value = "/sendmessage",method = RequestMethod.POST,produces = "application/json")
//    @ResponseBody
//    public Object sendMessage(@RequestBody RequestDto<MsgBodyDto> param) {
//        ResultDto result = new ResultDto();
//        result.setMsg("发送短信验证码");
//        try {
//            MsgBodyDto data = param.getData();
//            String mobileNo = data.getMobileNo();
//            String accNo = data.getAccNo();
//
//            MsgBody msgBody = new MsgBody();
//            msgBody.setMOBILE_NO(mobileNo);
//            msgBody.setACC_NO(accNo);
//            msgBody.setTRANS_DESC("短信内容发送");
//
//            MsgBean msgBean = new MsgBean();
//            msgBean.getBODYS().add(msgBody);
//
//            PayBean reqBean = payService.sendMessage(msgBean);
//            result.setData(reqBean);
//            result.setCode("0");
//            result.setMsg("发送短信验证码成功");
//        }catch (Exception e) {
//            result.setCode("-1");
//            result.setMsg("发送短信验证码失败");
//            logger.error(e.getMessage(),e);
//        }
//        return result;
//    }

      /*
     应用场景：通过银行账户认证查询
     参数定义：ACC_NO 银行账号
      */
    @RequestMapping(value = "/verifyquery",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object verifyQuery(@RequestBody RequestDto<MsgBodyDto> param) {
        ResultDto result = new ResultDto();
        result.setMsg("认证查询");
        try {
            MsgBodyDto data = param.getData();
            String accNo = data.getAccNo();
            String accName = data.getAccName();
            PayBean resBean = payService.verifyQuery(accNo,accName);
             return  resBean;
        }catch (Exception e) {
            result.setCode("-1");
            result.setMsg("认证查询失败");
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    /*
      应用场景：代收
      参数定义： ACC_NO
                 ACC_NAME
              SN
                 AMOUNT
      */
    @RequestMapping(value = "/gather",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object gather(@RequestBody RequestDto<MsgBodyDto> param) throws Exception {
         PayBean res= payService.gather(param.getData());
         return res;
    }

    /*
    应用场景：代收查询
    参数定义：
     */
    @RequestMapping(value = "/gatherquery",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object gatherQuery(@RequestBody RequestDto<MsgBodyDto> msgBean) throws Exception {
        return payService.gatherQuery(msgBean.getData().getBatchNo(),msgBean.getData().getObjectId());
    }

    /*
   应用场景：代付(商户通过易联付款给客户，一般用于提现等)
   参数定义： ACC_NO
            ACC_NAME
            SN
            AMOUNT
    */
    @RequestMapping(value = "/pay",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object pay(@RequestBody RequestDto<MsgBodyDto> param) throws Exception{
        return payService.pay(param.getData());
    }

    /*
    应用场景：代付查询
    参数定义：
     */
    @RequestMapping(value = "/payquery",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object payQuery(@RequestBody RequestDto<MsgBodyDto> param) throws Exception {
        return payService.payQuery(param.getData().getBatchNo(),param.getData().getObjectId());
    }





}
