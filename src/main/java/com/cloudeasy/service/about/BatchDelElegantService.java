/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.about;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: BatchDelElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("batchDelElegantService")
public class BatchDelElegantService extends BaseService<Integer, List<Integer>> {

	
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
	public Integer execute(List<Integer> list) throws Exception {
		
		Integer count = newsHonourMapper.batchDelete(list);
		
		return count;
	}

}
