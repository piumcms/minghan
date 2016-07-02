/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.news;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dto.news.NewsReqDTO;
import com.cloudeasy.dto.news.NewsResDTO;
import com.cloudeasy.model.News;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.mybatis.DynamicParameter;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ListNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("showNewsService")
public class ShowNewsService extends BaseService<NewsResDTO, NewsReqDTO> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private NewsMapper newsMapper;
	
	
	public NewsResDTO execute(NewsReqDTO arg) throws Exception {
	
		NewsResDTO resDTO = new NewsResDTO();
		
		Integer rowCount = 0;
		List<News> list = new ArrayList<News>();
		if (arg.getNewsTypeId().intValue() == 5 || arg.getNewsTypeId().intValue() == 6 ) {
			DynamicDBValues dy = baseDao.createDBValues();
			dy.put("newsTypeId", arg.getNewsTypeId());
			dy.put("flag", arg.getFlag());
			List<News> topList = newsMapper.queryTopFive(dy);
			resDTO.setTopList(topList);
			arg.setRows(5);
			rowCount = newsMapper.showNewsCount(arg);
			arg.getPager().setRowCount(rowCount);
			
			list = newsMapper.showNewsList(arg);
			
		} else if (arg.getNewsTypeId().intValue() == 13 ){
			rowCount = newsMapper.showNewsCount(arg);
			arg.setRows(6);
			arg.getPager().setRowCount(rowCount);
			list = newsMapper.showNewsList(arg);
		}
		resDTO.setNewsTypeId(arg.getNewsTypeId());
		resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);
		return resDTO;
	}

}
