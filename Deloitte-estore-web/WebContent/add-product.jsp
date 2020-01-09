<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<form action="addproduct" method="post">
Enter Product ID <input type= "number" name="txtpid"><br><br>
Enter product name <input type="text" name="txtname"><br><br>
Enter price <input type="text" name="txtprice"><br><br>
<input type="submit" value="Save">
</form>
