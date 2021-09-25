<!DOCTYPE html>

<html>
<head>
<%-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.2/js/jquery.dataTables.min.js"></script>
 --%>

<!-- Datatable plugin CSS file -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />

<!-- jQuery library file -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js">
	
</script>

<!-- Datatable plugin JS library file -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

	<%@page import="com.pgr.dao.UserDao,com.pgr.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s"%>
	<h1>Users List</h1>

	<%
		List<User> list = UserDao.getAllRecords();
		request.setAttribute("list", list);
	%>

	<table border="1" width="90%" id="a">

		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Sex</th>
				<th>Country</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.getId()}</td>
					<td>${u.getName()}</td>
					<td>${u.getPassword()}</td>
					<td>${u.getEmail()}</td>
					<td>${u.getSex()}</td>
					<td>${u.getCountry()}</td>
					<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
					<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>

</body>

<script>
	$(document).ready(function() {
		$('#a').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>

</html>