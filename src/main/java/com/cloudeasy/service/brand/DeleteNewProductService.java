package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键获取NewProduct
 * @author tbs
 *
 */
@Service("deleteNewProductService")
public  class DeleteNewProductService extends BaseService<Result,NewProduct>{
	
	@Autowired
    private NewProductMapper newProductMapper;
	
	@Override
	public Result execute(NewProduct arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = newProductMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
