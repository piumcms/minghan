package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListProductReqDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.Product;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("isProductByNameService")
public  class IsProductByNameService extends BaseService<Result,Product>{
	
	@Autowired
    private ProductMapper productMapper;
	
	@Override
	public Result execute(Product arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getProductName()!= null) {
			ListProductReqDTO dto=new ListProductReqDTO();
			dto.setProductName(arg.getProductName());
			dto.setBrandType(arg.getTableId());
			int cout = productMapper.isBrandName(dto);
			getResult().setObj(cout);
		}
		return getResult();
	}

}
