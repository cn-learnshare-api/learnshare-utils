package cn.learnshare.jar.utils;

import java.util.Random;

/**
 * This class is designed to handle number related operations.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class NumberUtils {

	/**
	 * Generate a random number between min and max (inclusive)
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return a random number between min and max (inclusive)
	 */
	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	/**
	 * Calculate the greatest common divisor of two integers.
	 * @param a the first integer
	 * @param b the second integer
	 * @return the greatest common divisor of a and b
	 */
	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

}