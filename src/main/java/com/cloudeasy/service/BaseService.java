/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;

/** 
 * @Title: BaseService 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 上午11:22:24 
 * @version V1.0   
 */
public abstract class BaseService<K, V>{


	@Autowired
	protected BaseDao baseDao;
	
	private Result result;
	
	/**
	 * @return result 
	 */
	public Result getResult() {
		if (result == null) {
			result = new ResultImpl();
		}
		return result;
	}

	/**
	 * service main method
	 * @param arg v
	 * @return k
	 * @throws Exception
	 */
	public abstract K execute(V arg) throws Exception;
}
