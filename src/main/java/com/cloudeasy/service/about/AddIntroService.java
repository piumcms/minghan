/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.about;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dto.about.AboutArticleResDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: AddIntroService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("addIntroService")
public class AddIntroService extends BaseService<AboutArticle, AboutArticle> {

	
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
	
	public Result getPaginationLists(AboutArticleResDTO arg) throws Exception {
		
		Integer rowCount = aboutArticleMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		AboutArticle article = new AboutArticle();
		article.setFlag(arg.getFlag());
		article.setBrandType(arg.getBrandType());
		article.setCategory(arg.getCategory());
        List<AboutArticle> list = aboutArticleMapper.queryForList(article);
		AboutArticleResDTO resDTO = new AboutArticleResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setBrandType(arg.getBrandType());
		resDTO.setCategory(arg.getCategory());
        resDTO.setPageNumber(arg.getPageNumber());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
