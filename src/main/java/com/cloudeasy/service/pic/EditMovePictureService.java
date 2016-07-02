/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.pic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.MovePictureMapper;
import com.cloudeasy.dao.PictureMapper;
import com.cloudeasy.model.MovePicture;
import com.cloudeasy.model.Picture;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: EditElegantService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("editMovePictureService")
public class EditMovePictureService extends BaseService<MovePicture, MovePicture> {

	
	@Autowired
	private MovePictureMapper pictureMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public MovePicture execute(MovePicture record) throws Exception {
		
		record = pictureMapper.selectByPrimaryKey(record.getId());
		
		return record;
	}

}
