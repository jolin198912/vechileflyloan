package cn.houhe.api.common.carcheck.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类。
 * @author 史春阳
 * @version 2.0
 */
public final class DateUtil {
	public static final String LOCAL_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private DateUtil() {
	}

	/**
	 * 2.获取当前时间。(字符串：yyyy-MM-dd HH:mm:ss)
	 * @return 
	 * 		字符串：yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(LOCAL_DATETIME_FORMAT);
		return dateFormat.format(new Date());
	}
	
}