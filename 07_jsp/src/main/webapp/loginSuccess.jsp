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
    	
    %>

	<h3>Welcome  <%= username %></h3>
	<form  action='friends' method='get' >
		<button type='submit'>Display Friend's List</button>
	</form>
</body>
</html>