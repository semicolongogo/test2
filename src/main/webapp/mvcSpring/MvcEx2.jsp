<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <a href="/orm/headerAction.do">Click1</a>
   <a href="/orm/headerAction2.do">Click2</a>
   <form action="/orm/cookieTest.do">
     <input type="radio" name="color" value="blue">blue
     <input type="radio" name="color" value="red">red
     <input type="radio" name="color" value="lime">lime
     <input type="radio" name="color" value="yellow">yellow
     <button type="submit">Send</button>
   </form>
   <h1>${cookie }</h1>
   
</body>
</html>