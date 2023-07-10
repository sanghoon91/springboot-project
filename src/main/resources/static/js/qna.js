/**
 * 
 */
$(function(){
	$(".qna-up-area a").click(qnaClicked);	
	$(".menu").click(menuClicked);
	$(".wrap a").click(qnaClicked);
	
})

function qnaClicked(event){
	event.preventDefault();
	
	$.get(
		$(this).attr("href"),
		function(resultMain){
			$(".wrap").html(resultMain);
		}
	)
}
function qnaBoardDetail(no){
	$.ajax({
		url:`/qna-board/${no}`,
		success: function(result){
			$(".wrap").html(result)
		}
	})
}


function menuClicked(){
	
	var check=$(this).hasClass("open");
	$(".menu").removeClass("open");
	if(!check){
		$(this).addClass("open");
	}
}

function qnaSubmitted(){
	var formData= $("#form-qna-write").serialize();
	$.ajax({
		url:"/qna-board/write",
		type:"POST",
		data: formData,
		success:function(){
			$("a[href='/qna-board']").trigger("click");
			alert("등록")
		}
	});
}

