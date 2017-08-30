package cn.houhe.api.common.carcheck.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * SignUtils  签名工具类。
 * @author 史春阳
 */
public class SignUtils {
	/**
	 * 签名类型
	 */
	public static final String SIGN_TYPE = "RSA";
	/**
	 * 签名算法
	 */
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	/**
	 * 编码
	 */
	private static final String DEFAULT_CHARSET = "utf-8";
	

	/**
	* RSA签名
	* @param data 待签名数据
	* @param privateKey 私钥
	* @return 签名值
	*/
	public static String getSign(String data, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			Signature signature = Signature.getInstance("SHA1WithRSA");

			signature.initSign(priKey);
			signature.update(data.getBytes(DEFAULT_CHARSET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * RSA验签名检查
	 * 
	 * @param data
	 *            待签名数据
	 * @param sign
	 *            签名值
	 * @param publicKey
	 *            公钥
	 * @return 布尔值 返回true  签名验证成功  否则签名失败
	 */
	public static boolean checkSign(String data, String sign, String publicKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(SIGN_TYPE);

			byte[] encodedKey = Base64.decode(publicKey);

			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);

			signature.update(data.getBytes(DEFAULT_CHARSET));

			return signature.verify(Base64.decode(sign));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
}

