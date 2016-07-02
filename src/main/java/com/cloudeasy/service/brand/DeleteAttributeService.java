package com.cloudeasy.service.brand;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AttributeMapper;
import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.model.Brand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键获取Attribute
 * @author tbs
 *
 */
@Service("deleteAttributeService")
public  class DeleteAttributeService extends BaseService<Result,Attribute>{
	
	@Autowired
    private AttributeMapper attriMapper;
	
	@Override
	public Result execute(Attribute arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = attriMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
