package com.cloudeasy.dao;

import com.cloudeasy.model.BrandDevelopment;

public interface BrandDevelopmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int insert(BrandDevelopment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int insertSelective(BrandDevelopment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    BrandDevelopment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BrandDevelopment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(BrandDevelopment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_development_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BrandDevelopment record);
}