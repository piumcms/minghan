/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListAttributeResDTO extends BaseDTO {
	/**
	 * 商品属性名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 商品属性列表
	 */
	private List<Attribute> list;

	public List<Attribute> getList() {
		return list;
	}

	public void setList(List<Attribute> list) {
		this.list = list;
	}


}
