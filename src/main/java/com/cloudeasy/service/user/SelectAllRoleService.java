package com.cloudeasy.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.RoleMapper;
import com.cloudeasy.dto.user.ListRoleReqDTO;
import com.cloudeasy.dto.user.ListRoleResDTO;
import com.cloudeasy.model.Role;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("selectAllRoleService")
public  class SelectAllRoleService extends BaseService<Result,ListRoleReqDTO>{
	
	@Autowired
    private RoleMapper roleMapper;
	
	@Override
	public Result execute(ListRoleReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
        List<Role> list = roleMapper.queryForList("1");
        arg.getPager().setRowCount(list.size());
		ListRoleResDTO resDTO = new ListRoleResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setName(arg.getName());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}

}
