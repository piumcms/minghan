/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.about;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Download;

/** 
 * @Title: ListDownloadResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListDownloadResDTO extends BaseDTO {

	private List<Download> list;
	
	private String category;
	
	private String siteName;
	
	private String title;

	/**
	 * @return list 
	 */
	
	public List<Download> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<Download> list) {
		this.list = list;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
