package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.SkuMapper;
import com.cloudeasy.model.Sku;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 根据Key获取Sku
 * @author tbs
 *
 */
@Service("getSkuByPkeyService")
public  class GetSkuByPkeyService extends BaseService<Result,Sku>{
	
	@Autowired
    private SkuMapper skuMapper;
	
	@Override
	public Result execute(Sku arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getId() != null) {
			arg = skuMapper.selectByPrimaryKey(arg.getId());
		}
		getResult().setObj(arg);
		return getResult();
	}

}
