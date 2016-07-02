/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudeasy.controller.BaseController;
import com.cloudeasy.dto.duty.ListWelfareReqDTO;
import com.cloudeasy.dto.news.ListNewsReqDTO;
import com.cloudeasy.model.News;
import com.cloudeasy.model.Welfare;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.duty.DelWelfareService;
import com.cloudeasy.service.duty.EditWelfareService;
import com.cloudeasy.service.duty.ListWelfareService;
import com.cloudeasy.service.duty.SaveWelfareService;
import com.cloudeasy.service.news.DelNewsService;
import com.cloudeasy.service.news.EditNewsService;
import com.cloudeasy.service.news.ListNewsService;
import com.cloudeasy.service.news.SaveNewsService;

/** 
 * @Title: NewsController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-20 下午4:49:16 
 * @version V1.0   
 */
@Controller
@RequestMapping("/duty")
public class DutyController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6058815121077220120L;

	
	@Autowired
	private SaveWelfareService saveWelfareService;
	
	@Autowired
	private ListWelfareService listWelfareService;
	
	@Autowired
	private EditWelfareService editWelfareService;
	
	@Autowired
	private DelWelfareService delWelfareService;
	
	/**
	 *公益新增
	 * @param honour
	 * @param request
	 * @param model
	 * @return string
	 * @throws Exception
	 */
	@RequestMapping("/addDuty.html")
	public String addDuty( Welfare welfare, HttpServletRequest request, Model model) throws Exception {
		welfare.setFlag(super.getUrlFlag(request));
		welfare.setCreateTime(new Date());
		model.addAttribute("welfare", welfare);
		return "/duty/addDuty";
	}
	
	/**
	 *公益保存
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @return json
	 * @throws Exception
	 */
	@RequestMapping("/saveDuty.html")
	public void saveWelfare( @RequestBody Welfare welfare, HttpServletRequest request,  HttpServletResponse response, Model model) throws Exception {
		welfare.setFlag(super.getUrlFlag(request));
		if (welfare.getId() == null) {
			welfare.setCreateUser(super.getSessionUsername(request));
		}
		
		Result result = saveWelfareService.execute(welfare);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"","保存成功");
		} else {
			super.sendFailureMessage(response,"", "保存失败");
		}
	}
	
	/**
	 * 公益一蘭
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/listDuty.html")
	public String listWelfare(ListWelfareReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		dto.setFlag(super.getUrlFlag(request));
		Result result = listWelfareService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/duty/listDuty";
		
	}
	
	/**
	 * 公益编辑
	 * @param dto
	 * @param request
	 * @param model
	 * @return list
	 * @throws Exception
	 */
	@RequestMapping("/editWelfare.html")
	public String editWelfare(Welfare news, HttpServletRequest request, Model model) throws Exception {
		Welfare n = editWelfareService.execute(news);
		model.addAttribute("pageNumber", request.getParameter("pageNumber"));
		model.addAttribute("welfare", n);
		return "/duty/addDuty";
	}
	
	/**
	 * 公益删除
	 * @param honour
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/delWelfare.html")
	public void delWelfare(@RequestBody Welfare welfare, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Integer count = delWelfareService.execute(welfare);
		if (count.intValue() == 0) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
		
	}
}
