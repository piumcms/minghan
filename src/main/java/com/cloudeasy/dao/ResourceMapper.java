package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.model.Resource;
import com.cloudeasy.mybatis.DynamicDBValues;

public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    Resource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resource_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Resource record);
    
    List<Resource> findAllMenuItems(DynamicDBValues dy);
    
    int queryByCount(Resource res);
    
    List<Resource> queryByList(DataGridModel model);
    
    List<Resource> queryResByParentId(Integer parentId);
}