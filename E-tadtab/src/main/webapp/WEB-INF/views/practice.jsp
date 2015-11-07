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
 <form:form commandName="user">
 	<table>
		<tr>
			<td>firstName</td>
			<td><form:input path="firstName" /></td>
			<input type="text" name="firsName" value="firsName" >
			<td>isNewsLetterRecieve</td>
						<td><form:checkBox path="preferences.isRecieveNewsletter" /></td>
			<td>interests</td>
			<td>
			soccer=<input type="checkbox" name="" value="soccer" >
			footBall: <form:checkBox path="preferences.interests" value="footBall"/>
			</td>
			<td>interests</td>
			<td>
			<form:checkBoxs path="preferences.interesrs" items=${interestslist} />
			</td>
			<form:radioButtons path="sex" value="m" />
			<form:radiobutton path="sex" value="f"/>
			<form:checkboxes path="sex" items=${sexOptions} />
			
			<td>password</td>
			<td>
				<form:password path="password" showpassword="true" value="^fdkfdlk" />
			</td>
			
			<td>skills</td>
			<td>
				<form:select path="skills" items=${skills} />
			</td>
			
			<td>house</td>
			<select name="house" multiple="true" >
				<Option value="sdf" />
				<option value="fds" />
			</select>			
			
				<form:Option value="sdf" />
				<form:option value="fds" />
			</select>
			
			</td>
			
			<td>text area </td>
			<td>
				<form:textarea path="note"/>
				<form:error path="note" />
			</td>
			
			
		</tr>
 	</table>
 </form:form>
 
 <form:form>
 	<td>
 		<form:errors pathl="*" />
 		
 		<td>Fist Name </td>
 		<td>
 			<form:input path="firstName"/>
 			<form:error path="firstName" />
 		</td>
 		
 		<td>Last Name </td>
 		<td>
 			<form:input path="lastName"/>
 			<form:error path="lastName" />
 		</td>
 		
 		
 </form:form>
</body>
</html>