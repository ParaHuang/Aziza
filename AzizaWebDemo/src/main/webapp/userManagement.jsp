<%@page import="com.amazon.dao.UserDao"%>
<%@page import="com.amazon.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<table border="1">
		<thead>
			<tr>
				<th>Username</th>
				<th>Phonenumber</th>
				<th>Name</th>
				<th>Email</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			
			<%
			UserDao dao = new UserDao();
			ArrayList<User> list = dao.queryAllUsers();
			for (int i = 0; i < list.size(); i++) {
				User u = list.get(i);
			%>
			
			<tr>
				<td><%=u.getUsername() %></td>
				<td><%=u.getPhonenumber() %></td>
				<td><%=u.getName() %></td>
				<td><%=u.getEmail() %></td>
				<td><%=u.getLocation() %></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>






</body>
</html>