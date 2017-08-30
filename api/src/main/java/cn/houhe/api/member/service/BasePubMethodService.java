package cn.houhe.api.member.service;

import cn.com.iotrust.common.ServiceOperationException;
import cn.houhe.api.common.AliTools;
import cn.houhe.api.common.Configs;
import cn.houhe.api.member.web.BankCardAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/4/28.
 */
public class BasePubMethodService {
    private static final Logger logger = LoggerFactory.getLogger(BankCardAction.class);

    //发送手机短信验证码
    public static String sendMobileVerificode(String mobile){
        try {
            int code = (int) ((Math.random() * 9 + 1) * 100000);
            String paramString = "" +code;
            //HttpSession session = request.getSession();
            //session.setAttribute("code",paramString);
            String mobile_code = "{\"code\":\"" +paramString +"\"}";
            String templateCode = Configs.registcode;
            AliTools.sendMsg(mobile,mobile_code,templateCode);
            return paramString;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new ServiceOperationException("验证码发送失败");
        }
    }
}
