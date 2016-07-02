/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dto.about.AboutArticleResDTO;
import com.cloudeasy.dto.about.BatchDeleteReqDTO;
import com.cloudeasy.dto.about.ListElegantReqDTO;
import com.cloudeasy.dto.tag.TagRepDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.KeyWords;
import com.cloudeasy.model.NewsHonour;
import com.cloudeasy.model.Tag;
import com.cloudeasy.result.Mess;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.service.TagService;
import com.cloudeasy.service.about.AboutArticleService;
import com.cloudeasy.service.about.AddIntroService;
import com.cloudeasy.service.about.AddKeyWordsService;
import com.cloudeasy.service.about.BatchDeleteService;
import com.cloudeasy.service.about.DelElegantService;
import com.cloudeasy.service.about.EditElegantService;
import com.cloudeasy.service.about.ListElegantService;
import com.cloudeasy.service.about.SaveAboutIntrService;
import com.cloudeasy.service.about.SaveElegantService;
import com.cloudeasy.service.about.SaveKeyWordsService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.SessionUtils;

/** 
 * @Title: AboutController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午4:49:16 
 * @version V1.0   
 */
@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6058815121077220120L;

	@Autowired
	private AddIntroService addIntroService;
	
	@Autowired
	private SaveAboutIntrService saveAboutIntrService;
	
	@Autowired
	private AboutArticleService 	aboutArticleService;
	
	@Autowired
	private SaveElegantService saveElegantService;
	
	@Autowired
	private ListElegantService listElegantService;
	
	@Autowired
	private EditElegantService editElegantService;
	
	@Autowired
	private DelElegantService delElegantService;
	

	
	@Autowired
	private SaveKeyWordsService saveKeyWordsService;
	
	@Autowired
	private BatchDeleteService batchDeleteService;
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/about");
		AboutArticle article = new AboutArticle();
		article.setBrandType(urlS);
		List<AboutArticle> abouts = aboutArticleService.findList(article);
		mv.addObject("abouts",abouts);
		return mv;
	}
	
	//backend
	@RequestMapping("/{urlS}/intrs-{types}.html")///cheerwin/about/vewin/addIntr-1.html
	public String intrList( AboutArticleResDTO article,@PathVariable String urlS,@PathVariable String types,
			HttpServletRequest request, Model model) throws Exception {
		article.setFlag(super.getUrlFlag(request));
		article.setBrandType(urlS);
		article.setCategory(types);
		Result result = addIntroService.getPaginationLists(article);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("brandType",urlS);
		model.addAttribute("types",types);
		return "/about/intros";
	}
	
	
	@RequestMapping("/{urlS}/addIntr-{types}.html")///cheerwin/about/vewin/addIntr-1.html
	public String addIntr( AboutArticle article,@PathVariable String urlS,@PathVariable String types,
			HttpServletRequest request, Model model) throws Exception {
		article.setFlag(super.getUrlFlag(request));
		article.setBrandType(urlS);
		article.setCategory(types);
		article.setLanguage(request.getParameter("language"));
		AboutArticle about = addIntroService.execute(article);
		if (about == null) {
			about = new AboutArticle();
			about.setBrandType(urlS);
			about.setCategory(article.getCategory());
		}
		model.addAttribute("about", about);
		return "/about/addIntro";
	}
	
	@RequestMapping("/saveIntr.html")
	public void saveIntr(@RequestBody AboutArticle about, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		about.setCreateUser(super.getLoginUser(request).getUsername());
		about.setFlag(super.getUrlFlag(request));
		Result result = saveAboutIntrService.execute(about);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,about.getBrandType(), "保存成功");
		} else {
			super.sendFailureMessage(response,about.getBrandType(), "保存失败");
		}
		
	}
	
	/**
	 * 集团风采新增
	 * @param honour
	 * @param request
	 * @param model
	 * @return string
	 * @throws Exception
	 */
	@RequestMapping("/addElegant.html")
	public String addHonour( NewsHonour honour, HttpServletRequest request, Model model) throws Exception {
		honour.setFlag(super.getUrlFlag(request));
		
		model.addAttribute("honour", honour);
		
		if (honour.getNewsTypeId().intValue() == 1) {
			return "/about/addElegant";
		}
		return "/about/addDevelopment";
	}
	
	/**
	 * 集团风采保存
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/saveElegant.html")
	public void saveElegant( @RequestBody NewsHonour honour, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		honour.setFlag(super.getUrlFlag(request));
		if (honour.getId() == null) {
			honour.setCreateUser(super.getSessionUsername(request));
		}
		
		Result result = saveElegantService.execute(honour);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "保存成功");
		} else {
			super.sendFailureMessage(response,"", "保存失败");
		}
	}
	
	/**
	 * 集團風采一蘭
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/listElegant.html")
	public String listElegant(ListElegantReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		Result result = listElegantService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		if (dto.getNewsTypeId().intValue() == 1) {
			return "/about/listElegant";
		}
		return "/about/listDevelopment";
		
	}
	
	/**
	 * 集團風采编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/editElegant.html")
	public String editElegant(NewsHonour honour, HttpServletRequest request, Model model) throws Exception {
		NewsHonour h = editElegantService.execute(honour);
		model.addAttribute("pageNumber", request.getParameter("pageNumber"));
		model.addAttribute("honour", h);
		if (h.getNewsTypeId().intValue() == 1) {
			return "/about/addElegant";
		}
		return "/about/addDevelopment";
	}
	
	/**
	 * 集團風采删除
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delElegant.html")
	public void delElegant(@RequestBody NewsHonour honour, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Integer count = delElegantService.execute(honour);
		if (count.intValue() == 0) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
		
	}
	
	
	@RequestMapping(value="/batchDelete.html")
	public void batchDelete(@RequestBody BatchDeleteReqDTO dto, HttpServletRequest req, HttpServletResponse response) throws Exception {
		Result result = new ResultImpl();
		if (StringUtils.isBlank(dto.getIds())) {
			Mess mess = new Mess();
			mess.setMessage("请选择删除记录");
			result.setMessList(mess);
		}
		if (StringUtils.isBlank(dto.getTableName())) {
			Mess mess = new Mess();
			mess.setMessage("请注明删除表名");
			result.setMessList(mess);
		}
		
		String regex = "^\\w+$"; 
		Pattern p = Pattern.compile(regex);
		Matcher mat = p.matcher(dto.getTableName());
		if (!mat.find()) {
			Mess mess = new Mess();
			mess.setMessage("表名不合法");
			result.setMessList(mess);
		}
		int count = batchDeleteService.execute(dto);
		if (count == 0) {
			Mess mess = new Mess();
			mess.setMessage("删除失败");
			result.setMessList(mess);
		}
		HtmlUtil.writerJson(response, result);
	}
}
