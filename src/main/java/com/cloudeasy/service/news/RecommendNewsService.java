/**
 * 
 */
package com.cloudeasy.service.news;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.model.News;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("recommendNewsService")
public class RecommendNewsService extends
		BaseService<Result, News> {
	
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public Result execute(News arg) throws Exception {

		int count = 0;
	
		count = newsMapper.updateByPrimaryKeySelective(arg);
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
