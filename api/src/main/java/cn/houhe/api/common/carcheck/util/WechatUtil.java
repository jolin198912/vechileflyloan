package cn.houhe.api.common.carcheck.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
 

@SuppressWarnings("all")
public class WechatUtil {
	
	/**
	 * 上传
	 */
	public static String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap,String contentType,String sessionId) {
		String res = "";
		
		HttpURLConnection conn = null;
		
		String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
		
		try {
			URL url = new URL(urlStr);
			
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			
			conn.setRequestMethod("POST");
			
			if(!StringUtil.isEmpty(sessionId))
				conn.setRequestProperty("Cookie", sessionId);
			
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			
			conn.connect();

			BufferedOutputStream out = new BufferedOutputStream(new DataOutputStream(conn.getOutputStream()));
			
			//普通文本项
			if (textMap != null) {
				StringBuffer strBuf = new StringBuffer();
				
				Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
				
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = iter.next();
					String inputName = (String) entry.getKey();
					
					String inputValue = (String) entry.getValue();
					if (inputValue == null) {
						continue;
					}
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
					
					strBuf.append(inputValue);
				}
				
				System.out.println(strBuf.toString());
				
				out.write(strBuf.toString().getBytes());
			}

			// 文件文本项
			if (fileMap != null) {
				Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
				
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = iter.next();
					
					String inputName = (String) entry.getKey();
					String inputValue = (String) entry.getValue();
					
					if (inputValue == null) {
						continue;
					}
					
					File file = new File(inputValue);
					String filename = file.getName();
					

					StringBuffer strBuf = new StringBuffer();
					
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
							+ "\"\r\n");
					
					strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

					out.write(strBuf.toString().getBytes());

					BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
					
					int bytes = -1;
					
					byte[] bufferOut = new byte[1024];
					
					while ((bytes = in.read(bufferOut)) != -1) {
						out.write(bufferOut, 0, bytes);
					}
					
					in.close();
				}
			}

			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();
			out.close();

			// 读取返回数据
			StringBuffer strBuf = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuf.append(line).append("\n");
			}
			res = strBuf.toString();
			reader.close();
			reader = null;
		} catch (Exception e) {
			System.out.println(urlStr+",访问异常");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
		
		return res;
	}
}
