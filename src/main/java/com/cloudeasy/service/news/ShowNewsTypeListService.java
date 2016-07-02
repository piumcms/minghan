package com.cloudeasy.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudeasy.dao.NewsTypeMapper;
import com.cloudeasy.dto.news.ListNewsTypeReqDTO;
import com.cloudeasy.dto.news.ListNewsTypeResDTO;
import com.cloudeasy.model.NewsType;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("showNewsTypeListService")
public class ShowNewsTypeListService extends BaseService<Result,ListNewsTypeReqDTO> {

	@Autowired
	private NewsTypeMapper newsTypeMapper;
	
	@Override
	public Result execute(ListNewsTypeReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = newsTypeMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		List<NewsType> list = newsTypeMapper.queryByList(arg);
		ListNewsTypeResDTO resDTO = new ListNewsTypeResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		resDTO.setCategoryName(arg.getCategoryName());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}
}
