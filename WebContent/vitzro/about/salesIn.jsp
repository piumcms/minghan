<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<title><spring:message code="zkmed.index"/>|<spring:message code="zkmed.service.salesIn"/></title>
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
			$("div.menu>a").eq(3).attr("class","curr_menu");
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
    	<div class="left_tit"><h2><spring:message code="zkmed.index.serviceCentre"/></h2></div>
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
                	<div class="menu_items_handel"><a href="${ctx}/zkmed/about-salesIn.html" style="color:#90c320"><spring:message code="zkmed.service.salesIn"/></a></div>
                </div>
                <div class="menu_items">
                	<div class="menu_items_handel"><a href="${ctx}/zkmed/about-salesOut.html"><spring:message code="zkmed.service.salesOut"/></a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="fr right">
    	<div class="url tr"> <a href="${ctx}/index.html?locale=${language}"><spring:message code="zkmed.index.index"></spring:message></a> &gt; <a href="${ctx}/zkmed/about-salesIn.html"><spring:message code="zkmed.index.serviceCentre"/></a> &gt; <a class="curr_url" href="javascript:;"><spring:message code="zkmed.service.salesIn"/></a></div>
        
        <div class="right_tit"><h2><span><spring:message code="zkmed.index.serviceCentre"/></span><spring:message code="zkmed.service.salesIn"/></h2></div>
        
        <div class="right_info">
        	<div class="services tc">
            	<img src="${ctx}/imgs/temp/svices.png" alt=""/>
            </div>
        </div>
        
    </div>
    <div class="cl"></div>
</div>
    
<%@ include file="/common/footer.jsp" %>
</body>
</html>