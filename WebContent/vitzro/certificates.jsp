<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>企业荣誉|无锡飞世龙机电有限公司</title>
<%@ include file="/vitzro/common/taglibs.jsp"%>
<%@ include file="/vitzro/common/meta.jsp"%>
</head>
<!-- <script src="${ctx}/js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>  -->
<!-- <link rel="stylesheet" href="${ctx}/css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" /> 
<script type="text/javascript">
jQuery(document).ready(function() {
	
	function uplightbox() {
	
	jQuery("a[rel^='prettyPhoto']").prettyPhoto({
	animationSpeed:'slow',
	slideshow:5000,
	theme:'light_square',
	show_title:false,  //显示a 标签中 title里的内容
	overlay_gallery: false //把整个照片组排在照片下方
	});
	
	}
	
	if(jQuery().prettyPhoto) {
	
	uplightbox(); 
	
	}

});

</script> -->
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp"%>

	<!--main-->
	<div class="productsbanner">
		<img src="${ctx}/vitzro/images/about-us.jpg" width="1140" height="308" />
	</div>

	<div class="proaduct">

		<div class="main_grid1qqq navpro">
			<ol class="breadcrumb pull-right111">
				<li><a href="${ctx}/index.html">首页</a></li>
				<li><a href="#">关于我们</a></li>
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
				<div class="tabfloatleft">
					<h3>企业荣誉证书</h3>
					<ul class="nav nav-tabs" id="myTab">
						<li class="active"><a href="#patent">专利证书</a></li>
						<li><a href="#authentication">认证证书</a></li>
						<li><a href="#collect">采标证明</a></li>
						<li><a href="#high_quality">高品证书</a></li>
						<li><a href="#c3">3C证书</a></li>
					</ul>
				</div>

				<div class="tab-content">
					<div class="tab-pane active" id="patent">
						<c:set var="patents" value="${honors.patent}"></c:set>
						<c:forEach var="patent" items="${patents}">
						<!-- <button class="btnfix btnfix-primary" data-toggle="modal"
								data-target=".bs-example-modal-lg">
								<img class="img-thumbnail" alt="140x140"
									src="${patent.picture}"/>
							</button> 
					<a href="${patent.picture}" target="_blank" class="btn" >
					
					</a>-->	
			<button class="btnfix btnfix-primary" data-toggle="modal"
		data-target=".bs-example-modal-lg"  onclick="window.open('${patent.picture}','_blank')"> 
		<img src="${patent.picture}" alt="140x140" class="img-thumbnail" />
		</button> 
						</c:forEach>
						
						

						<!-- 弹出框 -->
						<%-- <div class="modal fade bs-example-modal-lg" tabindex="-1"
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
										<img src="${ctx}/vitzro/images/s5.jpg" width="600" height="400">
									</div>
									<div class="modal-footer">
										<button type="button" class="btnfancy btn-default"
											data-dismiss="modal">关闭</button>
									</div>
								</div>
							</div>
						</div> --%>
						<!-- 弹出框 -->
					</div>
					<div class="tab-pane" id="authentication">
						<c:set var="authentications" value="${honors.authentication}"></c:set>
						<c:forEach var="authentication" items="${authentications}">
							<!--  <button class="btnfix btnfix-primary" data-toggle="modal"
								data-target=".bs-example-modal-lg">
								<img class="img-thumbnail" alt="140x140"
									src="${authentication.picture}"/>
							</button>
						
					<a href="${authentication.picture}"  target="_blank" class="btn"   >
					<img src="${authentication.picture}" alt="140x140" class="img-thumbnail" />
					</a>	-->	
			<button class="btnfix btnfix-primary" data-toggle="modal"
		data-target=".bs-example-modal-lg"  onclick="window.open('${authentication.picture}','_blank')"> 
		<img src="${authentication.picture}" alt="140x140" class="img-thumbnail" />
		</button> 					
						</c:forEach>
					</div>
					<div class="tab-pane" id="collect">
						<c:set var="collects" value="${honors.collect}"></c:set>
						<c:forEach var="collect" items="${collects}">
							<!-- <button class="btnfix btnfix-primary" data-toggle="modal"
								data-target=".bs-example-modal-lg">
								<img class="img-thumbnail" alt="140x140"
									src="${collect.picture}"/>
							</button> 
							<a href="${collect.picture}"   target="_blank" class="btn"    >
					<img src="${collect.picture}" alt="140x140" class="img-thumbnail" />
					</a>-->		
			<button class="btnfix btnfix-primary" data-toggle="modal"
		data-target=".bs-example-modal-lg"  onclick="window.open('${collect.picture}','_blank')"> 
		<img src="${collect.picture}" alt="140x140" class="img-thumbnail" />
		</button> 				
						</c:forEach>
					</div>
					<div class="tab-pane" id="high_quality">
						<c:set var="high_qualitys" value="${honors.high_quality}"></c:set>
						<c:forEach var="high_quality" items="${high_qualitys}">
							<!-- <button class="btnfix btnfix-primary" data-toggle="modal"
								data-target=".bs-example-modal-lg">
								<img class="img-thumbnail" alt="140x140"
									src="${high_quality.picture}"/>
							</button>
					<a href="${high_quality.picture}" target="_blank" class="btn"   >
					<img src="${high_quality.picture}" alt="140x140" class="img-thumbnail" />
					</a> -->
			<button class="btnfix btnfix-primary" data-toggle="modal"
		data-target=".bs-example-modal-lg"  onclick="window.open('${high_quality.picture}','_blank')"> 
		<img src="${high_quality.picture}" alt="140x140" class="img-thumbnail" />
		</button> 						
						</c:forEach>
					</div>
					<div class="tab-pane" id="c3">
						<c:set var="c3s" value="${honors.c3}"></c:set>
						<c:forEach var="c3" items="${c3s}">
							<!--  <button class="btnfix btnfix-primary" data-toggle="modal"
								data-target=".bs-example-modal-lg">
								<img class="img-thumbnail" alt="140x140"
									src="${c3.picture}"/>
							</button>
					<a href="${c3.picture}" target="_blank"  class="btn"  >
					<img src="${c3.picture}" alt="140x140" class="img-thumbnail" />
					</a>-->
								<button class="btnfix btnfix-primary" data-toggle="modal"
		data-target=".bs-example-modal-lg"  onclick="window.open('${c3.picture}','_blank')"> 
		<img src="${c3.picture}" alt="140x140" class="img-thumbnail" />
		</button> 	
						</c:forEach>
					</div>
				</div>

				<script>
					$(function() {
						$('#myTab a:first').tab('show');//初始化显示哪个tab

						$('#myTab a').click(function(e) {
							e.preventDefault();//阻止a链接的跳转行为
							$(this).tab('show');//显示当前选中的链接及关联的content
						});
					});
				</script>
				<!--<div class="proaductsimgsize">-->

				<!-- </div>-->
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