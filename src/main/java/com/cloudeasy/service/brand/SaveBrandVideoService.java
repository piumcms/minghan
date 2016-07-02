/**
 * 
 */
package com.cloudeasy.service.brand;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandVideoMapper;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveBrandVideoService")
public class SaveBrandVideoService extends
		BaseService<Result, BrandVideo> {
	
	@Autowired
	private BrandVideoMapper brandVideoMapper;

	@Override
	public Result execute(BrandVideo arg) throws Exception {

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
//			arg.setCreateUser(null);
			count = brandVideoMapper.updateByPrimaryKeySelective(arg);
		} else {
			arg.setCreateTime(new Date());
			count = brandVideoMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
