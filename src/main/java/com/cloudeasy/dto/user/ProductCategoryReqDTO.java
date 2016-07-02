/**
 * 
 */
package com.cloudeasy.dto.user;

import com.cloudeasy.dto.DTO;

public class ProductCategoryReqDTO implements DTO {

	private static final long serialVersionUID = -7801057799655299601L;
	
	private String name;
	
	private Integer id;
	
	private Integer productId;
	
	/**
	 * 分类类别ids
	 */
	private String ids;
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
}
