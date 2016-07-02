/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**

 * @Title: BaseDao 
 * @Description: 基本DAO
 * @author ZDH
 * @date 2013-9-6 下午5:03:13 
 * @version V1.0
 */
public interface BaseDao {

	/**
	 * 参数初始�?
	 * @return
	 */
	public abstract DynamicDBValues createDBValues();
	
   /**
	* 分页参数初始�?
	* @return
	*/
	public abstract DynamicDBValues createDBPageValues();
	
	/**
	 * 参数初始化�?
	 * @return
	 */
	public abstract DynamicDBValues createDBValuesWithInitialize(Object obj) throws Exception;
	
	
	/**
	 * 带分页参数初始化�?
	 * @param object 对应DTO
	 * @return dbDao
	 */
	public DynamicDBValues createDBValuesWithInitializePage(Object object) throws Exception;
	
	/**
	 * 实体结果值取�?
	* @param 对应SQLID
	* @param in参数初始�?
	* @return 实体结果
	 */
	public abstract <T extends Serializable> T queryForObject(String s , DynamicDBValues dynamicDBValues);
	
	/**
	 * 列表结果值取�?
	* @param 对应SQLID
	* @param in参数初始�?
	* @param 记录�?��的index
	* @param 查询记录�?
	* @return 结果�?
	 */
	public abstract <T extends Serializable> List<T> queryForList(String s , DynamicDBValues dynamicDBValues);
	
	/**
	 * 数据插入
	* @param 对应SQLID
	* @param in参数初始�?
	* @param 查询记录�?
	* @return 插入条数
	 */
	public abstract int insert(String s , DynamicDBValues dynamicDBValues);
	
	/**
	 * 插入数据返回主键�?
	* @param s SQLID
	* @param dynamicDBValues 参数初始�?
	* @return
	 */
	public abstract int insertReturnPrimaryKey(String s,
			DynamicDBValues dynamicDBValues);
	
	/**
	 * 数据更新�?
	 * @param s SQLID
	 * @param dynamicDBValues 参数初始�?
	 * @return
	 */
	public abstract int update(String s,
			DynamicDBValues dynamicDBValues);
	
	/**
	 * 删除数据�?
	 * @param s
	 * @param dynamicDBValues
	 * @return
	 */
	public abstract int delete(String s, DynamicDBValues dynamicDBValues);
	
	/**
     * 从多个结果中取第�?��结果
    * @param 对应SQLID
    * @param in参数初始�?
    * @param 记录�?��的index
    * @param 查询记录�?
    * @return 对象
     */
    public abstract <T extends Serializable> T queryForOneObject(String s , DynamicDBValues dynamicDBValues);
    
    /**
     * 数据批量插入
    * @param 对应SQLID
    * @param dynamicDBValues参数初始�?
    * @return 插入条数
     */
    public abstract <T extends Serializable> int insert(String s , List<T> list);
    
    /**
     * 数据查询
    * @param <T>
    * @param s
    * @param dynamicDBValues
    * @return map
     */
    
    public abstract Map<?, ?> queryForMap(String s , DynamicDBValues dynamicDBValues, String key);
    
    /**
     * 查询结果map,list
     * @param s
     * @param dynamicDBValues
     * @return list
     */
    public abstract  List<Map<?, ?>> queryForListWithMap(String s , DynamicDBValues dynamicDBValues);
}
