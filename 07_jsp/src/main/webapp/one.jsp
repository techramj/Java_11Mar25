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
	  out.println("<h3>Hello! let learn JSP</h3>");	
	  
	%>
	
	<%
		int a = 10;
	%> <!--  HTML comment -->
	
	<%! int a1 = 1234; %> <%-- declaration tag --%>
	
	
	<h4>Jsp(Java Server page)</h4>
	<p></p>
	
	<%
		for(int i=1;i<=10;i++){
	%>
		<p><%= i %></p>
	<%
		}
	%>

</body>
</html>