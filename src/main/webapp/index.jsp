<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<style>
{
	background: rgb(252, 135, 255);
	background: linear-gradient(326deg, rgba(252, 135, 255, 1) 0%,
		rgba(249, 137, 255, 1) 26%, rgba(130, 224, 255, 1) 73%,
		rgba(119, 232, 255, 1) 100%);
	background-repeat: no-repeat;
	background-size: cover;
	height: 100px;
}

#main, #img {
	margin: 10% auto;
	width: 50%;
	display: flex;
	justify-content: space-between;
	font-size: 2em;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: black;
	border: 2px solid;
	padding: 5px;
	border-radius: 20%;
}

a:hover {
	background: -webkit-linear-gradient(orange, red);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	border: 2px solid red;
	box-shadow: 2px 2px orange;
	padding: 5px 10px;
}
</style>
<body>
		<div id="main">
			<div style="height:200px;width:100px;">
				<a href="./login">Admin Login</a>
			</div>
			<div style="height: 200px;width:100px;">
				<a href="./studentviews/login">Student Login</a>
			</div>
			<div style="height: 200px;width:100px;">
				<a href="./facultyviews/login">Faculty Login</a>
			</div>
		</div>
</body>
</html>
