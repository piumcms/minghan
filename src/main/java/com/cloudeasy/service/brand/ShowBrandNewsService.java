/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.brand;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dto.brand.ShowBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ShowBrandNewsResDTO;
import com.cloudeasy.dto.news.ListNewsReqDTO;
import com.cloudeasy.dto.news.ListNewsResDTO;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.News;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ShowBrandNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("showBrandNewsService")
public class ShowBrandNewsService extends BaseService<Result, ShowBrandNewsReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private BrandNewsMapper brandNewsMapper;
	
	
	public Result execute(ShowBrandNewsReqDTO arg) throws Exception {
	
		Integer rowCount = brandNewsMapper.findByCountByBrandId(arg);
		arg.getPager().setRowCount(rowCount);
		arg.setRows(15);
		List<BrandNews> list = brandNewsMapper.findByListByBrandId(arg);
		
		ShowBrandNewsResDTO resDTO = new ShowBrandNewsResDTO();
		resDTO.setTotalRows(rowCount);
		resDTO.setBrandId(arg.getBrandId());
		resDTO.setPager(arg.getPager());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
