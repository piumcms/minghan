package com.cloudeasy.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities")
public class CityList implements Serializable{

	private List<City> city;
	
	public CityList(){}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	
}
