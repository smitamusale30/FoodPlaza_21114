<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Customer"%>
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
		ArrayList<Customer> customer = (ArrayList<Customer>) session.getAttribute("showAllCustomer");
	%>

	<table border="2">
		<caption>Customer List</caption>
		<tr>
			<th>Customer EmailID</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
			<th>Customer ContactNo</th>
			<th>Customer Password</th>
			<th colspan="2">Action</th>
		
		</tr>
		<%
			Iterator <Customer> i = customer.iterator();
			while (i.hasNext()) {
				Customer c = i.next();
		%>

		<tr>
			<td><%= c.getCustEmailID()%></td>
			<td><%=c.getCustName()%></td>
			<td><%=c.getCustAddress()%></td>
			<td><%=c.getCustContactNo()%></td>
			<td><%=c.getCustPassword()%></td>
	<%-- 		<td><a href="CustomerServlet?choice=delete&custEmailID=<%=c.getCustEmailID()%>">Remove</a></td> --%>
<%-- 			<td><a href="CustomerServlet?choice=update&custEmailID=<%=c.getCustEmailID()%>">Edit</a></td>
 --%>			
		</tr>
		<%
			}
	%>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>