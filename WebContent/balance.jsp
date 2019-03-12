<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>balance</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
body {
	background-image: url("image/bank.jpg");
	background-size: 700px 700px;
}

h2 {
	margin: auto;
	width: 50%;
	border: 3px;
	padding-top: 250px;
	padding-right: 30px;
	padding-bottom: 150px;
	padding-left: 250px;
}

.container {
	text-align: right;
}
</style>
</head>
<body>
	<div class="container">
		<a href="firstpage.html" class="btn btn-info btn-lg"> <span
			class="glyphicon glyphicon-off"></span> Logout
		</a>
	</div>
	<h2>
		Account balance: ${USER.bankBalance} <br> <a href="homepage.html">Back</a>
	</h2>
</body>
</html>