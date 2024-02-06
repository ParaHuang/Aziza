<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- get:request the request(get something from server)
post:submit infomation to server -->
<form action="LoginServlet" method="post">
	username:<input name="username"/><br>
	password:<input name="password"/><br>
	<button>Login</button>
</form>
<a href="register.jsp">register</a>
</body>
</html>