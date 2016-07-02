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
import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.ProductCategoryMapper;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Category;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.utils.Constants;

/** 
 * @Title: CategoryService 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 上午11:38:36 
 * @version V1.0   
 */
@Service("categoryService")
public class CategoryService{

	@Autowired
	protected 	BaseDao 			baseDao;

	@Autowired
	private 	CategoryMapper 		categoryMapper;
	
	@Autowired
	private 	ProductCategoryMapper 		productCategoryMapper;
	
    public Integer save(Category resource){
    	Date now = new Date();
    	resource.setCreateTime(now);
    	resource.setUpdateTime(now);
        categoryMapper.insert(resource);
        return resource.getId();
    }
    
    public Integer update(Category resource){
    	resource.setUpdateTime(new Date());
    	categoryMapper.updateByPrimaryKey(resource);
        return resource.getId();
    }
    
    public void delete(Integer id){
    	categoryMapper.deleteByPrimaryKey(id);
    }
    
    public Object findPaginationList(DataGridModel gridModel,final Category resource){
    	Map<String,Object> result = new HashMap<String,Object>(2);
    	resource.setParentId(resource.getId());
    	List<Category> list = null;
    	if(resource.getId()!=0){
    		list = categoryMapper.queryResByParentId(resource);
    	}else{
    		Integer rowCount = categoryMapper.queryByCount(resource);
    		result.put(Constants.TOTAL, rowCount);
    		
        	Map<String,Object> params = new HashMap<String,Object>(1);
        	params.put("parentId",resource.getId());
        	params.put("brandType",resource.getBrandType());
        	gridModel.setParams(params);
        	gridModel.setPage((gridModel.getPage()-1)*gridModel.getRows());
            list = categoryMapper.queryByList(gridModel);
    	}
    	
    	List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>(0);
        if(null!=list&&list.size()>0){
        	datas = new ArrayList<Map<String,Object>>(list.size());
        	for(Category res:list){
        		datas.add(getMap(res));
        	}
        }
    	
        if(resource.getId()!=0){
        	return datas;
        }
        result.put(Constants.ROWS, datas);
    	return result;
        
    } 
    
    private Map getMap(Category res){
    	Map<String,Object> mp = new HashMap<String,Object>(7);
    	mp.put("id",res.getId());
    	mp.put("parentId",res.getParentId());
    	mp.put("name",res.getName());
    	mp.put("createTime",res.getCreateTime());
    	mp.put("updateTime", res.getUpdateTime());
    	mp.put("brandType",res.getBrandType());
    	mp.put("language",res.getLanguage());
    	mp.put("title",res.getTitle());
    	mp.put("des",res.getDes());
    	mp.put("keywords",res.getKeywords());
    	mp.put("brief",res.getBrief());
    	Category params = new Category();
    	params.setBrandType(res.getBrandType());
    	params.setParentId(res.getId());
    	List<Category> resList = categoryMapper.queryResByParentId(params);
    	mp.put("state",resList.size()>0?"closed":"open");//TreeGrid用
    	return mp;
    }
    
	public Map<String, List<Category>> getCategoryMaps(Map<String, Object> map) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("flag", map.get("flag"));
		dy.put("brandType",map.get("brandType"));
		List<Category> list = categoryMapper.findAllCategorys(dy);
		
		Map<String, List<Category>> resultMap = new HashMap<String, List<Category>>();
		resultMap.put("list", list);
		
		dy.put("productId", map.get("productId"));
		List<Category> chooseList = productCategoryMapper.selectCategoryByProduct(dy);
		resultMap.put("chooseList", chooseList);
		
		return resultMap;
	}
	
	/*public Result execute(AddCategoryReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		
		// 删除所有角色
		CategoryCategory resourceCategory = new CategoryCategory();
		resourceCategory.setCategoryId(reqDTO.getId());
		
		int count = mapper.deleteByCategoryCategory(resourceCategory);
		
		// 删除用户角色中间表
		userCategorymapper.deleteUserCategoryByCategory(reqDTO.getId());
		
		Category resource = new Category();
		resource.setId(reqDTO.getId());
		count = categoryMapper.deleteByPrimaryKey(reqDTO.getId());
		if (count == 0) {
			result.setStatus("1");
		}
	
		return result;
	}*/
	
	

}
