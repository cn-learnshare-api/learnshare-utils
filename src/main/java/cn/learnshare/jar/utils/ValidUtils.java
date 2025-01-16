package cn.learnshare.jar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to validate the input parameters.
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class ValidUtils {

	/**
	 * This method is used to validate the phone number.
	 *
	 * @param str the input string to be validated
	 * @return true if the input string is a valid phone number, otherwise false
	 * @since 1.0.1
	 */
	public static Boolean isPhone(String str){
		Pattern pattern = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * This method is used to validate the email address.
	 *
	 * @param str the input string to be validated
	 * @return true if the input string is a valid email address, otherwise false
	 * @since 1.0.1
	 */
	public static Boolean isEmail(String str){
		String exprEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";
		return str.matches(exprEmail);
	}

}