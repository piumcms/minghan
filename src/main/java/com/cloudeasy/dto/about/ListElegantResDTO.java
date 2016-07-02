/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.about;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.NewsHonour;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListElegantResDTO extends BaseDTO {

	private List<NewsHonour> list;
	
	private Integer newsTypeId;

	/**
	 * @return list 
	 */
	
	public List<NewsHonour> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<NewsHonour> list) {
		this.list = list;
	}

	public Integer getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	
}
