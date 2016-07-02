package com.cloudeasy.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dao.NewsTypeMapper;
import com.cloudeasy.model.News;
import com.cloudeasy.model.NewsType;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 删除新闻类别
 * @author madmai
 *
 */
@Service("deleteNewsService")
public class DeleteNewsService extends BaseService<Result, News>{

	@Autowired
	private NewsMapper newsMapper;
	
	@Override
	public Result execute(News arg) throws Exception {
		int count = 0;
		if(arg.getId()!=null){
			count = newsMapper.deleteByPrimaryKey(arg.getId());
		}
		return getResult();
	}

}
