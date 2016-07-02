package com.cloudeasy.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.UserMapper;
import com.cloudeasy.model.User;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存用户
 * @author tbs
 */
@Service("saveUserService")
public class SaveUserService extends BaseService<Result, User>{
	
	@Autowired
	private UserMapper userMapper;
   
	@Override
	public Result execute(User arg) throws Exception {
		arg.setCreateTime(new Date());
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = userMapper.updateByPrimaryKeySelective(arg);
		} else {
			count = userMapper.insertSelective(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
