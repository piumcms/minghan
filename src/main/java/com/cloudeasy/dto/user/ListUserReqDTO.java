/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.user;

import com.cloudeasy.dto.BaseDTO;

/** 
 * @Title: LiseUserReqDTO 
 * @Description: TODO
 * @author LL
 * @date 2013-11-19 下午4:24:37 
 * @version V1.0   
 */
public class ListUserReqDTO extends BaseDTO {
	
	/**
	 * 用户名
	 */
	private String username;
	
	private String email;
	
	private String mobile;
	
	private String ip;
	
	private String monthStart;
	
	private String monthEnd;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return username 
	 */
	
	public String getUsername() {
		return username;
	}

	/** 
	 * @param username 要设置的 username 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(String monthStart) {
		this.monthStart = monthStart;
	}

	public String getMonthEnd() {
		return monthEnd;
	}

	public void setMonthEnd(String monthEnd) {
		this.monthEnd = monthEnd;
	}
	
	

}
