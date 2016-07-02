/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.innovate;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandMapper;
import com.cloudeasy.dao.QuesAnswMapper;
import com.cloudeasy.dto.innovate.InnovateReqDTO;
import com.cloudeasy.dto.innovate.InnovateResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.QuesAnsw;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: addInnovateService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("showInnovateService")
public class ShowInnovateService extends BaseService<InnovateResDTO, InnovateReqDTO> {

	
	@Autowired
	private QuesAnswMapper quesAnswMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public InnovateResDTO execute(InnovateReqDTO record) throws Exception {
		
		InnovateResDTO resDto = new InnovateResDTO();
		
		List<Brand> brandList = brandMapper.findAllBrand(record);
		resDto.setBrandList(brandList);
		
		if (brandList != null && brandList.size() > 0 && record.getBrandId() == null) {
			record.setBrandId(brandList.get(0).getId());
		}
		int count = quesAnswMapper.queryForCountByBrandId(record);
		record.setRows(5);
		record.getPager().setRowCount(count);
		
		
		List<QuesAnsw> l = quesAnswMapper.queryForListByBrandId(record);
		resDto.setList(l);
		resDto.setTotalRows(count);
		resDto.setPageNumber(record.getPageNumber());
		resDto.setBrandId(record.getBrandId());
		return resDto;
	}

}
