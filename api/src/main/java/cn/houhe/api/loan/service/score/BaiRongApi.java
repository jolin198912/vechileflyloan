package cn.houhe.api.loan.service.score;

import cn.houhe.api.common.Configs;
import com.bfd.facade.MerchantServer;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/5/9.
 */
public class BaiRongApi {

    private static Logger logger = LoggerFactory.getLogger(BaiRongApi.class);

    private static String bairong_username= Configs.bairong_username;//商户名称
    private static String bairong_pwd= Configs.bairong_pwd;//商户密码
    private static String bairong_code= Configs.bairong_code;//商户标识

    private String tokenid;
    private MerchantServer ms;

    public BaiRongApi() {
        try {
            ms=new MerchantServer();
            String login_result=ms.login(bairong_username,bairong_pwd,"LoginApi",bairong_code);
            logger.debug("百融：" + login_result);
            JSONObject json= JSONObject.parseObject(login_result);
            this.tokenid=json.getString("tokenid");//有效期一个小时，一个小时没有调用接口就会过期。需要重新登录。
        } catch (Exception e) {
            logger.error("bairong", e);
        }
    }

    public String getData(String apiname, JSONObject reqData)
    {
        try {
            JSONObject jso = new JSONObject();
            jso.put("tokenid", this.tokenid);
            jso.put("apiName", apiname);
            jso.put("reqData", reqData);
            String result =  ms.getApiData(jso.toString(), bairong_code);
            logger.debug("百融：" + result);
            return result;
        } catch (Exception e) {
            logger.error("bairong", e);
            return  "";
        }
    }
}
