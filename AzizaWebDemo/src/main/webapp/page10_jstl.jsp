<%@page import="java.util.ArrayList"%>
<%@page import="com.amazon.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<User> list = new ArrayList<>();
	for(int i=1 ; i<=10 ; i++){
		list.add(new User("username"+i,"pwd"+i,"+861536666777"+i,"Jack"+i,null,null));
	}
	//pageContext
	pageContext.setAttribute("list", list);
	//request
	//session
	//application
%>



<%-- <c:forEach></c:forEach> --%>

immitate：<br>
for(int i=0 ; i < list.size() ; i++){<br>
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(list.get(i))<br>
}<br>
<c:forEach var="i" begin="10" end="40" step="2">
	${i } <br>
</c:forEach>
<br><br><br>
<c:forEach var="i" begin="0" end="${list.size() }">
	${list[i].username }--${list[i].name }<br>
</c:forEach>
<br><br><br>
immitate：<br>
for(User u:list){<br>
&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(u)<br>
}<br>
<c:forEach items="${list }" var="u">
	${u.username }--${u.phonenumber }<br>
</c:forEach>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



<%-- <c:if test=""></c:if> --%>
<%-- <c:choose></c:choose> --%>
<%-- <c:when test=""></c:when> --%>

<!-- ctrl+/:  comment -->
<!-- alt+/ :  reminder-->

</body>
</html>