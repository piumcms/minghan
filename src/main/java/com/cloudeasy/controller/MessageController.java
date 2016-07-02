package com.cloudeasy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {
	
	@RequestMapping(value="/list.html")
	public ModelAndView index(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("message/list");
		return mv;
	}
	
	@RequestMapping(value="/info.html")
	public ModelAndView detail(HttpServletRequest request,Model model) throws Exception {
		ModelAndView mv = new ModelAndView("message/info");
		return mv;
	}
}
