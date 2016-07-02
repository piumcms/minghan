<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #000000;
}
.STYLE5 {font-size: 12}
.STYLE7 {font-size: 12px; color: #FFFFFF; }
.STYLE7 a{font-size: 12px; color: #FFFFFF;text-decoration:none; }
a img {
	border:none;
}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="57" background="${ly }/images/main_03.gif">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="350" height="57" background="${ly }/images/mainlogo.png">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="281" valign="bottom">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33" height="27"><img src="${ly }/images/main_05.gif" width="33" height="27" /></td>
            <td width="248" background="${ly }/images/main_06.gif"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="17"><div align="right">
                <a href="${ly }/user/upPwd.html" target="rightFrame"><img src="${ly }/images/pass.gif" width="69" height="17" /></a></div></td>
                <td><div align="right">
                <sec:hasRole name="ROLE_ADMIN">
                <a href="javascript:alert('当前为超级管理原，用户信息无！');" target="rightFrame">
                
                <img src="${ly }/images/user.gif" width="69" height="17" /></a></sec:hasRole>
                <sec:lacksRole name="ROLE_ADMIN"><a href="${ly }/user/showLoginUser.html/${session_user.id}" target="rightFrame">
                
                <img src="${ly }/images/user.gif" width="69" height="17" /></a>
                </sec:lacksRole>
                </div></td>
                <td><div align="right"><a href="${ly }/logout.html" target="_parent"><img src="${ly }/images/quit.gif" alt=" " width="69" height="17" /></a></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="40" background="${ly }/images/main_10.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="40" >
          <table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
          <tr>
            <td width="21"><img src="${ly }/images/main_13.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="main.html" target="rightFrame">首页</a></div></td>
            <td width="21" class="STYLE7"><img src="${ly }/images/main_15.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="javascript:history.go(-1);">后退</a></div></td>
            <td width="21" class="STYLE7"><img src="${ly }/images/main_17.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="javascript:history.go(1);">前进</a></div></td>
            <td width="21" class="STYLE7"><img src="${ly }/images/main_19.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="javascript:window.parent.location.reload();">刷新</a></div></td>
            <td width="21" class="STYLE7"><img src="${ly }/images/main_21.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="http://www.865171.cn" target="_parent">帮助</a></div></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" background="${ly }/images/main_31.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" height="30"><img src="${ly }/images/main_28.gif" width="8" height="30" /></td>
        <td width="147" background="images/main_29.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="24%">&nbsp;</td>
            <td width="43%" height="20" valign="center" class="STYLE1">管理菜单</td>
            <td width="33%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="39"><img src="${ly }/images/main_30.gif" width="39" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="20" valign="center"><span class="STYLE1">当前登录用户：<sec:principal/> </span></td>
            <td valign="bottom" class="STYLE1"><div align="right"></div></td>
          </tr>
        </table></td>
        <td width="17"><img src="${ly }/images/main_32.gif" width="17" height="30" /></td>
      </tr>
    </table></td>
  </tr>
</table>

<div id="dlg" class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px">
        The dialog content.
    </div>
</body>
</html>
