package seniocare.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnect {
	private static final String url = "jdbc:postgresql://localhost:5432/SenioCare_DB";
	private static final String user = "postgres";
	private static final String password = "Bhaloo04091996!";
	public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
