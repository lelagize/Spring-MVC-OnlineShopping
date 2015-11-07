<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
     
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1 >Shopping Cart</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th colspan="6" align="center">Order Detail</th>
			</tr>
			<tr>
				<th>Remove</th>
				<th>Item Id</th>
				<th>Item Name</th>
				
				<th>Item Price</th>	
				<th>Item Quantity</th>			
				<th>Sub Total</th>
			</tr>
		</thead>
		<tbody>
		
				
				<c:set var="s" value="0" /> 
				<c:forEach var="it" items="${sessionScope.cart}">
					<c:set var="s" value="${ s + it.product.productPrice * it.quantity }" /> 
						<tr>
							<td>
								<s:url var="remove_action" action="remove">
									<s:param name="productId">${it.product.productId}</s:param>			
									
								</s:url>
								<s:a href="%{remove_action}" onclick='return confirm("Are you Sure About That?")'>Remove</s:a>
							</td>
														
						<td>${it.product.productId}</td> 
						<td>
						
							<s:url var="detail_action" action="detail" >
								<s:param name="productId" > <s:property value="productId" /></s:param>
							</s:url>
							<s:a action="%{detail_action}" >${it.product.productName}</s:a>
						</td>
						
						<td>${it.product.productPrice }</td>
						<td>${it.quantity}</td>
						<td>${ it.product.productPrice * it.quantity }</td>
						
					</tr>			
				</c:forEach>
					<tr>
						<td colspan="5"  align="right">Total price</td>
						<td> ${s}</td>
					</tr>
		</tbody>
	</table>
	<br>
	<br>
	<s:if test="#session.get('cart') != null">
		 <s:property value="#session.cart.size"/> order(s) 
	</s:if>
		
	<br>
	<br>
	<br>
	<s:a action="gobacktoShopping">Continue Shopping</s:a>
	
</body>
</html>