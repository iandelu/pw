<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.uco.pw.p2.business.UserDTO,es.uco.pw.p2.data.UserDAO" %>
<jsp:useBean id="CustomerBean" scope="session" class="es.uco.pw.p2.display.CustomerBean"></jsp:useBean>
<%
	if (CustomerBean.getEmail() != null) {
		CustomerBean.setEmail(null);
		CustomerBean.setFirstname(null);
		CustomerBean.setLastname(null);
		CustomerBean.setID(-1);
		CustomerBean.setLoginAttempts(0);
	}
	response.sendRedirect("login.jsp");
%>