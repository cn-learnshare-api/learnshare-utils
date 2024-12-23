package cn.learnshare.jar.utils.file;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * This class is about image manipulation.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class FileImageUtils {

	/**
	 * Write the content to IMG file
	 *
	 * @param data the content to be written to the file
	 * @param savePath the path of the file to be saved
	 * @return true if the content is written to the file successfully, false otherwise
	 */
	public static boolean writeByteToFile(byte[] data, String savePath) {
		if(data == null || data.length == 0){
			return false;
		} else {
			FileOutputStream fos = null;
			try {
				File dest = new File(savePath);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				fos = new FileOutputStream(savePath);
				fos.write(data);
				fos.flush();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}