package cn.learnshare.jar.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * This class is used to execute shell commands in Java.
 *
 * @author xuezhifenxiang
 * @version 1.0.1
 * @since 1.0.1
 */
public class ShellUtils {

	/**
	 * Execute a shell command.
	 *
	 * @param commands the commands to be executed
	 * @return true if the command is executed successfully, false otherwise
	 */
	private static boolean exec(List<String> commands){
		ProcessBuilder builder = new ProcessBuilder(commands);
		InputStreamReader input = null;
		Process process = null;
		try {
			builder.redirectErrorStream(true);
			process = builder.start();
			input = new InputStreamReader(process.getInputStream());
			try (BufferedReader reader = new BufferedReader(input)) {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Command executed successfully.");
				return true;
			} else {
				System.err.println("Command execution failed with exit code: " + exitCode);
				return false;
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (process!= null){
					process.destroyForcibly();
					process.destroy();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (input!= null){
					input.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}