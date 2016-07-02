package com.cloudeasy.service.brand;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.News;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

@Service("frontBrandNewsService")
public class FrontBrandNewsService extends BaseService<BrandNews, Map<String, Object>> {

	@Autowired
	private BrandNewsMapper newsMapper;
	
	
	@Override
	public BrandNews execute( Map<String, Object> arg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("newsId in detail function :	" + arg.get("newsId"));
		Integer primaryKey = Integer.valueOf(arg.get("newsId").toString());
		BrandNews result = newsMapper.selectByPrimaryKey(primaryKey);
		System.out.println("result:"+result);
		return result;
	}
}
