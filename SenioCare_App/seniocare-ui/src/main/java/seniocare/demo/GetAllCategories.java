package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class GetAllCategories {
	public static List<String> getAllCategories() throws ClassNotFoundException, SQLException {
		List<String> categories=new ArrayList<>();
		Class.forName("org.postgresql.Driver");
    	Connection conn = SQLConnect.connect();
    	PreparedStatement statement;
    	ResultSet rs;
    	statement = conn.prepareStatement(Queries.getAllCategories); 
    	rs = statement.executeQuery();
    	while(rs.next()) {
    		categories.add(rs.getString(1));
    	}
    	return categories;
	}
}
