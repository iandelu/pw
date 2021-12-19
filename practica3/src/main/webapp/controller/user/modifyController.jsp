<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="UserBean" scope="session" class="view.UserBean"></jsp:useBean>
<%@ page import="model.data.Usuario,model.daos.MySQLDAOManager" %>
<%
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String nickname = request.getParameter("nickname");
	MySQLDAOManager gestor = new MySQLDAOManager();
	Usuario user = gestor.getUsuarios().obtener(email);
	
	if (firstname == null || lastname == null || password == null || email == null || firstname == "" || lastname == "" || password == "" || email == ""){
		response.sendRedirect("errorPage.jsp?msg=Uno o mas campos estaban incompletos");
	}
	else{
		
		if (UserBean.getEmail() != null) {
			try{
				Long id = user.getIdUsuario();
				Usuario userNuevo = new Usuario(firstname,lastname, UserBean.getEmail(), nickname, password);
				gestor.getUsuarios().modificar(user);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("view/home.jsp");
	}
%>