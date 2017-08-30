package cn.houhe.api.common;

import cn.com.iotrust.common.ServiceOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by think on 2017/6/1.
 */
public class IDCardUtil {
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(IDCardUtil.class);
    static {
        try {
            properties.load(IDCardUtil.class.getClassLoader().getResourceAsStream("native.properties"));
        } catch (IOException e) {
            logger.error("未找到省份文件",e);
        }
    }
    public static int sex(String id){
        Assert.notNull(id,"身份证不能为空");
        Character flag = null;
        if (id.length() == 15){
            flag = id.charAt(id.length() - 1);
        }else if (id.length() == 18){
            flag = id.charAt(id.length() - 2);
        }else {
            throw new ServiceOperationException("身份证不合法");
        }
        //奇数是男，偶数为女
        return Integer.valueOf(flag.toString()) % 2 == 0 ? 1 : 0;
    }


    public static String nativePlace(String id){
        Assert.notNull(id,"身份证不能为空");
        if (id.length() > 2) {
            String provinceCode = id.substring(0, 2);
            String province = properties.getProperty(provinceCode + "00");
            if (province != null) {
                return province;
            }
        }
        throw new ServiceOperationException("身份证不合法");
    }

    public static void main(String[] args) {
        System.out.println( "sex: "+ sex("420521198807245300"));
        System.out.println( "native : "+ nativePlace("420521198807245300"));
    }
}
