<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|产品中心</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp" %>
<%@ include file="/vitzro/common/meta.jsp" %>
</head>
<body>

	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp" %>

<!--main-->
<div class="productsbanner">
<img src="${ctx}/vitzro/images/product-01.png" width="1140" height="308"> </div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="#">产品中心</a></li>
		  <li class="active">${pName}</li>
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
      <div class="asideprocess">
      	<c:if test="${not empty f_categories}">
      		<c:forEach var="category" items="${f_categories}">
      			<c:choose>
      				<c:when test="${pid==category.id}">
      					<a class="active" href="${ctx}/vitzro/pro.html?pid=${category.id}">${category.name}</a>
      				</c:when>
      				<c:otherwise>
      					<a href="${ctx}/vitzro/pro.html?pid=${category.id}">${category.name}</a>
      				</c:otherwise>
      			</c:choose>
      		</c:forEach>
      	</c:if>
     </div>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
   </div>
     <!--右侧边-->
       <div class="rightside">
         <div class="biaoqti">
         	<h3>产品中心</h3>
         </div>
         <div class="productcontent">
         	<c:if test="${not empty products}">
         		<c:forEach var="cp" items="${products}" varStatus="s">
         			<div class="wrapperfloat21">
			            <h2 class="titlehead${s.count}">${cp.key.name}</h2>
			            <c:forEach var="c" items="${cp.value}">
			         		<p><a href="${ctx}/vitzro/pro_detail.html?id=${c.id}&cid=${cateId}">${c.productName}</a></p>
			         	</c:forEach>
		         	</div>
	         	</c:forEach>
         	</c:if>
	         <%-- <div class="wrapper">
		         <div class="wrapperleft">
		         	<c:if test="${not empty products}">
		         		<c:forEach var="cp" items="${products}">
					         <ul class="titlehead">${cp.key.name}
					         	<c:forEach var="c" items="${cp.value}">
					         		<li><a href="${ctx}/vitzro/pro_detail.html?id=${c.id}">${c.productName}</a></li>
					         	</c:forEach>
					         </ul>
			         	</c:forEach>
		         	</c:if>

		         </div>
	         </div> --%>
	         
         </div>
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