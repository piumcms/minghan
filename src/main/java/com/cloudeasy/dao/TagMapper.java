package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.KeyWords;
import com.cloudeasy.model.Tag;

public interface TagMapper {
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
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    Tag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table key_words_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Tag record);
    
    List<Tag> queryByList(BaseDTO model);
    
    /**
     * 总条数
     * @param model
     * @return int
     */
    public int queryByCount(BaseDTO model);

	/** 
	 * TODO
	 * @return
	 * List<Tag> 
	 */
	List<Tag> selectAllAbled();
}