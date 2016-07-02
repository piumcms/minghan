/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.about;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.dto.about.ListElegantReqDTO;
import com.cloudeasy.dto.about.ListElegantResDTO;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listElegantService")
public class ListElegantService extends BaseService<Result, ListElegantReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private NewsHonourMapper newsHonourMapper;
	
	
	public Result execute(ListElegantReqDTO arg) throws Exception {
	
		Integer rowCount = newsHonourMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<NewsHonour> list = newsHonourMapper.queryForList(arg);
		
		ListElegantResDTO resDTO = new ListElegantResDTO();
		resDTO.setNewsTypeId(arg.getNewsTypeId());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
