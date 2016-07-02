/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import com.cloudeasy.dto.BaseDTO;

/** 
 * @Title: ListBrandVideoReqDTO 
 * @Description: TODO
 * @author LL
 * @date 2013-11-19 下午4:24:37 
 * @version V1.0   
 */
public class ListBrandVideoReqDTO extends BaseDTO {
	
	private String flag;
	
	private Integer brandId;
	
	private String brandType;
	
	private String category;
	
	private String title;
	
	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
