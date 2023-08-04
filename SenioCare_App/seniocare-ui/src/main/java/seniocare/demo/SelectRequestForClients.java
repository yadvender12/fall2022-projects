package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class SelectRequestForClients {
	
	public static List<Request> selectforClients(int clientId) throws ClassNotFoundException, SQLException{
		List<Request> retList=new ArrayList<>();
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	ResultSet rs;
    	statement = conn.prepareStatement(Queries.selReqForClient); 
		statement.setInt(1, clientId);
		statement.setString(2, "Unresolved");
        rs = statement.executeQuery();
        while(rs.next()) {
        	Request req=new Request();
        	req.setFirstName(rs.getString(1));
        	req.setLastName(rs.getString(2));
        	req.setPhone(rs.getString(3));
        	req.setEmail(rs.getString(4));
        	req.setType(rs.getString(5));
        	retList.add(req);
        }
        return retList;
	}

}
