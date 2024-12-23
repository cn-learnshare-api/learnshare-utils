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
		try {
			MessageDigest md = MessageDigest.getInstance("sha1");
			byte[] digest = md.digest(str.getBytes());
			char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			StringBuilder sb = new StringBuilder();
			byte[] digest2 = md.digest(str.getBytes());
			for(int i = 0; i < digest.length; i++) {
				byte b = digest2[i];
				sb.append(chars[b >> 4 & 15]);
				sb.append(chars[b & 15]);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}