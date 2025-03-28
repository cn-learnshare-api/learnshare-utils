package cn.learnshare.jar.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is used to handle directory operations.
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class DirectoryUtils {

	/**
	 * This method is used to create a directory.
	 *
	 * @param dirPath the directory path to be created
	 * @return true if the directory is created successfully, false otherwise
	 * @since 1.0.1
	 */
	public static boolean mk(String dirPath){
		try {
			File f = new File(dirPath);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is used to move a directory.
	 *
	 * @param originalDirPath the original directory path to be created
	 * @param targetDirPath the target directory path to be created
	 * @return true if the directory is created successfully, false otherwise
	 * @since 1.0.1
	 */
	public static boolean mv(String originalDirPath, String targetDirPath) {
		try {
			File f = new File(targetDirPath);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			Path sourceDirectory = Paths.get(originalDirPath);
			Path targetDirectory = Paths.get(targetDirPath);
			Files.move(sourceDirectory, targetDirectory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method is used to delete a directory.
	 *
	 * @param dirPath the directory path to be deleted
	 * @since 1.0.1
	 */
	public static void del(String dirPath) {
		File directory = new File(dirPath);
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (File file : files) {
					if (file.isDirectory()) {
						del(file.getPath());
					} else {
						file.delete();
					}
				}
			}
		}
		directory.delete();
	}

	/**
	 * This method is used to get the size of a directory.
	 *
	 * @param directory the directory to be calculated
	 * @return the size of the directory in bytes
	 * @since 1.0.1
	 */
	public static long size(File directory) {
		long size = 0;
		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					size += file.length();
				} else {
					size += size(file);
				}
			}
		}
		return size;
	}

}