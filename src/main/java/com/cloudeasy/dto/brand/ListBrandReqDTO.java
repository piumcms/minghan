package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/**
 * 
 * @author tbs
 *
 */
public class ListBrandReqDTO extends BaseDTO {
      
	/**
	 * 品牌名称
	 */
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	
}
