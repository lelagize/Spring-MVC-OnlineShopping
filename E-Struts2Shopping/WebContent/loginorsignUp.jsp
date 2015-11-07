<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up or Log In</title>

<style type="text/css">
	#signIn {
		text-align: center;
	}
</style>
</head>
<body>
	<div id="signIn">
		<h1 style="text-align: left;">Log in Here</h1>
		<s:form action="signIn" >
			<s:textfield key="username" label="User Name" /><br>
			<s:textfield key="password" label="Password" /><br>
			<s:submit label="Sign IN"/>	
		</s:form>
		<h2 style="text-align: left;">If You Do Not Have an Account?</h2><br>
		<s:a action="clickforsignup">Click Here to Sign Up</s:a><br>
	</div>
</body>

</html>