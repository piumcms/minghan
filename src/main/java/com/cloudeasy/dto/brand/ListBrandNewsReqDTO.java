package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/**
 * 
 * @author tbs
 *
 */
public class ListBrandNewsReqDTO extends BaseDTO {
      
	/**
	 * 品牌新闻标题
	 * 	 */
	private String title;
	
	/**
	 * 品牌id
	 */
	private int brandId;
	
	private String brandType;
	
	private String category;
	
	private String schoolType;

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
