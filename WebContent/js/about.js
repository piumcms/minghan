$(document)
		.ready(
				function() {
					// 保存Brand
					$("#submit")
							.click(
									function() {
										var obj = new Object();
										obj.id = $('#id').val();
										/*obj.brandId = $(
												"#brandId option:selected")
												.val();*/
										obj.brandType = $("#brandType").val();//$("#brandId option:selected").attr("brandTypeValue");
										obj.category = $("#ctype").val();
										obj.title = $("#title").val();
										if (obj.title == "") {
											$.messager.alert('立白管理系统',
													'标题不能为空!', 'warning');
											return false;
										}
										if ($("#createTime").length > 0) {
											if ($("#createTime").val() == "") {
												$.messager.alert('立白管理系统',
														'创建时间不能为空', 'warning');
												return false;
											}
											obj.createTime = $("#createTime")
													.val();
										}

										var html = editor1.html();
										if (html == "") {
											$.messager.alert('立白管理系统',
													'内容不能为空', 'warning');
											return false;
										}
										$("#content").val(html);
										obj.content = $("#content").val();
										var jsondata = $.toJSON(obj);
										$
												.ajax({
													type : 'POST',
													url : getRootPath()
															+ '/saveBrandNews.html',
													data : jsondata,
													dataType : 'json',
													contentType : 'application/json',
													beforeSend : function(
															XMLHttpRequest) {
														$.messager
																.progress({
																	title : 'Please waiting',
																	msg : 'Loading data...'
																});
													},
													success : function(result) {
														if (result.success) {
															$.messager
																	.alert(
																			'立白管理系统',
																			result.msg,
																			'question',
																			function(
																					r) {
																				var pageNumber = $(
																						"#pageNumber")
																						.val();
																				if (pageNumber != null) {
																					window.location.href = getRootPath()
																							+ "/brand/"+$("#brandType").val()+"/list.html?category="+$("#ctype").val()+"&pageNumber="
																							+ pageNumber;
																				} else {
																					window.location.href = getRootPath()
																							+ "/brand/"+$("#brandType").val()+"/list.html?category="+$("#ctype").val();
																				}
																			});
														} else {
															$.messager
																	.alert(
																			'立白管理系统',
																			result.msg,
																			'question',
																			function(
																					r) {
																				$(
																						"#brand")
																						.val(
																								'');
																			});
														}
													},
													complete : function(
															XMLHttpRequest,
															textStatus) {
														$.messager
																.progress('close');
													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														top.location.href = getRootPath()
																+ "/common/error";
													}
												});
									});
				});
//删除
function delAboutUs(objsid) {
	$.messager
			.confirm(
					'立白管理系统',
					'确定删除吗？',
					function(r) {
						if (r) {
							var obj = new Object();
							obj.id = objsid;
							var jsondata = $.toJSON(obj);
							$
									.ajax({
										type : 'POST',
										url : getRootPath()
												+ '/removeBrandNews.html',
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
											$.messager
													.alert(
															'立白管理系统',
															result.msg,
															'question',
															function(r) {
																var pageNumber = $(
																		"input[name='pageNumber']")
																		.val();
																window.location.href = getRootPath()
																	+"/brand/"+$("#brandType").val()+"/list.html?category="+$("#ctype").val()+"&pageNumber="
																	+ pageNumber;
															});
										},
										complete : function(XMLHttpRequest,
												textStatus) {
											$.messager.progress('close');
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											top.location.href = getRootPath()
													+ "/common/error";
										}
									});
						}
					});

}
//新建
function addAboutUs() {
	 window.location.href = (getRootPath()+"/brand/"
	 	+$("#brandType").val()+"/edits.html?category="+$("#ctype").val());
}

// 编辑
function editAboutUs(objsid) {
	$.messager.confirm('立白管理系统', '确定编辑吗？', function(r) {
		var pageNumber = $("input[name='pageNumber']").val();
		if (r) {
			window.location.href = getRootPath()+"/brand/"
					+$("#brandType").val()+"/edits.html?category="+$("#ctype").val()+"&id=" + objsid
					+ "&pageNumber=" + pageNumber;
		}
	});
}

function recommend(ob_id, subId) {

	$.messager.prompt('立白管理系统', '推荐显示,输入0，取消置顶;1.推荐置顶', function(r) {
		if (r) {

			if (!/^[0-9]*$/.test(r)) {
				alert("请输入数字!");
				return false;
			}
			var obj = new Object();
			obj.id = ob_id;
			if (subId == '0') {
				obj.allSeq = r;
			} else {
				obj.signalSeq = r;
			}

			var jsondata = $.toJSON(obj);
			$.ajax({
				type : 'POST',
				url : getRootPath() + '/brand/recommendBrandNews.html',
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

					$.messager.alert('立白管理系统', result.msg);
					$("#technologyOrBrandNewsList").submit();

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
function removeAll(tag) {

	$.messager.confirm('立白管理系统', '确定删除吗？', function(r) {
		if (r) {
			invokeRemove(tag, "brand_news_tbl", "/about/batchDelete.html");
		}
	});

}
function confirm5(ob_id) {

	$.messager.prompt('立白管理系统', '推送首页显示,输入0，取消推送;1.推送', function(r) {
		if (r) {
			if (!/^[0-9]*$/.test(r)) {
				alert("请输入数字!");
				return false;
			}
			var obj = new Object();
			obj.id = ob_id;
			obj.indexSeq = r;
			var jsondata = $.toJSON(obj);
			$.ajax({
				type : 'POST',
				url : getRootPath() + '/brand/recommendBrandNews.html',
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

					$.messager.alert('立白管理系统', result.msg);
					$("#technologyOrBrandNewsList").submit();

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
