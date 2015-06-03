package com.cht.common.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource {

	private static Connection connection = null;
	
	public static Connection getConnection(){
		
        try {
            if(null != connection && !connection.isClosed()){
                return connection;
            }else{
                try {
                    Class.forName("org.sqlite.JDBC");
                    connection = DriverManager.getConnection("jdbc:sqlite::resource:sample.db");
                    return connection;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
