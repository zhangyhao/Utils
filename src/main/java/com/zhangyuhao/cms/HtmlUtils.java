package com.zhangyuhao.cms;

public class HtmlUtils {
	
	/**
	 * html字符的转义处理
	 * @param str
	 * @return
	 */
	public static String htmlspecialchars(String str){
		str=str.replaceAll("&", "&amp;");
		str=str.replaceAll("<", "&lt;");
		str=str.replaceAll(">", "&gt;");
		str=str.replaceAll("\"", "&quot");
		return str;
	}
}
