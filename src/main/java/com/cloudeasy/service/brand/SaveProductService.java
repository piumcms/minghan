package com.cloudeasy.service.brand;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.model.Product;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;
/**
 * 保存商品
 * @author tbs
 *
 */
@Service("saveProductService")
public class SaveProductService extends BaseService<Result, Product>{
	
	@Autowired
	private ProductMapper productMapper;
   
	@Override
	public Result execute(Product arg) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		if (arg.getId() != null) {
			count = productMapper.updateByPrimaryKeySelective(arg);
		} else {
			arg.setCreateTime(new Date());
			count = productMapper.insert(arg);
			if (arg.getMainProductId()==null || arg.getMainProductId()==null) {
				arg.setMainProductId(arg.getId());
				arg.setId(null);
				productMapper.insert(arg);
			}
		}
		System.out.println("id after insert:"+arg.getId());
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}

	

}
