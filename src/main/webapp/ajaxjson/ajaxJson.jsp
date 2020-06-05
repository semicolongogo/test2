<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
    $(function(){
    	$("button#d1").click(function(){
    		$.ajax({
    			url:"/orm/jsonView.do",
    			dataType:"json",
    			type:"GET",
    			success:function(v){
    				console.log(v);
    			}
    		});
    	});
    });
</script>
</head>
<body>

<button id="d1">DEPTLIST</button>

</body>
</html>