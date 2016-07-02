package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/**
 * 
 * @author tbs
 *
 */
public class ListSkuReqDTO extends BaseDTO {
      
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

    
	
	
}
