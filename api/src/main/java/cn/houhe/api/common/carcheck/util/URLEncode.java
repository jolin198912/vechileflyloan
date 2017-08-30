package cn.houhe.api.common.carcheck.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.BitSet;

public class URLEncode {
	
	private URLEncode() {
	}

	static BitSet dontNeedEncoding;

	static {
		dontNeedEncoding = new BitSet(256);
		int i;
		for (i = 'a'; i <= 'z'; i++) {
			dontNeedEncoding.set(i);
		}
		for (i = 'A'; i <= 'Z'; i++) {
			dontNeedEncoding.set(i);
		}
		for (i = '0'; i <= '9'; i++) {
			dontNeedEncoding.set(i);
		}
		dontNeedEncoding.set(' '); 
		dontNeedEncoding.set('-');
		dontNeedEncoding.set('_');
		dontNeedEncoding.set('.');
		dontNeedEncoding.set('*');

		dontNeedEncoding.set('+');
		dontNeedEncoding.set('%');
	}

	/**
	 * 判断段落文本是否被urlencode过
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isURLEncoded(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		char[] chars = str.toCharArray();
		boolean containsPercent = false;
		for (char c : chars) {
			if (Character.isWhitespace(c)) {
				return false;
			}
			if (!dontNeedEncoding.get(c)) {
				return false;
			}
			if (c == '%') {
				containsPercent = true;
			}
		}
		if (!containsPercent) {
			return false;
		}
		return true;
	}

	public static final String encodeURL(String str) {
		try {
			return URLEncoder.encode(str, "utf-8");
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static final String decodeURL(String str) {
		try {
			return URLDecoder.decode(str, "utf-8");
		}catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		String str = "查询失败,您消费的一份核查报告已退还";
		String encode_str = "%E6%9F%A5%E8%AF%A2%E5%A4%B1%E8%B4%A5%2C%E6%82%A8%E6%B6%88%E8%B4%B9%E7%9A%84%E4%B8%80%E4%BB%BD%E6%A0%B8%E6%9F%A5%E6%8A%A5%E5%91%8A%E5%B7%B2%E9%80%80%E8%BF%98";
		
		System.out.println(decodeURL(encode_str));// 查询失败,您消费的一份核查报告已退还
		
		System.out.println(encode_str.equals(encodeURL(str)));// true(相同)
		
		System.out.println(isURLEncoded(str));// false
		System.out.println(isURLEncoded(encode_str));// true(经过URL编码。)
	}
}
