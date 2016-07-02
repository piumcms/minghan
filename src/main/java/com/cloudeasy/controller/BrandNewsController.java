
package com.cloudeasy.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudeasy.common.Constant;
import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.TagRelation;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.TagRelationService;
import com.cloudeasy.service.brand.DeleteBrandNewsService;
import com.cloudeasy.service.brand.DeleteBrandService;
import com.cloudeasy.service.brand.DeleteProductService;
import com.cloudeasy.service.brand.DeleteSubBrandService;
import com.cloudeasy.service.brand.FindAllSubBrandService;
import com.cloudeasy.service.brand.GetBrandByPkeyService;
import com.cloudeasy.service.brand.GetBrandNewsByPkeyService;
import com.cloudeasy.service.brand.GetProductByPkeyService;
import com.cloudeasy.service.brand.GetSubBrandByPkeyService;
import com.cloudeasy.service.brand.IsBrandByNameService;
import com.cloudeasy.service.brand.IsBrandNewsByNameService;
import com.cloudeasy.service.brand.IsProductByNameService;
import com.cloudeasy.service.brand.IsSubBrandByNameService;
import com.cloudeasy.service.brand.RecommendBrandNewsService;
import com.cloudeasy.service.brand.SaveBrandNewsService;
import com.cloudeasy.service.brand.SaveBrandService;
import com.cloudeasy.service.brand.SaveProductService;
import com.cloudeasy.service.brand.SaveSubBrandService;
import com.cloudeasy.service.brand.SelectAllBrandNewsService;
import com.cloudeasy.service.brand.SelectAllBrandService;
import com.cloudeasy.service.brand.SelectAllBrandVideoService;
import com.cloudeasy.service.brand.SelectAllProductService;
import com.cloudeasy.service.brand.SelectAllSubBrandService;
import com.cloudeasy.service.brand.SelectSkuByProductIdService;
import com.cloudeasy.service.brand.ShowFrontNewsService;
import com.cloudeasy.service.innovate.GetQuesAnswService;

@Controller
public class BrandNewsController extends BaseController {
    
	/**
	 * 保存品牌
	 */
	@Autowired
	private SaveBrandService saveBrandService;
	
	
	/**
	 * 查询品牌列表
	 */
	@Autowired
	private SelectAllBrandService selectAllBrandService;
	
	/**
	 * 根据key删除Brand
	 */
	@Autowired
	private DeleteBrandService deleteBrandService;
	
	/**
	 * 根据key删除Brand
	 */
	@Autowired
	private DeleteSubBrandService deleteSubBrandService;
	
	/**
	 * 根据key获取Brand
	 */
	@Autowired
	private GetBrandByPkeyService getBrandByPkeyService;
	
	/**
	 * 根据key获取Brand
	 */
	@Autowired
	private GetSubBrandByPkeyService getSubBrandByPkeyService;
	
	
	/**
	 * 判断名称是否存在
	 */
	@Autowired
	private IsBrandByNameService isBrandByNameService;
	
	/**
	 * 判断子品牌是否存在
	 */
	@Autowired
	private IsSubBrandByNameService isSubBrandByNameService;
	
	/**
	 * 保存子品牌
	 */
	@Autowired
	private SaveSubBrandService saveSubBrandService;
	
	/**
	 * 查询品牌列表
	 */
	@Autowired
	private SelectAllSubBrandService selectAllSubBrandService;
	
	@Autowired
	private IsProductByNameService isProductByNameService;
	
	@Autowired
	private SaveProductService saveProductService;
	
	@Autowired
	private SelectAllProductService selectAllProductService;
	
	@Autowired
	private DeleteProductService deleteProductService;
	
	@Autowired
	private GetProductByPkeyService getProductByPkeyService;
	
	@Autowired
	private IsBrandNewsByNameService isBrandNewsByNameService;
	
	@Autowired
	private DeleteBrandNewsService deleteBrandNewsService;
	
	@Autowired
	private GetBrandNewsByPkeyService getBrandNewsByPkeyService;
	
	@Autowired
	private SaveBrandNewsService saveBrandNewsService;
	
	@Autowired
	private SelectAllBrandNewsService selectAllBrandNewsService;
	
	@Autowired
	private SelectAllBrandVideoService selectAllBrandVideoService;
	
	@Autowired
	private SelectSkuByProductIdService selectSkuByProductIdService;
	
	@Autowired
	private RecommendBrandNewsService recommendBrandNewsService;
	
	@Autowired
	private ShowFrontNewsService showFrontNewsService;
	
	@Autowired
	private GetQuesAnswService getQuesAnswService;
	
	@Autowired
	private FindAllSubBrandService findAllSubBrandService;
	
	@Autowired
	private TagRelationService tagRelationService;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 保存商品
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveBrandNews.html")
	public void saveBrandNews(@RequestBody BrandNews brandNews, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brandNews.setCreateUser(super.getLoginUser(request).getUsername());
		brandNews.setFlag(super.getUrlFlag(request));
		brandNews.setChecker("0");
		Result result=isBrandNewsByNameService.execute(brandNews);
		Integer count=(Integer)result.getObj();
		if(count>0&&brandNews.getId()==null){
			super.sendFailureMessage(response,"", "商品名称已存在！");
		}else{
		 result = saveBrandNewsService.execute(brandNews);
		 if (result.getStatus().equals("0")) {
			 
			 Map params=new HashMap();
			 	params.put("type", Constant.TAG_RELATION_NEWS);
			 	params.put("relationId", brandNews.getId());
			 	tagRelationService.deleteByRelationId(params);
				String tags=brandNews.getTags();
				String [] tagIds=tags.split(",");			
				for(String tagId :tagIds){
					if(StringUtils.isNotBlank(tagId)){
						TagRelation tr=new TagRelation();
						tr.setRelationId(brandNews.getId());
						tr.setTagId(Integer.parseInt(tagId));
						tr.setType(Constant.TAG_RELATION_NEWS);
						tagRelationService.insert(tr);
					}

				}
		 	super.sendSuccessMessage(response,"", "保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}

	/**
	 * 搜索品牌新闻列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brand/{urlS}/list.html")
	public String ShowAllBrandNews(@PathVariable String urlS,ListBrandNewsReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		dto.setBrandType(urlS);
		String ctype = request.getParameter("category");
		dto.setCategory(ctype);
		Result result=selectAllBrandNewsService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",ctype);
		if (ctype.equals("brand_profile")) {
			return "/about/brandProfiles";
		} else if (ctype.equals("exciting_activities")) {
			return "/about/excitActivities";
		} else if (ctype.equals("school")) {
			return "/school/schoolList";
		}
		return "/brand/brandNewsList";
	}
	

	/**
	 * 显示品牌编辑页面
	 * @param brand
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brand/{urlS}/edits.html")
	public String showEditBrandNews(@PathVariable String urlS,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		BrandNews brandNews=new BrandNews();
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			brandNews.setId(Integer.valueOf(id));
			Result result = getBrandNewsByPkeyService.execute(brandNews);
			brandNews=(BrandNews)result.getObj();
		}else{
			brandNews.setBrandType(urlS);
			brandNews.setCategory(category);
		}
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand(""); 
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		String brandNewsName = request.getParameter("brandNewsName");
		if(StringUtils.isNotBlank(brandNewsName)){
			brandNewsName = URLDecoder.decode(brandNewsName, "UTF-8");
		}
		model.addAttribute("brandNewsName", brandNewsName);
	    model.addAttribute("brandList",brandList);
	    model.addAttribute("brandNews",brandNews);
	    model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",category);
		if (category.equals("exciting_activities")) {
			return "/about/editExcitActivities";
		} else if (category.equals("brand_profile")) {
			return "/about/editBrandProfile";
		} else if (category.equals("school")) {
			return "/school/editSchool";
		}
		return "/brand/addBrandNews";
	}
	
	/**
	 * 显示品牌历程编辑页面
	 * @param brand
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brand/{urlS}/editBrandProfile.html")
	public String showEditBrandProfile(@PathVariable String urlS,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		BrandNews brandNews=new BrandNews();
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			brandNews.setId(Integer.valueOf(id));
			Result result = getBrandNewsByPkeyService.execute(brandNews);
			brandNews=(BrandNews)result.getObj();
		}else{
			brandNews.setBrandType(urlS);
			brandNews.setCategory(category);
		}
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand(""); 
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		model.addAttribute("brandNews",brandNews);
	    model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",category);
		return "/about/editBrandProfile";
	}
	
	/**
	 * 显示品牌历程编辑页面
	 * @param brand
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brand/{urlS}/editAboutUs.html")
	public String showEditAboutUs(@PathVariable String urlS,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		BrandNews brandNews=new BrandNews();
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			brandNews.setId(Integer.valueOf(id));
			Result result = getBrandNewsByPkeyService.execute(brandNews);
			brandNews=(BrandNews)result.getObj();
		}else{
			brandNews.setBrandType(urlS);
			brandNews.setCategory(category);
		}
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand(""); 
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		model.addAttribute("brandNews",brandNews);
	    model.addAttribute("brandType",urlS);
		model.addAttribute("ctype",category);
		return "/about/editExictActivities";
	}
	
	/**
	 * 保存品牌历程
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveBrandProfile.html")
	public void saveBrandProfile(@RequestBody BrandNews brandNews, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brandNews.setCreateUser(super.getLoginUser(request).getUsername());
		brandNews.setFlag(super.getUrlFlag(request));
		brandNews.setChecker("0");
		Result result=isBrandNewsByNameService.execute(brandNews);
		Integer count=(Integer)result.getObj();
		if(count>0&&brandNews.getId()==null){
			super.sendFailureMessage(response,"", "品牌历程已存在！");
		}else{
		 result = saveBrandNewsService.execute(brandNews);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"", "保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}
	
	 /**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeBrandNews.html")
	public void removeBrandNews(@RequestBody BrandNews brandNews, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brandNews.setCreateUser(super.getLoginUser(request).getUsername());
		brandNews.setFlag(super.getUrlFlag(request));
		Result result = deleteBrandNewsService.execute(brandNews);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
}
