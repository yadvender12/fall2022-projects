package seniocare.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/Site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifier = request.getParameter("page");
		if (null == identifier)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else {
			if (identifier.equals("NewRequest")) {
				try {
					request.setAttribute("client", request.getParameter("client"));
					request.setAttribute("CategoryList", GetAllCategories.getAllCategories());
					request.setAttribute("SubCategoryList", GetAllSubCategories.getAllSubcategories());
					request.getRequestDispatcher("/FormForRequest.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (identifier.equals("RequestforClients")) {
				List<Request> selForCl = null;
				try {
					selForCl = SelectRequestForClients
							.selectforClients(Integer.parseInt(request.getParameter("client")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("ReqForCl", selForCl);
				request.getRequestDispatcher("DisplayRequestsForClients.jsp").forward(request, response);
			}
			if (identifier.equals("RequestforEmployees")) {
				List<Request> selForEmp = null;
				try {
					System.out.println(Integer.parseInt(request.getParameter("employee")));
					selForEmp = SelectRequestForEmployees
							.selectforEmployees(Integer.parseInt(request.getParameter("employee")));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("ReqForEmp", selForEmp);
				request.getRequestDispatcher("DisplayRequestsForEmps.jsp").forward(request, response);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifier = request.getParameter("page");
		if (identifier.equals("ResolveRequest")) {
			try {
				ResolveRequest.resolveRequest(Integer.parseInt(request.getParameter("req")),
						Integer.parseInt(request.getParameter("employee")));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("DisplayRequestsForEmps.jsp").forward(request, response);
		}
		else if(identifier.equals("Logout")) {
			try {
				EmployeeLogout.employeeLogout(Integer.parseInt(request.getParameter("employee")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
