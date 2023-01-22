<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<style>
body {
	
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
	border: 2px solid orange;
	box-shadow: 2px 2px red;
	padding: 5px 20px;
	
}
</style>
<body>
	<div id="main">
		<div>
			<a href="./CRUD_on_Student/home">Student Management</a>
		</div>
		<div>
			<a href="./CRUD_on_Faculty/homeFacultyForAdmin">Faculty Management</a>
		</div>
	</div>
</body>
</html>
