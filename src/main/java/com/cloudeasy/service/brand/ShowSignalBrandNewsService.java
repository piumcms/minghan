/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.brand;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: ShowBrandNewsService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("showSignalBrandNewsService")
public class ShowSignalBrandNewsService extends BaseService<BrandNews, Integer> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private BrandNewsMapper brandNewsMapper;
	
	
	public BrandNews execute(Integer arg) throws Exception {
	
		BrandNews brandNews = brandNewsMapper.selectByPrimaryKey(arg);
		
		return brandNews;
	}

}
