package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class ResolveRequest {
	
	public static void resolveRequest(int reqId, int empId) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	statement = conn.prepareStatement(Queries.updateResolveRequest); 
    	statement.setObject(1, new Timestamp(new Date().getTime()));
		statement.setString(2, "Resolved");
		statement.setInt(3, reqId);
        statement.executeUpdate();
        statement = conn.prepareStatement(Queries.updateEmployeeResolveRequest); 
        statement.setBoolean(1, false);
        statement.setInt(2, empId);
        statement.executeUpdate();
        
	}

}
