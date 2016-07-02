/**
 * 
 */
package com.cloudeasy.service.news;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.model.News;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveNewsService")
public class SaveNewsService extends
		BaseService<Result, News> {
	
	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
    private PlatformTransactionManager platformTransactionManager; 

	@Override
	public Result execute(News arg) throws Exception {
		 // 事物开启
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();     
        TransactionStatus status=platformTransactionManager.getTransaction(def);
		int count = 0;
		//截取上传图片url
		String url = "";
		arg.setSeq(0);
		arg.setClickCount(0);
		if (StringUtils.indexOf(arg.getPicture(), "image") != -1) {
			url = arg.getPicture();
			url = url.substring(url.indexOf("image/") + 6);
			arg.setPicture(url);
		}
		if (arg.getId() != null) {
			arg.setCreateUser(null);
			count = newsMapper.updateByPrimaryKeySelective(arg);
		} else {
			if (arg.getNewsTypeId() != null && (arg.getNewsTypeId().intValue() == 5 || arg.getNewsTypeId().intValue() == 6)) {
				
			} else {
				arg.setCreateTime(new Date());
			}
			
			arg.setIsCheck("0");
			count = newsMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		platformTransactionManager.commit(status);
		return getResult();
	}

}
