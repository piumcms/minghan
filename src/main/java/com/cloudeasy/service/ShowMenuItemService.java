/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.ResourceMapper;
import com.cloudeasy.model.Resource;
import com.cloudeasy.mybatis.DynamicDBValues;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("showMenuItemService")
public class ShowMenuItemService extends BaseService<Map<String, List<Resource>>, Map<String, String>>{

	
	/**
	 * 根据角色获取菜单
	 */
	private static final String SELECTRESOURCESBYROLENAME = "index.selectResourcesByRoleName";
	
	@Autowired
	private ResourceMapper mapper;
	
	
	public Map<String, List<Resource>> execute(Map<String, String> map) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("flag", map.get("flag"));
		List<Resource> list = mapper.findAllMenuItems(dy);
		
		Map<String, List<Resource>> resultMap = new HashMap<String, List<Resource>>();
		resultMap.put("list", list);
		
		dy.put("name", map.get("name"));
		dy.put("flag", map.get("flag"));
		List<Resource> chooseList = baseDao.queryForList(SELECTRESOURCESBYROLENAME, dy);
		resultMap.put("chooseList", chooseList);
		
		return resultMap;
	}
	
}
