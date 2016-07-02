<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="link tc"><a href="${ctx}/index.html?locale=${language}"><spring:message code="zkmed.index.index"/></a>|<a href="${ctx}/zkmed/about-commonIssue.html"><spring:message code="zkmed.help.commonIssue"/></a>|<a href="${ctx}/zkmed/about-introduction.html"><spring:message code="zkmed.index.aboutUs"/></a>|<a href="${ctx}/zkmed/about-contactUs.html"><spring:message code="zkmed.help.contactUs"/></a></div>

<div class="footer tc">
	<p>"泽被后世，福寿康宁"是泽康人创业的梦想；"帮助患者实现幸福人生"是泽康人毕生的追求</p>
    <em><img src="${ctx}/imgs/f_icon.png" alt=""/></em>
</div>

<div class="copyright tc">
	<p>© 2014 无锡泽康医疗科技有限公司 All Rights Reserved. 
	
	<script type="text/javascript">
		var cur = window.location.href;
		if(cur.indexOf("www.js-zkmed.com.cn")!=-1){
			document.write("苏ICP备14056371号-4");
		}else if(cur.indexOf("www.js-zkmed.com")!=-1){
			document.write("苏ICP备14056371号-1");
		}else if(cur.indexOf("www.js-zkmed.net")!=-1){
			document.write("苏ICP备14056371号-2");
		}else if(cur.indexOf("www.js-zkmed.cn")!=-1){
			document.write("苏ICP备14056371号-3");
		}
	</script>
	</p>
	<p>Powered by 无锡泽康</p>
	<p class="layer"><a href="${ctx}/zkmed/about-privacyNorms.html"><spring:message code="zkmed.help.privacy"/></a>|<a href="${ctx}/zkmed/about-useSpecification.html"><spring:message code="zkmed.help.specification"/></a>|<a href="${ctx}/zkmed/about-maps.html"><spring:message code="zkmed.help.maps"/></a></p>
</div>

<div class="tool_bar">
	<a href="${ctx}/zkmed/about-contactUs.html"><img src="${ctx}/imgs/side_bar/1.png" alt=""/><br/><spring:message code="zkmed.help.contact"/></a>
    <a href="http://wpa.qq.com/msgrd?v=3&uin=42479719&site=qq&menu=yes" target="_blank"><img src="${ctx}/imgs/side_bar/2.png" alt=""/><br/><spring:message code="zkmed.help.onlineService"/></a>
    <a href="javascript:;"><img src="${ctx}/imgs/side_bar/3.png" alt=""/><br/><spring:message code="zkmed.help.attentionUs"/></a>
    <a style="display: none" id="goTopBtn" href="javascript:;"><img src="${ctx}/imgs/side_bar/4.png" alt=""/><br/><spring:message code="zkmed.help.returnTop"/></a>
</div>
<script type="text/javascript">
	goTopEx();
</script>