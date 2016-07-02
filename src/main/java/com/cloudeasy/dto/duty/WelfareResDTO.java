/**
 * 
 */
package com.cloudeasy.dto.duty;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Welfare;
/**
 * @author admiimport com.cloudeasy.model.Welfare;
 *
 */
public class WelfareResDTO extends BaseDTO {

	private Integer newsTypeId;

	private String flag;
	
	private List<Welfare> list;
	
	
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

	public List<Welfare> getList() {
		return list;
	}

	public void setList(List<Welfare> list) {
		this.list = list;
	}
	
	
}
