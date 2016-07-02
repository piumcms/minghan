package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dao.SkuMapper;
import com.cloudeasy.model.Sku;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存商品属性
 * @author tbs
 *
 */
@Service("saveSkuService")
public class SaveSkuService extends BaseService<Result, Sku>{
	
	@Autowired
	private SkuMapper brandMapper;
   
	@Override
	public Result execute(Sku arg) throws Exception {
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
