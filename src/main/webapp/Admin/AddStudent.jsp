<%@page import="com.deepak.Admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Admin admin = (Admin) session.getAttribute("adminlogin");

if (admin == null) {
	response.sendRedirect("AdminLogin.html");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<style>
label, input[type="text"],input[type="password"],input[type="submit"],input[type="date"]{
	display: block;
	padding: 5px;
}

input[type="text"], input[type="password"] {
	border-radius: 10px;
}

input[type="submit"] {
	margin-top: 10px;
	text-align: center;
}

form {
	margin: auto;
	width: 300px;
}
</style>
</head>
<body>
<form method="post" action="../addstudent">
		<label>Student Name</label> <input type="text" name="name" /> <label>Student
			Email</label> <input type="text" name="email" /> <label>Student
			Phone</label> <input type="text" name="phone" /> <label>Gender</label>Male<input
			type="radio" name="gender" value="Male"> Female<input
			type="radio" name="gender" value="Female">
			<label>Student Dob</label>
			<input type="date" name="dob"/>
			<label>Stduent address</label>
			<textarea type="text" name="address"></textarea>
		
			 <input
			type="submit" />
	</form>


</body>
</html>