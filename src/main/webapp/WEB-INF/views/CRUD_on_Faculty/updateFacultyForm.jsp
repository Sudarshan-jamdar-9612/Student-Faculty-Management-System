<%@page import="facultymanagement.Pojo.FacultyPojo"%>
<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headerContectFaculty.jsp"/>
<%
FacultyPojo faculty = (FacultyPojo) request.getAttribute("faculty");
String course = faculty.getJob();
String Course[] = null;
Course = course.split(" ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<fieldset id="form">
	<legend id="legend">Update Record</legend>
	<form action="./updateFacultyForm" method="post">
		<table>
			<tr>
				<td>Enter Id :</td>
				<td><input type="text" name="id" placeholder="Enter Id number"
					required="required" readonly="readonly"
					style="border-style: dashed;" value="<%=faculty.getId()%>">
					<sup>Unchangeable</sup></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter student name" value="<%=faculty.getName()%>"></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><input type="text" name="email"
					placeholder="Enter student Email ID"
					value="<%=faculty.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td id="submit"><input type="text" name="contact"
					placeholder="Enter student Contact"
					value="<%=faculty.getContact()%>"></td>
			</tr>
			<tr>
				<td>Job_Profile :</td>
				<td><input type="checkbox" name="job" value="JAVA"
				<%for(String check : Course)
				{ 
					if(check.equals("JAVA")){%> checked="checked" <%}
				}%> 
				>
					<label>JAVA</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="job" value="SQL"
				<%for(String check : Course)
				{ 
					if(check.equals("SQL")){%> checked="checked" <%}
				}%> 
				> <label>SQL</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="job" value="Python"
				<%for(String check : Course)
				{ 
					if(check.equals("Python")){%> checked="checked" <%}
				}%> 
				>
					<label>Python</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="job" value="Web_Tech"
				<%for(String check : Course)
					{ 
						if(check.equals("Web_Tech")){%> checked="checked" <%}
					}%> 
				>
					<label>Web Tech</label></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" placeholder="username"
					value="<%=faculty.getUsername()%>"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password" placeholder="password"
					value="<%=faculty.getPassword()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</fieldset>
</body>
</html>