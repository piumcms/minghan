/**  
* Copyright(c)2013 Wuxi ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloudeasy.bean.TreeNode;
import com.cloudeasy.dto.user.AddRoleReqDTO;
import com.cloudeasy.dto.user.SaveAuthoritesReqDTO;
import com.cloudeasy.model.AboutArticle;
import com.cloudeasy.model.Resource;
import com.cloudeasy.model.Role;
import com.cloudeasy.result.Mess;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.AddRoleService;
import com.cloudeasy.service.DeleteRoleService;
import com.cloudeasy.service.GetRoleService;
import com.cloudeasy.service.SaveAuthoritiesService;
import com.cloudeasy.service.ShowAllRoleService;
import com.cloudeasy.service.ShowMenuItemService;

/** 
 * @Title: MenuController 
 * @Description: TODO
 * @author SEA
 * @date 2013-11-19 下午3:54:14 
 * @version V1.0   
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 3424963607488113866L;
	
	@Autowired
	private ShowAllRoleService showAllRoleService;
	
	/**
	 * 获取所有菜单项
	 */
	@Autowired
	private ShowMenuItemService showMenuItemService;
	
	@Autowired
	private SaveAuthoritiesService saveAuthoritiesService;
	
	@Autowired
	private AddRoleService addRoleService;
	
	@Autowired
	private DeleteRoleService deleteRoleService;
	
	@Autowired
	private GetRoleService getRoleService;
	
	@RequestMapping("/list.html")
	public String showAllRole(HttpServletRequest request, Model model) throws Exception {
		List<Role> list = showAllRoleService.execute(super.getUrlFlag(request));
		model.addAttribute("list", list);
		return "/user/listRole";
	}
	
	@RequestMapping("/add.html")
	public String addRole() {
		return "/user/addRole";
	}
	
	@RequestMapping("/editRole.html")
	public String getAuhorityFromRole(@RequestParam String name, HttpServletRequest request, Model model) throws Exception {
		Role r = getRoleService.execute(name);
		model.addAttribute("role", r);
		return "/user/editRole";
	}
	
	@RequestMapping("/saveRoles.html")
	public void saveRoles(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (StringUtils.isBlank(reqDto.getName())) {
			super.sendFailureMessage(response,"","1_角色对应的英文名称不能为空");
			return;
		}
		String regex = "^\\w+$"; 
		Pattern p = Pattern.compile(regex);
		Matcher mat = p.matcher(reqDto.getName());
		if (!mat.find()) {
			super.sendFailureMessage(response,"","1_角色对应的英文名称非法，请输入字母或下划线组成");
			return;
		}
		reqDto.setFlag(super.getUrlFlag(request));
		Result result = addRoleService.execute(reqDto);
		if (result.getStatus().equals("0")) {
			log.info("save role success");
			super.sendSuccessMessage(response,"","0_保存成功");
		} else {
			log.info("save role fail");
			super.sendFailureMessage(response,"","1_保存失败");
		}
	}
	
	@RequestMapping("/deleteRole.html")
	public void deleteRole(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result result = deleteRoleService.execute(reqDto);
		if (result.getStatus().equals("0")) {
			log.info("delete role success");
			super.sendSuccessMessage(response,"","删除成功");
		} else {
			log.info("delete role fail");
			super.sendFailureMessage(response,"","删除失败");
		}
	}
	
}
