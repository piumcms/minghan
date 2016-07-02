package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.SubBrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.dto.brand.ListSubBrandReqDTO;
import com.cloudeasy.dto.brand.ListSubBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.SubBrand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllSubBrandService")
public  class SelectAllSubBrandService extends BaseService<Result,ListSubBrandReqDTO>{
	
	@Autowired
    private SubBrandMapper brandMapper;
	
	@Override
	public Result execute(ListSubBrandReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<SubBrand> list = brandMapper.queryByList(arg);
		ListSubBrandResDTO resDTO = new ListSubBrandResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setBrand(arg.getBrand());
		resDTO.setBrandId(arg.getBrandId());
		resDTO.setPageNumber(arg.getPageNumber());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
