package com.cloudeasy.service.brand;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键删除品牌新闻
 * @author tbs
 *
 */
@Service("deleteBrandNewsService")
public  class DeleteBrandNewsService extends BaseService<Result,BrandNews>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(BrandNews arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = brandMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
