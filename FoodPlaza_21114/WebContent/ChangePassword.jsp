<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">

<script> 
function validationCP()
{
	var uName=document.getElementById("uName").value;
	var uPass=document.getElementById("uPass").value;
	var newPass=document.getElementById("newPass").value;
	var confirmPass=document.getElementById("confirmPass").value;
	var opt=document.getElementById("selectID");
	var data=opt.options[opt.selectedIndex].value;
	if(data=="--Select--")
		{
		document.getElementById("sError").innerHTML="Select Any 1 Option";
		return false;
		}
	
		if(uName=="")
			{
			document.getElementById("userError").innerHTML="Please Enter User Name.";
			return false;
			}
		if(uPass=="")
			{
			document.getElementById("opError").innerHTML="Please Enter Password.";
			return false;
			}
		if(newPass=="")
			{
			document.getElementById("npError").innerHTML="Please Enter New Password.";
			return false;
			}
		if(uPass==newPass)
			{
			document.getElementById("npError").innerHTML="Please Enter New Password.";
			return false;
			}
		if(confirmPass=="")
			{
			document.getElementById("cpError").innerHTML="Please Confirm Password.";
			return false;
			}
		if(newPass!=confirmPass)
			{
			document.getElementById("cpError").innerHTML="Enter same Password";
			return false;
			}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
String aname=(String)session.getAttribute("aname");
String cname=(String)session.getAttribute("cname");
%>

<form onsubmit="return validationCP()" action="LoginServlet" method="post">
   <input type="hidden" name="choice" value="changePassword">                                                    
<table id=tbl>
<caption><h3>Change Password</h3></caption>
<tr>
	<th>Login as:</th>
	<td> 
	<select id="selectID" name="selectOpt"> 
	<option>--Select--</option>
	<option>Administrator</option>
	<option>Customer</option>
	</select>
	<br>
	</td>
	<td><span id="sError"></span></td>
</tr> 
<%if(aname!=null && cname==null) {%>
				<tr>
	<th>User Name: </th>
	<td>
	<input type="text" id="uName" name="aName" value="<%=aname%>" readonly="readonly"> <br> 
	</td>
	<td><span id="userError"></span></td>
</tr>
				
<%}else if(cname!=null && aname==null) { %>
<tr>
	<th>User Name: </th>
	<td>
	<input type="text" id="uName" name="aName" value="<%=cname%>" readonly="readonly"> <br> 
	</td>
	<td><span id="userError"></span></td>
</tr>
<%} %>
<!-- <tr>
	<th>Old Password: </th>
	<td>
	<input type="Password" id="uPass" name="aPass"> <br> 
	</td>
	<td><span id="opError"></span></td>
</tr>
 -->
<tr>
	<th>New Password: </th>
	<td>
	<input type="Password" id="newPass" name="nPass"> <br> 
	</td>
	<td><span id="npError"></span></td>
</tr>
<tr>
	<th>Confirm Password: </th>
	<td>
	<input type="Password" id="confirmPass" name="cPass"> <br> 
	</td>
	<td><span id="cpError"></span></td>
</tr>

</table>

<p id=p2>
	<input type="submit" value="Change"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>