/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.ProductCategoryMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.dto.user.ProductCategoryReqDTO;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.ProductCategory;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;

@Service("productCategoryService")
public class ProductCategoryService{

	/**
	 * 插入权限语句
	 */
	private static final String SQL_BATCHINSERT = "index.batchInsertCategory";
	
	@Autowired
	protected 	BaseDao 			baseDao;
	
	@Autowired
	private ProductCategoryMapper 	mapper;
	
	@Autowired
	private ProductMapper 			productMapper;
	
	@Autowired
	private 	CategoryMapper 		categoryMapper;
	
	public Result save(ProductCategoryReqDTO reqDTO) throws Exception {
		Result result = new ResultImpl();
		/*Product product = productMapper.selectByPrimaryKey(reqDTO.getId());
		*/
		/*// 更新product
		product.setMemo(reqDTO.getMemo());
		product.setName(reqDTO.getName());
		productMapper.updateByPrimaryKeySelective(product);*/
		// 删除所有角色
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductId(reqDTO.getId());
		int count = mapper.deleteByProductCategory(productCategory);
		if (count == 0) {
			//result.setStatus("1");
		}
		// 开始保存新的权限
		String[] ids = reqDTO.getIds().split(",");
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		for (String id: ids) {
			productCategory = new ProductCategory();
			productCategory.setProductId(reqDTO.getId());
			productCategory.setCategoryId(Integer.valueOf(id));
			list.add(productCategory);
		}
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("list", list);
		count = baseDao.insert(SQL_BATCHINSERT, dy);
		if (count == 0) {
			result.setStatus("1");
		}
		return result;
	}
	
	
	/**
	 * getAllCategoryProduct
	 * @param mp 参数说明
	 * @return Map<String,List<Product>>
	 * */
	public Map<String,List<Product>>  getAllCategoryProduct(Map<String,Object> mp){
		
		Map<String,List<Product>> result = new LinkedHashMap<String,List<Product>>(3);
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("brandType",mp.get("brandType"));
		List<Category> list = categoryMapper.findAllCategorys(dy);
		
		if(null!=list&&list.size()>0){
			for(Category category:list){
				dy = baseDao.createDBValues();
				dy.put("categoryId",category.getId());
				result.put(category.getName(),mapper.selectProductByCategory(dy));
			}
		}
		
		return result;
	}
	
	/**
	 * getAllCategoryProduct
	 * @param mp 参数说明
	 * @return Map<String,List<Product>>
	 * */
	public List<Product>  getProductByCondition(Map<String,Object> mp){
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("categoryId",mp.get("categoryId"));
		dy.put("tableId",mp.get("tableId"));
		dy.put("language",mp.get("language"));
		dy.put("pw",mp.get("pw"));
		List<Product> temp = mapper.selectProductByCategory(dy);
		return temp;
	}

}
