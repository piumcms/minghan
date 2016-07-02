/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service.pic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.PictureMapper;
import com.cloudeasy.model.Picture;
import com.cloudeasy.service.BaseService;

/** 
 * @Title: FrontPicService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 上午10:49:22 
 * @version V1.0   
 */
@Service("frontPicService")
public class FrontPicService extends BaseService<List<Picture>, Picture> implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = -3374911673288270041L;

	@Autowired
	private PictureMapper pictureMapper;
	
	
	public List<Picture> execute(Picture arg) throws Exception {
	
		
		List<Picture> list = pictureMapper.findForList(arg);
		
		return list;
	}

}
