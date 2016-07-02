/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudeasy.dto.brand.ListBrandVideoReqDTO;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.brand.DelBrandVideoService;
import com.cloudeasy.service.brand.EditBrandService;
import com.cloudeasy.service.brand.ListBrandVideoService;
import com.cloudeasy.service.brand.SaveBrandVideoService;
import com.cloudeasy.service.innovate.GetQuesAnswService;

/** 
 * @Title: AboutController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午4:49:16 
 * @version V1.0   
 */
@Controller
public class BrandVideoController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6058815121077220120L;

	
	@Autowired
	private SaveBrandVideoService saveBrandVideoService;
	
	@Autowired
	private ListBrandVideoService listBrandVideoService;
	
	@Autowired
	private EditBrandService editBrandService;
	
	@Autowired
	private DelBrandVideoService delBrandVideoService;
	
	@Autowired
	private GetQuesAnswService getQuesAnswService;
	
	
	
	/**
	 * 品牌视屏新增
	 * @param honour
	 * @param request
	 * @param model
	 * @return string
	 * @throws Exception
	 */
	@RequestMapping("/video/addBrandVideo.html")
	public String addBrandVideo( BrandVideo brandVideo, HttpServletRequest request, Model model) throws Exception {
		brandVideo.setFlag(super.getUrlFlag(request));
		
		model.addAttribute("brandVideo", brandVideo);
		
		model.addAttribute("list", getQuesAnswService.execute(brandVideo.getFlag()));
		
		return "/brand/addBrandVideo";
	}
	
	/**
	 * 品牌视屏保存
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/video/saveBrandVideo.html")
	public void saveBrandVideo( @RequestBody BrandVideo brandVideo, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		brandVideo.setFlag(super.getUrlFlag(request));
		if (brandVideo.getId() == null) {
			brandVideo.setCreateUser(super.getSessionUsername(request));
		}
		
		Result result = saveBrandVideoService.execute(brandVideo);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "保存成功");
		} else {
			super.sendFailureMessage(response,"", "保存失败");
		}
	}
	
	/**
	 * 视频一蘭
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/video/listBrandVideo.html")
	public String listBrandVideo(ListBrandVideoReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		Result result = listBrandVideoService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("list", getQuesAnswService.execute(super.getUrlFlag(request)));
		
		return "/brand/listBrandVideojsp";
		
	}
	
	/**
	 * 搜索品牌新闻列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/video/{urlS}/list.html")
	public String list(@PathVariable String urlS,
			ListBrandVideoReqDTO dto, HttpServletRequest request, Model model) throws Exception{
		dto.setFlag(super.getUrlFlag(request));
		dto.setBrandType(urlS);
		String ctype = request.getParameter("category");
		dto.setCategory(ctype);
		
		Result result = listBrandVideoService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
//		model.addAttribute("list", getQuesAnswService.execute(super.getUrlFlag(request)));
		model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",ctype);
		
		return "/brand/listBrandVideojsp";
	}
	
	/**
	 * 视频编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/video/editBrandVideo.html")
	public String editElegant(BrandVideo honour, HttpServletRequest request, Model model) throws Exception {
		BrandVideo h = editBrandService.execute(honour);
		model.addAttribute("brandVideo", h);
		model.addAttribute("list", getQuesAnswService.execute(h.getFlag()));
		model.addAttribute("pageNumber", request.getParameter("pageNumber"));
		model.addAttribute("brandId", request.getParameter("brandId"));
		
		return "/brand/addBrandVideo";
	}
	
	/**
	 * 视频编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/video/{urlS}/edits.html")
	public String editElegant(@PathVariable String urlS,BrandVideo honour, HttpServletRequest request, Model model) throws Exception {
		BrandVideo video = new BrandVideo();
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			honour.setId(Integer.valueOf(id));
			video = editBrandService.execute(honour);
		}else{
			video.setBrandType(urlS);
			video.setCategory(category);
		}
		model.addAttribute("brandVideo",video);
//		model.addAttribute("list", getQuesAnswService.execute(h.getFlag()));
		model.addAttribute("pageNumber", request.getParameter("pageNumber"));
//		model.addAttribute("brandId", request.getParameter("brandId"));
		model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",category);
		return "/brand/addBrandVideo";
	}
	
	/**
	 * 视频删除
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/video/delBrandVideo.html")
	public void delBrandVideo(@RequestBody BrandVideo honour, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Integer count = delBrandVideoService.execute(honour);
		if (count.intValue() == 0) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
		
	}
}
