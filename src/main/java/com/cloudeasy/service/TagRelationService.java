/**  
* 北京智普信科技股份有限公司
* Copyright Right (c) 2012-2015 Beijing Zeepson technology Co.,Ltd. 
* http://www.zeepson.com/
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.TagRelationMapper;
import com.cloudeasy.model.TagRelation;

/** 
 * @Title: TagRelationService 
 * @Description: TODO
 * @author wayne
 * @date 2016年6月30日 下午4:44:33 
 * @version V1.0   
 */
@Service
public class TagRelationService {
	@Autowired
	private TagRelationMapper tagRelationMapper;

	/** 
	 * TODO
	 * @param params
	 * void 
	 */
	public List<TagRelation> queryByList(Map params) {
		// TODO Auto-generated method stub
		return tagRelationMapper.queryByList(params);
	}

	/** 
	 * TODO
	 * @param id
	 * @param tagRelationProduct
	 * void 
	 */
	public void deleteByRelationId(Map params) {
		
		tagRelationMapper.deleteByRelationByParam(params);
	}

	/** 
	 * TODO
	 * @param tr
	 * void 
	 */
	public void insert(TagRelation tr) {
		tagRelationMapper.insert(tr);
		
	}
	
}
