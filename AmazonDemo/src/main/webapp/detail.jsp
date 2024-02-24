<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function buy(){
	if(${user==null}){
		//haven't login yet
		//show infomation dialog
		//alert("you haven't logged yet, click [ok] to login")
		//show option dialog, confirm() will return you true / false,true:ok , false:cancle
		if(confirm("you haven't logged yet, click [ok] to login")){
			//set the location as login.jsp
			location.href="login.jsp";
		}
	}else{
		//buy it
		location.href="BuyServlet?pNo=${product.no}&price=${product.price}";
	}
}

</script>
</head>
<body>
<h1>${product.name }</h1>
<h1 style="color:red">
${product.price }
<button onclick="buy()">buy it</button>
</h1>
<h3>${product.descirption }</h3>
<img src="img/${product.picture }"/>

</body>
</html>




