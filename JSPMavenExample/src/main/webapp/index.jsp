<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.pgr.model.Employee"%>
<jsp:useBean id="todayDateObj" class="com.pgr.jsp.TodayDateDemo"></jsp:useBean>
<jsp:useBean id="employeeObj" class="com.pgr.model.Employee"
	scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String empId = request.getParameter("empId");
		String name = request.getParameter("name");
		out.println("Current Date&Time is : " + todayDateObj.getTodayDate());
	%>

	<jsp:setProperty property="empId" name="employeeObj"
		value="<%=empId%>" />
	<jsp:setProperty property="name" name="employeeObj" value="<%=name%>" />


	<%-- <%=todayDateObj.getTodayDate() %> --%>
	<%
		out.println("Hello Employee details : " + employeeObj.getEmpId() + " " + employeeObj.getName());
	%>

</body>
</html>