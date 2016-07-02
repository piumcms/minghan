package com.cloudeasy.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "areas")
public class AreaList implements Serializable{

	private List<Area> area;
	
	public AreaList(){}

	public List<Area> getArea() {
		return area;
	}

	public void setArea(List<Area> area) {
		this.area = area;
	}

	
}
