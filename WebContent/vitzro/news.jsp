<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|新闻资讯</title>
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
<div class="productsbanner"><img src="${ctx}/vitzro/images/newcenter.jpg" width="1140" height="308"></div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="#">新闻资讯</a></li>
          <c:choose>
	      	<c:when test="${category=='cnews'}">
	      		 <li class="active">公司新闻</li>
	      	</c:when>
	      	<c:otherwise>
	      		 <li class="active">行业新闻</li>
	      	</c:otherwise>
	      </c:choose>
		 
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
      <div class="asideprocess">
      <c:choose>
      	<c:when test="${category=='cnews'}">
      		<a  class="active" href="#">公司新闻</a>
      		<a href="${ctx}/vitzro/news.html?category=inews">行业新闻</a>
      	</c:when>
      	<c:otherwise>
      		<a href="${ctx}/vitzro/news.html?category=cnews">公司新闻</a>
      		<a class="active" href="#">行业新闻</a>
      	</c:otherwise>
      </c:choose>
      
     </div>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
   </div>
     <!--右侧边-->
       <div class="rightside">
         <div class="biaoqti">
         <h3>新闻资讯</h3>
         </div>
         <div class="productcontent">
         <div class="wrapper">
            <table class="table table-striped table-bordered table-hover">
   
   <tbody>
   	<c:forEach var="item" items="${news}" varStatus="status">
	     <tr>
       		<td>
       			<a href="${ctx}/vitzro/newsDetail.html?newsId=${item.id}&category=${category}">
			    	<c:choose>   
						<c:when test="${fn:length(item.title) > 30}">   
							<c:out value="${fn:substring(item.title, 0, 30)}......" escapeXml="false"/>   
						</c:when>   
						<c:otherwise>   
							<c:out value="${item.title}" escapeXml="false"/>   
						</c:otherwise>  
					</c:choose>
				</a>
       		</td>
       		<td><fmt:formatDate value="${item.createTime}" type="date" pattern="yyyy-MM-dd"/></td>
	    </tr>
	</c:forEach>  
   </tbody>
 </table>
        <input type="hidden" id="total" name="total" value="${total}"/>
        <input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>
        <input type="hidden" id="category" name="category" value="${category}"/>
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
              window.top.location.href = ctx+"/vitzro/news.html?currentPage="+(pageIndex+1)+"&category="+$("#category").val();
            }
        });
    }
});
</script>
</body>
</html>