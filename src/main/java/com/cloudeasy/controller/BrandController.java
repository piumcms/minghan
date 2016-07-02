package com.cloudeasy.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.cloudeasy.bean.ProductNews;
import com.cloudeasy.dto.brand.ListAttributeReqDTO;
import com.cloudeasy.dto.brand.ListBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ListBrandNewsResDTO;
import com.cloudeasy.dto.brand.ListBrandReqDTO;
import com.cloudeasy.dto.brand.ListBrandResDTO;
import com.cloudeasy.dto.brand.ListNewProductReqDTO;
import com.cloudeasy.dto.brand.ListProductNewsReqDTO;
import com.cloudeasy.dto.brand.ListProductNewsResDTO;
import com.cloudeasy.dto.brand.ListProductReqDTO;
import com.cloudeasy.dto.brand.ListProductResDTO;
import com.cloudeasy.dto.brand.ListSkuReqDTO;
import com.cloudeasy.dto.brand.ListSubBrandReqDTO;
import com.cloudeasy.dto.brand.ListSubBrandResDTO;
import com.cloudeasy.dto.brand.ShowBrandNewsReqDTO;
import com.cloudeasy.dto.brand.ShowBrandNewsResDTO;
import com.cloudeasy.model.Attribute;
import com.cloudeasy.model.Brand;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.BrandVideo;
import com.cloudeasy.model.NewProduct;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.Sku;
import com.cloudeasy.model.SubBrand;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.brand.DeleteAttributeService;
import com.cloudeasy.service.brand.DeleteBrandNewsService;
import com.cloudeasy.service.brand.DeleteBrandService;
import com.cloudeasy.service.brand.DeleteNewProductService;
import com.cloudeasy.service.brand.DeleteProductService;
import com.cloudeasy.service.brand.DeleteSkuService;
import com.cloudeasy.service.brand.DeleteSubBrandService;
import com.cloudeasy.service.brand.FindAllSubBrandService;
import com.cloudeasy.service.brand.GetAttributeByPkeyService;
import com.cloudeasy.service.brand.GetBrandByPkeyService;
import com.cloudeasy.service.brand.GetBrandNewsByBrandIdService;
import com.cloudeasy.service.brand.GetBrandNewsByPkeyService;
import com.cloudeasy.service.brand.GetNewProductByPkeyService;
import com.cloudeasy.service.brand.GetProductByPkeyService;
import com.cloudeasy.service.brand.GetSkuByPkeyService;
import com.cloudeasy.service.brand.GetSubBrandByPkeyService;
import com.cloudeasy.service.brand.IsAttributeByNameService;
import com.cloudeasy.service.brand.IsBrandByNameService;
import com.cloudeasy.service.brand.IsBrandNewsByNameService;
import com.cloudeasy.service.brand.IsNewProductByNameService;
import com.cloudeasy.service.brand.IsProductByNameService;
import com.cloudeasy.service.brand.IsSubBrandByNameService;
import com.cloudeasy.service.brand.RecommendBrandNewsService;
import com.cloudeasy.service.brand.SaveAttributeService;
import com.cloudeasy.service.brand.SaveBrandNewsService;
import com.cloudeasy.service.brand.SaveBrandService;
import com.cloudeasy.service.brand.SaveNewProductService;
import com.cloudeasy.service.brand.SaveProductService;
import com.cloudeasy.service.brand.SaveSkuService;
import com.cloudeasy.service.brand.SaveSubBrandService;
import com.cloudeasy.service.brand.SelectAllAttributeService;
import com.cloudeasy.service.brand.SelectAllBrandNewsService;
import com.cloudeasy.service.brand.SelectAllBrandService;
import com.cloudeasy.service.brand.SelectAllBrandVideoService;
import com.cloudeasy.service.brand.SelectAllNewProductService;
import com.cloudeasy.service.brand.SelectAllProductNewsService;
import com.cloudeasy.service.brand.SelectAllProductService;
import com.cloudeasy.service.brand.SelectAllSkuService;
import com.cloudeasy.service.brand.SelectAllSubBrandService;
import com.cloudeasy.service.brand.SelectSkuByProductIdService;
import com.cloudeasy.service.brand.ShowFrontNewsService;
import com.cloudeasy.service.innovate.GetQuesAnswService;
import com.cloudeasy.utils.HtmlUtil;

@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController {
    
	/**
	 * 主键
	 */
	private Integer id;
	
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
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *  显示添加品牌页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addBrand.html")
	public String showAddBrand(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		return "/brand/addBrand";
	}
	
	
	/**
	 * 保存品牌
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveBrand.html")
	public void saveBrand(@RequestBody Brand brand, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brand.setCreateUser(super.getLoginUser(request).getUsername());
		brand.setFlag(super.getUrlFlag(request));
		Result result=isBrandByNameService.execute(brand);
		Integer count=(Integer)result.getObj();
		if(count>0&&brand.getId()==null){
			super.sendFailureMessage(response,"", "品牌名称已存在！");
		}else{
		 result = saveBrandService.execute(brand);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response, "","保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}
	
	
	
	/**
	 * 搜索品牌列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brandList.html")
	public String ShowAllBrand(ListBrandReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllBrandService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/brand/brandList";
	}
	
    /**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeBrand.html")
	public void removeBrand(@RequestBody Brand brand, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brand.setCreateUser(super.getLoginUser(request).getUsername());
		brand.setFlag(super.getUrlFlag(request));
		Result result = deleteBrandService.execute(brand);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
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
	@RequestMapping("/showEditBrand.html")
	public String showEditBrand(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Brand brand=new Brand();
		id=Integer.valueOf(request.getParameter("id"));
		brand.setId(id);
		Result result = getBrandByPkeyService.execute(brand);
		brand=(Brand)result.getObj();
		model.addAttribute("bflag", 2);
		model.addAttribute("brand", brand);
		return "/brand/addBrand";
	}


	/**
	 *  显示添加子品牌页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSubBrand.html")
	public String showAddSubBrand(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		//获取一级品牌列表
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
	    SubBrand subBrand=new SubBrand();
	    subBrand.setBrandId(brandList.get(0).getId());
	    model.addAttribute("brandList",brandList);
	    model.addAttribute("subbrand",subBrand);
	    model.addAttribute("brand",new Brand());
		return "/brand/addSubBrand";
	}
	
	/**
	 * 保存子品牌
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveSubBrand.html")
	public void saveSubBrand(@RequestBody SubBrand subbrand, HttpServletRequest request, HttpServletResponse response) throws Exception {
		subbrand.setCreateUser(super.getLoginUser(request).getUsername());
		subbrand.setFlag(super.getUrlFlag(request));
		Result result=isSubBrandByNameService.execute(subbrand);
		Integer count=(Integer)result.getObj();
		if(count>0&&subbrand.getId()==null){
			super.sendFailureMessage(response,"", "子品牌名称已存在！");
		}else{
		 result = saveSubBrandService.execute(subbrand);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"", "保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}	

	/**
	 * 搜索品牌列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/subbrandList.html")
	public String ShowAllSubBrand(ListSubBrandReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllSubBrandService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		
		List<Brand> list = getQuesAnswService.execute(super.getUrlFlag(request));
		model.addAttribute("list", list);
		return "/brand/subbrandList";
	}
	
	 /**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeSubBrand.html")
	public void removeSubBrand(@RequestBody SubBrand brand, HttpServletRequest request, HttpServletResponse response) throws Exception {
		brand.setCreateUser(super.getLoginUser(request).getUsername());
		brand.setFlag(super.getUrlFlag(request));
		Result result = deleteSubBrandService.execute(brand);
		if(result.getStatus().equals("0")){
			super.sendSuccessMessage(response,"", "删除成功");
		}else {
			super.sendFailureMessage(response,"", "删除失败");
		}
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
	@RequestMapping("/showEditSubBrand.html")
	public String showEditSubBrand(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		SubBrand subbrand=new SubBrand();
		id=Integer.valueOf(request.getParameter("id"));
		subbrand.setId(id);
		Result result = getSubBrandByPkeyService.execute(subbrand);
		subbrand=(SubBrand)result.getObj();
	
		Brand brand=new Brand();
		brand.setId(subbrand.getBrandId());
		result=getBrandByPkeyService.execute(brand);
		brand=(Brand)result.getObj();
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
		model.addAttribute("bflag", 2);
		subbrand.setBrandId(brandList.get(0).getId());
	    model.addAttribute("brandList",brandList);
	    model.addAttribute("brand", brand);
	    model.addAttribute("subbrand",subbrand);
	    
	    model.addAttribute("pageNumber", request.getParameter("pageNumber"));
		return "/brand/addSubBrand";
	}	
	
	
	/**
	 *  显示添加商品
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addProduct.html")
	public String showAddProduct(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		//获取一级品牌列表
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		brandMap.put(0, "-请选择-");
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
	    Product product=new Product();
	    product.setTableId("0");
	    model.addAttribute("brandMap",brandMap);
	    model.addAttribute("product",product);
		return "/brand/addProduct";
	}
	
	/**
	 * 二级下拉框获取子品牌
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getSubBrand.html")
	public void getSubBrand(@RequestBody SubBrand subBrand, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListSubBrandReqDTO brandReqDto=new ListSubBrandReqDTO();
		brandReqDto.setBrandId(subBrand.getBrandId());
		Result result=selectAllSubBrandService.execute(brandReqDto);
		ListSubBrandResDTO resDto=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subList=resDto.getList();
		Map<Integer, String> subBrandMap = new HashMap<Integer, String>();  
		for (int i=0;i<subList.size();i++) {
			subBrandMap.put(subList.get(i).getId(), subList.get(i).getBrand());
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		System.out.println(gson.toJson(subList));
		HtmlUtil.writerJson( response,gson.toJson(subList));
	}	
	
	
	/**
	 * 保存商品
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveProduct.html")
	public void saveProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
		product.setCreateUser(super.getLoginUser(request).getUsername());
		product.setFlag(super.getUrlFlag(request));
		product.setTableRelateFlag("1");
		Result result=isProductByNameService.execute(product);
		Integer count=(Integer)result.getObj();
		if(count>0&&product.getId()==null){
			super.sendFailureMessage(response,"", "商品名称已存在！");
		}else{
		 result = saveProductService.execute(product);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"", "保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}

	/**
	 * 搜索商品列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/productList.html")
	public String ShowAllProduct(ListProductReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllProductService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("list", findAllSubBrandService.execute(""));
		return "/brand/productList";
	}
	
	 /**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeProduct.html")
	public void removeProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
		product.setCreateUser(super.getLoginUser(request).getUsername());
		product.setFlag(super.getUrlFlag(request));
		Result result = deleteProductService.execute(product);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
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
	@RequestMapping("/showEditProduct.html")
	public String showEditProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Product product=new Product();
		id=Integer.valueOf(request.getParameter("id"));
		product.setId(id);
		Result result = getProductByPkeyService.execute(product);
		product=(Product)result.getObj();
		model.addAttribute("product",product);
		
		    SubBrand subBrand=new SubBrand();
		    subBrand.setId(Integer.valueOf(product.getTableId()));
		    result=getSubBrandByPkeyService.execute(subBrand);
		    subBrand=(SubBrand)result.getObj();
		    model.addAttribute("subBrand", subBrand);
		    Brand brand=new Brand();
		    brand.setId(subBrand.getBrandId());
		    result=getBrandByPkeyService.execute(brand);
		    brand=(Brand)result.getObj();
		    model.addAttribute("brand", brand);
		    
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
		product.setTableId(String.valueOf(subBrand.getBrandId()));
	    model.addAttribute("brandList",brandList);
	    
		ListSubBrandReqDTO brandReqDto=new ListSubBrandReqDTO();
		brandReqDto.setBrandId(subBrand.getBrandId());
		result=selectAllSubBrandService.execute(brandReqDto);
		ListSubBrandResDTO resDto=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subList=resDto.getList();
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		model.addAttribute("tableId", request.getParameter("tableId"));
		String productName = request.getParameter("productName");
		productName = URLDecoder.decode(productName, "UTF-8");
		model.addAttribute("productName", productName);
		model.addAttribute("subList",subList);
		model.addAttribute("bflag", 2);
		return "/brand/editProduct";
	}	
	
	/**
	 *  显示添加品牌新闻
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addBrandNews.html")
	public String showAddBrandNews(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		//获取一级品牌列表
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
	    BrandNews brandNews=new BrandNews();
	    brandNews.setCreateTime(new Date());
	    brandNews.setBrandId(brandList.get(0).getId());
		model.addAttribute("pageNumber","1");
	    model.addAttribute("brandMap",brandMap);
	    model.addAttribute("brandList",brandList);
	    model.addAttribute("brandNews",brandNews);
		return "/brand/addBrandNews";
	}
	
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
	@RequestMapping("/brandNewsList.html")
	public String ShowAllBrandNews(ListBrandNewsReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllBrandNewsService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("subBrandId", dto.getBrandId());
		
		ListBrandReqDTO dtom=new ListBrandReqDTO();
		dtom.setBrand("");
		result=selectAllBrandService.execute(dtom);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		List<Brand> brandList=resdto.getList();
		model.addAttribute("subList", brandList);
		return "/brand/brandNewsList";
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
	
	/**
	 * 显示品牌编辑页面
	 * @param brand
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showEditBrandNews.html")
	public String showEditBrandNews(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		BrandNews brandNews=new BrandNews();
		id=Integer.valueOf(request.getParameter("id"));
		brandNews.setId(id);
		Result result = getBrandNewsByPkeyService.execute(brandNews);
		brandNews=(BrandNews)result.getObj();
	    
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand(""); 
		result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		Map<Integer, String> brandMap = new HashMap<Integer, String>();  
		List<Brand> brandList=resdto.getList();
		for (int i=0;i<brandList.size();i++) {
			brandMap.put(brandList.get(i).getId(), brandList.get(i).getBrand());
		}
		model.addAttribute("bflag", 2);
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
	    model.addAttribute("brandList",brandList);
	    model.addAttribute("brandNews",brandNews);
		return "/brand/addBrandNews";
	}	
	
	/**
	 *  显示添加商品属性页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addAttribute.html")
	public String showAddAttribute(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		return "/brand/addAttribute";
	}
	
	@Autowired
	private IsAttributeByNameService isAttributeByNameService;
	
	@Autowired 
	private SaveAttributeService saveAttributeService;
	
	/**
	 * 保存商品属性
	 * @param attri
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveAttribute.html")
	public void saveAttribute(@RequestBody Attribute attri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result=isAttributeByNameService.execute(attri);
		Integer count=(Integer)result.getObj();
		if(count>0&&attri.getId()==null){
			super.sendFailureMessage(response,"", "商品属性名称已存在！");
		}else{
		 attri.setFlag(Integer.valueOf(super.getUrlFlag(request)));
		 result = saveAttributeService.execute(attri);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"","保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}
	
	@Autowired
	private SelectAllAttributeService selectAllAttributeService;
	
	/**
	 * 搜索商品属性列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/attriList.html")
	public String ShowAllAttribute(ListAttributeReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllAttributeService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/brand/attriList";
	}
	
	
    @Autowired
    private DeleteAttributeService deleteAttributeService;
    
    /**
     * 删除Attribute
     * @param attri
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeAttribute.html")
	public void removeAttribute(@RequestBody Attribute attri, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = deleteAttributeService.execute(attri);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response, "","删除失败");
		}
	}
	
	@Autowired
	private GetAttributeByPkeyService getAttributeByPkeyService;
	
	/**
	 * 显示商品属性编辑页面
	 * @param attri
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showEditAttribute.html")
	public String showEditAttribute(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Attribute attri=new Attribute();
		id=Integer.valueOf(request.getParameter("id"));
		attri.setId(id);
		Result result = getAttributeByPkeyService.execute(attri);
		attri=(Attribute)result.getObj();
		model.addAttribute("bflag", 2);
		model.addAttribute("attri", attri);
		return "/brand/addAttribute";
	}
    /** ---------------------------------------------Sku商品-------------------------------------------------------*/
	/**
	 *  显示添加Sku商品页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSku.html")
	public String showAddSku(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag",1);
		ListSubBrandReqDTO subReqBrandReqDTO=new ListSubBrandReqDTO();
		Result result=selectAllSubBrandService.execute(subReqBrandReqDTO);
		ListSubBrandResDTO subBrandResDTO=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subBrandList=subBrandResDTO.getList();
		model.addAttribute("subBrandList", subBrandList);
		
//		ListAttributeReqDTO attrReqDto=new ListAttributeReqDTO();
//		result=selectAllAttributeService.execute(attrReqDto);
//		ListAttributeResDTO resdto=(ListAttributeResDTO)result.getBaseDTO();
//		Map<Integer, String> attriMap = new HashMap<Integer, String>();  
//		List<Attribute> attriList=resdto.getList();
//		for (int i=0;i<attriList.size();i++){
//			attriMap.put(attriList.get(i).getId(), attriList.get(i).getName());
//		}
//		model.addAttribute("attriMap", attriMap);
//		
//		ListProductReqDTO proReqDto=new ListProductReqDTO();
//		proReqDto.setRows(99999);
//		result=selectAllProductService.execute(proReqDto);
//		ListProductResDTO proResdto=(ListProductResDTO)result.getBaseDTO();
//		Map<Integer, String> proMap = new HashMap<Integer, String>();  
//		List<Product> proList=proResdto.getList();
//		for (int i=0;i<proList.size();i++){
//			proMap.put(proList.get(i).getId(), proList.get(i).getProductName());
//		}
//		model.addAttribute("proMap", proMap);
		
		Sku sku=new Sku();
		model.addAttribute("sku",sku);
		return "/brand/addSku";
	}
	
	
	/**
	 * 二级下拉框获取子商品
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getProduct.html")
	public void getProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
 		ListProductReqDTO proReqDto=new ListProductReqDTO();
 		proReqDto.setRows(99999);
 		proReqDto.setTableId(product.getTableId());
 		Result result=selectAllProductService.execute(proReqDto);
 		ListProductResDTO proResdto=(ListProductResDTO)result.getBaseDTO();
 		List<Product> proList=proResdto.getList();
		Gson gson = new Gson();
		response.setContentType("application/json");
		System.out.println(gson.toJson(proList));
		HtmlUtil.writerJson( response,gson.toJson(proList));
	}	

	@Autowired 
	private SaveSkuService saveSkuService;
	
	/**
	 * 保存Sku商品
	 * @param sku
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveSku.html")
	public void saveSku(@RequestBody Sku sku, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 Result result = saveSkuService.execute(sku);
		 if(result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"", "保存成功");
		 }else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
	}
	
	@Autowired
	private SelectAllSkuService selectAllSkuService;
	
	/**
	 * 搜索Sku商品列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/skuList.html")
	public String ShowAllSku(ListSkuReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllSkuService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("list", findAllSubBrandService.execute(""));
		return "/brand/skuList";
	}
	
	
    @Autowired
    private DeleteSkuService deleteSkuService;
    
    /**
     * 删除Sku
     * @param sku
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeSku.html")
	public void removeSku(@RequestBody Sku sku, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = deleteSkuService.execute(sku);
		if(result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		}else{
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
	
	@Autowired
	private GetSkuByPkeyService getSkuByPkeyService;
	
	/**
	 * 显示Sku商品编辑页面
	 * @param sku
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showEditSku.html")
	public String showEditSku(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Sku sku=new Sku();
		id=Integer.valueOf(request.getParameter("id"));
		sku.setId(id);
		Result result = getSkuByPkeyService.execute(sku);
		sku=(Sku)result.getObj();
		model.addAttribute("sku", sku);
		
		Product product=new Product();
		product.setId(sku.getProductId());
		result=getProductByPkeyService.execute(product);
		product=(Product)result.getObj();
		model.addAttribute("product", product);
		
		
		
		ListSubBrandReqDTO subReqBrandReqDTO=new ListSubBrandReqDTO();
		result=selectAllSubBrandService.execute(subReqBrandReqDTO);
		ListSubBrandResDTO subBrandResDTO=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subBrandList=subBrandResDTO.getList();
		model.addAttribute("subBrandList", subBrandList);
		
		ListProductReqDTO proReqDto=new ListProductReqDTO();
		proReqDto.setTableId(product.getTableId());
		result=selectAllProductService.execute(proReqDto);
		ListProductResDTO proResdto=(ListProductResDTO)result.getBaseDTO();
		Map<Integer, String> proMap = new HashMap<Integer, String>();  
		List<Product> proList=proResdto.getList();
		model.addAttribute("proList", proList);
//		ListAttributeReqDTO attrReqDto=new ListAttributeReqDTO();
//		result=selectAllAttributeService.execute(attrReqDto);
//		ListAttributeResDTO resdto=(ListAttributeResDTO)result.getBaseDTO();
//		Map<Integer, String> attriMap = new HashMap<Integer, String>();  
//		List<Attribute> attriList=resdto.getList();
//		for (int i=0;i<attriList.size();i++){
//			attriMap.put(attriList.get(i).getId(), attriList.get(i).getName());
//		}
//		model.addAttribute("attriMap", attriMap);
		
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		model.addAttribute("tableId",request.getParameter("tableId"));
		String attributeName = request.getParameter("attributeName");
		if (attributeName != null) {
			attributeName = URLDecoder.decode(attributeName,  "UTF-8");
		}
		
		model.addAttribute("attributeName",attributeName);
		String productName = request.getParameter("productName");
		if (productName != null) {
			productName = 	URLDecoder.decode(productName,  "UTF-8");
		}
		
		model.addAttribute("productName", productName);
		model.addAttribute("bflag", 2);
		return "/brand/editSku";
	}

	
	/*****************************************************新品管理*********************************************************************/
	
	/**
	 *  显示添加新品页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addNewProduct.html")
	public String showAddNewProduct(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("bflag", 1);
		return "/brand/addNewProduct";
	}
	
	@Autowired
	private IsNewProductByNameService isNewProductByNameService;
	
	@Autowired
	private SaveNewProductService saveNewProductService;
	
	/**
	 * 保存品牌
	 * @param newProduct
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveNewProduct.html")
	public void saveNewProduct(@RequestBody NewProduct newProduct, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result=isNewProductByNameService.execute(newProduct);
		Integer count=(Integer)result.getObj();
		if(count>0&&newProduct.getId()==null){
			super.sendFailureMessage(response,"", "新品名称已存在！");
		}else{
		 result = saveNewProductService.execute(newProduct);
		 if (result.getStatus().equals("0")) {
		 	super.sendSuccessMessage(response,"", "保存成功");
		 } else {
			super.sendFailureMessage(response,"", "保存失败");
		 }
		}
	}
	
	
	@Autowired
	private SelectAllNewProductService selectAllNewProductService;
	
	/**
	 * 搜索新品列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/newProductList.html")
	public String ShowAllNewProduct(ListNewProductReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		Result result=selectAllNewProductService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/brand/newProductList";
	}
	
	@Autowired
	private DeleteNewProductService deleteNewProductService;
	
    /**
     * 删除NewProduct
     * @param newProduct
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeNewProduct.html")
	public void removeNewProduct(@RequestBody NewProduct newProduct, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = deleteNewProductService.execute(newProduct);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
	
	@Autowired
	private GetNewProductByPkeyService getNewProductByPkeyService;
	
	/**
	 * 显示品牌编辑页面
	 * @param newProduct
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showEditNewProduct.html")
	public String showEditNewProduct(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		NewProduct newProduct=new NewProduct();
		id=Integer.valueOf(request.getParameter("id"));
		newProduct.setId(id);
		Result result = getNewProductByPkeyService.execute(newProduct);
		newProduct=(NewProduct)result.getObj();
		model.addAttribute("bflag", 2);
		model.addAttribute("newProduct", newProduct);
		return "/brand/addNewProduct";
	}
	
	
	/*****************************************************前端*********************************************************************/
	
     @Autowired
     private GetBrandNewsByBrandIdService getBrandNewsByBrandIdService;

	@RequestMapping("/showbrand.html")
	public ModelAndView showBrand(HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("showbrand");
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		List<Brand> brandList=resdto.getList();
		
		ShowBrandNewsReqDTO showBrandNewsReqDTO = new ShowBrandNewsReqDTO();
		showBrandNewsReqDTO.setFlag(super.getUrlFlag(request));
		showBrandNewsReqDTO.setRows(5);
		showBrandNewsReqDTO.setBrandId(null);
		
		result=showFrontNewsService.execute(showBrandNewsReqDTO);
		ShowBrandNewsResDTO bnreRDto=(ShowBrandNewsResDTO)result.getBaseDTO();
		mv.addObject("brandNewList", bnreRDto.getList());
		mv.addObject("brandList", brandList);
		mv.addObject("brand",brandList.get(0));
		
		/**显示品牌视频**/
		BrandVideo video = new BrandVideo();
		video.setFlag(super.getUrlFlag(request));
		video.setBrandId(null);
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		Map<String, List<BrandVideo>> map = new LinkedHashMap<String, List<BrandVideo>>();
		List<BrandVideo> innerList = new ArrayList<BrandVideo>();
		for (BrandVideo b : list) {
			
			if (!map.containsKey(String.valueOf(b.getYearM()))) {
				innerList = new ArrayList<BrandVideo>();
				map.put(String.valueOf(b.getYearM()), innerList);
			}
			innerList.add(b);
		}
		mv.addObject("map", map);
		
		return mv;
	}	
	
	@Autowired
	private SelectAllProductNewsService selectAllProductNewsService;
	/**
	 * 全站搜索
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectAll.html")
	public ModelAndView selectAll(ListProductNewsReqDTO dto, HttpServletRequest request, Model model) throws Exception{
		ModelAndView mv = new ModelAndView("selectAll");
		dto.setTitle(request.getParameter("title"));
		Result result=selectAllProductNewsService.execute(dto);
		ListProductNewsResDTO resdto=(ListProductNewsResDTO)result.getBaseDTO();
		List<ProductNews> productList=resdto.getList();
		String regEx="<.+?>"; //表示标签 
		for (ProductNews productNews : productList) {
			 Pattern p=Pattern.compile(regEx); 
		        Matcher m=p.matcher(productNews.getContent()); 
		        String s=m.replaceAll("");
		        productNews.setContent(s.trim().replaceAll("&nbsp;", "").toString());
		}
		mv.addObject("list", resdto.getList());
		mv.addObject("title", dto.getTitle());
		mv.addObject("dto",resdto);
		return mv;
	} 
	
	@RequestMapping("/showbrandindex/{id}")
	public ModelAndView showBrandById(@PathVariable Integer id,HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("showbrandindex");
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		Result result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		List<Brand> brandList=resdto.getList();
		mv.addObject("brandList", brandList);
		
		//获取品牌
		Brand brand=new Brand();
		brand.setId(id);
		result=getBrandByPkeyService.execute(brand);
	    brand=(Brand)result.getObj();
		mv.addObject("brand",brand);
		mv.addObject("t",brand.getId());
		
		//获取品牌新闻
		ListBrandNewsReqDTO bnreqDto=new ListBrandNewsReqDTO();
		bnreqDto.setBrandId(brand.getId());
		result=selectAllBrandNewsService.execute(bnreqDto);
		ListBrandNewsResDTO bnreRDto=(ListBrandNewsResDTO)result.getBaseDTO();
		mv.addObject("brandNewList", bnreRDto.getList());
		
		/**显示品牌视频**/
		BrandVideo video = new BrandVideo();
		video.setFlag(super.getUrlFlag(request));
		video.setBrandId(brand.getId());
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		Map<String, List<BrandVideo>> map = new LinkedHashMap<String, List<BrandVideo>>();
		List<BrandVideo> innerList = new ArrayList<BrandVideo>();
		int count = 0;
		for (BrandVideo b : list) {
			if (count > 3 ) {
				break;
			}
			if (!map.containsKey(String.valueOf(b.getBrandId()))) {
				innerList = new ArrayList<BrandVideo>();
				map.put(String.valueOf(b.getBrandId()), innerList);
			}
			innerList.add(b);
		}
		mv.addObject("map", map);
		count++;
		mv.addObject("ttitle","4");
		return mv;
	}
	
	@RequestMapping("/showBrandInfo/{category}")
	public ModelAndView showBrandInfo(@PathVariable String category,HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("brandInfo");
		//获取品牌
		Brand brand=new Brand();
		brand.setId(Integer.parseInt(category));
		Result result=getBrandByPkeyService.execute(brand);
	    brand=(Brand)result.getObj();
		mv.addObject("brand",brand);
		mv.addObject("t",brand.getId());
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		List<Brand> brandList=resdto.getList();
		mv.addObject("brandList",brandList);
	
		//获取子品牌
		ListSubBrandReqDTO subBrandReqDto=new ListSubBrandReqDTO();
		subBrandReqDto.setBrandId(brand.getId());
		result=selectAllSubBrandService.execute(subBrandReqDto);
		ListSubBrandResDTO subBrandResDto=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subBrandList=subBrandResDto.getList();
		mv.addObject("subBrandList",subBrandList);
		
		
		
		
		//获取品牌新闻

		ShowBrandNewsReqDTO showBrandNewsReqDTO = new ShowBrandNewsReqDTO();
		showBrandNewsReqDTO.setFlag(super.getUrlFlag(request));
		showBrandNewsReqDTO.setRows(5);
		showBrandNewsReqDTO.setBrandId(brand.getId());
		result=showFrontNewsService.execute(showBrandNewsReqDTO);
		ShowBrandNewsResDTO bnreRDto=(ShowBrandNewsResDTO)result.getBaseDTO();
		
		
		mv.addObject("brandNewsList", bnreRDto.getList());
		//mv.addObject("brandList", brandList);
		
		/**显示品牌视频**/
		BrandVideo video = new BrandVideo();
		video.setFlag(super.getUrlFlag(request));
		video.setBrandId(brand.getId());
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		Map<String, List<BrandVideo>> map = new LinkedHashMap<String, List<BrandVideo>>();
		List<BrandVideo> innerList = new ArrayList<BrandVideo>();
		int count = 0;
		for (BrandVideo b : list) {
			if (count > 3 ) {
				break;
			}
			if (!map.containsKey(String.valueOf(b.getBrandId()))) {
				innerList = new ArrayList<BrandVideo>();
				map.put(String.valueOf(b.getBrandId()), innerList);
			}
			innerList.add(b);
		}
		mv.addObject("map", map);
		count++;
		mv.addObject("ttitle","4");
		return mv;
	}	
	
	
	@RequestMapping("/showproductinfo/{category}/{id}.html")
	public ModelAndView showPoductInfo(@PathVariable String category, @PathVariable Integer id,  Product product, HttpServletRequest request, Model model) throws Exception {
		ModelAndView mv = new ModelAndView("productInfo");
		if(category.equals("-1")){
			product.setId(id);
			Result result=getProductByPkeyService.execute(product);
			product=(Product)result.getObj();
			SubBrand subBrand=new SubBrand();
			subBrand.setId(Integer.valueOf(product.getTableId()));
			result=getSubBrandByPkeyService.execute(subBrand);
			subBrand=(SubBrand)result.getObj();
			category=subBrand.getBrandId().toString();
			if(category.equals("1")){
				category="2";
			}
		}
		//获取品牌
		Brand brand=new Brand();
		brand.setId(Integer.parseInt(category));
		Result result=getBrandByPkeyService.execute(brand);
	    brand=(Brand)result.getObj();
		mv.addObject("brand",brand);
		mv.addObject("t",brand.getId());
		
		ListBrandReqDTO dto=new ListBrandReqDTO();
		dto.setBrand("");
		result=selectAllBrandService.execute(dto);
		ListBrandResDTO resdto=(ListBrandResDTO)result.getBaseDTO();
		List<Brand> brandList=resdto.getList();
		mv.addObject("brandList",brandList);
	
		//获取子品牌
		ListSubBrandReqDTO subBrandReqDto=new ListSubBrandReqDTO();
		subBrandReqDto.setBrandId(brand.getId());
		result=selectAllSubBrandService.execute(subBrandReqDto);
		ListSubBrandResDTO subBrandResDto=(ListSubBrandResDTO)result.getBaseDTO();
		List<SubBrand> subBrandList=subBrandResDto.getList();
		mv.addObject("subBrandList",subBrandList);
		
		//获取对应产品
		Result r = getProductByPkeyService.execute(product);
		product = (Product)r.getObj();
		model.addAttribute("product", product);
		Sku sku = new Sku();
		sku.setProductId(product.getId());
		List<Sku> skuList = selectSkuByProductIdService.execute(sku);
		
		if (skuList != null && skuList.size() > 0) {
			model.addAttribute("sku", skuList.get(0));
		} else {
			sku.setId(0);
			sku.setInfo(product.getProductDesc());
			sku.setSrc(product.getPicSrc());
			sku.setProductId(product.getId());
			sku.setProductName(product.getProductName());
			skuList = new ArrayList<Sku>();
			skuList.add(sku);
			model.addAttribute("sku", skuList.get(0));	
		}
		model.addAttribute("skuList", skuList);
		//获取品牌产品
				List<SubBrand> showBrandList = new ArrayList<SubBrand>();
				
				List<Product> listProduct = new ArrayList<Product>();
				Map<String, List<Product>> mapProduct = new LinkedHashMap<String, List<Product>>();
				if (subBrandList != null) {
					for (SubBrand subBrand : subBrandList) {
						ListProductReqDTO productReqDto=new ListProductReqDTO();
						productReqDto.setTableId(String.valueOf(subBrand.getId()));
						productReqDto.setRows(999);
						ListProductResDTO productResDto=(ListProductResDTO)selectAllProductService.execute(productReqDto).getBaseDTO();
						showBrandList.add(subBrand);
						mapProduct.put(subBrand.getId().toString(), productResDto.getList());
					}
				}
				Collections.reverse(showBrandList);
				mv.addObject("showBrandList", showBrandList);
				mv.addObject("mapProduct", mapProduct);
		//获取品牌新闻
		ListBrandNewsReqDTO bnreqDto=new ListBrandNewsReqDTO();
		bnreqDto.setBrandId(brand.getId());
		result=selectAllBrandNewsService.execute(bnreqDto);
		ListBrandNewsResDTO bnreRDto=(ListBrandNewsResDTO)result.getBaseDTO();
		mv.addObject("brandNewsList", bnreRDto.getList());
		//mv.addObject("brandList", brandList);
		
		/**显示品牌视频**/
		BrandVideo video = new BrandVideo();
		video.setFlag(super.getUrlFlag(request));
		video.setBrandId(brand.getId());
		List<BrandVideo> list = selectAllBrandVideoService.execute(video);
		Map<String, List<BrandVideo>> map = new LinkedHashMap<String, List<BrandVideo>>();
		List<BrandVideo> innerList = new ArrayList<BrandVideo>();
		int count = 0;
		for (BrandVideo b : list) {
			if (count > 3 ) {
				break;
			}
			if (!map.containsKey(String.valueOf(b.getBrandId()))) {
				innerList = new ArrayList<BrandVideo>();
				map.put(String.valueOf(b.getBrandId()), innerList);
			}
			innerList.add(b);
		}
		mv.addObject("map", map);
		count++;
		mv.addObject("ttitle","4");
		return mv;
	}
	
	/**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/recommendBrandNews.html")
	public void recommendBrandNews(@RequestBody BrandNews brandNews, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Result result = recommendBrandNewsService.execute(brandNews);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "操作成功");
		} else {
			super.sendFailureMessage(response,"", "操作失败");
		}
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
}
