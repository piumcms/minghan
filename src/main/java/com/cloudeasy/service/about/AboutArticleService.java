package com.cloudeasy.service.about;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.utils.Constants;

@Service("aboutArticleService")
public class AboutArticleService {

	@Autowired
	protected 	BaseDao 				baseDao;

	@Autowired
	private 	AboutArticleMapper 		aboutArticleMapper;
	
    public Integer save(AboutArticle resource){
    	Date now = new Date();
    	resource.setCreateTime(now);
        aboutArticleMapper.insert(resource);
        return resource.getId();
    }
    
    public Integer update(AboutArticle resource){
    	aboutArticleMapper.updateByPrimaryKey(resource);
        return resource.getId();
    }
    
    public void delete(Integer id){
    	aboutArticleMapper.deleteByPrimaryKey(id);
    }
    
    public List<AboutArticle> findList(final AboutArticle aboutArticle){
    	return aboutArticleMapper.queryForList(aboutArticle);
    }
    
    /*public Object findPaginationList(DataGridModel gridModel,final AboutArticle resource){
    	Map<String,Object> result = new HashMap<String,Object>(2);
    	resource.setParentId(resource.getId());
    	List<AboutArticle> list = null;
    	if(resource.getId()!=0){
    		list = aboutArticleMapper.queryResByParentId(resource.getId());
    	}else{
    		Integer rowCount = aboutArticleMapper.queryByCount(resource);
    		result.put(Constants.TOTAL, rowCount);
    		
        	Map<String,Object> params = new HashMap<String,Object>(1);
        	params.put("parentId",resource.getId());
        	gridModel.setParams(params);
        	gridModel.setPage((gridModel.getPage()-1)*gridModel.getRows());
            list = aboutArticleMapper.queryByList(gridModel);
    	}
    	
    	List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>(0);
        if(null!=list&&list.size()>0){
        	datas = new ArrayList<Map<String,Object>>(list.size());
        	for(AboutArticle res:list){
        		datas.add(getMap(res));
        	}
        }
    	
        if(resource.getId()!=0){
        	return datas;
        }
        result.put(Constants.ROWS, datas);
    	return result;
        
    }*/ 
    

}
