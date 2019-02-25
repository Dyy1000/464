<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   display: none;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=Welcome.jsp>
<button type= submit class=logout>Logout</button>
</form>
<form action=CustomerTransactionConfirmation>
<p>Movie Name: ${shoppingcartinfo.band}</p>
<p>Ticket quantity: ${shoppingcartinfo.quantity}</p>
<p>Total Price:${shoppingcartinfo.total}</p>
<p>Venue name :${shoppingcartinfo.venue}</p>
<p>Card Type
<select id="cardtype" onchange=typechange()>
  <option value="visa">Visa</option>
  <option value="master">Master</option>
  <option value="discover">Discover</option>
</select>
</p>
<input class="invis" value=visa id="ctype" name=type>
<p>Card Number<input name=cardnumber value=8888888888888888></p>
<p>Security Code<input name=cvv value = 111></p>
<p>Car Holder name<input name=cardholder value= "Deng Yang"></p>
<p>EXpire Date
<select id="day" onchange=daychange()>
  <option value="01">1</option>
  <option value="02">2</option>
  <option value="03">3</option>
  <option value="04">4</option>
  <option value="05">5</option>
  <option value="06">6</option>
  <option value="07">7</option>
  <option value="08">8</option>
  <option value="09">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
  <option value="31">31</option>
</select>
<select id="month" onchange=monthchange()>
  <option value="01">Jan</option>
  <option value="02">Feb</option>
  <option value="03">Mar</option>
  <option value="04">Apr</option>
  <option value="05">May</option>
  <option value="06">Jun</option>
  <option value="07">Jul</option>
  <option value="08">Aug</option>
  <option value="09">Sep</option>
  <option value="10">Oct</option>
  <option value="11">Nov</option>
  <option value="12">Dec</option>
</select>
<select id="year" onchange=yearchange()>
  <option value="2019">2019</option>
  <option value="2020">2020</option>
  <option value="2021">2021</option>
  <option value="2022">2022</option>
  <option value="2023">2023</option>
  <option value="2023">2024</option>
  <option value="2025">2025</option>
</select></p>
<input class="invis" id=date name=date value="2000-01-01">
<input class="invis" id=currentdate name=currentdate value="">

<button type= submit >Submit Payment</button>
</form>
<form action=ViewAndCheckoutshoppingcart.jsp>
<button type= submit >Cancel payment</button>
</form>
<form action=ViewOrder.jsp>
<button type= submit >view order</button>
</form>
<script>
var day=document.getElementById("day").value;
var month=document.getElementById("month").value;
var year=document.getElementById("year").value;
var date=year+"-"+month+"-"+day;
document.getElementById("date").value=date;
function daychange(){
	day=document.getElementById("day").value;
    date=year+"-"+month+"-"+day;
	document.getElementById("date").value=date;
	
}
function monthchange(){
	month=document.getElementById("month").value;
    date=year+"-"+month+"-"+day;
	document.getElementById("date").value=date;
	
}
function yearchange(){
	year=document.getElementById("year").value;
    date=year+"-"+month+"-"+day;
	document.getElementById("date").value=date;
	
}
function typechange(){
	var type=document.getElementById("cardtype").value;
	document.getElementById("ctype").value=type;
	
}
var d = new Date();
var n = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
document.getElementById("currentdate").value = n;
</script>
</body>
</html>