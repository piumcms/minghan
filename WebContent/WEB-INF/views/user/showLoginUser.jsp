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
<script type="text/javascript" src="${ly}/scripts/lhgdialog/lhgdialog.min.js"></script>
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">	
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <th>${user.username} 的个人信息</th></tr>
        </table>
    </div>
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${user.id }"/>
		<input type="hidden" id="flag" name="flag" value="2"/>
        <div class="input_text">
        	<label>用户名：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${user.username }" class="easyui-validatebox" required="true" 
        	validType="length[2,30]" missingMessage="不能为空" id="username" name="username"/>
			</div>
        </div>
        <div class="input_text">
        	<label>绑定手机号：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${user.mobilePhone}" class="easyui-validatebox" required="true" 
        	validType="mobile" missingMessage="不能为空" id="mobilePhone" name="mobilePhone"/>
			</div>
        </div>
        <div class="input_text">
        	<label>绑定邮箱：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${user.email}" class="easyui-validatebox" required="true" 
        	validType="email" missingMessage="不能为空" id="email" name="email"/>
			</div>
        </div>
        
   	    </div>
</body>
</html>
