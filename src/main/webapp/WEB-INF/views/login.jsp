<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	String msg = (String)request.getAttribute("msg");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
*{
border-radius: 5px;
}
#form {
	font-size: 1.2em;
	margin: 10% 10%;
	background-color: #FCFCFC;
	border-color: #F2F2F2;
}

#legend {
	font-weight: bold;
	font-size: 1.5em;
}
input[type="submit"] {
	padding: 10px;
	border: none;
	font-size: medium;
	background-color: red;
	cursor: pointer;
	color: white;
	font-weight: bold;
}
input {
	padding: 5px;
}
input[type="submit"]:hover {
	box-shadow: 2px 2px black;
}
</style>
<body>
	<div>
		<fieldset id="form">
		<legend id="legend"><h3>Admin Login Form</h3></legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username :</td>
						<td><input type="text" name="username" placeholder="Enter Your Username"></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" name="password" placeholder="Enter Your Password"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login"></td>
					</tr>
				</table>
				<a href="signup">Account doesn't exist?Create Account</a>
			</form>
			<%
			if(msg!=null){
			%>
			<h2><%=msg %></h2>
			<%} %>
		</fieldset>
	</div>
</body>
</html>