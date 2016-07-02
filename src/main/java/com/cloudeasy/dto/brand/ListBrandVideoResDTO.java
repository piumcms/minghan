/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.model.NewsHonour;

/** 
 * @Title: ListBrandVideoResDTO 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListBrandVideoResDTO extends BaseDTO {

	private List<BrandVideo> list;
	
	private Integer brandId;
	

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	/**
	 * @return list 
	 */
	
	public List<BrandVideo> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<BrandVideo> list) {
		this.list = list;
	}
	
}
