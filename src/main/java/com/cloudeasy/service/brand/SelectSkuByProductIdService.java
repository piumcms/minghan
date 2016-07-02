package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.SkuMapper;
import com.cloudeasy.model.Sku;
import com.cloudeasy.service.BaseService;

@Service("selectSkuByProductIdService")
public  class SelectSkuByProductIdService extends BaseService<List<Sku>, Sku>{
	
	@Autowired
    private SkuMapper skuMapper;
	
	@Override
	public List<Sku> execute(Sku arg) throws Exception {
		// TODO Auto-generated method stub
		List<Sku> list = skuMapper.findAllSkuByBrandId(arg);
		return list;
	}

}
