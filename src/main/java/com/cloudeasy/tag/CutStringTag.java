/**  
 * Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
 * All right reserved. 
 */
package com.cloudeasy.tag;


import java.io.IOException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jmesa.view.html.HtmlBuilder;


/**
 * @Title: ChooseTag
 * @Description: 截取字符串
 * @author SEA
 * @date 2013-9-4 下午2:59:51
 * @version V1.0
 */
public class CutStringTag extends SimpleTagSupport {

	
	protected PageContext pageContext;
	
	private  String MORE_ZH = "查看更多";
	
	private boolean shutMore;//是否显示more
	
	/**
	 * 分类代号
	 */
	private String code;

	/**
	 * 标签ID
	 */
	private String id;

	/**
	 * 语言
	 */
	private String language;
	

	/**
	 * 标签值
	 */
	private String value;
	
	/**
	 * 中文截取长度
	 */
	private String cnLength;
	
	/**
	 * 英文截取长度
	 */
	private String enLength;

	/**
	 * 链接
	 */
	private String href;
	
	/**
	 * 是否需要省略号
	 */
	private String isEllipsis;

	/**
	 * @return code
	 */

	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(String code) {
		this.code = code;
	}


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
	 * @return value
	 */

	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            要设置的 value
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * @return language 
	 */
	
	public String getLanguage() {
		return language;
	}

	/** 
	 * @param language 要设置的 language 
	 */
	public void setLanguage(String language) {
		this.language = language;
	}


	public PageContext getPageContext() {
		
		return (PageContext)getJspContext();
	}


	public String getCnLength() {
		return cnLength;
	}

	public void setCnLength(String cnLength) {
		this.cnLength = cnLength;
	}

	public String getEnLength() {
		return enLength;
	}

	public void setEnLength(String enLength) {
		this.enLength = enLength;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}



    public boolean isShutMore() {
        return shutMore;
    }

    public void setShutMore(boolean shutMore) {
        this.shutMore = shutMore;
    }
    
    /**
	 * @return isEllipsis 
	 */
	
	public String getIsEllipsis() {
		return isEllipsis;
	}

	/** 
	 * @param isEllipsis 要设置的 isEllipsis 
	 */
	public void setIsEllipsis(String isEllipsis) {
		this.isEllipsis = isEllipsis;
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
		
		// 获取中英文
		
		HtmlBuilder htmlBuilder = new HtmlBuilder();
		if (StringUtils.isNotBlank(value)) {
			if (StringUtils.length(value) > this.getLength(cnLength)) {
			    if(shutMore)
			    {
			        MORE_ZH="";  
			    }
			    value = StringUtils.substring(value, 0, this.getLength(cnLength));
			    htmlBuilder.append(value);
			    if (!StringUtils.equals(isEllipsis, "1")) {
			    	htmlBuilder.append(" ...");
			    }
				
				if (StringUtils.isNotBlank(href)) {
					htmlBuilder.a().href(StringEscapeUtils.escapeHtml4(href)).end();
					htmlBuilder.append(MORE_ZH).aEnd();
				}
				
			} else {
				htmlBuilder.append(value);
			}
			
		}
			
		
		
		out.write(htmlBuilder.toString());
	}
	
	/**
	 * 获取长度
	 * @param l
	 * @return
	 */
	private int getLength(String l) {
		if (StringUtils.isNotBlank(l)) {
			return Integer.parseInt(l);
		} else {
			return 0;
		}
	}
}
