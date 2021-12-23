package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.daos.MySQLDAOManager;
import model.data.Usuario;
import view.UserBean;

public class LoginController {

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        UserBean usuarioBean = (UserBean) session.getAttribute("jugadorBean");
        	
        	try{
                Class.forName("com.mysql.jdbc.Driver");
                MySQLDAOManager daoManager = new MySQLDAOManager("ggather.zapto.org", "java", "1234", "aplicacion");
                String email = request.getParameter("email");
                String password = request.getParameter("pass");
               
                Usuario myUser = daoManager.getUsuarios().obtener(email);
                
                
                if(myUser != null && myUser.getPassword().equals(password)) {
                	
                	session.setAttribute("Usuario", myUser);
                	response.sendRedirect("/home.jsp");
                	
                }
                else if(myUser == null || !myUser.getPassword().equals(password)){
                	response.sendRedirect("/login.jsp");
                }

        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
