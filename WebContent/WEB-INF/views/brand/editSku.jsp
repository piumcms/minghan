<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<link href="${ly }/js/calendarControl/skin/default/datepickersel.css">
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<script charset="utf-8" src="${ly }/js/sku.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
    <div class="topPathArea">	
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>Sku商品管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑(${sku.productName}--${sku.attributeName})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly }/brand/saveSku.html" method="post" id="saveBrandForm" commandName="sku" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${sku.id }"/>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber}"/>
		<input type="hidden" id="stableId" name="stableId" value="${tableId}"/>
		<input type="hidden" id="sattributeName" name="sattributeName" value="${attributeName}"/>
		<input type="hidden" id="sproductName" name="sproductName" value="${productName}"/>
		
		<input type="hidden" id="productName" name="productName" value="${sku.productName}"/>
		<input type="hidden" id="attributeName" name="attributeName" value="${sku.attributeName}"/>
		<div class="input_text">
        	<label>商品品牌：</label>
        	<div style="float: left;display: inline;">
        	   <select id="tableId" name="tableId" style="width: 180px;">
        	    <option value="0">-请选择-</option>
        	    <c:forEach begin="0" items="${subBrandList }" var="bean" >
        	       <c:if test="${product.tableId==bean.id }">
        	       <option value="${bean.id }" selected="selected">${bean.brand}</option>
        	       </c:if>
        	        <c:if test="${product.tableId!=bean.id }">
        	       <option value="${bean.id }" >${bean.brand}</option>
        	       </c:if>
        	    </c:forEach>
        	   </select>
			</div>
        </div>
		<div class="input_text" id="prodv">
        	<label>所属商品：</label>
			 <select id="productId" name="productId" style="width: 180px;">
        	    <option value="0">-请选择商品-</option>
        	    <c:forEach begin="0" items="${proList }" var="bean" >
        	       <c:if test="${product.id==bean.id }">
        	       <option value="${bean.id }" selected="selected">${bean.productName}</option>
        	       </c:if>
        	        <c:if test="${product.id!=bean.id }">
        	       <option value="${bean.id }" >${bean.productName}</option>
        	       </c:if>
        	    </c:forEach>
        	 </select>
        </div>
        
        <div class="input_text">
	        	<label>Sku排位：</label>
	        	<div style="float: left;display: inline;">
		        	<input type="text"  id="pw" name="pw" value="${sku.pw}"  />
				</div>
	        </div>
		<%-- <div class="input_text">
        	<label>商品属性：</label>
        	<div style="float: left;display: inline;">
        	   <form:select path="attributeId" items="${attriMap }" cssStyle="width:180px;" />
			</div>
        </div> --%>
         <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${sku.src }">
        		<img src="${sku.src }" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${sku.src  }">
        			<img src="${sku.src }" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>Sku图片：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="src" name="src" value="${sku.src }" readonly="readonly" />
        	<input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
        <div class="input_text" style="height:380px;">
        	<label>Sku介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="info" name="info">${sku.info} </textarea>
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
   </form:form>
</body>
</html>
