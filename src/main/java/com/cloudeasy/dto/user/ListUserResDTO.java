/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.user;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.User;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListUserResDTO extends BaseDTO {

	private List<User> list;

	/**
	 * @return list 
	 */
	
	public List<User> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<User> list) {
		this.list = list;
	}
}
