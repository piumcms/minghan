/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.innovate;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.model.QuesAnsw;

/** 
 * @Title: ListQuesResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListQuesResDTO extends BaseDTO {

	private List<QuesAnsw> list;
	
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
	
	public List<QuesAnsw> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<QuesAnsw> list) {
		this.list = list;
	}

}
