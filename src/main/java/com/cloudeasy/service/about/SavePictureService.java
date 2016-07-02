/**
 * 
 */
package com.cloudeasy.service.about;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.PictureMapper;
import com.cloudeasy.model.Picture;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("savePictureService")
public class SavePictureService extends
		BaseService<Result, Picture> {
	
	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public Result execute(Picture arg) throws Exception {

		int count = 0;
		//截取上传图片url
		String url = "";
		if (StringUtils.indexOf(arg.getPath(), "image") != -1) {
			url = arg.getPath();
			url = url.substring(url.indexOf("image/") + 6);
			arg.setPath(url);
		}
		if (arg.getId() != null) {
			count = pictureMapper.updateByPrimaryKeySelective(arg);
		} /*else {
			arg.setCreateTime(new Date());
			arg.setIsCheck("0");
			count = newsHonourMapper.insertSelective(arg);
		}*/
		Result result = getResult();
		if (count == 0) {
			result.setStatus("1");
		}
		result.setBrandType(arg.getBrandType());
		return result;
	}

}
