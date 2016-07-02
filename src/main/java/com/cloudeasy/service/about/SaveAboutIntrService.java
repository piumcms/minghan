/**
 * 
 */
package com.cloudeasy.service.about;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveAboutService")
public class SaveAboutIntrService extends
		BaseService<Result, AboutArticle> {
	
	@Autowired
	private AboutArticleMapper aboutArticleMapper;

	@Override
	public Result execute(AboutArticle arg) throws Exception {

		int count = 0;
		if (arg.getId() != null) {
//			arg.setCreateUser(null);
			count = aboutArticleMapper.updateByPrimaryKeyWithBLOBs(arg);
		} else {
			arg.setCreateTime(new Date());
			count = aboutArticleMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
