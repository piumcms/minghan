package com.cloudeasy.service.brand;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.Product;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键获取Brand
 * @author tbs
 *
 */
@Service("deleteProductService")
public  class DeleteProductService extends BaseService<Result,Product>{
	
	@Autowired
    private ProductMapper productMapper;
	
	@Override
	public Result execute(Product arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = productMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
