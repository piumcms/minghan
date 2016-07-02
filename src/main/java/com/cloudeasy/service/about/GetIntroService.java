/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.about;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: AddIntroService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("getIntroService")
public class GetIntroService extends BaseService<AboutArticle, AboutArticle> {

	
	@Autowired
	private AboutArticleMapper aboutArticleMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public AboutArticle execute(AboutArticle record) throws Exception {
		
		List<AboutArticle> list = aboutArticleMapper.queryForList(record);
		if ( list != null && list.size() > 0) {
			
			return list.get(0);
		}
		return null;
	}

}
