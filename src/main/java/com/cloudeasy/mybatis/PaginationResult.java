package com.cloudeasy.mybatis;

import java.util.List;

/**
 * 
 * @Title: PaginationResult 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:11:20 
 * @version V1.0  
 * @param <E>
 */
    public interface PaginationResult<E> {
	
	  /**
	   * 当前页数�?�?
	   * @return
       */
	   List<E> getData(); 
	
	   /**
	    * 总行数�?
	    * @return
	    */
	   int getRowTotal(); 
	
	  /**
	   * 只分页不统计总行数时true,该�?并不真正代表数据库中还有更多的数据，只代表可能还有数�?
	   * @return
	   */
	   boolean hasMoreData(); 
   }
