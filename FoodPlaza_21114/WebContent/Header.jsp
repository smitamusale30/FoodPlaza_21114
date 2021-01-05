<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FOOD PLAZA</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
String aname=(String)session.getAttribute("aname");
String cname=(String)session.getAttribute("cname");
%>
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<div id="templatemo_menu">
			<ul>
				<li class="current"><a href="index.jsp"><b>Home</b></a></li>
				<%if(aname==null && cname==null) {%>
				<li><a href="RegisterCustomer.jsp"><b>Register</b></a></li>
				<li><a href="Login.jsp"><b>Login</b></a></li>
				<li><a href="FoodServlet"><b>Food Menu</b></a></li>
				
				<%}else if(aname==null && cname!=null) { %>
				<li><a href="FoodServlet"><b>Food Menu</b></a></li>
				<li><a href="CartServlet"><b>Cart List</b></a></li>
				<li><a href="OrderServlet"><b>My Order</b></a></li>
				<li><a href="CustomerServlet?choice=update&custEmailID=<%=cname%>"><b>Update Customer</b></a></li>
				<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
				<li><a href="LoginServlet"><b>Logout</b></a></li>
			    <li><a href="CustomerServlet?choice=delete&custEmailID=<%=cname%>"><b>Delete account</b></a></li>
				
				<%}else if(aname!=null && cname==null) { %>
				<li><a href="FoodServlet"><b>Food Menu</b></a></li>
				<li><a href="AddFood.jsp"><b>Add Food</b></a></li>	
				<li><a href="OrderServlet"><b>Customer Order</b></a></li>			
				<li><a href="CustomerServlet"><b>Customer List</b></a></li>
				<li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
				<li><a href="LoginServlet"><b>Logout</b></a></li>


				


				<%} %>
			</ul>
		</div>
</body>
</html>