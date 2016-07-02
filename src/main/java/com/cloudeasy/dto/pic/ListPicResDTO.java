/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.pic;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Picture;

/** 
 * @Title: ListUserResDTO 
 * @Description: TODO
 * @author LL
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListPicResDTO extends BaseDTO {

	private List<Picture> list;

	public List<Picture> getList() {
		return list;
	}

	public void setList(List<Picture> list) {
		this.list = list;
	}
	
	
	
}
