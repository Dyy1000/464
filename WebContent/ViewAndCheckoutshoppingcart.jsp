<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.logout{

   position:fixed;
   right:10px;
   top:5px;
}
#cart{
border-style: solid;
width: 50%;
}
#notfound{
display:none;
}
.invis{
display:none;
}
</style>
</head>
<body>
<form action=CustomerHomePage.jsp>
<button type= submit>Home</button>
</form>
<form action=Welcome.jsp>
<button type= submit class=logout>Logout</button>
</form>
<h1>Shopping Cart</h1>
<form action=Shopping>
<div id= cart>
<p>Concert Identifier: ${shoppingcartinfo.id} </p>
<p>ticket quantity: ${shoppingcartinfo.quantity} </p>
<p>ticket type:${shoppingcartinfo.type}  </p>
<p>Movie Name:${shoppingcartinfo.band} </p>
<p>thumbnail: ${shoppingcartinfo.thumbnail}</p>
<p>Venue name :${shoppingcartinfo.venue} </p>
<p>Show time:${shoppingcartinfo.time}</p>
<button type=submit>Delete</button>
</div>
<div id=notfound>
<h3>Nothing in cart yet</h3>
</div>
<p>Total Price:${shoppingcartinfo.total}</p>
<input class="invis" id=con name= conid value='0'>

</form>
<script>
var a=0;
var b=${shoppingcartinfo.id};
var del = document.getElementById("cart");
if(a==b){
del.style.display="none";
document.getElementById("notfound").style.display="block";
}

</script>
<form action=CustomerTransaction.jsp >
<button type= submit class=checkout>Check Out</button>
</form>
</body>
</html>