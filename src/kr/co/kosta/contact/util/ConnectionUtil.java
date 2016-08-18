package kr.co.kosta.contact.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection(String string) throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/kosta10", "root", "1234");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return conn;
	}

	public static void releaseConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
