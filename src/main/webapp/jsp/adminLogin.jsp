<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>������</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="copyright" content="Copyright 2009 @ high1 all rights reserved" />
<link href="/orm/css/contents.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script>
   $(function(){
	   $("#btnSubmit").click(function(){
		  if($("#id").val().length==0||$("#pw").val().length==0){
			  alert('ID OR PASS Check');
			  return false;
		  }else{
			  
              if($("input#checker").is(":checked")){
            	 $("form").attr("action","/orm/login.do");
            	 $("form").submit();
            	 //alert('ddd');
			  }else {
				  //alert('test');  
				  $("form").attr("action","/orm/cookielogin.do");
				  $("form").submit();
				  //$("form").submit();
			  }
              
			//  $("form").submit();
		  } 
	   });
	   if($("input#id").val().length==0){
		   $("input#checker").prop("checked",false);
	   }else{
		   $("input#checker").prop("checked",true);
	   }
   });
</script>
</head>
<body>
<form name="login" method="post">
 <div id="loginWrapper">
  <div class="loginForm">
   <fieldset>
    <legend>������ �ý��� �α���</legend>
    <dl>
     <dt><img src="/orm/img/common/th_id.gif" alt="���̵�" /></dt>
     <dd><input type="text" name="id" class="text" id="id" value="${id }"/></dd>

     <dt><img src="/orm/img/common/th_pw.gif" alt="��й�ȣ" /></dt>
     <dd><input type="password" name="pw" class="text" id="pw" /></dd>
    </dl>
    <div class="btn">
     <img id="btnSubmit" src="/orm/img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  />
    </div>
    
    <div class="saveId"><input type="checkbox" id="checker" name="checker" /> 
     <img src="/orm/img/common/save_id.gif" alt="���̵� ����" />
    </div>
   </fieldset>
  </div>
 </div>
</form>
</body>
</html>