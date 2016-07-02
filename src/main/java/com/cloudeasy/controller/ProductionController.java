/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dao.CategoryMapper;
import com.cloudeasy.dao.ProductCategoryMapper;
import com.cloudeasy.dao.ProductMapper;
import com.cloudeasy.model.Category;
import com.cloudeasy.model.Product;
import com.cloudeasy.model.ProductCategory;
import com.cloudeasy.mybatis.BaseDao;
import com.cloudeasy.mybatis.DynamicDBValues;
import com.cloudeasy.mybatis.DynamicParameter;
import com.cloudeasy.service.ProductCategoryService;
import com.cloudeasy.service.product.ProductService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.SessionUtils;
import com.cloudeasy.utils.StringUtil;


@Controller
public class ProductionController extends BaseController {

	private static final long serialVersionUID = 6058815121077220120L;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryMapper mapper;
	
	@Autowired
	protected 	BaseDao 			baseDao;

	@Autowired
	private 	CategoryMapper 		categoryMapper;
	
	@Autowired
	private 	ProductMapper 		productMapper;
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/production.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/productList");
//		Result result = getProductByPkeyService.execute(product);
//		product=(Product)result.getObj();
//		model.getParams().put("brandType",)
		String categoryId = request.getParameter("categoryId");
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		model.getParams().put("tableId",urlS);
		model.getParams().put("page", currentPage);
		Map<String,Object> result = productService.findPaginationList(model);
		mv.addObject("result",result);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/productList.html")
	public ModelAndView products(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/productList");
		String categoryId = request.getParameter("categoryId");
		DynamicParameter dy = new DynamicParameter();
		dy.put("categoryId",categoryId);
		List<Product> list = mapper.selectProductByCategory(dy);
		Map<String, Object> result = new HashMap();
		Integer rowCount = mapper.getTotalRows(dy);
		result.put(Constants.TOTAL, rowCount);
		result.put(Constants.LIST, list);
		result.put("categoryName", new String(request.getParameter("categoryName").getBytes("iso-8859-1"),"utf-8"));
	//	result.put("categoryName", request.getParameter("categoryName"));
		request.setAttribute("categoryName", request.getParameter("categoryName"));
		mv.addObject("result",result);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/allProductList.html")
	public ModelAndView productsII(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/allProductList");
		String categoryId = request.getParameter("categoryId");
		DynamicParameter dy = new DynamicParameter();
		dy.put("categoryId",categoryId);
		dy.put("tableId",urlS);
		List<Product> list = mapper.selectProductByCategory(dy);
		Map<String, Object> result = new HashMap();
		Integer rowCount = mapper.getTotalRows(dy);
		result.put(Constants.TOTAL, rowCount);
		result.put(Constants.LIST, list);
		result.put("categoryName", new String(request.getParameter("categoryName").getBytes("iso-8859-1"),"utf-8"));
		//result.put("categoryName", request.getParameter("categoryName"));
		mv.addObject("result",result);
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/proCategory.html")
	public ModelAndView category(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/categoryList");
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/getAllCategorys")
	@ResponseBody
	public List<Category> categorys(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		DynamicDBValues dy = baseDao.createDBValues();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", super.getUrlFlag(request));
		dy.put("brandType",urlS);
		List<Category> list = categoryMapper.findAllCategorys(dy);
		return list;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/getProductByCategoryId")
	@ResponseBody
	public List<Product> productByCategory(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		DynamicDBValues dy = baseDao.createDBValues();
		String categoryId = request.getParameter("categoryId");
		dy.put("categoryId",categoryId);
		List<Product> list = mapper.selectProductByCategory(dy);
		return list;
	}
	
	/**
	 * 获取所有的父类别集合
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/getParentCategorys")
	@ResponseBody
	public List<Category> getParentCategorys(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		DynamicDBValues dy = baseDao.createDBValues();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", super.getUrlFlag(request));
		dy.put("brandType",urlS);
		dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
		dy.put("parentid","0");
		List<Category> list = categoryMapper.findAllCategorys(dy);
		return list;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getProductsByCategory")
	@ResponseBody
	public List<Product> getProducts(HttpServletRequest request,DataGridModel model) throws Exception {
		String categoryId = request.getParameter("categoryId");
		DynamicParameter dy = new DynamicParameter();
		dy.put("categoryId",categoryId);
		List<Product> list = mapper.selectProductByCategory(dy);
		return list;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/getProductByMainProductId")
	@ResponseBody
	public List<Product> productByMainProduct(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		DynamicDBValues dy = baseDao.createDBValues();
		String mainProductId = request.getParameter("mainProductId");
		dy.put("mainProductId",mainProductId);
		List<Product> list = productMapper.findProductByMainProductId(Integer.parseInt(mainProductId));
		return list;
	}
	
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/productDetail.html")
	public ModelAndView detail(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/productDetail");
		String id = request.getParameter("id");
		String cateName = request.getParameter("cn");
		mv.addObject("categoryName","");
		if(StringUtils.isNotBlank(id)){
			Product product = productService.getProductById(Integer.valueOf(id));
			mv.addObject("product", product);
			List<Map> noteList = new ArrayList<Map>();
			if (StringUtil.isNotEmpty(product.getNoteKey1())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey1(), product.getNoteValue1());
				map.put("noteKey", product.getNoteKey1());
				map.put("noteDesc", product.getNoteDesc1());
				map.put("noteValue", product.getNoteValue1());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey2())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey2(), product.getNoteValue2());
				map.put("noteKey", product.getNoteKey2());
				map.put("noteDesc", product.getNoteDesc2());
				map.put("noteValue", product.getNoteValue2());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey3())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey3(), product.getNoteValue3());
				map.put("noteKey", product.getNoteKey3());
				map.put("noteDesc", product.getNoteDesc3());
				map.put("noteValue", product.getNoteValue3());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey4())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey4(), product.getNoteValue4());
				map.put("noteKey", product.getNoteKey4());
				map.put("noteDesc", product.getNoteDesc4());
				map.put("noteValue", product.getNoteValue4());
				noteList.add(map);
			}
			DynamicParameter dy = new DynamicParameter();
			List<Product> list = null;
			if (product.getMainProductId()!=null && StringUtil.isNotEmpty(product.getMainProductId().toString()) && product.getMainProductId()!=0) {
				//当mainProductId不为空时，表示当前商品是子商品；
				dy.put("mainProductId",product.getMainProductId());
				//dy.put("productId",id);
				list = mapper.selectProductByChildProduct(dy);
			} else {
				//当mainProductId为空时，表示当前商品是主商品；
				dy.put("mainProductId",id);//所有类别
				list = mapper.selectProductByMainProduct(dy);
			}
			mv.addObject("noteList",noteList);
			dy.put("productId",id);//所有类别
			//List<Product> list = mapper.selectProductByCategory(dy);
			mv.addObject("relatedProducts",list);
		//	mv.addObject("categoryName", cateName==null?"":cateName);
			mv.addObject("categoryName", cateName==null?"": new String(cateName.getBytes("iso-8859-1"),"utf-8"));
			request.setAttribute("categoryName", request.getParameter("cn"));
			//request.setAttribute("categoryName",);
		}
		
		return mv;
	}
	
    @Autowired
    private ProductCategoryService  productCategorySerivce;
	//产品列表
    @RequestMapping(value="/{urlS}/pro.html")
    public ModelAndView supermarketPlan(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
        ModelAndView mv = new ModelAndView(urlS+"/pro");
        
        //All Category
        DynamicDBValues dy = baseDao.createDBValues();
        dy.put("brandType",urlS);
        dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        List<Category> list = categoryMapper.findAllCategorys(dy);
        List<Category> parents = new ArrayList<Category>(0);
        Map<Category,List<Category>> groups = new LinkedHashMap<Category,List<Category>>(0);
        if(!org.springframework.util.CollectionUtils.isEmpty(list)){
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                if(c.getParentId()==0){
                    parents.add(c);
                    groups.put(c,new ArrayList<Category>(0));
                    iter.remove();
                }
            }
            
            
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                for(Iterator<Map.Entry<Category,List<Category>>> giter = groups.entrySet().iterator();giter.hasNext();){
                    Map.Entry<Category,List<Category>> entry = giter.next();
                    Category p = entry.getKey();
                    List<Category> cs = entry.getValue();
                    if((c.getParentId()).equals(p.getId())){
                        cs.add(c);
                        iter.remove();
                    }
                }
            }
        }
        
        mv.addObject("categories", list);
        mv.addObject("f_categories",parents);//父类别集合
        
        mv.addObject("groups", groups);
        mv.addObject("cid","");
        mv.addObject("pid","");
        mv.addObject("cName","");
        mv.addObject("pName","");
        Map<String,Object> mp = new HashMap<String,Object>(1);
/*        String id = request.getParameter("id");
        if(StringUtils.isNotBlank(id)){
            mp.put("categoryId", id);
            mv.addObject("cid",id);
            Category category = categoryMapper.selectByPrimaryKey(Integer.valueOf(id));
            mv.addObject("cName",category.getName());
        }*/
        
        String pid = request.getParameter("pid");
        mp.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        mp.put("tableId",urlS);
        Map<Category,List<Product>> results = new LinkedHashMap<Category,List<Product>>(0);
        if(StringUtils.isNotBlank(pid)&&parents.size()>0){
            mv.addObject("pid",pid);
            Category category = categoryMapper.selectByPrimaryKey(Integer.valueOf(pid));
            if(null!=category){//查询所有子分类对应的产品
            	dy.put("parentid",category.getId());
            	List<Category> categories = categoryMapper.findAllCategorys(dy);
            	for(Category c:categories){
            		mp.put("categoryId",c.getId());
        	        List<Product> products = productCategorySerivce.getProductByCondition(mp);
        	        if(null!=products&&products.size()>0){
        	            for(Product product:products){
        	                product.setShortDesc(HtmlUtil.formatHtml(product.getShortDesc()));
        	            }
        	        }
        	        results.put(c, products);
            	}
                mv.addObject("pName",category.getName());
                mv.addObject("cateId",category.getId());
            }
            
            /*for(Iterator<Entry<Category,List<Category>>> iter = groups.entrySet().iterator();iter.hasNext();){
            	Entry<Category,List<Category>> entry = iter.next();
            	Category p = entry.getKey();
            	if((p.getId()).equals(pid)){
            		List<Category> l = entry.getValue();
            		for(Category c:l){
            			mp.put("categoryId",c.getId());
            	        List<Product> products = productCategorySerivce.getProductByCondition(mp);
            	        if(null!=products&&products.size()>0){
            	            for(Product product:products){
            	                product.setShortDesc(HtmlUtil.formatHtml(product.getShortDesc()));
            	            }
            	        }
            	        results.put(p, products);
            		}
            	}
            }*/
            
            /*for(Category p:parents){
            	mp.put("categoryId",p.getId());
    	        List<Product> products = productCategorySerivce.getProductByCondition(mp);
    	        if(null!=products&&products.size()>0){
    	            for(Product product:products){
    	                product.setShortDesc(HtmlUtil.formatHtml(product.getShortDesc()));
    	            }
    	        }
    	        results.put(p, products);
            }*/
            
            //只有一个级别
            /*mp.put("categoryId",pid);
	        List<Product> products = productCategorySerivce.getProductByCondition(mp);
	        if(null!=products&&products.size()>0){
	            for(Product product:products){
	                product.setShortDesc(HtmlUtil.formatHtml(product.getShortDesc()));
	            }
	        }
	        results.put(category, products);*/
            
        }
        mv.addObject("products", (null!=results&&results.size()>0)?results:null);
        return mv;
    }
    
    //产品
    @RequestMapping(value="/{urlS}/pro_detail.html")
    public ModelAndView supermarketDetails(HttpServletRequest request,@PathVariable String urlS,Model model) throws Exception {
        ModelAndView mv = new ModelAndView(urlS+"/pro_detail");
        
      //All Category
        DynamicDBValues dy = baseDao.createDBValues();
        dy.put("brandType",urlS);
        dy.put("language",SessionUtils.getAttrStr(request,Constants.SELECT_LANGUAGE));
        List<Category> list = categoryMapper.findAllCategorys(dy);
        List<Category> parents = new ArrayList<Category>(0);
        Map<Category,List<Category>> groups = new LinkedHashMap<Category,List<Category>>(0);
        if(!org.springframework.util.CollectionUtils.isEmpty(list)){
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                if(c.getParentId()==0){
                    parents.add(c);
                    groups.put(c,new ArrayList<Category>(0));
                    iter.remove();
                }
            }
            
            
            for(Iterator<Category> iter = list.iterator();iter.hasNext();){
                Category c = iter.next();
                for(Iterator<Map.Entry<Category,List<Category>>> giter = groups.entrySet().iterator();giter.hasNext();){
                    Map.Entry<Category,List<Category>> entry = giter.next();
                    Category p = entry.getKey();
                    List<Category> cs = entry.getValue();
                    if((c.getParentId()).equals(p.getId())){
                        cs.add(c);
                        iter.remove();
                    }
                }
            }
        }
        
        mv.addObject("categories", list);
        mv.addObject("groups", groups);
        mv.addObject("f_categories",parents);//父类别集合
        String pId = request.getParameter("id");
        String cId = request.getParameter("cid");
        if(cId==null){
        	dy.put("parent_id", "0");
        	dy.put("productId", pId);
            List<Category> list_ = mapper.selectCategoryByProduct(dy);
            System.out.println("---------------"+list_);
            mv.addObject("cName", list_.get(0).getName());
            mv.addObject("categoreId", list_.get(0).getId());

        }else{
        	Category cg=categoryMapper.selectByPrimaryKey(Integer.parseInt(cId));
        
        	mv.addObject("cName", cg.getName());
        }
        //
        
        if(StringUtils.isNotBlank(pId)){
            Product product = productMapper.selectByPrimaryKey(Integer.valueOf(pId));
            mv.addObject("product",product);
            
            List<Map> noteList = new ArrayList<Map>(4);
			if (StringUtil.isNotEmpty(product.getNoteKey1())) {//介绍
				Map map = new HashMap();
				//map.put(product.getNoteKey1(), product.getNoteValue1());
				map.put("noteKey", product.getNoteKey1());
				map.put("noteDesc", product.getNoteDesc1());
				map.put("noteValue", product.getNoteValue1());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey2())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey2(), product.getNoteValue2());
				map.put("noteKey", product.getNoteKey2());
				map.put("noteDesc", product.getNoteDesc2());
				map.put("noteValue", product.getNoteValue2());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey3())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey3(), product.getNoteValue3());
				map.put("noteKey", product.getNoteKey3());
				map.put("noteDesc", product.getNoteDesc3());
				map.put("noteValue", product.getNoteValue3());
				noteList.add(map);
			}
			if (StringUtil.isNotEmpty(product.getNoteKey4())) {
				Map map = new HashMap();
				//map.put(product.getNoteKey4(), product.getNoteValue4());
				map.put("noteKey", product.getNoteKey4());
				map.put("noteDesc", product.getNoteDesc4());
				map.put("noteValue", product.getNoteValue4());
				noteList.add(map);
			}
			mv.addObject("noteList",noteList);
        }
        
        return mv;
    }
}
