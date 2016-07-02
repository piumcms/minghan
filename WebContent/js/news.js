

// 删除新闻类别
function delNewsType(objsid) {
	$.messager.confirm('立白管理系统', '确定删除吗？', function(r) {
		if (r) {
			var obj = new Object();
			obj.id = objsid;
			var jsondata = $.toJSON(obj);
			$.ajax({
				type : 'POST',
				url : getRootPath() + '/news/removenewstype.html',
				data : jsondata,
				dataType : 'json',
				contentType : 'application/json',
				beforeSend : function(XMLHttpRequest) {
					$.messager.progress({
						title : 'Please waiting',
						msg : 'Loading data...'
					});
				},
				success : function(result) {
					$.messager.alert('立白管理系统', result.msg, 'question',
							function(r) {
								window.location.href = getRootPath()
										+ "/news/shownewstypelist.html";
							});
				},
				complete : function(XMLHttpRequest, textStatus) {
					$.messager.progress('close');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					top.location.href = getRootPath() + "/common/error";
				}
			});
		}
	});

}

// 编辑新闻类别
function editNewsType(objsid) {
	$.messager.confirm('立白管理系统', '确定编辑吗？', function(r) {
		if (r) {
			alert(getRootPath() + "/news/showeditnewstype.html?id=" + objsid);
			window.location.href = getRootPath()
					+ "/news/showeditnewstype.html?id=" + objsid;
		}
	});
}
//删除新闻
function delNews(objsid) {
	$.messager.confirm('立白管理系统', '确定删除吗？', function(r) {
		if (r) {
			var obj = new Object();
			obj.id = objsid;
			var jsondata = $.toJSON(obj);
			$.ajax({
				type : 'POST',
				url : getRootPath() + '/news/removenews.html',
				data : jsondata,
				dataType : 'json',
				contentType : 'application/json',
				beforeSend : function(XMLHttpRequest) {
					$.messager.progress({
						title : 'Please waiting',
						msg : 'Loading data...'
					});
				},
				success : function(result) {
					$.messager.alert('立白管理系统', result.msg, 'question',
							function(r) {
								window.location.href = getRootPath()
										+ "/news/shownewslist.html";
							});
				},
				complete : function(XMLHttpRequest, textStatus) {
					$.messager.progress('close');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					top.location.href = getRootPath() + "/common/error";
				}
			});
		}
	});

}

// 编辑新闻
function editNews(objsid) {
	$.messager.confirm('立白管理系统', '确定编辑吗？', function(r) {
		if (r) {
			alert(getRootPath() + "/news/showeditnews.html?id=" + objsid);
			window.location.href = getRootPath()
					+ "/news/showeditnews.html?id=" + objsid;
		}
	});
}