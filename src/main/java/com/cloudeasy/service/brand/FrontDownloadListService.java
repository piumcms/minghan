package com.cloudeasy.service.brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.BrandNewsMapper;
import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.Download;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.BaseService;

@Service("frontDownloadListService")
public class FrontDownloadListService extends BaseService<Map<String, Object>, Map<String, Object>> {

	@Autowired
	private BrandNewsMapper newsMapper;
	
	@Autowired
	private DownloadMapper downloadMapper;
	
	
	@Override
	public Map<String, Object> execute(Map<String, Object> arg) throws Exception {
		// TODO Auto-generated method stub
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("limit", arg.get("limit"));
		dy.put("page", arg.get("page"));
		dy.put("flag", arg.get("flag"));
		dy.put("siteName", arg.get("siteName"));
		dy.put("indexSeq",arg.get("indexSeq"));
		dy.put("category",arg.get("category"));
		Integer count = downloadMapper.queryCountByCondition(dy);
		List<Download> list = downloadMapper.queryListByCondition(dy);
		Map<String, Object> resultMap = new HashMap(2);
		resultMap.put("list", list);
		resultMap.put("count", count);
		return resultMap;
	}
}
