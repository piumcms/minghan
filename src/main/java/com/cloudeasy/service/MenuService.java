/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloudeasy.model.Resource;
import com.cloudeasy.mybatis.DynamicDBValues;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("menuService")
public class MenuService extends BaseService<List<Resource>, Map<String, String>>{

	/**
	 * 获取资源
	 */
	private final String SQL_GETRESOURCE = "index.getResource";
	
	
	public List<Resource> execute(Map<String, String> map) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("username", map.get("username"));
		dy.put("flag", map.get("flag"));
		dy.put("obj", map.get("obj"));
		List<Resource> list = baseDao.queryForList(SQL_GETRESOURCE, dy);
		return list;
	}

}
