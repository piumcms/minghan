package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.dto.brand.ListNewProductReqDTO;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("isNewProductByNameService")
public  class IsNewProductByNameService extends BaseService<Result,NewProduct>{
	
	@Autowired
    private NewProductMapper newProductMapper;
	
	@Override
	public Result execute(NewProduct arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getName()!= null) {
			ListNewProductReqDTO dto=new ListNewProductReqDTO();
			dto.setName(arg.getName());
			int cout = newProductMapper.isName(dto);
			getResult().setObj(cout);
		}
		
		return getResult();
	}

}
