package com.cloudeasy.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "provinces")
public class ProvinceList implements Serializable{

	private List<Province> province;
	
	public ProvinceList(){}

	public List<Province> getProvince() {
		return province;
	}

	public void setProvince(List<Province> province) {
		this.province = province;
	}

	
}
