<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>

<!-- <link
	href="./resourecs/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	 -->
<%-- <link
	href="<c:url value="./resourecs/css/bootstrap.min.css"/>"
	rel="stylesheet" id="bootstrap-css"> --%>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

</head>
<body>


	<section class="vh-100" style="background-color: #508bfc;">
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-12 col-md-8 col-lg-6 col-xl-5">
				<div class="card shadow-2-strong" style="border-radius: 1rem;">
					<div class="card-body p-5 text-center">
						<h4 class="mb-5">${registerForm }</h4>

						<form:form name="userRegisterForm" method="POST"
							modelAttribute="userRegisterForm" action="userRegisterForm">
							<div class="form-outline mb-4">
								<input type="text" id="typeEmailX"
									class="form-control form-control-lg" name="userName"
									placeholder="User Name" />

							</div>
							<div class="form-outline mb-4">
								<input type="password" id="typeEmailX"
									class="form-control form-control-lg" name="password"
									placeholder="Password" />
							</div>


							<button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>

						</form:form>
						
						<p>${successMsg }</p>
					</div>
				</div>
			</div>
		</div>

	</div>
	</section>
	<%-- <form:form name="loginForm" method="POST" modelAttribute="loginBean"
		action="login">

		<div align="center">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form> --%>
</body>
</html>