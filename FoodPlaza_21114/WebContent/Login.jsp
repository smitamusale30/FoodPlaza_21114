<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">ww
<script> 
function validationLogin()
{
	var uName=document.getElementById("uName").value;
	var uPass=document.getElementById("uPass").value;
	var opt=document.getElementById("selectId");
	var data=opt.options[opt.selectedIndex].value;
	if(data=="--Select--")
		{
		document.getElementById("sError").innerHTML="Select Any Option";
		return false;
		}
		if(uName=="")
			{
			document.getElementById("unError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(uPass=="")
			{
			document.getElementById("pError").innerHTML="Please Enter some Data for Password.";
			return false;
			}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form onsubmit="return validationLogin()" action="LoginServlet" method="post">
 <input type="hidden" name="choice" value="login">                                                           
<table id=tbl>
<caption><h3>Login</h3></caption>
<tr>
	<th>Login as:</th>
	<td> 
	<select id="selectId" name="selectOpt">
	<option >--Select--</option>
	<option>Administrator</option>
	<option>Customer</option>
	</select>
	<br>
	</td>
	<td><span id="sError"></span></td>
</tr> 

<tr>
	<th>User Name: </th>
	<td>
	<input type="text" id="uName" name="aName"> <br> 
	</td>
	<td><span id="unError"></span></td>
</tr>

<tr>
	<th>Password: </th>
	<td>
	<input type="Password" id="uPass" name="aPass"> <br> 
	</td>
	<td><span id="pError"></span></td>
</tr>

</table>

<p id=p2>
	<input type="submit" value="Login"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>