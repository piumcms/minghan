package com.cloudeasy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FooterController extends BaseController {
	
	@RequestMapping(value="/privacy.html")
	public ModelAndView basePrivacy(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("privacy");
		return mv;
	}
	
	@RequestMapping(value="/contact.html")
	public ModelAndView baseContact(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("contact");
		return mv;
	}
	
	@RequestMapping(value="/law.html")
	public ModelAndView baseLaw(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("law");
		return mv;
	}

	@RequestMapping(value="/{urlS}/privacy.html")
	public ModelAndView privacy(HttpServletRequest request,@PathVariable String urlS) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/privacy");
		return mv;
	}
	
	@RequestMapping(value="/{urlS}/contact.html")
	public ModelAndView contact(HttpServletRequest request,@PathVariable String urlS) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/contact");
		return mv;
	}
	
	@RequestMapping(value="/{urlS}/law.html")
	public ModelAndView law(HttpServletRequest request,@PathVariable String urlS) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/law");
		return mv;
	}

}
