package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.SubBrandMapper;
import com.cloudeasy.model.SubBrand;
import com.cloudeasy.service.BaseService;

@Service("findAllSubBrandService")
public  class FindAllSubBrandService extends BaseService<List<SubBrand>,String>{
	
	@Autowired
    private SubBrandMapper brandMapper;
	
	@Override
	public List<SubBrand> execute(String arg) throws Exception {
        List<SubBrand> list = brandMapper.findByList();
		return list;
	}

}
