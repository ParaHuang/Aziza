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
<!-- 
tr:   table row
th:   table head
tbody:  table body, where we put data
td:	  table data
 -->
<table border="1" width="500" cellspacing="0">
	<thead>
		<tr>
			<th>username</th>
			<th>phone number</th>
			<th>name</th>
			<th>email</th>
			<th>location</th>
		</tr>
	</thead>
	<tbody>
	<%
	UserDao dao = new UserDao();
	ArrayList<User> list = dao.queryAllUsers();
	for(User u:list){%>
		<tr>
			<td><%=u.getUsername() %></td>
			<td><%=u.getPhonenumber() %></td>
			<td><%=u.getName()%></td>
			<td><%=u.getEmail() %></td>
			<td><%=u.getLocation() %></td>
		</tr>
	<%	}%>
	</tbody>

</table>
</body>
</html>