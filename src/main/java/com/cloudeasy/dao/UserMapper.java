package com.cloudeasy.dao;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_tbl
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);
    
    /**
     * 名称是否存在
     * @param model
     * @return
     */
    public int isUserName(BaseDTO model);
    
    /**
     * 邮箱是否存在
     * @param model
     * @return
     */
    public int isUserEmail(BaseDTO model);
    
    /**
     *手机号码是否存在
     * @param model
     * @return
     */
    public int isUserMobile(BaseDTO model);
    
    public int isUserIp(BaseDTO model);
    
    public int hasMoreTenWin(BaseDTO model);
    
    /**
     * 总条数
     * @param model
     * @return int
     */
    public int queryByCount(BaseDTO model);
	
    /**
     * list
     * @param model
     * @return list
     */
	public List<User> queryByList(BaseDTO model);
	/**
	 * 查询所有会员
	 * @return list
	 */
	public List<User> queryAllUser();
}