package com.cloudeasy.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City implements Serializable{

	private Integer id;
	private String cityID;
	private String city;
	private String father;
	
	public City(){}
	
	public City(Integer id ,String cityID,String city,String father) {
		this.id = id;
		this.cityID = cityID;
		this.city = city;
		this.father = father;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}
	
	
}
