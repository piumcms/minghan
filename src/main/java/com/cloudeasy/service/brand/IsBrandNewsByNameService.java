package com.cloudeasy.service.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 判断品牌新闻是否存在
 * @author tbs
 *
 */
@Service("isBrandNewsByNameService")
public  class IsBrandNewsByNameService extends BaseService<Result,BrandNews>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(BrandNews arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getTitle()!= null) {
			ListBrandNewsReqDTO dto=new ListBrandNewsReqDTO();
			dto.setTitle(arg.getTitle());
			dto.setBrandType(arg.getBrandType());
			dto.setCategory(arg.getCategory());
			int cout = brandMapper.isBrandName(dto);
			getResult().setObj(cout);
		}
		
		return getResult();
	}

}
