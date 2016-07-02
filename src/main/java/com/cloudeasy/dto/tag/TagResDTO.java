/**
* @class: TagResDTO.java
* @title:
* @Description: 
* @Copyright: Copyright (c) 2015
* @Company: 无锡飙码技术有限公司
* @author wayne
* @date 2016年6月28日
* @version 1.0
*/
package com.cloudeasy.dto.tag;

import java.util.List;

import com.cloudeasy.dto.BaseDTO;
import com.cloudeasy.model.Tag;

/**
 * @class: TagResDTO.java
 * @title:
 * @Description: 
 * @Copyright: Copyright (c) 2015
 * @Company: 无锡飙码技术有限公司
 * @author wayne
 * @date 2016年6月28日
 * @version 1.0
 */
public class TagResDTO extends BaseDTO {
	List<Tag> list;

	public List<Tag> getList() {
		return list;
	}

	public void setList(List<Tag> list) {
		this.list = list;
	}
	
}
