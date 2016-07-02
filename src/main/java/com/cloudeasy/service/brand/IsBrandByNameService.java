package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("isBrandByNameService")
public  class IsBrandByNameService extends BaseService<Result,Brand>{
	
	@Autowired
    private BrandMapper brandMapper;
	
	@Override
	public Result execute(Brand arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getBrand()!= null) {
			ListBrandReqDTO dto=new ListBrandReqDTO();
			dto.setBrand(arg.getBrand());
			int cout = brandMapper.isBrandName(dto);
			getResult().setObj(cout);
		}
		
		return getResult();
	}

}
