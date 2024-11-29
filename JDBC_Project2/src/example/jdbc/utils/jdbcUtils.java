package example.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils {
public static Connection getConnection() throws SQLException {
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String uid = "root";
	String pwd = "Rohit@1710";
	Connection dbConnection = 
			DriverManager.getConnection(url, uid, pwd);
	return dbConnection;
}
}
