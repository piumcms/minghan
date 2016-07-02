/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.tag;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.jmesa.view.html.HtmlBuilder;

import com.cloudeasy.utils.TokenHandler;

/**
 * @Title: 产生token
 * @Description: 产生token
 * @author SEA
 * @date 2013-9-4 下午2:59:51
 * @version V1.0
 */
public class GeneratedTag extends SimpleTagSupport {

	/**
	 * token
	 */
	private final String TOKEN = "wittc.token";
	/**
	 * 上下文
	 */
	protected PageContext pageContext;

	public PageContext getPageContext() {
		
		return (PageContext)getJspContext();
	}


	/**
	 * (非 Javadoc) 解析xml文件,解析标签jsp引擎
	 * 
	 * @throws JspException
	 * @throws IOException
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter out = getJspContext().getOut();
		String uuid = TokenHandler.generateGUID();
		
		HtmlBuilder htmlBuilder = new HtmlBuilder();
		htmlBuilder.input().type("hidden").id("token").name("token").value(uuid);
		htmlBuilder.end();
		HttpServletRequest request = (HttpServletRequest)getPageContext().getRequest();
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute(TOKEN, uuid);
		}
		out.write(htmlBuilder.toString());
		
	}
}
