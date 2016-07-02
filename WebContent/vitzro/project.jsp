<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>工程案例|无锡飞世龙机电有限公司</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp"%>
<link href="${ctx}/vitzro/css/jBootsrapPage.css" rel="stylesheet" />
<%@ include file="/vitzro/common/meta.jsp"%>
<script src="${ctx}/vitzro/js/jBootstrapPage.js"></script>
<style type="text/css">
.pagination {
	font-weight: bold;
}
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp"%>

	<!--main-->
	<div class="productsbanner">
		<img src="${ctx}/vitzro/images/projects.jpg" width="1140" height="308"> 
	</div>

	<div class="proaduct">

		<div class="main_grid1qqq navpro">
			<ol class="breadcrumb pull-right111">
				<li><a href="${ctx}/index.html">首页</a></li>
				<li><a href="#">工程案例</a></li>
				<li class="active">工程案例</li>
			</ol>
		</div>

	</div>

	<div class="proaductsss">
		<div class="main_gridddd1 asidepro">

			<div class="zuocebian">
				<div class="asideprocess">
					<a class="active" href="#">工程案例</a>
				</div>
				<img src="${ctx}/vitzro/images/products-07.png" width="212"
					height="336">
			</div>
			<!--右侧边-->
			<div class="rightside blue">
				<div class="tabfloatleft">
					<h3>工程案例</h3>
				</div>
				<div class="tab-content22">
					<div class="tab-pane active" id="home">
						<!-- 12 -->
						<c:if test="${not empty news}">
							<c:forEach var="item" items="${news}" varStatus="status">
								<div class="gongcheng">
									<!-- TODO -->
									<button class="btnfix btnfix-primary"  type="button" data-toggle="modal"
										data-target="#model${item.id}">
										<img class="img-thumbnail11" alt="140x140"
											src="${item.picture}">
									</button>
									<div class="modal fade bs-example-modal-lg" tabindex="-1"  id="model${item.id}"
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
													<img src="${item.picture}" 
														alt="图挂了" title="谢谢观赏" 
														 width="680" height="480"/>
												</div>
												<div class="modal-footer">
													<button type="button" class="btnfancy btn-default"
														data-dismiss="modal">关闭</button>
				
												</div>
											</div>
										</div>
									</div>
									<p>${item.title}</p>
								</div>
							</c:forEach>
						</c:if>
						<div class="clearboth"></div>
						<input type="hidden" id="total" name="total" value="${total}"/>
				        <input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>
				        <input type="hidden" id="category" name="category" value="${category}"/>
				        <div class="news-pages">
				        	<ul class="pagination">
				
							</ul>   	
						</div>
					</div>
				</div>
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
	<script type="text/javascript">
		$(function() {
			function createPage(pageSize, buttons,total) {
				$(".pagination")
					.jBootstrapPage({
					pageSize : pageSize,
					total : total,
					maxPageButton : buttons,
					onPageClicked : function(obj, pageIndex) {
						$.ajax({
					    	type : 'POST',
							url : ctx+ "/${siteName}/getNewsByAjax-${category}?currentPage="+(pageIndex + 1),
							dataType : 'json',
							contentType : 'application/json',
							success : function(result) {
								$("div.gongcheng").remove();
								var list = result.brandNewsList;
								if(result.brandNewsCount
										&&result.brandNewsCount>0
										&&list.length>0){
									for(var i=0,size=list.length;i<size;i++){
										$("#home").prepend(
											'<div class="gongcheng">'+
												'<button class="btnfix btnfix-primary"  type="button" data-toggle="modal"'+
													'data-target="#model'+list[i].id+'">'+
													'<img class="img-thumbnail11" alt="140x140"'+
														'src="'+list[i].picture+'">'+
												'</button>'+
												'<div class="modal fade bs-example-modal-lg" tabindex="-1"  id="model'+list[i].id+'"'+
													'role="dialog" aria-labelledby="myLargeModalLabel"'+
													'aria-hidden="true">'+
													'<div class="modal-dialog modal-lg">'+
														'<div class="modal-content">'+
															'<div class="modal-header">'+
																'<button type="button" class="close" data-dismiss="modal">'+
																	'<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>'+
																'</button>'+
																'<h4 class="modal-title">图片放大</h4>'+
															'</div>'+
															'<div class="modal-body">'+
																'<img src="'+list[i].picture+'" '+
																	'alt="图挂了" title="谢谢观赏" '+
																	 'width="680" height="480"/>'+
															'</div>'+
															'<div class="modal-footer">'+
																'<button type="button" class="btnfancy btn-default" '+
																	'data-dismiss="modal">关闭</button>'+
															'</div>'+
														'</div>'+
													'</div>'+
												'</div>'+
												'<p>'+list[i].title+'</p>'+
											'</div>');
									}
								}
							}
					    });
					}
				});
			}
			
			createPage(12, 2,$("#total").val());
			
			
		});
		
	</script>

</body>
</html>