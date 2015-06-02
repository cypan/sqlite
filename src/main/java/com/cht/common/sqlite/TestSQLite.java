package com.cht.common.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLite {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC"); // �إ�database���s�u
		Connection connection = null;

		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:d:\\ATM\\workspace\\sample.db"); // �n�[�W����r���u\�v
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			//statement.executeUpdate("drop table test01");
			statement
					.executeUpdate("create table test01 (id integer, name string)");
			statement.executeUpdate("insert into test01 values (1,'�i�T')");
			statement.executeUpdate("insert into test01 values (2,'���|')");

			ResultSet rs = statement.executeQuery("select * from test01");
			while (rs.next()) // �v��Ū��ResultSet�����
			{
				System.out.println("�m�W = " + rs.getString("name"));
				System.out.println("�s�� = " + rs.getInt("id"));
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
