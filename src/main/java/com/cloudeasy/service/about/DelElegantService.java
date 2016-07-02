/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.about;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: DelElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("delElegantService")
public class DelElegantService extends BaseService<Integer, NewsHonour> {

	
	@Autowired
	private NewsHonourMapper newsHonourMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Integer execute(NewsHonour record) throws Exception {
		
		Integer count = newsHonourMapper.deleteByPrimaryKey(record.getId());
		
		return count;
	}

}
