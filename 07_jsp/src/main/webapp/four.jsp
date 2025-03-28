<%@page import="com.seed.entity.Address"%>
<%@page import="com.seed.entity.Employee"%>
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
	Employee emp = new Employee();
	emp.setId(1);
	emp.setName("Kiran");
	emp.setSalary(9999999);
	
	Address address = new Address();
	//emp.setAddress(address);
	
	request.setAttribute("emp", emp);
%>


<p>Id: <%= emp.getId() %>
<p>name: <%= emp.getName() %>
<p>salary: <%= emp.getSalary() %>
<%-- <p>Address: <%= emp.getAddress()== null?"":emp.getAddress() %>
<p>City: <%= emp.getAddress()== null?"":emp.getAddress().getCity() %> --%>


<h4>Result using EL</h4>
<p>Id: ${emp.id }</p>
<p>Name: ${emp.name }</p>
<p>Address: ${emp.address }</p>
<p>City: ${emp.address.city } </p>

</body>
</html>