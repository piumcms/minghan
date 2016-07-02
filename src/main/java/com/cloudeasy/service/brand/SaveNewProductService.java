package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存新品
 * @author tbs
 */
@Service("saveNewProductService")
public class SaveNewProductService extends BaseService<Result, NewProduct>{
	
	@Autowired
	private NewProductMapper newProductMapper;
   
	@Override
	public Result execute(NewProduct arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = newProductMapper.updateByPrimaryKeySelective(arg);
		} else {
			count = newProductMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
