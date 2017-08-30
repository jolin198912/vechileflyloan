package cn.houhe.api.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/3/29.
 * 配置属性列表
 */
public class Configs {
    /*
    * 阿里云key
    * */
    public static String accesskey;
    /*
    * 阿里云secret
    * */
    public static String secretKey;
    /*
    * 阿里云oss地址
    * */
    public static String osssrc;
    /*
    * 阿里云oss 文件夹
    * */
    public static String ossbucket;
    /*
   * 请求签名
   * */
    public static String apptoken;
    /*
   注册/重置密码短信模板
   * */
    public static String registcode;
    /*
    短信签名
    * */
    public static String smssign;

    /*
    推送appKey
    * */
    public static long appKey;
    /*
    * 推送环境
    * */
    public static String pushEv;
    /*
   * apns环境
   * */
    public static String apns;
    /*
    * 接口请求区域
    * */
    public static String regionId;

    /***易连代扣代付配置***/
    public static String yl_dna_pub_key;
    public static String yl_mer_pfx_key;
    public static String yl_mer_pfx_pass;
    public static String yl_user_name;
    public static String yl_user_name_v;
    public static String yl_merchant_no;
    public static String yl_merchant_key;
    public static String yl_version;
    public static String yl_url;

    /* 百融*/
    public static String bairong_loginname = "LoginApi";
    public static String bairong_username = "hhwAPI";
    public static String bairong_pwd = "hhwAPI";
    public static String bairong_code = "3000679";

    public static Map<String, String> CityMap = new HashMap<String, String>();

    /**
     * face++
     */
    public static String FACE_APPKEY = "DD7TfA6qe2WJ4eD10ErAdiF1jroWl0cZ";
    public static String FACE_APPSecret = "lih8YUkeemi4T2bxDLCpb7EC_jb-6Dag";


    /**
     * 白骑士
     */
    public static String BAIQISHI_KEY = "5c56b215662c48d0a2cdd148e17ef6f5";
    public static String BAIQISHI_PARTNERID = "honhesns";
    public static String BAIQISHI_APPID = "test";

    /**
     * 法大大
     */
    public static String FDD_SERVER = "http://test.api.fabigbig.com:8888/api/";
    public static String FDD_APP_ID = "400355";
    public static String FDD_APP_SECRET = "PcYtkmWEIn0glLWNrQyWQ22z";


    public static String FDD_CUST_ID = "7F53BA11D1984E6E2DB820046E42AB65";


    //车鉴定配置
    public static String chejd_isopen="";
    public static String chejd_url = "";
    public static String chejd_uid = "";
    public static String chejd_pwd = "";
    public static String chejd_private_Key = "";


    //同盾配置
    public static String td_url = "";
    public static String td_partner_code = "";
    public static String td_android_event_id = "";
    public static String td_ios_event_id = "";
    public static String td_android_secret_key = "";
    public static String td_ios_secret_key = "";
    public static String td_web_event_id="";
    public static String td_web_secret_key="";

    //联动短信配置
    public static String ld_url = "";
    public static String ld_authCode = "";
    public static String ld_spId = "";


    public static boolean jobFlag = false;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Configs.class.getClassLoader().getResourceAsStream("config.properties"));
            accesskey = properties.getProperty("accesskey");
            secretKey = properties.getProperty("secretKey");
            osssrc = properties.getProperty("osssrc");
            ossbucket = properties.getProperty("ossbucket");
            apptoken = properties.getProperty("apptoken");
            registcode = properties.getProperty("registcode");
            smssign = properties.getProperty("smssign");
            appKey = Long.parseLong(properties.getProperty("appKey"));
            pushEv = properties.getProperty("pushEv");
            apns= properties.getProperty("apns");
            regionId = properties.getProperty("regionId");

            yl_dna_pub_key = properties.getProperty("yl_dna_pub_key");
            yl_mer_pfx_key = properties.getProperty("yl_mer_pfx_key");
            yl_mer_pfx_pass = properties.getProperty("yl_mer_pfx_pass");
            yl_user_name = properties.getProperty("yl_user_name");
            yl_user_name_v = properties.getProperty("yl_user_name_v");
            yl_merchant_no = properties.getProperty("yl_merchant_no");
            yl_merchant_key = properties.getProperty("yl_merchant_key");
            yl_version = properties.getProperty("yl_version");
            yl_url = properties.getProperty("yl_url");

            chejd_isopen=properties.getProperty("chejd.isopen");
            chejd_url = properties.getProperty("chejd.url");
            chejd_uid = properties.getProperty("chejd.uid");
            chejd_pwd = properties.getProperty("chejd.pwd");
            chejd_private_Key = properties.getProperty("chejd.private_Key");

            td_url = properties.getProperty("td_url");
            ;
            td_partner_code = properties.getProperty("td_partner_code");
            td_android_event_id = properties.getProperty("td_android_event_id");
            td_ios_event_id = properties.getProperty("td_ios_event_id");
            td_android_secret_key = properties.getProperty("td_android_secret_key");
            td_ios_secret_key = properties.getProperty("td_ios_secret_key");
            td_web_event_id=properties.getProperty("td_web_event_id");
            td_web_secret_key=properties.getProperty("td_web_secret_key");;


           ld_url =properties.getProperty("ld_url");
           ld_authCode =properties.getProperty("ld_authCode");
           ld_spId =properties.getProperty("ld_spId");

            BAIQISHI_APPID = properties.getProperty("BAIQISHI_APPID", "test");

            FACE_APPKEY = properties.getProperty("face.key");
            FACE_APPSecret = properties.getProperty("face.secret");

            jobFlag = Boolean.parseBoolean(properties.getProperty("job.flag"));

            FDD_APP_ID = properties.getProperty("fdd.appId");
            FDD_SERVER = properties.getProperty("fdd.server");
            FDD_APP_SECRET = properties.getProperty("fdd.appSecret");
            FDD_CUST_ID = properties.getProperty("fdd.custId");

            bairong_username = properties.getProperty("bairong.username");
            bairong_pwd = properties.getProperty("bairong.pwd");
            bairong_code = properties.getProperty("bairong.code");
             /*百融城市*/
            CityMap.put("北京", "beijing");
            CityMap.put("上海", "shanghai");
            CityMap.put("广州", "guangzhou");
            CityMap.put("成都", "chengdu");
            CityMap.put("西安", "xian");
            CityMap.put("青岛", "qingdao");
            CityMap.put("太原", "taiyuan");
            CityMap.put("郑州", "zhengzhou");
            CityMap.put("南昌", "nanchang");
            CityMap.put("银川", "yinchuan");
            CityMap.put("石家庄", "shijiazhuang");
            CityMap.put("厦门", "xiamen");
            CityMap.put("南京", "nanjing");
            CityMap.put("杭州", "hangzhou");
            CityMap.put("天津", "tianjin");
            CityMap.put("福州", "fuzhou");
            CityMap.put("廊坊", "langfang");
            CityMap.put("佛山", "foshan");
            CityMap.put("宁波", "ningbo");
            CityMap.put("苏州", "suzhou");
            CityMap.put("重庆", "chongqing");
            CityMap.put("沈阳", "shenyang");
            CityMap.put("长沙", "changsha");
            CityMap.put("深圳", "shenzhen");
            CityMap.put("无锡", "wuxi");
            CityMap.put("武汉", "wuhan");
            CityMap.put("济南", "jinan");
            CityMap.put("大连", "dalian");
            CityMap.put("东莞", "dongguan");
            CityMap.put("包头", "baotou");
            CityMap.put("九江", "jiujiang");
            CityMap.put("萍乡", "pingxiang");
            CityMap.put("呼和浩特", "huhehaote");
            CityMap.put("贵阳", "guiyang");
            CityMap.put("惠州", "huizhou");
            CityMap.put("湛江", "zhanjiang");
            CityMap.put("绍兴", "shaoxing");
            CityMap.put("南通", "nantong");
            CityMap.put("常州", "changzhou");
            CityMap.put("潍坊", "weifang");
            CityMap.put("中山", "zhongshan");
            CityMap.put("柳州", "liuzhou");
            CityMap.put("昆山", "kunshan");
            CityMap.put("昆明", "kunming");
            CityMap.put("温州", "wenzhou");
            CityMap.put("珠海", "zhuhai");
            CityMap.put("长春", "changchun");
            CityMap.put("南宁", "nanning");
            CityMap.put("哈尔滨", "haerbin");
            CityMap.put("宜昌", "yichang");
            CityMap.put("洛阳", "luoyang");
            CityMap.put("泸州", "luzhou");
            CityMap.put("吉林", "jilin");
            CityMap.put("秦皇岛", "qinhuangdao");
            CityMap.put("唐山", "tangshan");
            CityMap.put("扬州", "yangzhou");
            CityMap.put("赣州", "ganzhou");
            CityMap.put("乌鲁木齐", "wulumuqi");
            CityMap.put("兰州", "lanzhou");
            CityMap.put("西宁", "xining");
            CityMap.put("合肥", "hefei");
            CityMap.put("桂林", "guilin");
            CityMap.put("北海", "beihai");
            CityMap.put("济宁", "jining");
            CityMap.put("三亚", "sanya");
            CityMap.put("徐州", "xuzhou");
            CityMap.put("泉州", "quanzhou");
            CityMap.put("烟台", "yantai");
            CityMap.put("金华", "jinhua");
            CityMap.put("蚌埠", "bengbu");
            CityMap.put("海口", "haikou");
            CityMap.put("南充", "nanchong");
            CityMap.put("连云港", "lianyungang");
            CityMap.put("株洲", "zhuzhou");
            CityMap.put("清远", "qingyuan");
            CityMap.put("肇庆", "zhaoqing");
            CityMap.put("临沂", "linyi");
            CityMap.put("马鞍山", "maanshan");
            CityMap.put("莆田", "putian");
            CityMap.put("汕头", "shantou");
            CityMap.put("台州", "taizhou");
            CityMap.put("鞍山", "anshan");
            CityMap.put("泰安", "taian");
            CityMap.put("大庆", "daqing");
            CityMap.put("开封", "kaifeng");
            CityMap.put("淄博", "zibo");
            CityMap.put("安阳", "anyang");
            CityMap.put("平顶山", "pingdingshan");
            CityMap.put("延边", "yanbian");
            CityMap.put("新乡", "xinxiang");
            CityMap.put("丹东", "dandong");
            CityMap.put("锦州", "jinzhou");
            CityMap.put("盘锦", "panjin");
            CityMap.put("营口", "yingkou");
            CityMap.put("通辽", "tongliao");
            CityMap.put("安庆", "anqing");
            CityMap.put("德州", "dezhou");
            CityMap.put("鹤壁", "hebi");
            CityMap.put("漯河", "luohe");
            CityMap.put("濮阳", "puyang");
            CityMap.put("商丘", "shangqiu");
            CityMap.put("信阳", "xinyang");
            CityMap.put("许昌", "xuchang");
            CityMap.put("周口", "zhoukou");
            CityMap.put("驻马店", "zhumadian");
            CityMap.put("南阳", "nanyang");
            CityMap.put("三门峡", "sanmenxia");
            CityMap.put("黄石", "huangshi");
            CityMap.put("保定", "baoding");
            CityMap.put("宝鸡", "baoji");
            CityMap.put("宜宾", "yibin");
            CityMap.put("资阳", "ziyang");
            CityMap.put("遂宁", "suining");
            CityMap.put("达州", "dazhou");
            CityMap.put("拉萨", "lasa");
            CityMap.put("广安", "guangan");
            CityMap.put("眉山", "meishan");
            CityMap.put("滨州", "binzhou");
            CityMap.put("沧州", "cangzhou");
            CityMap.put("邯郸", "handan");
            CityMap.put("江门", "jiangmen");
            CityMap.put("泰州", "tai4zhou");
            CityMap.put("威海", "weihai");
            CityMap.put("芜湖", "wuhu");
            CityMap.put("咸阳", "xianyang");
            CityMap.put("襄阳", "xiangyang");
            CityMap.put("镇江", "zhenjiang");
            CityMap.put("盐城", "yancheng");
            CityMap.put("大同", "datong");
            CityMap.put("抚顺", "fushun");
            CityMap.put("焦作", "jiaozuo");
            CityMap.put("榆林", "yulin");
            CityMap.put("漳州", "zhangzhou");
            CityMap.put("承德", "chengde");
            CityMap.put("滁州", "chuzhou");
            CityMap.put("鄂州", "ezhou");
            CityMap.put("葫芦岛", "huludao");
            CityMap.put("临汾", "linfen");
            CityMap.put("六安", "luan");
            CityMap.put("龙岩", "longyan");
            CityMap.put("牡丹江", "mudanjiang");
            CityMap.put("宁德", "ningde");
            CityMap.put("钦州", "qinzhou");
            CityMap.put("曲靖", "qujing");
            CityMap.put("日照", "rizhao");
            CityMap.put("十堰", "shiyan");
            CityMap.put("渭南", "weinan");
            CityMap.put("长治", "changzhi");
            CityMap.put("遵义", "zunyi");
            CityMap.put("大理白族自治州", "dali");
            CityMap.put("吕梁", "luliang");
            CityMap.put("松原", "songyuan");
            CityMap.put("东营", "dongying");
            CityMap.put("赤峰", "chifeng");
            CityMap.put("巴彦淖尔", "bayannaoer");
            CityMap.put("鄂尔多斯", "eerduosi");
            CityMap.put("呼伦贝尔", "hulunbeier");
            CityMap.put("乌兰察布", "wulanchabu");
            CityMap.put("锡林浩特", "xilinhaote");
            CityMap.put("兴安盟", "xinganmeng");
            CityMap.put("锡林郭勒", "xilinguole");
            CityMap.put("舟山", "zhoushan");
            CityMap.put("湖州", "huzhou");
            CityMap.put("衢州", "quzhou");
            CityMap.put("丽水", "lishui");
            CityMap.put("嘉兴", "jiaxing");
            CityMap.put("苏州", "su4zhou");
            CityMap.put("宿迁", "suqian");
            CityMap.put("六盘水", "liupanshui");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
