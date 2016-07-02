/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.news;

import java.util.ArrayList;
import java.util.List;

import com.cloudeasy.dto.BaseDTO;

/** 
 * @Title: ListDownloadReqDTO 
 * @Description: TODO
 * @author LL
 * @date 2013-11-19 下午4:24:37 
 * @version V1.0   
 */
public class ListDownloadReqDTO extends BaseDTO {
	
	private String flag;
	
	private String category;
	
	private List<String> categorys = null;
	
	private String siteName;
	
	private String title;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public List<String> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<String> categorys) {
		this.categorys = categorys;
	}
}
