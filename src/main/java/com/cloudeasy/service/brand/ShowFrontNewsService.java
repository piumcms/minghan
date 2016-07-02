package com.cloudeasy.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dto.brand.ShowBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ShowBrandNewsResDTO;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("showFrontNewsService")
public  class ShowFrontNewsService extends BaseService<Result,ShowBrandNewsReqDTO>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(ShowBrandNewsReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = brandMapper.findByCountByBrandId(arg);
		arg.getPager().setRowCount(rowCount);
        List<BrandNews> list = brandMapper.findByListByBrandId(arg);
        ShowBrandNewsResDTO resDTO = new ShowBrandNewsResDTO();
        resDTO.setBrandId(arg.getBrandId());
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
