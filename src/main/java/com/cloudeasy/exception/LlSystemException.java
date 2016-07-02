/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.exception;
import java.util.Collection;

/**
 * 自定义系统异�?
 * @Title: LlSystemException 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-2 下午2:39:24 
 * @version V1.0
 */
public class LlSystemException extends Exception{

	/** 
	* @Fields serialVersionUID : 序列ID 
	*/ 
	
	private static final long serialVersionUID = -228940273905131641L;

	private String messageId;
	
	private String[] params;
	
	private Collection<String> messages;
	
	public LlSystemException (String messageId, String[] params) {
		this.messageId = messageId;
		if (params == null) {
			this.params = null;
		} else {
			this.params = new String[params.length];
			System.arraycopy(params, 0, this.params, 0, params.length);
		}
	}
	
	public LlSystemException(String messageId, String params) {
		this.messageId = messageId;
		this.params = (new String[]{params});
	}
	
	public LlSystemException(String messageId) {
		this.messageId = messageId;
	}
	
	public LlSystemException(Collection<String> messages) {
		this.messages = messages;
	}
	
	public String getMessageId() {
		return messageId;
	}
	
	public String[] getParams() {
		if (params == null) {
			return null;
		} else {
			String[] results = new String[params.length];
			System.arraycopy(params, 0, results, 0, params.length);
			return results;
		}
	}
	
	public Collection<String> getMessages() {
		return messages;
	}
}
