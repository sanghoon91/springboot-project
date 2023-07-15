/**
 * 
 */



	
function pay(btnTag) {
		var amount=$(btnTag).siblings("#amount").val();
		var name=$(btnTag).siblings("#name").val();
		
		alert(amount);
		alert(name);
 	const IMP = window.IMP; // 생략 가능
	IMP.init("imp06453507"); // 예: imp00000000a
    IMP.request_pay({
      pg: "kcp",
      pay_method: "card",
      merchant_uid: "ORD+new Date().getTime()",   // 주문번호
      name: name,
      amount: amount,                         // 숫자 타입
      buyer_email: "admin@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
     var msg="";
     if(rsp.success){
		 msg="결제완료";
	 }else{
		 msg="결제실패";
	 }
	 alert(msg);
    });
  }