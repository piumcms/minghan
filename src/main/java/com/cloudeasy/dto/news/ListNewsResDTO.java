/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.news;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.News;

/** 
 * @Title: ListNewsResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListNewsResDTO extends BaseDTO {

	private List<News> list;
	
	private Integer newsTypeId;

	/**
	 * @return list 
	 */
	
	public List<News> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<News> list) {
		this.list = list;
	}

	public Integer getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	
}
