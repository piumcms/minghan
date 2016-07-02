/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.model.Role;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("getRoleService")
public class GetRoleService extends BaseService<Role, String>{

	@Autowired
	private RoleMapper roleMapper;
	
	public Role execute(String roleName) throws Exception {
		Result result = new ResultImpl();
		Role role = new Role();
		role.setName(roleName);
		
		role = roleMapper.selectByRoleName(role);
	
		return role;
	}

}
