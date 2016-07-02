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
import com.cloudeasy.dto.about.ListDownloadResDTO;
import com.cloudeasy.dto.about.ListElegantReqDTO;
import com.cloudeasy.dto.about.ListElegantResDTO;
import com.cloudeasy.dto.news.ListDownloadReqDTO;
import com.cloudeasy.model.Download;
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
@Service("listDownloadService")
public class ListDownloadService extends BaseService<Result, ListDownloadReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private DownloadMapper downloadMapper;
	
	
	public Result execute(ListDownloadReqDTO arg) throws Exception {
	
		Integer rowCount = downloadMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<Download> list = downloadMapper.queryForList(arg);
		
		ListDownloadResDTO resDTO = new ListDownloadResDTO();
		resDTO.setCategory(arg.getCategory());
		resDTO.setSiteName(arg.getSiteName());
		resDTO.setTitle(arg.getTitle());
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
