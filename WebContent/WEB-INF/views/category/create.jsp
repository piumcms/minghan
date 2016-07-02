<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px"  
	        data-options="modal:true,closed:true,iconCls:'icon-save',buttons:'#dlg-buttons'" > 
			 <form id="fm" method="post" action="${ly}/menu/create">  
			 	<table style="text-align: center;">
			 		<tr>
						<td>父菜单名称:</td>
						<td><input class="easyui-validatebox" type="text" id="parentName" name="parentName" readonly="readonly"></input></td>
					</tr>
					<tr>
						<td>语言:</td>
						<td>
							<select id="language" name="language" 
								style="text-align: left;width: 150px;"  data-options="required:true">
		            			<option value="zh_CN">中文</option>
		            			<option value="en_US">英语</option>
				            </select>
						</td>
					</tr>
					<tr>
						<td>菜单名称:</td>
						<td>
							<input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true"></input>
							<input type="hidden" id="id" name="id"/>
							<input type="hidden" id="parentId" name="parentId"/>
							<input type="hidden" id="brandType" name="brandType" value="${brandType}"/>
						</td>
					</tr>
					<tr>
						<td>title:</td>
						<td>
							<input class="easyui-validatebox" type="text" id="title" name="title" ></input>
						</td>
					</tr>
					<tr>
						<td>description:</td>
						<td>
							<input class="easyui-validatebox" type="text" id="des" name="des" ></input>
						</td>
					</tr>
					<tr>
						<td>keyWords:</td>
						<td>
							<input class="easyui-validatebox" type="text" id="keywords" name="keywords" ></input>
						</td>
					</tr>
					<tr>
						<td>简介:</td>
						<td>
							<textarea id="brief" rows='5'  name="brief" class="textarea easyui-validatebox" ></textarea>
							<!-- <input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true"></input> -->
						</td>
					</tr>
				</table>
			</form> 
	    </div>
	    <div id="dlg-buttons">  
	    	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="dlgSave()">保存</a>  
	    	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>  
		</div>
	</body>
</html>