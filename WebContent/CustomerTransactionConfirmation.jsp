<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="lecture464.model.CreditCardsDB"%>
<!DOCTYPE html>
<html>
<head>
<style>
.logout{

   position:fixed;
   right:10px;
   top:5px;
}
.invis{
display:none;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=CustomerHomePage.jsp>
<button type= submit>Home</button>
</form>
<form action=Welcome.jsp>
<button type= submit class=logout>Logout</button>
</form>
<div id="success">
<h1>Transaction Confirmation</h1>
<p>Movie Name: ${shoppingcartinfo.band}</p>
<p>Ticket quantity: ${shoppingcartinfo.quantity}</p>
<p>Total Price:${shoppingcartinfo.total}</p>
<p>Venue name :${shoppingcartinfo.venue}</p>
<h3>card information</h3>
<p>card holder: ${cardinfo.cardholder}</p>
<input class="invis"id="holder" value="${cardinfo.cardholder}">
<p>card number: ${cardinfo.cardnumber}</p>
<p>type: ${cardinfo.cardtype}</p>
<p>CVV: ${cardinfo.cvv}</p>
<p>exp: ${cardinfo.expiredate}</p>
<p>submission date: ${cardinfo.proccessdate}</p>
<form action=Vieworder>
<button type= submit >view order</button>
</form>
<button>Print</button>
</div>
<div class="invis" id=fail>
<h4>Your information is invaild</h4>
<form action=CustomerTransaction.jsp>
<button type= submit >back</button>
</form>
</div>
<script>

var x=document.getElementById("holder").value;
if(x==("")){
var su=document.getElementById("success");
su.style.display = "none";
document.getElementById("fail").style.display="block";

}
	

</script>
</body>
</html>