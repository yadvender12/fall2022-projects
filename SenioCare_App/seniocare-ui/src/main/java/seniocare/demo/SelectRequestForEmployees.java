package seniocare.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seniocare.SQL.Queries;
import seniocare.SQL.SQLConnect;

public class SelectRequestForEmployees {

	public static List<Request> selectforEmployees(int empId) throws ClassNotFoundException, SQLException {
		List<Request> retList = new ArrayList<>();
		Class.forName("org.postgresql.Driver");
		Connection conn = SQLConnect.connect();
		PreparedStatement statement;
		ResultSet rs;	
		statement = conn.prepareStatement(Queries.selReqForEmp);
		statement.setInt(1, empId);
		rs = statement.executeQuery();
		while (rs.next()) {
			Request req = new Request();
			req.setId(rs.getInt(1));
			req.setFirstName(rs.getString(2));
			req.setLastName(rs.getString(3));
			req.setPhone(rs.getString(4));
			req.setEmail(rs.getString(5));
			req.setType(rs.getString(6));
			req.setComments(rs.getString(7));
			retList.add(req);
		}
		return retList;
	}

}
