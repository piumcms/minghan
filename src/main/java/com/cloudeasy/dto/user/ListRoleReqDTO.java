package com.cloudeasy.dto.user;

import com.cloudeasy.dto.BaseDTO;
/**
 * 
 * @author tbs
 *
 */
public class ListRoleReqDTO extends BaseDTO {
      
	/**
	 * 名称
	 */
	private String name;
	

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

	
	
}
