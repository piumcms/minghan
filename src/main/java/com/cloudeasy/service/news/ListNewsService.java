/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dto.news.ListNewsReqDTO;
import com.cloudeasy.dto.news.ListNewsResDTO;
import com.cloudeasy.model.News;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listNewsService")
public class ListNewsService extends BaseService<Result, ListNewsReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private NewsMapper newsMapper;
	
	
	public Result execute(ListNewsReqDTO arg) throws Exception {
	
		Integer rowCount = newsMapper.findByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<News> list = newsMapper.findForList(arg);
		
		ListNewsResDTO resDTO = new ListNewsResDTO();
		resDTO.setNewsTypeId(arg.getNewsTypeId());
		resDTO.setPager(arg.getPager());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
