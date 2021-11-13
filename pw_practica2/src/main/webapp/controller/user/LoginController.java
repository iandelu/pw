package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UserBean;
import model.daos.MySQLDAOManager;
import model.data.Usuario;

public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public LoginController() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		HttpSession session  =request.getSession();
		UserBean usuarioBean = (UserBean) session.getAttribute("usuarioBean");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			MySQLDAOManager daoManager = new MySQLDAOManager("","","","");
			
			String nextPage = "/View/login.jsp";
			String email  =request.getParameter("email");
			String password  = request.getParameter("pass");
			
			Usuario usuarioAux  = daoManager.getUsuarios().obtener(email);
			
			if(usuarioAux != null && usuarioAux.getPassword().equals(password)) {
				
				session.setAttribute("usuario", usuarioAux);
				response.sendRedirect("webapp/Principal.jsp");
				
			}else if(usuarioAux == null || usuarioAux.getPassword().equals(password)) {
				
				response.sendRedirect("webapp/login.jsp");
				
			}
		
		}catch(Exception e) {
			
			System.out.println("error");
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
