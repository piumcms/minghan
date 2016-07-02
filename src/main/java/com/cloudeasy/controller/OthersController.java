/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Picture;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.BrandNews.BrandNewsType;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.service.ProductCategoryService;
import com.cloudeasy.service.about.AddIntroService;
import com.cloudeasy.service.brand.FrontBrandNewsListService;
import com.cloudeasy.service.brand.FrontBrandNewsService;
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
import com.cloudeasy.service.pic.FrontPicService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.StringUtil;
import com.cloudeasy.utils.Constants.BrandType;

/** 
 * 其他不同类别信息
 */
@Controller
public class OthersController extends BaseController {

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
	
	/**
	 * 新闻资讯中心
	 */
	@RequestMapping(value="/consultingCenter.html")
	public ModelAndView consultingCenter(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("consultingCenter");
		int offset = 10;
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*offset;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", BrandType.CMCCSOFT.toString());
		map.put("limit", limit);
		map.put("page", offset);
		map.put("category",BrandNewsType.NEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		Map<String, Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		if(null!=newsList&&newsList.size()>0){
			for(BrandNews news:newsList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
		Integer pageAmount = (newsCount-1)/offset+1;//共几页
		mv.addObject("newsList", newsList);
		mv.addObject("newsCount", newsCount);
		mv.addObject("pageAmount", pageAmount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("urlS", BrandType.CMCCSOFT.toString());
		return mv;
	}
	
	@Autowired
	private FrontPicService frontPicService;
	/**
	 * 详情
	 */
	@RequestMapping(value="/details.html")
	public ModelAndView consultingDetail(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("details");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newsId", Integer.valueOf(request.getParameter("id")));
		BrandNews newsDetail = frontNewsService.execute(map);
		mv.addObject("details", newsDetail);
		
		
		map = new HashMap<String, Object>(5);
		map.put("brandType",BrandType.CMCCSOFT.toString());
		map.put("limit",0);
		map.put("page", 3);
		map.put("category",BrandNews.BrandNewsType.NEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		Map<String,Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		mv.addObject("hotNews",newsList);
		
		
		//图片轮播
		Picture p = new Picture();
		p.setFlag(super.getUrlFlag(request));
		p.setBrandType(Constants.BrandType.CMCCSOFT.toString());
		List<Picture> piclist = frontPicService.execute(p);
		mv.addObject("piclist", piclist);
		
		return mv;
	}
	
	@Autowired
	private ProductCategoryService	productCategorySerivce;
	
	
	@Autowired
	protected 	BaseDao 			baseDao;
	
	@Autowired
	private 	CategoryMapper		categoryMapper;
	
	@Autowired
	private     ProductMapper  		productMapper;
	//方案超市
	@RequestMapping(value="/supermarketPlan.html")
	public ModelAndView supermarketPlan(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("supermarketPlan");
		
		//All Category
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("brandType",Constants.BrandType.CMCCSOFT.toString());
		List<Category> list = categoryMapper.findAllCategorys(dy);
		Category cate = new Category();
		cate.setName("方案超市");
		list.add(0, cate);
		mv.addObject("categories", list);
		
		Map<String,Object> mp = new HashMap<String,Object>(1);
		if(null!=request.getParameter("id")&&request.getParameter("id").length()>0){
			mp.put("categoryId", request.getParameter("id"));
		}
		mp.put("tableId",Constants.BrandType.CMCCSOFT.toString());
		List<Product> results = productCategorySerivce.getProductByCondition(mp);
		if(null!=results&&results.size()>0){
			for(Product product:results){
				product.setShortDesc(HtmlUtil.formatHtml(product.getShortDesc()));
			}
		}
		mv.addObject("products", (null!=results&&results.size()>0)?results:null);
		return mv;
	}
	
	//方案超市
	@RequestMapping(value="/productDetail.html")
	public ModelAndView supermarketDetails(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("productDetail");
		
		if(null!=request.getParameter("id")&&request.getParameter("id").length()>0){
			Product product = productMapper.selectByPrimaryKey(Integer.valueOf(request.getParameter("id")));
			mv.addObject("product",product);
		}
		
		return mv;
	}
	
	   //方案超市
    @RequestMapping(value="/successStories.html")
    public ModelAndView successStories(HttpServletRequest request,Model model) throws Exception {
        ModelAndView mv = new ModelAndView("successStories");
        int offset = 10;
        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
        Integer limit = (currentPage-1)*offset;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("brandType", BrandType.CMCCSOFT.toString());
        map.put("limit", limit);
        map.put("page", offset);
//        map.put("category",BrandNewsType.SUCCESS_STORIES.toString());
        map.put("flag", super.getUrlFlag(request));
        Map<String, Object> resultMap = frontNewsListService.execute(map);
        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
        if(null!=newsList&&newsList.size()>0){
            for(BrandNews news:newsList){
                news.setContent(HtmlUtil.formatHtml(news.getContent()));
            }
        }
        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
        Integer pageAmount = (newsCount-1)/offset+1;//共几页
        mv.addObject("newsList", newsList);
        mv.addObject("newsCount", newsCount);
        mv.addObject("pageAmount", pageAmount);
        mv.addObject("currentPage", currentPage);
        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
        return mv;
    }
	
	@RequestMapping(value="/entreDynamics.html")
	public ModelAndView entreDynamics(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("entreDynamics");
		int offset = 10;
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*offset;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", BrandType.CMCCSOFT.toString());
		map.put("limit", limit);
		map.put("page", offset);
//		map.put("category",BrandNewsType.ENTRE_DYNAMICS.toString());
		map.put("flag", super.getUrlFlag(request));
		Map<String, Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		if(null!=newsList&&newsList.size()>0){
			for(BrandNews news:newsList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}
		Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
		Integer pageAmount = (newsCount-1)/offset+1;//共几页
		mv.addObject("newsList", newsList);
		mv.addObject("newsCount", newsCount);
		mv.addObject("pageAmount", pageAmount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("urlS", BrandType.CMCCSOFT.toString());
		return mv;
	}
	
	@RequestMapping(value="/entreClass.html")
    public ModelAndView entreClass(HttpServletRequest request,Model model) throws Exception {
        ModelAndView mv = new ModelAndView("entreClass");
        int offset = 10;
        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
        Integer limit = (currentPage-1)*offset;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("brandType", BrandType.CMCCSOFT.toString());
        map.put("limit", limit);
        map.put("page", offset);
//        map.put("category",BrandNewsType.ENTRE_CLASS.toString());
        map.put("flag", super.getUrlFlag(request));
        Map<String, Object> resultMap = frontNewsListService.execute(map);
        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
        if(null!=newsList&&newsList.size()>0){
            for(BrandNews news:newsList){
                news.setContent(HtmlUtil.formatHtml(news.getContent()));
            }
        }
        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
        Integer pageAmount = (newsCount-1)/offset+1;//共几页
        mv.addObject("newsList", newsList);
        mv.addObject("newsCount", newsCount);
        mv.addObject("pageAmount", pageAmount);
        mv.addObject("currentPage", currentPage);
        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
        return mv;
    }
	
	   @RequestMapping(value="/pioneeringFigures.html")
	    public ModelAndView pioneeringFigures(HttpServletRequest request,Model model) throws Exception {
	        ModelAndView mv = new ModelAndView("pioneeringFigures");
	        int offset = 10;
	        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
	        Integer limit = (currentPage-1)*offset;
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("brandType", BrandType.CMCCSOFT.toString());
	        map.put("limit", limit);
	        map.put("page", offset);
//	        map.put("category",BrandNewsType.PIONEERING_FIGURES.toString());
	        map.put("flag", super.getUrlFlag(request));
	        Map<String, Object> resultMap = frontNewsListService.execute(map);
	        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
	        if(null!=newsList&&newsList.size()>0){
	            for(BrandNews news:newsList){
	                news.setContent(HtmlUtil.formatHtml(news.getContent()));
	            }
	        }
	        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
	        Integer pageAmount = (newsCount-1)/offset+1;//共几页
	        mv.addObject("newsList", newsList);
	        mv.addObject("newsCount", newsCount);
	        mv.addObject("pageAmount", pageAmount);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
	        return mv;
	    }
	   
	    @RequestMapping(value="/entreStory.html")
	    public ModelAndView entreStory(HttpServletRequest request,Model model) throws Exception {
	        ModelAndView mv = new ModelAndView("entreStory");
	        int offset = 10;
	        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
	        Integer limit = (currentPage-1)*offset;
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("brandType", BrandType.CMCCSOFT.toString());
	        map.put("limit", limit);
	        map.put("page", offset);
//	        map.put("category",BrandNewsType.ENTRE_STORY.toString());
	        map.put("flag", super.getUrlFlag(request));
	        Map<String, Object> resultMap = frontNewsListService.execute(map);
	        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
	        if(null!=newsList&&newsList.size()>0){
	            for(BrandNews news:newsList){
	                news.setContent(HtmlUtil.formatHtml(news.getContent()));
	            }
	        }
	        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
	        Integer pageAmount = (newsCount-1)/offset+1;//共几页
	        mv.addObject("newsList", newsList);
	        mv.addObject("newsCount", newsCount);
	        mv.addObject("pageAmount", pageAmount);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
	        return mv;
	    }
	    
	    @RequestMapping(value="/theResults.html")
	    public ModelAndView theResults(HttpServletRequest request,Model model) throws Exception {
	        ModelAndView mv = new ModelAndView("theResults");
	        int offset = 10;
	        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
	        Integer limit = (currentPage-1)*offset;
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("brandType", BrandType.CMCCSOFT.toString());
	        map.put("limit", limit);
	        map.put("page", offset);
//	        map.put("category",BrandNewsType.THE_RESULTS.toString());
	        map.put("flag", super.getUrlFlag(request));
	        Map<String, Object> resultMap = frontNewsListService.execute(map);
	        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
	        if(null!=newsList&&newsList.size()>0){
	            for(BrandNews news:newsList){
	                news.setContent(HtmlUtil.formatHtml(news.getContent()));
	            }
	        }
	        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
	        Integer pageAmount = (newsCount-1)/offset+1;//共几页
	        mv.addObject("newsList", newsList);
	        mv.addObject("newsCount", newsCount);
	        mv.addObject("pageAmount", pageAmount);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
	        return mv;
	    }
	    
	    @RequestMapping(value="/galaxyMasters.html")
	    public ModelAndView galaxyMasters(HttpServletRequest request,Model model) throws Exception {
	        ModelAndView mv = new ModelAndView("galaxyMasters");
	        int offset = 10;
	        Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
	        Integer limit = (currentPage-1)*offset;
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("brandType", BrandType.CMCCSOFT.toString());
	        map.put("limit", limit);
	        map.put("page", offset);
//	        map.put("category",BrandNewsType.GALAXY_MASTERS.toString());
	        map.put("flag", super.getUrlFlag(request));
	        Map<String, Object> resultMap = frontNewsListService.execute(map);
	        List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
	        if(null!=newsList&&newsList.size()>0){
	            for(BrandNews news:newsList){
	                news.setContent(HtmlUtil.formatHtml(news.getContent()));
	            }
	        }
	        Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
	        Integer pageAmount = (newsCount-1)/offset+1;//共几页
	        mv.addObject("newsList", newsList);
	        mv.addObject("newsCount", newsCount);
	        mv.addObject("pageAmount", pageAmount);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("urlS", BrandType.CMCCSOFT.toString());
	        return mv;
	    }
	
	@RequestMapping(value="/support-{supportType}.html")
	public ModelAndView support(HttpServletRequest request,@PathVariable String supportType,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("support");
		int offset = 10;
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		Integer limit = (currentPage-1)*offset;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", BrandType.CMCCSOFT.toString());
		map.put("limit", limit);
		map.put("page", offset);
		map.put("category",supportType);
		map.put("flag", super.getUrlFlag(request));
		Map<String, Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		/*if(null!=newsList&&newsList.size()>0){
			for(BrandNews news:newsList){
				news.setContent(HtmlUtil.formatHtml(news.getContent()));
			}
		}*/
		Integer newsCount = (Integer)resultMap.get("brandNewsCount");//记录总条数
		Integer pageAmount = (newsCount-1)/offset+1;//共几页
		mv.addObject("newsList", newsList);
		mv.addObject("newsCount", newsCount);
		mv.addObject("pageAmount", pageAmount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("supportType",supportType);
		return mv;
	}
	
	
	/**
	 * 详情
	 */
	@RequestMapping(value="/supportDetails-{supportType}.html")
	public ModelAndView supportDetail(HttpServletRequest request,@PathVariable String supportType,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("supportDetails");
		
		
		if(!supportType.equals(AboutArticle.ArticleType.CONTACT_US.toString())){

			Map<String, Object> map = new HashMap<String, Object>(1);
			map.put("newsId", Integer.valueOf(request.getParameter("id")));
			BrandNews newsDetail = frontNewsService.execute(map);
			mv.addObject("details", newsDetail);
			
		}else{
			
			AboutArticle article = new AboutArticle();
			article.setFlag(super.getUrlFlag(request));
			article.setBrandType(BrandType.CMCCSOFT.toString());
			article.setCategory(supportType);
			AboutArticle about = addIntroService.execute(article);
			model.addAttribute("details", about);
			
		}
		mv.addObject("supportType",supportType);
		return mv;
	}
	

	@Autowired
	private AddIntroService addIntroService;
}
