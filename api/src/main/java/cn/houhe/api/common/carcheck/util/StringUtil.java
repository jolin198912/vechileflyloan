package cn.houhe.api.common.carcheck.util;

public class StringUtil {

	/**
	 * 判断字符串为null或""字符串或"  "字符串。
	 * @author 史春阳
	 * @param str 字符串
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str) || "".equals(str.trim()));
	}
}
