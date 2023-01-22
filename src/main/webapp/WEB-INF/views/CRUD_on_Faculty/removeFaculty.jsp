<%@page import="facultymanagement.Pojo.FacultyPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="../headerContectFaculty.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Faculty</title>
</head>
<%
String remove = (String) request.getAttribute("remove");
String msg = (String) request.getAttribute("msg");
List<FacultyPojo> faculty = (List<FacultyPojo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Remove faculty Record</legend>
		<form action="./removeFaculty" method="post">
			<table>
				<tr>
					<p>Enter Id : <input type="number" name="id" placeholder="Enter Id number" required="required"></p>
				</tr>
				<tr>
					<p><input type="submit" value="Delete"></p>
				</tr>
			</table>
		</form>
		<%
		if (remove != null) {
		%>
		<h2><%=remove%></h2>
		<%
		}
		if (msg != null) {
		%>
		<h2><%=msg%></h2>
		<%
		}
		%>
	</fieldset>
	<%
	if (faculty != null) {
	%>
	<table id="tab" style="margin: 5% auto;">
		<tr id="ro1">
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Job</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<%
		for(FacultyPojo fac : faculty)
		{
		%>
		<tr id="ro2">
			<td class="td" ><%=fac.getId()%></td>
			<td class="td" ><%=fac.getName()%></td>
			<td class="td" ><%=fac.getContact()%></td>
			<td class="td" ><%=fac.getEmail()%></td>
			<td class="td" ><%=fac.getJob()%></td>
			<td class="td" ><%=fac.getUsername()%></td>
			<td class="td" ><%=fac.getPassword()%></td>
		</tr>
	<%
	}
	}
	%>
	</table>
</body>
</html>