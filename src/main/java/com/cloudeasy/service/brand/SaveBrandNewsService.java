package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.AboutArticleMapper;
import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存品牌新闻
 * @author tbs
 *
 */
@Service("saveBrandNewsService")
public class SaveBrandNewsService extends BaseService<Result, BrandNews>{
	
	@Autowired
	private BrandNewsMapper brandNewsMapper;
   
	@Override
	public Result execute(BrandNews arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = brandNewsMapper.updateByPrimaryKeySelective(arg);
		} else {
			//arg.setCreateTime(new Date());
			count = brandNewsMapper.insert(arg);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
