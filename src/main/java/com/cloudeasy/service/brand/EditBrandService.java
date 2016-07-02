/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.brand;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandVideoMapper;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: EditBrandService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("editBrandService")
public class EditBrandService extends BaseService<BrandVideo, BrandVideo> {

	
	@Autowired
	private BrandVideoMapper brandVideoMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public BrandVideo execute(BrandVideo record) throws Exception {
		
		BrandVideo newsHonour = brandVideoMapper.selectByPrimaryKey(record.getId());
		
		return newsHonour;
	}

}
