/**
 * 
 */
package com.cloudeasy.service.about;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.KeyWordsMapper;
import com.cloudeasy.model.KeyWords;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveKeyWordsService")
public class SaveKeyWordsService extends
		BaseService<Result, KeyWords> {
	
	@Autowired
	private KeyWordsMapper keyWordsMapper;

	@Override
	public Result execute(KeyWords arg) throws Exception {

		int count = 0;
		if (arg.getId() != null) {
			count = keyWordsMapper.updateByPrimaryKey(arg);
		} else {
			count = keyWordsMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
