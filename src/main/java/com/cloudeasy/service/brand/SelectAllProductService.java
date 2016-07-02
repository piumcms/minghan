package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.dto.brand.ListProductReqDTO;
import com.cloudeasy.dto.brand.ListProductResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.Product;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllProductService")
public  class SelectAllProductService extends BaseService<Result,ListProductReqDTO>{
	
	@Autowired
    private ProductMapper productMapper;
	
	@Override
	public Result execute(ListProductReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = productMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<Product> list = productMapper.queryByList(arg);
		ListProductResDTO resDTO = new ListProductResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setBrandId(arg.getBrandId());
		resDTO.setTableId(arg.getTableId());
        resDTO.setProductName(arg.getProductName());
        resDTO.setPageNumber(arg.getPageNumber());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
