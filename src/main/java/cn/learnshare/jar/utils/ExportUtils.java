package cn.learnshare.jar.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class is used to export files.
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class ExportUtils {

	/**
	 * Used to zip file.
	 * @param filePath the paths of the file to be zipped
	 * @param zipFilePath the path of the zip file to be created
	 * @return true if the file is deleted successfully, false otherwise
	 * @since 1.0.1
	 */
	public static boolean zip(String filePath, String zipFilePath) {
		List<String> list = new ArrayList<>();
		list.add(filePath);
		return zip(list, zipFilePath);
	}

	/**
	 * Used to zip files.
	 * @param filePaths the paths of the files to be zipped
	 * @param zipFilePath the path of the zip file to be created
	 * @return true if the file is deleted successfully, false otherwise
	 * @since 1.0.1
	 */
	public static boolean zip(List<String> filePaths, String zipFilePath) {
		FileOutputStream fos = null;
		ZipOutputStream out = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(zipFilePath);
			out = new ZipOutputStream(fos);
			for (int i = 0; i < filePaths.size(); i++) {
				File file = new File(filePaths.get(i));
				fis = new FileInputStream(file);
				ZipEntry zip = new ZipEntry(file.getName());
				out.putNextEntry(zip);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = fis.read(bytes)) >= 0) {
					out.write(bytes, 0, length);
				}
				out.closeEntry();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (fis!= null) {
					fis.close();
				}
				if (out!= null) {
					out.close();
				}
				if (fos!= null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}