/**
 * 
 */
package com.cloudeasy.service.pic;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.MovePictureMapper;
import com.cloudeasy.dao.PictureMapper;
import com.cloudeasy.model.MovePicture;
import com.cloudeasy.model.Picture;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveMovePictureService")
public class SaveMovePictureService extends
		BaseService<Result, MovePicture> {
	
	@Autowired
	private MovePictureMapper movePictureMapper;

	@Override
	public Result execute(MovePicture arg) throws Exception {

		int count = 0;
		//截取上传图片url
		String url = "";
		if (StringUtils.indexOf(arg.getPath(), "image") != -1) {
			url = arg.getPath();
			url = url.substring(url.indexOf("image/") + 6);
			arg.setPath(url);
		}
		if (arg.getId() != null) {
			count = movePictureMapper.updateByPrimaryKeySelective(arg);
		} /*else {
			arg.setCreateTime(new Date());
			arg.setIsCheck("0");
			count = newsHonourMapper.insertSelective(arg);
		}*/
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
