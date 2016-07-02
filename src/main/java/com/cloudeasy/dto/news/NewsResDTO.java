/**
 * 
 */
package com.cloudeasy.dto.news;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.News;
import com.cloudeasy.model.QuesAnsw;

/**
 * @author zdh
 *
 */
public class NewsResDTO extends BaseDTO {

	private Integer newsTypeId;

	private String flag;
	
	private List<News> list;
	
	private List<News> topList;

	public Integer getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public List<News> getTopList() {
		return topList;
	}

	public void setTopList(List<News> topList) {
		this.topList = topList;
	}
}
