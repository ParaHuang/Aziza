<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
page 7,8 to show request and response.<br>
use request to save information, <br>
you won't be able to use it in next page if you go to next page by redirect
but you can use it in next page if you forward
<%
	request.setAttribute("msgRequest", "message saved in request");
	//Redirection 
	response.sendRedirect("page8_request.jsp");//generate a new request,you won't be able to get the infmation in old request
	//forwarding
	//use the old request, and location to new page
	//request.getRequestDispatcher("page8_request.jsp").forward(request, response);
%>
hello page7
</body>
</html>