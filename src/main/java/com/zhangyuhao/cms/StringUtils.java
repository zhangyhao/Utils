package com.zhangyuhao.cms;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	
	static char charArray[]=new char[36];
	static{
		for (int i = 0; i < 10; i++) {
			charArray[i]=(char) ('0'+i);
		}
		for (int i = 0; i < 26; i++) {
			charArray[i+10]=(char) ('A'+i);
		}
	}
	
	
	
	/**
	 * 判断一个字符串是否为空
	 * @param str
	 * @return 为空返回true 否则返回false
	 */
	public boolean isBlank(String str){
		return null==str||"".equals(str.trim());
	}
	
	/**
	 * 判断一个字符是否有值
	 * @param str
	 * @return 有值返回true 无值返回false
	 */
	public static boolean haveValue(String str){
		return null!=str&&!"".equals(str.trim());
	}
	
	public static boolean isMobile(String str){
		String regex = "^(135|136|152)\\d{8}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	
	public static String getRandomStr(int n){
		Random random = new Random();
		//StringBuilder 线程不安全，执行效率 高，效率高的原因是再访问时不会加锁
		//StringBuffer 线程安全，但是执行效率低
		//这里可以使用StringBuilder,一个函数的执行职能在一个线程内部执行
		// 也就是下边这个sb 不会被多个线程同时访问，不会出现线程安全的问题，因而选择效率较高的StringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char randomChar = (char) ('a'+random.nextInt(26));
			sb.append(randomChar);
		}
		return sb.toString();
	}
	/**
	 * 数字和英文
	 * @param n
	 * @return
	 */
	public static String getRandomStrNum(int n){
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(36);//0-25下标
			char randomChar = charArray[index];
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	public static String getGb2312(int n) throws UnsupportedEncodingException{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getGb2312());
		}
		return sb.toString();
	}
	
	private static String getGb2312() throws UnsupportedEncodingException{
		byte word[] = new byte[2];
		
		Random random = new Random();
		
		word[0] = (byte) (0xA1+0x10+random.nextInt(39));
		word[1] = (byte) (0xA1+random.nextInt(94));
		return new String(word,"GBK");
	}
	
	/**
	 * 判断是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String regex = "^\\d{1,}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	/**
	 * 判断邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
			
		String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}
}
