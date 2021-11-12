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

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//RequestDispatcher disparador = null;
        HttpSession session = request.getSession();
        UserBean jugador = (UserBean) request.getSession().getAttribute("JugadorBean");
        
        	try{
             Class.forName("com.mysql.jdbc.Driver");
             MySQLDAOManager daoManager = new MySQLDAOManager("ggather.zapto.org", "java", "1234", "aplicacion");
       
             String nextPage = "/View/register.jsp";
             String usuario = request.getParameter("usuario");
             String nombre = request.getParameter("nombre");
             String apellidos = request.getParameter("apellidos");
             String fecha =  request.getParameter("fechanacimiento");
             int telefono = Integer.parseInt(request.getParameter("telefono"));
             String email = request.getParameter("email");
             String password = request.getParameter("pass");
             
  
             Usuario usuarioAux = new Usuario( usuario,  nombre,  apellidos,  email, password);

             
             daoManager.getUsuarios().insertar(usuarioAux);
             session.setAttribute("jugador", usuarioAux);
             
             nextPage = "/View/Principal.jsp";
             
            // disparador = request.getRequestDispatcher(nextPage);
            // disparador.include(request, response);
             
        }catch(Exception e){
            
        }
        
        //disparador.forward(request, response);
        response.sendRedirect("/IW_/View/Principal.jsp");

             
       
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
	
	
