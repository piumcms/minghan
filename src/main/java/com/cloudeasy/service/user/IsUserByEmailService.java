package com.cloudeasy.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.UserMapper;
import com.cloudeasy.dto.user.ListUserReqDTO;
import com.cloudeasy.model.User;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
* 
* @Title: IsUserByNameService 
* @Description: TODO(根据根据邮箱获取User) 
* @author TBS
* @date Dec 12, 2013 8:52:19 PM 
* @version V1.0
 */
@Service("isUserByEmailService")
public  class IsUserByEmailService extends BaseService<Result,User>{
	
	@Autowired
    private UserMapper userMapper;
	
	@Override
	public Result execute(User arg) throws Exception {
		// TODO Auto-generated method stub
		if (arg.getUsername()!= null) {
			ListUserReqDTO dto=new ListUserReqDTO();
			dto.setEmail(arg.getEmail());
			int cout = userMapper.isUserEmail(dto);
			getResult().setObj(cout);
		}
		return getResult();
	}

}
