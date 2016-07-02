package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.NewProduct;

public interface NewProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    int insert(NewProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    int insertSelective(NewProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    NewProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NewProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table new_product_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NewProduct record);
    
    /**
     * 总条数
     * @param model
     * @return int
     */
    public int queryByCount(BaseDTO model);

    /**
     * 名称是否存在
     * @param model
     * @return
     */
    public int isName(BaseDTO model);
    
    
	List<NewProduct> queryByList(BaseDTO model);

	
	/**
	 * 获取所有新品
	 * @param model
	 * @return
	 */
	List<NewProduct> findAllNewProduct(BaseDTO model);
    
}