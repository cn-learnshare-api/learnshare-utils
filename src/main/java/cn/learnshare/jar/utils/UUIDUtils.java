package cn.learnshare.jar.utils;

import java.util.UUID;

/**
 * This class is used to generate UUID.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class UUIDUtils {

	/**
	 * Used to generate a UUID.
	 *
	 * @return a UUID string，length is 32
	 */
	public static String makeId(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}

	/**
	 * Used to generate a UUID.
	 *
	 * @param multiple the number of UUIDs to be generated
	 * @return a UUID string，length is 32 * multiple
	 */
	public static String makeId(int multiple){
		String uuid = "";
		for (int i = 0; i < multiple; i++) {
			uuid += makeId();
		}
		return uuid;
	}

}