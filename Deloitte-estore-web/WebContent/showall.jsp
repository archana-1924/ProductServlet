<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List" %>
<%@page import= "com.deloitte.estore.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
List<Product> products= (List<Product>)session.getAttribute("products");
%>
<table border="1">
<tr>
<th>Product ID  </th>
<th>Product Name  </th>
<th>Price  </th>
<%
for(Product p: products)
{
	out.println("<tr><td>"+p.getProductId()+"</td>");
	out.println("<td>"+p.getProductName()+"</td>");
	out.println("<td>"+p.getPrice()+"</td>");
}
%>
</table>




</body>
</html>