package cn.houhe.api.common;

import cn.com.iotrust.common.ServiceException;
import com.alibaba.fastjson.JSONObject;
import com.fadada.sample.client.FddClientBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * Created by think on 2017/5/2.
 */
public class FDDUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FDDUtil.class);

    private static FddClientBase clientbase = new FddClientBase(Configs.FDD_APP_ID, Configs.FDD_APP_SECRET, "2.0", Configs.FDD_SERVER );
   public static String custCA(String cname,String idCard, String mobile) throws Exception{
        String response = clientbase.invokeSyncPersonAuto(cname, "", idCard, "0", mobile);
        LOGGER.debug(response);
        JSONObject result = JSONObject.parseObject(response);
        if (!"success".equals(result.getString("result")) || !"1000".equals(result.getString("code"))){
            LOGGER.error(response);
            throw new ServiceException("申请CA失败");
        }

       try {
           if (!"客户已存在".equals(result.getString("msg"))){
               AliTools.sendMsg(mobile,"","SMS_67310358");
           }
       } catch (Exception e) {
           LOGGER.error("合同签约发送短信失败",e);
       }
       return result.getString("customer_id");
    }

    public static void fillingContract(String contractId){
        FddClientBase clientbase = new FddClientBase(Configs.FDD_APP_ID, Configs.FDD_APP_SECRET, "2.0", Configs.FDD_SERVER);
        String response = clientbase.invokeContractFilling(contractId);
        LOGGER.debug(response);
        JSONObject result = JSONObject.parseObject(response);
        if (!"success".equals(result.getString("result")) || !"1000".equals(result.getString("code"))){
            LOGGER.error(response);
            throw new ServiceException("合同归档失败");
        }
    }

    public static void main(String[] args) throws Exception {
        uploadTemplates();
//        custCA("qzz","36012419920305181X","13014235786");
       /* Map param = new HashMap();
        param.put("borrower","李");
        param.put("platformName","车飞货");
        generateContract("test1","testcontract2","测试合同",param);
        autoSign("t2","C97F3AEDF7B0AC382DB820046E42AB65","4","testcontract2","借款合同","委托方签字",null);
        autoSignPlat("t21","testcontract2","借款合同","受托方签字",null);*/
    }


    /**
     * 生成合同
     * @param templateId
     * @param contractId
     * @param docTitle
     * @param param
     * @return
     */
    public static Map generateContract(String templateId, String contractId, String docTitle, Map<String, String> param) {
        // 填充内容
         String response = clientbase.invokeGenerateContract(templateId, contractId, docTitle, "", "", param, null);
        LOGGER.debug(response);
        JSONObject result = JSONObject.parseObject(response);
        if (!"success".equals(result.getString("result")) || !"1000".equals(result.getString("code"))){
            LOGGER.error(response);
            throw new ServiceException("生成合同失败");
        }
        return result;
    }

    public static Map<String, Object> autoSign(String transactionId, String customerId, String clientRole, String contractId, String docTitle, String signKeyword, String notifyUrl){
        String response = clientbase.invokeExtSignAuto(transactionId, customerId, clientRole, contractId, docTitle, signKeyword, notifyUrl);
        LOGGER.debug(response);
        JSONObject result = JSONObject.parseObject(response);
        if (!"success".equals(result.getString("result")) || !"1000".equals(result.getString("code"))){
            LOGGER.error(response);
            throw new ServiceException("签合同失败");
        }
        return result;
    }

    public static Map autoSignPlat(String transactionId, String contractId, String docTitle, String signKeyword, String notifyUrl) {
      return  autoSign(transactionId,Configs.FDD_CUST_ID,"1",contractId,docTitle,signKeyword,notifyUrl);
    }


    public static String uploadTemplate (){
        // 填充内容
//        String templateId = "credit20170517";
//        String templateId = "reg2017051701";
        String templateId = "plat2017051701";
//        String templateId = "repay20170517";
//        String templateId = "loan20170517";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\授权扣款委托书.pdf";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\借款协议.pdf";
        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\平台服务协议.pdf";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\用户注册协议.pdf";
//        String file = ""E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\征信授权.pdf"";
        String  response = clientbase.invokeUploadTemplate(templateId,
                new File(file), null); ;
        LOGGER.debug(response);
        JSONObject result = JSONObject.parseObject(response);
        if (!"success".equals(result.getString("result")) || !"1".equals(result.getString("code"))){
            LOGGER.error(response);
            throw new ServiceException("上传合同模板失败");
        }
        return "test1";
    }


    public static void uploadTemplates (){
        // 填充内容
//        String templateId = "credit20170517";
//        String templateId = "reg2017051701";
//        String templateId = "plat2017051701";
//        String templateId = "repay20170517";
//        String templateId = "loan20170517";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\授权扣款委托书.pdf";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\借款协议.pdf";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\平台服务协议.pdf";
//        String file = "E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\用户注册协议.pdf";
//        String file = ""E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\征信授权.pdf"";
       /* System.out.println(clientbase.invokeUploadTemplate("repay2017051701",
                new File("E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\授权扣款委托书.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("credit20170526",
                new File("E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\征信授权.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("plat20170526",
                new File("E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\平台服务协议.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("reg20170526",
                new File("E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\授信环节\\\\用户注册协议.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("loan20170526",
                new File("E:\\interheart\\车飞贷合同文件\\车飞贷合同文件\\借款环节\\借款协议.pdf"), null));*/

       System.out.println(clientbase.invokeUploadTemplate("jiekuanxieyi20170810_1",
                new File("E:\\车飞贷合同\\jiekuanxieyi20170810.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("platformxieyi20170810_1",
                new File("E:\\车飞贷合同\\平台居间服务协议20170809.pdf"), null));
       /* System.out.println(clientbase.invokeUploadTemplate("shouquan_koukuanxieyi20170810",
                new File("E:\\车飞贷合同\\shouquan_koukuanxieyi20170810.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("yonghuxieyi20170810",
                new File("E:\\车飞贷合同\\yonghuxieyi20170810.pdf"), null));
        System.out.println(clientbase.invokeUploadTemplate("zhengxinshouquanxieyi20170810_1",
                new File("E:\\车飞贷合同\\zhengxinshouquanxieyi20170810.pdf"), null));*/

    }

}
