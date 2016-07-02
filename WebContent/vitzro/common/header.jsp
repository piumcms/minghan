<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="header_bg">
	<div class="container">
		<div class="header">
			<div class="logo">
				<a class="logofancy" href="${ctx}/index.html"><img src="${ctx}/vitzro/images/logo.png" alt=""/></a>
	            <a class="homefancy" href="${ctx}/index.html"><img src="${ctx}/vitzro/images/home.png" alt=""/></a>
			</div>
			<div class="h_menu">
				<a id="touch-menu" class="mobile-menu" href="#">Menu</a>
				<nav>
					<ul class="menu list-unstyled">
						<li><a href="#">新闻资讯</a>
			            <ul class="sub-menu list-unstyled">
							<li><a href="${ctx}/vitzro/news.html?category=cnews">公司新闻</a></li>
							<li><a href="${ctx}/vitzro/news.html?category=inews">行业新闻</a></li>
						</ul>
			            </li>
						<li><a href="#">产品中心</a>
			            <ul id="header_pc" name="header_pc"  class="sub-menu list-unstyled">
						</ul>
			            </li>
						<li><a href="${ctx}/ec/vitzro/login.html">在线订购</a></li>
						<li><a href="#">关于我们</a>
						<ul class="sub-menu list-unstyled">
							<li><a href="${ctx}/vitzro/about-introduction.html">公司简介</a></li>
							<li><a href="${ctx}/vitzro/about-culture.html">企业文化</a></li>
							<li><a href="${ctx}/honor/vitzro/honors.html">企业荣誉</a></li>
			                <li><a href="${ctx}/vitzro/about-recruitment.html">人力资源</a></li>
						</ul>
						</li>
						<li><a href="${ctx}/vitzro/news.html?category=projects">工程案例</a></li>
						<li><a href="${ctx}/vitzro/about-contactUs.html">联系我们</a></li>
					</ul>
				</nav>
				<script src="${ctx}/vitzro/js/menu.js" type="text/javascript"></script>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
