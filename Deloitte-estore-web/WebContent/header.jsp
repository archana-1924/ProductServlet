<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
ul{
display : inline-flex;
list-style-type: none;
font-size: 18px;
}
li{
padding-right: 20px;
align: right;
}
form
{
padding-right: 20px;
}
</style>
<ul>
<li><a href="add-product.jsp">Add Product</a></li>
<br><br>
<form action="SearchProduct">
<input type="number" name="txtprodId" placeholder="Enter an ID">
<input type= "submit" value="Search">
 </form>
<br><br>
<li><a href="getall">Show all Products</a></li>
</ul>



</body>
</html>