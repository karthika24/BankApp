<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>withdraw</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  
<style>
body {
background-image: url("image/bank.jpg");
background-size: 700px 700px;}
form {
  margin: auto;
  width: 50%;
  border: 3px;
  padding-top: 150px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
   color: blue;
}
h3 {
color:red;
}
</style>
</head>
<body>
<div align="right">
		<a href="firstpage.html" class="btn btn-info btn-lg"> <span
			class="glyphicon glyphicon-off"></span> Logout
		</a>
	</div>
<form method="post" action="Withdraw">
<div class="center">
<div class="form-group">
      <h1><label for="inputdefault">Enter Pin</label></h1>
      <input class="form-control" id="inputdefault" type="password" name="pin">
    </div>
    <div class="form-group">
      <h1><label for="inputdefault">Enter Account number</label></h1>
      <input class="form-control" id="inputdefault" type="number" name="acno">
    </div>
<div class="form-group">
    
      <h1><label for="inputdefault">Enter Amount</label></h1>
      <input class="form-control" id="inputdefault" type="number" name="amount">
    </div>
    <h2><button type="submit" class="btn btn-primary">Withdraw</button></h2>
</div>
<h3>${ERROR}</h3>
</form>
</body>
</html>