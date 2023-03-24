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
<title>update profile</title>
<style>
label, input {
	display: block;
	padding: 5px;
}

input[type="text"],input[type="password"] {
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

	<form method="post" action="../adminupdateprofile">
		<input type="hidden" name="id" value="<%=admin.getId() %>" /> <label> Name</label>
		<input type="text" value="<%=admin.getName() %>" name="name" /> <label> Email</label> <input
			type="text" value="<%=admin.getEmail() %>" name="email" /> <label> Phone</label> <input
			type="text" value="<%=admin.getPhone() %>" name="phone" /> <label> username</label> <input
			type="password" value="<%=admin.getUsername()%>" name="username" /> <label> password</label>
		<input type="password" value="<%=admin.getPassword() %>" name="password" /> <input
			type="submit" />
	</form>

</body>
</html>