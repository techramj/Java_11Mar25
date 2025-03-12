package com.seed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	static {
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hr";
		String username ="root";
		String password ="root1234";

		System.out.println("create Connection Object");
		System.out.println("\tstep 1: Load the driver..");
		try {
			Class.forName(driverClassName); // load the driver
			System.out.println("\t\tmysql driver loaded!!!!");
			
			connection= DriverManager.getConnection(url, username, password);
			System.out.println("\t\t connection object creatred."+connection.getClass());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
