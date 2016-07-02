package com.cloudeasy.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.LocaleResolver;

import com.cloudeasy.exception.LlApplicationException;
import com.cloudeasy.model.User;
import com.cloudeasy.result.Mess;
import com.cloudeasy.result.Message;
import com.cloudeasy.result.Result;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.HtmlUtil;
import com.cloudeasy.utils.SessionUtils;


/**
 * 基类控制器
 * 
 * @Title: BaseController
 * @Description: 提供基类信息
 * @author SEA
 * @date 2013-9-2 下午2:16:32
 * @version V1.0
 */
public class BaseController implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列ID
	 */
	private static final long serialVersionUID = 8423236445501128350L;

	/**
	 * 日志
	 */
	protected static final Logger log = Logger.getLogger("R");
	
	public final static String BRAND_TYPE	= "brandType";
	
	public final static String SUCCESS ="success";  
	
	public final static String MSG ="msg";  
	
	
	public final static String DATA ="data";  
	
	public final static String LOGOUT_FLAG = "logoutFlag";  

	/*
	 * token
	 */
	protected final String TOKEN = "wittc.token";

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	protected LocaleResolver localeResolver;
	

	// 获取保存在Session中的用户对象
	protected String getSessionUsername(HttpServletRequest request)
			throws Exception {
		
		User user = getLoginUser(request);
		if (user != null) {
			return user.getUsername();
		}
		return null;
	}

	/**
	 * 获取的登陆的用户
	 * @param request
	 * @return user
	 * @throws Exception
	 */
	protected User getLoginUser(HttpServletRequest request) {
		return SessionUtils.getUser(request);
	}


	/**
	 * 获取当前用户的IP地址
	 * 
	 * @param request
	 * @return
	 */
	protected String getUserIp(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * get error messages.
	 * 
	 * @param result
	 *            返回结果容器
	 * @param errors
	 *            验证errors
	 */
	protected void getMessages(Result result, Errors errors) {
		List<FieldError> er = errors.getFieldErrors();

		Mess mess = null;
		for (FieldError fieldError : er) {
			mess = new Mess();
			mess.setFieldName(fieldError.getField());
			mess.setMessage(fieldError.getDefaultMessage());
			result.setMessList(mess);
		}
	}

	/**
	 * 获取异常信息。
	 * 
	 * @param result
	 * @param app
	 * @param messageSource
	 */
	protected void getMessagesFromAppException(Result result,
			LlApplicationException app, HttpServletRequest request) {

		if (app.getMessageId() != null) {
			String message = messageSource.getMessage(app.getMessageId(),
					app.getParams(), localeResolver.resolveLocale(request));
			Mess mess = new Mess();
			mess.setMessage(message);
			result.setMessList(mess);
		}
	}

	/**
	 * 获取Message信息。
	 * 
	 * @param result
	 * @param app
	 * @param messageSource
	 */
	protected void getMessagesFromMap(Result result) {

		Map<String, String[]> map = result.getMessage();
		Mess mess = new Mess();
		for (Iterator<Entry<String, String[]>> iter = map.entrySet().iterator(); iter
				.hasNext();) {
			Entry<String, String[]> entry = iter.next();
			mess = new Mess();
			mess.setMessage(messageSource.getMessage(entry.getKey(),
					entry.getValue(), null));
			result.setMessList(mess);
		}
		result.getMessage().clear();
	}

	/**
	 * 获取Message信息。
	 * 
	 * @param result
	 * @param app
	 * @param messageSource
	 */
	protected void getMessagesFromList(Result result) {

		List<Message> list = result.getMessageList();

		for (int i = 0; i < list.size(); i++) {
			Message message = list.get(i);
			Mess mess = new Mess();
			mess.setMessage(messageSource.getMessage(message.getMessageId(),
					message.getParams(), null));
			result.setMessList(mess);
		}
		result.getMessageList().clear();
	}

	/**
	 * 取得上传绝对路径
	 * 
	 * @param request
	 * @return string
	 */
	protected String getUploadPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("/");
	}


	/**
	 * 验证二次提交
	 * 
	 * @return boolean
	 */
	protected boolean validDuplicate(String inputToken,
			HttpServletRequest request) {

		if (inputToken == null) {
			log.warn("token is not valid!inputToken is NULL");
			return false;
		}

		HttpSession session = request.getSession(false);
		
		if (session == null) {
			log.warn("httpSession is NULL");
			return false;
		}
		Object obj = session.getAttribute(TOKEN);

		if (obj == null) {
			log.warn("token is not valid!sessionToken is NULL");
			return false;
		}

		String sessionToken = obj.toString();

		if (!StringUtils.equals(inputToken, sessionToken)) {

			log.warn("token is not valid!inputToken='" + inputToken

			+ "',sessionToken = '" + sessionToken + "'");

			return false;
		}
		return true;
	}

	/**
	 * 成功提交后移除token
	 * 
	 * @param request
	 */
	protected void removeToken(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Object obj = session.getAttribute(TOKEN);

		if (obj != null) {
			session.removeAttribute(TOKEN);
		}
	}
	
	/**
	 *
	 * 提示成功信息
	 *
	 * @param message
	 *
	 */
	public void sendSuccessMessage(HttpServletResponse response, String brandType,String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		result.put(BRAND_TYPE,brandType);
		HtmlUtil.writerJson(response, result);
	}

	/**
	 *
	 * 提示失败信息
	 *
	 * @param message
	 *
	 */
	public void sendFailureMessage(HttpServletResponse response,String brandType,String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		result.put(BRAND_TYPE,brandType);
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 获取当前flag转向
	 * @param request
	 * @return string
	 */
	protected String getUrlFlag(HttpServletRequest request) {
		Object flag = request.getServletContext().getAttribute("url_flag");
		if(flag != null) {
			return flag.toString();
		}
		return "0";
	}
	
	
   protected void initLanguage(HttpServletRequest request){
        String cLocale = request.getParameter("locale");
        Locale currentLocale = localeResolver.resolveLocale(request);
        if(StringUtils.isNotBlank(cLocale)){
            String[] localeStr = cLocale.split("_");
            currentLocale = new Locale(localeStr[0],localeStr[1]);
        }else{
            cLocale = (currentLocale.toLanguageTag()).replace("-","_");
        }
        SessionUtils.setAttr(request, Constants.SELECT_LANGUAGE, cLocale);
    }
}
