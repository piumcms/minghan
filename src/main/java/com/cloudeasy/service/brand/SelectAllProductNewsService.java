package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.bean.ProductNews;
import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dto.brand.ListProductNewsReqDTO;
import com.cloudeasy.dto.brand.ListProductNewsResDTO;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllProductNewsService")
public  class SelectAllProductNewsService extends BaseService<Result,ListProductNewsReqDTO>{
	
	@Autowired
    private BrandMapper brandMapper;
	
	@Override
	public Result execute(ListProductNewsReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.querySelectAllCount(arg);
		arg.getPager().setRowCount(rowCount);
        List<ProductNews> list = brandMapper.querySelectAllByList(arg);
		ListProductNewsResDTO resDTO = new ListProductNewsResDTO();
		resDTO.setTotalRows(rowCount);
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setList(list);
		resDTO.setTitle(arg.getTitle());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
