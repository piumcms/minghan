package com.cloudeasy.service.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.model.News;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

@Service("frontNewsListService")
public class FrontNewsListService extends BaseService<List<News>, Map<String, Object>> {

	@Autowired
	private NewsMapper newsMapper;
	
	
	@Override
	public List<News> execute( Map<String, Object> arg) throws Exception {
		// TODO Auto-generated method stub
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("newsTypeId", arg.get("newsTypeId"));
		dy.put("page", arg.get("page"));
		dy.put("flag", arg.get("flag"));
		List<News> list = newsMapper.frontNewsBySeq(dy);
		
		return list;
	}
}
