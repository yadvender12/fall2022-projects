package seniocare.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

/**
 * Servlet implementation class InitialLogin
 */
@WebServlet("/InitialLogin")
public class InitialLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "deprecation", "unchecked" }) 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name="";
		int clientId=0;
		int empId=0;
		int id=Integer.parseInt(request.getParameter("Id"));
		try {
        	Class.forName("org.postgresql.Driver");
        	Connection conn = SQLConnect.connect();
        	PreparedStatement statement;
        	ResultSet rs;
        	statement = conn.prepareStatement(Queries.getPersonFromPerson); 
        	statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()) 
             name=rs.getString(1)+" "+rs.getString(2);
        	request.setAttribute("Name", name);
            statement = conn.prepareStatement(Queries.getIdFromClient); 
        	statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()) {
            	clientId=rs.getInt(1);
            	request.setAttribute("clientId", clientId);
    			request.getRequestDispatcher("/Client.jsp").forward(request, response);
            }
            statement = conn.prepareStatement(Queries.getIdFromEmployee); 
        	statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()) {
            	empId=rs.getInt(1);
            	setEmployeeActive(empId, conn, statement,rs);
            	request.setAttribute("empId", empId);
    			request.getRequestDispatcher("/Employee.jsp").forward(request, response);
            }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		doGet(request, response); 
	}
	public void setEmployeeActive(int empId, Connection conn, PreparedStatement statement, ResultSet rs) throws SQLException {
		statement = conn.prepareStatement(Queries.setEmployeeActive); 
    	statement.setBoolean(1, true);
    	statement.setInt(2,empId);
        statement.executeUpdate();
	}

}
