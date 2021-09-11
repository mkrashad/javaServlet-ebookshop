package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class DBConnection {
    public static Connection getDBConnection() {
    	try {
			String url = "jdbc:mysql://localhost:3306/ebookshop?serverTimezone=" + TimeZone.getDefault().getID();
			String username = "root";
			String password = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			return DriverManager.getConnection(url, username, password);
		} catch(Exception ex) {
			System.out.println("Connection FAILED");
		}
    	return null;
    }
}
