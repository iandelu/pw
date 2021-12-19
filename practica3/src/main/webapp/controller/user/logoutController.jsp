<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="UserBean" scope="session" class="view.UserBean"></jsp:useBean>
<%@ page import="model.data.Usuario,model.daos.MySQLDAOManager" %>
<%
	if (UserBean.getEmail() != null) {
		UserBean.setEmail(null);
		UserBean.setFirstname(null);
		UserBean.setLastname(null);
		UserBean.setID((long)-1);
		UserBean.setLoginAttempts(0);
	}
	response.sendRedirect("login.jsp");
%>