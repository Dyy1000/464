<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-
awesome/4.7.0/css/font-awesome.min.css">
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
<title>Detail</title>
</head>
<body>

<form action=CustomerHomePage.jsp>
<button type= submit>Home</button>
</form>
<form action=Welcome.jsp>
<button type= submit class=logout>Logout</button>
</form>
<form action=Shopping>

<p>concert detail</p>
<ul>
<li>Movie's name: ${concertthing.moviename}</li>
<li>Band description: ${concertthing.description}</li>
<li>Band poster: Something</li>
<li>Start time: ${concertthing.moviename}</li>
<li>opening act : yes</li>
<li>Venue: ${concertthing.venue}</li>
<li>Show time :${concertthing.starttime}</li>
<li>price: ${concertthing.price}</li>
<li>AvaiLable Seats: 1000</li>

</ul>

<input class="invis" name= conid value='${concertthing.id}'>
<input class="invis" name=conqun id="quan" value=1>
<input class="invis" name=contype id="tickettype" value="Floor seat">
<input class="invis" name=conname value='${concertthing.moviename}'>
<input class="invis" name=conthumb value='${concertthing.thumbnail}'>
<input class="invis" name=convenue value='${concertthing.venue}'>
<input class="invis" name=contime value='${concertthing.starttime}'>
<input class="invis" name=conprice value='${concertthing.price}'>

<select id="selectticket" onchange=ticketselection()>
<option value='Floor seat'>Floor seat</option>
<option value=balcony>balcony</option>
</select>

<p>quantity 
<select id="mySelect" onchange=myFunction()>
<option value=1>1</option>
<option value=2>2</option>
<option value=3>3</option>
<option value=4>4</option>
<option value=5>5</option>
<option value=6>6</option>
</select>
</p>
<button type= submit>Add to Cart</button>
</form>
<h2>Overall Rating: ${concertthing.rating} Star</h2>
<!-- <span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span> -->
<h3>Latest Review</h3>
<form action=CustomerReview.jsp>
<h1>${reviewinfo.person}</h1>
<p>${reviewinfo.rating}</p>
<p>${reviewinfo.content}</p>

<!-- <span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span> -->
<span >${reviewinfo.date}</span>
<button type= submit>Add Review</button>
</form>

<form action=ConcertSearchResult.jsp>
<button type= submit>Back</button>
</form>
<script>
function myFunction() {
	  var x = document.getElementById("mySelect").value;
	  document.getElementById("quan").value = x;
     }
function ticketselection(){
	var y= document.getElementById("selectticket").value;
	document.getElementById("tickettype").value = y;
}
	
	
</script>
</body>
</html>