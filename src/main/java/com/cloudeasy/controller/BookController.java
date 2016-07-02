/**  
* Copyright(c)2013 Wuxi Ll Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.common.DataGridModel;
import com.cloudeasy.dto.innovate.ListQuesReqDTO;
import com.cloudeasy.dto.innovate.ListQuesResDTO;
import com.cloudeasy.model.BrandNews;
import com.cloudeasy.model.QuesAnsw;
import com.cloudeasy.model.BrandNews.BrandNewsType;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.innovate.ListQuesService;
import com.cloudeasy.service.product.ProductService;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.StringUtil;
import com.cloudeasy.utils.Constants.BrandType;


@Controller
public class BookController extends BaseController {

	private static final long serialVersionUID = 6058815121077220120L;
	
	@Autowired
	private ListQuesService listQuesService;
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{urlS}/book.html")
	public ModelAndView index(HttpServletRequest request,@PathVariable String urlS,DataGridModel model) throws Exception {
		ModelAndView mv = new ModelAndView(urlS+"/book");
		String indexSeq = request.getParameter("indexSeq");
		int pageSize = 5;
		if(StringUtils.isNotBlank(indexSeq)&&indexSeq.equals("1")){//判断是否首页
			pageSize = Integer.valueOf(Constants.NEWS_OFFSET);
		}
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		ListQuesReqDTO dto = new ListQuesReqDTO();
		dto.setFlag(super.getUrlFlag(request));
		dto.setPageNumber(currentPage);
		dto.setRows(pageSize);
		Result result = listQuesService.execute(dto);
		Integer pageAmount = (dto.getPager().getRowCount()-1)/pageSize+1;
		mv.addObject("pageAmount", pageAmount);
		mv.addObject("currentPage", currentPage);
		mv.addObject("dto", result.getBaseDTO());
		
		return mv;
	}
	
	/**
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getBooksByAjax")
	@ResponseBody
	public List<QuesAnsw> getNews(HttpServletRequest request,DataGridModel model) throws Exception {
		int pageSize = 5;
		Integer currentPage = StringUtil.isEmpty(request.getParameter("currentPage"))?1:Integer.valueOf(request.getParameter("currentPage"));
		ListQuesReqDTO dto = new ListQuesReqDTO();
		dto.setFlag(super.getUrlFlag(request));
		dto.setPageNumber(currentPage);
		dto.setRows(pageSize);
		Result result = listQuesService.execute(dto);
		ListQuesResDTO resultDto = (ListQuesResDTO)result.getBaseDTO();
		return resultDto.getList();
	}
}
