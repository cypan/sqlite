package com.cht.common.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLite {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC"); // 建立database的連線
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:d:\\ATM\\workspace\\sample.db"); // 要加上跳脫字元「\」
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			//statement.executeUpdate("drop table test01");
			statement
					.executeUpdate("create table test01 (id integer, name string)");
			statement.executeUpdate("insert into test01 values (1,'張三')");
			statement.executeUpdate("insert into test01 values (2,'李四')");

			ResultSet rs = statement.executeQuery("select * from test01");
			while (rs.next()) // 逐筆讀取ResultSet的資料
			{
				System.out.println("姓名 = " + rs.getString("name"));
				System.out.println("編號 = " + rs.getInt("id"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e); // connection close failed.
			}
		}

	}

}
