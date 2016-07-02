/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.login;

import com.cloudeasy.dto.DTO;

/** 
 * @Title: LoginReqDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午1:45:15 
 * @version V1.0   
 */
public class LoginReqDTO implements DTO {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 4402368281713680201L;

	/**
	 * 获取当前登录用户
	 */
	private String username;

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
	
	
}
