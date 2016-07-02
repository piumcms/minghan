/**  
* Copyright(c)2013 Wuxi ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dto.user.AddRoleReqDTO;
import com.cloudeasy.dto.user.SaveAuthoritesReqDTO;
import com.cloudeasy.model.Category;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.service.AddRoleService;
import com.cloudeasy.service.CategoryService;
import com.cloudeasy.service.DeleteRoleService;
import com.cloudeasy.service.GetRoleService;
import com.cloudeasy.service.SaveAuthoritiesService;
import com.cloudeasy.service.ShowAllRoleService;
import com.cloudeasy.service.ShowMenuItemService;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

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
	private CategoryService	categoryService;
	
	@RequestMapping("{urlS}/list.html")
	public ModelAndView showAllCategory(@PathVariable String urlS,
			HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("/category/list");
		mv.addObject("brandType",urlS);
		return mv;
	}
	
	@RequestMapping(value = "{urlS}/search")
	@ResponseBody         
	public Object list(@PathVariable String urlS,DataGridModel datagrid,Category category){
		category.setBrandType(urlS);
		return categoryService.findPaginationList(datagrid,category);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public Result create(Category category){
		Integer id = categoryService.save(category);
		return new ResultImpl();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Category category){
		categoryService.update(category);
		return new ResultImpl();
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(Integer id){
		categoryService.delete(id);
		return new ResultImpl();
	}
	
	@RequestMapping("/add.html")
	public String addCategory() {
		return "/user/addCategory";
	}
	
/*	@RequestMapping("/assignedMenus.html")
	public String getAllMenus(@RequestParam String name,HttpServletRequest request, Model model) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("flag", super.getUrlFlag(request));
		map.put("name", name);
		Map<String, List<Category>> resultMap = showMenuItemService.execute(map);
		
		List<Category> list = resultMap.get("list");
		List<Category> chooseList = resultMap.get("chooseList");
		
		Set<Integer> choosedSet = new HashSet<Integer>();//选中的列表
		for (Category r : chooseList) {
			choosedSet.add(r.getId());
		}
		
		List<TreeNode> treeList = TreeNode.getTreeNodes(list,choosedSet);
		model.addAttribute("menuList", treeList);
		
		Role r = getRoleService.execute(name);
		model.addAttribute("role", r);
		
		return "/menu/assignedMenus";
	}*/
	
	@RequestMapping("/saveAuthorites.html")
	public void saveCategorys(@RequestBody SaveAuthoritesReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
	
	@RequestMapping("/saveCategorys.html")
	public void saveCategorys(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
			log.info("save category success");
			super.sendSuccessMessage(response,"","0_保存成功");
		} else {
			log.info("save category fail");
			super.sendFailureMessage(response,"","1_保存失败");
		}
	}
	
	@RequestMapping("/deleteCategory.html")
	public void deleteCategory(@RequestBody AddRoleReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result result = deleteRoleService.execute(reqDto);
		if (result.getStatus().equals("0")) {
			log.info("delete category success");
			super.sendSuccessMessage(response,"","删除成功");
		} else {
			log.info("delete category fail");
			super.sendFailureMessage(response,"","删除失败");
		}
	}
	
}
