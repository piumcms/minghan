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
<script charset="utf-8" src="${ly }/js/newProduct.js"></script>
<script type="text/javascript"></script>
</head>
<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>新品管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加新品</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑新品(${newProduct.name})</th></tr></c:if>
        </table>
    </div>
	<form action="${ly }/newProduct/saveBrand.html" method="post" id="saveBrandForm">
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${newProduct.id }"/>
		<input type="hidden" id="brandType" name="brandType" value="${newProduct.brandType }"/>
        <div class="input_text">
        	<label>新品名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${newProduct.name}" class="easyui-validatebox" 
        	required="true" validType="length[2,30]" missingMessage="不能为空" id="name" name="name"/>
			</div>
        </div>
        <div class="input_text">
        	<label>新品链接：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${newProduct.url }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空"  id="url" name="url"/>
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${newProduct.image }">
        		<img src="${newProduct.image}" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${newProduct.image }">
        			<img src="${newProduct.image}" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>新品图片：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="image" name="image" value="${newProduct.image }" readonly="readonly" /> 
        	<input type="button" id="image3" value="选择图片" />
			</div>
        </div>
         <div class="input_text" style="height:380px;display: none;">
        	<label>品牌介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="brandDesc" name="brandDesc"  > </textarea>
			</div>
        </div>
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
    </form>
</body>
</html>
