package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.*;
import model.daos.*;
//import es.uco.pw.p3.display.CustomerBean;
//import java.util.ArrayList;
import view.UserBean;




@WebServlet("/singupServlet")
public class SingupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/MVC/View/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		MySQLDAOManager man;
		try {
			man = new MySQLDAOManager("oraclepr.uco.es:3306", "i92lupua", "pwuco2021", "i92lupua");
		
		
		if (userBean != null) {
			
			if (userBean.getEmail() == null) {
				ServletContext context = getServletContext();
				String email = request.getParameter("email");
				String nickname = request.getParameter("usuario");
				String password = request.getParameter("pass");
				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidosque");
				
				try {
					if (man.getUsuarios().obtener(email) != null) {
						String errorMsg = "Un usuario con este email ya existe";
						request.setAttribute("errorMsg", errorMsg);
						RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");
						rd.forward(request, response);
					}
					else if (nombre == null || apellidos == null || email == null || password == null || nickname == null || nombre == "" || apellidos == "" || email == "" || password == "" || nickname == "") {
						String errorMsg = "Uno o más campos de registro estaban vacíos";
						request.setAttribute("errorMsg", errorMsg);
						RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");
						rd.forward(request, response);
					}
					else {
						
						Usuario user;
						try {
							user = new Usuario( nombre, apellidos, email, nickname,password);
							man.getUsuarios().insertar(user);
						} catch (DAOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String msg = "Registrado correctamente";
						request.setAttribute("msg", msg);
						RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/login.jsp");
						rd.forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				response.sendRedirect(request.getContextPath());
			}
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	}
}