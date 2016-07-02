<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>无锡飞世龙机电有限公司|首页</title>
<!-- Bootstrap -->
<%@ include file="/vitzro/common/taglibs.jsp"%>
<%@ include file="/vitzro/common/meta.jsp"%>
</head>
<body>

	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp"%>

	<div id="fwslider">
		<!-- start slider -->
		<div class="slider_container">
			<!-- <div class="slide"> 
            	<img src="${ctx}/vitzro/images/slider1.png">
            </div>
            <div class="slide">
                <img src="${ctx}/vitzro/images/slider2.jpg">
                <div class="slide_contentdia">
                    <div class="slide_content_wrap">
                        <h4 class="title">Lorem ipsum dolor sit amet</h4>
                        <p class="description">Pellentesque non neque egestas libero. Nam sed porta est. Vestibulum id massa eu odio rhoncus eleifend.</p>
                    </div>
                </div>
            </div> -->
			<c:if test="${not empty piclist }">
				<c:forEach var="item" items="${piclist}" varStatus="status">
					<c:if test="${not empty item.path}">
						<div class="slide">
							<img src="${ctx}/upload/images/image/${item.path}" />
						</div>
					</c:if>
				</c:forEach>
			</c:if>
		</div>
		<div class="timers"></div>
		<div class="slidePrev">
			<span></span>
		</div>
		<div class="slideNext">
			<span></span>
		</div>
	</div>
	<!--/slider -->
	<div class="main_bg">
		<!-- start main -->
		<!-- <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
 -->
		<div class="container">
			<div class="main_grid">
				<div class="span_of_4">
					<!-- start span_of_4 -->

					<div class="col-md-3 span1_of_4">
						<div class="span4_of_list">
							<span></span>
							<p><a href="${ctx}/vitzro/news.html?category=cnews">NEWS</a></p>
							<img src="${ctx}/vitzro/images/news.jpg" width="363" height="220">
							<h3><a href="${ctx}/vitzro/news.html?category=cnews">新闻资讯</a></h3>
							<ul class="newslist11">
								<c:if test="${not empty news}">
									<c:forEach var="n" items="${news}">
										<li><a
											href="${ctx}/vitzro/newsDetail.html?newsId=${n.id}"> <c:choose>
													<c:when test="${fn:length(n.title) > 17}">
														<c:out value="${fn:substring(n.title, 0, 17)}..."
															escapeXml="false" />
													</c:when>
													<c:otherwise>
														<c:out value="${n.title}" escapeXml="false" />
													</c:otherwise>
												</c:choose>
										</a></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>
					<div class="col-md-3 span1_of_4">
						<div class="span4_of_list">
							<span></span>
							<p><a href="${ctx}/vitzro/pro.html?pid=90">PRODUCT</a></p>
							<img width="363" height="220"
								src="${ctx}/vitzro/images/product.jpg" />
							<h3><a href="${ctx}/vitzro/pro.html?pid=90">产品中心</a></h3>
							<ul class="newslist11">
								<c:if test="${not empty products}">
									<c:forEach var="product" items="${products}" end="4">
										<li><a
											href="${ctx}/vitzro/pro_detail.html?id=${product.id}">${product.productName}</a></li>
									</c:forEach>
								</c:if>
							</ul>
						</div>
					</div>

					<!--隔断      -->
					<div class="col-md-3 span1_of_4">
						<div class="span4_of_list">
							<span></span>
							<p><a href="${ctx}/vitzro/about-contactUs.html">CONTACT US</a></p>
							<img width="363" height="220"
								src="${ctx}/vitzro/images/contact.jpg">
							<h3><a href="${ctx}/vitzro/about-contactUs.html">联系我们</a></h3>
							<div class="contactus">
								如果您有问题咨询，请联系我们！<br /> 技术支持：13665167595
							</div>
							<img class="contactusimg"
								src="${ctx}/vitzro/images/contactus.png" width="281" height="74">
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!-- end span_of_4 -->
			</div>
		</div>
	</div>

	<!-- start banner -->
<div class="col-sm-6666" style="position:fixed; bottom:0; right:0; z-index:999; display:none;">
      <img class="img-responsive" src="images/advertsiment.png" width="322" height="263">
  </div>
   <script type="text/javascript">
$(document).ready(function(){
    $(".col-sm-6666").show();
    $(".col-sm-6666").animate({bottom:"0"},4000);
    //自动隐藏，时间为5000毫秒
    setTimeout(function(){ $(".col-sm-6666").fadeOut(1000); }, 12000); 
});
</script>
  
	<!-- end banner -->
	</div>
	<div class="main_btm">
		<!-- start main_btm -->
		<div class="container">
			<div class="main span_of_3">
				<div class="col-md-3 span1_of_33fancy">
					<div class="aboutus_vedio">
						<object
							classid="clsid:D27CDB6E-AE6D-11cf-96B8-444第二世界整理发布553540000"
							codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
							width="320" height="320">
							<param name="movie" value="${ctx}/vitzro/Flvplayer.swf" />
							<param name="quality" value="high" />
							<param name="allowFullScreen" value="true" />
							<embed src="${ctx}/vitzro/Flvplayer.swf" allowfullscreen="true"
								flashvars="vcastr_file=media/sc.flv&IsAutoPlay=1&LogoUrl=${ctx}/vitzro/images/logo.jpg"
								quality="high"
								pluginspage="http://www.macromedia.com/go/getflashplayer"
								type="application/x-shockwave-flash" width="320" height="320"></embed>
						</object>

					</div>
					<img src="${ctx}/vitzro/images/creative.png" width="346"
						height="201">
				</div>

				<div class="col-md-3 span1_of_3fancy">
					<h4>关于我们</h4>
					<div class="clients">
						<p style="padding-left: 2px;">
							<c:if test="${not empty introduction}">
								<c:out value="${introduction.content}" escapeXml="false" />
							</c:if>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="links">
			<img src="${ctx}/vitzro/images/links.jpg" width="941" height="66"
				usemap="#Map">
			<map name="Map">
				<area shape="rect" coords="19,10,124,57" href="http://www.vitzrotech.com" target="_blank">
				<area shape="rect" coords="153,15,255,57" href="http://www.vitzrocell.co.kr" target="_blank">
				<area shape="rect" coords="264,13,419,58" href="http://www.vitzromaterials.co.kr" target="_blank">
				<area shape="rect" coords="428,15,532,56" href="http://www.vitzrosys.com" target="_blank">
				<area shape="rect" coords="544,15,672,59" href="http://www.wetech21.co.kr" target="_blank">
				<area shape="rect" coords="682,12,803,58" href="http://www.vitzrocnc.com" target="_blank">
				<area shape="rect" coords="814,10,935,57" href="http://www.vitzromedia.com" target="_blank">
			</map>
		</div>
		<div class="footer_bg">
			<!-- start footer -->
			<div class="container">
				<div class="footer">
					<div class="col-md-444 footer1_of_3">

						<h4>使用手机端网站</h4>
						<div class="f_logo">
							<a href="${ctx}/index.html"><img
								src="${ctx}/vitzro/images/weixinshi.jpg" alt="" /></a>
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
						<ul id="pc_category" name="pc_category"
							class="list-unstyled f_list">
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
							<li><a href="${ctx}/vitzro/about-aboutUs.html">公司简介</a></li>
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
						$(function() {
							$
									.ajax({
										type : 'POST',
										url : ctx
												+ '/vitzro/getParentCategorys',
										success : function(result) {
											if (null != result) {
												for (var i = 0; i < result.length; i++) {
													$("#pc_category")
															.append(
																	"<li>"
																			+ "<a href=\""
																			+ ctx
																			+ "/vitzro/pro.html?pid="
																			+ result[i].id
																			+ "\">"
																			+ result[i].name
																			+ "</a>"
																			+ "</li>");
													$("#header_pc")
															.append(
																	"<li>"
																			+ "<a href=\""
																			+ ctx
																			+ "/vitzro/pro.html?pid="
																			+ result[i].id
																			+ "\">"
																			+ result[i].name
																			+ "</a>"
																			+ "</li>");
												}
											}
											$("#pc_category")
													.append(
															"<li><a href='"+ctx+"/downcenter/vitzro/download.html'>下载中心</a></li>");
										}
									});
						});
					</script>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/vitzro/common/footer.jsp"%>

</body>
</html>