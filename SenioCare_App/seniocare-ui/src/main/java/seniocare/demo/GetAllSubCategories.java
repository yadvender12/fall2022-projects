package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class GetAllSubCategories {
	public static List<String> getAllSubcategories() throws ClassNotFoundException, SQLException {
		List<String> sub=new ArrayList<>();
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	ResultSet rs;
    	statement = conn.prepareStatement(Queries.getParticularSubCategories); 
    	rs = statement.executeQuery();
    	while(rs.next()) {
    		sub.add(rs.getString(1));
    	}
    	return sub;
	}
}
