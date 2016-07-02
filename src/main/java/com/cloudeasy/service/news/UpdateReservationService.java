/**
 * 
 */
package com.cloudeasy.service.news;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.ReservationMapper;
import com.cloudeasy.model.Reservation;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("updateReservationService")
public class UpdateReservationService extends
		BaseService<Result, Reservation> {
	
	@Autowired
	private ReservationMapper reservationMapper;

	@Override
	public Result execute(Reservation arg) throws Exception {

		int count = 0;
		
		arg.setStatus("1");
		count = reservationMapper.updateByPrimaryKeySelective(arg);
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
