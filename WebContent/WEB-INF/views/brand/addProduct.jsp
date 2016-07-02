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
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>产品管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑(${product.productName})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly }/brand/saveProduct.html" method="post" id="saveBrandForm" commandName="product" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${product.id }"/>
		<div class="input_text">
        	<label>选择品牌：</label>
        	<div style="float: left;display: inline;">
        	   <form:select path="tableId" items="${brandMap }" cssStyle="width:180px;"  />
			</div>
        </div>
        <div class="input_text" id="subdv" style="display: none;">
        	<label>选择子品牌：</label>
        	<div style="float: left;display: inline;">
        	   <select id="subBrandId" name="subBrandId" style="width: 180px;">
        	    <option value="0">-请选择-</option>
        	   </select>
			</div>
        </div>
       <input type="hidden" id="brandId" name="brandId" value="0"/>
        <div class="input_text">
        	<label>产品名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.productName }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="productName" name="productName"/>
			</div>
        </div>
        <div class="input_text">
        	<label>淘宝地址：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.taobaoUrl }" class="easyui-validatebox" 
        	required="true" validType="length[1,30]" missingMessage="不能为空" id="taobaoUrl" name="taobaoUrl"/>
			</div>
        </div>
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
         <div class="input_text">
        	<label>产品排位：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${product.pw}" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" 
        	id="pw" name="pw"/>
			</div>
        </div>
        <div class="input_text" style="height:380px;">
        	<label>产品介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="productDesc" name="productDesc"  > ${product.productDesc} </textarea>
			</div>
        </div>
        <!--
        <div class="input_text">
        	<label>产品概要：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" class="input_text_css" id="info" name="info"/>
			</div>
        </div>  -->
   
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
   </form:form>
</body>
</html>
