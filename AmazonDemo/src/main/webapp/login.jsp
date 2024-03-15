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
	//String username = "";
	//String password = "";
	//Cookie
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			/* out.println(c.getName());//--key
			out.println(c.getValue());//--value */
			//if(c.getName().equals("username")){
			//	username = c.getValue();
			//}
			//username-Para
			//password-1122
			//JSESSIONID-xxxxxxxxxxxxxxxxxxxx
			//if(!c.getName().equals("JSESSIONID"))
			pageContext.setAttribute(c.getName(), c.getValue());
		}
	}
%>
<!-- get:request the request(get something from server)
post:submit infomation to server -->
<form action="LoginServlet" method="post">
	username:<input name="username" value="${username }"/><br>
	password:<input name="password" value="${password }"/><br>
	<button>Login</button>
</form>
<a href="register.jsp">register</a>
</body>
</html>








