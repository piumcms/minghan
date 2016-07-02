//品牌相关js代码
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="brandDesc"]', {
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#image3').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#image').val(url);
					$("#img").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
});

 $(document).ready(function() { 
	//保存Brand
	 $("#submit").click(function() {
			var obj = new Object();
			obj.id=$('#id').val();
			obj.name = $("#name").val();
			if (obj.name == "") {
				$.messager.alert('立白管理系统','新品名称不能为空!','warning');
				return false;
			}
			obj.url=$("#url").val();
			obj.image=$("#image").val();
			if (!$("#brandType").val()) {
				$("#brandType").val("liby");
			}
			obj.brandType=$("#brandType").val();
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/saveNewProduct.html',
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
						window.location.href=getRootPath()+"/brand/newProductList.html";
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
 function delNewProduct(objsid){
	  $.messager.confirm('立白管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : getRootPath()+'/brand/removeNewProduct.html',
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
							window.location.href=getRootPath()+"/brand/newProductList.html";
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
 
 
 //新建
 function addNewProduct() {
	 window.location.href = getRootPath()+"/brand/addNewProduct.html";
 }
 
 //编辑
 function editNewProduct(objsid){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  window.location.href=getRootPath()+"/brand/showEditNewProduct.html?id="+objsid;
		  }		  
	  });
 }
 
 //编辑
 function editNewsType(objsid){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  window.location.href=getRootPath()+"/news/showeditnewstype.html?id="+objsid;
		  }		  
	  });
	  
 }
 
 function removeAll (tag) {
		
		$.messager.confirm('立白管理系统','确定删除吗？',function(r){
//			  if(r){
//					invokeRemove(tag,"brand_tbl","/about/batchDelete.html");
//			  }		  
		  });
		
	}