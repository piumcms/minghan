package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Welfare;

public interface WelfareMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int insert(Welfare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int insertSelective(Welfare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    Welfare selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Welfare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Welfare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Welfare record);
    
    /**
     * 总条数
     * @param model
     * @return int
     */
    int findByCount(BaseDTO model);
    /**
     * 获取所有风采
     * @param flag
     * @return list
     */
    List<Welfare> findForList(BaseDTO model);
    
	/**
     * 总条数
     * @param model
     * @return int
     */
    public int queryByCount(BaseDTO model);
    
    /**
     * 新闻列表
     * @param model
     * @return
     */
	List<Welfare> queryByList(BaseDTO model);
	
}