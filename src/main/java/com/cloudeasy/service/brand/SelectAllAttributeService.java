package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AttributeMapper;
import com.cloudeasy.dto.brand.ListAttributeReqDTO;
import com.cloudeasy.dto.brand.ListAttributeResDTO;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllAttributeService")
public  class SelectAllAttributeService extends BaseService<Result,ListAttributeReqDTO>{
	
	@Autowired
    private AttributeMapper brandMapper;
	
	@Override
	public Result execute(ListAttributeReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<Attribute> list = brandMapper.queryByList(arg);
		ListAttributeResDTO resDTO = new ListAttributeResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setName(arg.getName());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
