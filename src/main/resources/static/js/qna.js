/**
 * 
 */
$(function(){
	$(".qna-up-area a").click(qnaClicked);	
	$(".menu").click(menuClicked);
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

function menuClicked(){
	
	var check=$(this).hasClass("open");
	$(".menu").removeClass("open");
	if(!check){
		$(this).addClass("open");
	}
}
