<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<script charset="utf-8" src="${ly }/js/brandnews.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
</head>
<body>
	<div class="topPathArea">
		<table>
			<colgroup width="30px" />
			<tr>
				<td><img src="${ly}/images/localPlace.jpg" /></td>
				<td>系统管理</td>
				<td>&gt;</td>
				<td>新闻管理</td>
				<td>&gt;</td>
				<th>列表</th>
			</tr>
		</table>
	</div>
	<div class="div1_2">
	
	 <form action="${ly}/brand/${brandType}/list.html?category=${ctype}" method="post" id="technologyOrBrandNewsList">
		 标题：<input type="text" id="title" name="brandNewsName" value="${dto.title}" />
		 <input type="hidden" id="ctype" name="ctype" value="${ctype}"/>
		 <input type="hidden" id="brandType" name="brandType" value="${brandType}" /> 
		 <input type="submit" id="selbut" value="查询" /> 
		 
		 <c:if test="${ctype=='protect'&&dto.pager.rowCount<6}"> <!-- 蚊虫防护 -->
		  	<input type="button" value="新建" onclick="addBrandNews()"/>
		 </c:if>
		 <c:if test="${ctype!='protect'}"> <!-- 蚊虫防护 -->
		  	<input type="button" value="新建" onclick="addBrandNews()"/>
		 </c:if>
			<ll:tableModel id="brandNewsList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}"  batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
					
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" />
						<ll:htmlColumn property="language" title="语言" editable="false"
							exportable="false" />
						
						<ll:htmlColumn property="title" title="标题" exportable="true" styleClass="table_left_css">
							${bean.title}
						</ll:htmlColumn>
						<%-- <ll:htmlColumn property="content" title="新闻内容" exportable="true" styleClass="table_left_css">
                        <c:if test="${fn:length(bean.content) > 20}">
                        <c:out value="${fn:substring(bean.content, 0, 20)}"/>...
                        </c:if>
                        <c:if test="${fn:length(bean.content) <= 20}">
                        <c:out value="${bean.content}"/>
                        </c:if>
                        &nbsp;
						</ll:htmlColumn> --%>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;
						</ll:htmlColumn>
						<c:if test="${ctype!='protect'}">
						<ll:htmlColumn property="indexSeq" title="是否首页显示" exportable="false" width="10%">
							<c:if test="${bean.indexSeq > 0 }"><span style="color:red;">是</span></c:if>
							<c:if test="${bean.indexSeq == null || bean.indexSeq == 0}">否</c:if>
						</ll:htmlColumn>
						</c:if>
						
						<ll:htmlColumn property="allSeq" title="是否置顶" exportable="false">
							<span style="color:red;">
							<c:if test="${subBrandId == '0' }">
								<c:if test="${bean.allSeq> 0 }">
									是
								</c:if>
								<c:if test="${bean.allSeq == 0 || bean.allSeq == null }">
									否
								</c:if>
								
							</c:if>
							<c:if test="${subBrandId != '0' }">
								<c:if test="${bean.signalSeq> 0 }">
										是
									</c:if>
									<c:if test="${bean.signalSeq == 0 || bean.signalSeq == null }">
										否
									</c:if>
							</c:if>
						</span>
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false">
						<c:if test="${ctype!='protect'}">
							<a href="javascript:confirm5(${bean.id });">推送首页</a>&nbsp;
						</c:if>
							<a href="javascript:recommend('${bean.id}', '${subBrandId }');">置顶</a>|
                           	<a href="javascript:editBrandNews(${bean.id});">编辑</a>|
                           	<a href="javascript:delBrandNews(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
		</div>
</body>
</html>
