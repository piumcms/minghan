<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8" http-equiv="Content-Type" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/commom.css">
<script type="text/javascript" src="${ctx}/BScripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript"> 
	function goTopEx() { 
		var obj = document.getElementById("goTopBtn"); 
		function getScrollTop() { 
			return document.documentElement.scrollTop + document.body.scrollTop; 
		} 
		function setScrollTop(value) { 
			if (document.documentElement.scrollTop) { 
				document.documentElement.scrollTop = value; 
			} else { 
				document.body.scrollTop = value; 
			} 
		} 
		window.onscroll = function() { 
			getScrollTop() > 0 ? obj.style.display = "": obj.style.display = "none"; 
		} 
		obj.onclick = function() { 
			var goTop = setInterval(scrollMove, 10); 
			function scrollMove() { 
				setScrollTop(getScrollTop() / 1.1); 
				if (getScrollTop() < 1) clearInterval(goTop); 
			} 
		} 
	} 
</script>