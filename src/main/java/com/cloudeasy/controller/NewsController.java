/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.jmesa.view.html.HtmlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.bean.NewsCommand;
import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dto.news.ListDownloadReqDTO;
import com.cloudeasy.dto.news.ListNewsReqDTO;
import com.cloudeasy.dto.news.ListReservationReqDTO;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.BrandNews.BrandNewsType;
import com.cloudeasy.model.BrandVideo.BrandVideosType;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Download;
import com.cloudeasy.model.News;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.Reservation;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.mybatis.DynamicParameter;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.brand.FrontBrandNewsListService;
import com.cloudeasy.service.brand.FrontBrandNewsService;
import com.cloudeasy.service.brand.SelectAllBrandVideoService;
import com.cloudeasy.service.news.DelDownloadService;
import com.cloudeasy.service.news.DelNewsService;
import com.cloudeasy.service.news.DelReservationService;
import com.cloudeasy.service.news.EditDownloadService;
import com.cloudeasy.service.news.EditNewsService;
import com.cloudeasy.service.news.ListDownloadService;
import com.cloudeasy.service.news.ListNewsService;
import com.cloudeasy.service.news.ListReservationService;
import com.cloudeasy.service.news.RecommendNewsService;
import com.cloudeasy.service.news.SaveDownloadService;
import com.cloudeasy.service.news.SaveNewsService;
import com.cloudeasy.service.news.SaveReservationService;
import com.cloudeasy.service.news.UpdateReservationService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.MailUtil;
import com.cloudeasy.utils.SessionUtils;
import com.cloudeasy.utils.StringUtil;
import com.cloudeasy.utils.Constants.BrandType;

/** 
 * @Title: NewsController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午4:49:16 
 * @version V1.0   
 */
@Controller
public class NewsController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6058815121077220120L;

	
	@Autowired
	private SaveNewsService saveNewsService;
	
	@Autowired
	private ListNewsService listNewsService;
	
	@Autowired
	private EditNewsService editNewsService;
	
	@Autowired
	private DelNewsService delNewsService;
	
	
	@Autowired
	private SaveDownloadService saveDownloadService;
	
	@Autowired
	private ListDownloadService listDownloadService;
	
	@Autowired
	private EditDownloadService editDownloadService;
	
	@Autowired
	private DelDownloadService delDownloadService;
	
	@Autowired
	private SaveReservationService saveReservationService;
	
	@Autowired
	private ListReservationService listReservationService;
	
	@Autowired
	private UpdateReservationService updateReservationService;
	
	@Autowired
	private DelReservationService delReservationService;
	
	@Autowired
	private RecommendNewsService recommendNewsService;
	
	@Autowired
	private FrontBrandNewsListService frontNewsListService;
	
	@Autowired
	private FrontBrandNewsService frontNewsService;
	
	@Autowired
	private SelectAllBrandVideoService selectAllBrandVideoService;
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/news.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		String indexSeq = request.getParameter("indexSeq");
		String category = request.getParameter("category");
		if(StringUtils.isEmpty(category)){
			category = BrandNewsType.NEWS.toString();
		}
		int pageSize = 10;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		
		ModelAndView mv = null;
		if(category.equals("projects")){
			mv = new ModelAndView(urlS+"/project");
			pageSize = 12;
		}else{
			mv = new ModelAndView(urlS+"/news");
		}
		
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", urlS);
		map.put("indexSeq", indexSeq);
		map.put("limit", limit);
		map.put("page", pageSize);
		map.put("category",category);
		map.put("flag", super.getUrlFlag(request));
//		map.put("signal_seq", "1");
		map.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		Map<String, Object> signalSeqMap = frontNewsListService.execute(map);
		List<BrandNews> signalSeqList = (List<BrandNews>)signalSeqMap.get("brandNewsList");
		
		if(null!=signalSeqList&&signalSeqList.size()>0){
			for(BrandNews news:signalSeqList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		
		Integer total = (Integer)signalSeqMap.get("brandNewsCount");//记录总条数
//		Integer pageAmount = (unSignalSeqCount-1)/pageSize+1;//共几页
		mv.addObject("news", signalSeqList);
		mv.addObject("total", total);
		mv.addObject("currentPage", currentPage);
		mv.addObject("category",category);
		mv.addObject("siteName", urlS);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/getBrandNewsByAjax")
	@ResponseBody
	public List<BrandNews> getBrandNews(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		String indexSeq = request.getParameter("indexSeq");
		int pageSize = 10;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", urlS);
		map.put("indexSeq", indexSeq);
		map.put("limit", limit);
		map.put("page", pageSize);
		map.put("category",BrandNewsType.NEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		map.put("signal_seq", 0);
		Map<String, Object> unSignalSeqMap = frontNewsListService.execute(map);
		List<BrandNews> unSignalSeqList = (List<BrandNews>)unSignalSeqMap.get("brandNewsList");
		System.out.println("unSignalSeqList size:"+unSignalSeqList.size());
		if(null!=unSignalSeqList&&unSignalSeqList.size()>0){
			for(BrandNews news:unSignalSeqList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		return unSignalSeqList;
	}
	

	/**
	 * 前台资讯信息详情
	 */
	@RequestMapping(value="/{urlS}/newsDetail.html")
	public ModelAndView detail(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/newsDetail");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newsId", Integer.valueOf(request.getParameter("newsId")));
		BrandNews newsDetail = frontNewsService.execute(map);
		mv.addObject("newsDetail", newsDetail);
		String category = request.getParameter("category");
		mv.addObject("category",StringUtils.isEmpty(category)?BrandNewsType.CNEWS.toString():category);
		return mv;
	}
	
	/**
	 * 前台资讯信息详情
	 */
	@RequestMapping(value="/{urlS}/videoList.html")
	public ModelAndView videos(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/videoList");
		String brandType = request.getParameter("brandType");
		if (StringUtil.isEmpty(brandType)) {
			brandType = "beibeij";
		}
		BrandVideo video = new BrandVideo();
		video.setFlag(super.getUrlFlag(request));
		video.setBrandType(urlS);
		//video.setCategory(BrandVideosType.BRAND_INDEX.toString());
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		mv.addObject("videos", list);
		return mv;
	}

	// front
	@RequestMapping(value = "/news-center-videos.html")
	public ModelAndView cheerVideoListIndex(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("news/videos");
		//String brandType = request.getParameter("brandType");
		//if (StringUtil.isEmpty(brandType)) {
		//	brandType = "beibeij";
		//}
		//BrandVideo video = new BrandVideo();
		//video.setFlag(super.getUrlFlag(request));
		//video.setBrandType(BrandType.ZKMED.toString());
		//video.setCategory(BrandVideosType.BRAND_INDEX.toString());
		//List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		//mv.addObject("videos", list);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/news-list.html")
	public ModelAndView cheerNewsList(HttpServletRequest request,Model model) throws Exception {
		String indexSeq = request.getParameter("indexSeq");
		int pageSize = 10;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", BrandType.ZKMED.toString());
		map.put("indexSeq", indexSeq);
		map.put("category",BrandNewsType.NEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		map.put("signal_seq", "1");
		map.put("language", SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		Map<String, Object> signalSeqMap = frontNewsListService.execute(map);
		List<BrandNews> signalSeqList = (List<BrandNews>)signalSeqMap.get("brandNewsList");
		map.put("limit", limit);
		map.put("page", pageSize);
		System.out.println(limit+"|"+pageSize);
		map.put("signal_seq", "0");
		Map<String, Object> unSignalSeqMap = frontNewsListService.execute(map);
		List<BrandNews> unSignalSeqList = (List<BrandNews>)unSignalSeqMap.get("brandNewsList");
		System.out.println("unSignalSeqList size:"+unSignalSeqList.size());
		
		if(null!=signalSeqList&&signalSeqList.size()>0){
			for(BrandNews news:signalSeqList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		
		if(null!=unSignalSeqList&&unSignalSeqList.size()>0){
			for(BrandNews news:unSignalSeqList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		
		Integer unSignalSeqCount = (Integer)unSignalSeqMap.get("brandNewsCount");//记录总条数
		Integer pageAmount = (unSignalSeqCount-1)/pageSize+1;//共几页
		ModelAndView mv = new ModelAndView("news/newsList");
		mv.addObject("signalSeqList", signalSeqList);
		mv.addObject("unSignalSeqList", unSignalSeqList);
		mv.addObject("newsCount", unSignalSeqCount);
		mv.addObject("pageAmount", pageAmount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("urlS", BrandType.ZKMED.toString());
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getNewsByAjax")
	@ResponseBody
	public List<BrandNews> getNews(HttpServletRequest request,DataGridModel model) throws Exception {
		String indexSeq = request.getParameter("indexSeq");
		int pageSize = 10;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", BrandType.ZKMED.toString());
		map.put("indexSeq", indexSeq);
		map.put("limit", limit);
		map.put("page", pageSize);
		map.put("category",BrandNewsType.NEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		map.put("signal_seq", 0);
		Map<String, Object> unSignalSeqMap = frontNewsListService.execute(map);
		List<BrandNews> unSignalSeqList = (List<BrandNews>)unSignalSeqMap.get("brandNewsList");
		System.out.println("unSignalSeqList size:"+unSignalSeqList.size());
		if(null!=unSignalSeqList&&unSignalSeqList.size()>0){
			for(BrandNews news:unSignalSeqList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		return unSignalSeqList;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="{siteName}/getNewsByAjax-{stype}")
	@ResponseBody
	public Map<String,Object> getNewsAjax(@PathVariable String siteName,@PathVariable String stype,
			HttpServletRequest request) throws Exception {
		int pageSize = 12;
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", siteName);
		map.put("limit", limit);
		map.put("page", pageSize);
		map.put("category",stype);
		map.put("flag", super.getUrlFlag(request));
		Map<String, Object> mp = frontNewsListService.execute(map);
		return mp;
	}
	

	/**
	 * 前台资讯信息详情
	 */
	@RequestMapping(value="/news-detail.html")
	public ModelAndView cheerNewsDetail(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("news/newsDetail");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newsId", Integer.valueOf(request.getParameter("newsId")));
		BrandNews newsDetail = frontNewsService.execute(map);
		mv.addObject("newsDetail", newsDetail);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllVideos")
	@ResponseBody
	public List<BrandVideo> allVideos(HttpServletRequest request,DataGridModel model) throws Exception {
		String brandType = request.getParameter("brandType");
		BrandVideo video = new BrandVideo();
		System.out.println("video flag:"+super.getUrlFlag(request));
		video.setFlag(super.getUrlFlag(request));
		video.setBrandType(brandType);
		video.setCategory(BrandVideosType.BRAND_INDEX.toString());
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		return list;
	}
	
	/**
	 *新闻新增
	 * @param honour
	 * @param request
	 * @param model
	 * @return string
	 * @throws Exception
	 */
	@RequestMapping("/addNews.html")
	public String addNews( News news, HttpServletRequest request, Model model) throws Exception {
		news.setFlag(super.getUrlFlag(request));
		news.setCreateTime(new Date());
		model.addAttribute("news", news);
		return "/news/addNews";
	}
	
	/**
	 *新闻保存
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/saveNews.html")
	public void saveNews( @RequestBody NewsCommand news, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		news.setFlag(super.getUrlFlag(request));
		if (news.getId() == null) {
			news.setCreateUser(super.getSessionUsername(request));
		}
		
		Result result = null;
		if (news.getNewsTypeId().intValue() == 5) {
			result = saveNewsService.execute(news);
			if (!result.getStatus().equals("0")) {
				super.sendFailureMessage(response,"","保存失败");
				return;
			}
			if (StringUtils.equals("1", news.getToMedia())) {
				news.setId(null);
				news.setNewsTypeId(6);
				result = saveNewsService.execute(news);
				if (!result.getStatus().equals("0")) {
					super.sendFailureMessage(response,"","保存失败");
					return;
				}
			}
			super.sendSuccessMessage(response,"","保存成功");	
		} else {
			result = saveNewsService.execute(news);
			if (result.getStatus().equals("0")) {
				super.sendSuccessMessage(response,"","保存成功");
			} else {
				super.sendFailureMessage(response,"", "保存失败");
			}
		}
		
	}
	
	/**
	 * 新闻一蘭
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/listNews.html")
	public String listNews(ListNewsReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		
		dto.setFlag(super.getUrlFlag(request));
		Result result = listNewsService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/news/listNews";
		
	}
	
	/**
	 * 新闻,类型
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	/*@RequestMapping("/news/{urlS}/list.html")
	public String list(@PathVariable String urlS,ListNewsReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		dto.setBrandType(urlS);
		dto.setCategory(BrandNews.BrandNewsType.NEWS.toString());
		Result result = listNewsService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/news/listNews";
	}*/
	
	/**
	 * 新闻编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/editNews.html")
	public String editElegant(News news, HttpServletRequest request, Model model) throws Exception {
		News n = editNewsService.execute(news);
		model.addAttribute("pageNumber", request.getParameter("pageNumber"));
		model.addAttribute("news", n);
		return "/news/addNews";
	}
	
	/**
	 * 新闻删除
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delNews.html")
	public void delNews(@RequestBody News news, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Integer count = delNewsService.execute(news);
		if (count.intValue() == 0) {
			super.sendSuccessMessage(response,"","删除成功");
		} else {
			super.sendFailureMessage(response,"","删除失败");
		}
	}
	
	@RequestMapping("/saveReservation.html")
	public void saveReservation( @RequestBody Reservation reservation, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		
		if(!GenericValidator.isEmail(reservation.getEmail())) {
			super.sendFailureMessage(response,"", "请正确填写邮箱!");
			return;
		}
		reservation.setFlag(super.getUrlFlag(request));
		
		reservation.setCreateUser(super.getSessionUsername(request));
		
		Result result = saveReservationService.execute(reservation);
		
		// 将其内容组织成表格形式
		HtmlBuilder htmlBuilder = new HtmlBuilder();
		htmlBuilder.table(0).style("border:1px solid").close();
		htmlBuilder.tr(1).close();
		htmlBuilder.td().close().append("姓名：").tdEnd();
		htmlBuilder.td().close().append(reservation.getFullname()).tdEnd();
		htmlBuilder.trEnd(2);
		
		htmlBuilder.tr(3).close();
		htmlBuilder.td().close().append("所在媒体：").tdEnd();
		htmlBuilder.td().close().append(reservation.getMdia()).tdEnd();
		htmlBuilder.trEnd(4);
		
		htmlBuilder.tr(5).close();
		htmlBuilder.td().close().append("职位：").tdEnd();
		htmlBuilder.td().close().append(reservation.getPostion()).tdEnd();
		htmlBuilder.trEnd(6);
		
		htmlBuilder.tr(7).close();
		htmlBuilder.td().close().append("电子邮件：").tdEnd();
		htmlBuilder.td().close().append(reservation.getEmail()).tdEnd();
		htmlBuilder.trEnd(8);
		
		htmlBuilder.tr(9).close();
		htmlBuilder.td().close().append("办公电话：").tdEnd();
		htmlBuilder.td().close().append(reservation.getTelephone()).tdEnd();
		htmlBuilder.trEnd(10);
		
		htmlBuilder.tr(11).close();
		htmlBuilder.td().close().append("手机号码：").tdEnd();
		htmlBuilder.td().close().append(reservation.getMobile()).tdEnd();
		htmlBuilder.trEnd(12);
		
		htmlBuilder.tr(13).close();
		htmlBuilder.td().close().append("选择您感兴趣的领域：").tdEnd();
		htmlBuilder.td().close().append(reservation.getInterestedArea()).tdEnd();
		htmlBuilder.trEnd(14);
		
		htmlBuilder.tr(15).close();
		htmlBuilder.td().close().append("采访提纲：").tdEnd();
		htmlBuilder.td().close().append(reservation.getOutline()).tdEnd();
		htmlBuilder.trEnd(16);
		
		htmlBuilder.tableEnd(0);
		
		
		try {
			MailUtil mailUtil = new MailUtil();
			// 开始发磅邮件
			log.info("start send email:" +mailUtil.getSentEmailAddress());
			mailUtil.setToEmailsAddress(new String[] {mailUtil.getSentEmailAddress()});
			mailUtil.setTitle("媒体会客室");
			mailUtil.setContent(htmlBuilder.toString());
			mailUtil.sendEmail();
			log.info("send email success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("falst:", e);
		}
		
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "预约成功");
		} else {
			super.sendFailureMessage(response,"", "预约失败");
		}
	}
	
	@RequestMapping("/listReservation.html")
	public String listReservation(ListReservationReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		Result result = listReservationService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/news/listReservation";
		
	}
	
	@RequestMapping("/updateReservation.html")
	public void updateReservation( @RequestBody Reservation reservation, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		reservation.setFlag(super.getUrlFlag(request));
		
		Result result = updateReservationService.execute(reservation);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "操作成功");
		} else {
			super.sendFailureMessage(response,"", "操作失败");
		}
	}
	
	@RequestMapping("/delReservation.html")
	public void delReservation( @RequestBody Reservation reservation, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		reservation.setFlag(super.getUrlFlag(request));
		
		Result result = delReservationService.execute(reservation);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "操作成功");
		} else {
			super.sendFailureMessage(response, "","操作失败");
		}
	}
	
	@RequestMapping("/recommendSeq.html")
	public void recommendSeq(@RequestBody News news, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Result result = recommendNewsService.execute(news);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "操作成功");
		} else {
			super.sendFailureMessage(response,"", "操作成功");
		}
	}
	
	@RequestMapping("/audit.html")
	public void audit(@RequestBody News news, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		news.setChecher(super.getSessionUsername(request));
		Result result = recommendNewsService.execute(news);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "操作成功");
		} else {
			super.sendFailureMessage(response,"", "操作成功");
		}
	}
}
