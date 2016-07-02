/**  
* Copyright(c)2013 Wuxi ll Co.,Ltd. 
* All right reserved. 
*/ 
package com.cloudeasy.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.bean.ProductNews;
import com.cloudeasy.dao.BrandVideoMapper;
import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.NewProductMapper;
import com.cloudeasy.dto.brand.ListProductNewsReqDTO;
import com.cloudeasy.dto.brand.ListProductNewsResDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Picture;
import com.cloudeasy.model.Product;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.mybatis.DynamicParameter;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.CategoryService;
import com.cloudeasy.service.ProductCategoryService;
import com.cloudeasy.service.about.AddIntroService;
import com.cloudeasy.service.about.GetElegantService;
import com.cloudeasy.service.about.GetIntroService;
import com.cloudeasy.service.about.ListElegantService;
import com.cloudeasy.service.brand.FrontBrandNewsListService;
import com.cloudeasy.service.brand.GetBrandByPkeyService;
import com.cloudeasy.service.brand.SelectAllBrandService;
import com.cloudeasy.service.brand.SelectAllBrandVideoService;
import com.cloudeasy.service.brand.SelectAllProductNewsService;
import com.cloudeasy.service.brand.SelectAllProductService;
import com.cloudeasy.service.brand.SelectAllSubBrandService;
import com.cloudeasy.service.brand.ShowBrandNewsService;
import com.cloudeasy.service.brand.ShowFrontNewsService;
import com.cloudeasy.service.brand.ShowSignalBrandNewsService;
import com.cloudeasy.service.duty.ShowWelfareService;
import com.cloudeasy.service.duty.SignalWelfareService;
import com.cloudeasy.service.innovate.AddInnovateService;
import com.cloudeasy.service.innovate.ShowInnovateService;
import com.cloudeasy.service.news.ShowDownloadedService;
import com.cloudeasy.service.news.ShowNewsService;
import com.cloudeasy.service.news.SignalNewsService;
import com.cloudeasy.service.pic.FrontMovePicService;
import com.cloudeasy.service.pic.FrontPicService;
import com.cloudeasy.service.pic.ListPicService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.Constants.BrandType;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.SessionUtils;



/**
 * 首页〉controller
 * @Title: IndexController 
 * @Description: TODO
 * @author kk
 * @date 2013-9-2 创建时间2:33:04 
 * @version V1.0
 */
@Controller
public class IndexController extends BaseController {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1171612677864509127L;
	
	@Autowired
	private GetIntroService getIntroService;
	
	@Autowired
	private ListElegantService listElegantService;
	
	@Autowired
	private SelectAllBrandService selectAllBrandService;
	
	@Autowired
	private ShowInnovateService showInnovateService;
	
	@Autowired
	private ShowNewsService showNewsService;
	
	@Autowired
	private SignalNewsService signalNewsService;
	
	@Autowired
	private ShowWelfareService ShowWelfareService;
	
	@Autowired
	private SignalWelfareService signalWelfareService;
	
	@Autowired
	private AddInnovateService addInnovateService;

	@Autowired
	private GetElegantService getElegantService;

	@Autowired
	private ShowBrandNewsService showBrandNewsService;
	
	@Autowired
	private ShowSignalBrandNewsService showSignalBrandNewsService;
	
	@Autowired
	private ShowDownloadedService showDownloadService;
	
	@Autowired
	private ListPicService listPicService;
	
	/**
	 * 根据key获取Brand
	 */
	@Autowired
	private GetBrandByPkeyService getBrandByPkeyService;
	
	/**
	 * 查询品牌列表
	 */
	@Autowired
	private SelectAllSubBrandService selectAllSubBrandService;
	
	@Autowired
	private SelectAllProductService selectAllProductService;
	
	@Autowired
	private ShowFrontNewsService showFrontNewsService;
	

	@Autowired
	private SelectAllBrandVideoService selectAllBrandVideoService;
	
	@Autowired
	private FrontPicService frontPicService;
	
	@Autowired
	private FrontBrandNewsListService frontNewsListService;
	
	@Autowired
	private FrontMovePicService frontMovePicService;
	
	@Autowired
	private NewProductMapper	newProductMapper;
	
	@Autowired
	private BrandVideoMapper 	brandVideoMapper;
	
	@Autowired
	private CategoryService		categoryService;
	
	@Autowired
	private ProductCategoryService	productCategorySerivce;

	@Autowired
	private CategoryMapper         categoryMapper;
	/**
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/index.html")
    public String defaultI(HttpServletRequest request, Model model) throws Exception {
        return "redirect:/";
    }
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/")
	public ModelAndView index(HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView(Constants.BrandType.VITZRO+"/index");
		
		initLanguage(request);
		
		//图片轮播
		Picture p = new Picture();
		p.setFlag(super.getUrlFlag(request));
		p.setBrandType(Constants.BrandType.VITZRO.toString());
		p.setLanguage(SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		List<Picture> piclist = frontPicService.execute(p);
		mv.addObject("piclist", piclist);
		
		//类别产品
		/*Map<String,Object> mp = new HashMap<String,Object>(1);
		mp.put("brandType",Constants.BrandType.VITZRO.toString());
		Map<String,List<Product>> results = productCategorySerivce.getAllCategoryProduct(mp);
		if(null!=results&&results.size()>0){
			mv.addObject("productCategory",results);
			List<Product> products = new ArrayList<Product>(6);
			for(Iterator<Entry<String,List<Product>>> iter = results.entrySet().iterator();iter.hasNext();){
				Entry<String,List<Product>> entry = iter.next();
				List<Product> prods = entry.getValue();
				if(null!=prods&&prods.size()>0){
					products.add(prods.get(0));
					if(prods.size()>=2){
						products.add(prods.get(1));
					}
				}
			}
			mv.addObject("recommended",products);
		}*/
		
		//新闻
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("brandType",BrandType.VITZRO.toString());
		map.put("limit",0);
		map.put("page", 5);
		map.put("category",BrandNews.BrandNewsType.CNEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		map.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		Map<String, Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		mv.addObject("news",newsList);
		
		//产品分类
		DynamicDBValues dy = new DynamicParameter();
		dy.put("brandType",BrandType.VITZRO.toString());
		dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		dy.put("nParentid","0");
		List<Category> categories = categoryMapper.findAllCategorys(dy);
		model.addAttribute("categories",categories);
		
		//企业简介
		AboutArticle article = new AboutArticle();
        article.setFlag(super.getUrlFlag(request));
        article.setBrandType(BrandType.VITZRO.toString());
        article.setCategory(AboutArticle.ArticleType.ABOUT_US.toString());
        article.setLanguage(SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        AboutArticle about = addIntroService.execute(article);
        if(null!=about){
            about.setContent(about.getContent());//HtmlUtil.formatHtml(
        }
        model.addAttribute("introduction", about);
        
        //产品列表
        Map<String,Object> mp = new HashMap<String,Object>(0);
        mp.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        mp.put("tableId",Constants.BrandType.VITZRO.toString());
        mp.put("pw","1");
        List<Product> results = productCategorySerivce.getProductByCondition(mp);
        mv.addObject("products", (null!=results&&results.size()>0)?results:null);
		
		return mv;
	}
	//MingHan New Material Site index
	@RequestMapping(value="/index2.html")
	public ModelAndView index2(HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView(Constants.BrandType.MINGHAN+"/index");
		
		initLanguage(request);
		
		//图片轮播
		Picture p = new Picture();
		p.setFlag(super.getUrlFlag(request));
		p.setBrandType(Constants.BrandType.VITZRO.toString());
		p.setLanguage(SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		List<Picture> piclist = frontPicService.execute(p);
		mv.addObject("piclist", piclist);
		
		//类别产品
		/*Map<String,Object> mp = new HashMap<String,Object>(1);
		mp.put("brandType",Constants.BrandType.VITZRO.toString());
		Map<String,List<Product>> results = productCategorySerivce.getAllCategoryProduct(mp);
		if(null!=results&&results.size()>0){
			mv.addObject("productCategory",results);
			List<Product> products = new ArrayList<Product>(6);
			for(Iterator<Entry<String,List<Product>>> iter = results.entrySet().iterator();iter.hasNext();){
				Entry<String,List<Product>> entry = iter.next();
				List<Product> prods = entry.getValue();
				if(null!=prods&&prods.size()>0){
					products.add(prods.get(0));
					if(prods.size()>=2){
						products.add(prods.get(1));
					}
				}
			}
			mv.addObject("recommended",products);
		}*/
		
		//新闻
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("brandType",BrandType.VITZRO.toString());
		map.put("limit",0);
		map.put("page", 5);
		map.put("category",BrandNews.BrandNewsType.CNEWS.toString());
		map.put("flag", super.getUrlFlag(request));
		map.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		Map<String, Object> resultMap = frontNewsListService.execute(map);
		List<BrandNews> newsList = (List<BrandNews>)resultMap.get("brandNewsList");
		mv.addObject("news",newsList);
		
		//产品分类
		DynamicDBValues dy = new DynamicParameter();
		dy.put("brandType",BrandType.VITZRO.toString());
		dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		dy.put("nParentid","0");
		List<Category> categories = categoryMapper.findAllCategorys(dy);
		model.addAttribute("categories",categories);
		
		//企业简介
		AboutArticle article = new AboutArticle();
        article.setFlag(super.getUrlFlag(request));
        article.setBrandType(BrandType.VITZRO.toString());
        article.setCategory(AboutArticle.ArticleType.ABOUT_US.toString());
        article.setLanguage(SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        AboutArticle about = addIntroService.execute(article);
        if(null!=about){
            about.setContent(about.getContent());//HtmlUtil.formatHtml(
        }
        model.addAttribute("introduction", about);
        
        //产品列表
        Map<String,Object> mp = new HashMap<String,Object>(0);
        mp.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        mp.put("tableId",Constants.BrandType.VITZRO.toString());
        mp.put("pw","1");
        List<Product> results = productCategorySerivce.getProductByCondition(mp);
        mv.addObject("products", (null!=results&&results.size()>0)?results:null);
		
		return mv;
	}
	
	
	
	@Autowired
	private AddIntroService addIntroService;
	
    /**
     * 会话超时
     */
    @RequestMapping(value="/timedout")
    public String timedout(HttpServletRequest request, Model model) {
        return null;
    }
    
    
	@Autowired
	private SelectAllProductNewsService selectAllProductNewsService;
	/**
	 * 全站搜索
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchAll.html")
	public ModelAndView searchAll(ListProductNewsReqDTO dto, HttpServletRequest request, Model model) throws Exception{
		ModelAndView mv = new ModelAndView("selectAll");
		dto.setTitle(request.getParameter("title"));
		Result result=selectAllProductNewsService.execute(dto);
		ListProductNewsResDTO resdto=(ListProductNewsResDTO)result.getBaseDTO();
		List<ProductNews> productList=resdto.getList();
		String regEx="<.+?>"; //表示标签 
		for (ProductNews productNews : productList) {
			Pattern p=Pattern.compile(regEx); 
	        Matcher m=null;
	        String s = null;
	        if(null!=productNews.getContent()&&productNews.getContent().length()>0){
	        	m = p.matcher(productNews.getContent()); 
	 	        s=m.replaceAll("");
	 	        productNews.setContent(s.trim().replaceAll("&nbsp;", "").toString());
	        }
	       
	        if(null!=productNews.getCategoryName()&&isNumeric(productNews.getCategoryName())){
	        	productNews.setType("1");//1新闻，2产品
	        }else{
	        	productNews.setType("2");
	        }
		}
		mv.addObject("list", resdto.getList());
		mv.addObject("title", dto.getTitle());
		mv.addObject("dto",resdto);
		return mv;
	} 
	
	private static boolean isNumeric(String str){
	  for (int i = str.length();--i>=0;){   
	   if (!Character.isDigit(str.charAt(i))){
	    return false;
	   }
	  }
	  return true;
	 }
   
}
