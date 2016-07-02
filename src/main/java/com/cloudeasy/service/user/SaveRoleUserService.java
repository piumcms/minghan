package com.cloudeasy.service.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.UserRoleMapper;
import com.cloudeasy.model.UserRole;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存用户
 * @author tbs
 */
@Service("saveRoleUserService")
public class SaveRoleUserService extends BaseService<Result, UserRole>{
	
	@Autowired
	private UserRoleMapper userMapper;
   
	@Override
	public Result execute(UserRole arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		count = userMapper.deleteUserRoleByUserId(arg.getUserId());
	
		count = userMapper.insertSelective(arg);
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
