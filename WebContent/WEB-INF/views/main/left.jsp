<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>后台管理系统</title>
	<%@ include file="/WEB-INF/views/meta.jsp" %>
	<style type="text/css">
	<!--
	body {
		margin:0px;
		padding:0px;
		font-size: 12px;
	}
	#navigation {
		margin:0px;
		padding:0px;
		width:147px;
	}
	#navigation a.head {
		cursor:pointer;
		background:url(images/main_34.gif) no-repeat scroll;
		display:block;
		font-weight:bold;
		margin:0px;
		padding:5px 0 5px;
		text-align:center;
		font-size:12px;
		text-decoration:none;
	}
	#navigation ul {
		border-width:0px;
		margin:0px;
		padding:0px;
		text-indent:0px;
	}
	#navigation li {
		list-style:none; display:inline;
	}
	#navigation li li a {
		display:block;
		font-size:12px;
		text-decoration: none;
		text-align:left;
		padding:5px;
		margin-left: 10px;
	}
	#navigation li li a:hover {
		background:url(images/tab_bg.gif) repeat-x;
			border:solid 1px #adb9c2;
	}
	-->
	</style>
</head>
<body>
	<ul class="easyui-tree">
        <c:forEach var="item" items="${menuList}" varStatus="status">
	  		<li <c:if test="${fn:length(item.children)>0}">
		       					data-options="state:'closed'"	
		       				</c:if>> 
	  			<span><a class="head">${item.text}</a></span>
		  		<ul>
					<c:forEach var="node" items="${item.children}">
		       			<c:set var="thirds" value="${node.children}"></c:set>
		       			<li 
		       				<c:if test="${fn:length(thirds)>0}">
		       					data-options="state:'closed'"	
		       				</c:if>
		       				>
		       				<c:choose>
		       					<c:when test="${fn:length(thirds)>0}">
		       						<span><a class="head">${node.text}</a></span>
									<ul>
										<c:forEach var="nodec" items="${thirds}">
											<li>
												<span><a href="${ly}${nodec.url}" target="rightFrame">${nodec.text}</a></span>																					
											</li>
										</c:forEach>
				       				</ul>		       						
		       					</c:when>
		       					<c:otherwise>
		       						<span><a href="${ly}${node.url}" target="rightFrame">${node.text}</a></span>
		       					</c:otherwise>
		       				</c:choose>
		       			</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
        
    </ul>
</body>
</html>
