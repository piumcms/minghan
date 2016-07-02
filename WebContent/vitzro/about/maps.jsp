<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<title><spring:message code="zkmed.index"/>| <spring:message code="zkmed.help.maps"/></title>
</head>

<body>
<%@ include file="/common/header.jsp" %>

<div class="temp_banner_box">
	
    <%@ include file="/common/menu.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("div.menu>a").each(function(index){ 
				$(this).removeAttr("class");
			});
			$("div.menu>a").eq(4).attr("class","curr_menu");
		});
	</script>
	
    <div class="temp_banner_info">
    	<h2><spring:message code="zkmed.index.complex.banner"/></h2>
        <p><spring:message code="zkmed.index.banner"/></p>
    </div>

	<div class="kv_box"><img src="${ctx}/imgs/temp/t_2.png" alt=""/></div>

</div>

<div class="temp_area">
	<div class="fl left">
    	<div class="left_tit"><h2><spring:message code="zkmed.sitemaps.navigation"/></h2></div>
        <div class="left_menu">
        	<div class="menu_box">
            	<script type="text/javascript">
                	$(function(){
						$(".menu_items_handel").click(function(){
							$(".menu_items_info").addClass("none");	
							$(this).next(".menu_items_info").removeClass("none");
						});	
					});
                </script>
            	<div class="menu_items">
                	<div class="menu_items_handel"><spring:message code="zkmed.sitemaps.navigation"/></div>
                </div>
            </div>
        </div>
    </div>
    <div class="fr right">
    	<div class="url tr"> <a href="javascript:;"><spring:message code="zkmed.index.index"/></a> &gt; <a href="javascript:;"><spring:message code="zkmed.sitemaps.navigation"/></a></div>
        
        <div class="right_tit"><h2><span><spring:message code="zkmed.sitemaps.navigation"/></span></h2></div>
        
        <div class="right_info">
        	<style type="text/css">
				.sitemap_box{ padding:0 15px;}
            	.sitemap_items h2{ font-size:14px; color:#333; margin:10px 0; background:url(${ctx}/imgs/temp/icon.png) no-repeat 0 center; padding-left:16px;}
				
				.site_menu{ border-bottom:1px dashed #ccc; padding:0px 18px 10px; margin-bottom:15px;}
				.site_menu a{ float:left; display:inline-block; width:22%; background:url(${ctx}/imgs/s_icon.png) no-repeat 0 center; padding-left:15px;}
            </style>
        	<div class="sitemap_box">
            	<div class="sitemap_items">
                	<h2><spring:message code="zkmed.index.index"/></h2>
                	<div class="site_menu">
                		<a href="${ctx}/index.html"><spring:message code="zkmed.index.index"/></a>
                    	<a href="${ctx}/zkmed/about-privacyNorms.html"><spring:message code="zkmed.help.privacy"/></a>
                        <a href="${ctx}/zkmed/about-useSpecification.html"><spring:message code="zkmed.help.specification"/></a>
                        <a href="${ctx}/zkmed/about-maps.html"><spring:message code="zkmed.help.maps"></spring:message></a>
                        <div class="cl"></div>
                    </div>
                </div>
                <div class="sitemap_items">
                	<h2><spring:message code="zkmed.index.allProduct"/></h2>
                    <div class="site_menu">
                    	<a href="${ctx}/pro.html?id=76&pid=50"><spring:message code="zkmed.sitemaps.prokfzlsbl"/></a>
                        <a href="${ctx}/pro.html?id=77&pid=51"><spring:message code="zkmed.sitemaps.proyycbqxl"/></a>
                        <a href="${ctx}/pro.html?id=78&pid=63"><spring:message code="zkmed.sitemaps.prozybjqxl"/></a>
                        <a href="${ctx}/pro.html?id=79&pid=64"><spring:message code="zkmed.sitemaps.prozyzlsbl"/></a>
                        <div class="cl"></div>
                    </div>
                </div>
                <div class="sitemap_items">
                	<h2><spring:message code="zkmed.index.news"/></h2>
                    <div class="site_menu">
                    	<a href="${ctx}/zkmed/news.html"><spring:message code="zkmed.news.industrynews"/></a>
                        <div class="cl"></div>
                    </div>
                </div>
                <div class="sitemap_items">
                	<h2><spring:message code="zkmed.index.serviceCentre"/></h2>
                    <div class="site_menu">
                    	<a href="${ctx}/zkmed/about-salesIn.html"><spring:message code="zkmed.service.salesIn"/></a>
                        <a href="${ctx}/zkmed/about-salesOut.html"><spring:message code="zkmed.service.salesOut"/></a>
                        <div class="cl"></div>
                    </div>
                </div>
                <div class="sitemap_items">
                	<h2><spring:message code="zkmed.help.attentionUs"/></h2>
                    <div class="site_menu">
                        <a href="${ctx}/zkmed/about-introduction.html"><spring:message code="zkmed.index.shortIntro"></spring:message></a><a href="${ctx}/zkmed/about-honor.html"><spring:message code="zkmed.help.honor"/></a>
                        <a href="${ctx}/zkmed/about-recruitment.html"><spring:message code="zkmed.help.recruitment"/></a><a href="${ctx}/zkmed/about-contactUs.html"><spring:message code="zkmed.help.contactUs"/></a>
                        <div class="cl"></div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <div class="cl"></div>
</div>

<%@ include file="/common/footer.jsp" %>

</body>
</html>