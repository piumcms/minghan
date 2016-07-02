/**
 * 
 */
package com.cloudeasy.service.innovate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.InnovateMapper;
import com.cloudeasy.model.InnovateWithBLOBs;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveInnovateService")
public class SaveInnovateService extends
		BaseService<Result, InnovateWithBLOBs> {
	
	@Autowired
	private InnovateMapper innovateMapper;

	@Override
	public Result execute(InnovateWithBLOBs arg) throws Exception {

		int count = 0;
		if (arg.getId() != null) {
			arg.setCreateUser(null);
			count = innovateMapper.updateByPrimaryKeyWithBLOBs(arg);
		} else {
			arg.setCreateTime(new Date());
			count = innovateMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
