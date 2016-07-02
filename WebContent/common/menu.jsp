<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="menu_logo">
	<div class="logo fl"><a href="javascript:;"><img src="${ctx}/imgs/logo.png" alt=""/></a></div>
    <div class="search fr">
    	<input class="s_text" type="text"><input class="s_btn" type="button"/>
    </div>
    <div class="menu fr">
    	<a class="curr_menu" href="${ctx}/index.html?locale=${language}"><spring:message code="zkmed.index.index"/></a>
    	<a href="${ctx}/pro.html"><spring:message code="zkmed.index.allProduct"/></a>
    	<a href="${ctx}/zkmed/news.html"><spring:message code="zkmed.index.news"/></a>
        <a href="${ctx}/zkmed/about-salesIn.html"><spring:message code="zkmed.index.serviceCentre"/></a>
        <a href="${ctx}/zkmed/about-introduction.html"><spring:message code="zkmed.index.aboutUs"/></a>
    </div>
    <div class="cl"></div>
</div>