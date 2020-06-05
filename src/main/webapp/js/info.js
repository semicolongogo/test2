function actionFun(action,state,data){
	var subject = $("input[name='subject']").val();
	var contents = $("input[name='contents']").val();
	if(state=='true'){
		if(action=='del'){
			alert('선택한 글을 삭제 하였습니다.');
			$("form#submitFun").submit();
		}else{
			$.ajax({
				url:"modInfo.do",
				dataType:"text",
				Type:"POST",
				data:{no:data,subject:subject,contents:contents},
				success:function(v){
					alert("해당글을 수정 하였습니다.");
					//$("input[name='subject']").hide();
					//$("input[name='contents']").hide();
					location.reload();//새로고침
				},error:function(e){
					alert("error!");
				}
			});
			//alert(subject+" "+contents);
		}
	}else{
		alert("비번이 틀렸수!!");
	}
}
function ajaxProcess(data,pass,action){
	$.ajax({
		url:"passwordCheck.do",
		dataType:"json",
		Type:"GET",
		data:{no:data,password:pass,action:action},
		success:function(v){
			//alert(v.action);
			actionFun(v.action,v.state,data);
			/*if(v.state=='true'){
			    alert('선택한 글을 삭제 하였습니다.');
				//document.location.href='/orm/deleteif.do?no='+data;
				$("form#submitFun").submit();
			}else{
				alert("비번이 틀렸수!!");
			}*/
			
			//ajax는 값을 받는 것이다. 무언가를 실행하고 페이지 이동까지 할려면 ajax 사용 금지!!!!!!
			//즉 ajax는 해당 페이지에 머물러 있으면서 값을 변경 할때 사용 
			
			/*if(v.state=='true'){
				
				//$("input[name='no']").val(data);
			}else{
				alert("비번이 플렷수")
			}*/
		},error:function(e){
			alert("error!");
		}
	});
}
$(function(){
	$("input[name='subject']").hide();
	$("input[name='contents']").hide();
	$("#password").hide();
	
	$("i").click(function(){
		var data = $(this).attr("id").split("#");
		var label = $(this).text();
		
		if($(this).text()=='Del'){
			//alert($("input#password").val());
			ajaxProcess(data[1],$("input#password").val(),"del");
		}else if($(this).text()=='Mod'){
			ajaxProcess(data[1],$("input#password").val(),"mod");
		}
		/*else if(label=='삭제'||label=='Del'){
			
		}*/
		//$("#password").show(500).fadeOut(500).fadeIn(500);
		if(data[0]=="mod"){
			if(label=="수정"){
				$(this).text("Mod");
				$("#password").show(500);
				$("input[name='subject']").show(500);
				$("input[name='contents']").show(500);
			}
			if(label=="Mod"){
				$(this).text("수정");
				$("#password").fadeOut(500);
			}
			
			
		}else if(data[0]=="del"){
			if(label=="삭제"){
				$(this).text("Del");
				$("#password").show(500)
			}
			if(label=="Del"){
				$(this).text("삭제");
				$("#password").fadeOut(500);
			}
			
			/*//ajax
*/		}	
	});
	
	
	/*$("button#like").click(function(){
		if($("i#likecnt").text()=="0"){
			$("i#likecnt").text("1");
			$("i#hatecnt").text("0");
		}else{
			checkFun();
		}
		
	});
	$("button#hate").click(function(){
		if($("i#hatecnt").text()=="0"){
			$("i#hatecnt").text("1");
			$("i#likecnt").text("0");
		}else{
			checkFun();
		}
	});*/
	// 사기 좋아요 싫어요 
	$("button#like").click(function(){
		var data = $("input#good").attr("lang");
		if($("input#good").val()==0){
			goodFun(data,"plusg");
		}else{
			goodFun(data,"minus");
		}		
	});
	$("button#hate").click(function(){
		var data = $("input#bad").attr("lang");
		if($("input#bad").val()==0){
			goodFun(data,"plusb");
		}else{
			goodFun(data,"minus");
		}	
	});
	
	
	$("button#down").click(function(){
		//$("button#down").attr("formaction")
		//alert($(this).attr("lang"));
		document.location.href='downLoad.do?fileName='+$(this).attr("lang");
	});
	
/*	$("a#scrabFun").click(function(){
		$("form#scrabFun").submit();
	});*/
	
	
});
function goodFun(data,action){
	$.ajax({
		url:"goodUpdate.do",
		dataType:"text",
		Type:"POST",
		data:{no:data,action:action},
		success:function(v){
			location.reload();
		},error:function(){
			alert('error');
		}
	});//ajax
}

// 사기 좋아요 싫어요 
/*function checkFun(){
		$("i#likecnt").text("0");
		$("i#hatecnt").text("0");
	
}*/