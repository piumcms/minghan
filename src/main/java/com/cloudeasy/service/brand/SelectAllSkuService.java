package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.SkuMapper;
import com.cloudeasy.dto.brand.ListSkuReqDTO;
import com.cloudeasy.dto.brand.ListSkuResDTO;
import com.cloudeasy.model.Sku;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllSkuService")
public  class SelectAllSkuService extends BaseService<Result,ListSkuReqDTO>{
	
	@Autowired
    private SkuMapper brandMapper;
	
	@Override
	public Result execute(ListSkuReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<Sku> list = brandMapper.queryByList(arg);
		ListSkuResDTO resDTO = new ListSkuResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setProductName(arg.getProductName());
		resDTO.setAttributeName(arg.getAttributeName());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setTableId(arg.getTableId());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
