/**
 * 
 */

function goodsDetail(goodsNo){
	$.ajax({
		url: `goods/${goodsNo}`,
		success: function(result){
			$("main>.grid-container").html(result);
		}
		
	});
}