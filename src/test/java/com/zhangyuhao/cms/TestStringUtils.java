package com.zhangyuhao.cms;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStringUtils {

	static StringUtils stringUtils;
	
	@Before
	public void init(){
		stringUtils = new StringUtils();
		System.err.println("init beore -------------");
	}
	@BeforeClass
	public static void init1(){
		System.out.println("init beoreClass ------------");
	}
	
	@After
	public void after(){
		System.out.println("after ----------");
	}
	
	@AfterClass
	public static void afterClass(){
		System.err.println("afterClass -----------");
	}
	
	@Test
	public void testIsBlank(){
		boolean blank = stringUtils.isBlank("11");
		System.out.println(" blank is "+blank);
	}
	
	@Test
	public void testIsBlank1(){
		boolean blank = stringUtils.isBlank("11");
		System.out.println(" blank is "+blank);
		Assert.assertTrue(blank==true);
	}
	
	@Test
	public void IsHaveValue(){
		boolean b = StringUtils.haveValue(" 123");
		Assert.assertTrue(b==true);
	}
	
	@Test
	public void IsMobileTrue(){
		String str = "1522749951";
		Assert.assertTrue(StringUtils.isMobile(str));
	}
	
	
	@Test
	public void testRandom(){
		String randomStr = StringUtils.getRandomStr(20);
		System.out.println("randomStr is "+randomStr);
		Assert.assertTrue(20==randomStr.length());
	}
	
	@Test
	public void EnglishAndMath(){
		String randomStrNum = StringUtils.getRandomStrNum(15);
		System.out.println("randomStrNum is " +randomStrNum);
		Assert.assertTrue(15==randomStrNum.length());
	}
	
	@Test
	public void RandomChar() throws UnsupportedEncodingException{
		String string = StringUtils.getGb2312(20);
		System.out.println(""+string);
		Assert.assertTrue(20==string.length());
	}
	
	@Test
	public void getAge(){
		Date now = new Date(100,4,20);
		int i = DateUtils.getAge(now);
		System.out.println("age is "+i);
	}
	
	@Test
	public void Seconds(){
		Date d = new Date(120,0,1);
		int i = DateUtils.getRemainDays(d);
		System.out.println("距离元旦剩下:"+i);
	}
	
	@Test
	public void isToday(){
		Date future = new Date(120,0,1);
		boolean inToday = DateUtils.inToday(future);
		System.out.println("1111是今天"+inToday);
		
		inToday = DateUtils.inToday(new Date());
		System.out.println("2222是今天"+inToday);
	}
	
	@Test
	public void testGetDay(){
		Date date = DateUtils.getBeginOfMonth();
		System.out.println("beginOfMonth is"+date);
	}
}
