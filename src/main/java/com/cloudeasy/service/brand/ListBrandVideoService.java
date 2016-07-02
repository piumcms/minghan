/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.brand;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandVideoMapper;
import com.cloudeasy.dto.about.ListElegantResDTO;
import com.cloudeasy.dto.brand.ListBrandVideoReqDTO;
import com.cloudeasy.dto.brand.ListBrandVideoResDTO;
import com.cloudeasy.model.BrandVideo;
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
@Service("listBrandVideoService")
public class ListBrandVideoService extends BaseService<Result, ListBrandVideoReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private BrandVideoMapper brandVideoMapper;
	
	
	public Result execute(ListBrandVideoReqDTO arg) throws Exception {
	
		Integer rowCount = brandVideoMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<BrandVideo> list = brandVideoMapper.queryForList(arg);
		
		ListBrandVideoResDTO resDTO = new ListBrandVideoResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setBrandId(arg.getBrandId());
		resDTO.setList(list);
		resDTO.setPageNumber(arg.getPageNumber());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
