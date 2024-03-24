<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddProductServlet" method="post" enctype="multipart/form-data">
product name:<input name="name"/><br>
product price:<input name="price"/><br>
product image:<input type="file" name="picture"><br>
product description:<textarea name="description" rows="10" cols="50"></textarea><br>
<input type="submit">

</form>
</body>
</html>