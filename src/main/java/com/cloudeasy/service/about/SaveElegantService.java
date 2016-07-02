/**
 * 
 */
package com.cloudeasy.service.about;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.NewsHonourMapper;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveElegantIntrService")
public class SaveElegantService extends
		BaseService<Result, NewsHonour> {
	
	@Autowired
	private NewsHonourMapper newsHonourMapper;

	@Override
	public Result execute(NewsHonour arg) throws Exception {

		int count = 0;
		//截取上传图片url
		String url = "";
		if (StringUtils.indexOf(arg.getPicture(), "image") != -1) {
			url = arg.getPicture();
			url = url.substring(url.indexOf("image/") + 6);
			arg.setPicture(url);
		}
		if (StringUtils.indexOf(arg.getVideoUrl(), "file") != -1) {
			url = arg.getVideoUrl();
			url = url.substring(url.indexOf("file/") + 5);
			arg.setVideoUrl(url);
		}
		if (arg.getId() != null) {
			arg.setCreateUser(null);
			count = newsHonourMapper.updateByPrimaryKeySelective(arg);
		} else {
			arg.setCreateTime(new Date());
			arg.setIsCheck("0");
			count = newsHonourMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
