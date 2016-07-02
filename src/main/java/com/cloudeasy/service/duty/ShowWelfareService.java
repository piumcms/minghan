/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.duty;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.WelfareMapper;
import com.cloudeasy.dto.duty.WelfareReqDTO;
import com.cloudeasy.dto.duty.WelfareResDTO;
import com.cloudeasy.model.Welfare;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("showWelfareService")
public class ShowWelfareService extends BaseService<WelfareResDTO, WelfareReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private WelfareMapper welfareMapper;
	
	
	public WelfareResDTO execute(WelfareReqDTO arg) throws Exception {
	
		WelfareResDTO resDTO = new WelfareResDTO();
		Integer rowCount = welfareMapper.findByCount(arg);
		arg.setRows(5);
		arg.getPager().setRowCount(rowCount);
		List<Welfare> list = welfareMapper.findForList(arg);
		
		resDTO.setNewsTypeId(arg.getNewsTypeId());
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		return resDTO;
	}

}
