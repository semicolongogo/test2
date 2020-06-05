<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <a href="/orm/mvcLocation1.do">Location1</a>
   <a href="/orm/mvcLocation2.do">Location2</a>
   <!-- <a>는 무조건 GET 방식이다!!!!!!!!!!!! -->
   <form action="/orm/mvcLocation3.do" method="get">
      <input type="text" name="msg">
      <input type="text" name="no">
      <input type="submit" value="Send">
   </form>
    <a href="/orm/mvcLocation4.do?job=info&no=5">Location4</a>
</body>
</html>