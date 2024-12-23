package cn.learnshare.jar.utils;

/**
 * This class is designed to handle string related operations.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class StringUtils {

	/**
	 * Used to check if the string is empty.
	 *
	 * @param str the string to check
	 * @return true if the string is empty, false otherwise
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * Used to check if the string is not empty.
	 *
	 * @param str the string to check
	 * @return true if the string is not empty, false otherwise
	 */
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}

}