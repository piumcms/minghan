<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="main_btm">
	<!-- start main_btm -->
	<div class="links"></div>
	<div class="footer_bg">
		<!-- start footer -->
		<div class="container">
			<div class="footer">
				<div class="col-md-444 footer1_of_3">

					<h4>使用手机端网站</h4>
					<div class="f_logo">
						<a href="${ctx}/index.html"><img
							src="${ctx}/vitzro/images/weixinshi.jpg" alt=""/></a>
					</div>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>新闻资讯</h4>
					<ul class="list-unstyled f_list">
						<li><a href="${ctx}/vitzro/news.html?category=cnews">公司新闻</a></li>
						<li><a href="${ctx}/vitzro/news.html?category=inews">行业新闻</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>产品中心</h4>
					<ul id="pc_category" name="pc_category" class="list-unstyled f_list">
					</ul>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>在线订购</h4>
					<ul class="list-unstyled f_list">
						<li><a href="${ctx}/ec/vitzro/login.html">进入订购</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>关于飞世龙</h4>
					<ul class="list-unstyled f_list">
						<li><a href="${ctx}/vitzro/about-introduction.html">公司简介</a></li>
						<li><a href="${ctx}/vitzro/about-culture.html">企业文化</a></li>
						<li><a href="${ctx}/honor/vitzro/honors.html">企业荣誉</a></li>
						<li><a href="${ctx}/vitzro/about-recruitment.html">人力资源</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>工程案例</h4>
					<ul class="list-unstyled f_list">
						<li><a href="${ctx}/vitzro/news.html?category=projects">工程案例</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer1_of_3">
					<h4>联系我们</h4>
					<ul class="list-unstyled f_list">
						<li><a href="${ctx}/vitzro/about-contactUs.html">联系我们</a></li>
					</ul>
				</div>
				<script type="text/javascript">
					$(function(){
						$.ajax({
							type : 'POST',
							url : ctx
									+ '/vitzro/getParentCategorys',
							success : function(result) {
								if(null!=result){
									for(var i=0;i<result.length;i++){
										$("#pc_category").append("<li>"+
											"<a href=\""+ctx+"/vitzro/pro.html?pid="+result[i].id+"\">"+result[i].name+"</a>"
											+"</li>");
										$("#header_pc").append("<li>"+
												"<a href=\""+ctx+"/vitzro/pro.html?pid="+result[i].id+"\">"+result[i].name+"</a>"
												+"</li>");
									}
								}
								$("#pc_category").append("<li><a href='"+ctx+"/downcenter/vitzro/download.html'>下载中心</a></li>");
							}
						});
					});
				</script>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>