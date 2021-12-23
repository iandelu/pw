package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.daos.DAOException;
import model.daos.MySQLDAOManager;
import model.data.Espectaculo;


@WebServlet("/tablonAnuncios")
public class TablonEspectaculosController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			MySQLDAOManager man = new MySQLDAOManager("ggather.zapto.org", "java", "1234", "aplicacion");
			
			String id = (String) request.getParameter("partido");
			Long Id = Long.parseLong(id);
			
			ArrayList<Espectaculo> espectaculos = man.getEspectaculos().obtenerTodos();
			
			
			session.setAttribute("espectaculos", espectaculos);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/tablonEspectaculos.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
