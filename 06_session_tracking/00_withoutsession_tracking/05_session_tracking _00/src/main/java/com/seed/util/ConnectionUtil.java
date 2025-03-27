package com.seed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	public static Connection getConnection(String drivername, String url, String username, String password) {

		if(connection != null) {
			return connection;
		}
		
		System.out.println("create Connection Object");
		System.out.println("\tstep 1: Load the driver..");
		try {
			Class.forName(drivername); // load the driver
			System.out.println("\t\tmysql driver loaded!!!!");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("\t\t connection object creatred." + connection.getClass());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
