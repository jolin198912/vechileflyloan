package cn.houhe.api.common;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20150827.PushRequest;
import com.aliyuncs.push.model.v20150827.PushResponse;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31.
 * 调用阿里工具类
 */
public class AliTools {
    /**
    * 发送短信
     *@recNum 手机号码
     * @paramString 模板对应参数
     * @templateCode 模板编号
    * */
    public static boolean sendMsg(String recNum, String paramString, String templateCode) {
        try {
            IClientProfile profile = DefaultProfile.getProfile(Configs.regionId, Configs.accesskey, Configs.secretKey);
            DefaultProfile.addEndpoint("cn-hangzhou", Configs.regionId, "Sms",  "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(Configs.smssign);//控制台创建的签名名称
            request.setTemplateCode(templateCode);//控制台创建的模板CODE
            request.setParamString(paramString);//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
            //request.setParamString("{}");
            request.setRecNum(recNum);//接收号码
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    * 单点推送
    * @accounts 推送账号（后河推送为用户id，多个使用逗号隔开）
    * @summary 消息标题
    * @body 消息内容
    * */
    public static  Map<String,String>  pushMsg(String accounts,int msgtype,String title,String summary,String body) throws ClientException {
       return AliTools.pushMsgtool("account",accounts,3,0,title,body,summary,msgtype);
    }

    /*
       * 全局推送
       * @tag 推送标签（测试环境为dev，正式环境为pro）
       * @summary 消息标题
       * @body 消息内容
       * */
    public static  Map<String,String>  pushGlobaMsg(String tag,int msgtype,String title,String summary,String body) throws ClientException {
        return AliTools.pushMsgtool("tag",tag,3,0,title,body,summary,msgtype);
    }

    private  static Map<String,String>  pushMsgtool(String target,String targetvalue,int deviceType,int showtype,String title,String body,String summary,int msgtype)throws ClientException
    {
        IClientProfile profile = DefaultProfile.getProfile(Configs.regionId, Configs.accesskey, Configs.secretKey);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        PushRequest pushRequest = new PushRequest();
        // 推送目标
        pushRequest.setAppKey(Configs.appKey);
        pushRequest.setTarget(target); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue(targetvalue); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(3); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
        // 推送配置
        pushRequest.setType(1); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(title); // 消息的标题
        pushRequest.setBody(body); // 消息的内容
        pushRequest.setSummary(body); // 通知的摘要
        pushRequest.setiOSTitle(title);//iostitle
        pushRequest.setAndroidExtParameters("{\"msg_content_type\":\""+msgtype+"\",\"title\":\""+title+"\",\"content\":\""+body+"\"}");
        // 推送配置: iOS
        pushRequest.setiOSBadge("5"); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSExtParameters("{\"msg_content_type\":\""+msgtype+"\",\"title\":\""+title+"\",\"content\":\""+body+"\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备
        pushRequest.setApnsEnv(Configs.apns);
        //pushRequest.setRemind(true); // 推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境
        // 推送配置: Android
        //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffline设为true
        //pushRequest.setXiaomiActivity("_Your_XiaoMi_Activity_");
        pushRequest.setAndroidOpenType("4"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
        //pushRequest.setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        //pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性
        // 推送控制
        //final Date pushDate = new Date(System.currentTimeMillis() + 30 * 1000); // 30秒之间的时间点, 也可以设置成你指定固定时间
        //final String pushTime = ParameterHelper.getISO8601Time(pushDate);
                // pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        //pushRequest.setStoreOffline(false); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        //final String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        //pushRequest.setExpireTime(expireTime);
        //pushRequest.setBatchNumber("100010"); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串
            PushResponse pushResponse = client.getAcsResponse(pushRequest);
            Map<String,String> map=new HashMap<String,String>();
            map.put("requestId",pushResponse.getRequestId());
            map.put("responseId",pushResponse.getResponseId());
            return map;

    }


   /*
   * foldername:文件夹名字
   * filename：文件名
   * filecontent：文件二进制
   * 返回值：网路全路径
   * */
    public  static  String uploadFileToAli(String foldername, String filename, byte[] filecontent)
    {
        String endpoint = Configs.osssrc;
        String accessKeyId = Configs.accesskey;
        String accessKeySecret = Configs.secretKey;
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);
        String key=  foldername+"/"+filename;
        try {
            PutObjectResult res= ossClient.putObject(Configs.ossbucket, key, new ByteArrayInputStream(filecontent));
            ossClient.shutdown();
        }catch (Exception ex)
        {
            return null;
        }
        return "http://"+Configs.ossbucket+"."+endpoint+"/"+key;
    }
    /*
    * 阿里oss地址
    * */
    public static String ossPrefix;

    static {
        ossPrefix = "http://"+Configs.ossbucket+"."+Configs.osssrc+"/";
    }
}
