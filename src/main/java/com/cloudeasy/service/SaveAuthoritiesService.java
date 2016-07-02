/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.dao.RoleResourceMapper;
import com.cloudeasy.dto.user.SaveAuthoritesReqDTO;
import com.cloudeasy.model.Role;
import com.cloudeasy.model.RoleResource;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.security.IAuthService;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("saveAuthoritiesService")
public class SaveAuthoritiesService extends BaseService<Result, SaveAuthoritesReqDTO>{

	/**
	 * 插入权限语句
	 */
	private static final String SQL_BATCHINSERT = "index.batchInsert";
	
	@Autowired
	private RoleResourceMapper mapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private IAuthService authService;
	
	public Result execute(SaveAuthoritesReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		// 获取roleid
		Role role = new Role();
		//role.setName(reqDTO.getRoleName());
		role = roleMapper.selectByPrimaryKey(reqDTO.getId());
		
		// 更新role
		role.setMemo(reqDTO.getMemo());
		role.setName(reqDTO.getName());
		roleMapper.updateByPrimaryKeySelective(role);
		// 删除所有角色
		RoleResource roleResource = new RoleResource();
		roleResource.setRoleId(role.getId());
		int count = mapper.deleteByRoleResource(roleResource);
		if (count == 0) {
			//result.setStatus("1");
		}
		// 开始保存新的权限
		String[] ids = reqDTO.getIds().split(",");
		List<RoleResource> list = new ArrayList<RoleResource>();
		for (String id: ids) {
			roleResource = new RoleResource();
			roleResource.setRoleId(role.getId());
			roleResource.setResourceId(Integer.valueOf(id));
			list.add(roleResource);
		}
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("list", list);
		count = baseDao.insert(SQL_BATCHINSERT, dy);
		if (count == 0) {
			result.setStatus("1");
		}
		// 重新加载权限
		authService.reCreateFilterChains();
		return result;
	}

}
