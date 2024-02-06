<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
page4-6:show you how to use pageContext and Session<br>
and you can see pageContext only works in the present page(we don't use it very often)<br>
session:works in the whole client, so you can see it in page5,6
<%
	session.setAttribute("msg", "this is a message saved in session");
	//session.setMaxInactiveInterval(5);//5seconds,default time is 30 mins
	//out.println(application.getRealPath(""));
	
	pageContext.setAttribute("msgPage", "message saved in PageContext object");
%>

${msgPage }

</body>
</html>