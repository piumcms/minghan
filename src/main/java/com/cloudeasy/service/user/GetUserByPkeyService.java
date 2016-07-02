package com.cloudeasy.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.UserMapper;
import com.cloudeasy.model.User;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

/**
 * 根据Key获取User
 * @author tbs
 *
 */
@Service("getUserByPkeyService")
public  class GetUserByPkeyService extends BaseService<Result,User>{
	
	@Autowired
    private UserMapper BrandMapper;
	
	@Override
	public Result execute(User arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getId() != null) {
			arg = BrandMapper.selectByPrimaryKey(arg.getId());
		}
		getResult().setObj(arg);
		return getResult();
	}

}
