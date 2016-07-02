/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.innovate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.QuesAnswMapper;
import com.cloudeasy.model.QuesAnsw;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: DelElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("delQuesService")
public class DelQuesService extends BaseService<Integer, QuesAnsw> {

	
	@Autowired
	private QuesAnswMapper quesAnswMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Integer execute(QuesAnsw record) throws Exception {
		
		Integer count = quesAnswMapper.deleteByPrimaryKey(record.getId());
		
		return count;
	}

}
