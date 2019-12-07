package com.zhangyuhao.cms;

import org.junit.Test;

public class FileUtilsTest {

	/**
	 * 测试文件的工具类
	 */
	@Test
	public void testGetSuffix(){
		String suffixName = FileUtils.getSuffixName("D:\\学习内容\\Git\\unins000.dat");
		System.out.println("suffix = "+suffixName);
	}
	
	
	/**
	 * 删除目录
	 */
	@Test
	public void testDelFile(){
		FileUtils.deFile("D:\\02");
	}
	
	@Test
	public void testGetpro(){
		FileUtils.getProperty("");
	}
	
	//获取系统环境变量
	@Test
	public void testGetEvn(){
		System.out.println(" java_home is"+FileUtils.getEnv("JAVA_HOME"));
	}
	
	@Test
	public void testSize(){
		long size = FileUtils.getSize("D:\\01\\01.txt");
		System.out.println(size);
	}
	
	
}
