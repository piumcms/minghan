/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.model.Role;

/** 
 * @Title: ShowAllRoleService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("showAllRoleService")
public class ShowAllRoleService extends BaseService<List<Role>, String> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> execute(String arg) throws Exception {
	
		List<Role> list = roleMapper.queryForList(arg);
		return list;
	}

}
