/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.ProvinceMapper;
import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;

@Service("areaService")
public class AreaService{

	/**
	 * 插入权限语句
	 */
	private static final String SQL_BATCHINSERT = "index.batchInsertCategory";
	
	@Autowired
	protected 	BaseDao 			baseDao;
	
	@Autowired
	private ProvinceMapper mapper;
	
	
	public Result save(BaseDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		
		return result;
	}

}
