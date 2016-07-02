
 //选择省市区
 var api = frameElement.api;
 function selArea(){
	 var dg=new $.dialog({
			id:'areaSelect',
			content: 'url:'+getRootPath()+'/area/selPcareaPage.html',
			width:480,
			height:530,
		    drag: false, 
		    resize: false,
			parent:dg,
			lock: true,
			title:"选择区域",
			max:false,
			min:false
		});
 }

 
 $(function(){
	 
	 //添加管理员
	 $("#submitAdmin").click(function(){
		 var obj = new Object();
		 obj.id=$("#id").val();
		 obj.flag=$("#flag").val();
		 obj.username=$("#username").val();
		 obj.password=$("#password").val();
		 obj.roleId=$("#roleId").val();
		 if (obj.username==''||obj.username==null) {
				$.messager.alert('后台管理系统','用户名不能为空！','warning');
				return false;
			}
		 if (obj.id == "") {
			 if (obj.password==''||obj.password=='') {
					$.messager.alert('后台管理系统','密码不能为空！','warning');
					return false;
				}
			 if (obj.password!=''&&obj.password!=$("#confirmPassword").val()) {
					$.messager.alert('后台管理系统','确认密码和密码不一致！','warning');
					return false;
				}
		 } else {
			 if (obj.password!=''&&obj.password!=$("#confirmPassword").val()) {
					$.messager.alert('后台管理系统','确认密码和密码不一致！','warning');
					return false;
				}
		 }
		 obj.mobilePhone=$("#mobilePhone").val();
		 obj.email=$("#email").val();
		 if (obj.mobilePhone==''||obj.mobilePhone==null) {
				$.messager.alert('后台管理系统','手机号码不能为空！','warning');
				return false;
			}
		 if (obj.email==''||obj.email==null) {
				$.messager.alert('后台管理系统','邮箱不能为空！','warning');
				return false;
			}
		
		 var jsondata=$.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/user/saveUser.html',
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
					   $.messager.alert('后台管理系统',result.msg,'question',function(r){
						window.location.href=getRootPath()+"/user/list";
					  });
					}else{
						$.messager.alert('后台管理系统',result.msg,'question',function(r){
							
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