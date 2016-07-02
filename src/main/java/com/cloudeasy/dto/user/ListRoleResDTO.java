/**  
* Copyright(c)2013 FLC Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.user;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Role;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListRoleResDTO extends BaseDTO {
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 角色列表
	 */
	private List<Role> list;

	/** 
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * @return list 
	 */
	public List<Role> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<Role> list) {
		this.list = list;
	}


}
