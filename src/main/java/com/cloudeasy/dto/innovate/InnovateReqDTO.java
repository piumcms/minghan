/**
 * 
 */
package com.cloudeasy.dto.innovate;

import com.cloudeasy.dto.BaseDTO;

/**
 * @author zdh
 *
 */
public class InnovateReqDTO extends BaseDTO {

	private Integer brandId;

	private String flag;

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
	
}
