/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.model.News;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: EditNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("editNewsService")
public class EditNewsService extends BaseService<News, News> {

	
	@Autowired
	private NewsMapper newsMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public News execute(News record) throws Exception {
		
		News newsHonour = newsMapper.selectByPrimaryKey(record.getId());
		
		return newsHonour;
	}

}
