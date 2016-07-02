/**  
* 无锡五洲国际电子商务有限公司 
* Copyright(c)2014 Wuxi WuZhouHui Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @Title: ECommerenceController 
 * @Description: TODO
 * @author cuics
 * @date 2015年1月7日 下午6:11:56 
 * @version V1.0   
 */
@Controller
@RequestMapping("ec")
public class ECommerenceController extends BaseController {
	
	@RequestMapping("/{urlS}/login.html")
	public String index(@PathVariable String urlS,HttpServletRequest request){
		return urlS+"/ec";
	}
}
