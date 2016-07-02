/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudeasy.dto.pic.ListPicReqDTO;
import com.cloudeasy.model.MovePicture;
import com.cloudeasy.model.Picture;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.about.SavePictureService;
import com.cloudeasy.service.pic.EditMovePictureService;
import com.cloudeasy.service.pic.EditPicService;
import com.cloudeasy.service.pic.ListPicService;
import com.cloudeasy.service.pic.SaveMovePictureService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.SessionUtils;

/** 
 * @Title: PictureController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午4:49:16 
 * @version V1.0   
 */
@Controller
@RequestMapping("/pic")
public class PictureController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6058815121077220120L;

	
	@Autowired
	private SavePictureService savePictureService;
	
	@Autowired
	private ListPicService listPicService;
	
	@Autowired
	private EditPicService editPicService;
	
	@Autowired
	private SaveMovePictureService saveMovePictureService;
	
	
	@Autowired
	private EditMovePictureService editMovePictureService;
	
	/**
	 * 首页图片保存
	 * @param pic
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/saveMovPic.html")
	public void saveMovPic( @RequestBody MovePicture pic, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		pic.setFlag(super.getUrlFlag(request));
		/*if (pic.getId() == null) {
			pic.setCreateUser(super.getSessionUsername(request));
		}
		*/
		Result result = saveMovePictureService.execute(pic);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,result.getBrandType(),"保存成功");
		} else {
			super.sendFailureMessage(response,result.getBrandType(),"保存失败");
		}
	}
	
	/**
	 * 首页图片保存
	 * @param pic
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/savePic.html")
	public void savePic( @RequestBody Picture pic, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		pic.setFlag(super.getUrlFlag(request));
		/*if (pic.getId() == null) {
			pic.setCreateUser(super.getSessionUsername(request));
		}
		*/
		Result result = savePictureService.execute(pic);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,result.getBrandType(),"保存成功");
		} else {
			super.sendFailureMessage(response,result.getBrandType(),"保存失败");
		}
	}
	
	/**
	 * 首页图片保存
	 * @param pic
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/delPic.html")
	public void deletePic( @RequestBody Picture pic, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		pic.setFlag(super.getUrlFlag(request));
		/*if (pic.getId() == null) {
			pic.setCreateUser(super.getSessionUsername(request));
		}
		*/
		Result result = savePictureService.execute(pic);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,result.getBrandType(),"保存成功");
		} else {
			super.sendFailureMessage(response,result.getBrandType(),"保存失败");
		}
	}
	
	/**
	 * 图片集一蘭
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/listPic.html")
	public String listPic(ListPicReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		Result result = listPicService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/pic/listPic";
	}
	
	@RequestMapping(value="/{urlS}/listPic.html")
	public String listKvPic(ListPicReqDTO dto,HttpServletRequest request,
			@PathVariable String urlS,Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		dto.setBrandType(urlS);
//		dto.setLanguage(SessionUtils.getAttrStr(request, Constants.SELECT_LANGUAGE));
		Result result = listPicService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("brandType",urlS);
		return "/pic/listPic";
	}
	
	/**
	 * 图片编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/editMovePic.html")
	public String editElegant(MovePicture honour, HttpServletRequest request, Model model) throws Exception {
		MovePicture h = editMovePictureService.execute(honour);
		model.addAttribute("picture", h);
		return "/pic/addMovePicture";
	}
	
	/**
	 * 图片编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/editPic.html")
	public String editPic(Picture pic, HttpServletRequest request, Model model) throws Exception {
		Picture h = editPicService.execute(pic);
		model.addAttribute("picture", h);
		return "/pic/addPicture";
	}
}
