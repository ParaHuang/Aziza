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
	Main Page<br>
	Welcome!${user.name }   <br>
	<!-- the expression language user.name is acctually using user.getName() -->
	all the products
	<br>
	
	<table width="800" border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>name</th>
				<th>price</th>
				<th>picture</th>
				<th>description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="p">
				<tr>
					<td>${p.no }</td>
					<td>${p.name }</td>
					<td>${p.price }</td>
					<td><img width="100px" src="img/${p.picture }"/></td>
					<td>${p.descirption }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
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