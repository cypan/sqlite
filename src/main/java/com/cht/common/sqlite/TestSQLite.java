package com.cht.common.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQLite {

	public static void main(String[] args) {

		SQLiteTemplate sqliteTemplate = null;
		
		try {
			sqliteTemplate = SQLiteTemplate.getInstance(SQLiteDataSource.getConnection());
			
			//sqliteTemplate.executeDDL("drop table test01");
			
			//sqliteTemplate.executeUpdate("create table atm_member (id integer, name string)");
			//sqliteTemplate.executeUpdate("insert into atm_member values (1,'cypan')");
			//sqliteTemplate.executeUpdate("insert into atm_member values (2,'frank_yen')");
			//sqliteTemplate.executeUpdate("insert into atm_member values (3,'oscar_wang')");
			//sqliteTemplate.executeUpdate("insert into atm_member values (4,'hank_liu')");
			
			ResultSet rs = sqliteTemplate.executeQuery("select * from atm_member");
			while (rs.next()) 
			{
				System.out.println("id = " + rs.getInt("id") + ", " + "name = " + rs.getString("name"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			sqliteTemplate.closeConnection();
		}

	}

}
