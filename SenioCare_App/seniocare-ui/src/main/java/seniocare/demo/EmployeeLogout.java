package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class EmployeeLogout {
	public static void employeeLogout(int empId) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	statement = conn.prepareStatement(Queries.updateEmployeeLogout); 
    	statement.setBoolean(1, false);
    	statement.setInt(2, empId);
    	statement.executeUpdate();
	}
}
