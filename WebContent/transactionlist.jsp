<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
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
</style>
</head>
<body>
<div align="right">
		<a href="firstpage.html" class="btn btn-info btn-lg"> <span
			class="glyphicon glyphicon-off"></span> Logout
		</a>
	</div>
<div class="center">
<h3>Your Transactions</h3>
	<table class="table table-hover">
		<thead>
			<tr>
			    <th scope="col">STATUS</th>
				<th scope="col">AMOUNT</th>
				<th scope="col">TRANSACTION DATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="transactions" items="${TRANSACTIONS}">
				<tr>
				    <td>${transactions.status}</td>
					<td>${transactions.amount}</td>
					<td>${transactions.transactionDate}</td>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>