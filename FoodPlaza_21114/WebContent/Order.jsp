<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Page</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
		String aname = (String) session.getAttribute("aname");
		String cname = (String) session.getAttribute("cname");
	%>
<%
		ArrayList<Order> order = (ArrayList<Order>) request.getAttribute("ShowOrder");
	%>
<form action="OrderServlet" method="get">
	<table border="2">
		<caption>Order List</caption>
		<tr>
			<th>OrderID </th>
			<th>Customer Address</th>
			<th>Total Price</th>
			<th>Order Date</th>
				<%
				if (aname != null && cname == null) {
			%>
			<th >Customer EmailID</th>
			<%
				} else if (cname != null && aname == null) {
			%>
			
			<%
				}
			%>
			
		</tr>
		<%
			Iterator <Order> i = order.iterator();
		/* Order o=new Order();  */
			while (i.hasNext()) {
				Order o = i.next();
		%>

		<tr>
			<td><%= o.getOrderID()%></td>
			<td><%=o.getCustAddress()%></td>
			<td><%=o.getTotalPrice()%></td>
			<td><%=o.getOrderDate()%></td>
				<%
				if (aname != null && cname == null) {
			%>
			<td><%=o.getCustEmailID()%></td>
			<%
				} else if (cname != null && aname == null) {
			%>
			
			<%
				}
			%>
			
		</tr>
				
	<%
			}
	%>
	</table>		
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>