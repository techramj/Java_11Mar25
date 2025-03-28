<%@page import="com.seed.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	User user = (User)session.getAttribute("user");
%>

<p>Username: <%= user.getUsername() %>  </p>
<p>First Name: <%= user.getFirstName() %> </p>
<p>Last Name:  <%= user.getLastName() %> </p>

</body>
</html>