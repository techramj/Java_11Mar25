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
<h3 align="center">Registration Result 2</h3>
<% 
	//User user = (User)session.getAttribute("user");
%>

<jsp:useBean id="user" class="com.seed.entity.User" scope="session">
</jsp:useBean>



<p>Username: <jsp:getProperty property="username" name="user"/>  </p>
<p>First Name: <jsp:getProperty property="firstName" name="user"/></p>
<p>Last Name:  <jsp:getProperty property="lastName" name="user"/> </p>
<p>Password:  <jsp:getProperty property="password" name="user"/> </p>

</body>
</html>