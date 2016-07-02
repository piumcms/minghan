/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.result;

/**
 * 
 * @Title: Mess 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:27:23 
 * @version V1.0
 */
public class Mess {
	
	private  String fieldName;
	
	private String message;

	/** 
	 * @return fieldName 
	 */
	
	public String getFieldName() {
		return fieldName;
	}

	/** 
	 * @param fieldName 要设置的 fieldName 
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/** 
	 * @return message 
	 */
	
	public String getMessage() {
		return message;
	}

	/** 
	 * @param message 要设置的 message 
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
