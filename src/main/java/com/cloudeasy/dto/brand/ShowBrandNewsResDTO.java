/**
 * 
 */
package com.cloudeasy.dto.brand;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.BrandNews;
/**
 * @author admiimport com.cloudeasy.model.Welfare;
 *
 */
public class ShowBrandNewsResDTO extends BaseDTO {

	private Integer brandId;

	private String flag;
	
	private List<BrandNews> list;
	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<BrandNews> getList() {
		return list;
	}

	public void setList(List<BrandNews> list) {
		this.list = list;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	
}
