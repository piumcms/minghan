package com.cloudeasy.service.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.model.Product;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.utils.Constants;

@Service("productService")
public class ProductService {

	@Autowired
	protected 	BaseDao 				baseDao;

	@Autowired
	private 	ProductMapper 			productMapper;
	
    public Integer save(Product p){
    	Date now = new Date();
    	p.setCreateTime(now);
        productMapper.insert(p);
        return p.getId();
    }
    
    public Integer update(Product p){
    	productMapper.updateByPrimaryKey(p);
        return p.getId();
    }
    
    public void delete(Integer id){
    	productMapper.deleteByPrimaryKey(id);
    }
    
    public List<Product> findList(final Product product){
    	return productMapper.queryByList(null);
    }
    
    public Map<String,Object> findPaginationList(DataGridModel gridModel){
    	/*Map<String,Object> params = new HashMap<String,Object>(1);
    	gridModel.setParams(params);
    	gridModel.setPage((gridModel.getPage()-1)*gridModel.getRows());*/
    	Map<String,Object> result = new HashMap<String,Object>(2);
    	List<Product> list = null;
		Integer rowCount = productMapper.getTotalRows(gridModel);
		result.put(Constants.TOTAL, rowCount);
		gridModel.setPage((gridModel.getPage()-1)*gridModel.getRows());
        list = productMapper.queryList(gridModel);
        result.put(Constants.ROWS, list);
        result.put(Constants.LIST, list);
        result.put("params",gridModel.getParams());
        /*resDTO.setPageNumber(arg.getPageNumber());
		resDTO.setPager(arg.getPager());
		resDTO.setTotalRows(rowCount);
		resDTO.setList(list);*/
    	return result;
    } 
    
    public Product getProductById(Integer id){
    	return productMapper.findProductById(id);
    }
}
