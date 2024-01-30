package utils;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "sqlpassword@123";

        // JDBC objects
        Statement statement = null;
        ResultSet resultSet = null;

            // Establish the database connection
        	Connection connection;
			try {
				connection = DriverManager.getConnection(url, username, password);
				if(connection.isClosed()) {
					System.out.println("False");
	            	
            	}
				else{
					System.out.println("true");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
            
            
        
    }

}
