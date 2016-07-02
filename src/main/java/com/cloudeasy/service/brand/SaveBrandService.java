package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.model.Brand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存品牌
 * @author tbs
 *
 */
@Service("saveBrandService")
public class SaveBrandService extends BaseService<Result, Brand>{
	
	@Autowired
	private BrandMapper brandMapper;
   
	@Override
	public Result execute(Brand arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = brandMapper.updateByPrimaryKeySelective(arg);
		} else {
			arg.setCreateTime(new Date());
			count = brandMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
