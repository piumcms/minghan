/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.news;

import com.cloudeasy.dto.BaseDTO;

/** 
 * @Title: ListNewsReqDTO 
 * @Description: TODO
 * @author LL
 * @date 2013-11-19 下午4:24:37 
 * @version V1.0   
 */
public class ListNewsReqDTO extends BaseDTO {
	
	private String flag;
	
	private Integer newsTypeId;
	
	private String brandType;
	
	private String category;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
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
