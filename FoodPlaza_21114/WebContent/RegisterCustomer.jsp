<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">

<script> 
function validationRegister()
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
			document.getElementById("usError").innerHTML="Please Enter UserName.";
			return false;
			}
		if(uPass=="")
			{
			document.getElementById("upError").innerHTML="Please Enter Password.";
			return false;
			}
		if(contactNo=="")
			{
			document.getElementById("conError").innerHTML="Please Enter ContactNumber.";
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
			document.getElementById("addError").innerHTML="Please Enter Address.";
			return false;
			}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form onsubmit="return validationRegister()" method="post" action="CustomerServlet">
<input type="hidden" name="choice" value="addCustomer">                                                             
<table id=tbl>
<caption><h3>Register Customer</h3></caption>

<tr>
	<th>Full Name: </th>
	<td>
	<input type="text" id="cName" name="cname"> <br> 
	</td>
	<td><span id="fnError"></span></td>
</tr>

<tr>
	<th>User Name: </th>
	<td>
	<input type="text" id="uName" name="uname"> <br> 
	</td>
	<td><span id="usError"></span></td>
</tr>

<tr>
	<th>Password: </th>
	<td>
	<input type="Password" id="uPass" name="upass"> <br> 
	</td>
	<td><span id="upError"></span></td>
</tr>

<tr>
	<th>Contact Number: </th>
	<td>
	<input type="text" id="contactNo" name="contactno"> <br> 
	</td>
	<td><span id="conError"></span></td>
</tr>

<tr>
	<th>Address: </th>
	<td>
	<input type="text" id="address" name="add">
	</td>
	<td><span id="addError"></span></td>
</tr>

</table>

<p id=p2>
	<input type="submit" value="Register"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>