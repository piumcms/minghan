/**
 * 
 */
package com.cloudeasy.service.innovate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.QuesAnswMapper;
import com.cloudeasy.model.QuesAnsw;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveQuesService")
public class SaveQuesService extends
		BaseService<Result, QuesAnsw> {
	
	@Autowired
	private QuesAnswMapper quesAnswMapper;

	@Override
	public Result execute(QuesAnsw arg) throws Exception {

		int count = 0;
		if (arg.getId() != null) {
			arg.setCreateUser(null);
			count = quesAnswMapper.updateByPrimaryKey(arg);
		} else {
			arg.setCreateTime(new Date());
			count = quesAnswMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
