$(function(){
	$("input#password").on("keyup",function(){
		$("font#chkNotice").html("");
	});
	$("input#passord2").on("keyup",function(){
		if($("input#password").val()!=$("input#passord2").val()){
			$("font#chkNotice").html("비밀번호가 일치하지 않음<br><br>");
			$("font#chkNotice").attr("color","red");
		}else{
			$("font#chkNotice").html("비밀번호가 일치합니다.<br><br>");
			$("font#chkNotice").attr("color","blue");
		}
	});
	
	$("a#signup").click(function(){
		$("form#signupsubmit").submit();
	});
	
	
	
});