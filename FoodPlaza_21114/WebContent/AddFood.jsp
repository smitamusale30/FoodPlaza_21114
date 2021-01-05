<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Add Food</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">
 <script> 
function validationFood()
{
	var fName=document.getElementById("fName").value;
	var fType=document.getElementById("fType").value;
	var fCategory=document.getElementById("fCategory").value;
	var fDescription=document.getElementById("fDescription").value;
	var fPrice=document.getElementById("fPrice").value;
		
		if(fName=="")
			{
			document.getElementById("nError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(fType=="")
			{
			document.getElementById("tError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(fCategory=="")
			{
			document.getElementById("cError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(fDescription=="")
			{
			document.getElementById("dError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(fPrice=="")
			{
			document.getElementById("pError").innerHTML="Please Enter some Data.";
			return false;
			}
		if(isNaN(fPrice))
			{
			document.getElementById("pError").innerHTML="Enter Data in numbers.";
			return false;
			}
		return true;
}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form onsubmit="return validationFood()" method="post" action="FoodServlet">    
<input type="hidden" name="choice" value="addfood">                                                       
<table id=tbl>
<caption><h3>Add Food</h3></caption>

<tr>
	<th>Food Name: </th>
	<td>
	<input type="text" id="fName" name="fname"> <br> 
	</td>
	<td><span id="nError"></span></td>
</tr>

<tr>
	<th>Food Type: </th>
	<td>
	<input type="text" id="fType" name="ftype"> <br> 
	</td>
	<td><span id="tError"></span></td>
</tr>

<tr>
	<th>Food Category: </th>
	<td>
	<input type="text" id="fCategory" name="fcategory"> <br> 
	</td>
	<td><span id="cError"></span></td>
</tr>

<tr>
	<th>Food Description: </th>
	<td>
	<textarea rows="5" cols="20" id="fDescription" name="fdescription"> </textarea><br> 
	</td>
	<td><span id="dError"></span></td>
</tr>

<tr>
	<th>Food Price: </th>
	<td>
	<input type="text" id="fPrice" name="fprice"> <br> 
	</td>
	<td><span id="pError"></span></td>
</tr>

</table>

<p id=p2>
	<input type="submit" value="AddFood"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>