/**
* @class: TagController.java
* @title:
* @Description: 
* @Copyright: Copyright (c) 2015
* @Company: 无锡飙码技术有限公司
* @author wayne
* @date 2016年6月28日
* @version 1.0
*/
package com.cloudeasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudeasy.common.Constant;
import com.cloudeasy.dto.tag.TagRepDTO;
import com.cloudeasy.model.Tag;
import com.cloudeasy.model.TagRelation;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.TagRelationService;
import com.cloudeasy.service.TagService;

/**
 * @class: TagController.java
 * @title:
 * @Description: 
 * @Copyright: Copyright (c) 2015
 * @Company: 无锡飙码技术有限公司
 * @author wayne
 * @date 2016年6月28日
 * @version 1.0
 */
@Controller
@RequestMapping("/tag")
public class TagController extends BaseController {

	/** serialVersionUID*/
	private static final long serialVersionUID = -4300931612694500859L;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private TagRelationService tagRelationService;
	
	@RequestMapping("/tag.html")
	public String listPage(TagRepDTO dto, HttpServletRequest request, Model model) throws Exception {
		Result result= tagService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/tag/taglist";
	}
	@RequestMapping("/addTag.html")
	public String addTagPage(Tag tag, HttpServletRequest request, Model model) throws Exception {
		//Result result= tagService.execute(dto);
		model.addAttribute("tag", tag);
		return "/tag/addTag";
	}
	
	@RequestMapping("/aditTag.html")
	public String editTagPage(HttpServletRequest request,Model model){
		int id=Integer.parseInt(request.getParameter("id").toString());
		Tag tag=tagService.selectById(id);
		model.addAttribute("tag", tag);
		return "/tag/addTag";
	}
	
	@RequestMapping("/saveTag.html")
	public void saveKeyWords(@RequestBody Tag tag, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		tag.setFlag(super.getUrlFlag(request));
		Result result = tagService.executeInsertOrUpdate(tag);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "保存成功");
		} else {
			super.sendFailureMessage(response, "","保存失败");
		}
	}
	@RequestMapping("/remove.html")
	public void removeTag(@RequestBody Tag tag, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=tag.getId();
		int i=tagService.deleteById(id);		
		if (i>0) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
	
	@RequestMapping("/getTagData")
	@ResponseBody
	public Map getTagData(HttpServletRequest request){
		String productId=request.getParameter("productId");
		String type=request.getParameter("type");
		Map result=new HashMap<String, Object>();
		Map params=new HashMap(1);
		params.put("type",type);
		params.put("relationId", productId);
		List<TagRelation> tagRelations= tagRelationService.queryByList(params);
		if(!CollectionUtils.isEmpty(tagRelations)){
			result.put("tagRelations", tagRelations);
		}
		List<Tag> tags=tagService.selectAllAbled();
		if(!CollectionUtils.isEmpty(tags)){
			result.put("tags", tags);
		}			
		return result;
	}
}
