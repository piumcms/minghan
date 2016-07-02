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
<script charset="utf-8" src="${ly }/js/updatePwd.js"></script>
<script type="text/javascript"></script>
</head>
<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>用户管理</td><td>&gt;</td>
            <th>修改密码</th></tr>
        </table>
    </div>
	<form action="${ly }/user/updatePwd.html" method="post" id="saveBrandForm">
		<div class="outSideDiv">
        <div class="input_text">
        	<label>原始密码：</label>
        	<div style="float: left;display: inline;">
        	<input type="password" value="" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" 
        	id="oldpwd" name="oldpwd"/>
			</div>
        </div>
        <div class="input_text">
        	<label>新密码：</label>
        	<div style="float: left;display: inline;">
        	<input type="password" value="" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" 
        	id="pwd" name="pwd"/>
			</div>
        </div>
   
       <div class="input_text">
        	<label>确认密码：</label>
        	<div style="float: left;display: inline;">
        	<input type="password" value="" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" 
        	id="cpwd" name="cpwd"/>
			</div>
        </div>
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
    </form>
</body>
</html>
