package com.zhangyuhao.cms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	/**
	 * 一天有多少毫秒
	 */
	static final int millSeconds = 1000*60*60*24;
	/**
	 * 计算年龄
	 * @param birthday
	 * @return
	 */
	public static int getAge(Date birthday){
		//2018 12 4 // 5 // 6
		Calendar caledar = Calendar.getInstance();
		//计算出生的年、月、日
		caledar.setTime(birthday);
		int year = caledar.get(Calendar.YEAR);
		int month = caledar.get(Calendar.MONTH);
		int date = caledar.get(Calendar.DATE);
		//计算当前的年、月、日
		caledar.setTime(new Date());
		int nyear = caledar.get(Calendar.YEAR);
		int nmonth = caledar.get(Calendar.MONTH);
		int ndate = caledar.get(Calendar.DATE);
		
		int age = nyear-year;
		// 如果当前的月份小 则年龄减去1
		if(nmonth<month){
			age--;
		}else if(nmonth==month&&ndate<date){
			age--;
		}
		
		return age;
	}
	/**
	 * 计算还剩多少天
	 * @param future
	 * @return
	 */
	public static int getRemainDays(Date future){
		return (int) ((future.getTime()-new Date().getTime())/millSeconds);
	}
	/**
	 * 判断是否是当天
	 * @param date
	 * @return
	 */
	public static boolean inToday(Date date){
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");
		
		String format = dateForm.format(date);// 参数格式化成一个字符串
		
		String to = dateForm.format(new Date());// 把当前日期格式化成字符串
		
		return format.equals(to);
	}
	/**
	 * 获取当月的月初
	 * @return
	 */
	public static Date getBeginOfMonth(){
		// 获取日历的实例
		Calendar instance = Calendar.getInstance();
		// 设置成当前的时间
		instance.setTime(new Date());
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.AM_PM, Calendar.AM);
		instance.set(Calendar.DATE, 1);
		return instance.getTime();
	}
	
	/**
	 * 获取当前月的月末
	 * @return
	 */
	public static Date getEndOfMonth() {
		// 获取日历的实例
		Calendar instance = Calendar.getInstance();
		// 设置成当前的时间
		instance.setTime(new Date());
		instance.add(Calendar.MONTH, 1);// 月份加1
		
		// 下列代码设置成月初
		instance.set(Calendar.SECOND, 0);// 设置0秒
		instance.set(Calendar.MINUTE, 0);// 设置0分
		instance.set(Calendar.HOUR, 0);// 设置0小时
		instance.set(Calendar.AM_PM, Calendar.AM);// 设置上午
		instance.set(Calendar.DATE, 1);// 设置1日
		
		// 减去一秒 变成当月的月末
		instance.add(Calendar.SECOND, -1);// 秒减去1
		return instance.getTime();
		
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static boolean  isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7-day+1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));
		
		return (date.getTime()<lastDayOfWeek.getTime().getTime() &&
				date.getTime()>firstDayOfWeek.getTime().getTime() );

	}
}
