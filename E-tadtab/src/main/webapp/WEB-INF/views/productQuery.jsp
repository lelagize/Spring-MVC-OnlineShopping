<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product list</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${date}. </P></br>
<a href="<c:url value="/signUp" />" >Sign Up</a></br> 
<a href="<c:url value="/signIn" />" >Sign In</a></br>
<a href="<c:url value="/members.xml" />" >See All members in xml(REST Service)</a> </br>
<a href="<c:url value="/members.json" />" >See All members in Json (REST Service)</a></br>
<a href="<c:url value="/messagePost" />" >contact us</a></br>
			
		<c:forEach items="${lst}" var="ls">
			<table>	
					<tr>
						<td colspan="2"><a href="selectProduct?ProductId=${ls.productId}">${ls.productName}</a></td>
					</tr></br>
					<tr>
						<td>Price:</td>
						<td>${ls.productPrice}</td></br>
					</tr>
					<tr>
						<td colspan="2"><a href = addToCart?productId=${lsc.productId}>Add To cart</a></td>
					</tr>
					
			</table>			
		
		</c:forEach>
	
</body>
</html>