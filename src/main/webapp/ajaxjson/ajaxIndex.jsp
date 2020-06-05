<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.0.min.js"></script>
 <script type="text/javascript">
   function ajaxFun(url,data,dataType){
	   $.ajax({
		   url:url,
		   dataType:dataType,
		   type:"POST",
		   data:{job:data},
		   success:function(v){
			  // $("span").html(v.author+" >>> "+v.subject);
			  //console.log(v);
			  $.each(v,function(i,d){
				 $("span").append(d.deptno+"           "+d.dname+"          "+d.loc+"<br>");
			  });
			},error:function(e){
			   alert("error");
		   }
	   });//ajax
   }
   $(function(){
	   $("button").click(function(){
		   switch ($(this).attr("id")) {
		case "c1":
			ajaxFun("/orm/ajaxMap.do","oracle","text");
			break;
		case "c2":
			ajaxFun("/orm/ajaxMap.do","jsp","text");
			break;
		case "c3":
			ajaxFun("/orm/ajaxMap.do","zz","text");
			break;
		case "c4":
			ajaxFun("/orm/ajaxMap.do","hh","text");
			break;
		case "c5":
			ajaxFun("/orm/ajaxMap2.do",'11',"json");
			break;
		case "c6":
			ajaxFun("/orm/ajaxMap2.do",'13',"json");
			break;
		case "c7":
			ajaxFun("/orm/ajaxMap3.do",'',"json");
			break;

			
		default:
			break;
		}
	   });//click
   });
 </script>
<title>Insert title here</title>
</head>
<body>
<button id="c1">CLick1</button><button id="c2">CLick2</button><button id="c3">CLick3</button><button id="c4">CLick4</button><button id="c5">CLick5</button>
<button id="c6">CLick6</button><button id="c7">CLick7</button>
<br>
<h1><span></span></h1>


</body>
</html>