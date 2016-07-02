package com.cloudeasy.service.brand;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 根据主键删除品牌新闻
 * @author tbs
 *
 */
@Service("recommendBrandNewsService")
public  class RecommendBrandNewsService extends BaseService<Result,BrandNews>{
	
	@Autowired
    private BrandNewsMapper brandMapper;
	
	@Override
	public Result execute(BrandNews arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = brandMapper.updateByPrimaryKeySelective(arg);
		}
		return getResult();
	}

}
