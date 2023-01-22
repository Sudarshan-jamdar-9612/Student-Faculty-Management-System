<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headercontentstud.jsp" />
<%
String msg = (String) request.getAttribute("msg");
StudentPojo student = (StudentPojo) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mock Rating's</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 4px 6px;
}
</style>
<body>
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
			<td class="td"><%=student.getJava()%></td>
			<td class="td"><%=student.getSql()%></td>
			<td class="td"><%=student.getWeb()%></td>
			<td class="td"><%=student.getPython()%></td>
		</tr>
	</table>
	<%
	}
	if(msg!=null){
		%>
		<h2><%=msg %></h2>
		<%
	}
	%>
</body>
</html>