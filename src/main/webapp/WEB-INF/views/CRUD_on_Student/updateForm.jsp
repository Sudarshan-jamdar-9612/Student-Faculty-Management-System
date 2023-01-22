<%@page import="studentmanagement.pojo.StudentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="../headercontent.jsp"></jsp:include>
<%
StudentPojo student = (StudentPojo) request.getAttribute("stud");
String Course = student.getCourse();
String[] course = null;
course = Course.split(" ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<fieldset id="form">
	<legend id="legend">Update Record</legend>
	<form action="./updateForm" method="post">
		<table>
			<tr>
				<td>Enter Id :</td>
				<td><input type="text" name="id" placeholder="Enter Id number"
					required="required" readonly="readonly"
					style="border-style: dashed;" value="<%=student.getId()%>">
					<sup>Unchangeable</sup></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter student name" value="<%=student.getName()%>"></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><input type="text" name="email"
					placeholder="Enter student Email ID"
					value="<%=student.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td id="submit"><input type="text" name="contact"
					placeholder="Enter student Contact"
					value="<%=student.getContact()%>"></td>
			</tr>
			<tr>
				<td>Course :</td>

				<td><input type="checkbox" name="course" value="JAVA"
				<%for(String check : course)
					{ 
						if(check.equals("JAVA")){%> checked="checked" <%}
					}%> >
					<label>JAVA</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="course" value="SQL"
				<%for(String check : course)
					{ 
						if(check.equals("SQL")){%> checked="checked" <%}
					}%> 
				> <label>SQL</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="course" value="Python"
				<%for(String check : course)
					{ 
						if(check.equals("Python")){%> checked="checked" <%}
					}%> 
				>
					<label>Python</label></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="course" value="Web_Tech"
				<%for(String check : course)
					{ 
						if(check.equals("Web_Tech")){%> checked="checked" <%}
					}%> 
				>
					<label>Web Tech</label></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username" placeholder="username"
					value="<%=student.getUsername()%>"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password" placeholder="password"
					value="<%=student.getPassword()%>"></td>
			</tr>
			<tr>
				<td>Mock Rating :</td>
			</tr>
			
			<tr>
				<td></td>
				<td><label>JAVA :</label> <select name="java">
						<option value="__" <% if(student.getJava().equals("__")){ %> selected <% } %> >Undefined</option>
						<option value="star" <% if(student.getJava().equals("star")){ %> selected <% } %> >&#9733;</option>
						<option value="1" <% if(student.getJava().equals("1")){ %> selected <% } %> >1</option>
						<option value="2" <% if(student.getJava().equals("2")){ %> selected <% } %> >2</option>
						<option value="3" <% if(student.getJava().equals("3")){ %> selected <% } %>>3</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><label>SQL :</label> <select name="sql">
						<option value="__" <% if(student.getSql().equals("__")){ %> selected <% } %> >Undefined</option>
						<option value="star" <% if(student.getSql().equals("star")){ %> selected <% } %> >&#9733;</option>
						<option value="1" <% if(student.getSql().equals("1")){ %> selected <% } %> >1</option>
						<option value="2" <% if(student.getSql().equals("2")){ %> selected <% } %> >2</option>
						<option value="3" <% if(student.getSql().equals("3")){ %> selected <% } %> >3</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><label>WEB-Tech :</label> <select name="web">
						<option value="__" <% if(student.getWeb().equals("__")){ %> selected <% } %> >Undefined</option>
						<option value="star" <% if(student.getWeb().equals("star")){ %> selected <% } %> >&#9733;</option>
						<option value="1" <% if(student.getWeb().equals("1")){ %> selected <% } %> >1</option>
						<option value="2" <% if(student.getWeb().equals("2")){ %> selected <% } %> >2</option>
						<option value="3" <% if(student.getWeb().equals("3")){ %> selected <% } %> >3</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><label>PYTHON :</label> <select name="python">
						<option value="__" <% if(student.getPython() .equals("__")){ %> selected <% } %> >Undefined</option>
						<option value="star" <% if(student.getPython() .equals("star")){ %> selected <% } %> >&#9733;</option>
						<option value="1" <% if(student.getPython() .equals("1")){ %> selected <% } %> >1</option>
						<option value="2" <% if(student.getPython() .equals("2")){ %> selected <% } %> >2</option>
						<option value="3" <% if(student.getPython() .equals("3")){ %> selected <% } %> >3</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</fieldset>
</body>
</html>