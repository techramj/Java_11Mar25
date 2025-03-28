<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@ page import="com.seed.entity.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	int a = 10;
    User user = new User();
   
%>

<%

	 a = 100;
%>

<%! 
int a = 111; 

void foo(){}

%>

<%= "a ="+a %>


</body>
</html>