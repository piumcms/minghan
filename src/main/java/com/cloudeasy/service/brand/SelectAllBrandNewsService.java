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

@Service("selectAllBrandNewsService")
public  class SelectAllBrandNewsService extends BaseService<Result,ListBrandNewsReqDTO>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(ListBrandNewsReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<BrandNews> list = brandMapper.queryByList(arg);
		ListBrandNewsResDTO resDTO = new ListBrandNewsResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setTitle(arg.getTitle());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
