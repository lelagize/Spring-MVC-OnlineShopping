<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>

</head>
<body>
	<h1>Enter the Item you are looking for</h1>
	
	<s:textfield label= "Searcch for customer" key="customerName"/><br />
	<s:submit/>
	<s:property value="#session['1st-product']"/>
	
	<a href="<s:url action='listOfProducts' />" >Get List of Products Here</a><br>
	
	<br>
	<br>
	<s:if test="#session.get('cart') != null">
		Hello ???, You Have  <s:property value="#session.cart.size"/> order(s) and ??? Item(s) in your  Shopping Cart
	</s:if>
	
	<br>
	<br>
	<br>
	
	
	
</body>
</html>