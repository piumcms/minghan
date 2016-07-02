/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.utils;

import org.apache.log4j.Logger;

/**
 * 日志工具类
 * @Title: LoggerUtil 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:59:42 
 * @version V1.0
 */
public class LoggerUtil {

	public static Logger cLog = Logger.getLogger("R");
	
	public  static Logger sLog = Logger.getLogger("SQL");
	
	public static boolean isDebuggedC() {
		return cLog.isDebugEnabled();
	}
	
	public static boolean isInfoC() {
		return cLog.isInfoEnabled();
	}
	
	public static boolean isDebuggedS() {
		return sLog.isDebugEnabled();
	}
	
	public static boolean isInfoS() {
		return sLog.isInfoEnabled();
	}
	
	public static<T>  Logger log(Class<T> t) {
		return Logger.getLogger(t);
	}
}
