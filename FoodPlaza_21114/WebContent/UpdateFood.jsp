<%@page import="java.util.Iterator"%>
<%@page import="com.foodPlaza.Pojo.Food"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Update Food</title>
<link rel="stylesheet" type="text/css" href="FoodPlazaTemplet.css">

<script>
	function validationUF() {
		var fID = document.getElementById("fID").value;
		var fName = document.getElementById("fName").value;
		var fType = document.getElementById("fType").value;
		var fCategory = document.getElementById("fCategory").value;
		var fDescription = document.getElementById("fDescription").value;
		var fPrice = document.getElementById("fPrice").value;
		if (fID == "") {
			document.getElementById("fError").innerHTML = "Please Enter Food Name.";
			return false;
		}
		if (fName == "") {
			document.getElementById("fnError").innerHTML = "Please Enter Food Name.";
			return false;
		}
		if (fType == "") {
			document.getElementById("ftError").innerHTML = "Please Enter Food Type.";
			return false;
		}
		if (fCategory == "") {
			document.getElementById("cError").innerHTML = "Please Enter food Category.";
			return false;
		}
		if (fDescription == "") {
			document.getElementById("fdError").innerHTML = "Please Enter Food Description.";
			return false;
		}
		if (fPrice == "") {
			document.getElementById("fpError").innerHTML = "Please Enter Price.";
			return false;
		}
		if (isNaN(fPrice)) {
			document.getElementById("fpError").innerHTML = "Enter price in Integer.";
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

	<%
		ArrayList<Food> food = (ArrayList<Food>) session.getAttribute("fdetails");
	%>
	<form onsubmit="return validationUF()" action="FoodServlet"method="post">
		<input type="hidden" name="choice" value="updatefood">
		<table id=tbl>
			<caption>
				<h3>Update Food</h3>
			</caption>
	<%
			Iterator<Food> i = food.iterator();
			while (i.hasNext()) {
				Food f = i.next();
		%>

			<tr>
				<th>Food ID:</th>
				<td><input type="text" id="fID" name="fid" value=<%=f.getFoodID() %> readonly="readonly"> <br></td>
				<td><span id="fError"></span></td>
			</tr>

			<tr>
				<th>Food Name:</th>
				<td><input type="text" id="fName" name="fname" value=<%=f.getFoodName() %>> <br>
				</td>
				<td><span id="fnError"></span></td>
			</tr>

			<tr>
				<th>Food Type:</th>
				<td><input type="text" id="fType" name="ftype" value=<%=f.getFoodType() %>> <br>
				</td>
				<td><span id="ftError"></span></td>
			</tr>

			<tr>
				<th>Food Category:</th>
				<td><input type="text" id="fCategory" name="fcategory" value=<%=f.getFoodCategory() %>>
					<br></td>
				<td><span id="fcError"></span></td>
			</tr>

			<tr>
				<th>Food Description:</th>
				<td><input type="text" id="fDescription" name="fdescription" value=<%=f.getFoodDescription() %>><br></td>
				<td><span id="fdError"></span></td>
			</tr>

			<tr>
				<th>Food Price:</th>
				<td><input type="text" id="fPrice" name="fprice" value=<%=f.getFoodPrice() %>> <br>
				</td>
				<td><span id="fpError"></span></td>
			</tr>
			<%
			}
			%>
		</table>

		<p id=p2>
			<input type="submit" value="Update"> &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset"><br>
		</p>

	</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>