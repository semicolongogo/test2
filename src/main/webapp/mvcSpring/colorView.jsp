<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table{
  text-align: center;
  table-layout: 80%;
}
</style>
</head>
<body>
   <table border="1">
     
   <tr>
   <th><h1>color</h1></th>
   <th><h1>Check</h1></th>
   </tr>
   <tr>
   <td bgcolor="${color }"><h1>${color }</h1></td>
   <td><a href="/orm/cookieCheck.do">Check</a></td>
   </tr>
  
   </table>
</body>
</html>