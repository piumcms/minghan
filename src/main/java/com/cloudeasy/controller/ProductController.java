package com.cloudeasy.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudeasy.bean.TreeNode;
import com.cloudeasy.common.Constant;
import com.cloudeasy.dao.ProductCategoryMapper;
import com.cloudeasy.dto.brand.ListProductReqDTO;
import com.cloudeasy.dto.user.ProductCategoryReqDTO;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.ProductCategory;
import com.cloudeasy.model.Tag;
import com.cloudeasy.model.TagRelation;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.CategoryService;
import com.cloudeasy.service.ProductCategoryService;
import com.cloudeasy.service.TagRelationService;
import com.cloudeasy.service.TagService;
import com.cloudeasy.service.brand.DeleteProductService;
import com.cloudeasy.service.brand.GetProductByPkeyService;
import com.cloudeasy.service.brand.IsProductByNameService;
import com.cloudeasy.service.brand.SaveProductService;
import com.cloudeasy.service.brand.SelectAllProductService;
import com.cloudeasy.service.product.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	@Autowired
	protected 	BaseDao 			baseDao;
	
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
	private ProductService		productService;
	
	@Autowired
	private CategoryService		categoryService;
	
	@Autowired
	private ProductCategoryMapper mapper;
	
	@Autowired
	private TagRelationService tagRelationService;
	
	@Autowired
	private TagService tagService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 搜索商品列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{urlS}/list.html")
	public String ShowAllProduct(@PathVariable String urlS,ListProductReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		dto.setTableId(urlS);
		dto.setIsMainProduct(1);
		Result result= selectAllProductService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		model.addAttribute("brandType",urlS);
		return "/product/list";
	}
	
	/**
	 * 搜索商品列表
	 * @param dto
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{urlS}/childProList.html")
	public String ShowAllChildProduct(@PathVariable String urlS,ListProductReqDTO dto,HttpServletRequest request, Model model) throws Exception{
		dto.setTableId(urlS);
		dto.setIsMainProduct(0);
		Result result= selectAllProductService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
//		model.addAttribute("list", findAllSubBrandService.execute(""));
		model.addAttribute("brandType",urlS);
		return "/product/childList";
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
	@RequestMapping("/{urlS}/showEditProduct.html")
	public String showEditProduct(@PathVariable String urlS,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String productId = request.getParameter("id");
		Product product = new Product();
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		String productName = request.getParameter("productName");
		if(StringUtils.isNotBlank(productName)){
			productName = URLDecoder.decode(productName, "UTF-8");
		}
		model.addAttribute("productName", productName);
		if(StringUtils.isNotBlank(productId)){
			Integer id=Integer.valueOf(productId);
			product.setId(id);
			Result result = getProductByPkeyService.execute(product);
			product=(Product)result.getObj();
		}else{
			product.setTableId(urlS);
		}
		model.addAttribute("product",product);
		return "/product/editProduct";
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
	@RequestMapping("/{urlS}/showEditChildProduct.html")
	public String showEditChildProduct(@PathVariable String urlS,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String productId = request.getParameter("id");
		Product product = new Product();
		model.addAttribute("pageNumber",request.getParameter("pageNumber"));
		String productName = request.getParameter("productName");
		if(StringUtils.isNotBlank(productName)){
			productName = URLDecoder.decode(productName, "UTF-8");
		}
		model.addAttribute("productName", productName);
		if(StringUtils.isNotBlank(productId)){
			Integer id=Integer.valueOf(productId);
			product.setId(id);
			Result result = getProductByPkeyService.execute(product);
			product=(Product)result.getObj();
		}else{
			product.setTableId(urlS);
		}
		ListProductReqDTO dto = new ListProductReqDTO();
		dto.setTableId(urlS);
		dto.setIsMainProduct(1);
		Result proList = selectAllProductService.execute(dto);
		model.addAttribute("dto", proList.getBaseDTO());
		model.addAttribute("product",product);
		return "/product/editChildProduct";
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
//		Integer count=(Integer)result.getObj();
		if(null!=result.getObj()&&(Integer)result.getObj()>0&&null!=product&&product.getId()==null){
			super.sendFailureMessage(response,"", "商品名称已存在！");
		}else{
		 result = saveProductService.execute(product);
		 if (result.getStatus().equals("0")) {
			 	Map params=new HashMap();
			 	params.put("type", Constant.TAG_RELATION_PRODUCT);
			 	params.put("relationId", product.getId());
			 	tagRelationService.deleteByRelationId(params);
				String tags=product.getTags();
				String [] tagIds=tags.split(",");			
				for(String tagId :tagIds){
					if(StringUtils.isNotBlank(tagId)){
						TagRelation tr=new TagRelation();
						tr.setRelationId(product.getMainProductId());
						tr.setTagId(Integer.parseInt(tagId));
						tr.setType(Constant.TAG_RELATION_PRODUCT);
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
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/remove.html")
	public void removeProduct(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
		product.setCreateUser(super.getLoginUser(request).getUsername());
		product.setFlag(super.getUrlFlag(request));
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductId(product.getId());
		int count = mapper.deleteByProductCategory(productCategory);
		Result result = deleteProductService.execute(product);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
	
	/**
     * 删除Brand
     * @param brand
     * @param request
     * @param response
     * @throws Exception
     */
	@RequestMapping("/removeProducts.html")
	public void removeProducts(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String productIds = request.getParameter("ids");
		System.out.println("productIds:"+productIds);
		DynamicDBValues dy = baseDao.createDBValues();
		dy.put("productIds", productIds);
		String[] productIdArr = productIds.split(",");
		int count =0;
		for (int i=0;i<productIdArr.length;i++) {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setProductId(Integer.parseInt(productIdArr[i]));
			mapper.deleteByProductCategory(productCategory);
			Product delProduct = new Product();
			delProduct.setId(Integer.parseInt(productIdArr[i]));
			delProduct.setCreateUser(super.getLoginUser(request).getUsername());
			delProduct.setFlag(super.getUrlFlag(request));
			Result result = deleteProductService.execute(delProduct);
			if (result.getStatus().equals("0")) {
				count+=1;
			}
		}
		if (count==productIdArr.length) {
			super.sendSuccessMessage(response,"", "删除成功");
		} else {
			super.sendFailureMessage(response,"", "删除失败");
		}
	}
	
	
	@RequestMapping("/{urlS}/assignedCategory.html")
	public String getAllMenus(@PathVariable String urlS,@RequestParam Integer id,HttpServletRequest request, Model model) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", super.getUrlFlag(request));
		map.put("productId", id);
		map.put("brandType",urlS);
		Map<String, List<Category>> resultMap = categoryService.getCategoryMaps(map);
		
		List<Category> list = resultMap.get("list");
		List<Category> chooseList = resultMap.get("chooseList");
		
		Set<Integer> choosedSet = new HashSet<Integer>();//选中的列表
		for (Category r : chooseList) {
			choosedSet.add(r.getId());
		}
		
		List<TreeNode> treeList = TreeNode.getTreeNodesByCategory(list,choosedSet);
		model.addAttribute("menuList", treeList);
		
		Product p = productService.getProductById(id);
		model.addAttribute("product", p);
		
		model.addAttribute("brandType",urlS);
		
		return "/category/assignedCategory";
	}
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping("/saveRelatedCates.html")
	public void saveResources(@RequestBody ProductCategoryReqDTO reqDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = productCategoryService.save(reqDto);
		if (result.getStatus().equals("0")) {
			super.sendSuccessMessage(response,"","保存成功");
		} else {
			super.sendFailureMessage(response,"","保存失败");
		}
	}
	
}
