<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="UserBean" scope="session" class="view.UserBean"></jsp:useBean>
<%@ page import="model.data.Usuario,model.daos.MySQLDAOManager" %>
<%
	if (UserBean.getLoginAttempts() >= 3) {
		response.sendRedirect("http://www.uco.es/");
	}
	else{
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MySQLDAOManager gestor = new MySQLDAOManager("jdbc:mysql://oraclepr.uco.es:3306", "i9lupua", "pwuco2021", "i92lupua");
		Usuario user = gestor.getUsuarios().obtener(email);
		
		boolean loginSuccessful = false;
		if (user != null && user.getPassword().equals(password)){
			loginSuccessful = true;
		}
		
		if (!loginSuccessful && UserBean.getLoginAttempts() >= 2) {
			UserBean.setLoginAttempts(UserBean.getLoginAttempts() + 1);
			response.sendRedirect("http://www.uco.es/");
		}
		else {
			if (loginSuccessful) {
				UserBean.setEmail(user.getEmail());
				UserBean.setFirstname(user.getNombre());
				UserBean.setLastname(user.getApellidos());
				response.sendRedirect("/P2_MVC/mvc/view/loginView.jsp");
			}
			else {
				UserBean.setLoginAttempts(UserBean.getLoginAttempts() + 1); %>
				<jsp:forward page="/mvc/view/loginView.jsp">
					<jsp:param value="Login incorrecto" name="msg"/>
				</jsp:forward>
		<%  }
		}
	}
%>