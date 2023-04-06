<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
</head>
<body >
	<br>
	<a href=Home.jsp
		style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">Sporty
		Shoes</a>
	<br>
	<br>
	
	<h2>Admin Login</h2>
	
	<div>
		<form action="adminPage" method=post>
			<label for=email>Email :-</label>    <input type="email" name=email id=email /><br>
			<label for=pass>Password :-</label> <input type="password" name=password id=pass /><br>
			<br>                                <input type=submit value=submit /> <input type=reset />
		</form>
	</div>
	<br>
	<a href=forgotPassword style="font-size: 25; color: red;">Forgot Password</a>
	<p style="color: green;">${message}</p>
	

</body>
</html>