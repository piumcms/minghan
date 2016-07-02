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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudeasy.bean.TreeNode;
import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dto.user.AddRoleReqDTO;
import com.cloudeasy.dto.user.SaveAuthoritesReqDTO;
import com.cloudeasy.model.Resource;
import com.cloudeasy.model.Role;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.service.AddRoleService;
import com.cloudeasy.service.DeleteRoleService;
import com.cloudeasy.service.GetRoleService;
import com.cloudeasy.service.MenuNewService;
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
@RequestMapping("/menu")
public class MenuController extends BaseController {

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
	
	@Autowired
	private MenuNewService	menuNewService;
	
	@RequestMapping("/list.html")
	public String showAllResource(HttpServletRequest request, Model model) throws Exception {
		/*List<Resource> list = showAllResourceService.execute(super.getUrlFlag(request));
		model.addAttribute("list", list);*/
		return "/menu/list";
	}
	
	@RequestMapping(value = "/search")
	@ResponseBody         
	public Object list(DataGridModel datagrid,Resource resource){
		return menuNewService.findPaginationList(datagrid,resource);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public Result create(Resource resource){
		Integer id = menuNewService.save(resource);
		return new ResultImpl();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Resource resource){
		menuNewService.update(resource);
		return new ResultImpl();
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(Integer id){
		menuNewService.delete(id);
		return new ResultImpl();
	}
	
	@RequestMapping("/add.html")
	public String addResource() {
		return "/user/addResource";
	}
	
	@RequestMapping("/showAuthorities.html")
	public String getAuhorityFromResource(@RequestParam String name, HttpServletRequest request, Model model) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("flag", super.getUrlFlag(request));
		map.put("name", name);
		Map<String, List<Resource>> resultMap = showMenuItemService.execute(map);
		
		List<Resource> list = resultMap.get("list");
		
		List<Resource> chooseList = resultMap.get("chooseList");
		
		Set<Integer> set = new HashSet<Integer>();
		for (Resource r : chooseList) {
			set.add(r.getId());
		}
		
		TreeNode treeNode = null;
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		List<TreeNode> childrenList = new ArrayList<TreeNode>();
		for (Resource r : list) {
			if (r.getParentId() == 0) {
				treeNode = new TreeNode();
				treeNode.setDataId(r.getId());
				treeNode.setText(r.getName());
				if (set.contains(r.getId())) {
					treeNode.setChecked(true);
				} else {
					treeNode.setChecked(false);
				}
				childrenList = new ArrayList<TreeNode>();
				treeNode.setChildren(childrenList);
				treeList.add(treeNode);
			} else {
				treeNode = new TreeNode();
				treeNode.setDataId(r.getId());
				treeNode.setText(r.getName());
				if (set.contains(r.getId())) {
					treeNode.setChecked(true);
				} else {
					treeNode.setChecked(false);
				}
				childrenList.add(treeNode);
			}
			
		}
		model.addAttribute("menuList", treeList);
		
		Role r = getRoleService.execute(name);
		model.addAttribute("role", r);
		return "/user/editAuthorities";
	}
	
	@RequestMapping("/assignedMenus.html")
	public String getAllMenus(@RequestParam String name,HttpServletRequest request, Model model) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("flag", super.getUrlFlag(request));
		map.put("name", name);
		Map<String, List<Resource>> resultMap = showMenuItemService.execute(map);
		
		List<Resource> list = resultMap.get("list");
		List<Resource> chooseList = resultMap.get("chooseList");
		
		Set<Integer> choosedSet = new HashSet<Integer>();//选中的列表
		for (Resource r : chooseList) {
			choosedSet.add(r.getId());
		}
		
		List<TreeNode> treeList = TreeNode.getTreeNodes(list,choosedSet);
		model.addAttribute("menuList", treeList);
		
		Role r = getRoleService.execute(name);
		model.addAttribute("role", r);
		
		return "/menu/assignedMenus";
	}
	
	@RequestMapping("/saveAuthorites.html")
	public void saveResources(@RequestBody SaveAuthoritesReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.info("start update authority...,update username:" + super.getLoginUser(request));
		Result result = saveAuthoritiesService.execute(reqDto);
		if (result.getStatus().equals("0")) {
			log.info("update authority success");
			super.sendSuccessMessage(response,"","保存成功");
		} else {
			log.info("update authority fail");
			super.sendFailureMessage(response,"","保存失败");
		}
	}
	
	@RequestMapping("/saveResources.html")
	public void saveResources(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
			log.info("save resource success");
			super.sendSuccessMessage(response,"","0_保存成功");
		} else {
			log.info("save resource fail");
			super.sendFailureMessage(response,"","1_保存失败");
		}
	}
	
	@RequestMapping("/deleteResource.html")
	public void deleteResource(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result result = deleteRoleService.execute(reqDto);
		if (result.getStatus().equals("0")) {
			log.info("delete resource success");
			super.sendSuccessMessage(response,"","删除成功");
		} else {
			log.info("delete resource fail");
			super.sendFailureMessage(response,"","删除失败");
		}
	}
	
}
