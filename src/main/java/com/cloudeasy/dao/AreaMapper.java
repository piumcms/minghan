package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.model.Area;

public interface AreaMapper {
    

	
    /**
     * list
     * @param model
     * @return list
     */
	public List<Area> queryByList(Area model);
}