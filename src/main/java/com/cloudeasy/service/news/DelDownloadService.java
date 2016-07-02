/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.model.Download;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: DelDownloadService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("delDownloadService")
public class DelDownloadService extends BaseService<Integer, Download> {

	
	@Autowired
	private DownloadMapper downloadMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Integer execute(Download record) throws Exception {
		
		Integer count = downloadMapper.deleteByPrimaryKey(record.getId());
		
		return count;
	}

}
