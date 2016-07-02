/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.innovate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.InnovateMapper;
import com.cloudeasy.model.InnovateWithBLOBs;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: addInnovateService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("addInnovateService")
public class AddInnovateService extends BaseService<InnovateWithBLOBs, InnovateWithBLOBs> {

	
	@Autowired
	private InnovateMapper innovateMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public InnovateWithBLOBs execute(InnovateWithBLOBs record) throws Exception {
		
		InnovateWithBLOBs inno = new InnovateWithBLOBs();
		List<InnovateWithBLOBs> l = innovateMapper.queryForList(record);
		if (l.size() > 0) {
			return l.get(0);
		}
			
		return inno;
	}

}
