/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListBrandResDTO extends BaseDTO {
	/**
	 * 品牌名称
	 */
	private String brand;

	/**
	 * 品牌列表
	 */
	private List<Brand> list;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Brand> getList() {
		return list;
	}

	public void setList(List<Brand> list) {
		this.list = list;
	}

}
