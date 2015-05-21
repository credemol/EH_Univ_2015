package kr.ac.ewha.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private static final String JDBC_URL = "jdbc:derby://localhost:1527/seconddb;create=true";
	
	private DBConnectionManager() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static DBConnectionManager getInstance() {
		return Holder.instance;
	}
	
	public Connection getConnection(String jdbcUrl) throws SQLException {
		return DriverManager.getConnection(jdbcUrl);
	}
	
	public static Connection getConnection() throws SQLException {
		return Holder.instance.getConnection(JDBC_URL);
	}
	
	private static class Holder {
		static DBConnectionManager instance = new DBConnectionManager();
	}
}
