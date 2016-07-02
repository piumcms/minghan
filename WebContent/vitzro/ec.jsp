<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>在线订购|无锡飞世龙机电有限公司</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp"%>
<%@ include file="/vitzro/common/meta.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp"%>

	<!--main-->
	<div class="productsbanner">
		<img src="${ctx}/vitzro/images/E-commerce_03.jpg" width="1139" height="308" />
	</div>

	<div class="proaduct">

		<div class="main_grid1qqq navpro">
			<ol class="breadcrumb pull-right111">
				<li><a href="${ctx}/index.html">首页</a></li>
				<li><a href="#">在线订购</a></li>
				<li class="active">在线订购</li>
			</ol>
		</div>

	</div>

	<div class="proaductsss">
		<div class="main_gridddd1 asidepro">

			<div class="zuocebian">
				<div class="asideprocess">
					<a class="active" href="#">在线订购</a>
				</div>
				<img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
			</div>
			<!--右侧边-->
			<div class="rightside blue">
				<div class="aboutus-title">
					<h3>在线订购</h3>
				</div>
				<div class="tab-content login">
					<input class="form-control input-lg" type="text" placeholder="用户名">
					<input class="form-control input-lg" type="text" placeholder="密码">
					<button class="btnfan btnfan-primary btn-lg" type="button">登
						录</button>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearboth"></div>
	</div>

	<!--footer-->
	<%@ include file="/vitzro/common/menu.jsp" %>
	<%@ include file="/vitzro/common/footer.jsp" %>

</body>
</html>