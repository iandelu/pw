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

import model.daos.MySQLDAOManager;
import model.data.Espectaculo;
import view.UserBean;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		MySQLDAOManager man;
		try {
			man = new MySQLDAOManager("oraclepr.uco.es:3306", "i92lupua", "pwuco2021", "i92lupua");
		
		if (userBean != null) {
			if (userBean.getEmail() != null) {
				ServletContext context = getServletContext();
				String searchType = request.getParameter("type");
				if (searchType == null) {
					response.sendRedirect(request.getContextPath() + "/MVC/View/search.jsp");
				}
				else if (searchType.equals("title")) {
					String titleQuery = request.getParameter("titleQuery");
					if (titleQuery == null || titleQuery.equals("")) {
						String errorMsg = "Introduzca un título";
						request.setAttribute("errorMsg", errorMsg);
						RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/search.jsp");
						rd.forward(request, response);
					}
					else {
						ArrayList<Espectaculo> EspectaculoSearch = man.getEspectaculos().obtenerTodos();
						//filtro en dao
						request.setAttribute("espectaculoSearch", EspectaculoSearch);
						request.setAttribute("titleQuery", titleQuery);
						RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/searchResult.jsp");
						rd.forward(request, response);
					}
				}
				else if (searchType.equals("dateRange")){
					String categoria = request.getParameter("startDate");
					if (categoria != null) {
						//filtro en dao
						ArrayList<Espectaculo> EspectaculoSearch = man.getEspectaculos().obtenerTodos();
						request.setAttribute("espectaculoSearch", EspectaculoSearch);
						request.setAttribute("categoria", categoria);
						RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/searchResult.jsp");
						rd.forward(request, response);
					}
					else {
						String errorMsg = "Especifique una categoria";
						request.setAttribute("errorMsg", errorMsg);
						RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/search.jsp");
						rd.forward(request, response);
					}
				}
				else {
					response.sendRedirect(request.getContextPath() + "/MVC/View/search.jsp");
				}
			}
			else {
				response.sendRedirect(request.getContextPath());
			}
		}
		else {
			response.sendRedirect(request.getContextPath());
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}