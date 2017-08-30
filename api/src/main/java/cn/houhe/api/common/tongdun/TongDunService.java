package cn.houhe.api.common.tongdun;

import cn.houhe.api.common.Configs;
import cn.houhe.api.common.tongdun.util.RequestTool;
import com.sun.org.apache.regexp.internal.REUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/23.
 */
public class TongDunService {

    /**
     * 借款事件风控评估
     * @param name  姓名
     * @param idno  身份证号
     * @param mobile  手机号
     * @param tokenid 设备id
     * @param devtype  设备类型（0安卓，1ios）
     * @return
     */
    public  static String GetCheck(String name,String idno,String mobile,String tokenid,int devtype)
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("partner_code", Configs.td_partner_code);// 此处值填写您的合作方标识
        if(devtype==0) {
            params.put("secret_key",Configs.td_android_secret_key);// 此处填写对应app密钥
            params.put("event_id", Configs.td_android_event_id);// 此处填写策略集上的事件标识
        }else if(devtype==2)
        {
            params.put("secret_key",Configs.td_web_secret_key);// 此处填写对应app密钥
            params.put("event_id", Configs.td_web_event_id);// 此处填写策略集上的事件标识
        }
        else
        {
            params.put("secret_key",Configs.td_ios_secret_key);// 此处填写对应app密钥
            params.put("event_id", Configs.td_ios_event_id);// 此处填写策略集上的事件标识
        }
        if(tokenid!=null) {
            params.put("black_box", tokenid);//此处填写设备指纹服务的会话标识，和部署设备脚本的token一致
        }
        params.put("account_name", name);// 以下填写其他要传的参数，比如系统字段，扩展字段
        params.put("id_number", idno);
        params.put("account_mobile", mobile);
        return RequestTool.request(params);
    }
}
