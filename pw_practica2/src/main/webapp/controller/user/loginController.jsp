<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.uco.pw.p2.business.UserDTO,es.uco.pw.p2.data.UserDAO" %>
<jsp:useBean id="CustomerBean" scope="session" class="es.uco.pw.p2.display.CustomerBean"></jsp:useBean>
<%
	if (CustomerBean.getLoginAttempts() >= 3) {
		response.sendRedirect("http://www.uco.es/");
	}
	else{
		Usuario user = new Usuario(request.getServletContext());
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MySQLDAOManager gestor = new MySQLDAOManager();
		Usuario user = gestor.getUsuarios().obtener(email);
		
		boolean loginSuccessful = false;
		if (user != null && user.getPassword().equals(password)){
			loginSuccessful = true;
		}
		
		if (!loginSuccessful && CustomerBean.getLoginAttempts() >= 2) {
			CustomerBean.setLoginAttempts(CustomerBean.getLoginAttempts() + 1);
			response.sendRedirect("http://www.uco.es/");
		}
		else {
			if (loginSuccessful) {
				CustomerBean.setID(user.getID());
				CustomerBean.setEmail(user.getEmail());
				CustomerBean.setFirstname(user.getFirstname());
				CustomerBean.setLastname(user.getLastname());
				response.sendRedirect("/P2_MVC/mvc/view/loginView.jsp");
			}
			else {
				CustomerBean.setLoginAttempts(CustomerBean.getLoginAttempts() + 1); %>
				<jsp:forward page="/mvc/view/loginView.jsp">
					<jsp:param value="Login incorrecto" name="msg"/>
				</jsp:forward>
		<%  }
		}
	}
%>