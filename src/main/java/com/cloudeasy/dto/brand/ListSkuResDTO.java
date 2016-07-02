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
import com.cloudeasy.model.Sku;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListSkuResDTO extends BaseDTO {
	/**
	 * Sku商品名称
	 * 	 */
	private String productName;
	
	/**
	 * Sku属性名称
	 * 	 */
	private String attributeName;
	
	private Integer tableId;
	
	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * Sku商品列表
	 */
	private List<Sku> list;

	public List<Sku> getList() {
		return list;
	}

	public void setList(List<Sku> list) {
		this.list = list;
	}


}
