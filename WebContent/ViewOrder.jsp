<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="lecture464.model.OrdersDB"%>
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
.order{
border-style: solid;
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
<div class="order">
<p>Order Number:</p>
<p>Order Total;1</p>
<p>Ordered date:Jan 11,2019</p>
<form action=ManageOrder.jsp>
<button type= submit>View</button>
</form>

<%OrdersDB order=new OrdersDB();
  String txt="${userinfo.id}";
%>
<%=txt %>
</div>

</body>
</html>