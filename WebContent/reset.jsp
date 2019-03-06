<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reset</title>
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
h3 {
color:red;
}
</style>
</head>
<body>
<form method="post" action="ResetServlet">
<div class="center">
<h2>
<div class="form-group">
  <label for="usr">Enter pin</label>
  <input type="password" class="form-control" name="pin">
</div>
<div class="form-group">
  <label for="usr">Account number</label>
  <input type="number" class="form-control" name="acno">
</div>
<div class="form-group">
  <label for="usr">Enter new password</label>
  <input type="password" class="form-control" name="newpassword">
</div>
<button type="submit" class="btn btn-primary">Reset</button>
</h2>
<h3>${ERROR}</h3>
</div>
</form>
</body>
</html>