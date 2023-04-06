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
	<h2 style="color: blue;">Enter details to reset password</h2>
	<div>
		<form action=adminForgotPassword method=post>
			<label for=email>Email :-</label> <input type="email" name=email
				id=email /><br>
			<br> <label for=pass>New Password :-</label> <input
				type="password" name=password id=pass /><br>
			<br> <input type=submit value=submit /> <input type=reset />
		</form>
	</div>
	<br>
	<br>
	<p style="color: green;">${message}</p>
</body>
</html>