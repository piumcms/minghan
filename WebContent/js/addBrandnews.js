

 $(document).ready(function() { 
	//保存Brand
	 var proId=$("#id").val()?$("#id").val():"no data";
	 $.ajax({
	    	type : 'GET',
			url : ctx+'/tag/getTagData?productId='+proId+'&type=news',
			dataType : 'json',
			success:function(data){
				var str="";
				var tagRelations=null;
				if(data.tagRelations){
					tagRelations=data.tagRelations;
				}
				if(data.tags){
					var tags=data.tags;
					for(var i=0;i<tags.length&&tags[i].id;i++){
						var c="";
						if(tagRelations){
							for(var j=0;j<tagRelations.length&&tagRelations[j].tagId;j++){
								if(tags[i].id==tagRelations[j].tagId){
									c='checked="checked" ';
								}
							}
						}
						str+='<input name="tag" type="checkbox" value="'+tags[i].id+'" '+c+' />'+tags[i].tag+'&nbsp;&nbsp;&nbsp;&nbsp;';						
					}
				}
				$("#tags").append(str);
			}
		 
	 });
	 
 });
 
