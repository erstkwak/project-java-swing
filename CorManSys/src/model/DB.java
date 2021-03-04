package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url    = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String id     = "exam01";
	private static final String pw     = "1234";
	
	private static Connection conn = null;
	
	public static Connection connDB() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		}
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e)           {e.printStackTrace();}
		return conn;
	}
	
	public static void discDB(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs    != null) rs   .close();
			if (pstmt != null) pstmt.close();
			if (conn  != null) conn .close();
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
	
}