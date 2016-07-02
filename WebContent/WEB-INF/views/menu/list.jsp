<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>后台管理系统</title>
		<%@ include file="/WEB-INF/views/taglibs.jsp"%>
		<%@ include file="/WEB-INF/views/meta.jsp" %>
	</head>
	<body>
		<div class="topPathArea">
			<table>
				<colgroup width="30px" />
				<tr>
					<td><img src="${ly}/images/localPlace.jpg" /></td>
					<td>系统管理</td>
					<td>&gt;</td>
					<td>菜单管理</td>
					<td>&gt;</td>
					<th>列表</th>
				</tr>
			</table>
		</div>
		<div style="margin:10px 0;"></div>
		<div id="toolbar">
			<div id="tmenu">
				<a id="createBtn" href="#" class="easyui-linkbutton" 
					data-options="iconCls:'icon-add',plain:true">新增</a>  
		        <a id="updateBtn" href="#" class="easyui-linkbutton" 
		        	data-options="iconCls:'icon-edit',plain:true">编辑</a>  
		        <a id="delBtn" href="#" class="easyui-linkbutton" 
		        	data-options="iconCls:'icon-remove',plain:true">删除</a>  
			</div>
	    </div>
		<table id="menuGrid"  title="菜单管理" class="easyui-treegrid" style="height:auto;width:auto;">
				<thead>
					<tr>
						<th field="id" width="10%">ID</th>
						<th field="name" width="20%" data-options="editor:'text'">菜单名称</th>
						<th field="url" width="40%" data-options="editor:'text'">URL</th>
						<th field="createTime" formatter="dateFormatter" width="15%">新建时间</th>
						<th field="updateTime" formatter="dateFormatter" width="15%">更新时间</th>
					</tr>
				</thead>
			</table>
			<!--菜单编辑 -->
		    <%@ include file="create.jsp" %>
	</body>
	<script type="text/javascript">
	function dateFormatter(val,row,index){
		return new Date(val).format("yyyy-MM-dd hh:mm:ss");
	}
	
	var loadGrid;
	$(function(){
		
		var defaultRow = {id:null,parentId:0,parentName:'明翰cms管理系统',name:"",url:""};
		var selectedRow = {};
		
		$("#createBtn").click(function(){
			$("#dlg").dialog({title: '新建菜单'}).dialog('open'); 
			$('#fm').form('clear'); 
			if(selectedRow.id){
				defaultRow.parentId = selectedRow.id;
				defaultRow.parentName = selectedRow.name;
			}
			$('#fm').attr("action",'${ly}/menu/create');
			$('#fm').form('load',defaultRow);
		});
		
		$("#updateBtn").click(function(){
		    var row = $('#menuGrid').datagrid('getSelected');  
		    if (row){
		    	$("#dlg").dialog({title: '更新菜单'}).dialog('open'); 
		        row.parentName = "明翰cms管理系统";
		    	$('#fm').form('load',row);  
		        $('#fm').attr("action",'${ly}/menu/update');
		    }  
		});
		
		$("#delBtn").click(function(){
			var row = $('#menuGrid').datagrid('getSelected');  
		    if (row){
		    	$.messager.confirm('确认','您确认删除此菜单?',function(r){  
		            if (r){  
		                $.post("${ly}/menu/delete",{id:row.id},function(result){  
		                    /* if (result.success){  
		                        $('#menuGrid').datagrid('reload');
		                    } else {  
		                        $.messager.show({// show error message  
		                            title: '错误',  
		                            msg: result.data  
		                        });  
		                    } */
		                	loadGrid();
		                });  
		            }  
		        }); 
		    }
		    return false;
		});
		
		loadGrid = function(){
			$('#menuGrid').treegrid({
		        url:'${ly}/menu/search',
		        idField:'id',
		        treeField:'name',
		        rownumbers:true,
				pagination:true,
				fitColumns:true,    
				onBeforeLoad: function(row,param){
					if(!row){
						param.id = 0;
					} 
				},onClickRow:function(row){
					selectedRow = row;
				}
		    });	
		}
		
		loadGrid();
	    
	});

	function dlgSave(){
	    $('#fm').form('submit',{  
	        url: $("#fm").attr("action"),  
	        onSubmit: function(){  
	            return $(this).form('validate');  
	        },  
	        success: function(result){ 
	        	/* var result = eval('('+result+')');
	            if(result.success){
	            	 $('#dlg').dialog('close');      // close the dialog  
	                 $('#menuGrid').datagrid('reload');    // reload data 
	            }else{
	            	$.messager.show({  
	                    title: '错误',  
	                    msg: result.data  
	                });  
	            }  */
	            $('#dlg').dialog('close');      // close the dialog  
	            loadGrid();
	        }  
	    });
	}
</script>
</html>
