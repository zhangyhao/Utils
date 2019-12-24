package com.zhangyuhao.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekUtils {

	
	/**
	 * 根据传入的yyyy-MM-dd获取星期几是否是奇数 比如:2019-12-24:false,2019-12-25:true
	 * 
	 * @param strDate
	 * @return boolean
	 */

	public static boolean isOddDayOfWeekFromDate(String strDate) {
		boolean flag = true;
		int year = getYearFromDate(strDate);
		int month = getMonthFromDate(strDate);
		int day = getDayFromDate(strDate);
		int dayOfWeek = whatday(year, month, day);
		if (dayOfWeek % 2 == 0) {// 偶数
			flag = false;
		}
		return flag;
	}

	/**
	 * 根据传入的yyyy-MM-dd HH:mm:ss获取星期几是否是奇数 比如:2019-12-24 23:12:21:false,2019-12-25
	 * 09:12:21:true
	 * 
	 * @param strDateTime
	 * @return boolean
	 */
	public static boolean isOddDayOfWeekFromDateTime(String strDateTime) {

		boolean flag = true;
		int year = getYearFromDateTime(strDateTime);
		int month = getMonthFromDateTime(strDateTime);
		int day = getDayFromDateTime(strDateTime);
		int dayOfWeek = whatday(year, month, day);
		if (dayOfWeek % 2 == 0) {// 偶数
			flag = false;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(isOddDayOfWeekFromDate("2019-12-23"));
	}

	// 基姆拉尔森计算公式根据日期判断星期几
	public static void CalculateWeekDay(int y, int m, int d) {
		if (m < 1 || m > 12) {
			System.out.println("你输入的月份不再范围内，请重新输入！");
		}
		if (m == 1 || m == 2) {
			m += 12;
			y--;
		}
		int iWeek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
		switch (iWeek) {
		case 0:
			System.out.printf("星期一\n");
			break;
		case 1:
			System.out.printf("星期二\n");
			break;
		case 2:
			System.out.printf("星期三\n");
			break;
		case 3:
			System.out.printf("星期四\n");
			break;
		case 4:
			System.out.printf("星期五\n");
			break;
		case 5:
			System.out.printf("星期六\n");
			break;
		case 6:
			System.out.printf("星期日\n");
			break;
		}
	}

	/**
	 * 蔡勒公式
	 * 
	 * @param y:年
	 * @param m:月
	 * @param d:日
	 * @return
	 */
	public static int whatday(int y, int m, int d) {
		int ans;
		if (m == 1 || m == 2) {
			m += 12;
			y--;
		}
		if ((y < 1752) || (y == 1752 && m < 9) || (y == 1752 && m == 9 && d < 3))
			ans = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 + 5) % 7 + 1;
		else
			ans = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7 + 1;
		return ans;
	}

	/**
	 * 根据给定格式日期获取整数年份
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 */
	public static int getYearFromDate(String dateStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		// int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		// int month = ca.get(Calendar.MONTH)+1;// 第几个月
		int year = ca.get(Calendar.YEAR);// 年份数值
		return year;
	}

	
	/**
	 * 根据给定格式日期获取整数月份
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 */
	public static int getMonthFromDate(String dateStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		// int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		int month = ca.get(Calendar.MONTH) + 1;// 第几个月
		// int year = ca.get(Calendar.YEAR);// 年份数值
		return month;
	}


	/**
	 * 根据给定格式日期获取整数月份中的天数
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 */
	public static int getDayFromDate(String dateStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		// int month = ca.get(Calendar.MONTH)+1;// 第几个月
		// int year = ca.get(Calendar.YEAR);// 年份数值
		return day;
	}


	/**
	 * 根据给定格式日期获取整数年份
	 * 
	 * @param dateTimeStr
	 *            yyyy-MM-dd HH:mm:ss
	 */
	public static int getYearFromDateTime(String dateTimeStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeStr);
		} catch (ParseException e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd HH:mm:ss格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		// int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		// int month = ca.get(Calendar.MONTH)+1;// 第几个月
		int year = ca.get(Calendar.YEAR);// 年份数值
		return year;
	}

	/**
	 * 根据给定格式日期获取整数月份
	 * 
	 * @param dateTimeStr
	 *            yyyy-MM-dd HH:mm:ss
	 */
	public static int getMonthFromDateTime(String dateTimeStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeStr);
		} catch (ParseException e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd HH:mm:ss格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		// int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		int month = ca.get(Calendar.MONTH) + 1;// 第几个月
		// int year = ca.get(Calendar.YEAR);// 年份数值
		return month;
	}

	/**
	 * 根据给定格式日期获取整数月份中的天数
	 * 
	 * @param dateTimeStr
	 *            yyyy-MM-dd HH:mm:ss
	 */
	public static int getDayFromDateTime(String dateTimeStr) {
		// 获取string对应date日期：
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeStr);
		} catch (Exception e) {
			System.out.println("你输入的日期格式不是:yyyy-MM-dd HH:mm:ss格式");
			e.printStackTrace();
		}
		// 获取date对应的Calendar对象
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		// 3、可以从ca中获取各种该日期的属性值：
		int day = ca.get(Calendar.DAY_OF_MONTH);// 一个月中的第几天
		// int month = ca.get(Calendar.MONTH)+1;// 第几个月
		// int year = ca.get(Calendar.YEAR);// 年份数值
		return day;
	}
	
}
