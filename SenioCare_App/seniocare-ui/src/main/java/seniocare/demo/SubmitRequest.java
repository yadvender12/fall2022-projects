package seniocare.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

/**
 * Servlet implementation class SubmitRequest
 */
@WebServlet("/SubmitRequest")
public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequest() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String formCategory=(String) request.getParameter("FormCategory");
		System.out.println(formCategory);
		String formSubCategory=(String) request.getParameter("FormSubCategory");
		String comments=(String) request.getParameter("Comments");
		int clientId=Integer.parseInt(request.getParameter("client"));
		System.out.println(clientId);
		int empId=0,maxReqId=0,categoryId=0,subCategoryId=0;
		try {
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	ResultSet rs;
    	statement = conn.prepareStatement(Queries.selectEmpForRequest); 
		statement.setBoolean(1, true);
		statement.setBoolean(2, false);
    	statement.setString(3, formCategory);
        rs = statement.executeQuery();
        if(rs.next()) 
        	empId=rs.getInt(1);
        statement = conn.prepareStatement(Queries.maxReqId); 
        rs = statement.executeQuery();
        if(rs.next())
        	maxReqId=rs.getInt(1);
        statement = conn.prepareStatement(Queries.getIdFromCategory); 
        statement.setString(1, formCategory);
        rs = statement.executeQuery();
        if(rs.next())
        	categoryId=rs.getInt(1);
        statement = conn.prepareStatement(Queries.getIdFromSubCategory);
        statement.setString(1, formSubCategory);
        rs = statement.executeQuery();
        if(rs.next())
        	subCategoryId=rs.getInt(1);
        rs = statement.executeQuery();
        setRequestAssigned(empId, conn, statement, rs);
        statement = conn.prepareStatement(Queries.insertIntoRequest); 
		statement.setInt(1, maxReqId+1);
		statement.setInt(2, clientId);
		statement.setInt(3, empId);
		statement.setObject(4, new Timestamp(new Date().getTime()));
		statement.setObject(5,  LocalDate.parse("2099-12-31"));
		statement.setInt(6, categoryId);
		statement.setInt(7, subCategoryId);
		statement.setString(8, comments);
		statement.setString(9, "Unresolved");
		if(empId==0)
			request.getRequestDispatcher("NoEmployees.jsp").forward(request, response);
		else {
			statement.executeUpdate();
			request.getRequestDispatcher("DisplayRequestsForClients.jsp").forward(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setRequestAssigned(int empId, Connection conn, PreparedStatement statement, ResultSet rs) throws SQLException {
		statement = conn.prepareStatement(Queries.setRequestAssigned); 
    	statement.setBoolean(1, true);
    	statement.setInt(2,empId);
        statement.executeUpdate();
	}

}
