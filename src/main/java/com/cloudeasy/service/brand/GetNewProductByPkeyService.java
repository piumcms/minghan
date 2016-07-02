package com.cloudeasy.service.brand;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 根据Key获取NewProduct
 * @author tbs
 *
 */
@Service("getNewProductByPkeyService")
public  class GetNewProductByPkeyService extends BaseService<Result,NewProduct>{
	
	@Autowired
    private NewProductMapper NewProductMapper;
	
	@Override
	public Result execute(NewProduct arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getId() != null) {
			arg = NewProductMapper.selectByPrimaryKey(arg.getId());
		}
		getResult().setObj(arg);
		return getResult();
	}

}
