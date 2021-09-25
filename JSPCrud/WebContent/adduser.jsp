<%@page import="com.pgr.dao.UserDao"%>
<jsp:useBean id="u" class="com.pgr.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
	int i = UserDao.save1000Records(u);
	if (i > 0) {
		response.sendRedirect("adduser-success.jsp");
	} else {
		response.sendRedirect("adduser-error.jsp");
	}
%>