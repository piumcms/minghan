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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dto.news.ListDownloadReqDTO;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Download;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.brand.FrontDownloadListService;
import com.cloudeasy.service.news.DelDownloadService;
import com.cloudeasy.service.news.EditDownloadService;
import com.cloudeasy.service.news.ListDownloadService;
import com.cloudeasy.service.news.SaveDownloadService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.SessionUtils;
import com.cloudeasy.utils.StringUtil;

/** 
 * @Title: DownCenterController 
 * @Description: 下载中心控制器
 * @author cuics
 * @date 2015年1月2日 下午11:37:25 
 * @version V1.0   
 */
@Controller
@RequestMapping("downcenter")
public class DownCenterController extends BaseController {
	
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
	public String list(ListDownloadReqDTO dto, @PathVariable String urlS,HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		dto.setSiteName(urlS);
		dto.setCategory(Download.Certificate.DOWNLOAD.toString());
		Result result = listDownloadService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("siteName",urlS);
		return "/downcenter/list";
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
		return "/downcenter/edit";
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
	private 	CategoryMapper 		categoryMapper;
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/download.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		String indexSeq = request.getParameter("indexSeq");
		int pageSize = 10;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("siteName", urlS);
		map.put("indexSeq", indexSeq);
		map.put("limit", limit);
		map.put("page", pageSize);
		map.put("flag", super.getUrlFlag(request));
		map.put("category",Download.Certificate.DOWNLOAD.toString());
//		map.put("signal_seq", "1");
//		map.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		Map<String, Object> mp = frontDownloadListService.execute(map);
		
		List<Download> downloads = (List<Download>)mp.get("list");
		
		if(null!=downloads&&downloads.size()>0){
			for(Download download:downloads){
				download.setMemo(HtmlUtil.formatHtml(download.getMemo()));
			}
		}
		
		Integer total = (Integer)mp.get("count");//记录总条数
		ModelAndView mv = new ModelAndView(urlS+"/downcenter");
		mv.addObject("downloads", downloads);
		mv.addObject("total", total);
		mv.addObject("currentPage", currentPage);
		
		//All Category
        DynamicDBValues dy = baseDao.createDBValues();
        dy.put("brandType",urlS);
        dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        List<Category> list = categoryMapper.findAllCategorys(dy);
        List<Category> parents = new ArrayList<Category>(0);
        Map<Category,List<Category>> groups = new LinkedHashMap<Category,List<Category>>(0);
        if(!org.springframework.util.CollectionUtils.isEmpty(list)){
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                if(c.getParentId()==0){
                    parents.add(c);
                    groups.put(c,new ArrayList<Category>(0));
                    iter.remove();
                }
            }
            
            
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                for(Iterator<Map.Entry<Category,List<Category>>> giter = groups.entrySet().iterator();giter.hasNext();){
                    Map.Entry<Category,List<Category>> entry = giter.next();
                    Category p = entry.getKey();
                    List<Category> cs = entry.getValue();
                    if((c.getParentId()).equals(p.getId())){
                        cs.add(c);
                        iter.remove();
                    }
                }
            }
        }
        
        mv.addObject("categories", list);
        mv.addObject("f_categories",parents);//父类别集合
		return mv;
	}
}
