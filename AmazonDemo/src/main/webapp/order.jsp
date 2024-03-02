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
<!-- get:request the request(get something from server)
post:submit infomation to server -->
${orderList }
<table width="800">
		<thead>
			<tr>
				<th>no</th>
				<th>username</th>
				<th>product name</th>
				<th>price</th>
				<th>time</th>
				<!-- <th>description</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderList }" var="o">
				<tr>
					<td>${o.no }</td>
					<td>${o.username }</td>
					<td>${o.p.name }</td>
					<td>${o.price }</td>
					<td>${o.time }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>