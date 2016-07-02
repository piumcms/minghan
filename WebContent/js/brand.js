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
					$('#picSrc').val(url);
					$("#img").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
	K('#image2').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#bannerPic').val(url);
					$("#imgbanner").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
	K('#image1').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#brandImage').val(url);
					$("#imagebrand").attr('src', url);
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
			obj.brandType = $("#brandType").val();
			if (obj.brandType == "") {
				$.messager.alert('立白管理系统','品牌简写不能为空!','warning');
				return false;
			}
			obj.url=$("#url").val();
			obj.picSrc=$("#picSrc").val();
			obj.bannerPic=$("#bannerPic").val();
			obj.brandImage=$("#brandImage").val();
			obj.weiboId=$("#weiboId").val();
			var html = editor1.html();
			if (html == "") {
				$.messager.alert('立白管理系统','内容描述不能为空','warning');
				return false;
			}
			$("#brandDesc").val(html)
			obj.brandDesc=$("#brandDesc").val();
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/saveBrand.html',
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
						window.location.href=getRootPath()+"/brand/brandList.html";
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
					url : getRootPath()+'/brand/removeBrand.html',
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
							window.location.href=getRootPath()+"/brand/brandList.html";
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
 function addBrand() {
 	 window.location.href = getRootPath()+"/brand/addBrand.html";
 }
 
 //编辑
 function editBrand(objsid){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  window.location.href=getRootPath()+"/brand/showEditBrand.html?id="+objsid;
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
			  if(r){
					invokeRemove(tag,"brand_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}