/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.KeyWordsMapper;
import com.cloudeasy.dao.TagMapper;
import com.cloudeasy.dto.brand.ListProductResDTO;
import com.cloudeasy.dto.tag.TagRepDTO;
import com.cloudeasy.dto.tag.TagResDTO;
import com.cloudeasy.model.KeyWords;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.Tag;
import com.cloudeasy.result.Result;

/** 
 * @Title: AddIntroService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午5:21:48 
 * @version V1.0   
 */
@Service("tagService")
public class TagService extends BaseService<Result, TagRepDTO> {

	
	@Autowired
	private TagMapper tagMapper;
	
	
	/** (非 Javadoc) 
	 *  
	 *  
	 * @param arg
	 * @return
	 * @throws Exception 
	 * @see com.cloudeasy.service.BaseService#execute(java.lang.Object) 
	 */
	@Override
	public Result execute(TagRepDTO dto) throws Exception {
		Integer rowCount = tagMapper.queryByCount(dto);
		dto.getPager().setRowCount(rowCount);
        List<Tag> list = tagMapper.queryByList(dto);
		TagResDTO resDTO = new TagResDTO();
		resDTO.setPager(dto.getPager());
		resDTO.setList(list);
/*		resDTO.setBrandId(arg.getBrandId());
		resDTO.setTableId(arg.getTableId());
        resDTO.setProductName(arg.getProductName());*/
        resDTO.setPageNumber(dto.getPageNumber());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}
	
	public int executeDel(Tag record){
		int i=tagMapper.deleteByPrimaryKey(record.getId());
		return i;
	}
	public Result executeInsertOrUpdate(Tag record){
		int count = 0;
		if (record.getId() != null) {
			count = tagMapper.updateByPrimaryKey(record);
		} else {
			count = tagMapper.insert(record);
		}
		if (count == 0) {
			getResult().setStatus("1");
		}
		return getResult();
	}
	
	public Tag selectById(int id){
		Tag tag=tagMapper.selectByPrimaryKey(id);
		return tag;
	}
	
	/**
	 * 查询所有显示的标签
	 * TODO
	 * @return
	 * List<Tag>
	 */
	public List<Tag> selectAllAbled(){
		return tagMapper.selectAllAbled();
	}
	/** 
	 * TODO
	 * @param id
	 * @return
	 * int 
	 */
	public int deleteById(int id) {
		return tagMapper.deleteByPrimaryKey(id);
	}
}
