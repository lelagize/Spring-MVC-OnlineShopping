<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post"  modelAttribute="customer">
	<form:errors path="*" cssClass="error" />
		<!-- // add atrribute in form tag
		// define global error
		// create table
		// define field names of the model
		// define the input
		// define corresponding error -->
	<table>
		<tr>
			<td>first Name</td>
			<td><form:input path="firstName"/></td>
			<td><form:errors path="firstName" cssClass="error"/></td>
		</tr>
		<tr>
			<td>last Name</td>
			<td><form:input path="lastName"/></td>
			<td><form:errors path="lastName" cssClass="error"/></td>
		</tr>
		<tr>
			<td>zip Code</td>
			<td><form:input path="zipCode"/></td>
			<td><form:errors path="zipCode" cssClass="error"/></td>
		</tr>
		<tr>
			<td>phone Number</td>
			<td><form:input path="phonenumber"/></td>
			<td><form:errors path="phonenumber" cssClass="error"/></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><form:input path="userName"/></td>
			<td><form:errors path="userName" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password"/></td>
			<td><form:errors path="password" cssClass="error"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Sign Up" />
			</td>
		</tr>
	</table>	
		
	</form:form>
</body>
</html>