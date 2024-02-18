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
	pageContext.setAttribute("score", 78);
%>
1.c:if<br>
if(score>=60){<br>
	print("pass")<br>
}<br><br><br><br><br>

<c:if test="${score>=60 }">
	pass
</c:if>

<br><br><br><br>
2.c:choose<br>
if(expression1){<br>
	operationA<br>
}else if(expression2){<br>
	operationB<br>
}else if(expression3){<br>
	operationC<br>
}else{<br>
	print("something else")<br>
}<br>

<!-- 
0~29:F
30~49:E
50~59:D
60~79:C
80~89:B
90~100:A 
-->

c:choose, c:when , c:otherwise<br><br><br>
<c:choose>
	<c:when test="${score>=0 && score<30 }">
		F
	</c:when>
	<c:when test="${score>=30 && score<50 }">
		E
	</c:when>
	<c:when test="${score>=50 && score<60 }">
		D
	</c:when>
	<c:when test="${score>=60 && score<80 }">
		C
	</c:when>
	<c:when test="${score>=80 && score<90 }">
		B
	</c:when>
	<c:otherwise>
		A
	</c:otherwise>
</c:choose> 

<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>





</body>
</html>












