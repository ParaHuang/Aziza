<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th{
	text-align:left
}
</style>
</head>
<body>
	Main Page<br>
	Welcome!
	<c:choose>
		<c:when test="${user!=null }">
			<!-- if you logged, then show your name -->
			<a href="order.html">${user.name }</a>
		</c:when>
		<c:otherwise>
			<!-- otherwise , then show "Guest" -->
			Guest<br>
			<a href="login.jsp">click here</a> to login
		</c:otherwise>
	</c:choose>
	
	
	
	 <br><br><br>
	<!-- the expression language user.name is acctually using user.getName() -->
	all the products
	<br>
	
	<table width="800">
		<thead>
			<tr>
				<th>no</th>
				<th>name</th>
				<th>price</th>
				<th>picture</th>
				<!-- <th>description</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="p">
				<tr>
					<td>${p.no }</td>
					<td><a href="detail.htm?no=${p.no }">${p.name }</a></td>
					<td>${p.price }</td>
					<td><img width="100px" src="img/${p.picture }"/></td>
					<%-- <td>${p.descirption }</td> --%>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="center">
				<a href="IndexServlet?page=${param.page-1 }">previous</a>
				<c:choose>
					<c:when test="${param.page==null }">
						<a href="IndexServlet?page=2">next</a>
					</c:when>
					<c:otherwise>
						<a href="IndexServlet?page=${param.page+1 }">next</a>
					</c:otherwise>
				</c:choose>
				
				
				</td>
			</tr>
		</tbody>
	</table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<!-- use link to start a request , it's get request
		1.get request will expose all the information
		2.the parameter length is limited in get request
		3.if there are foreigner characters in request parameter, then it will be messy code
		   then you need to write program to decode
	 -->
	<!-- 
		for(Product p:list){
			p.getName()
		
		}
	
	 -->
	<br>
	<!-- ctrl+/ -> comment -->
	<%-- ${user.email }<br>
	${user.location }<br>
	${user } --%>
</body>
</html>