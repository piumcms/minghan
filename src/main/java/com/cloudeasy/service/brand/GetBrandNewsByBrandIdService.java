package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ListBrandNewsResDTO;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("getBrandNewsByBrandIdService")
public  class GetBrandNewsByBrandIdService extends BaseService<Result,ListBrandNewsReqDTO>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(ListBrandNewsReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
        List<BrandNews> list = brandMapper.getBrandNewsListByBrandId(arg);
		ListBrandNewsResDTO resDTO = new ListBrandNewsResDTO();
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
