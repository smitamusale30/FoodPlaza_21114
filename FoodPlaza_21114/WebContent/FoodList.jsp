<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Food"%>
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
		String aname = (String) session.getAttribute("aname");
		String cname = (String) session.getAttribute("cname");
	%>
	<%
		ArrayList<Food> food = (ArrayList<Food>) session.getAttribute("showAll");
	%>

	<table border="2">
		<caption>Food List</caption>
		<tr>
			<th>Food ID</th>
			<th>Food Name</th>
			<th>Food Type</th>
			<th>Food Category</th>
			<th>Food Description</th>
			<th>Food Price</th>
			<%
				if (aname != null && cname == null) {
			%>
			<th colspan="2">Action</th>
			<%
				} else if (cname != null && aname == null) {
			%>
			<th >Action</th>
			<%
				}
			%>
			

		</tr>
		<%
			Iterator<Food> i = food.iterator();
			while (i.hasNext()) {
				Food f = i.next();
		%>

		<tr>
			<td><%=f.getFoodID()%></td>
			<td><%=f.getFoodName()%></td>
			<td><%=f.getFoodType()%></td>
			<td><%=f.getFoodCategory()%></td>
			<td><%=f.getFoodDescription()%></td>
			<td><%=f.getFoodPrice()%></td>
			<%
				if (aname != null && cname == null) {
			%>
			<td><a href="FoodServlet?choice=delete&fid=<%=f.getFoodID()%>">Remove</a></td>
			<td><a href="FoodServlet?choice=update&fname=<%=f.getFoodName()%>">Edit</a></td>

			<%
				} else if (cname != null && aname == null) {
			%>
			<td><a
				href="CartServlet?choice=addtocart&fname=<%=f.getFoodName()%>">Add_to_Cart</a>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>