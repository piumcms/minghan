/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.dto.user.AddRoleReqDTO;
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
@Service("addRoleService")
public class AddRoleService extends BaseService<Result, AddRoleReqDTO>{

	@Autowired
	private RoleMapper roleMapper;
	
	public Result execute(AddRoleReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		Role role = new Role();
		role.setId(reqDTO.getId());
		role.setName(reqDTO.getName());
		role.setMemo(reqDTO.getMemo());
		role.setView(reqDTO.getMemo());
		role.setFlag(reqDTO.getFlag());
		role.setIsDeleted("0");
		role.setCreateTime(new Date());
		int count = 0;
		if(null!=reqDTO.getId()&&reqDTO.getId()>0){
			count = roleMapper.updateByPrimaryKeySelective(role);
		}else{
			count = roleMapper.insertSelective(role);
		}
		if (count == 0) {
			result.setStatus("1");
		}
	
		return result;
	}

}
