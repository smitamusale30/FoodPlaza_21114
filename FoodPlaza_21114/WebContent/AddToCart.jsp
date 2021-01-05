<%@page import="com.foodPlaza.Pojo.Food"%>
<%@page import="com.foodPlaza.Pojo.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Add To Cart</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">

<script> 
function validationATC()
{
	var fID=document.getElementById("fID").value;
	var custID=document.getElementById("custID").value;
	var fQuantity=document.getElementById("fQuantity").value;
	var fPrice=document.getElementById("fPrice").value;
	var ftPrice=document.getElementById("ftPrice").value;
	
		if(fID=="")
			{
			document.getElementById("fidError").innerHTML="Please Enter Food ID";
			return false;
			}
		if(custID=="")
			{
			document.getElementById("custIDError").innerHTML="Please Enter Customer EmailID.";
			return false;
			}
		if(fQuantity=="")
			{
			document.getElementById("fqError").innerHTML="Please Enter Food Quantity.";
			return false;
			}
		if(isNaN(fQuantity))
			{
			document.getElementById("fqError").innerHTML="Please Enter Quantity in Integer";
			return false;
			}
		if(fPrice=="")
			{
			document.getElementById("fpError").innerHTML="Please Enter Food Price.";
			return false;
			}
		if(isNaN(fPrice))
			{
			document.getElementById("fpError").innerHTML="Please Enter FoodPrice in Integer";
			return false;
			}
		if(ftPrice=="")
			{
			document.getElementById("tpError").innerHTML="Please Enter Total Price";
			return false;
			}
		if(isNaN(ftPrice))
			{
			document.getElementById("tpError").innerHTML="Please Enter Total Price in Integer";
			return false;
			}
		return true;
}
function totalPrice() 
{
	var fPrice=document.getElementById("fPrice").value;
	var fQuantity=document.getElementById("fQuantity").value;
	
	var totalprice=(fPrice*fQuantity);
	document.getElementById("ftPrice").value=totalprice;
}

</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
String cname=(String)session.getAttribute("cname");
%>

<%
ArrayList<Food> f = (ArrayList<Food>) session.getAttribute("cartdetails");
%>
<form onsubmit="return validationATC()" method="post" action="CartServlet">    
<input type="hidden" name="choice" value="addtocart">                                                            
<table id=tbl>
<caption><h3>Cart</h3></caption>
<%
			Iterator <Food> i = f.iterator();
			while (i.hasNext()) {
				Food c = i.next();
		%>
<tr>
	<th>Food ID: </th>
	<td>
	<input type="text" id="fID" name="fid" value="<%=c.getFoodID()%>" readonly="readonly"> <br> 
	</td>
	<td><span id="fidError"></span></td>
</tr>

<tr>
	<th>Customer Email ID: </th>
	<td>
	<input type="text" id="custID" name="custid" value="<%=cname %>" readonly="readonly"> <br> 
	</td>
	<td><span id="custIDError"></span></td>
</tr>

<tr>
	<th>Food Quantity: </th>
	<td>
	<input type="text" id="fQuantity" name="fq" onblur="totalPrice()" > <br> 
	</td>
	<td><span id="fqError"></span></td>
</tr>

<tr>
	<th>Food Price: </th>
	<td>
	<input type="text" id="fPrice" name="fprice" value="<%= c.getFoodPrice()%>" readonly="readonly"><br> 
	</td>
	<td><span id="fpError"></span></td>
</tr>
 <!-- 
<tr>
	<th>Food Total Price: </th>
	<td>
	<input type="text" id="ftPrice" name="ftprice" > <br> 
	</td>
	<td><span id="tpError" ></span></td>
</tr>
-->
<%
}
%>
</table>

<p id=p2>
	<input type="submit" value="AddToCart"> &nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset"><br>
</p>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>