package com.cloudeasy.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.SessionUtils;

public class I18nInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private LocaleResolver localeResolver;
	/**
	 * 最后执行，可用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * 显示视图前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	    /*String cLocale = request.getParameter("locale");
	    Locale currentLocale = new Locale("zh","CN");
	    if(StringUtils.isNotBlank(cLocale)){
	        String[] localeStr = cLocale.split("_");
	        currentLocale = new Locale(localeStr[0],localeStr[1]);
	    }else{
	        cLocale = "zh_CN";
	    }
	    localeResolver.setLocale(request, response, currentLocale);
	    SessionUtils.setAttr(request, Constants.SELECT_LANGUAGE, cLocale);*/
		super.postHandle(request, response, handler, modelAndView);
	}

}
