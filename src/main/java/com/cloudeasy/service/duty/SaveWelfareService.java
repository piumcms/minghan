/**
 * 
 */
package com.cloudeasy.service.duty;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.WelfareMapper;
import com.cloudeasy.model.Welfare;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * @author admin
 *
 */
@Service("saveWelfareService")
public class SaveWelfareService extends
		BaseService<Result, Welfare> {
	
	@Autowired
	private WelfareMapper welfareMapper;

	@Override
	public Result execute(Welfare arg) throws Exception {

		int count = 0;
		//截取上传图片url
		String url = "";
		if (StringUtils.indexOf(arg.getPicture(), "image") != -1) {
			url = arg.getPicture();
			url = url.substring(url.indexOf("image/") + 6);
			arg.setPicture(url);
		}
		if (arg.getId() != null) {
			arg.setCreateUser(null);
			count = welfareMapper.updateByPrimaryKeySelective(arg);
		} else {
			if (arg.getNewsTypeId() != null && arg.getNewsTypeId().intValue() == 10) {
				
			} else {
			arg.setCreateTime(new Date());
			}
			arg.setIsCheck("0");
			count = welfareMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

}
