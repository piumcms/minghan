/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.duty;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.WelfareMapper;
import com.cloudeasy.model.Welfare;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: DelNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("delWelfareService")
public class DelWelfareService extends BaseService<Integer, Welfare> {

	
	@Autowired
	private WelfareMapper newsMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Integer execute(Welfare record) throws Exception {
		
		Integer count = newsMapper.deleteByPrimaryKey(record.getId());
		
		return count;
	}

}
