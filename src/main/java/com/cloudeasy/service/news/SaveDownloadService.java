/**
 * 
 */
package com.cloudeasy.service.news;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.model.Download;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveDownloadService")
public class SaveDownloadService extends
		BaseService<Result, Download> {
	
	@Autowired
	private DownloadMapper downloadMapper;

	@Override
	public Result execute(Download arg) throws Exception {

		int count = 0;
		//截取上传图片url
		String url = "";
/*		if (StringUtils.equals("2", arg.getCategory())) {
			if (StringUtils.indexOf(arg.getPicture(), "image") != -1) {
				url = arg.getPicture();
				url = url.substring(url.lastIndexOf("/") + 1);
				arg.setPicture(url);
			}
		}
		if (StringUtils.indexOf(arg.getUrl(), "file") != -1) {
			url = arg.getUrl();
			url = url.substring(url.lastIndexOf("/") + 1);
			arg.setUrl(url);
		}*/
		if (arg.getId() != null) {
//			arg.setCreateUser(null);
			count = downloadMapper.updateByPrimaryKeySelective(arg);
		} else {
			arg.setCreateTime(new Date());
			count = downloadMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
