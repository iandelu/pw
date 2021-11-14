<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="UserBean" scope="session" class="display.UserBean"></jsp:useBean>
<%@ page import="model.data.Usuario,model.daos.MySQLDAOManager" %>
<%
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	MySQLDAOManager gestor = new MySQLDAOManager();
	Usuario user = gestor.getUsuarios().obtener(email);
	
	if (firstname == null || lastname == null || password == null || email == null || firstname == "" || lastname == "" || password == "" || email == ""){
		response.sendRedirect("errorPage.jsp?msg=Uno o mas campos estaban incompletos");
	}
	else{
		
		if (UserBean.getEmail() != null) {
			try{

				Usuario userNuevo = new Usuario(id, CustomerBean.getEmail(), password, firstname, lastname);
				gestor.getUsuarios().modificar(user);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("view/home.jsp");
	}
%>