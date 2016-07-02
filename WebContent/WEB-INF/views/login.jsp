<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="${ly}/js/jquery-easyui-1.3.2/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="${ly}/js/jquery-easyui-1.3.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ly}/css/base.css">
<script type="text/javascript" src="${ly}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ly}/js/commons/jquery.form.js"></script>
<script type="text/javascript" src="${ly}/js/commons/package.js"></script>
<script type="text/javascript" src="${ly}/js/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ly}/js/commons/utils.js"></script>
<script type="text/javascript" src="${ly}/js/commons/base.js?v=11"></script>
<link rel="stylesheet" type="text/css" href="${ly}/css/main.css">
<link rel="stylesheet" type="text/css" href="${ly}/css/user_login.css">
</head>
<body id=userlogin_body>
	<form id="loginForm" action="${ly}/logon.html" method="post">
		<div></div>
		<div id=user_login>
			<dl>
				<dd id=user_top>
					<ul>
						<li class=user_top_l></li>
						<li class=user_top_c></li>
						<li class=user_top_r></li>
					</ul>
				<dd id=user_main>
					<ul>
						<li class=user_main_l>
						</li>
						<li class=user_main_c>
							<div class=user_main_box>
								<ul>
									<li class=user_main_text>用户名：</li>
									<li class=user_main_input><input
										class="txtusernamecssclass easyui-validatebox"
										name="username" value="" maxlength="20" style="width: 165px;"/></li>
								</ul>
								<ul>
									<li class=user_main_text>密 码：</li>
									<li class=user_main_input><input
										class="txtpasswordcssclass easyui-validatebox"
										data-options="required:true,missingMessage:'密码不能为空.'"
										type="password" name="password" value="" style="width: 165px;"/></li>
								</ul>
								<ul>
									<li class=user_main_text>验证码：</li>
									<li class=user_main_input><img class="vc-pic" width="65"
										height="23" title="点击刷新验证码"
										src="${ly }/imageServlet?time=new Date().getTime()"> <input
										class="vc-text easyui-validatebox"
										data-options="required:true,missingMessage:'验证码不能为空.'"
										maxlength="4" type="text" name="validateCode"></li>
								</ul>
							</div>
						</li>
						<li class=user_main_r><input class="ibtnentercssclass"
							style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px"
							type=image src="images/login/user_botton.gif"></li>
					</ul>
				<dd id=user_bottom>
					<ul>
						<li class=user_bottom_l></li>
						<li class=user_bottom_c><span style="margin-top: 40px">
								
						</span></li>
						<li class=user_bottom_r></li>
					</ul>
				</dd>
			</dl>
		</div>
		<div></div>
	</form>
	<script type="text/javascript" src="${ly }/js/ux/login.js"></script>
</body>
</html>
