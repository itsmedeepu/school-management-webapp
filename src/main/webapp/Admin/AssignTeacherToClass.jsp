<%@page import="com.deepak.Teacher.Teacher"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.deepak.Admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Admin admin = (Admin) session.getAttribute("adminlogin");

if (admin == null) {
	response.sendRedirect("AdminLogin.html");
	return;
}

List<HashMap<String, String>> classes = (List) session.getAttribute("allclasses");
List<Teacher> teachers = (List) session.getAttribute("allteachers");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Teacher To class</title>
<style>
table, th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	text-align: center;
	margin: auto;
	width: 1000px;
}

table th {
	background-color: yellow;
}
</style>


</head>
<body>
	<table>
		<tr>
			<th>SI.NO</th>
			<th>Teacher Id</th>
			<th>Teacher Name</th>
			<th>Teacher Email</th>
			<th>Teacher Phone</th>
			<th>Teacher Gender</th>
			<th>Class</th>
			<th>Action</th>

		</tr>

		<%
		int i = 1;
		for (Teacher t : teachers) {
		%>

		<tr>
			<td><%=i++%></td>
			<td><%=t.getId()%>
			<td><%=t.getName()%></td>
			<td><%=t.getEmail()%></td>
			<td><%=t.getPhone()%></td>
			<td><%=t.getGender()%></td>
			<td><select id="class<%=t.getId()%>">
					<option value="NA">Not Available</option>
					<%
					for (HashMap<String, String> h : classes) {
					%>
					<option value="<%=h.get("classid")%>"><%=h.get("classname")%></option>
					<%
					}
					%>
			</select></td>
			<td><button type="button"
					onclick="assignteacher('<%=t.getId()%>')">Assign</button></td>
		</tr>

		<%
		}
		%>




	</table>
	<script type="text/javascript">
		function assignteacher(teacherid) {

			var id = teacherid;
			var selectElement = document.getElementById("class" + id);
			var classid = selectElement.value;
			window.location.href = "../assinteachertoclass1?teacherid=" + id
					+ "&classid=" + classid;
		}
	</script>
</body>
</html>