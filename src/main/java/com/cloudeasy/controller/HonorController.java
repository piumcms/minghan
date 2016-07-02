/**  
* 无锡五洲国际电子商务有限公司 
* Copyright(c)2014 Wuxi WuZhouHui Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.DownloadMapper;
import com.cloudeasy.dto.news.ListDownloadReqDTO;
import com.cloudeasy.model.Download;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.brand.FrontDownloadListService;
import com.cloudeasy.service.news.DelDownloadService;
import com.cloudeasy.service.news.EditDownloadService;
import com.cloudeasy.service.news.ListDownloadService;
import com.cloudeasy.service.news.SaveDownloadService;
import com.cloudeasy.utils.HtmlUtil;

/** 
 * @Title: HonorController 
 * @Description: 企业荣誉控制器
 * @author cuics
 * @date 2015年1月2日 下午11:37:25 
 * @version V1.0   
 */
@Controller
@RequestMapping("honor")
public class HonorController extends BaseController {
	
	@Autowired
	private SaveDownloadService saveDownloadService;
	
	@Autowired
	private ListDownloadService listDownloadService;
	
	@Autowired
	private EditDownloadService editDownloadService;
	
	@Autowired
	private DelDownloadService delDownloadService;
	
	@Autowired
	private FrontDownloadListService frontDownloadListService;

	/**
	 * 下载列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/{urlS}/list.html")
	public String list(ListDownloadReqDTO dto, @PathVariable String urlS,
			HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		dto.setSiteName(urlS);
		dto.setCategorys(new ArrayList<String>(0));
		dto.getCategorys().add(Download.Certificate.PATENT.toString());
		dto.getCategorys().add(Download.Certificate.AUTHENTICATION.toString());
		dto.getCategorys().add(Download.Certificate.COLLECT.toString());
		dto.getCategorys().add(Download.Certificate.HIGH_QUALITY.toString());
		dto.getCategorys().add(Download.Certificate.C3.toString());
		Result result = listDownloadService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("siteName",urlS);
		return "/honor/list";
	}
	
	/**
	 * 显示品牌编辑页面
	 * @param brand
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{urlS}/showEditDownCenter.html")
	public String showEditProduct(@PathVariable String urlS,HttpServletRequest request, 
			HttpServletResponse response, Model model) throws Exception {
		String did = request.getParameter("id");
		Download download = new Download();
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		String title = request.getParameter("title");
		if(StringUtils.isNotBlank(title)){
			title = URLDecoder.decode(title, "UTF-8");
		}
		model.addAttribute("title", title);
		if(StringUtils.isNotBlank(did)){
			Integer id=Integer.valueOf(did);
			download.setId(id);
			download = editDownloadService.execute(download);
		}else{
			download.setSiteName(urlS);
		}
		model.addAttribute("download",download);
		return "/honor/edit";
	}
	
	@RequestMapping("/addDownload.html")
	public String addDownload( Download download, HttpServletRequest request, Model model) throws Exception {
		download.setFlag(super.getUrlFlag(request));
		model.addAttribute("download", download);
		return "/news/addDownload";
	}
	
	
	@RequestMapping("/saveDownload.html")
	public void saveDownload( @RequestBody Download download, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		download.setFlag(super.getUrlFlag(request));
		if (download.getId() == null) {
			download.setCreateUser(super.getSessionUsername(request));
		}
		
		Result result = saveDownloadService.execute(download);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"","保存成功");
		} else {
			super.sendFailureMessage(response,"","保存失败");
		}
	}
	
	/**
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
/*	@RequestMapping("/editDownload.html")
	public String editDownload(Download download, HttpServletRequest request, Model model) throws Exception {
		Download h = editDownloadService.execute(download);
		model.addAttribute("download", h);
		return "/news/addDownload";
	}*/
	
	/**
	 * @param download
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delDownload.html")
	public void delElegant(@RequestBody Download download, 
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Integer count = delDownloadService.execute(download);
		if (count.intValue() == 1) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response, "","删除失败");
		}
	}
	
	
	@Autowired
	protected 	BaseDao 			baseDao;
	@Autowired
	private 	DownloadMapper		downloadMapper;//queryForList	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/honors.html")
	public ModelAndView honors(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ListDownloadReqDTO dto = new ListDownloadReqDTO();
		dto.setFlag(super.getUrlFlag(request));
		dto.setSiteName(urlS);
		dto.setCategorys(new ArrayList<String>(0));
		dto.getCategorys().add(Download.Certificate.PATENT.toString());
		dto.getCategorys().add(Download.Certificate.AUTHENTICATION.toString());
		dto.getCategorys().add(Download.Certificate.COLLECT.toString());
		dto.getCategorys().add(Download.Certificate.HIGH_QUALITY.toString());
		dto.getCategorys().add(Download.Certificate.C3.toString());
		dto.setRows(50);
		List<Download> list = downloadMapper.queryForList(dto);
		Map<String,List<Download>> honors = new LinkedHashMap<String,List<Download>>(0);
		if(null!=list&&list.size()>0){
			for(Download download:list){
				String key = download.getCategory();
				if(!honors.containsKey(key)){
					honors.put(key, new ArrayList<Download>(0));
				}
				List<Download> sub = honors.get(key);
				sub.add(download);
			}
		}
		
		model.addAttribute("siteName",urlS);
		
		ModelAndView mv = new ModelAndView(urlS+"/honor");
		
		mv.addObject("honors", honors);
		return mv;
	}
}
