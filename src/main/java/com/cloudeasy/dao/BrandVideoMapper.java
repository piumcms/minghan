package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.BrandVideo;

public interface BrandVideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    int insert(BrandVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    int insertSelective(BrandVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    BrandVideo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BrandVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table brand_video_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BrandVideo record);
    
    /**
     * 总条数
     * @param model
     * @return int
     */
    int queryByCount(BaseDTO model);
    
    /**
     * 获取所有风采
     * @param flag
     * @return list
     */
    List<BrandVideo> queryForList(BaseDTO model);
    
    
    /**
     * 获取所有风采
     * @param flag
     * @return list
     */
    List<BrandVideo> findForList(BrandVideo record);
}