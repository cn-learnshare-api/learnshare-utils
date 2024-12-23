package cn.learnshare.jar.utils;

/**
 * This class is designed to desensitize data.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class DesensitizeUtils {

	/**
	 * desensitize phone number
	 *
	 * @param phoneNumber to be desensitized
	 * @return phone number after desensitization
	 */
	public static String phone(String phoneNumber) {
		if (StringUtils.isEmpty(phoneNumber) || phoneNumber.length() <= 7) {
			return phoneNumber;
		}
		return common(phoneNumber, 3, 4, "*");
	}


	/**
	 * desensitize email address
	 *
	 * @param email to be desensitized
	 * @return email address after desensitization
	 */
	public static String email(String email) {
		if (StringUtils.isEmpty(email) || email.length() <= 5) {
			return email;
		}
		int index = email.indexOf("@");
		if (index == -1) {
			return email;
		}
		String prefix = email.substring(0, index);
		String suffix = email.substring(index);
		return prefix + common(suffix, 1, 1, "*") + "@";
	}

	/**
	 * desensitize ID card number
	 *
	 * @param idCard to be desensitized
	 * @return ID card number after desensitization
	 */
	public static String idCard(String idCard) {
		if (StringUtils.isEmpty(idCard) || idCard.length() <= 10) {
			return idCard;
		}
		return common(idCard, 6, 4, "*");
	}

	/**
	 * desensitize bank card number
	 *
	 * @param cardNumber to be desensitized
	 * @return bank card number after desensitization
	 */
	public static String bankCard(String cardNumber) {
		if (StringUtils.isEmpty(cardNumber) || cardNumber.length() <= 10) {
			return cardNumber;
		}
		return common(cardNumber, 6, 4, "*");
	}

	/**
	 * desensitize strings
	 *
	 * @param origin to be desensitized
	 * @param prefixNoMaskLen left side need to keep plaintext length
	 * @param suffixNoMaskLen right side need to keep plaintext length
	 * @param star masking character
	 * @return string after desensitization
	 */
	public static String common(String origin, int prefixNoMaskLen, int suffixNoMaskLen, String star) {
		if (StringUtils.isEmpty(origin) || origin.length() == 1) {
			return origin;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, n = origin.length(); i < n; i++) {
			if (i < prefixNoMaskLen) {
				sb.append(origin.charAt(i));
				continue;
			}
			if (i > (n - suffixNoMaskLen - 1)) {
				sb.append(origin.charAt(i));
				continue;
			}
			sb.append(star);
		}
		return sb.toString();
	}

}