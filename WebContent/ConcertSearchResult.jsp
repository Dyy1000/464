<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lecture464.model.ConcertsDB"%>
<!DOCTYPE html>
<html>
<head>
<style>
.invis{
   display: none;
}
.logout{

   position:fixed;
   right:10px;
   top:5px;
}
table
{border-style: dashed;}
</style>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>

<form action=Welcome.jsp>
<button type= submit class=logout>Logout</button>
</form>

<form action=ViewOrder.jsp>
<button type= submit>View Order</button>
</form>

<form action=ConcertSearchResult>
<input type=text class="invis" name=concert value="${concertinfo.name}">
<input type=text class="invis" name=venue value="${concertinfo.venue}">
<input type=text class="invis" name=time value="${concertinfo.starttime}">
<input type=text class="invis" name=price value="${concertinfo.price}">
<table id=table>
<tr>

<th>${concertinfo.name}</th>
<th><button type="submit" >View Detail</button></th>

</tr>
<tr>
<td>Building</td>
<td>${concertinfo.venue}</td>
</tr>
<tr>
<td>Start time</td>
<td>${concertinfo.starttime}</td>
</tr>
<tr>
<td>Avaliable Seats</td>
<td>1000</td>
</tr>
<tr>
<td>Price</td>
<td>${concertinfo.price }</td>
</tr>
<tr>
<td>Opening act</td>
<td>yes</td>
</tr>
<tr>
<td>Thumbnail</td>
<td>${concertinfo.thumbnail}</td>
</tr>
</table>
</form>
<form action=CustomerHomePage.jsp>
<button type= submit>Back</button>
</form>
<script>

</script>

</body>
</html>