<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com.deloitte.estore.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%! 
Product p;
%>
<%
p= (Product)session.getAttribute("product");
%>
<body>

<style>
table{
border-bottom: 5;
border-bottom-color: red;
margin: 5px;
width: 50%;
padding-right: 5px;
font-size: 18px;
color: blue; 
}
</style>


<h1>Product Information </h1>
<form action="ShowUpdate" method="post">
<table border="1">
<tr>
<th>Property</th>
<th>Value</th>
</tr>
<tr>
<td>Product ID</td>
<td><input type="text" name="uid" value=<%=p.getProductId() %> readonly></td>
</tr>
<tr>
<td>Product Name</td>
<td><input type="text" name="uname" value=<%=p.getProductName() %>></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" name="uprice" value=<%=p.getPrice() %>></td>
</tr>
<tr>
</table>
<br><br>
<input type="submit" value="Update">
</form>
</body>
</html>

