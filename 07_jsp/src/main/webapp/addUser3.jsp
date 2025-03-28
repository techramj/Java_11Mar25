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


<jsp:useBean id="user" class="com.seed.entity.User" scope="session">
   	<jsp:setProperty property="*" name="user"/>
</jsp:useBean>

<jsp:forward page="registrationFile2.jsp"></jsp:forward>


</body>
</html>