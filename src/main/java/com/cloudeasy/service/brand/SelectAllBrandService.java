package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllBrandService")
public  class SelectAllBrandService extends BaseService<Result,ListBrandReqDTO>{
	
	@Autowired
    private BrandMapper brandMapper;
	
	@Override
	public Result execute(ListBrandReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<Brand> list = brandMapper.queryByList(arg);
		ListBrandResDTO resDTO = new ListBrandResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setBrand(arg.getBrand());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
