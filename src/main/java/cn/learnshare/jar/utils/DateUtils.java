package cn.learnshare.jar.utils;

import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class is designed to handle date related operations.
 *
 * @author xuezhifenxiang
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateUtils {

	/**
	 * Create a random datetime string in today.
	 *
	 * @return a random datetime string in today
	 */
	public static String create(){
		return create("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Create a random date time string for today within the specified hours.
	 *
	 * @param minHours the minimum hours of the date
	 * @param maxHours the maximum hours of the date
	 * @return a random date string between the specified hours
	 */
	public static String create(int minHours, int maxHours){
		String baseDate = create("yyyy-MM-dd");
		Random random = new Random();
		int hour = (random.nextInt(maxHours - minHours + 1) + minHours);
		baseDate += " " + (hour < 10 ? "0" + hour : hour);
		int minute = (random.nextInt(59 - 1 + 1) + 1);
		int second = (random.nextInt(59 - 1 + 1) + 1);
		baseDate += ":" + (minute < 10 ? "0" + minute : minute);
		baseDate += ":" + (second < 10 ? "0" + second : second);
		return baseDate;
	}

	/**
	 * Create a random datetime string in today with the specified format.
	 *
	 * @param format the format of the datetime string
	 * @return a random datetime string in today with the specified format
	 */
	public static String create(String format){
		return format(new Date(), format);
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param date the date to be formatted
	 * @return the formatted date string
	 */
	public static String format(String date){
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param fileTime the date to be formatted
	 * @return the formatted date string
	 */
	public static String format(FileTime fileTime){
		return format(fileTime, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param fileTime the date to be formatted
	 * @param format the format of the datetime string
	 * @return the formatted date string
	 */
	public static String format(FileTime fileTime, String format){
		LocalDateTime dateTime = fileTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return dateTime.format(formatter);
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param date the date to be formatted
	 * @return the formatted date string
	 */
	public static String format(Date date){
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param date the date to be formatted
	 * @return the formatted date string
	 */
	public static String format(long date){
		return format(new Date(date), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param date the date to be formatted
	 * @param format the format of the datetime string
	 * @return the formatted date string
	 */
	public static String format(String date, String format){
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * Format the specified date with the specified format.
	 *
	 * @param date the date to be formatted
	 * @param format the format of the datetime string
	 * @return the formatted date string
	 */
	public static String format(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * Get the number of days between today and the specified date.
	 *
	 * @param date the specified date
	 * @return the number of days between today and the specified date
	 */
	public static int getBetweenDays(String date) {
		return getBetweenDays(date, create());
	}

	/**
	 * Get the number of days between two dates.
	 *
	 * @param date1 the first date
	 * @param date2 the second date
	 * @return the number of days between two dates
	 */
	public static int getBetweenDays(String date1, String date2) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(date1.replaceAll("-", "/")));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(date2.replaceAll("-", "/")));
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Math.abs(Integer.parseInt(String.valueOf(between_days)));
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Get the last date of the specified date.
	 *
	 * @return the last date of the specified date
	 */
	public static String getLastDate(){
		return getLastDate(new Date());
	}

	/**
	 * Get the last date of the specified date.
	 *
	 * @param date the specified date
	 * @return the last date of the specified date
	 */
	public static String getLastDate(Date date){
		return getLastDate(format(date, "yyyy-MM-dd"));
	}

	/**
	 * Get the last date of the specified date.
	 *
	 * @param date the specified date
	 * @return the last date of the specified date
	 */
	public static String getLastDate(String date){
		return LocalDate.parse(date).minus(1, ChronoUnit.DAYS).toString();
	}

	/**
	 * Get the last month of the specified date.
	 *
	 * @return the last month of the specified date
	 */
	public static String getLastMonth(){
		return getLastMonth(new Date());
	}

	/**
	 * Get the last month of the specified date.
	 *
	 * @param date the specified date
	 * @return the last month of the specified date
	 */
	public static String getLastMonth(String date){
		return getLastMonth(format(date, "yyyy-MM-dd"));
	}

	/**
	 * Get the last month of the specified date.
	 *
	 * @param date the specified date
	 * @return the last month of the specified date
	 */
	public static String getLastMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		return format(calendar.getTime(), "yyyy-MM");
	}

	/**
	 * Get the last year of the specified date.
	 *
	 * @return the last year of the specified date
	 */
	public static String getLastYear(){
		return getLastYear(new Date());
	}

	/**
	 * Get the last year of the specified date.
	 *
	 * @param date the specified date
	 * @return the last year of the specified date
	 */
	public static String getLastYear(String date){
		return getLastYear(format(date, "yyyy-MM-dd"));
	}

	/**
	 * Get the last year of the specified date.
	 *
	 * @param date the specified date
	 * @return the last year of the specified date
	 */
	public static String getLastYear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);
		return format(calendar.getTime(), "yyyy");
	}

}