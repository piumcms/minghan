/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.dao.ReservationMapper;
import com.cloudeasy.dto.about.ListDownloadResDTO;
import com.cloudeasy.dto.about.ListElegantReqDTO;
import com.cloudeasy.dto.about.ListElegantResDTO;
import com.cloudeasy.dto.about.ListReservationResDTO;
import com.cloudeasy.dto.news.ListDownloadReqDTO;
import com.cloudeasy.dto.news.ListReservationReqDTO;
import com.cloudeasy.model.Download;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.model.Reservation;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listReservationService")
public class ListReservationService extends BaseService<Result, ListReservationReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private ReservationMapper reservationMapper;
	
	
	public Result execute(ListReservationReqDTO arg) throws Exception {
	
		Integer rowCount = reservationMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<Reservation> list = reservationMapper.queryForList(arg);
		
		ListReservationResDTO resDTO = new ListReservationResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
