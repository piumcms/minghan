/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.innovate;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.QuesAnswMapper;
import com.cloudeasy.dto.innovate.ListQuesReqDTO;
import com.cloudeasy.dto.innovate.ListQuesResDTO;
import com.cloudeasy.model.QuesAnsw;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ShowAllRoleService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listQuesService")
public class ListQuesService extends BaseService<Result, ListQuesReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private QuesAnswMapper quesAnswMapper;
	
	
	public Result execute(ListQuesReqDTO arg) throws Exception {
	
		Integer rowCount = quesAnswMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		arg.getPager().setPageId(arg.getPageNumber());
		arg.getPager().setPageSize(arg.getRows());
		List<QuesAnsw> list = quesAnswMapper.queryForList(arg);
		
		ListQuesResDTO resDTO = new ListQuesResDTO();
		resDTO.setBrandId(arg.getBrandId());
		resDTO.setPager(arg.getPager());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
