package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.daos.MySQLDAOManager;
import model.data.*;
import view.UserBean;

@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		MySQLDAOManager man = new MySQLDAOManager("oraclepr.uco.es:3306", "i92lupua", "pwuco2021", "i92lupua");
		ServletContext context = getServletContext();
		if (userBean != null) {
			if (userBean.getEmail() != null) {
				Usuario user = man.getUsuarios().obtener(userBean.getEmail());
				
				ArrayList<Espectaculo> board = man.getEspectaculos().obtenerTodos()
				
				request.setAttribute("todosEspectaculos", board);
				RequestDispatcher rd = request.getRequestDispatcher("/MVC/View/board.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath());
			}
		}
		else {
			response.sendRedirect(request.getContextPath());
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