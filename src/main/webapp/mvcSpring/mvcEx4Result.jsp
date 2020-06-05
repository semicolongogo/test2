<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mvcEx4Result</title>
</head>
<body>
List
<c:forEach var="i" items="${paramValues.strMsg }">
<h1>${i }</h1>
</c:forEach>
<%-- <h1>${paramValues.strMsg[0] }</h1>
<h1>${paramValues.strMsg[1] }</h1>
<h1>${paramValues.strMsg[2] }</h1>
<h1>${paramValues.strMsg[3] }</h1> --%>

String<h2>${msg }</h2>
bean<h3>${pb }</h3>
map<h4>${map }</h4>

 <%-- <%
  String[]str=request.getParameterValues("strMsg");
  for(int i=0;i<str.length;i++){
	  out.println(str[i]);
  }
%>  --%>
<br>
<h1>Job : ${param.job }</h1>
<h1>No : ${param.no }</h1>

</body>
</html>