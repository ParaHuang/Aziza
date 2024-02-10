<%@page import="com.amazon.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("msg", "this is message saved in request");
%>


${34>30 }<br>
${34+30 }<br>
${msg }<br>
${msg==null }<br>
${user==null }
</body>
</html>