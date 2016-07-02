package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AttributeMapper;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 根据Key获取Attribute
 * @author tbs
 *
 */
@Service("getAttributeByPkeyService")
public  class GetAttributeByPkeyService extends BaseService<Result,Attribute>{
	
	@Autowired
    private AttributeMapper BrandMapper;
	
	@Override
	public Result execute(Attribute arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getId() != null) {
			arg = BrandMapper.selectByPrimaryKey(arg.getId());
		}
		getResult().setObj(arg);
		return getResult();
	}

}
