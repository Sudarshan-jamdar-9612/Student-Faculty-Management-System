<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headercontent.jsp" />
<%
String msg = (String) request.getAttribute("msg");
StudentPojo student = (StudentPojo) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Search Record</legend>
		<form action="./search" method="post">
			<table>
				<tr>
					<td>Enter Id :</td>
					<td><input type="number" name="id"
						placeholder="Enter Id number" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
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
	<%
	if (student != null) {
	%>
	<table id="tab" style="margin: 5% auto;">
		<tr id="ro1">
			<th rowspan="2">Id</th>
			<th rowspan="2">Name</th>
			<th rowspan="2">Contact</th>
			<th rowspan="2">Email</th>
			<th rowspan="2">Course</th>
			<th rowspan="2">Username</th>
			<th rowspan="2">Password</th>
			<th colspan="3">Mock Rating</th>
		</tr>
		<tr id="ro1">
			<th>JAVA</th>
			<th>SQL</th>
			<th>Web-Tech</th>
			<th>PYTHON</th>
		</tr>
		<tr id="ro2">
			<td class="td"><%=student.getId()%></td>
			<td class="td"><%=student.getName()%></td>
			<td class="td"><%=student.getContact()%></td>
			<td class="td"><%=student.getEmail()%></td>
			<td class="td"><%=student.getCourse()%></td>
			<td class="td"><%=student.getUsername()%></td>
			<td class="td"><%=student.getPassword()%></td>
			<td class="td"><%=student.getJava()%></td>
			<td class="td"><%=student.getSql()%></td>
			<td class="td"><%=student.getWeb()%></td>
			<td class="td"><%=student.getPython()%></td>
		</tr>
	</table>
	<%
	}
	%>

</body>
</html>