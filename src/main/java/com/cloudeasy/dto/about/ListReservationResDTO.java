/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.dto.about;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Reservation;

/** 
 * @Title: ListDownloadResDTO 
 * @Description: TODO
 * @author HXJ
 * @date 2013-11-19 下午4:27:32 
 * @version V1.0   
 */
public class ListReservationResDTO extends BaseDTO {

	private List<Reservation> list;

	/**
	 * @return list 
	 */
	
	public List<Reservation> getList() {
		return list;
	}

	/** 
	 * @param list 要设置的 list 
	 */
	public void setList(List<Reservation> list) {
		this.list = list;
	}

}
