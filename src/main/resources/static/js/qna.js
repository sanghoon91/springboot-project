/**
 * 
 */
$(function(){
	//qna 자주하는질문 문의하기
	$(".qna-up-area a").click(qnaClicked)
	//faq 열고닫기
	$(".menu").click(menuClicked);
	$(".qna-write a").click(qnaClicked)
	
	
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

