package com.cht.common.sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTemplate {

	private static SQLiteTemplate instance = null;
	
	Connection conn = null;
	
	public static SQLiteTemplate getInstance (Connection conn) {
		if (instance == null) {
            instance = new SQLiteTemplate();
            instance.setConnection(conn);
        }
        return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
		
	}
	
	public void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public void executeDDL(String ddl) throws SQLException {
        Statement stat = null;
        stat = conn.createStatement();
        stat.executeUpdate(ddl);
    }
	
	public void executeUpdate(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
	}
	
	public ResultSet executeQuery(String sql) throws SQLException {
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(30);
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
    
}
