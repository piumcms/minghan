package com.cloudeasy.service.brand;

import java.util.HashMap;
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

@Service("frontBrandNewsListService")
public class FrontBrandNewsListService extends BaseService<Map<String, Object>, Map<String, Object>> {

	@Autowired
	private BrandNewsMapper newsMapper;
	
	
	@Override
	public Map<String, Object> execute( Map<String, Object> arg) throws Exception {
		// TODO Auto-generated method stub
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("schoolType", arg.get("schoolType"));
		dy.put("limit", arg.get("limit"));
		dy.put("page", arg.get("page"));
		dy.put("flag", arg.get("flag"));
		dy.put("brandType", arg.get("brandType"));
		dy.put("indexSeq",arg.get("indexSeq"));
		dy.put("category",arg.get("category"));
		dy.put("signal_seq", arg.get("signal_seq"));
		dy.put("language",arg.get("language"));
		Integer newsCount = newsMapper.frontCountByBrandId(dy);
		List<BrandNews> list = newsMapper.frontNewsBySeq(dy);
		Map<String, Object> resultMap = new HashMap();
		resultMap.put("brandNewsList", list);
		resultMap.put("brandNewsCount", newsCount);
		return resultMap;
	}
}
