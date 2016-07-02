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
 * @Title: EditNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("editWelfareService")
public class EditWelfareService extends BaseService<Welfare, Welfare> {

	
	@Autowired
	private WelfareMapper welfareMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Welfare execute(Welfare record) throws Exception {
		
		Welfare newsHonour = welfareMapper.selectByPrimaryKey(record.getId());
		
		return newsHonour;
	}

}
