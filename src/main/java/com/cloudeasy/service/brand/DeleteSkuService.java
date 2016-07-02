package com.cloudeasy.service.brand;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.SkuMapper;
import com.cloudeasy.model.Sku;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键获取Sku
 * @author tbs
 *
 */
@Service("deleteSkuService")
public  class DeleteSkuService extends BaseService<Result,Sku>{
	
	@Autowired
    private SkuMapper skuMapper;
	
	@Override
	public Result execute(Sku arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = skuMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
