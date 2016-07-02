<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|新闻详情</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp" %>
<%@ include file="/vitzro/common/meta.jsp" %>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp" %>

<!--main-->
<div class="productsbanner">
<img src="${ctx}/vitzro/images/newcenter.jpg" width="1140" height="308"> </div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="${ctx}/vitzro/news.html?category=cnews">新闻资讯</a></li>
		  <li class="active">${newsDetail.title}</li>
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
      <div class="asideprocess">
	     <c:choose>
	      	<c:when test="${category=='cnews'}">
	      		<a  class="active" href="${ctx}/vitzro/news.html?category=cnews">公司新闻</a>
	      		<a href="${ctx}/vitzro/news.html?category=inews">行业新闻</a>
	      	</c:when>
	      	<c:otherwise>
	      		<a href="${ctx}/vitzro/news.html?category=cnews">公司新闻</a>
	      		<a class="active" href="${ctx}/vitzro/news.html?category=inews">行业新闻</a>
	      	</c:otherwise>
	      </c:choose>
      </div>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
   </div>
     <!--右侧边-->
       <div class="rightside blue">
			<div class="aboutus-title">
             <h3>${newsDetail.title}</h3>           
         	</div>
          <div class="tab-content aboutline">
          		<c:out value="${newsDetail.content}" escapeXml="false"></c:out>
          </div>
       </div>
       <div class="clearfix"></div>
     </div>
   </div>
   <div class="clearboth"></div>
</div>
<!--footer menu-->
<%@ include file="/vitzro/common/menu.jsp" %>

<!-- footer -->
<%@ include file="/vitzro/common/footer.jsp" %>

</body>
</html>