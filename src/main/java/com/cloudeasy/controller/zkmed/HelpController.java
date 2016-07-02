/**  
 * 无锡优客电子商务有限公司 
 * Copyright(c)2014 Wuxi WuZhouHui Co.,Ltd. 
 * All right reserved. 
 */

package com.cloudeasy.controller.zkmed;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.controller.BaseController;
import com.cloudeasy.service.about.AboutArticleService;

/**
 * @Title: HelpController
 * @Description: TODO
 * @author cuics
 * @date 2014年9月30日 上午11:36:13
 * @version V1.0
 */
@Controller
@RequestMapping("/help")
public class HelpController extends BaseController{
    
    @Autowired
    private AboutArticleService     aboutArticleService;
    
    /**
     * 企业简介
     * @return
     * ModelAndView
     */
    @RequestMapping("/intro.html")
    public ModelAndView introduction(HttpServletRequest request){
        return null;
    }
    
    /**
     * 关于我们
     * @return
     * ModelAndView
     */
    @RequestMapping("/aboutUs.html")
    public ModelAndView aboutUs(HttpServletRequest request){
        return null;
    }
    
    /**
     * 联系我们
     * @return
     * ModelAndView
     */
    @RequestMapping("/contractUs.html")
    public ModelAndView contractUs(HttpServletRequest request){
        return null;
    }
    
    
    /**
     * 常见问题
     * @return
     * ModelAndView
     */
    @RequestMapping("/issue.html")
    public ModelAndView commonIssue(HttpServletRequest request){
        return null;
    }
    
    /**
     * 隐私规范
     * @return
     * ModelAndView
     */
    @RequestMapping("/privacy.html")
    public ModelAndView privacy(HttpServletRequest request){
        return null;
    }
    
    /**
     * 使用规范
     * @return
     * ModelAndView
     */
    @RequestMapping("/specification.html")
    public ModelAndView useSpecification(HttpServletRequest request){
        return null;
    }
    
    /**
     * 网站地图
     * @return
     * ModelAndView
     */
    @RequestMapping("/maps.html")
    public ModelAndView maps(HttpServletRequest request){
        return null;
    }
}
