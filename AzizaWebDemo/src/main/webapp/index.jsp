<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>${msg }
protocol://ip:port/contextRoot/resource<br>
http://localhost:8080/AzizaWebDemo/index.jsp<br>

localhost:the present machine,we also can use 127.0.0.1 or the real ip address<br>
<h1>welcome to the new page</h1>
jsp  = html + java<br>
<%
	Random rand = new Random();
	int x = rand.nextInt(100);
	//print in console
	System.out.println("generate a number:"+x);
	out.print(x);
%>

Expression:write the value in web page<br>
<%=100 %>
<br>
<%=x %>
because expression is a java code:    out.print(xxx);

<%
	for(int i=1 ; i<=10 ; i++){
		//in page, to write 10 titles()
	%>
		<h1 style="color:green">title<%=i %></h1>	
<%	}%>

<img alt="" src="img/IMG_2093.PNG" width="400"><br>
<a href="http://www.baidu.com"> baiDu </a>

</body>












</html>