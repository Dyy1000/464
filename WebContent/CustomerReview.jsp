<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerReview</title>
</head>
<style>
.invis{
   display: none;
}
</style>
<body>
<form action=CustomerReview>
<h3>Your review for ${concertthing.moviename}</h3>
<br>
Today's date:<p id= demo></p>
Rating: 
<select id="mySelect" onchange=myFunction()>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select> star
<br>
<input class="invis" name=concertid value='${concertthing.id}'>
<input class="invis" id="result" name=result value=1>
<input class="invis" id="date" name=date >
<input size="40" name=cusreview >
<button type= submit>submit</button>
</form>

<form action=ConcertDetailandSelection.jsp>
<button type= submit >cancel</button>
</form>
</body>
<script>
var d = new Date();
var n = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
document.getElementById("demo").innerHTML = n;
document.getElementById("date").value = n;

function myFunction() {
	  var x = document.getElementById("mySelect").value;
	  document.getElementById("result").value = x;
       }
</script>
</html>