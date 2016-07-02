<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|下载中心</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp" %>
<%@ include file="/vitzro/common/meta.jsp" %>
<link href="${ctx}/vitzro/css/jBootsrapPage.css" rel="stylesheet" />
<script src="${ctx}/vitzro/js/jBootstrapPage.js"></script>
<style type="text/css">
	.pagination{font-weight:bold;}
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp" %>

<!--main-->
<div class="productsbanner"><img src="${ctx}/vitzro/images/download.jpg" width="1140" height="308"/></div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="${ctx}/vitzro/pro.html?pid=90">产品中心</a></li>
		  <li class="active">下载中心</li>
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
     <%--  <div class="asideprocess">
      <c:if test="${not empty f_categories}">
      		<c:forEach var="category" items="${f_categories}">
      			<a href="${ctx}/vitzro/pro.html?pid=${category.id}">${category.name}</a>
      		</c:forEach>
      	</c:if>
      <a class="active" href="#">下载中心</a>
     </div> --%>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336" style="margin-top:0px;">
   </div>
     <!--右侧边-->
       <div class="rightside">
         <div class="biaoqti">
         <h3>下载中心</h3>
         </div>
         <div class="productcontent">
         <div class="wrapper">
            <table class="table table-striped table-bordered table-hover">
   
   <tbody>
   <thead>
     <tr>
       <th>文件名</th>
       <th>操作</th>
     </tr>
   </thead>
     <c:forEach var="item" items="${downloads}" varStatus="status">
	     <tr>
       		<td>
       			${item.title}
       		</td>
       		<td><a href="${item.url}">下载</a></td>
	    </tr>
	</c:forEach>  
   </tbody>
 </table>
        <input type="hidden" id="total" name="total" value="${total}"/>
        <input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>
        <div class="news-pages">
        	<ul class="pagination pagination">

			</ul>   
		</div>
         </div>
         
         </div>
     </div>
   
     
   
   </div>
   <div class="clearboth"></div>
</div>

<!--footer menu-->
<%@ include file="/vitzro/common/menu.jsp" %>
<!-- footer -->
<%@ include file="/vitzro/common/footer.jsp" %>
<script type="text/javascript">
$(function(){
    createPage(10, 6);
    function createPage(pageSize, buttons) {
        $(".pagination").jBootstrapPage({
            pageSize : pageSize,
            total : $("#total").val(),
            selectedIndex :$("#currentPage").val(),
            maxPageButton:buttons,
            onPageClicked: function(obj, pageIndex) {
              window.top.location.href = ctx+"/downcenter/vitzro/download.html?currentPage="+(pageIndex+1);
            }
        });
    }
});
</script>
</body>
</html>