/**
 * 
 */
package com.cloudeasy.service.about;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.cloudeasy.dto.about.BatchDeleteReqDTO;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("batchDeleteService")
public class BatchDeleteService extends BaseService<Integer, BatchDeleteReqDTO> {

	private final String SQL_BATCH_DEL = "index.batchDelete";
	@Override
	public Integer execute(BatchDeleteReqDTO arg) throws Exception {
		
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("ids", StringUtils.split(arg.getIds(), ","));
		dy.put("tableName", arg.getTableName());
		int count = baseDao.delete(SQL_BATCH_DEL, dy);
		
		return count;
	}

}
