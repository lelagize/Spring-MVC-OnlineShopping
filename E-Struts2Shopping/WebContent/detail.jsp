<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
	
</head>
<body background="">
	<h1>Product Dtail</h1>
	<table id=”t” style=”display:visible”><tr  id=”row” style=”height:50px”> <td><a 
	href="http://www.gia.edu">W3Schools.com</a></td></tr></table>
	 
	ProductId: <s:property value="prdct.productId"/><br>
	Product Name: <s:property value="prdct.productName"/><br>
	Product Price: <s:property value="prdct.productPrice"/><br>
	
	<br>
	<br>
	<br>
	
	<s:url var="addtocart_action" action="addtocart" >
						<s:param name="productId" > <s:property value="prdct.productId"/></s:param>
	</s:url>
	<s:a action="%{addtocart_action}" >Add to Shopping Cart</s:a>
	
</body>
</html>