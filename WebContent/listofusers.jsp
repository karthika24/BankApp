<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
body {
background-image: url("image/bank.jpg");
background-size: 700px 700px;
}
.center {
  margin: auto;
  width: 100%;
  border: 3px;
  padding-top: 150px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
 
}
h1 {
padding-left:1100px;
}
</style>
</head>
<body>
<div align="right">
		<a href="firstpage.html" class="btn btn-info btn-lg"> <span
			class="glyphicon glyphicon-off"></span> Logout
		</a>
	</div>
<h1><a href="admin.jsp">Logout</a></h1>
<div class="center">
<h3>List of users</h3>
	<table class="table table-hover">
		<thead>
			<tr>
			    <th scope="col">ACCOUNT NUMBER</th>
				<th scope="col">NAME</th>
				<th scope="col">EMAIL</th>
				<th scope="col">PASSWORD</th>
				<th scope="col">DATE OF BIRTH</th>
				<th scope="col">GENDER</th>
				<th scope="col">CITY</th>
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
	</div>
</body>
</html>
