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
	String username = request.getParameter("username");
    String password = request.getParameter("password");
    String firstName = request.getParameter("fname");
    String lastName = request.getParameter("lname");
    
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    
    session.setAttribute("user", user);
	
    RequestDispatcher rd = request.getRequestDispatcher("registrationFile.jsp");
    rd.forward(request, response);
%>

</body>
</html>