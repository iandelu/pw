<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="UserBean" scope="session" class="display.UserBean,model.data.Usuario"></jsp:useBean>
<%
	if (UserBean.getLoginAttempts() >= 3) {
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
		
		if (!loginSuccessful && UserBean.getLoginAttempts() >= 2) {
			UserBean.setLoginAttempts(UserBean.getLoginAttempts() + 1);
			response.sendRedirect("http://www.uco.es/");
		}
		else {
			if (loginSuccessful) {
				UserBean.setID(user.getID());
				UserBean.setEmail(user.getEmail());
				UserBean.setFirstname(user.getFirstname());
				UserBean.setLastname(user.getLastname());
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