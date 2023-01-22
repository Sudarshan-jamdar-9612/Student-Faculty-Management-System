<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
	<fieldset id="form">
		<legend  id="legend"> <h3>Registration Form</h3> </legend>
		<form action="./signup" method="post">
			<p>Username : <input type="text" name="username" placeholder="Enter Username"></p>
			<p>Password : <input type="password" name="password" placeholder="Enter password"></p>
			<p>Email ID : <input type="email" name="email" placeholder="Enter Email ID"></p>
			<p><input type="submit" value="Register"></p>
		</form>
		<%
		if(msg!=null){
			%>
			<h2><%=msg %></h2>
			<%
		}
		%>
		<a href="login">Account exist?Click here to Login!</a>
	</fieldset>
</body>
</html>