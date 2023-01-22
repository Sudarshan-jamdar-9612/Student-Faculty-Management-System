<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headercontent.jsp"></jsp:include>
<%
List<StudentPojo> students = (List<StudentPojo>)request.getAttribute("student");
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<fieldset id="form">
		<legend id="legend">Update Record</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Enter Id :</td>
					<td><input type="number" name="id"
						placeholder="Enter Id number" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
		<%
		if(msg!=null){
			%>
			<h2><%=msg %></h2>
			<%
		}
		%>
	</fieldset>
	<%if(students!=null) {%>
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
		for (StudentPojo student : students) {
		%>
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
		<%
		}}
		%>
	</table>
</body>
</html>