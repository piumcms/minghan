package com.cloudeasy.service.news;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.bean.NewsBean;
import com.cloudeasy.dao.NewsMapper;
import com.cloudeasy.dao.NewsTypeMapper;
import com.cloudeasy.dto.news.ListNewsReqDTO;
import com.cloudeasy.dto.news.ListNewsResDTO;
import com.cloudeasy.model.News;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.BaseService;

@Service("showNewsListService")
public class ShowNewsListService extends BaseService<Result,ListNewsReqDTO> {

	@Autowired
	private NewsMapper newsMapper;
	
	@Autowired
	private NewsTypeMapper newsTypeMapper;
	
	@Override
	public Result execute(ListNewsReqDTO arg) throws Exception {
		// TODO Auto-generated method stub
		Integer rowCount = newsMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		List<News> list = newsMapper.queryByList(arg);
		List<NewsBean> beanlist = new ArrayList<NewsBean>();
		NewsBean nb;
		for (News n : list) {
			nb = new NewsBean();
			nb.setTitle(n.getTitle());
			nb.setBrief(n.getBrief());
			nb.setFlag(n.getFlag());
			nb.setIsCheck(n.getIsCheck());
			nb.setChecher(n.getChecher());
			nb.setCheckTime(n.getCheckTime());
			nb.setCreateTime(n.getCreateTime());
			nb.setCreateUser(n.getCreateUser());
			nb.setNewsAuthor(n.getNewsAuthor());
			nb.setNewsSource(n.getNewsSource());
			nb.setPicture(n.getPicture());
			nb.setNewsTypeName(newsTypeMapper.selectNameByKey(n.getNewsTypeId()));
			beanlist.add(nb);
		}
		ListNewsResDTO resDTO = new ListNewsResDTO();
		resDTO.setPager(arg.getPager());
		//resDTO.setList(beanlist);
		//resDTO.setTitle(arg.getTitle());
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}
}
