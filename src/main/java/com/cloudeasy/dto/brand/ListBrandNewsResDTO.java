/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author TBS
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListBrandNewsResDTO extends BaseDTO {
	/**
	 * 品牌新闻标题	 */
	private String title;

	/**
	 * 品牌新闻列表
	 */
	private List<BrandNews> list;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<BrandNews> getList() {
		return list;
	}

	public void setList(List<BrandNews> list) {
		this.list = list;
	}

}
