<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">

<script> 
function validationUC()
{
	var cName=document.getElementById("cName").value;
	var uName=document.getElementById("uName").value;
	var uPass=document.getElementById("uPass").value;
	var contactNo=document.getElementById("contactNo").value;
	var address=document.getElementById("address").value;
	
		if(cName=="")
			{
			document.getElementById("fnError").innerHTML="Please Enter Full Name.";
			return false;
			}
		if(uName=="")
			{
			document.getElementById("unError").innerHTML="Please Enter UserName.";
			return false;
			}
		if(uPass=="")
			{
			document.getElementById("pError").innerHTML="Please Enter Password.";
			return false;
			}
		if(contactNo=="")
			{
			document.getElementById("conError").innerHTML="Please Enter Contact Number.";
			return false;
			}
		if(isNaN(contactNo))
			{
			document.getElementById("conError").innerHTML="Please Enter ContactNumber in Integer";
			return false;
			}
		if(contactNo.length!=10)
			{
			document.getElementById("conError").innerHTML="Enter 10 digit Number";
			return false;
			}
		if(address=="")
			{
			document.getElementById("addrError").innerHTML="Please Enter UserName.";
			return false;
			}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<%
		Customer c = (Customer) session.getAttribute("cdetails");
	%>

<form onsubmit="return validationUC()" method="post" action="CustomerServlet">
<input type="hidden" name="choice" value="updateCustomer">                                                          
<table id=tbl>
<caption><h3>Update Customer</h3></caption>

		
<tr>
	<th>Full Name: </th>
	<td>
	<input type="text" id="cName" name="cname" value=<%=c.getCustName() %>><br> 
	</td>
	<td><span id="fnError"></span> </td>
</tr>

<tr>
	<th>User Name: </th>
	<td>
	<input type="text" id="uName" name="uname" value=<%=c.getCustEmailID() %> readonly="readonly"> <br> 
	</td>
	<td><span id="unError"></span> </td>
</tr>

<tr>
	<th>Password: </th>
	<td>
	<input type="Password" id="uPass" name="upass" value=<%=c.getCustPassword() %> readonly="readonly"> <br> 
	</td>
	<td><span id="pError"></span> </td>
</tr>

<tr>
	<th>Contact Number: </th>
	<td>
	<input type="text" id="contactNo" name="contactno" value=<%=c.getCustContactNo() %>> <br> 
	</td>
	<td><span id="conError"></span> </td>
</tr>

<tr>
	<th>Address: </th>
	<td>
	<input id="address" name="add" value=<%=c.getCustAddress() %>>
	</td>
	<td><span id="addrError"></span> </td>
</tr>

</table>

<p id=p2>
	<input type="submit" value="Update"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>