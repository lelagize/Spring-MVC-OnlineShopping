<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuccessPage</title>

</head>
<body>
	<h1>ThisIsSparta</h1>
	<br>
	
	<table border="1">
		<li><s:a action="viewShoppingKart">View Cart</s:a></li>
		<thead>
		<tr>
			<td colspan="5" align="center"><strong>List of Products Available</strong></td>
		</tr>
			
		<tr>
		
			<td><strong>Count</strong></td>
			<td><strong>Product name</strong></td>
			<td><strong>Price (In US $)</strong></td>
			<td><strong>Product id</strong></td>
			<td><strong>Add to cart</strong></td>
						
		</tr>
		</thead>
	
		<tbody>
		
			<s:iterator value="products" status="counter">
				<tr>
				<td>
					<s:property value="#counter.count"/>
				<td>
					<s:url var="detail_action" action="detail" >
						<s:param name="productId" > <s:property value="productId" /></s:param>
					</s:url>
					<s:a action="%{detail_action}" ><s:property value="productName"/></s:a>
				</td>
				</td>
				<td>
					<s:property value="productPrice"/> 
				</td>				
				<td><s:property value="productId"/></td>
				<td>
					<s:url var="addtocart_action" action="addtocart" >
						<s:param name="productId" > <s:property value="productId"/></s:param>
						</s:url>
					<s:a action="%{addtocart_action}" >Add To cart</s:a>
				</td>
				</tr>				
			</s:iterator>
			
		</tbody>
	
	</table>
<s:property value="#session['1st-product']"/>
	
</body>
</html>