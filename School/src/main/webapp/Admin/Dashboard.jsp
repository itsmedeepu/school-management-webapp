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
<title>Dashboard</title>
<style>
.container {
	display: flex;
}

.card1, .card2 {
	box-shadow: 0px 0px 2px 2px black;
	width: 300px;
	border: 1px solid blue;
	/*display: inline-block;*/
	margin-left: 10px;
	flex-wrap: wrap;
}
</style>
</head>
<body>
	<h2>
		Welcome to Dashboard
		<%=admin.getName()%></h2>
	<div class="container">
		<div class="card1">
			<h1>
				Admin Settings
				</h2>
				<ol>
					<li><a href="../adminupdateprofile">Update Profile</a></li>
				</ol>
		</div>
		<div class="card2">
			<h1>
				School Settings
				</h2>
				<ol>
					<li><a href="../addclass">Add Class</a></li>
					<li><a href="../addsubject">Add Subject</a></li>
					<li><a href="../addteacher">Add Teacher</a></li>
					<li><a href="../addstudent">Add Student</a></li>
					<li><a href="../assignteachertoclass">Assign Teacher to class</a></li>
					<li><a href="../assignteachertosubject">Assign Teacher to subject</a></li>
				</ol>
		</div>

	</div>

</body>
</html>