/**
 * 
 */
package com.cloudeasy.dto.innovate;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.QuesAnsw;

/**
 * @author zdh
 *
 */
public class InnovateResDTO extends BaseDTO {

	private Integer brandId;

	private String flag;
	
	private List<Brand> brandList;
	
	private List<QuesAnsw> list;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public List<QuesAnsw> getList() {
		return list;
	}

	public void setList(List<QuesAnsw> list) {
		this.list = list;
	}
	
}
