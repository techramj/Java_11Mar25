<%@page import="com.seed.entity.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.seed.dao.UserDao"%>
<%@page import="com.seed.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
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
	String dbusername = application.getInitParameter("db.username");
	String dbpassword = application.getInitParameter("db.password");
	String drivername = application.getInitParameter("db.drivername");
	String url = application.getInitParameter("db.url");

	Connection con = ConnectionUtil.getConnection(drivername, url, dbusername, dbpassword);
	application.setAttribute("connection", con);

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	UserDao dao = new UserDao(con);

	boolean isValidUser = false;
	User user = null;
	try {
		user = dao.getUserDetail(username);
		if (user != null) {
			isValidUser = password != null && password.equals(user.getPassword());
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	if(isValidUser) {
		System.out.println("valid user....");
		session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
		rd.forward(request, response);
	}else {
		System.out.println("invalid user");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
 %>

</body>
</html>