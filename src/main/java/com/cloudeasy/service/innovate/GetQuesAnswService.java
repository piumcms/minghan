/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.innovate;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudeasy.model.Brand;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: GetQuesAnswService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("getQuesAnswService")
public class GetQuesAnswService extends BaseService<List<Brand>, String> {

	
	/**
	 * 获取所需品牌
	 */
	private final String SQL_FINDALLBRAND = "index.findAllBrand";
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public List<Brand> execute(String arg) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("flag", arg);
		List<Brand> brandList = baseDao.queryForList(SQL_FINDALLBRAND, dy);
		return brandList;
	}

}
