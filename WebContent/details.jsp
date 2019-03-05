<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  
<style>
body {
background-image: url("image/bank.jpg");
background-size: 700px 700px;
}
.center {
  margin: auto;
  width: 50%;
  border: 3px;
  padding-top: 150px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
}
p{
padding-left:400px;
 color:	blue;
font-size: 170%;
font-style: italic;
}
</style>
</head>
<body>
<form method="post" action="homepage.html">
<div class="center">
<h2>YOUR DETAILS..</h2>
		<table class="table table-hover">
			<thead>
				<tr>
				<th scope="col">ACCOUNT NUMBER</th>
				<th scope="col">NAME</th>
				<th scope="col">EMAIL</th>
				<th scope="col">DATE OF BIRTH</th>
				<th scope="col">GENDER</th>
				<th scope="col">CITY</th>
				</tr>
			</thead>
			<tbody>
				    <tr>
				        <td>${USER.accountNumber}</td>
					    <td>${USER.name}</td>
					    <td>${USER.email}</td>
					    <td>${USER.dateOfBirth}</td>
					    <td>${USER.gender}</td>
					    <td>${USER.city}</td>
			</tbody>
		</table>
		<button type="submit" class="btn btn-success">Begin Transaction</button>
		</div>
		</form>
		<p>Please note Account number for further transactions*</p>
</body>
</html>