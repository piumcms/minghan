/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.login;

import com.cloudeasy.dto.DTO;
import com.cloudeasy.model.User;

/** 
 * @Title: LoginResDTO 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 下午1:46:29 
 * @version V1.0   
 */
public class LoginResDTO implements DTO {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -804663395675375782L;

	/**
	 * 
	 */
	private User user;

	/**
	 * @return user 
	 */
	
	public User getUser() {
		return user;
	}

	/** 
	 * @param user 要设置的 user 
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
