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

  /*
	String username = request.getParameter("username");
    String password = request.getParameter("password");
    String firstName = request.getParameter("fname");
    String lastName = request.getParameter("lname");
    
    User user = new User();
    session.setAttribute("user", user);
    
    user.setUsername(username);
    user.setPassword(password);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    
    
	
    RequestDispatcher rd = request.getRequestDispatcher("registrationFile.jsp");
    rd.forward(request, response);
    
    */
%>

<jsp:useBean id="user" class="com.seed.entity.User" scope="session">
   	<jsp:setProperty property="username" name="user"  param="username"/>
   	<jsp:setProperty property="password" name="user" param="password"/>
   	<jsp:setProperty property="firstName" name="user" param="fname"/>
   	<jsp:setProperty property="lastName" name="user" param="lname"/>
</jsp:useBean>

<jsp:forward page="registrationFile2.jsp"></jsp:forward>


</body>
</html>