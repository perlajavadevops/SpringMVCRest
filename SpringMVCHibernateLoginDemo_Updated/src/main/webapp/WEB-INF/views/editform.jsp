<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>


	<h1>Edit Form</h1>
	<form action="updateUser" method="post">
		<input type="hidden" name="id" value="${u.getId() }" />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${u.getName() }" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="${u.getPassword() }" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${u.getEmail() }" /></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><c:set var="gender" scope="page" value="${u.getSex()}" />
					<c:if test="${gender == 'female'}">
						<input type="radio" name="sex" value="male" />Male <input
							type="radio" name="sex" value="female" checked="checked" />Female
				</c:if> <c:if test="${gender == 'male'}">
						<input type="radio" name="sex" value="male" checked="checked" />Male <input
							type="radio" name="sex" value="female" />Female
				</c:if></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country">
						<option>India</option>
						<option>USA</option>
						<option>France</option>
						<option>China</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update User" /></td>
					
					<td>
					<input type="button" onclick="location.href='allUsers';" value="View Users" />
					</td>
					
					
			</tr>
		</table>
	</form>

	<script>
		$(document).ready(function() {
			$('#Hello').click({
				"pagingType" : "full_numbers"
			});

			$("#msg1Id").fadeOut("slow", function() {
				// Animation complete.
			});
		});
	</script>

</body>
</html>