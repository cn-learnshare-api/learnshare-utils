package cn.learnshare.jar.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class is responsible for encrypting and decrypting SHA-256 hash values.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class EncryptShaUtils {

	/**
	 * SHA1 encrypt
	 *
	 * @param str is the string to be encrypted
	 * @return encrypted string
	 */
	public static String sha1(String str) {
		return encrypt(str, "sha1");
	}

	/**
	 * sha encrypt
	 *
	 * @param str is the string to be encrypted
	 * @param algorithm is the algorithm
	 * @return encrypted string
	 * @since 1.0.1
	 */
	public static String encrypt(String str, String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] hashedBytes = md.digest(str.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hashedBytes) {
				String hex = Integer.toHexString(0xFF & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

}