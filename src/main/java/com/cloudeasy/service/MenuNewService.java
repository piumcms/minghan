/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dao.ResourceMapper;
import com.cloudeasy.dto.brand.ListProductResDTO;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.Resource;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.utils.Constants;

/** 
 * @Title: MenuService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("menuNewService")
public class MenuNewService{

	@Autowired
	protected 	BaseDao 			baseDao;

	@Autowired
	private 	ResourceMapper 		resourceMapper;
	
    public Integer save(Resource resource){
    	Date now = new Date();
    	resource.setCreateTime(now);
    	resource.setUpdateTime(now);
        resourceMapper.insert(resource);
        return resource.getId();
    }
    
    public Integer update(Resource resource){
    	resource.setUpdateTime(new Date());
    	resourceMapper.updateByPrimaryKey(resource);
        return resource.getId();
    }
    
    public void delete(Integer id){
    	resourceMapper.deleteByPrimaryKey(id);
    }
    
    public Object findPaginationList(DataGridModel gridModel,final Resource resource){
    	Map<String,Object> result = new HashMap<String,Object>(2);
    	resource.setParentId(resource.getId());
    	List<Resource> list = null;
    	if(resource.getId()!=0){
    		list = resourceMapper.queryResByParentId(resource.getId());
    	}else{
    		Integer rowCount = resourceMapper.queryByCount(resource);
    		result.put(Constants.TOTAL, rowCount);
    		
        	Map<String,Object> params = new HashMap<String,Object>(1);
        	params.put("parentId",resource.getId());
        	gridModel.setParams(params);
        	gridModel.setPage((gridModel.getPage()-1)*gridModel.getRows());
            list = resourceMapper.queryByList(gridModel);
    	}
    	
    	List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>(0);
        if(null!=list&&list.size()>0){
        	datas = new ArrayList<Map<String,Object>>(list.size());
        	for(Resource res:list){
        		datas.add(getMap(res));
        	}
        }
    	
        if(resource.getId()!=0){
        	return datas;
        }
        result.put(Constants.ROWS, datas);
    	return result;
        
    } 
    
    private Map getMap(Resource res){
    	Map mp = new HashMap(7);
    	mp.put("id",res.getId());
    	mp.put("parentId",res.getParentId());
    	mp.put("name",res.getName());
    	mp.put("url",res.getUrl());
    	mp.put("createTime",res.getCreateTime());
    	mp.put("updateTime", res.getUpdateTime());
    	List<Resource> resList = resourceMapper.queryResByParentId(res.getId());
    	mp.put("state",resList.size()>0?"closed":"open");//TreeGrid用
    	return mp;
    }
	
	/*public Result execute(AddResourceReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		
		// 删除所有角色
		ResourceResource resourceResource = new ResourceResource();
		resourceResource.setResourceId(reqDTO.getId());
		
		int count = mapper.deleteByResourceResource(resourceResource);
		
		// 删除用户角色中间表
		userResourcemapper.deleteUserResourceByResource(reqDTO.getId());
		
		Resource resource = new Resource();
		resource.setId(reqDTO.getId());
		count = resourceMapper.deleteByPrimaryKey(reqDTO.getId());
		if (count == 0) {
			result.setStatus("1");
		}
	
		return result;
	}*/
	
	

}
