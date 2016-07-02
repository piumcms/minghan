/**
 * Copyright(c)2012 Beijing PeaceMap Co.,Ltd.
 * All right reserved. 
 */
package com.wittc.servlet;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;

import common.Logger;

/**
 * 
 * @Title: InitSubject 
 * @Description: TODO
 * @author ZDH
 * @date 2013-9-6 下午5:44:52 
 * @version V1.0
 */
public class InitSubject extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
    
	/**
	 * 初始化日志记录器
	 */
	private Logger log = Logger.getLogger(InitSubject.class);
	
	/**
     * 系统属性文件路径
     */
    //private final String SYSTEM_PROPERTIES = "system.properties";
    
    /**
	 * @return log 
	 */
	
	public Logger getLog() {
		return log;
	}

	/** 
	 * @param log 要设置的 log 
	 */
	public void setLog(Logger log) {
		this.log = log;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public InitSubject() {
        
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		
		//初始化code数据
		Map<String, Map<String, String>> cnNodeMap = new LinkedHashMap<String, Map<String, String>>();
		
		Map<String, Map<String, String>> enNodeMap = new LinkedHashMap<String, Map<String, String>>();
		/**
		 * xml文件路径
		 */
		String path = config.getServletContext().getRealPath("/");
		
		
		try {
			SAXReader reader = new SAXReader();
			
			// 生成文档对应实体
			//初始化中文
			String cnPath = path + "WEB-INF/classes/zh_CN_node.xml";
			Document document = reader.read(new File(cnPath));
			// 获取指定路径下的元素列表,这里指获取指定node下的subcode元素
			@SuppressWarnings("unchecked")
			List<Element> list = document.selectNodes("/parentnode/node");
			List<String> nodeList = new ArrayList<String>();
			Map<String, String> childMap = null;
			String id = "";
			for (Element e: list) {
				id = e.attributeValue("id");
				@SuppressWarnings("unchecked")
				List<Element> children = e.elements();
				childMap = new LinkedHashMap<String, String>();
				for (Element el : children) {
					childMap.put(el.attributeValue("id"), el.getText());
				}
				cnNodeMap.put(id, childMap);
			}
			config.getServletContext().setAttribute("cnNode", cnNodeMap);
			//初始化英文
			String enPath = path + "WEB-INF/classes/en_US_node.xml";
			document = reader.read(new File(enPath));
			// 获取指定路径下的元素列表,这里指获取指定node下的subcode元素
			@SuppressWarnings("unchecked")
			List<Element> enList = document.selectNodes("/parentnode/node");
			for (Element e: enList) {
				id = e.attributeValue("id");
				@SuppressWarnings("unchecked")
				List<Element> children = e.elements();
				childMap = new LinkedHashMap<String, String>();
				for (Element el : children) {
					childMap.put(el.attributeValue("id"), el.getText());
				}
				enNodeMap.put(id, childMap);
			}
			config.getServletContext().setAttribute("enNode", enNodeMap);
			document = null;
			reader = null;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*config.getServletContext().setAttribute("ab_path", config.getServletContext().getRealPath("/"));
	    log.info("initialize start...");
	    
	    BaseDao  baseDao = (BaseDao) WebApplicationContextUtils.getWebApplicationContext(config.getServletContext()).getBean("baseDao");
//	    config.getServletContext().setAttribute("init_subject", map);
	    log.info("initialize end");
	    log.info("rewrite subject to xml, start...");
	    SchedulerService schedule = (SchedulerService) WebApplicationContextUtils.getWebApplicationContext(config.getServletContext()).getBean("schedulerService");
	  
	    try {
	        // txt文件库路径
	        Properties prop = new Properties();
	        
	        prop.load(this.getClass().getClassLoader().getResourceAsStream(SYSTEM_PROPERTIES));
            
            config.getServletContext().setAttribute("txt_path", prop.getProperty("txt_path"));
            
            config.getServletContext().setAttribute("subject_rate_top", prop.getProperty("subject_rate_top"));
            
            config.getServletContext().setAttribute("subject_rate_top", prop.getProperty("subject_rate_top"));
            
            config.getServletContext().setAttribute("v_flag", prop.getProperty("version_flag"));
            schedule.schedule("0 32 17 ? * *");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.info(StackTraceUtil.getStackTrace(e));
            throw new ServletException(MessageConstants.CONVERT_EXCEPTION);
        }*/
	}

}
