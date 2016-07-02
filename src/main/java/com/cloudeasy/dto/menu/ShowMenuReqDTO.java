/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.menu;

import com.cloudeasy.dto.DTO;
import com.cloudeasy.model.User;

/** 
 * @Title: ShowMenuReqDTO 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 下午1:37:26 
 * @version V1.0   
 */
public class ShowMenuReqDTO implements DTO {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 1820567743474920587L;
	
	/**
	 * 用户
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
