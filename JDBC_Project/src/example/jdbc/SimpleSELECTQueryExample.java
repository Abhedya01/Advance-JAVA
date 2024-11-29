package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {
	//This program fires a simple SELECT query and shows the data loaded from database
	public static void main(String[] args) {
		// Load the Driver
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/zomato";
		String uid = "root";
		String pwd = "password";
		
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClassName);
			System.out.println("Driver loaded.");
			
			//Establish Connection
			dbConnection = DriverManager.getConnection(url, uid, pwd);
			System.out.println("Connected to DB");
			
			//Obtain some Statement
			 stmt = dbConnection.createStatement();
			System.out.println("Obtained the Statement");
			
			//Execute SQL Query
			String sqlQuery = 
			"select rest_name, rest_branch_count, rest_cuisine from restaurant_master";
			rs = stmt.executeQuery(sqlQuery);
			System.out.println("Executed SQL SELECT query and obtained ResultSet");
			
			//In case of SELECT query, obtain ResultSet and perform navigation
			while(rs.next()) {
				String restaurantName = rs.getString(1);
				int branchCount = rs.getInt(2);
				String restaurantCuisine = rs.getString(3);
				System.out.println(restaurantName + " : " + branchCount + " : " + restaurantCuisine);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to proceed.");
		}
		finally {
			//Closing all the resources: ResultSet, Statement, Connection
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		

	}

}
