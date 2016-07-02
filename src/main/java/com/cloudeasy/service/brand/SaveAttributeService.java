package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dao.AttributeMapper;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存商品属性
 * @author tbs
 *
 */
@Service("saveAttributeService")
public class SaveAttributeService extends BaseService<Result, Attribute>{
	
	@Autowired
	private AttributeMapper brandMapper;
   
	@Override
	public Result execute(Attribute arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = brandMapper.updateByPrimaryKeySelective(arg);
		} else {
			count = brandMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
