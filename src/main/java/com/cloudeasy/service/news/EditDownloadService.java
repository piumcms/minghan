/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.model.Download;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: EditDownloadService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("editDownloadService")
public class EditDownloadService extends BaseService<Download, Download> {

	
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
	public Download execute(Download record) throws Exception {
		
		Download newsHonour = downloadMapper.selectByPrimaryKey(record.getId());
		
		return newsHonour;
	}

}
