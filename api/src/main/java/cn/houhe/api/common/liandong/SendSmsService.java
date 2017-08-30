package cn.houhe.api.common.liandong;

import cn.houhe.api.common.Configs;
import cn.houhe.api.common.liandong.util.RequestTool;
import cn.houhe.api.loan.service.ScheduleJobService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/24.
 */
public class SendSmsService {
     public static Map<String,String> SendMsg(String msgcontent,String mobileno,String sendflowno)
     {
         Map<String,String> map=new HashMap<>();
         JSONObject jb=new JSONObject();
         jb.put("authCode",Configs.ld_authCode);
         jb.put("content","【车飞贷】"+msgcontent);
         JSONArray ja=new JSONArray();
         ja.add(mobileno);
         jb.put("mobiles",ja);
         jb.put("reqId",sendflowno);
         jb.put("serviceId","");
         jb.put("spId",Configs.ld_spId);
         jb.put("srcId","");
         String res= RequestTool.request(jb.toJSONString(), Configs.ld_url);

         JSONObject resobj=(JSONObject)JSONObject.parse(res);
         if(resobj.containsKey("rets"))
         {
             JSONArray mobilesres=(JSONArray)resobj.get("rets");
             JSONObject m=(JSONObject)mobilesres.get(0);
             map.put("msgId",m.get("msgId")+"");
             map.put("status",m.get("rspcod")+"");
         }
         return  map;
     }
}
