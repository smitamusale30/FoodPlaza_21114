<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%
		ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("showAllCart");
	%>
<form action="OrderServlet" method="post">
	<table border="2">
		<caption>Cart List</caption>
		<tr>
			<th>CartID </th>
			<th>FoodID</th>
			<th>Food Quantity</th>
			<th>Food Price</th>
			<th>Total Price</th>
			<th>Customer EmailID</th>
			<th colspan="2">Action</th>
		
		</tr>
		<%
			Iterator <Cart> i = cart.iterator();
		Cart c=new Cart(); 
			while (i.hasNext()) {
				c = i.next();
		%>

		<tr>
			<td><%= c.getCartID()%></td>
			<td><%=c.getFoodID()%></td>
			<td><%=c.getFoodQuantity()%></td>
			<td><%=c.getFoodPrice()%></td>
			<td><%=c.getTotalPrice()%></td>
			<td><%=c.getCustEmailID()%></td>
			<td><a href="CartServlet?choice=delete&CartID=<%=c.getCartID()%>">Remove</a></td>
<%-- 			<td><a href="CartServlet?choice=clear&custEmailID=<%=c.getCustEmailID()%>">Clear</a></td>
 --%>			
		</tr>
				
	<%
			}
	%>
	</table>
		<%
				if (c.getCartID()!=0) {
			%>
			<input type="submit" value="Place Order">
			<%
				} 
			%>
				
	
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>