 $(document).ready(function() { 
	//保存Brand
	 $("#submit").click(function() {
		   var oldpwd=$("#oldpwd").val();
			if ( oldpwd == "") {
				$.messager.alert('立白管理系统','原始密码不能为空!','warning');
				return false;
			}
			 var pwd=$("#pwd").val();
				if ( pwd == "") {
					$.messager.alert('立白管理系统','新密码不能为空!','warning');
					return false;
				}
			 var cpwd=$("#cpwd").val();
					if ( oldpwd == "") {
						$.messager.alert('立白管理系统','确认密码不能为空!','warning');
						return false;
				}else if(pwd!=cpwd){
					$.messager.alert('立白管理系统','确认密码与新密码不一致!','warning');
					$("#cpwd").val("");
					return false;
				}
				
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/user/updatePwd.html',
				data : { oldpwd:oldpwd, pwd:pwd },
				beforeSend: function(XMLHttpRequest){
					 $.messager.progress({
					        title:'Please waiting',
					        msg:'Loading data...'
					    });
	        	},
				success : function(result) {
					if(result.success){
					   $.messager.alert('立白管理系统',result.msg,'question',function(r){
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
 
