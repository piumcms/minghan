//品牌相关js代码
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="subBrandDesc"]', {
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
					$('#picSrc').val(url);
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
			obj.brand = $("#brand").val();
			if (obj.brand == "") {
				$.messager.alert('立白管理系统','品牌名称不能为空!','warning');
				return false;
			}
			obj.url=$("#url").val();
			obj.weiboId=$("#weiboId").val();
			obj.picSrc=$("#picSrc").val();
			var html = editor1.html();
			if (html == "") {
				$.messager.alert('立白管理系统','内容描述不能为空','warning');
				return false;
			}
			$("#subBrandDesc").val(html)
			obj.subBrandDesc=$("#subBrandDesc").val();
			obj.brandId=$("#brandId").val();
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/saveSubBrand.html',
				data : jsondata,
				dataType : 'json',
				contentType : 'application/json',
				beforeSend: function(XMLHttpRequest){
					 $.messager.progress({
					        title:'Please waiting',
					        msg:'Loading data...'
					    });
	        	},
				success : function(result){
					if(result.success){
					   $.messager.alert('立白管理系统',result.msg,'question',function(r){
						window.location.href=getRootPath()+"/brand/subbrandList.html?pageNumber=" + $("#pageNumber").val();
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
 function delBrand(objsid){
	  $.messager.confirm('立白管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : getRootPath()+'/brand/removeSubBrand.html',
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
							window.location.href=getRootPath()+"/brand/subbrandList.html";
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
 function editBrand(objsid, objPage){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  window.location.href=getRootPath()+"/brand/showEditSubBrand.html?id="+objsid + "&pageNumber=" + objPage;
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
 
//remove
	function removeAll (tag) {
		
		$.messager.confirm('立白管理系统','确定删除吗？',function(r){
			  if(r){
					invokeRemove(tag,"subbrand_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}