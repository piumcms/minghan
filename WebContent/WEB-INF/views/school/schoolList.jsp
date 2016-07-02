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
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script src="${ly }/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${ly }/js/brandnews.js"></script>
<style type="text/css">
body {
	padding: 0px;
}

.div1 {
	padding: 0px;
}
</style>
</head>
<body>
<jsp:useBean id='map' class='java.util.HashMap' scope="page">
	<c:set target='${map}' property='1' value='蚊子'/>
	<c:set target='${map}' property='2' value='蟑螂'/>
	<c:set target='${map}' property='3' value='跳蚤'/>
	<c:set target='${map}' property='4' value='苍蝇'/>
	<c:set target='${map}' property='5' value='蚂蚁'/>
	<c:set target='${map}' property='6' value='臭虫'/>
</jsp:useBean>
	<div class="divn1_1">系统管理&gt;&gt; 蚊虫学院</div>
	<div class="div1_2">

		<form action="${ly}/product/${brandType}/list.html" method="post"
			id="technologyOrProductList">
			<input type="hidden" id="ctype" name="ctype" value="${ctype}"/>
			<input type="hidden" id="brandType" name="brandType" value="${brandType}"/> 
			<input type="button" id="addbut" name="addbut" value="新增" onclick="addBrandNews()"/>
			<ll:tableModel id="productList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}"
				batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true"
							width="5%" exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							width="50px" exportable="false" />
						<ll:htmlColumn property="picture" title="图片" exportable="true"
							styleClass="table_left_css" width="100px;">
							<img src="${bean.picture}" id="img"
								style="width: 100px; height: 100px;" />
						</ll:htmlColumn>
						<ll:htmlColumn property="schoolType" title="类型"
							exportable="true" styleClass="table_left_css" width="100px">
							<c:forEach var="item" items="${map}">   
								<c:if test="${item.key==bean.schoolType}">
									${item.value}
								</c:if>  
							</c:forEach>
						</ll:htmlColumn>
						<ll:htmlColumn property="title" title="标题"
							exportable="true" styleClass="table_left_css" width="100px">
							${bean.title}
						</ll:htmlColumn>
						
						<ll:htmlColumn property="createTime" title="创建时间"
							exportable="false">
							<fmt:formatDate value="${bean.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false"
							width="100px">
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
