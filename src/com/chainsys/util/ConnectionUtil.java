package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// 1.load the class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.get the connection
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			connection = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to load the driver");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to get the connection");
		}
		return connection;
	}

	public static void close(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to close the connection");
		}
	}
}
