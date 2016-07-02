package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/**
 * 
 * @author tbs
 *
 */
public class ListProductReqDTO extends BaseDTO {
      
	/**
	 * 产品名称
	 */
	private String productName;
	
	private String brandId;
	
	private Integer isMainProduct;

	public Integer getIsMainProduct() {
		return isMainProduct;
	}

	public void setIsMainProduct(Integer isMainProduct) {
		this.isMainProduct = isMainProduct;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	/**
	 * 品牌Id
	 */
	private  String tableId;

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
}
