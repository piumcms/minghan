/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.jmesa.view.html.HtmlBuilder;

import com.cloudeasy.utils.Constants;

/**
 * @Title: PagerTag
 * @Description: TODO
 * @author HXJ
 * @date 2013-9-6 上午8:30:39
 * @version V1.0
 */
public class PagerTag extends TagSupport {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private String currentPage;

	/**
	 * 总记录数
	 */
	private String allPage;

	/**
	 * 样式
	 */
	private String style;

	/**
	 * 样式名
	 */
	private String className;

	/**
	 * 每页多数记录
	 */
	private String recordCount;

	/**
	 * 编号
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 当前选中标签样式名
	 */
	private String curClass;

	/**
	 * 当前选中标签样式
	 */
	private String curStyle;
	
	/**
	 * 上下页标签名
	 */
	private String preNextClass;
	
	/**
	 * 上下页标签样式
	 */
	private String preNextStyle;
	
	/**
	 * 省略号样式名
	 */
	private String elipClass;
	
	/**
	 * 省略号样式
	 */
	private String elipStyle;
	
	/**
	 * 输入框样式名
	 */
	private String inputClass;
	
	/**
	 * 输入框样式
	 */
	private String inputStyle;
	
	/**
	 * 点击事件
	 */
	private String onClick;
	
	/**
	 * go按钮click事件
	 */
	private String goClick;
	
	/**
	 * @return id
	 */

	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return currentPage
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            要设置的 currentPage
	 */
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return allPage
	 */

	public String getAllPage() {
		return allPage;
	}

	/**
	 * @param allPage
	 *            要设置的 allPage
	 */
	public void setAllPage(String allPage) {
		this.allPage = allPage;
	}

	/**
	 * @return style
	 */

	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            要设置的 style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return className
	 */

	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            要设置的 className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getCurStyle() {
		return curStyle;
	}

	public void setCurStyle(String curStyle) {
		this.curStyle = curStyle;
	}

	public String getCurClass() {
		return curClass;
	}

	public void setCurClass(String curClass) {
		this.curClass = curClass;
	}

	

	public String getPreNextClass() {
		return preNextClass;
	}

	public void setPreNextClass(String preNextClass) {
		this.preNextClass = preNextClass;
	}

	public String getPreNextStyle() {
		return preNextStyle;
	}

	public void setPreNextStyle(String preNextStyle) {
		this.preNextStyle = preNextStyle;
	}
	
	public String getElipClass() {
		return elipClass;
	}

	public void setElipClass(String elipClass) {
		this.elipClass = elipClass;
	}

	public String getElipStyle() {
		return elipStyle;
	}

	public void setElipStyle(String elipStyle) {
		this.elipStyle = elipStyle;
	}
	
	public String getInputClass() {
		return inputClass;
	}

	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}

	public String getInputStyle() {
		return inputStyle;
	}

	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
	
	public String getGoClick() {
		return goClick;
	}

	public void setGoClick(String goClick) {
		this.goClick = goClick;
	}

	/**
	 * @return recordCount 
	 */
	
	public String getRecordCount() {
		if(recordCount!=null&&!recordCount.equals("")){
			return recordCount;
		}else{
			return "10";
		}
	}

	/** 
	 * @param recordCount 要设置的 recordCount 
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	@Override
	public int doStartTag() throws JspException{
		HtmlBuilder htmlBuilder = new HtmlBuilder();
		
		// 分页标签
		Integer intPage = 0;
		// 总页数/记录数
		Integer aPage = Integer.valueOf(allPage)/Integer.valueOf(recordCount);
		// 求模(总页数%记录数)
		Integer modPage = Integer.valueOf(allPage)%Integer.valueOf(recordCount);
		if(modPage >0){
			intPage =aPage + 1;
		} else{
			intPage = aPage;
		}
		if(currentPage ==null||"".equals(currentPage)){
			currentPage = "1";
		}
		
		Integer curPage = Integer.valueOf(currentPage);
		htmlBuilder.input().type("hidden").id("totalPages").name("totalPages").value(String.valueOf(intPage)).end();
		htmlBuilder.input().type("hidden").id("total").name("total").value(String.valueOf(intPage)).end();
		htmlBuilder.input().type("hidden").id("hidCurPage").name("currentPage").value(String.valueOf(curPage)).end();
		htmlBuilder.append(getPager(intPage, curPage, className, name, id, style,curClass,curStyle,preNextClass,preNextStyle,inputClass,inputStyle,goClick));
		try {
			pageContext.getOut().write(htmlBuilder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	/**
	 * @param text:标签文本
	 * @param className ：样式名
	 * @param style：样式
	 * @param curTag：当前选中标签样式(0:禁用,1:启用)
	 * @param tag:上一页,下一页样式(0:禁用,1：启用)
	 * @param id:编号
	 * @param name：名称
	 * @return
	 */
	public String divTag(String text, String className, String style,
			String curTag, String tag, String id, String name,String curClass,String curStyle,String preNextClass,String preNextStyle,String onClick) {
		HtmlBuilder divHtml = new HtmlBuilder();
		divHtml.span();
		
		// 当前标签被选中时,禁用点击,返回的样式
		if(Constants.ZERO_TAG.equals(curTag)){
			if(curClass != null&&!"".equals(curClass)){
				divHtml.styleClass(curClass);
			}
			if(curStyle !=null&&!"".equals(curStyle)){
				divHtml.style(curStyle);
			}
		}
		// 上一页按钮,下一页按钮禁用时,返回的样式
		else if(Constants.ZERO_TAG.equals(tag)){
			if(preNextClass != null&&!"".equals(preNextClass)){
				divHtml.styleClass(preNextClass);
			}
			if(curStyle !=null&&!"".equals(curStyle)){
				divHtml.style(preNextStyle);
			}
		} else {
			// 样式名
			if (className != null && !"".equals(className)) {
				divHtml.styleClass(className);
			}
			if(style!=null&&!"".equals(style)){
				divHtml.style(style);
			}
			
			if(onClick!=null&&!"".equals(onClick)){
				divHtml.onclick(onClick);
			}
			
		}
		
		// 分页标签Id
		if (id != null && !"".equals(id)) {
			divHtml.id(id+text);
		}
		
		// 分页标签名称
		if (name != null && !"".equals(name)) {
			divHtml.name(name);
		}
		divHtml.close();
		divHtml.append(text).spanEnd();
		return divHtml.toString();
	}

	/**
	 * 返回省略号的样式
	 * 
	 * @param className：样式名
	 * @param style：样式
	 * @return
	 */
	public String ellipsisStyle(String elipClass, String elipStyle, String text) {
		HtmlBuilder htmlEllipsis = new HtmlBuilder();
		htmlEllipsis.span();
		// 样式名
		if(elipClass !=null && !"".equals(elipClass)){
			htmlEllipsis.styleClass(elipClass);
		}
		
		if(elipStyle != null&& !"".equals(elipStyle)){
			htmlEllipsis.style(elipStyle);
		}
		htmlEllipsis.close().append(text).spanEnd();
		return htmlEllipsis.toString();
	}
	
	/**
	 * 分页标签
	 * @param allPage:显示总页数
	 * @param curPage:当前页数
	 * @param className:样式名称
	 * @param name:名称
	 * @param id:标签Id
	 * @param style:样式
	 * @return
	 */
	public String getPager(Integer allPage, Integer curPage, String className,
			String name, String id, String style,String curClass,String curStyle,String preNextClass,String preNextStyle,String inputClass,String inputStyle,String goClick) {
		HtmlBuilder htmlPager = new HtmlBuilder();
		htmlPager.span().styleClass("leftPage").close();
		// 但点击第一页的时候,上一页禁用
		if (Constants.ONE_PAGE.equals(curPage)) {
			htmlPager.append(divTag("<", className, style, "1", "0", id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
		} else {
			htmlPager.append(divTag("<", className, style, "1", "1", id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
		}

		// 当总页数小于14,返回的分页标签显示样式
		if (Constants.FOURTEEN_PAGE > allPage) {
			// 1-总页数的循环标签
			htmlPager.append(outPutHtml(1, allPage+1, className, style, id, name, curPage));
			
			// 当总页数大于14,返回的分页标签显示样式
		} else if (Constants.FOURTEEN_PAGE <= allPage) {
			// 当点击页数不超过7,只有一个末尾的省略号显示
			if (Constants.SEVEN_PAGE >= curPage) {
				htmlPager.append(outPutHtml(Constants.ONE_PAGE, Constants.ELEVEN_PAGE,
						className, style, id, name, curPage));
				htmlPager.append(ellipsisStyle(elipClass, elipStyle, "..."));
				htmlPager.append(outPutHtml(allPage, allPage + 1, className, style, id,
						name, curPage));
				// 总页数-当前页小于7
			} else if ((allPage - curPage) < Constants.SEVEN_PAGE) {
				htmlPager.append(outPutHtml(Constants.ONE_PAGE, Constants.ONE_PAGE + 1,
						className, style, id, name, curPage));
				
				htmlPager.append(ellipsisStyle(elipClass, elipStyle, "..."));
				
				
				htmlPager.append(outPutHtml(allPage - Constants.NINE_PAGE, allPage + 1,
						className, style, id, name, curPage));
				// 总页数-当前页数>4 并且当前页数-1>3
			} else {
				htmlPager.append( outPutHtml(Constants.ONE_PAGE, Constants.ONE_PAGE + 1,
						className, style, id, name, curPage));
				
				htmlPager.append(ellipsisStyle(elipClass, elipStyle, "..."));
				
				
				htmlPager.append(outPutHtml(curPage - 4, curPage + 5, className, style,
						id, name, curPage));
				
				htmlPager.append(ellipsisStyle(elipClass, elipStyle, "..."));
				htmlPager.append(outPutHtml(allPage, allPage + 1, className, style, id,
						name, curPage));
				
			}
		}

		// 当选中最后一页的时候,下一页禁用,非活性
		if (curPage.equals(allPage)) {
			htmlPager.append(divTag(">", className, style, "1", "0", id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
		} else {
			htmlPager.append(divTag(">", className, style, "1", "1", id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
		}
		/*htmlPager.nbsp().input().id("inputVal");
		if (inputClass !=null &&!"".equals(inputClass)){
			htmlPager.styleClass(inputClass);
		}
		
		if (inputStyle != null&&!"".equals(inputStyle)){
			htmlPager.style(inputStyle);
		}
		htmlPager.end().a().styleClass("goClass").close().append("Go").aEnd();*/
		htmlPager.spanEnd();
		return htmlPager.toString();
	}

	/**
	 * 返回1到总页数的样式
	 * 
	 * @param count
	 *            :循环次数
	 * @param className
	 *            :样式名
	 * @param style
	 *            :样式
	 * @param id
	 *            ：标签id
	 * @param name
	 *            ：标签名称
	 * @return
	 */
	public String outPutHtml(Integer start, Integer count, String className,
			String style, String id, String name, Integer curPage) {
		HtmlBuilder htmlOut = new HtmlBuilder();
		// 循环输出所有的分页
		for (int i = start; i < count; i++) {
			// 当前选中页的样式,非活性
			if (i == curPage) {
				htmlOut.append(divTag(String.valueOf(i), className, style, "0", "1",
						id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
				
			} else {// 未被选中页的样式,活性
				htmlOut.append(divTag(String.valueOf(i), className, style, "1", "1",
						id, name,curClass,curStyle,preNextClass,preNextStyle,onClick));
			}
		}
		return htmlOut.toString();
	}
}
