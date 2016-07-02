<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|企业荣誉</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp" %>
<%@ include file="/vitzro/common/meta.jsp" %>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp" %>
<!--main-->
<div class="productsbanner">
 <img src="${ctx}/vitzro/images/about-us.jpg" width="1139" height="308"></div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="${ctx}/vitzro/about-introduction.html">关于我们</a></li>
		  <li class="active">企业荣誉</li>
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
      <div class="asideprocess">
      <a href="${ctx}/vitzro/about-introduction.html">公司简介</a>
      <a href="${ctx}/vitzro/about-culture.html">企业文化</a>
      <a class="active" href="#">企业荣誉</a>
      <a href="${ctx}/vitzro/about-recruitment.html">人力资源</a>
     </div>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
   </div>
     <!--右侧边-->
       <div class="rightside blue">
         <div class="aboutus-title">
             <h3>企业荣誉</h3>           
         </div>
          <div class="tab-content aboutline">
            	${about.content}          
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