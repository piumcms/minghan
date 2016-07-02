package com.cloudeasy.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 * 
 * @Title: HtmlUtil 
 * @Description: TODO
 * @author ll
 * @date 2013-11-19 上午9:29:29 
 * @version V1.0
 */
public class HtmlUtil {
	
	/**
	 * 
	 * @param response
	 * @param jsonStr
	 */
	public static void writerJson(HttpServletResponse response,String jsonStr) {
			writer(response,jsonStr);
	}
	
	public static void writerJson(HttpServletResponse response,Object object){
			Gson gson = new Gson();
			response.setContentType("application/json");
			writer(response,gson.toJson(object));
	}
	
	/**
	 * 
	 * @param response
	 * @param htmlStr
	 */
	public static void writerHtml(HttpServletResponse response,String htmlStr) {
		writer(response,htmlStr);
	}
	
	/**
	 * 
	 * @param response
	 * @param str
	 */
	private static void writer(HttpServletResponse response,String str){
		try {
			StringBuffer result = new StringBuffer();
			//设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	 /**
		 * 去除str中的HTML标签
		 * 
		 * @param str
		 * @return
		 */
		public static String formatHtml(String str) {
			if (str == null) {
				return "";
			}
			str = str.toLowerCase();
			str = str.replaceAll("</?span[^>]*>", "");
			str = str.replaceAll("&#[^>]*;", "");
			str = str.replaceAll("</?marquee[^>]*>", "");
			str = str.replaceAll("</?object[^>]*>", "");
			str = str.replaceAll("</?param[^>]*>", "");
			str = str.replaceAll("</?embed[^>]*>", "");
			str = str.replaceAll("</?table[^>]*>", "");
			str = str.replaceAll("&nbsp;", "");
			str = str.replaceAll("</?tr[^>]*>", "");
			str = str.replaceAll("</?th[^>]*>", "");
			str = str.replaceAll("</?p[^>]*>", "");
			str = str.replaceAll("</?a[^>]*>", "");
			str = str.replaceAll("</?img[^>]*>", "");
			str = str.replaceAll("</?tbody[^>]*>", "");
			str = str.replaceAll("</?li[^>]*>", "");
			str = str.replaceAll("</?div[^>]*>", "");
			str = str.replaceAll("</?td[^>]*>", "");
			str = str.replaceAll("</?script[^>]*>", "");
			str = str.replaceAll("(javascript|jscript|vbscript|vbs):", "");
			str = str.replaceAll("on(mouse|exit|error|click|key)", "");
			str = str.replaceAll("<\\?xml[^>]*>", "");
			str = str.replaceAll("<\\?[a-z]+:[^>]*>", "");
			str = str.replaceAll("</?font[^>]*>", "");
			str = str.replaceAll("</?b[^>]*>", "");
			str = str.replaceAll("</?u[^>]*>", "");
			str = str.replaceAll("</?i[^>]*>", "");
			str = str.replaceAll("</?strong[^>]*>", "");
			str = str.replaceAll("</?(a|A)( .*?>|>)", "");
			return str;
		}
}
