package com.cloudeasy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "area")
public class Area implements Serializable{

	private Integer id;
	private String areaID;
	private String area;
	private String father;
	
	public Area(){}
	
	public Area(Integer id ,String areaID,String area,String father) {
		this.id = id;
		this.areaID = areaID;
		this.area = area;
		this.father = father;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaID() {
		return areaID;
	}

	public void setAreaID(String areaID) {
		this.areaID = areaID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}
	
	
}
