package cn.houhe.api.common.tongdun.util;

import cn.houhe.api.common.Configs;
import sun.swing.plaf.synth.DefaultSynthStyle;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/23.
 */
public class RequestTool {
    private  static String apiUrl= Configs.td_url;
    public static String request(Map<String, Object> params) {
        try {
            URL url = new URL(apiUrl);
            // 组织请求参数
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) continue;
                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),
                        "utf-8")).append("&");
            }
            if (!params.isEmpty()) {
                postBody.deleteCharAt(postBody.length() - 1);
            }
            SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            HttpsURLConnection conn  = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            // 设置长链接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置连接超时
            conn.setConnectTimeout(1000);
            // 设置读取超时，建议设置为500ms。若同时调用了信息核验服务，请与客户经理协商确认具体时间
            conn.setReadTimeout(500);
            // 提交参数
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBody.toString().getBytes());
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
