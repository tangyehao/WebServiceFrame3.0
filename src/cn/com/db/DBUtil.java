package cn.com.db;

import cn.com.config.Load;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBUtil {
	private DBUtil() {
		
	}
	
	static {
		try {
			Class.forName(Load.getValue("DRV"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(Load.getValue("URL"), Load.getValue("USER"), Load.getValue("PWD"));
		return conn;
	}
	
	public static void freeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void freeStatement(Statement pstm) throws SQLException {
		if (pstm != null) {
			pstm.close();
		}
	}
	
	public static void freeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
