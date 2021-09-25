<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Tags in JSP Example</title>
</head>
<body>

	<c:set var="Income" scope="session" value="${4*4}" />
	<c:if test="${Income > 10}">
		<p>
			My income is:
			<c:out value="${Income}" />
		<p>
	</c:if>

	<c:choose>
		<c:when test="${Income <= 10}">  
       Income is not good.  
    </c:when>
		<c:when test="${Income > 10}">  
        Income is very good.  
    </c:when>
		<c:otherwise>  
       Income is undetermined...  
    </c:otherwise>
	</c:choose>

	<%
		ArrayList<String> al = new ArrayList<String>();
		al.add("Perla Reddy");
		al.add("Dhatrika");
		al.add("Sabareesh");
	
	%>
	<br />
	<br />
	<br />
	<br />
	<c:forEach var="j" begin="1" end="3" >  
   Item <c:out value="${j}" />
		<p>
	</c:forEach>

	<br />
	<c:forEach items="${al}" var="i" begin="1" end="2">
		${da}
	</c:forEach>
</body>
</html>