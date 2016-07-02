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
<script charset="utf-8" src="${ly }/js/product.js"></script>
<script charset="utf-8" src="${ly }/js/addProduct.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var brandType = $("#brandType").val();
	 if (showNoteKeys.toString().indexOf(brandType) == -1) {
		 $("input[name^=noteKey]").each(function(){
			 $(this).parent().parent().hide();
		 })
	 }
	 if (showNoteDescs.toString().indexOf(brandType) == -1) {
		 $("input[name^=noteDesc]").each(function(){
			 $(this).parent().parent().hide();
		 })
	 }
	 if (showNoteValues.toString().indexOf(brandType) == -1) {
		 $("div[name='noteValueDiv']").hide();
	 }
	 if (showProductDescs.toString().indexOf(brandType) == -1) {
		 $("div[name='productDescDiv']").hide();
	 }
});
</script>
</head>

<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>产品管理</td><td>&gt;</td>
            <c:if test="${empty product.productName}"><th>添加</th></tr></c:if>
            <c:if test="${not empty product.productName}"><th>编辑(${product.productName})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly }/product/saveProduct.html" method="post" id="saveBrandForm" commandName="product" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${product.id }"/>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber}"/>
		<input type="hidden" id="searchProductName" name="searchProductName" value="${productName}"/>
		<input type="hidden" id="tableId" name="tableId" value="${product.tableId}"/>
		<input type="hidden" id="brandType" name="brandType" value="${product.tableId}"/>
        <div class="input_text">
        	<label>语言选择：</label>
        	<div style="float: left;display: inline;">
        		<select id="language" name="language" style="width:250px;">
	            	<c:choose>
	            		<c:when test="${product.language=='zh_CN' }">
	            			<option value="zh_CN" selected="selected">中文</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="zh_CN">中文</option>
	            		</c:otherwise>
	            	</c:choose>
	            	
	            	<c:choose>
	            		<c:when test="${product.language=='en_US' }">
	            			<option value="en_US" selected="selected">英语</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="en_US">英语</option>
	            		</c:otherwise>
	            	</c:choose>
	            </select>
			</div>
        </div>
        <div class="input_text">
        	<label>产品名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.productName }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="productName" name="productName"/>
			</div>
        </div>
<%--         <div class="input_text">
        	<label>淘宝地址：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.taobaoUrl }" class="easyui-validatebox" 
        	required="true" validType="length[2,30]" missingMessage="不能为空" id="taobaoUrl" name="taobaoUrl"/>
			</div>
        </div> --%>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${product.picSrc }">
        		<img src="${product.picSrc}" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${product.picSrc }">
        			<img src="${product.picSrc}" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>产品图片：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="picSrc" name="picSrc" value="${product.picSrc }" readonly="readonly" /> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
        <div class="input_text"  style="height:auto">
        	<label>网页标签：</label>
        	<div id="tags">
<%--         		 <c:forEach var="tag" items="${tags}" varStatus="status">
        		 	<c:forEach var="relation" items="${tagRelations}" varStatus="status">
        		 		<c:if test="${relation.tagId==tag.id}">
        		 		       			<input name="tag" type="checkbox" value="${tag.id}" checked="checked" />${tag.tag} &nbsp;&nbsp;&nbsp;&nbsp;       		 		
        		 		</c:if>
 					</c:forEach>
				</c:forEach> --%>
			</div>
        </div>
        
        <div class="input_text" style="height:240px;">
        	<label>产品简介：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="shortDesc" name="shortDesc"> ${product.shortDesc} </textarea>
			</div>
        </div>
         <div class="input_text" style="display: none;">
        	<label>产品排位：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.pw}" class="easyui-validatebox" required="true" value="1" validType="length[2,30]" missingMessage="不能为空" 
        	id="pw" name="pw"/>
			</div>
        </div>
        <div class="input_text" style="height:240px;" name="productDescDiv">
        	<label>产品介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="productDesc" name="productDesc"  > ${product.productDesc} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label>描述标题1：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteKey1}"
        	id="noteKey1" name="noteKey1"/>
			</div>
        </div>
        <div class="input_text">
        	<label>描述简介1：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteDesc1}"
        	id="noteDesc1" name="noteDesc1"/>
			</div>
        </div>
        <div class="input_text" style="height:240px;" name="noteValueDiv">
        	<label>描述内容1：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="noteValue1" name="noteValue1"  > ${product.noteValue1} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label>描述标题2：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteKey2}"
        	id="noteKey2" name="noteKey2"/>
			</div>
        </div>
        <div class="input_text">
        	<label>描述简介2：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteDesc2}"
        	id="noteDesc2" name="noteDesc2"/>
			</div>
        </div>
        <div class="input_text" style="height:240px;" name="noteValueDiv">
        	<label>描述内容2：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="noteValue2" name="noteValue2"  > ${product.noteValue2} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label>描述标题3：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteKey3}"
        	id="noteKey3" name="noteKey3"/>
			</div>
        </div>
        <div class="input_text">
        	<label>描述简介3：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteDesc3}"
        	id="noteDesc3" name="noteDesc3"/>
			</div>
        </div>
        <div class="input_text" style="height:240px;" name="noteValueDiv">
        	<label>描述内容3：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="noteValue3" name="noteValue3"  > ${product.noteValue3} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label>描述标题4：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteKey1}" 
        	id="noteKey4" name="noteKey4"/>
			</div>
        </div>
        <div class="input_text">
        	<label>描述简介4：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.noteDesc4}"
        	id="noteDesc4" name="noteDesc4"/>
			</div>
        </div>
        <div class="input_text" style="height:240px;" name="noteValueDiv">
        	<label>描述内容4：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="noteValue4" name="noteValue4"  > ${product.noteValue4} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label></label>
        	<div style="float: left;display: inline;">
        		<input type="button" value="保存" id="submit" style="width:80px;"/>
        	</div>
        </div>
   	 </div>
   </form:form>
</body>
</html>
