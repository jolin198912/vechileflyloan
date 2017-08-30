package cn.houhe.api.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * Created by think on 2017/4/17.
 */
public class BaiqishiUtil {
    private static  Logger logger = LoggerFactory.getLogger(BaiqishiUtil.class);
    private static final String API_URL = "https://api.baiqishi.com/services/decision";
    private static final String API_URL_CREDIT = "https://credit.baiqishi.com/clweb/api/common/getreport";
    private static final String API_URL_CLWEB = "https://credit.baiqishi.com/clweb/api/mno/getoriginal";
    private static final HttpClient CLIENT;

    static {
        CLIENT = HttpClients.createDefault();
    }

    public static String decision(String jsonParam) throws Exception {
        HttpPost httpPost = new HttpPost(API_URL);
        httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        httpPost.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.7");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(jsonParam, APPLICATION_JSON));
        String result = EntityUtils.toString(CLIENT.execute(httpPost).getEntity());
        logger.debug("白骑士返回信息：" + result);
        return result;
    }


    public static String decision(JSONObject param ) throws Exception {
        if (param == null){
            param = new JSONObject();
        }
        JSONObject jsonObject = new JSONObject(param);
        jsonObject.put("partnerId",Configs.BAIQISHI_PARTNERID);
        jsonObject.put("appId",Configs.BAIQISHI_APPID);
        jsonObject.put("verifyKey",Configs.BAIQISHI_KEY);
        jsonObject.put("occurTime", DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        if (param.getString("eventType") == null){
            jsonObject.put("eventType", "register");
        }
        return decision(jsonObject.toJSONString());
    }

    //运营商数据
    public static String decisionClweb(JSONObject param)  {
        HttpPost httpPost = new HttpPost(API_URL_CLWEB);
        String template = template(param, httpPost);
        return template;
    }
    //原始数据
    public static String decisionCredit(JSONObject param) {
        HttpPost httpPost = new HttpPost(API_URL_CREDIT);
        String template = template(param, httpPost);
        return template;
    }

    public static String template (JSONObject param, HttpPost httpPost) {
        try {
            if (param == null) {
                param = new JSONObject();
            }
            param.put("partnerId", Configs.BAIQISHI_PARTNERID);
            param.put("verifyKey", Configs.BAIQISHI_KEY);
            httpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            httpPost.setHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.7");
            httpPost.setHeader("Connection", "keep-alive");
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(param.toJSONString(), APPLICATION_JSON));
            String result = EntityUtils.toString(CLIENT.execute(httpPost).getEntity());
            logger.debug("白骑士返回信息：" + result);
            return result;
        } catch (Exception e) {
            logger.error("白骑士接入错误");
            return "";
        }
    }

    public static void main(String[] args) throws Exception {

        JSONObject param = new JSONObject();
        param.put("partnerId",Configs.BAIQISHI_PARTNERID);
        param.put("appId",Configs.BAIQISHI_APPID);
        param.put("verifyKey",Configs.BAIQISHI_KEY);
        param.put("eventType","register");
        param.put("certNo","362427199008023335");
        BaiqishiUtil.decision(param.toJSONString());
    }
}