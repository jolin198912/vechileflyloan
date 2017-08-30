package cn.houhe.api.common.carcheck.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
 

/**
 * HttpUtil
 * 
 * @createTime 创建时间：2016-06-21 
 * @author 史春阳
 * @version 2.1
 */
public class HttpUtil {
 
	
	
	private static String charset = "UTF-8";
	
	public static String proxy = "close"; // open:开启代理 other：不开启
	public static String proxy_host = "";//代理主机
	public static int proxy_port = 0;
	
	
	
	public static String httpReuqest(String requestUrl,String requestMethod,String data){
		StringBuffer sb = new StringBuffer();//用来装载返回数据
		String resultLine = null;//读取到的返回数据的每行数据。
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";// 模拟浏览器
		String lineSeparator = System.getProperty("line.separator", "\r\n");//换行符号。
		OutputStream out = null;//需要关闭资源。
		HttpURLConnection connection = null;//需要关闭资源
		BufferedReader reader = null;//需要关闭资源。
		try{
			URL url = new URL(requestUrl);// 连接URL地址
			/**
			 * 根据访问requestUrl,打开连接,requestUrl.openConnection()函数会根据URL的类型,
			 * 返回不同的URLConnection子类的对象,这里requestUrl是一个http请求,因此实际返回的是HttpURLConnection。
			 */
			if("open".equals(proxy)){
				//开启代理。
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy_host,proxy_port));
				connection = (HttpURLConnection) url.openConnection(proxy);
			}else{
				connection = (HttpURLConnection) url.openConnection();
			}
			//设置连接访问方法及超时参数
			connection.setRequestMethod(requestMethod);
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.setRequestProperty("Connection","keep-alive");
			connection.setRequestProperty("Accept","*/*");
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			//post请求特有的
			connection.setDoOutput(true);//允许输出流
			connection.setDoInput(true); // 允许输入流
			connection.setUseCaches(false);//禁用缓存
			connection.setInstanceFollowRedirects(true);  //允许重定向
			if(null != data)
				connection.setFixedLengthStreamingMode(data.getBytes().length);//输出的字节数。
			//进行连接,但是实际上要在下一句的connection.getInputStream()函数中才会真正发到 服务器。
			
			//---
			System.out.println("请求头：");
			System.out.println("Content-Type："+connection.getRequestProperty("Content-Type"));
			//获取请求头
			Map<String, List<String>> requestmap = connection.getRequestProperties();
			Set<String> requestkeySet = requestmap.keySet();
			for(String key:requestkeySet){
				List<String> list = requestmap.get(key);
				System.out.print(key+":");
				for(String value :list){
					System.out.print(" "+value);
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------");
			//---
			connection.connect();
			if(null !=data){
				 out = connection.getOutputStream();//-------------------------------------释放资源。
	             // 注意编码格式,防止中文乱码
                 out.write(data.getBytes("UTF-8"));
			}
			
			//获取响应头-------------------------------------------------------
			System.out.println("响应头：");
			System.out.println("Content-Language："+connection.getHeaderField("Content-Language"));
			Map<String, List<String>> map = connection.getHeaderFields();
			Set<String> keySet = map.keySet();
			for(String key:keySet){
				List<String> list = map.get(key);
				System.out.print(key+":");
				for(String value :list){
					System.out.print(" "+value);
				}
				System.out.println();
			}
			System.out.println("*--------------------------------------");
			//获取响应头-------------------------------------------------------结束
	//		List<String> contentList = map.get(null);//获取响应首行。
	//		if(contentList!=null && contentList.toString()!=null && contentList.toString().indexOf("200")!=-1){System.out.println("这个也可以");}//说明请求成功。
			
			int code = connection.getResponseCode();
			if(code==200){
				// 读取数据编码处理
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
				while ((resultLine = reader.readLine()) != null) {
					sb.append(resultLine);
					sb.append(lineSeparator);
				}
			}else{
				 
				return "error"+code+"_"+requestUrl;
			}
		}catch(Exception e){
			 
			return "error_"+requestUrl+"_访问异常";
		}finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					return "error_reader关闭异常_"+requestUrl;
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					return "error_out关闭异常_"+requestUrl;
				}
			}
			if(connection!=null){
				connection.disconnect();
			}
		}
		return sb.toString().trim();
	}
}
