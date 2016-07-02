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
						<td>菜单名称:</td>
						<td>
							<input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true"></input>
							<input type="hidden" id="id" name="id"/>
							<input type="hidden" id="parentId" name="parentId"/>
						</td>
					</tr>
					<tr>
						<td>URL:</td>
						<td><input class="easyui-validatebox" type="text" id="url" name="url" data-options="required:true"></input></td>
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