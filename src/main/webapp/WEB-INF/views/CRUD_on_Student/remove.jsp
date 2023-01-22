<%@page import="java.util.List"%>
<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headercontent.jsp" />
<%
String remove = (String) request.getAttribute("remove");
String msg = (String) request.getAttribute("msg");
List<StudentPojo> student = (List<StudentPojo>)request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Remove Record</legend>
		<form action="./remove" method="post">
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
	if (student != null) {
	%>
	<table id="tab" style="margin: 5% auto;">
		<tr id="ro1">
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Course</th>
			<th>Username</th>
			<th>Password</th>
			<th> JAVA </th>
			<th> SQL </th>
			<th> Web-Tech </th>
			<th> Python </th>
		</tr>
		<%
		for(StudentPojo stud : student)
		{
		%>
		<tr id="ro2">
			<td class="td" ><%=stud.getId()%></td>
			<td class="td" ><%=stud.getName()%></td>
			<td class="td" ><%=stud.getContact()%></td>
			<td class="td" ><%=stud.getEmail()%></td>
			<td class="td" ><%=stud.getCourse()%></td>
			<td class="td" ><%=stud.getUsername()%></td>
			<td class="td" ><%=stud.getPassword()%></td>
			<td class="td" ><%=stud.getJava() %></td>
			<td class="td" ><%=stud.getSql() %></td>
			<td class="td" ><%=stud.getWeb() %></td>
			<td class="td" ><%=stud.getPython() %></td>
		</tr>
	<%
	}
	}
	%>
	</table>
</body>
</html>