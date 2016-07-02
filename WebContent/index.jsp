<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>
<title><spring:message code="zkmed.index"/>|<spring:message code="zkmed.index.index"/></title>
</head>
<body>
<%@ include file="/common/header.jsp" %>
<div class="banner_box">
	
	<%@ include file="/common/menu.jsp" %>    
	
    <div class="banner_info">
    	<h2><spring:message code="zkmed.index.complex.banner"/></h2>
        <p>"帮助患者实现幸福人生"是泽康人毕生的追求</p>
        <p class="b_g">Help patients achieve a happy life ....</p>
        <p class="detail_btn"><a href="${ctx}/zkmed/news.html"><spring:message code="zkmed.index.clickDetails"></spring:message></a></p>
    </div>
    
    <div class="kv_thunb">
    	<c:if test="${not empty piclist }">
       		<c:forEach var="item" items="${piclist}" varStatus="status">
       		 <c:if test="${status.index<4}">
	    		<span class="${status.index==0?'curr_kv':''}"></span>
	    		</c:if>
	    	</c:forEach>
       	</c:if>
    	<!-- <span class="curr_kv"></span><span></span><span></span><span></span> -->
    </div>
    
	<div class="kv_box">
		<c:if test="${not empty piclist }">
    		<c:forEach var="item" items="${piclist}" varStatus="status">
    			<c:if test="${status.index==0}">
    				<a href="${item.url}"><img src="${ctx}/upload/images/image/${item.path}" alt=""/></a>
    			</c:if>
    		</c:forEach>
   		</c:if>
		<!-- <img src="${ctx}/imgs/KV/1.png" alt=""/> -->
	</div>
    <c:forEach var="item" items="${piclist}" varStatus="status">
   	 	<c:if test="${status.index<4}">
    		<input type="hidden" name="hidnPic"  value="${item.path}" />
    		<input type="hidden" name="hidnurl"  value="${item.url}" />
    	</c:if>
    </c:forEach>
    <script type="text/javascript">
		
		var t;
		var n = 0; 
		/* var _kv = ["1.png","2.jpg","3.jpg","4.jpg"];
		var count = _kv.length; */
		
		function showAuto() 
		{ 
			var imgs = $("input[name='hidnPic']");
			var urls = $("input[name='hidnurl']");
			var _banner = new Array();
			var _url = new Array();
			if (imgs) {
				for (var i=0;i<imgs.length;i++) {
					var img = $(imgs).eq(i);
					var url = $(urls).eq(i);
					_banner.push($(img).val());
					_url.push($(url).val());
				}
			} else {
				return;
			}
			
			var count = imgs.length;
			
			$(".kv_thunb span").removeClass("curr_kv");
			$($(".kv_thunb span")[n]).addClass("curr_kv");
			$(".kv_box img").attr("src",ctx+"/upload/images/image/"+_banner[n]);//"${ctx}/imgs/KV/" + _kv[n]
			n = n >= (count-1) ? 0 : n+1 ;
		}

    	$(function(){

			showAuto();
			t = setInterval("showAuto()", 3000); 

			$(".kv_thunb span").click(function(){
				var i = $(this).index(); 
				n = i; 
				clearInterval(t);
				showAuto();
				t = setInterval("showAuto()", 3000); 
				
			});	
			
		});
    </script>
    
</div>
<!-- 产品推荐 -->
<div class="pro_recommend_box">
	<div class="pro_recommend tc">
		<c:if test="${not empty products}">
   			<c:forEach var="product" items="${products}" end="0">
   				<img src="${product.picSrc}" alt="${product.productName}" style="width:144px;height: 101px;"/>
		        <strong><spring:message code="zkmed.index.recommendProducts"></spring:message></strong>
		        <span>${product.productName}</span>
		        <a class="pro_detail" href="${ctx}/pro_detail.html?id=${product.id}"><spring:message code="zkmed.index.viewProducts"></spring:message></a>
   			</c:forEach>
   		</c:if>
    </div>
</div>

<div class="index_box">
	<div class="index_items">
    	<div class="items">
        	<div class="items_tit"><img src="${ctx}/imgs/icon_1.png" alt=""/><span><spring:message code="zkmed.index.news"/></span><em><a href="${ctx}/zkmed/news.html"><img src="${ctx}/imgs/more.png" alt=""/></a></em></div>
            <div class="items_info">
            	<ul class="news_list">
            		
            		<c:if test="${not empty news}">
						<c:forEach var="n" items="${news}">
							<li>
								<a href="${ctx}/zkmed/newsDetail.html?newsId=${n.id}">
									<c:choose>
										<c:when test="${fn:length(n.title) > 17}">
											<c:out value="${fn:substring(n.title, 0, 17)}..." escapeXml="false"/>				
										</c:when>
										<c:otherwise>
											<c:out value="${n.title}" escapeXml="false"/>
										</c:otherwise>
									</c:choose>
								</a>
								<span><fmt:formatDate value="${n.createTime}" type="date" pattern="yyyy.MM.dd"/></span>
							</li>
						</c:forEach>
					</c:if>
                </ul>
            </div>
        </div>
        <div class="items mlr">
        	<div class="items_tit"><img src="${ctx}/imgs/icon_2.png" alt=""/><span><spring:message code="zkmed.index.allProduct"></spring:message></span><em><a href="javascript:;"><img src="${ctx}/imgs/more.png" alt=""/></a></em></div>
            <div class="items_info">
            	<div class="index_pro_list">
            		<c:if test="${not empty categories}">
            			<c:forEach var="category" items="${categories}" end="12">
							<a href="${ctx}/pro.html?id=${category.id}&pid=${category.parentId}">
								<c:choose>
									<c:when test="${language eq 'zh_CN' && fn:length(category.name) > 6}">
										<c:out value="${fn:substring(category.name, 0, 6)}.." escapeXml="false"/>				
									</c:when>
									<c:when test="${language eq 'en_US' && fn:length(category.name) > 11}">
										<c:out value="${fn:substring(category.name, 0, 11)}.." escapeXml="false"/>				
									</c:when>
									<c:otherwise>${category.name}</c:otherwise>
								</c:choose>
							</a>            				
            			</c:forEach>
            		</c:if>
                </div>
            </div>
        </div>
        <div class="items">
        	<div class="items_tit"><img src="${ctx}/imgs/icon_3.png" alt=""/><span><spring:message code="zkmed.index.shortIntro"></spring:message></span><em><a href="${ctx}/zkmed/about-introduction.html"><img src="${ctx}/imgs/more.png" alt=""/></a></em></div>
            <div class="items_info">
            	<p>
	            	<c:if test="${not empty introduction}">
	            		<c:choose>
							<c:when test="${fn:length(introduction.content) > 90}">
								<c:out value="${fn:substring(introduction.content, 0, 90)}..." escapeXml="false"/>				
							</c:when>
							<c:otherwise>
								<c:out value="${introduction.content}" escapeXml="false"/>
							</c:otherwise>
						</c:choose>
	            	</c:if>
            	</p>
            </div>
        </div>
        <div class="cl"></div>
    </div>
    
    <div class="pro_show">
    	<div class="pro_items">
        	<div class="t_left"><img src="${ctx}/imgs/t_left.png" alt=""/></div>
            <div class="pro_scroll">
            	<ul>
            		<c:if test="${not empty products}">
            			<c:forEach var="product" items="${products}">
            				<li><a href="${ctx}/pro_detail.html?id=${product.id}"><img src="${product.picSrc}" alt="${product.productName}" style="width:105px;height: 105px;"/></a></li>
            			</c:forEach>
            		</c:if>
                </ul>
            </div>
            <div class="t_right"><img src="${ctx}/imgs/t_right.png" alt=""/></div>
            
            <script type="text/javascript">
            	$(function(){
					var numb = $(".pro_scroll ul li").length;
					var li_width = 125;
					var last = numb%7; //alert(last);
					
					var run_W = $(".pro_scroll").width();
					var last_run_W = (7-last)*li_width;
					
					$(".pro_scroll ul").width(li_width*numb);
					
					var ul_width = $(".pro_scroll ul").width(); //alert(ul_width);
					var pages = ul_width/run_W;
					
					var count = 1;
					
					var Run_right = function(thumb){
						
						$("." + thumb).click(function(){
								if(count<1){ count=1}; //alert(count);
								if( Math.ceil(pages)-count>1){
									$(".pro_scroll ul").animate({ 
										left: -run_W*count+5,
									  }, 1000 );	
								}else{
									$(".pro_scroll ul").animate({ 
										left: -run_W*(Math.ceil(pages-1))+last_run_W+10,
									  }, 1000 );
								}
								
								count = count < Math.ceil(pages) ? count+1 : Math.ceil(pages);
								return count;
						});	
						
					};
					var Run_left = function(thumb){
						
						$("." + thumb).click(function(){
								//alert(count);
								if(count>1 && count==3){
									$(".pro_scroll ul").animate({ 
										left: -run_W*(count-2)+last_run_W+10,
									  }, 1000 );
								}else if(count>1){
									$(".pro_scroll ul").animate({ 
										left: -run_W*(count-2),
									  }, 1000 );
								}else{
									$(".pro_scroll ul").animate({ 
										left: 0,
									  }, 1000 );	
								}
								
								count = 1 < count < Math.ceil(pages) ? count-1 : 1;
								return count;
						});	
						
					};
					
					Run_right("t_right");
					Run_left("t_left");
					
				});
            </script>
            
        </div>
    </div>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>