/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.mybatis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 
 * @Title: DynamicDBValues 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:09:05 
 * @version V1.0
 */
public interface DynamicDBValues extends Serializable{
	
    /**
    * 清空map
    */
	public abstract void clear();
	
   /**
	* toString 
	* @return 对应属�?字段连接的字符串
	*/
	public abstract String toString();
	
   /**
	* 由键值得到对应的实体
	* @param 对应键�?
	* @return 实体
	*/
	public abstract Object getObject(String s);
	
	
   /**
	* 由键值得到对应的字符串�?
	* @param 对应键�?
	* @return 对应的字符串�?
	*/
	public abstract String getString(String s);
	
	public abstract Object put(Object o, Object o1);
	
	public abstract Boolean getBoolean(String s);
	
	public abstract Integer getInteger(String s);
	
	public abstract Map<?, ?> getMap(String s);
	 
	public abstract List<?> getList(String s);
	 
	public abstract BigDecimal getBigDecimal(String s);
	
	public abstract Object remove(Object o);
	
	public abstract String uuid();
	
	
}
