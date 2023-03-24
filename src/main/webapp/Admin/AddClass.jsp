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
<title>Add Class</title>

<style>
label, input {
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


	<form method="post" action="../addclass">
		<label>Class Id</label> <input type="text" name="id" /> <label>Class
			Name</label> <input type="text" name="name" /> <label> Class
			Descripton </label>
		<textarea type="text" name="description"></textarea>
		<input type="submit" />
	</form>


</body>
</html>