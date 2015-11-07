<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		#signUp {
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="signUp">
		<h1 style="text-align: left;">Sign Up here</h1>
		<s:form action ="signup">
			<s:textfield key="customer.firstname" label="First Name" /><br>
			<s:textfield key="customer.middlename" label="Middle Name" /><br>
			<s:textfield key="customer.lastname" label="Last Name" /><br>
			<s:textfield key="customer.username" label="User Name" /><br>
			<s:textfield key="customer.password" label="Password" /><br>
			<s:textfield key="customer.street" label="Street" /><br>
			<s:textfield key="customer.city" label="City" /><br>
			<s:textfield key="customer.state" label="State" /><br>
			<s:textfield key="customer.zipcode" label="Zip Code" /><br>
			<s:textfield key="customer.country" label="Country" /><br>
			<s:textfield key="customer.phonenumber" label="Phone Number" /><br>
			<s:submit label="Sign Up"/>
		</s:form>
	</div>
</body>
</html>