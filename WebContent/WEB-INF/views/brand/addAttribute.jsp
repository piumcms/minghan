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
<script charset="utf-8" src="${ly }/js/attri.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>商品属性管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加商品属性</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑商品属性(${attri.name})</th></tr></c:if>
        </table>
    </div>
	<form action="${ly }/attri/saveBrand.html" method="post" id="saveBrandForm">
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${attri.id }"/>
        <div class="input_text">
        	<label>商品属性名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${attri.name}" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="name" name="name"/>
			</div>
        </div>
        </div>
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
    </form>
</body>
</html>
