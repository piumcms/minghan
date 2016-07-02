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
import com.cloudeasy.dto.duty.ListWelfareReqDTO;
import com.cloudeasy.dto.duty.ListWelfareResDTO;
import com.cloudeasy.model.Welfare;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listWelfareService")
public class ListWelfareService extends BaseService<Result, ListWelfareReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private WelfareMapper welfareMapper;
	
	
	public Result execute(ListWelfareReqDTO arg) throws Exception {
	
		Integer rowCount = welfareMapper.findByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<Welfare> list = welfareMapper.findForList(arg);
		
		ListWelfareResDTO resDTO = new ListWelfareResDTO();
		resDTO.setNewsTypeId(arg.getNewsTypeId());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
