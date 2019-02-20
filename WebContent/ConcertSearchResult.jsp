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
<p id=nores>result not found</p>


<table id=table>
<tr>

<th>${concertinfo.moviename}</th>
<th><button type="submit" >View Detail</button></th>

</tr>
<tr>
<td>Building</td>
<td>Avery hall</td>
</tr>
<tr>
<td>Start time</td>
<td>Dec 11,2019</td>
</tr>
<tr>
<td>Avaliable Seats</td>
<td>1000</td>
</tr>
<tr>
<td>Price</td>
<td>100$</td>
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
<form action=CustomerHomePage.jsp>
<button type= submit>Back</button>
</form>
<script>

</script>

</body>
</html>