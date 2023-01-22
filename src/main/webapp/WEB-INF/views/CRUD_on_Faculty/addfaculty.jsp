<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headerContectFaculty.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Faculty</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Insert Student Details</legend>
		<form action="./addfaculty" method="post">
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" required="required"
						placeholder="Enter student name"></td>
				</tr>
				<tr>
					<td>Email Id :</td>
					<td><input type="text" name="email" required="required"
						placeholder="Enter student Email ID"></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td id="submit"><input type="number" name="contact"
						required="required" placeholder="Enter student Contact"></td>
				</tr>
				<tr>
					<td>Course :</td>
					<td><input type="checkbox" name="job" value="JAVA">
						<label>JAVA</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="job" value="SQL">
						<label>SQL</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="job" value="Python">
						<label>Python</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="job" value="Web_Tech">
						<label>Web Tech</label></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username" placeholder="username"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"
						placeholder="password"></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
		<%
		if (msg != null) {
		%>
		<h2><%=msg%></h2>
		<%
		}
		%>
	</fieldset>
</body>
</html>