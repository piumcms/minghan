<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|产品详细</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp"%>
<%@ include file="/vitzro/common/meta.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp"%>

	<!--main-->
	<div class="productsbanner">
		<img src="${ctx}/vitzro/images/product-01.png" width="1140"
			height="308">
	</div>

	<div class="proaduct">

		<div class="main_grid1qqq navpro">
			<ol class="breadcrumb pull-right111">
				<li><a href="${ctx}/index.html">首页</a></li>
				<li><a href="${ctx}/vitzro/pro.html?pid=90">产品中心</a></li>
				<li class="active">${cName}</li>
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
			      				<c:when test="${pageContext.request.parameterMap.cid[0]==category.id||categoreId==category.id}">
			      					<a class="active" href="${ctx}/vitzro/pro.html?pid=${category.id}">${category.name}</a>
			      				</c:when>
			      				<c:otherwise>
			      					<a href="${ctx}/vitzro/pro.html?pid=${category.id}">${category.name}</a>
			      				</c:otherwise>
			      			</c:choose>
			      		</c:forEach>
			      	</c:if>
				</div>
				<img src="${ctx}/vitzro/images/products-07.png" width="212"
					height="336">
			</div>
			<!--右侧边-->
			<div class="rightside blue">
				<div class="tabfloatleft">
					<h3>${product.productName}</h3>
					<ul class="nav nav-tabs" id="myTab">
						<c:if test="${not empty noteList}">
	                		<c:forEach var="note" items="${noteList}" varStatus="status">
	                			<c:set value="" var="noteKey" />
			                    <c:set value="" var="noteDesc" />
			                    <c:set value="" var="noteValue" />
			                    <c:forEach var="entry" items="${note}">
							    	<c:choose>
										<c:when test="${entry.key=='noteKey' }">
											<c:set value="${entry.value }" var="noteKey" />
										</c:when>
										<c:when test="${entry.key=='noteDesc' }">
											<c:set value="${entry.value }" var="noteDesc" />
										</c:when>
										<c:otherwise>
											<c:set value="${entry.value }" var="noteValue" />
										</c:otherwise>
				            		</c:choose>
							    </c:forEach>
	                			<c:choose>
		            				<c:when test="${status.index==0 }">
		            					<li class="active"><a href="#home">${noteKey}</a></li>
		            				</c:when>
		            				<c:when test="${status.index==1 }">
		            					<li><a href="#profile">${noteKey}</a></li>
		            				</c:when>
		            				<c:when test="${status.index==2 }">
		            					<li><a href="#messages">${noteKey}</a></li>
		            				</c:when>
		            				<c:otherwise>
		            					<li><a href="#others">${noteKey}</a></li>
		            				</c:otherwise>
	            				</c:choose>
		                	</c:forEach>
	                	</c:if>
					</ul>
				</div>

				<div class="tab-content">
					<c:if test="${not empty noteList}">
	               		<c:forEach var="note" items="${noteList}" varStatus="status">
	               			<c:set value="" var="noteKey" />
		                    <c:set value="" var="noteDesc" />
		                    <c:set value="" var="noteValue" />
		                    <c:forEach var="entry" items="${note}">
						    	<c:choose>
									<c:when test="${entry.key=='noteKey' }">
										<c:set value="${entry.value }" var="noteKey" />
									</c:when>
									<c:when test="${entry.key=='noteDesc' }">
										<c:set value="${entry.value }" var="noteDesc" />
									</c:when>
									<c:otherwise>
										<c:set value="${entry.value }" var="noteValue" />
									</c:otherwise>
			            		</c:choose>
						    </c:forEach>
	               			<c:choose>
	            				<c:when test="${status.index==0 }">
	            					<div class="tab-pane active" id="home">
										${noteValue}
									</div>
	            				</c:when>
	            				<c:when test="${status.index==1 }">
	            					<div class="tab-pane" id="profile">${noteValue}</div>
	            				</c:when>
	            				<c:when test="${status.index==2 }">
	            					<div class="tab-pane" id="messages">${noteValue}</div>
	            				</c:when>
	            				<c:otherwise>
	            					<div class="tab-pane" id="others">${noteValue}</div>
	            				</c:otherwise>
            				</c:choose>
	                	</c:forEach>
	               	</c:if>
				</div>

				<script>
					$(function() {
						$('#myTab a:first').tab('show');//初始化显示哪个tab

						$('#myTab a').click(function(e) {
							e.preventDefault();//阻止a链接的跳转行为
							$(this).tab('show');//显示当前选中的链接及关联的content
						})
					})
				</script>
				<div class="tabfloatright">
					<button class="btn btn-default" type="button" data-toggle="modal"
						data-target=".bs-example-modal-lg">放大图片</button>
					<div class="modal fade bs-example-modal-lg" tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title">图片放大</h4>
								</div>
								<div class="modal-body">
									<%-- <img src="${ctx}/vitzro/images/s5.jpg" width="680" height="480"> --%>
									<img src="${product.picSrc}" 
										alt="${product.productName}" title="${product.productName}" 
										 width="680" height="480"/>
								</div>
								<div class="modal-footer">
									<button type="button" class="btnfancy btn-default"
										data-dismiss="modal">关闭</button>

								</div>
							</div>
						</div>
					</div>
					<!--<div class="proaductsimgsize">-->
					<img src="${product.picSrc}" 
						alt="${product.productName}" title="${product.productName}" 
						width="122" height="86"/>
					<!-- </div>-->
				</div>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearboth"></div>
	</div>
	<!--footer menu-->
	<%@ include file="/vitzro/common/menu.jsp"%>
	<!-- footer -->
	<%@ include file="/vitzro/common/footer.jsp"%>

</body>
</html>