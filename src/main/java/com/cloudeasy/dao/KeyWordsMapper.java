package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.KeyWords;

public interface KeyWordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int insert(KeyWords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int insertSelective(KeyWords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    KeyWords selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KeyWords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(KeyWords record);
    
    List<KeyWords> queryForList(KeyWords record);
}