/**
 * 
 */
package com.cloudeasy.dto.about;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.AboutArticle;

/**
 * @author Sean
 *
 */
public class AboutArticleResDTO extends BaseDTO {
	
	private String flag;
	private String category;
	
	private List<AboutArticle> list;
	
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
	public List<AboutArticle> getList() {
		return list;
	}
	public void setList(List<AboutArticle> list) {
		this.list = list;
	}
	
	
}
