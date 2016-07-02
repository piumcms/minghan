/**
 * 
 */
package com.cloudeasy.dto.news;

import com.cloudeasy.dto.BaseDTO;

/**
 * @author zdh
 *
 */
public class NewsReqDTO extends BaseDTO {

	private Integer newsTypeId;

	private String flag;
	
	private String t;

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

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
}
