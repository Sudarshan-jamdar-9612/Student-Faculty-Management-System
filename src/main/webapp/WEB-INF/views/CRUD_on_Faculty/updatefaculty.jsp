<%@page import="facultymanagement.Pojo.FacultyPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="../headerContectFaculty.jsp"/>
     <%
List<FacultyPojo> facultyies = (List<FacultyPojo>)request.getAttribute("list");
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update faculty</title>
</head>
<body>
<fieldset id="form">
		<legend id="legend">Update Record</legend>
		<form action="./updatefaculty" method="post">
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
	<%if(facultyies!=null) {%>
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
		for (FacultyPojo faculty : facultyies) {
		%>
		<tr id="ro2">
			<td class="td"><%=faculty.getId()%></td>
			<td class="td"><%=faculty.getName()%></td>
			<td class="td"><%=faculty.getContact()%></td>
			<td class="td"><%=faculty.getEmail()%></td>
			<td class="td"><%=faculty.getJob()%></td>
			<td class="td"><%=faculty.getUsername()%></td>
			<td class="td"><%=faculty.getPassword()%></td>
		</tr>
		<%
		}}
		%>
	</table>
</body>
</html>