package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandVideoMapper;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.service.BaseService;

@Service("selectAllBrandVideoService")
public  class SelectAllBrandVideoService extends BaseService<List<BrandVideo>, BrandVideo>{
	
	@Autowired
    private BrandVideoMapper brandVideoMapper;
	
	@Override
	public List<BrandVideo> execute(BrandVideo brand) throws Exception {
		// TODO Auto-generated method stub
		List<BrandVideo> list = brandVideoMapper.findForList(brand);
		return list;
	}

}
