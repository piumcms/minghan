package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Province;
import com.cloudeasy.model.User;

public interface ProvinceMapper {
    

	
    /**
     * list
     * @param model
     * @return list
     */
	public List<Province> queryByList(BaseDTO model);
}