<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headercontent.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Insert Student Details</legend>
		<form action="./add" method="post">
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
					<td><input type="checkbox" name="course" value="JAVA">
						<label>JAVA</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="course" value="SQL">
						<label>SQL</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="course" value="Python">
						<label>Python</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="course" value="Web_Tech">
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
					<td>Mock Rating :</td>
				</tr>
				<tr>
					<td></td>
					<td><label>JAVA :</label> <select name="java">
							<option value="__" selected="selected">Undefined</option>
							<option value="star">&#9733;</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><label>SQL :</label> <select name="sql">
							<option value="__" selected="selected">Undefined</option>
							<option value="star">&#9733;</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><label>WEB-Tech :</label> <select name="web">
							<option value="__" selected="selected" >Undefined</option>
							<option value="star">&#9733;</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td><label>PYTHON :</label> <select name="python">
							<option value="__" selected="selected">Undefined</option>
							<option value="star">&#9733;</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td>
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