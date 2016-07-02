/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.login;

import org.springframework.stereotype.Service;

import com.cloudeasy.model.User;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: GetUserService 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午1:49:14 
 * @version V1.0   
 */
@Service("getUserService")
public class GetUserService extends BaseService<User, String> {
	
	/**
	 * 获取登录用户
	 */
	private final String SQL_SELECTUSERBYUSERNAME = "index.selectByUsername";

	@Override
	public User execute(String username) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("username", username);
		User user = baseDao.queryForObject(SQL_SELECTUSERBYUSERNAME, dy);
		return user;
	}

}
