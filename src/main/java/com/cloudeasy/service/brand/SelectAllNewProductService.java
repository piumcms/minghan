package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.dto.brand.ListNewProductReqDTO;
import com.cloudeasy.dto.brand.ListNewProductResDTO;
import com.cloudeasy.dto.brand.ListNewProductReqDTO;
import com.cloudeasy.dto.brand.ListNewProductResDTO;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllNewProductService")
public  class SelectAllNewProductService extends BaseService<Result,ListNewProductReqDTO>{
	
	@Autowired
    private NewProductMapper brandMapper;
	
	@Override
	public Result execute(ListNewProductReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<NewProduct> list = brandMapper.queryByList(arg);
		ListNewProductResDTO resDTO = new ListNewProductResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setName(arg.getName());
	    Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
