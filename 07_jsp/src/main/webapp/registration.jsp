<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>
	<h3 align="center">Add User</h3>
	<form action="addUser3.jsp" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName"></td>
		</tr>
		
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName"></td>
		</tr>
		<tr>
			<td></td>
			<td><button type="submit">Add user</button></td>
		</tr>
	</table>
	</form>
</fieldset>

</body>
</html>