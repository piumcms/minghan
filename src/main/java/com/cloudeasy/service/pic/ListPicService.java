/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.pic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.dao.PictureMapper;
import com.cloudeasy.dto.about.ListElegantReqDTO;
import com.cloudeasy.dto.about.ListElegantResDTO;
import com.cloudeasy.dto.pic.ListPicReqDTO;
import com.cloudeasy.dto.pic.ListPicResDTO;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.model.Picture;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("listPicService")
public class ListPicService extends BaseService<Result, ListPicReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private PictureMapper pictureMapper;
	
	
	public Result execute(ListPicReqDTO arg) throws Exception {
	
		Integer rowCount = pictureMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<Picture> list = pictureMapper.queryForList(arg);
		
		ListPicResDTO resDTO = new ListPicResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
