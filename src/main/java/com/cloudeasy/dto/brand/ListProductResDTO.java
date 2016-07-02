/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListProductResDTO extends BaseDTO {
	/**
	 * 商品名称
	 */
	private String productName;
	
	private String brandId;
	
	private String tableId;
	
	
	
	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}


	/**
	 * 商品列表
	 */
	private List<Product> list;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}


}
