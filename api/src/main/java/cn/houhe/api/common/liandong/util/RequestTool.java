package cn.houhe.api.common.liandong.util;

import cn.com.iotrust.common.ServiceException;
import cn.houhe.api.common.Configs;
import cn.houhe.api.common.carcheck.util.URLEncode;
import cn.houhe.api.common.liandong.SendSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/24.
 */
public class RequestTool {
    private static Logger logger = LoggerFactory.getLogger(RequestTool.class);
    public static String request(String  jsonparams,String u) {
        try {
            String CharsetName="GBK";
            URL url = new URL(u);
            HttpURLConnection conn  = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json;charset="+CharsetName);
            conn.setConnectTimeout(1000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            byte[] bts= jsonparams.getBytes(Charset.forName(CharsetName));
            conn.getOutputStream().write(bts);
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), CharsetName));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            String res=result.toString();
            logger.info("发送短信:"+res);
            return res.trim();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发送短信异常"+e.getMessage());
            return e.getMessage();
        }
    }
}