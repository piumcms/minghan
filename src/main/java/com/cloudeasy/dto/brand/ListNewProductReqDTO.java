package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/**
 * 
 * @author tbs
 *
 */
public class ListNewProductReqDTO extends BaseDTO {
      
	/**
	 * 名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
