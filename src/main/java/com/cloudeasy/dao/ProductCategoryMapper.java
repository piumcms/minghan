package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.model.Category;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.ProductCategory;
import com.cloudeasy.mybatis.DynamicDBValues;

public interface ProductCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    int insert(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    int insertSelective(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    ProductCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductCategory record);
    
    int deleteByProductCategory(ProductCategory record);
    
    List<Category> selectCategoryByProduct(DynamicDBValues dy);
    
    int getTotalRows(DynamicDBValues dy);
    
    List<Product>  selectProductByCategory(DynamicDBValues dy);
    
    List<Product>	selectProductByMainProduct(DynamicDBValues dy);
    
    List<Product>	selectProductByChildProduct(DynamicDBValues dy);
}