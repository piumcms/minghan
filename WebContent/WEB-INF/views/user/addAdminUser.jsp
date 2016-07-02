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
<script charset="utf-8" src="${ly }/js/addUser.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">	
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>管理员管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加管理员</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>修改管理员(${user.username})</th></tr></c:if>
        </table>
    </div>
	<form action="${ly }/user/saveUser.html" method="post" id="saveBrandForm">
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
        	<label>密码：</label>
        	<div style="float: left;display: inline;">
        	<input type="password" value="" class="easyui-validatebox" required="true" 
        	validType="length[6,30]" missingMessage="不能为空" id="password" name="password"/>
			</div>
        </div>
        <div class="input_text">
        	<label>确认密码：</label>
        	<div style="float: left;display: inline;">
        	<input type="password" value="" class="easyui-validatebox" required="true" 
        	validType="length[6,30]" missingMessage="不能为空" id="confirmPassword" name="confirmPassword"/>
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
        <div class="input_text">
        	<label>赋予角色：</label>
        	<div style="float: left;display: inline;">
        	 <select id="roleId" name="roleId" style="width: 120px;">
        	 <c:forEach begin="0" items="${roleList }" var="bean" >
        	   <c:if test="${user.roleId==bean.id }" >
        	   <option value="${bean.id }" selected="selected" >${bean.memo }</option>
        	   </c:if>
        	   <c:if test="${user.roleId!=bean.id }" >
        	   <option value="${bean.id }" >${bean.memo }</option>
        	   </c:if>
        	 </c:forEach>
        	 </select>
			</div>
        </div>
        
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submitAdmin" style="width:80px;margin-right: 35px;"/>
            <input type="button" value="取消" onclick="javascript:history.go(-1)" id="back" style="width:80px;margin-right: 35px;"/>
        </div>
   	    </div>
     </form>
</body>
</html>
