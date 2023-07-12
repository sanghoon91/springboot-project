/**
 * 
 */
function goodsSummited(){
	var data=$("#form-goods").serialize();
	
	  var token = $("meta[name='_csrf']").attr('content');
    var header = $("meta[name='_csrf_header']").attr('content');
    if(token && header) {
        $(document).ajaxSend(function(event, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }
	//console.log(data);
	$.ajax({
		url:"/admin/goods",
		type:"post",
		data: data,
		success: function(result){
			$("a[href='/admin/goods/new']").trigger("click");
		}
	});
	
}

 function tempUpload(fileEl){
	 console.log($(fileEl));
	 var fileData=$(fileEl)[0].files[0];
	 var formData = new FormData();
	 formData.append("temp", fileData);
	 
	  var token = $("meta[name='_csrf']").attr('content');
    var header = $("meta[name='_csrf_header']").attr('content');
    if(token && header) {
        $(document).ajaxSend(function(event, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }
	 $.ajax({
		 url:"/admin/goods/temp-img",
		 type:"POST",
		 contentType: false,
		 processData: false,
		 data: formData,
		 success: function(resultMap){
			 $(fileEl).parent().css("background-image",`url(${resultMap.imgUrl})`);
			 $(fileEl).parents(".img-wrap").find(".orgName").val(resultMap.orgName);
			 $(fileEl).parents(".img-wrap").find(".newName").val(resultMap.newName);
			 $(fileEl).parents(".img-wrap").find(".tempKey").val(resultMap.tempKey);
			 
			 var def=$(fileEl).parents(".img-wrap").find(".def").val();
	
			 if(def=="true")return;//대표이미지이면 함수종료
			 }
	});
}