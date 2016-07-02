package com.cloudeasy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "province")
public class Province implements Serializable{

	private Integer id;
	private String provinceID;
	private String province;
	
	public Province(){}
	
	public Province(Integer id ,String provinceID,String province) {
		this.id = id;
		this.provinceID = provinceID;
		this.province = province;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

	@XmlElement
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	

}
