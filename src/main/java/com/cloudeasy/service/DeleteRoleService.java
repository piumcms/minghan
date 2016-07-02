/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.dao.RoleResourceMapper;
import com.cloudeasy.dao.UserRoleMapper;
import com.cloudeasy.dto.user.AddRoleReqDTO;
import com.cloudeasy.model.Role;
import com.cloudeasy.model.RoleResource;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("deleteRoleService")
public class DeleteRoleService extends BaseService<Result, AddRoleReqDTO>{

	@Autowired
	private RoleResourceMapper mapper;
	
	@Autowired
	private UserRoleMapper userRolemapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	public Result execute(AddRoleReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		
		// 删除所有角色
		RoleResource roleResource = new RoleResource();
		roleResource.setRoleId(reqDTO.getId());
		
		int count = mapper.deleteByRoleResource(roleResource);
		
		// 删除用户角色中间表
		userRolemapper.deleteUserRoleByRole(reqDTO.getId());
		
		Role role = new Role();
		role.setId(reqDTO.getId());
		count = roleMapper.deleteByPrimaryKey(reqDTO.getId());
		if (count == 0) {
			result.setStatus("1");
		}
	
		return result;
	}

}
