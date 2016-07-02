/**
 * 
 */
package com.cloudeasy.dto.about;

import com.cloudeasy.dto.DTO;

/**
 * @author admin
 *
 */
public class BatchDeleteReqDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 378430980530047856L;
	
	/**
	 * 主键ids
	 */
	private String ids;
	
	/**
	 * 表名
	 */
	private String tableName;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
