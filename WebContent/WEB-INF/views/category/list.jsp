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
					<td>产品类别管理</td>
					<td>&gt;</td>
					<th>列表</th>
				</tr>
			</table>
		</div>
		<div style="margin:10px 0;"></div>
		<div id="toolbar">
			<div id="tcategory">
				<a id="createBtn" href="#" class="easyui-linkbutton" 
					data-options="iconCls:'icon-add',plain:true">新增</a>  
		        <a id="updateBtn" href="#" class="easyui-linkbutton" 
		        	data-options="iconCls:'icon-edit',plain:true">编辑</a>  
		        <a id="delBtn" href="#" class="easyui-linkbutton" 
		        	data-options="iconCls:'icon-remove',plain:true">删除</a>  
			</div>
	    </div>
		<table id="categoryGrid"  title="分类管理" class="easyui-treegrid" style="height:auto;width:auto;">
				<thead>
					<tr>
						<th field="id" width="10%">ID</th>
						<th field="name" width="30%" data-options="editor:'text'">分类名称</th>
						<th field="language" width="10%" data-options="editor:'text'">语言</th>
						<th field="createTime" formatter="dateFormatter" width="25%">新建时间</th>
						<th field="updateTime" formatter="dateFormatter" width="25%">更新时间</th>
					</tr>
				</thead>
			</table>
			<!--分类编辑 -->
		    <%@ include file="create.jsp" %>
	</body>
	<script type="text/javascript">
	function dateFormatter(val,row,index){
		return new Date(val).format("yyyy-MM-dd hh:mm:ss");
	}
	
	var loadGrid;
	$(function(){
		
		var defaultRow = {id:null,parentId:0,parentName:'明翰CMS管理系统',name:"",brandType:"${brandType}",language:"zh_CN",title:"",des:"",keywords:"",brief:""};
		var selectedRow = {};
		
		$("#createBtn").click(function(){
			$("#dlg").dialog({title: '新建分类'}).dialog('open'); 
			$('#fm').form('clear'); 
			if(selectedRow.id){
				defaultRow.parentId = selectedRow.id;
				defaultRow.parentName = selectedRow.name;
				defaultRow.brandType = selectedRow.brandType;
				defaultRow.title = selectedRow.title;
				defaultRow.des = selectedRow.des;
				defaultRow.keywords = selectedRow.keywords;
				defaultRow.brief = selectedRow.brief;
			}
			$('#fm').attr("action",'${ly}/category/create');
			$('#fm').form('load',defaultRow);
		});
		
		$("#updateBtn").click(function(){
		    var row = $('#categoryGrid').datagrid('getSelected');  
		    if (row){
		    	$("#dlg").dialog({title: '更新分类'}).dialog('open'); 
		        row.parentName = "明翰CMS管理系统";
		    	$('#fm').form('load',row);  
		    	console.info(JSON.stringify(row));
		        $('#fm').attr("action",'${ly}/category/update');
		    }  
		});
		
		$("#delBtn").click(function(){
			var row = $('#categoryGrid').datagrid('getSelected');  
		    if (row){
		    	$.messager.confirm('确认','您确认删除此分类?',function(r){  
		            if (r){  
		                $.post("${ly}/category/delete",{id:row.id},function(result){  
		                	loadGrid();
		                });  
		            }  
		        }); 
		    }
		    return false;
		});
		
		loadGrid = function(){
			$('#categoryGrid').treegrid({
		        url:'${ly}/category/${brandType}/search',
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
					console.info(row);
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
	            $('#dlg').dialog('close');      // close the dialog  
	            loadGrid();
	        }  
	    });
	}
</script>
</html>
