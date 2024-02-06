<%@page import="com.amazon.bean.User"%>
<%@page import="java.util.ArrayList"%>
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
	UserDao dao = new UserDao();
	ArrayList<User> list = dao.queryAllUsers();
	for(User u:list){%>
		
		
		<%=u.getUsername()%>
		<%=u.getPassword() %>
		<%=u.getPhonenumber() %>
		<%=u.getName() %>
		<%=u.getEmail() %>
		<%=u.getLocation() %>
		
		<br>
		
		
		
<%	}%>
</body>
</html>