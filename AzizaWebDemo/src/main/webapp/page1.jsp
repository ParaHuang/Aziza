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
Page 1:

<%
	UserDao dao = new UserDao();
	int rows = dao.addUser("alex","1234","15344433322","Alex D",null,null);
	if(rows>0){
		
		//JSP = html + java(compile as .class, then we can use it)
		//JSP : 1.translate into java
		//   everything in scriptlet will transfer into java code directlt
		//   every html code will transfer into out.write("html code");
		//2. compile  this java file into .class file
		//Invisible scope
	%>
		<h1 style="color:red">successfully</h1>
	<%}else{%>	
		<h1 style="color:blue">failed</h1>
	<%}%>
</body>
</html>