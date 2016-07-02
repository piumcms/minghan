/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.exception;

import java.util.Collection;

import com.cloudeasy.result.Result;

   /**
    * 自定义应用异�?
    * @Title: LlApplicationException
    * @Description: TODO
    * @author ZDH
    * @date 2013-9-6 下午4:56:00
    * @version V1.0
    */
    public class LlApplicationException extends Exception {

	/**
	 * @Fields serialVersionUID : 序列ID
	 */
	private static final long serialVersionUID = -228940273905131641L;

	private String messageId;

	private String[] params;

	private Collection<String> messages;

	private Result result;

	public LlApplicationException(String messageId, String params) {
		this.messageId = messageId;
		this.params = (new String[] { params });
	}

	public LlApplicationException(String messageId) {
		this.messageId = messageId;
	}

	public LlApplicationException(Collection<String> messages) {
		this.messages = messages;
	}

	public LlApplicationException(Result result) {
		this.result = result;
	}

	public String getMessageId() {
		return messageId;
	}

	public Result getResult() {
		return this.result;
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
	
	public LlApplicationException(String messageId, String[] params) {
		this.messageId = messageId;
		if (params == null) {
			this.params = null;
		} else {
			this.params = new String[params.length];
			System.arraycopy(params, 0, this.params, 0, params.length);
		}
	}
}
