<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp" %>

<%

	int a = 10;
	int b = 5;
	int c = a/b;
	//out.println("c= "+c);
%>

<%= "c= "+c %>

<jsp:include page="footer.jsp" />

</body>
</html>