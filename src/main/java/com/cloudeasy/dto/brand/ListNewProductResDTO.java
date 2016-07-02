/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListNewProductResDTO extends BaseDTO {
	/**
	 * 品牌名称
	 */
	private String name;

	/**
	 * 品牌列表
	 */
	private List<NewProduct> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NewProduct> getList() {
		return list;
	}

	public void setList(List<NewProduct> list) {
		this.list = list;
	}


}
