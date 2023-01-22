<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<style>
* {
	margin: 0;
	border-radius: 5px;
}

input {
	padding: 5px;
}

#nav {
	background-color: black;
	position: fixed;
	width: 100%;
	padding: 10px;
	font-size: 1.3em;
}

#navbar {
	display : flex;
	justify-content: space-around;
	list-style: none;
	width: 50%;
	float: right;
}

#welcome {
	justify-content: space-around;
	float: left;
	color: white;
	margin-left: 5%;
}

a {
	text-decoration: none;
	text-align: center;
	color: white;
	padding: 6px;
}

a:hover {
	background-color: red;
	box-shadow: 2px 2px 2px red;
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

input[type="submit"]:hover {
	box-shadow: 2px 2px black;
}

#tab, #ro1, #ro2, .td {
	border: 1.5px solid;
	border-collapse: collapse;
	font-size: 1.1em;
	padding: 5px 15px;
	text-align: center;
	width: auto;
}

sup {
	color: red;
	font-style: italic;
	text-decoration: underline;
}

#row1 {
	height: 200px;
	border: 5px solid;
	margin: 10px;
}

#row2, #row3 {
	display: flex;
	justify-content: space-around;
	height: 200px;
	margin: 10px;
}

marquee {
	color: red;
}

.video {
	border: 1px solid;
	width: 100%;
}

#port {
	text-align: center;
	justify-content: center;
	border: 1px solid;
	width: 25%;
	height: 100%;
}
</style>
<body>
	<nav id="nav">
		<%
		String name = (String) request.getAttribute("name");
		%>
		<div id="welcome">Welcome, Admin</div>
			<ul id="navbar">
			
				<li><a href="./home">Home</a></li>
				<li><a href="./add">Add</a></li>
				<li><a href="./search">Search</a></li>
				<li><a href="./update">Update</a></li>
				<li><a href="./remove">Remove</a></li>
				<li><a href="./../../management">LogOut</a></li>
			</ul>
	</nav>
	<div style="margin-top: 0;height: 50px;width: 100%"></div>
</body>
</html>