package cn.houhe.api.common.carcheck;

import cn.com.iotrust.common.util.JsonUtils;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.carcheck.util.CarInfoModel;
import cn.houhe.api.common.carcheck.util.HttpUtil;
import cn.houhe.api.common.carcheck.util.SignUtils;
import cn.houhe.api.common.carcheck.util.URLEncode;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/19.
 */
public class CarCheckService {


    /**
     * 查询接口余额
     * @param type（1、档案核查，5、vin车型库，6、违章查询）
     * @return
     */
    public  static BigDecimal GetBalance(int type)
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid", Configs.chejd_uid);
        map.put("time",GetTime());
        map.put("type",type+"");
        map.put("sign",URLEncode.encodeURL(SignUtils.getSign(map.get("uid")+type+map.get("time")+Configs.chejd_pwd, Configs.chejd_private_Key)));
        String result = HttpUtil.httpReuqest(Configs.chejd_url+"/public/car/getBalance", "POST",GetFormParam(map));
        try {
           JSONObject job=  JSONObject.parseObject(result);
           if(job.containsKey("balance"))
           {
               return   new BigDecimal(job.get("balance")+"");
           }
        }catch (Exception ex)
        {

        }
        return null;
    }

    /**
     * 根据车牌号查询车信息
     * @param license   车牌号
     * @param licenseType  车牌类型 （默认02 小型轿车）
     * @return 车信息
     */
    public static   CarInfoModel  GetCheck(String license,String licenseType)
    {
        if(license==null||license.length()<=1)
        {
            CarInfoModel m=new CarInfoModel();
            m.msg="车牌号码不能为空";
            m.code="-1";
            return  m;
        }
        String regEx="^[A-Z]{1}[A-Z_0-9]{5}$";
        String licensesub=license.substring(1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(licensesub);
        if(!matcher.matches())
        {
            CarInfoModel m=new CarInfoModel();
            m.msg="车牌号码有误";
            m.code="-1";
            return  m;
        }

        if(licenseType==null||"".equals(licenseType))
        {
            licenseType="02";
        }
        String time=GetTime();
        String sign = SignUtils.getSign(Configs.chejd_uid+license+time+Configs.chejd_pwd, Configs.chejd_private_Key);
        Map<String,String> map=new HashMap<String,String>();
        map.put("uid", Configs.chejd_uid);
        map.put("time", time);
        map.put("license", URLEncode.encodeURL(license));
        map.put("licenseType", licenseType);
        map.put("sign", URLEncode.encodeURL(sign));
        try {
           String resutl= HttpUtil.httpReuqest(Configs.chejd_url+"/public/car/check", "POST",GetFormParam(map));
            JSONObject job=  JSONObject.parseObject(resutl);
            if(job.containsKey("code")&&"200".equals(job.get("code")))
            {
                job= JSONObject.parseObject(job.get("result").toString());
                if(job.containsKey("state")&&"0".equals(job.get("state")+""))
                {
                     String json=job.get("data").toString();
                    return JsonUtils.<CarInfoModel>deserialize(json,CarInfoModel.class);
                }
            }else
            {
                CarInfoModel m=new CarInfoModel();
                m.code=job.get("code")+"";
                m.msg=job.get("message")+"";
                return m;
            }
        }catch (Exception ex)
        {
        }
        return  null;
    }

    /**
     * 查询违章信息
     * @param license
     * @param vin
     * @param engine
     * @param licenseType
     * @return
     */
    public  static String checkViolation(String license,String vin,String engine,String licenseType)
    {
        if(licenseType==null||"".equals(licenseType))
        {
            licenseType="02";
        }
        String time=GetTime();
        String sign = SignUtils.getSign(Configs.chejd_uid+license+vin+engine+time+Configs.chejd_pwd, Configs.chejd_private_Key);
        Map<String,String> map=new HashMap<String,String>();
        map.put("uid", Configs.chejd_uid);
        map.put("time", time);
        map.put("license", URLEncode.encodeURL(license));
        map.put("vin", vin);
        map.put("engine", engine);
        map.put("licenseType", licenseType);
        map.put("sign", URLEncode.encodeURL(sign));
       return   HttpUtil.httpReuqest(Configs.chejd_url+"/public/car/checkViolation", "POST",GetFormParam(map));
    }



    /**
     *将map组装成form参数
     * @param map
     * @return
     */
    private static String GetFormParam(Map<String,String> map)
    {
        String resutl="";
        for(String key:map.keySet())
        {
            resutl+="&"+key+"="+map.get(key);
        }
        if(resutl.length()>1)
        {
            resutl=resutl.substring(1);
        }
        System.out.println(resutl);
        return resutl;
    }

    /**
     * 获取指定格式的时间
     * @return
     */
    private static  String GetTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sd.format(new Date());
    }


}
