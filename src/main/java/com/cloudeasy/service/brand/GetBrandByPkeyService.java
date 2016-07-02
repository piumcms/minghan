package com.cloudeasy.service.brand;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 根据Key获取brand
 * @author tbs
 *
 */
@Service("getBrandByPkeyService")
public  class GetBrandByPkeyService extends BaseService<Result,Brand>{
	
	@Autowired
    private BrandMapper brandMapper;
	
	@Override
	public Result execute(Brand arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getId() != null) {
			arg = brandMapper.selectByPrimaryKey(arg.getId());
		}
		getResult().setObj(arg);
		return getResult();
	}

}
