<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<style>

</style>
</head>
<body>
<h3>List of users</h3>
	<table>
		<thead>
			<tr>
			    <th>ACCOUNT NUMBER</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>DATE OF BIRTH</th>
				<th>GENDER</th>
				<th>CITY</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${USER}">
				<tr>
				    <td>${user.accountNumber}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.dateOfBirth}</td>
					<td>${user.gender}</td>
					<td>${user.city}</td>
					
			</c:forEach>
		</tbody>
	</table>
	<h1><a href="admin.jsp">Logout</a></h1>
</body>
</html>