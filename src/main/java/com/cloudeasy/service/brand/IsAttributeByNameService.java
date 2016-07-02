package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AttributeMapper;
import com.cloudeasy.dto.brand.ListAttributeReqDTO;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("isAttributeByNameService")
public  class IsAttributeByNameService extends BaseService<Result,Attribute>{
	
	@Autowired
    private AttributeMapper attriMapper;
	
	@Override
	public Result execute(Attribute arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getName()!= null) {
			ListAttributeReqDTO dto=new ListAttributeReqDTO();
			dto.setName(arg.getName());
			int cout = attriMapper.isName(dto);
			getResult().setObj(cout);
		}
		return getResult();
	}
}
