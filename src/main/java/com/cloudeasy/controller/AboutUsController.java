/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.model.BrandVideo.BrandVideosType;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.about.AboutArticleService;
import com.cloudeasy.service.about.AddIntroService;
import com.cloudeasy.service.brand.SelectAllBrandNewsService;
import com.cloudeasy.service.brand.SelectAllBrandVideoService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.Constants.BrandType;
import com.cloudeasy.utils.SessionUtils;


@Controller
public class AboutUsController extends BaseController {

	private static final long serialVersionUID = 6058815121077220120L;

	@Autowired
	private AboutArticleService 	aboutArticleService;
	

	@Autowired
	private AddIntroService addIntroService;
	
	
	@Autowired
	private SelectAllBrandNewsService selectAllBrandNewsService;
	
	@Autowired
	private SelectAllBrandVideoService selectAllBrandVideoService;
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/about.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/about");
		AboutArticle article = new AboutArticle();
		article.setBrandType(urlS);
		List<AboutArticle> abouts = aboutArticleService.findList(article);
		mv.addObject("tabTag",request.getParameter("tag"));
		mv.addObject("abouts",abouts);
		
		if(urlS.equals(Constants.BrandType.BEIBEIJ.toString())){//贝贝健
			ListBrandNewsReqDTO dto = new ListBrandNewsReqDTO();
			dto.setBrandType(urlS);
			/*String ctype = request.getParameter("category");
			dto.setCategory(ctype);*/
			Result result=selectAllBrandNewsService.execute(dto);
			mv.addObject("aboutsList",result.getBaseDTO());
			
			BrandVideo video = new BrandVideo();
			video.setFlag(super.getUrlFlag(request));
			video.setBrandType(urlS);
			video.setCategory(BrandVideosType.BRAND_TVC.toString());
			List<BrandVideo> list = selectAllBrandVideoService.execute(video);
			mv.addObject("tvcVideo", list!=null&&list.size()>0?list.get(0):null);
		}else if(urlS.equals(Constants.BrandType.SUPERB.toString())){//超威
			BrandVideo video = new BrandVideo();
			video.setFlag(super.getUrlFlag(request));
			video.setBrandType(urlS);
			video.setCategory(BrandVideosType.BRAND_INDEX.toString());
			List<BrandVideo> list = selectAllBrandVideoService.execute(video);
			mv.addObject("videos", list);
		}
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/about.html")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("about");
		AboutArticle article = new AboutArticle();
		
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	//front
	@RequestMapping(value="/{urlS}/about-{types}.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,
			@PathVariable String types,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/about/"+types);
		AboutArticle article = new AboutArticle();
		article.setFlag(super.getUrlFlag(request));
		article.setBrandType(urlS);
		article.setCategory(types);
		article.setLanguage(SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		AboutArticle about = addIntroService.execute(article);
		model.addAttribute("about", about);
		return mv;
	}
}
