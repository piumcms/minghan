//商品属性

 $(document).ready(function() { 
	//保存Attribute
	 $("#submit").click(function() {
			var obj = new Object();
			obj.id=$('#id').val();
			obj.name = $("#name").val();
			if (obj.name == "") {
				$.messager.alert('立白管理系统','名称不能为空!','warning');
				return false;
			}
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/saveAttribute.html',
				data : jsondata,
				dataType : 'json',
				contentType : 'application/json',
				beforeSend: function(XMLHttpRequest){
					 $.messager.progress({
					        title:'Please waiting',
					        msg:'Loading data...'
					    });
	        	},
				success : function(result) {
					if(result.success){
					   $.messager.alert('立白管理系统',result.msg,'question',function(r){
						window.location.href=getRootPath()+"/brand/attriList.html";
					  });
					}else{
						$.messager.alert('立白管理系统',result.msg,'question',function(r){
							$("#brand").val('');
						  });
					}
				},
				 complete: function(XMLHttpRequest, textStatus){
					 $.messager.progress('close');
			        },
		        error:function(jqXHR, textStatus, errorThrown){
		        	top.location.href=getRootPath() + "/common/error";
		        }
		    });
		}); 
}); 
 
 //删除品牌
 function delAttribute(objsid){
	  $.messager.confirm('立白管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : getRootPath()+'/brand/removeAttribute.html',
					data : jsondata,
					dataType : 'json',
					contentType : 'application/json',
					beforeSend: function(XMLHttpRequest){
						 $.messager.progress({
						        title:'Please waiting',
						        msg:'Loading data...'
						    });
		        	},
					success : function(result) {
						$.messager.alert('立白管理系统',result.msg,'question',function(r){
							window.location.href=getRootPath()+"/brand/attriList.html";
							});
					},
					 complete: function(XMLHttpRequest, textStatus){
						 $.messager.progress('close');
				        },
			        error:function(jqXHR, textStatus, errorThrown){
			        	top.location.href=getRootPath() + "/common/error";
			        }
			    });
		  }		  
	  });
	  
 }
 
 //编辑
 function editAttribute(objsid){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  window.location.href=getRootPath()+"/brand/showEditAttribute.html?id="+objsid;
		  }		  
	  });
	  
 }
