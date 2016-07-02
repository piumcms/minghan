package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.SubBrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListSubBrandReqDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.SubBrand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("isSubBrandByNameService")
public  class IsSubBrandByNameService extends BaseService<Result,SubBrand>{
	
	@Autowired
    private SubBrandMapper subbrandMapper;
	
	@Override
	public Result execute(SubBrand arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getBrand()!= null) {
			ListSubBrandReqDTO dto=new ListSubBrandReqDTO();
			dto.setBrand(arg.getBrand());
			int cout = subbrandMapper.isBrandName(dto);
			getResult().setObj(cout);
		}
		
		return getResult();
	}

}
