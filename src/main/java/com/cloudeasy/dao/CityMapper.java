package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.model.City;

public interface CityMapper {
    

	
    /**
     * list
     * @param model
     * @return list
     */
	public List<City> queryByList(City model);
}